<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="customList" title="客户列表" data-options="singleSelect:false,collapsible:true,
		pagination:true,rownumbers:true,url:'custom/list', method:'get',pageSize:30, fitColumns:true,
		toolbar:toolbar_custom">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'customId',width:100,align:'center'">客户编号</th>
            <th data-options="field:'customName',width:100,align:'center'">客户名称</th>
            <th data-options="field:'fullName',width:200,align:'center'">客户全称</th>
            <th data-options="field:'address',width:200,align:'center'">地址</th>
            <th data-options="field:'fax',width:100,align:'center'">传真</th>
            <th data-options="field:'email',width:100,align:'center'">邮箱</th>
            <th data-options="field:'ownerName',width:60,align:'center'">经理姓名</th>
            <th data-options="field:'ownerTel',width:100,align:'center'">联系电话</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatCustomStatus">客户状态</th>
            <th data-options="field:'note',width:130,align:'center', formatter:formatCustomNote">备注</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_custom" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='custom:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="custom_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='custom:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="custom_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='custom:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel"
		        	 onclick="custom_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="custom_reload()">刷新</a>  
	</div>  
	
    <div id="search_custom" style="float: right;">
        <input id="search_text_custom" class="easyui-searchbox"  
            data-options="searcher:doSearch_custom,prompt:'请输入...',menu:'#menu_custom'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_custom" style="width:120px"> 
			<div data-options="name:'customId'">客户编号</div> 
			<div data-options="name:'customName'">客户名称</div>
		</div>     
    </div>  

</div>

<div id="customEditWindow" class="easyui-window" title="编辑客户" 
	data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'custom/edit'" 
	style="width:65%;height:80%;padding:10px;">
</div>

<div id="customAddWindow" class="easyui-window" title="添加客户" 
	data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'custom/add'" 
	style="width:65%;height:80%;padding:10px;">
</div>

<div id="customNoteDialog" class="easyui-dialog" title="备注" 
	data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" 
	style="width:55%;height:65%;padding:10px;">
	<form id="customNoteForm" class="itemForm" method="post">
		<input type="hidden" name="customId"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateCustomNote()">保存</a>
	</div>
</div>
<script>

function doSearch_custom(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#customList").datagrid({
	        title:'客户列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, 
	        	method:'get', nowrap:true,  
	        toolbar:"toolbar_custom", url:'custom/list', method:'get', loadMsg:'数据加载中......',  
	        	fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'customId', width : 100, title : '客户编号', align:'center'},
	             	{field : 'customName', width : 100, align : 'center', title : '客户名称'},
	             	{field : 'fullName', width : 200, align : 'center', title : '客户全称'}, 
	             	{field : 'address', width : 200, title : '地址', align:'center'}, 
	             	{field : 'fax', width : 100, title : '传真', align:'center'}, 
	            	{field : 'email', width : 70, title : '邮箱', align:'center'}, 
	             	{field : 'ownerName', width : 60, title : '经理姓名', align:'center'}, 
	             	{field : 'ownerTel', width : 100, title : '联系电话', align:'center'}, 
	             	{field : 'status', width : 60, title : '客户状态', align:'center', 
	             			formatter:TAOTAO.formatCustomStatus}, 
	             	{field : 'note', width : 100, title : '备注', align:'center', formatter:formatCustomNote}, 
	        ] ],  
	    });
	}else{
		$("#customList").datagrid({  
	        title:'客户列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, 
	        	method:'get', nowrap:true,  
	        toolbar:"toolbar_custom", url:'custom/search_custom_by_'+name+'?searchValue='+value, 
	        	loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
					{field : 'ck', checkbox:true }, 
					{field : 'customId', width : 100, title : '客户编号', align:'center'},
					{field : 'customName', width : 100, align : 'center', title : '客户名称'},
					{field : 'fullName', width : 200, align : 'center', title : '客户全称'}, 
					{field : 'address', width : 200, title : '地址', align:'center'}, 
					{field : 'fax', width : 100, title : '传真', align:'center'}, 
					{field : 'email', width : 70, title : '邮箱', align:'center'}, 
					{field : 'ownerName', width : 60, title : '经理姓名', align:'center'}, 
					{field : 'ownerTel', width : 100, title : '联系电话', align:'center'}, 
					{field : 'status', width : 60, title : '客户状态', align:'center', 
							formatter:TAOTAO.formatCustomStatus}, 
					{field : 'note', width : 100, title : '备注', align:'center', formatter:formatCustomNote}, 
	        ] ],  
	    });
	}
}	
	var customNoteEditor ;
	
	//根据index拿到该行值
	function onCustomClickRow(index) {
		var rows = $('#customList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化客户介绍
	function formatCustomNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openCustomNote("+index+")>"+"客户介绍"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openCustomNote(index){ 
		
		var row = onCustomClickRow(index);
		$("#customNoteDialog").dialog({
			onOpen :function(){
				$("#customNoteForm [name=customId]").val(row.customId);
				customNoteEditor = TAOTAO.createEditor("#customNoteForm [name=note]");
				customNoteEditor.html(row.note);
				
			},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#customNoteForm [name=note]");
			}
		}).dialog("open");
	};
	
	function updateCustomNote(){
		$.get("custom/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			customNoteEditor.sync();
    			$.post("custom/update_note",$("#customNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#customNoteDialog").dialog("close");
    					$("#customList").datagrid("reload");
    					$.messager.alert("操作提示", "更新客户介绍成功！");
    				}else{
    					$.messager.alert("操作提示", "更新客户介绍失败！","error");
    				}
    			});
    		}
    	});
	}
	
	function getCustomSelectionsIds(){
		var customList = $("#customList");
		var sels = customList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].customId);
		}
		ids = ids.join(","); 
		
		return ids;
	}
	
	function custom_add(){
    	$.get("custom/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#customAddWindow").window("open");
       		}
       	});
    }
    
    function custom_edit(){
    	$.get("custom/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCustomSelectionsIds();
    	    	
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','必须选择一个客户才能编辑!');
    	    		return ;
    	    	}
    	    	if(ids.indexOf(',') > 0){
    	    		$.messager.alert('提示','只能选择一个客户!');
    	    		return ;
    	    	}
    	    	
    	    	$("#customEditWindow").window({
    	    		onLoad :function(){
    	    			//回显数据
    	    			var data = $("#customList").datagrid("getSelections")[0];
    	    			$("#customEditForm").form("load", data);
    	    			customEditEditor.html(data.note);
    	    		}
    	    	}).window("open");
       		}
       	});
    }
    
    function custom_delete(){
    	$.get("custom/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getCustomSelectionsIds();
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','未选中客户!');
    	    		return ;
    	    	}
    	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的客户吗？',function(r){
    	    	    if (r){
    	    	    	var params = {"ids":ids};
    	            	$.post("custom/delete_batch",params, function(data){
    	        			if(data.status == 200){
    	        				$.messager.alert('提示','删除客户成功!',undefined,function(){
    	        					$("#customList").datagrid("reload");
    	        				});
    	        			}
    	        		});
    	    	    }
    	    	});
       		}
       	});
    }
    
    function custom_reload(){
    	$("#customList").datagrid("reload");
    }
</script>