<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="technologyPlanList" title="工艺计划列表" data-options="singleSelect:false,
		collapsible:true,pagination:true,rownumbers:true,url:'technologyPlan/list',method:'get',pageSize:30,
		fitColumns:true,toolbar:toolbar_technologyPlan">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'technologyPlanId',width:80,align:'center'">
				工艺计划编号
			</th>
            <th data-options="field:'technologyName',width:100,align:'center',
            		formatter:formatTechnology_technologyPlan">
				工艺名称
			</th>
            <th data-options="field:'batchAmount',width:80,align:'center'">批次数量</th>
            <th data-options="field:'startPlan',width:140,align:'center',formatter:TAOTAO.formatDateTime">
				计划开始时间
			</th>
            <th data-options="field:'endPlan',width:140,align:'center',formatter:TAOTAO.formatDateTime">
				计划结束时间
			</th>
            <th data-options="field:'commitPlan',width:140,align:'center',formatter:TAOTAO.formatDateTime">
				计划提交时间
			</th>
            <th data-options="field:'technologyPlanStart',width:140,align:'center',formatter:TAOTAO.formatDateTime">
				工艺计划开始时间
			</th>
            <th data-options="field:'technologyPlanEnd',width:140,align:'center',formatter:TAOTAO.formatDateTime">
				工艺计划结束时间
			</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_technologyPlan" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='technologyPlan:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="technologyPlan_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='technologyPlan:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="technologyPlan_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='technologyPlan:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="technologyPlan_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="technologyPlan_reload()">刷新</a>  
	</div>  
	
    <div id="search_technologyPlan" style="float: right;">
        <input id="search_text_technologyPlan" class="easyui-searchbox"  
            data-options="searcher:doSearch_technologyPlan,prompt:'请输入...',menu:'#menu_technologyPlan'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_technologyPlan" style="width:120px"> 
			<div data-options="name:'technologyPlanId'">工艺计划编号</div> 
			<div data-options="name:'technologyName'">工艺名称</div>
		</div>     
    </div>  

</div> 

<div id="technologyPlanEditWindow" class="easyui-window" title="编辑工艺计划" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'technologyPlan/edit'" style="width:40%;height:55%;padding:10px;">
</div>
<div id="technologyPlanAddWindow" class="easyui-window" title="添加工艺计划" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'technologyPlan/add'" style="width:40%;height:55%;padding:10px;">
</div>
 
<!-- 工艺信息 -->
<div id="technologyInfo_technologyPlan" class="easyui-dialog" title="工艺信息" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save'" style="width:40%;height:55%;padding:10px;">
	<form id="technologyEditForm_technologyPlan" method="post">
		<input type="hidden" name="technologyId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>工艺名称:</td>
	            <td><input class="easyui-textbox" type="text" name="technologyName" data-options="required:true"/></td>
	        </tr>
	        <tr>
	            <td>外协价格:</td>
	            <td><input class="easyui-numberbox" precision="2" maxlength="10" name="price"/></td>
	        </tr>
	        <tr>
	            <td>瓶颈工序工期:</td>
	            <td><input class="easyui-textbox" type="text" name="vitalProcessPeriod"/></td>
	        </tr>
	        <tr>
	            <td>标准加工能力:</td>
	            <td><input class="easyui-numberbox" maxlength="11" name="standardCapacity"/></td>
	        </tr>
	        <tr>
	            <td>加班标准加工能力:</td>
	            <td><input class="easyui-numberbox" maxlength="11" name="overtimeStandardCapacity"/></td>
	        </tr>
	        <tr>
	            <td>加班超额加工能力:</td>
	            <td><input class="easyui-numberbox" maxlength="11" name="overtimeOverfulfilCapacity"/></td>
	        </tr>
	        <tr>
	            <td>二班工序能力:</td>
	            <td><input class="easyui-numberbox" maxlength="11" name="doubleCapacity"/></td>
	        </tr>
	        <tr>
	            <td>超负荷工序能力:</td>
	            <td><input class="easyui-numberbox" maxlength="11" name="overfulfilCapacity"/></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTechnologyEditForm_technologyPlan()">
			提交
		</a>
	</div>
</div>
 
