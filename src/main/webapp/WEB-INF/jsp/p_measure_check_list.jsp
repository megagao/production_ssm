<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table  id="pMeasureCheckList" title="工序计量质检" class="easyui-datagrid" data-options="singleSelect:false,
		collapsible:true,pagination:true,rownumbers:true,url:'p_measure_check/list',method:'get',pageSize:10,
		fitColumns:true,toolbar:toolbar_pMeasureCheck">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'pMeasureCheckId',align:'center',width:100">
				工序计量质检编号
			</th>
            <th data-options="field:'processId',align:'center',width:100,formatter:formatPMeasureCheckProcess">
				工序编号
			</th>
            <th data-options="field:'checkItem',align:'center',width:100">
				检验项目
			</th>
            <th data-options="field:'cdate',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				检验时间
			</th>
            <th data-options="field:'measureData',width:100,align:'center'">
				实际测量数据
			</th>
            <th data-options="field:'empName',width:100,align:'center',formatter:formatEmp_pMeasure">
				检验人
			</th>
            <th data-options="field:'result',width:130,align:'center'">
				检验结果
			</th>
            <th data-options="field:'note',width:100,align:'center', formatter:formatPMeasureCheckNote">
				备注
			</th>
            
        </tr>
    </thead>
</table>
<!-- 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div  id="toolbar_pMeasureCheck" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='pMeasureCheck:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="pMeasureCheck_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='pMeasureCheck:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="pMeasureCheck_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='pMeasureCheck:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="pMeasureCheck_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="pMeasureCheck_reload()">
			刷新
		</a>
	</div>  
	
    <div id="search_pMeasureCheck" style="float: right;">
        <input id="search_text_pMeasureCheck" class="easyui-searchbox"  
            data-options="searcher:doSearch_pMeasureCheck,prompt:'请输入...',menu:'#menu_pMeasureCheck'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_pMeasureCheck" style="width:120px"> 
			<div data-options="name:'pMeasureCheckId'">工序计量质检编号</div> 
		</div>     
    </div>  

</div>  
<!-- 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div id="pMeasureCheckEditWindow" class="easyui-window" title="编辑工序计量质检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'p_measure_check/edit'" style="width:65%;height:75%;padding:10px;">
</div>
<div id="pMeasureCheckAddWindow" class="easyui-window" title="添加工序计量质检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'p_measure_check/add'" style="width:65%;height:75%;padding:10px;">
</div>

<!-- ********************************************************************************** -->


<div id="p2pMeasureInfo" class="easyui-dialog" title="工序信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:35%;height:40%;padding:10px;">
	<form id="p2pEditForm" method="post">
		<input type="hidden" name="processId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>工艺计划编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="technologyPlanId" panelHeight="auto"
						   data-options="required:true,valueField:'technologyPlanId',textField:'technologyPlanId',
						   url:'technologyPlan/get_data',editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td>工序顺序:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="sequence"/>
    			</td>  
	        </tr>
	         <tr>
	            <td>单件定额工时:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="quota"/>
    			</td>  
	        </tr>
	       
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitP2PEditForm()">提交</a>
	</div>
</div>

<!-- 检验人信息 -->
<div id="empInfo_pMeasure" class="easyui-dialog" title="检验人信息" data-options="modal:true,closed:true,resizable:true,
		iconCls:'icon-save'" style="width:33%;height:65%;padding:10px;">
	<form id="empEditForm_pMeasure" method="post">
		<input type="hidden" name="empId"/>
	    <table cellpadding="5">
	        <tr>
	           	<td>姓名:</td>
	           	<td><input class="easyui-textbox" name="empName" data-options="editable:false"/></td>
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<select id="sexCombobox" class="easyui-combobox" name="sex" panelHeight="auto"
							data-options="editable:false" style="width:173px">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>所属部门:</td>
	            <td>
	            	<input class="easyui-combobox" name="departmentId" panelHeight="auto"
    					data-options="valueField:'departmentId',textField:'departmentName',url:'department/get_data'"/>
    			</td> 
	        </tr>
	        <tr>
	            <td>身份证号:</td>
	            <td><input class="easyui-textbox" name="idCode"/></td>
	        </tr>
	        <tr>
	            <td>学历:</td>
	            <td><input class="easyui-textbox" name="education"/></td>
	        </tr>
	        <tr>
	            <td>学位:</td>
	            <td><input class="easyui-textbox" name="degree"/></td>
	        </tr>
	        <tr>
	            <td>专业:</td>
	            <td><input class="easyui-textbox" name="major"/></td>
	        </tr>
	        <tr>
	            <td>受教育形式:</td>
	            <td><input class="easyui-textbox" name="educationForm"/></td>
	        </tr>
	        <tr>
	            <td>生日:</td>
	            <td><input class="easyui-datetimebox" name="birthday"/></td>
	        </tr>
	        <tr>
	            <td>入职日期:</td>
	            <td><input class="easyui-datetimebox" name="joinDate"/></td>
	        </tr>
	        <tr>
	            <td>员工状态:</td>
	            <td><input class="easyui-textbox" name="status"/></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEmpEditForm_pMeasure()">提交</a>
	</div>
