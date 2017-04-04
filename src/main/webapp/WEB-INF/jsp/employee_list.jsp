<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="employeeList" title="员工列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'employee/list',
       	method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_employee">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'empId',align:'center',width:100">员工编号</th>
            <th data-options="field:'empName',align:'center',width:100">员工姓名</th>
            <th data-options="field:'sex',align:'center',width:100,formatter:TAOTAO.formatSex">性别</th>
            <th data-options="field:'department',align:'center',width:100,formatter:formatDepartment">所属部门</th>
            <th data-options="field:'idCode',align:'center',width:150">身份证号</th>
            <th data-options="field:'education',align:'center',width:100">学历</th>
            <th data-options="field:'degree',align:'center',width:100">学位</th>
            <th data-options="field:'major',align:'center',width:100">专业</th>
            <th data-options="field:'educationForm',align:'center',width:100">受教育形式</th>
            <th data-options="field:'birthday',width:130,align:'center',formatter:TAOTAO.formatDate">生日</th>
            <th data-options="field:'joinDate',width:130,align:'center',formatter:TAOTAO.formatDate">入职日期</th>
            <th data-options="field:'status',width:100,align:'center'">员工状态</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_employee" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='employee:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="employee_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='employee:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="employee_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='employee:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="employee_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="employee_reload()">刷新</a>  
	</div>  
	
    <div id="search_employee" style="float: right;">
        <input id="search_text_employee" class="easyui-searchbox"  
            data-options="searcher:doSearch_employee,prompt:'请输入...',menu:'#menu_employee'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_employee" style="width:120px"> 
			<div data-options="name:'employeeId'">员工编号</div> 
			<div data-options="name:'employeeName'">员工名称</div>
			<div data-options="name:'departmentName'">部门名称</div> 
		</div>     
    </div>  

</div>  

<div id="employeeEditWindow" class="easyui-window" title="编辑员工" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'employee/edit'" style="width:40%;height:70%;padding:10px;">
</div>
<div id="employeeAddWindow" class="easyui-window" title="添加员工" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'employee/add'" style="width:40%;height:70%;padding:10px;">
</div>

<div id="empDepartmentInfo" class="easyui-dialog" title="部门信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save'" style="width:65%;height:65%;padding:10px;">
	<form id="empDepartmentEditForm" method="post">
		<input type="hidden" name="departmentId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>部门名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="departmentName" data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>部门职责:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEmpDepartmentEditForm()">提交</a>
	</div>
</div>
<script>
function doSearch_employee(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#employeeList").datagrid({
	        title:'员工列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_employee", url:'employee/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'empId', width : 100, align:'center', title : '员工编号'},
				{field : 'empName', width : 100, align : 'center', title : '员工姓名'},
				{field : 'sex', width : 100, align : 'center', title : '性别', formatter:TAOTAO.formatSex},
				{field : 'department', width : 100, title : '所属部门', align:'center',formatter:formatDepartment},
				{field : 'idCode', width : 150, title : '身份证号', align:'center'},
				{field : 'education', width : 100, title : '学历', align:'center'},
				{field : 'degree', width : 100, title : '学位', align:'center'},
				{field : 'major', width : 100, title : '专业', align:'center'},
				{field : 'educationForm', width : 100, title : '受教育形式', align:'center'},
				{field : 'birthday', width : 130, title : '生日', align:'center', formatter:TAOTAO.formatDate},
				{field : 'joinDate', width : 130, title : '入职日期', align:'center', formatter:TAOTAO.formatDate},
				{field : 'status',  width : 100, title : '员工状态', align:'center'}
	        ] ],  
	    });
	}else{
		$("#employeeList").datagrid({  
	        title:'员工列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_employee", url:'employee/search_employee_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'empId', width : 100, align:'center', title : '员工编号'},
				{field : 'empName', width : 100, align : 'center', title : '员工姓名'},
				{field : 'sex', width : 100, align : 'center', title : '性别', formatter:TAOTAO.formatSex},
				{field : 'department', width : 100, title : '所属部门', align:'center',formatter:formatDepartment},
				{field : 'idCode', width : 150, title : '身份证号', align:'center'},
				{field : 'education', width : 100, title : '学历', align:'center'},
				{field : 'degree', width : 100, title : '学位', align:'center'},
				{field : 'major', width : 100, title : '专业', align:'center'},
				{field : 'educationForm', width : 100, title : '受教育形式', align:'center'},
				{field : 'birthday', width : 130, title : '生日', align:'center', formatter:TAOTAO.formatDate},
				{field : 'joinDate', width : 130, title : '入职日期', align:'center', formatter:TAOTAO.formatDate},
				{field : 'status',  width : 100, title : '员工状态', align:'center'}
	        ] ],  
	    });
	}
}

var empDepartmentEditor;
	//格式化部门信息
	function  formatDepartment(value, row, index){ 
		return "<a href=javascript:openDepartment("+index+")>"+row.department.departmentName+"</a>";
	};
	
	//根据index拿到该行值
	function onEmployeeClickRow(index) {
		var rows = $('#employeeList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开部门信息对话框
	function  openDepartment(index){ 
		var row = onEmployeeClickRow(index);
		$("#empDepartmentInfo").dialog({
			onOpen :function(){
				$.get("department/get/"+row.department.departmentId,'',function(data){
					empDepartmentEditor = TAOTAO.createEditor("#empDepartmentEditForm [name=note]");	
		    		//回显数据
		    		$("#empDepartmentEditForm").form("load", data);
		    		empDepartmentEditor.html(data.note);
		    	});
			},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#empDepartmentEditForm [name=note]");
			}
		}).dialog("open");
	};
	
	function submitEmpDepartmentEditForm(){
		$.get("department/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#empDepartmentEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			empDepartmentEditor.sync();
    			
    			$.post("department/update_all",$("#empDepartmentEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改部门成功!','info',function(){
    						$("#empDepartmentInfo").dialog("close");
    						$("#employeeList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	
    function getEmployeeSelectionsIds(){
    	var employeeList = $("#employeeList");
    	var sels = employeeList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].empId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function employee_add(){
    	$.get("employee/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#employeeAddWindow").window("open");
       		}
       	});
    }
    
    function employee_edit(){
    	$.get("employee/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getEmployeeSelectionsIds();
            	
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个员工才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个员工!');
            		return ;
            	}
            	
            	$("#employeeEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#employeeList").datagrid("getSelections")[0];
            			data.departmentId = data.department.departmentId; 
            			data.birthday = TAOTAO.formatDate(data.birthday);
            			data.joinDate = TAOTAO.formatDate(data.joinDate);
            			$("#employeeEditForm").form("load", data);
            			
            		}
            	}).window("open");
       		}
       	});
    }
    
    function employee_delete(){
    	$.get("employee/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getEmployeeSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中员工!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除ID为 '+ids+' 的员工吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("employee/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除员工成功!',undefined,function(){
                					$("#employeeList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function employee_reload(){
    	$("#employeeList").datagrid("reload");
    }
</script>