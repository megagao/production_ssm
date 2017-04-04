<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="processList" title="工序列表" data-options="singleSelect:false,collapsible:true,
		pagination:true,rownumbers:true,url:'process/list',method:'get',pageSize:30,fitColumns:true,
		toolbar:toolbar_process">
	<thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'processId',width:100,align:'center'">
				工序编号
			</th>
            <th data-options="field:'technologyPlanId',width:100,align:'center',formatter:formatTechnologyPlan_process">
				工艺计划编号
			</th>
            <th data-options="field:'sequence',width:100,align:'center'">
				工序顺序
			</th>
            <th data-options="field:'quota',width:100,align:'center'">
				单件定额工时
			</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_process" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='process:add'}" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="process_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='process:edit'}" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="process_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='process:delete'}" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="process_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="process_reload()">
			刷新
		</a>
	</div>  
	
    <div id="search_process" style="float: right;">
        <input id="search_text_process" class="easyui-searchbox"  
            data-options="searcher:doSearch_process,prompt:'请输入...',menu:'#menu_process'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_process" style="width:120px"> 
			<div data-options="name:'processId'">工序编号</div> 
			<div data-options="name:'technologyPlanId'">工艺计划编号</div> 
		</div>     
    </div>  

</div> 

<div id="processEditWindow" class="easyui-window" title="编辑工序" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'process/edit'" style="width:35%;height:50%;padding:10px;">
</div>
<div id="processAddWindow" class="easyui-window" title="添加工序" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'process/add'" style="width:35%;height:50%;padding:10px;">
</div>
 
<!-- 工艺计划信息 -->
<div id="technologyPlanInfo_process" class="easyui-dialog" title="工艺计划信息" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save'" style="width:40%;height:55%;padding:10px;">
	<form id="technologyPlanEditForm_process" method="post">
		<input type="hidden" name="technologyPlanId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>工艺名称:</td>
	            <td>
					<input class="easyui-combobox" name="technologyId" panelHeight="auto" data-options="required:true,
	            		valueField:'technologyId',textField:'technologyName',url:'technology/get_data',editable:false"/>
				</td>
	        </tr>
	        <tr>
	            <td>批次数量:</td>
	            <td><input class="easyui-numberbox" maxlength="11" name="batchAmount"/></td>
	        </tr>
	        <tr>
	            <td>计划开始时间:</td>
	            <td><input class="easyui-datetimebox" name="startPlan" value="5/5/2016 00:00:00"/></td>
	        </tr>
	        <tr>
	            <td>计划结束时间:</td>
	            <td><input class="easyui-datetimebox" name="endPlan"/></td>
	        </tr>
	        <tr>
	            <td>计划提交时间:</td>
	            <td><input class="easyui-datetimebox" name="commitPlan"/></td>
	        </tr>
	        <tr>
	            <td>工艺计划开始时间:</td>
	            <td><input class="easyui-datetimebox" name="technologyStartPlan"/></td>
	        </tr>
	        <tr>
	            <td>工艺计划结束时间:</td>
	            <td><input class="easyui-datetimebox" name="technologyEndPlan"/></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTechnologyPlanEditForm_process()">
			提交
		</a>
	</div>
</div>
 
<script>
function doSearch_process(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#processList").datagrid({
	        title:'工序列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_process", url:'process/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'processId', width : 100, align:'center', title : '工序编号'},
				{field : 'technologyPlanId', width : 100, align : 'center', title : '工艺计划编号',
					formatter:formatTechnologyPlan_process},
				{field : 'sequence', width : 100, align : 'center', title : '工序顺序'},
				{field : 'quota', width : 100, title : '单件定额工时', align:'center'}
	        ] ],  
	    });
	}else{
		$("#processList").datagrid({  
	        title:'工序列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_process", url:'process/search_process_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [
				{field : 'ck', checkbox:true },
				{field : 'processId', width : 100, align:'center', title : '工序编号'},
				{field : 'technologyPlanId', width : 100, align : 'center', title : '工艺计划编号',
					formatter:formatTechnologyPlan_process},
				{field : 'sequence', width : 100, align : 'center', title : '工序顺序'},
				{field : 'quota', width : 100, title : '单件定额工时', align:'center'}
	        ] ],  
	    });
	}
}

	//根据index拿到该行值
	function onProcessClickRow(index) {
		var rows = $('#processList').datagrid('getRows');
		return rows[index];
	}
	
	//格式化工艺计划信息
	function formatTechnologyPlan_process(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openTechnologyPlan_process("+index+")>"+row.technologyPlanId+"</a>";
		}else{
			return "无";
		}
	};  
	
	//打开工艺计划信息对话框
	function  openTechnologyPlan_process(index){ 
		var row = onProcessClickRow(index);
		$("#technologyPlanInfo_process").dialog({
    		onOpen :function(){
    			$.get("technologyPlan/get/"+row.technologyPlanId,'',function(data){
		    		//回显数据
		    		data.startPlan = TAOTAO.formatDateTime(data.startPlan);
           			data.endPlan = TAOTAO.formatDateTime(data.endPlan);
           			data.commitPlan = TAOTAO.formatDateTime(data.commitPlan);
           			data.technologyStartPlan = TAOTAO.formatDateTime(data.technologyStartPlan);
           			data.technologyEndPlan = TAOTAO.formatDateTime(data.technologyEndPlan);
		    		$("#technologyPlanEditForm_process").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交工艺计划信息
	function submitTechnologyPlanEditForm_process(){
		$.get("technologyPlan/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#technologyPlanEditForm_process').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}

    			$.post("technologyPlan/update_all",$("#technologyPlanEditForm_process").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改工艺计划成功!','info',function(){
    						$("#technologyPlanInfo_process").dialog("close");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}

	function getProcessSelectionsIds(){
		var processList = $("#processList");
		var sels = processList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].processId);
		}
		ids = ids.join(","); 
		
		return ids;
	}
	
	function process_add(){
    	$.get("process/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#processAddWindow").window("open");
       		}
       	});
    }
    
    function process_edit(){
    	$.get("process/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{ 
       			var ids = getProcessSelectionsIds();
       	    	
       	    	if(ids.length == 0){
       	    		$.messager.alert('提示','必须选择一个工序才能编辑!');
       	    		return ;
       	    	}
       	    	if(ids.indexOf(',') > 0){
       	    		$.messager.alert('提示','只能选择一个工序!');
       	    		return ;
       	    	}
       	    	
       	    	$("#processEditWindow").window({
       	    		onLoad :function(){
       	    			//回显数据
               			var data = $("#processList").datagrid("getSelections")[0];
               			data.addTime = TAOTAO.formatDateTime(data.addTime);
               			data.reviseTime = TAOTAO.formatDateTime(data.reviseTime);
               			$("#processEditForm").form("load", data);
       	    		}
       	    	}).window("open");
       		}
       	});
    }
    
    function process_delete(){
    	$.get("process/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{ 
       			var ids = getProcessSelectionsIds();
       	    	if(ids.length == 0){
       	    		$.messager.alert('提示','未选中工序!');
       	    		return ;
       	    	}
       	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的工序吗？',function(r){
       	    	    if (r){
       	    	    	var params = {"ids":ids};
       	            	$.post("process/delete_batch",params, function(data){
       	        			if(data.status == 200){
       	        				$.messager.alert('提示','删除工序成功!',undefined,function(){
       	        					$("#processList").datagrid("reload");
       	        				});
       	        			}
       	        		});
       	    	    }
       	    	});
       		}
       	});
    }
    
    function process_reload(){
    	$("#processList").datagrid("reload");
    }
</script>