</div>

<!-- ********************************************************************************** -->

<div id="pMeasureCheckNoteDialog" class="easyui-dialog" title="工序计量质检备注" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px">
	<form id="pMeasureCheckNoteForm" class="itemForm" method="post">
		<input type="hidden" name="pMeasureCheckId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:450px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updatePMeasureCheckNote()">保存</a>
	</div>
</div>
<script>
function doSearch_pMeasureCheck(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#pMeasureCheckList").datagrid({
	        title:'工序计量质检', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_pMeasureCheck", url:'p_measure_check/list', method:'get',
			loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'pMeasureCheckId', width : 100, title : '工序计量质检编号', align:'center'},
				{field : 'processId', width : 100, align : 'center', title : '工序编号'},
				{field : 'checkItem', width : 100, align : 'center', title : '检验项目'},
				{field : 'cdate', width : 130, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime},
				{field : 'measureData', width : 100, title : '实际测量数据', align:'center'},
				{field : 'empName', width : 100, title : '检验人', align:'center',formatter:formatEmp_pMeasure},
				{field : 'result', width : 100, title : '检验结果', align:'center'},
				{field : 'note', width : 130, title : '备注', align:'center', formatter:formatPMeasureCheckNote}
	        ] ],  
	    });
	}else{
		$("#pMeasureCheckList").datagrid({  
	        title:'工序计量质检', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_pMeasureCheck", url:'p_measure_check/search_pMeasureCheck_by_'+name
				+'?searchValue='+value, loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'pMeasureCheckId', width : 100, title : '工序计量质检编号', align:'center'},
				{field : 'processId', width : 100, align : 'center', title : '工序编号'},
				{field : 'checkItem', width : 100, align : 'center', title : '检验项目'},
				{field : 'cdate', width : 130, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime},
				{field : 'measureData', width : 100, title : '实际测量数据', align:'center'},
				{field : 'empName', width : 100, title : '检验人', align:'center',formatter:formatEmp_pMeasure},
				{field : 'result', width : 100, title : '检验结果', align:'center'},
				{field : 'note', width : 130, title : '备注', align:'center', formatter:formatPMeasureCheckNote}
	        ] ],  
	    });
	}
}

	var pMeasureCheckNoteEditor;

	//格式化工序信息
	function  formatPMeasureCheckProcess(value, row, index){ 
		if(value == null){
			return '无';
		}
		else{
			return "<a href=javascript:openP2P("+index+")>"+value+"</a>";
		}
	};
	
	//打开产品信息对话框
	function  openP2P(index){ 
		var row = onP2PClickRow(index);
		$("#p2pMeasureInfo").dialog({
    		onOpen :function(){
    			$.get("process/get/"+row.processId,'',function(data){
		    		//回显数据
		    		$("#p2pEditForm").form("load", data);
    	    	});
    		},
    	}).dialog("open");
	};
	
	
	//根据index拿到该行值
	function onP2PClickRow(index) {
		var rows = $('#pMeasureCheckList').datagrid('getRows');
		return rows[index];
		
	}
	
	function submitP2PEditForm(){
		//此处写工序信息
		$.get("process/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#p2pEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//此处写工序信息
    			$.post("process/update_all",$("#p2pEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改产品成功!','info',function(){
    						$("#p2pMeasureInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	
	
	//格式化检验人信息
	function formatEmp_pMeasure(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openEmp_pMeasure("+index+")>"+value+"</a>";
		}else{
			return "无";
		}
	};
	
	//打开检验人信息对话框
	function  openEmp_pMeasure(index){ 
		var row = onPMeasureCheckClickRow(index);
		$("#empInfo_pMeasure").dialog({
    		onOpen :function(){
    			$.get("employee/get/"+row.empId,'',function(data){
		    		//回显数据
					data.birthday = TAOTAO.formatDateTime(data.birthday);
					data.joinDate = TAOTAO.formatDateTime(data.joinDate);
					data.departmentId=data.department.departmentId;
					data.departmentName=data.department.departmentName;
		    		$("#empInfo_pMeasure").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交检验人信息
	function submitEmpEditForm_pMeasure(){
		$.get("employee/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#empEditForm_pMeasure').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("employee/update_all",$("#empEditForm_pMeasure").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改检验人信息成功!','info',function(){
    						$("#empInfo_pMeasure").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误', data.msg);
    				}
    			});
    		}
    	});
	}
	
	//////////////////////////////////////////////////////////////////////////
	
	//格式化备注
	function formatPMeasureCheckNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openPMeasureCheckNote("+index+")>"+"备注"+"</a>";
		}else{
			return "无";
		}
	}

	//根据index拿到该行值
	function onPMeasureCheckClickRow(index) {
		var rows = $('#pMeasureCheckList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开工序计量质检要求富文本编辑器对话框
	function  openPMeasureCheckNote(index){ 
		var row = onPMeasureCheckClickRow(index);
		$("#pMeasureCheckNoteDialog").dialog({
    		onOpen :function(){
    			$("#pMeasureCheckNoteForm [name=pMeasureCheckId]").val(row.pMeasureCheckId);
    			pMeasureCheckNoteEditor = TAOTAO.createEditor("#pMeasureCheckNoteForm [name=note]");
    			pMeasureCheckNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#pMeasureCheckNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新备注
	function updatePMeasureCheckNote(){
		$.get("pMeasureCheck/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			pMeasureCheckNoteEditor.sync();
    			$.post("p_measure_check/update_note",$("#pMeasureCheckNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#pMeasureCheckNoteDialog").dialog("close");
    					$("#pMeasureCheckList").datagrid("reload");
    					$.messager.alert("操作提示", "更新备注成功！");
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	
    function getPMeasureSelectionsIds(){
    	var pMeasureCheckList = $("#pMeasureCheckList");
    	var sels = pMeasureCheckList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].pMeasureCheckId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    //////////////////////////////////////////////////////////////////////////
    
    function pMeasureCheck_add(){
    	$.get("pMeasureCheck/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#pMeasureCheckAddWindow").window("open");
       		}
       	});
    }
    
    function pMeasureCheck_edit(){
    	$.get("pMeasureCheck/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getPMeasureSelectionsIds();
            	
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个工序计量质检才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个工序计量质检!');
            		return ;
            	}
            	
            	$("#pMeasureCheckEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#pMeasureCheckList").datagrid("getSelections")[0];
            			 
            			data.cdate = TAOTAO.formatDateTime(data.cdate);
            			$("#pMeasureCheckEditForm").form("load", data);
            			pMeasureCheckEditEditor.html(data.note);
            		}
            	}).window("open");
       		}
       	});
    }
    
    function pMeasureCheck_delete(){
    	$.get("pMeasureCheck/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getPMeasureSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','未选中工序计量质检!');
               		return ;
               	}
               	$.messager.confirm('确认','确定删除ID为 '+ids+' 的工序计量质检吗？',function(r){
               	    if (r){
               	    	var params = {"ids":ids};
                       	$.post("p_measure_check/delete_batch",params, function(data){
                   			if(data.status == 200){
                   				$.messager.alert('提示','删除工序计量质检成功!',undefined,function(){
                   					$("#pMeasureCheckList").datagrid("reload");
                   				});
                   			}
                   		});
               	    }
               	});
       		}
       	});
    }
    
    function pMeasureCheck_reload(){
    	$("#pMeasureCheckList").datagrid("reload");
    }
</script>

