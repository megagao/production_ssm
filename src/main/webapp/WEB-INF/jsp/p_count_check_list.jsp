<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table  id="pCountCheckList" title="工序计数质检" class="easyui-datagrid" data-options="singleSelect:false,
		collapsible:true,pagination:true,rownumbers:true,url:'p_count_check/list',method:'get',fitColumns:true,
		pageSize:10,toolbar:toolbar_pCountCheck">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'pCountCheckId',align:'center',width:100">工序计数质检编号</th>
            <th data-options="field:'processId',align:'center',width:100,formatter:formatPCountCheckProcess">
				工序编号
			</th>
            <th data-options="field:'checkItem',align:'center',width:100">检验项目</th>
            <th data-options="field:'sample',align:'center',width:100">样本总数</th>
            <th data-options="field:'checkNumber',width:100,align:'center'">抽检数</th>
            <th data-options="field:'unqualify',width:100,align:'center'">不合格数</th>
            <th data-options="field:'qualify',width:100,align:'center'">合格率</th>
            <th data-options="field:'cdate',width:130,align:'center',formatter:TAOTAO.formatDateTime">检验时间</th>
            <th data-options="field:'measureData',width:100,align:'center'">实际测量数据</th>
            <th data-options="field:'empName',width:100,align:'center',formatter:formatEmp_pCount">检验人</th>
            <th data-options="field:'result',width:100,align:'center'">检验结果</th>
            <th data-options="field:'note',width:100,align:'center', formatter:formatPCountCheckNote">备注</th>
        </tr>
    </thead>
</table>

<!-- 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div  id="toolbar_pCountCheck" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='pCountCheck:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="pCountCheck_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='pCountCheck:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="pCountCheck_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='pCountCheck:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="pCountCheck_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="pCountCheck_reload()">
			刷新
		</a>
	</div>  
	
    <div id="search_pCountCheck" style="float: right;">
        <input id="search_text_pCountCheck" class="easyui-searchbox"  
            data-options="searcher:doSearch_pCountCheck,prompt:'请输入...',menu:'#menu_pCountCheck'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_pCountCheck" style="width:120px"> 
			<div data-options="name:'pCountCheckId'">工序计数质检编号</div> 
			 
		</div>     
    </div>  

</div>  
<!-- 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div id="pCountCheckEditWindow" class="easyui-window" title="编辑工序计数质检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'p_count_check/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="pCountCheckAddWindow" class="easyui-window" title="添加工序计数质检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'p_count_check/add'" style="width:65%;height:80%;padding:10px;">
</div>

<!-- ********************************************************************************** -->
<div id="p2pCountInfo" class="easyui-dialog" title="工序信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:35%;height:40%;padding:10px;">
	<form id="p2pCountEditForm" method="post">
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitp2pCountEditForm()">提交</a>
	</div>
</div>

<!-- 检验人信息 -->
<div id="empInfo_pCount" class="easyui-dialog" title="检验人信息" data-options="modal:true,closed:true,resizable:true,
		iconCls:'icon-save'" style="width:33%;height:65%;padding:10px;">
	<form id="empEditForm_pCount" method="post">
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEmpEditForm_pCount()">提交</a>
	</div>
</div>

<!-- ********************************************************************************** -->

<div id="pCountCheckNoteDialog" class="easyui-dialog" title="工序计数质检备注" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px">
	<form id="pCountCheckNoteForm" method="post">
		<input type="hidden" name="pCountCheckId"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updatePCountCheckNote()">保存</a>
	</div>
</div>
<script>
function doSearch_pCountCheck(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#pCountCheckList").datagrid({
	        title:'工序计数质检', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_pCountCheck", url:'p_count_check/list', method:'get',
			loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'pCountCheckId', width : 100, title : '工序计数质检编号', align:'center'},
				{field : 'processId', width : 100, align : 'center', title : '工序编号'},
				{field : 'checkItem', width : 100, align : 'center', title : '检验项目'},
				{field : 'sample', width : 100, title : '样本总数', align:'center'},
				{field : 'checkNumber', width : 100, title : '抽检数', align:'center'},
				{field : 'unqualify', width : 100, title : '不合格数', align:'center'},
				{field : 'qualify', width : 100, title : '合格率', align:'center'},
				{field : 'cdate', width : 130, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime} ,
				{field : 'measureData', width : 100, title : '实际测量数据', align:'center'},
				{field : 'empName', width : 100, title : '检验人', align:'center',formatter:formatEmp_pCount},
				{field : 'result', width : 100, title : '检验结果', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatPCountCheckNote}
	        ] ],  
	    });
	}else{
		$("#pCountCheckList").datagrid({  
	        title:'工序计数质检', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_pCountCheck", url:'p_count_check/search_pCountCheck_by_'+name+'?searchValue='
				+value, loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'pCountCheckId', width : 100, title : '工序计数质检编号', align:'center'},
				{field : 'processId', width : 100, align : 'center', title : '工序编号'},
				{field : 'checkItem', width : 100, align : 'center', title : '检验项目'},
				{field : 'sample', width : 100, title : '样本总数', align:'center'},
				{field : 'checkNumber', width : 100, title : '抽检数', align:'center'},
				{field : 'unqualify', width : 100, title : '不合格数', align:'center'},
				{field : 'qualify', width : 100, title : '合格率', align:'center'},
				{field : 'cdate', width : 130, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime} ,
				{field : 'measureData', width : 100, title : '实际测量数据', align:'center'},
				{field : 'empName', width : 100, title : '检验人', align:'center',formatter:formatEmp_pCount},
				{field : 'result', width : 100, title : '检验结果', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatPCountCheckNote}
	        ] ],  
	    });
	}
}

