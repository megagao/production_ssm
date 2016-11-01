<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="customList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'custom/list',method:'get',pageSize:30,toolbar:toolbar">
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
<div id="customEditWindow" class="easyui-window" title="编辑客户" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'custom/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="customAddWindow" class="easyui-window" title="添加客户" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'custom/add'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="customNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:55%;height:80%;padding:10px;">
	<form id="customNoteForm" class="itemForm" method="post">
		<input type="hidden" name="customId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateCustomNote()">保存</a>
	</div>
</div>
<script>

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
	
	var toolbar = [{
	    text:'新增',
	    iconCls:'icon-add',
	    handler:function(){
	    	$.get("custom/add_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			$("#customAddWindow").window("open");
        		}
        	});
	    }
	},{
	    text:'编辑',
	    iconCls:'icon-edit',
	    handler:function(){
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
        	    			customNoteEditor.html(data.note);
        	    		}
        	    	}).window("open");
        		}
        	});
	    }
	},{
	    text:'删除',
	    iconCls:'icon-cancel',
	    handler:function(){
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
	},'-',{
	    text:'刷新',
	    iconCls:'icon-reload',
	    handler:function(){
	    	$("#customList").datagrid("reload");
	    }
	}];
</script>