<script>
function doSearch_technologyPlan(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#technologyPlanList").datagrid({
	        title:'工艺计划列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_technologyPlan", url:'technologyPlan/list', method:'get',
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [
				{field : 'ck', checkbox:true },
				{field : 'technologyPlanId', width : 100, align:'center', title : '工艺计划编号'},
				{field : 'technologyName', width : 100, align : 'center', title : '工艺名称',
					formatter:formatTechnology_technologyPlan},
				{field : 'batchAmount', width : 100, align : 'center', title : '批次数量'},
				{field : 'startPlan', width : 130, title : '计划开始时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'endPlan', width : 130, title : '计划结束时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'commitPlan', width : 130, title : '计划提交时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'technologyPlanStart', width : 130, title : '工艺计划开始时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'technologyPlanEnd', width : 130, title : '工艺计划结束时间', align:'center',
					formatter:TAOTAO.formatDateTime},
	        ] ],  
	    });
	}else{
		$("#technologyPlanList").datagrid({  
	        title:'工艺计划列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_technologyPlan", url:'technologyPlan/search_technologyPlan_by_'+name
				+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'technologyPlanId', width : 100, align:'center', title : '工艺计划编号'},
				{field : 'technologyName', width : 100, align : 'center', title : '工艺名称',
					formatter:formatTechnology_technologyPlan},
				{field : 'batchAmount', width : 100, align : 'center', title : '批次数量'},
				{field : 'startPlan', width : 130, title : '计划开始时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'endPlan', width : 130, title : '计划结束时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'commitPlan', width : 130, title : '计划提交时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'technologyPlanStart', width : 130, title : '工艺计划开始时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'technologyPlanEnd', width : 130, title : '工艺计划结束时间', align:'center',
					formatter:TAOTAO.formatDateTime},
	        ] ],  
	    });
	}
}

//根据index拿到该行值
	function onTechnologyPlanClickRow(index) {
		var rows = $('#technologyPlanList').datagrid('getRows');
		return rows[index];
		
	}

	//格式化工艺信息
	function formatTechnology_technologyPlan(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openTechnology_technologyPlan("+index+")>"+row.technologyName+"</a>";
		}else{
			return "无";
		}
	};
	
	//打开工艺信息对话框
	function  openTechnology_technologyPlan(index){
		var row = onTechnologyPlanClickRow(index);
		$("#technologyInfo_technologyPlan").dialog({
    		onOpen :function(){
    			$.get("technology/get/"+row.technologyId,'',function(data){
		    		//回显数据
		    		$("#technologyEditForm_technologyPlan").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交工艺信息
	function submitTechnologyEditForm_technologyPlan(){
		$.get("technology/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#technologyEditForm_technologyPlan').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}

    			$.post("technology/update_all",$("#technologyEditForm_technologyPlan").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改工艺成功!','info',function(){
    						$("#technologyInfo_technologyPlan").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改工艺失败!');
    				}
    			});
    		}
    	});
	}  
	
	function getTechnologyPlanSelectionsIds(){
		var technologyPlanList = $("#technologyPlanList");
		var sels = technologyPlanList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].technologyPlanId);
		}
		ids = ids.join(","); 
		
		return ids;
	}
	
	function technologyPlan_add(){
    	$.get("technologyPlan/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#technologyPlanAddWindow").window("open");
       		}
       	});
    }
    
    function technologyPlan_edit(){
    	$.get("technologyPlan/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{ 
       			var ids = getTechnologyPlanSelectionsIds();
       	    	
       	    	if(ids.length == 0){
       	    		$.messager.alert('提示','必须选择一个工艺计划才能编辑!');
       	    		return ;
       	    	}
       	    	if(ids.indexOf(',') > 0){
       	    		$.messager.alert('提示','只能选择一个工艺计划!');
       	    		return ;
       	    	}
       	    	
       	    	$("#technologyPlanEditWindow").window({
       	    		onLoad :function(){
       	    			//回显数据
               			var data = $("#technologyPlanList").datagrid("getSelections")[0];
               			data.startPlan = TAOTAO.formatDateTime(data.startPlan);
               			data.endPlan = TAOTAO.formatDateTime(data.endPlan);
               			data.commitPlan = TAOTAO.formatDateTime(data.commitPlan);
               			data.technologyStartPlan = TAOTAO.formatDateTime(data.technologyStartPlan);
               			data.technologyEndPlan = TAOTAO.formatDateTime(data.technologyEndPlan);
               			$("#technologyPlanEditForm").form("load", data);
       	    		}
       	    	}).window("open");
       		}
       	});
    }
    
    function technologyPlan_delete(){
    	$.get("technologyPlan/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{ 
       			var ids = getTechnologyPlanSelectionsIds();
       	    	if(ids.length == 0){
       	    		$.messager.alert('提示','未选中工艺计划!');
       	    		return ;
       	    	}
       	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的工艺计划吗？',function(r){
       	    	    if (r){
       	    	    	var params = {"ids":ids};
       	            	$.post("technologyPlan/delete_batch",params, function(data){
       	        			if(data.status == 200){
       	        				$.messager.alert('提示','删除工艺计划成功!',undefined,function(){
       	        					$("#technologyPlanList").datagrid("reload");
       	        				});
       	        			}else{
       	     					$.messager.alert('提示',data.msg);
       	     				}
       	        		});
       	    	    }
       	    	});
       		}
       	});
    }
    
    function technologyPlan_reload(){
    	$("#technologyPlanList").datagrid("reload");
    }
</script>