//格式化工序信息
function  formatPCountCheckProcess(value, row, index){ 
	if(value == null){
		return '无';
	}
	else{
		return "<a href=javascript:openCountP2P("+index+")>"+value+"</a>";
	}
};

//打开工序信息对话框
function  openCountP2P(index){ 
	var row = onPCountCheckClickRow(index);
	$("#p2pCountInfo").dialog({
		onOpen :function(){
			
			$.get("process/get/"+row.processId,'',function(data){
	    		//回显数据
	    		$("#p2pCountEditForm").form("load", data);
	    	});
		},
	}).dialog("open");
};

function submitp2pCountEditForm(){
	//此处写工序信息
	$.get("pCountCheck/edit_judge",'',function(data){
		if(data.msg != null){
			$.messager.alert('提示', data.msg);
		}else{
			if(!$('#p2pCountEditForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			//此处写工序信息
			$.post("process/update_all",$("#p2pCountEditForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','修改工序成功!','info',function(){
						$("#p2pCountInfo").dialog("close");
					});
				}else{
					$.messager.alert('错误','修改工序失败!');
				}
			});
		}
	});
}

//格式化检验人信息
function formatEmp_pCount(value, row, index){ 
	if(value !=null && value != ''){
		return "<a href=javascript:openEmp_pCount("+index+")>"+value+"</a>";
	}else{
		return "无";
	}
};

//打开检验人信息对话框
function  openEmp_pCount(index){ 
	var row = onPCountCheckClickRow(index);
	$("#empInfo_pCount").dialog({
		onOpen :function(){
			$.get("employee/get/"+row.empId,'',function(data){
	    		//回显数据
				data.birthday = TAOTAO.formatDateTime(data.birthday);
				data.joinDate = TAOTAO.formatDateTime(data.joinDate);
				data.departmentId=data.department.departmentId;
				data.departmentName=data.department.departmentName;
	    		$("#empInfo_pCount").form("load", data);
	    	});
		}
	}).dialog("open");
};

//提交检验人信息
function submitEmpEditForm_pCount(){
	$.get("employee/edit_judge",'',function(data){
		if(data.msg != null){
			$.messager.alert('提示', data.msg);
		}else{ 
			if(!$('#empEditForm_pCount').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			$.post("employee/update_all",$("#empEditForm_pCount").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','修改检验人信息成功!','info',function(){
						$("#empInfo_pCount").dialog("close");
					});
				}else{
					$.messager.alert('错误', data.msg);
				}
			});
		}
	});
}

	var pCountCheckNoteEditor ;
	
	//格式化工序计数质检要求
	function formatPCountCheckNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openPCountCheckNote("+index+")>"+"备注"+"</a>";
		}else{
			return "无";
		}
	}

	//根据index拿到该行值
	function onPCountCheckClickRow(index) {
		var rows = $('#pCountCheckList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开工序计数质检要求富文本编辑器对话框
	function  openPCountCheckNote(index){ 
		var row = onPCountCheckClickRow(index);
		$("#pCountCheckNoteDialog").dialog({
    		onOpen :function(){
    			$("#pCountCheckNoteForm [name=pCountCheckId]").val(row.pCountCheckId);
    			pCountCheckNoteEditor = TAOTAO.createEditor("#pCountCheckNoteForm [name=note]");
    			pCountCheckNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#pCountCheckNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新工序计数质检备注
	function updatePCountCheckNote(){
		$.get("pCountCheck/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			pCountCheckNoteEditor.sync();
    			$.post("p_count_check/update_note",$("#pCountCheckNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#pCountCheckNoteDialog").dialog("close");
    					$("#pCountCheckList").datagrid("reload");
    					$.messager.alert("操作提示", "更新工序计数质检备注成功！");
    				}else{
    					$.messager.alert("操作提示", "更新工序计数质检备注失败！");
    				}
    			});
    		}
    	});
	}
	
    function getPCountSelectionsIds(){
    	var pCountCheckList = $("#pCountCheckList");
    	var sels = pCountCheckList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].pCountCheckId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
//////////////////////////////////////////////////////////////////////////
    function pCountCheck_add(){
    	$.get("pCountCheck/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#pCountCheckAddWindow").window("open");
       		}
       	});
    }
    
    function pCountCheck_edit(){
    	$.get("pCountCheck/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getPCountSelectionsIds();
            	
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个工序计数质检才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个工序计数质检!');
            		return ;
            	}
            	
            	$("#pCountCheckEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#pCountCheckList").datagrid("getSelections")[0];
            			data.cdate = TAOTAO.formatDateTime(data.cdate);
            			$("#pCountCheckEditForm").form("load", data);
            			pCountCheckEditEditor.html(data.note);
            		}
            	}).window("open");
       		}
       	});
    }
    
    function pCountCheck_delete(){
    	$.get("pCountCheck/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getPCountSelectionsIds();
               	if(ids.length == 0){
               		$.messager.alert('提示','未选中工序计数质检!');
               		return ;
               	}
               	$.messager.confirm('确认','确定删除ID为 '+ids+' 的工序计数质检吗？',function(r){
               	    if (r){
               	    	var params = {"ids":ids};
                       	$.post("p_count_check/delete_batch",params, function(data){
                   			if(data.status == 200){
                   				$.messager.alert('提示','删除工序计数质检成功!',undefined,function(){
                   					$("#pCountCheckList").datagrid("reload");
                   				});
                   			}
                   		});
               	    }
               	});
       		}
       	});
    }
    
    function pCountCheck_reload(){
    	$("#pCountCheckList").datagrid("reload");
    }
</script>
