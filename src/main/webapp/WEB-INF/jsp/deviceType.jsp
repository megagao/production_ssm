<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<!-- Table -->
<table class="easyui-datagrid" id="deviceType" title="设备种类列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'deviceType/list',method:'get',pageSize:30, fitColumns:true,toolbar:toolbar_deviceType">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'deviceTypeId',width:80,align:'center'">编号</th>
            <th data-options="field:'deviceTypeName',width:100,align:'center'">名称</th>
            <th data-options="field:'deviceTypeModel',width:100,align:'center'">型号</th>
            <th data-options="field:'deviceTypeSpec',width:70,align:'center'">规格</th>
            <th data-options="field:'deviceTypeSupplier',width:170,align:'center'">供应商</th>
            <th data-options="field:'deviceTypeProducer',width:80,align:'center'">生产商</th>
            <th data-options="field:'deviceTypeQuantity',width:170,align:'center'">台数</th>
            <th data-options="field:'deviceTypeWarranty',width:170,align:'center',formatter:TAOTAO.formatDateTime">保修期</th>
        </tr>
    </thead>
</table>

<!-- Toolbar -->
<div  id="toolbar_deviceType" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<%-- <c:forEach items="${sessionScope.sysPermissionList}" var="per" > --%>
		<c:if test="${per=='deviceType:add'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="deviceType_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceType:edit'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="deviceType_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceType:delete'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="deviceType_delete()">删除</a>  
		    </div>  
		</c:if>
	<%-- </c:forEach> --%>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="deviceType_reload()">刷新</a>  
	</div>  
	
    <div id="search_deviceType" style="float: right;">
        <input id="search_text_deviceType" class="easyui-searchbox"  
            data-options="searcher:doSearch_deviceType,prompt:'请输入...',menu:'#menu_deviceType'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_deviceType" style="width:120px"> 
			<div data-options="name:'deviceTypeId'">种类编号</div> 
			<div data-options="name:'deviceTypeName'">种类名称</div>
		</div>     
    </div>  

</div>

<!-- deviceTypeAddWindow -->
<div id="deviceTypeAddWindow" class="easyui-window" title="添加设备种类" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'deviceType/add'" style="width:38%;height:80%;padding:10px;">
</div>

<!-- deviceTypeEditWindow -->
<div id="deviceTypeEditWindow" class="easyui-window" title="编辑设备种类" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'deviceType/edit'" style="width:38%;height:80%;padding:10px;">
</div>


<script>

	/*********************************** Toolbar function ***********************************/
	function getDeviceTypeSelectionsIds(){
		var deviceType = $("#deviceType");
		var sels = deviceType.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].deviceTypeId);
		}
		ids = ids.join(","); 
		return ids;
	}
	
	function deviceType_add(){
    	$.get("deviceType/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#deviceTypeAddWindow").window("open");
       		}
       	});
    }
    
    function deviceType_edit(){
    	$.get("deviceType/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceTypeSelectionsIds();
    	    	
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','必须选择一个设备种类才能编辑!');
    	    		return ;
    	    	}
    	    	if(ids.indexOf(',') > 0){
    	    		$.messager.alert('提示','只能选择一个设备种类!');
    	    		return ;
    	    	}
    	    	
    	    	$("#deviceTypeEditWindow").window({
    	    		onLoad :function(){
    	    			//回显数据
    	    			var data = $("#deviceType").datagrid("getSelections")[0];
    	    			data.deviceTypeWarranty = TAOTAO.formatDateTime(data.deviceTypeWarranty);
    	    			$("#deviceTypeEditForm").form("load", data);
    	    		}
    	    	}).window("open");
       		}
       	});
    }
    
    function deviceType_delete(){
    	$.get("deviceType/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceTypeSelectionsIds();
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','未选中设备种类!');
    	    		return ;
    	    	}
    	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的设备种类吗？',function(r){
    	    	    if (r){
    	    	    	var params = {"ids":ids};
    	            	$.post("deviceType/delete_batch",params, function(data){
    	        			if(data.status == 200){
    	        				$.messager.alert('提示','删除设备种类成功!',undefined,function(){
    	        					$("#deviceType").datagrid("reload");
    	        				});
    	        			}
    	        		});
    	    	    }
    	    	});
       		}
       	});
    }
    
    function deviceType_reload(){
    	$("#deviceType").datagrid("reload");
    }
    
	function doSearch_deviceType(value,name){ //用户输入用户名,点击搜素,触发此函数  
		
	}	
	/*********************************** Toolbar function ***********************************/
	
	//var deviceTypeNoteEditor ;
	
	//根据index拿到该行值
	function onDeviceTypeClickRow(index) {
		var rows = $('#deviceType').datagrid('getRows');
		return rows[index];
		
	}
</script>