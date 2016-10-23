<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="userList" title="用户列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'user/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',align:'center',width:150">用户编号</th>
            <th data-options="field:'username',align:'center',width:150">用户名</th>
            <th data-options="field:'password',align:'center',width:150">密码</th>
            <th data-options="field:'role',align:'center',width:150">角色</th>
            <th data-options="field:'locked',width:150,align:'center',formatter:formatUserStatus">状态</th>
        </tr>
    </thead>
</table>
<div id="userEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'user/edit'" style="width:45%;height:60%;padding:10px;">
</div>
<div id="userAddWindow" class="easyui-window" title="添加用户" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'user/add'" style="width:45%;height:60%;padding:10px;">
</div>
<script>
	function formatUserStatus(value){
        if (value == 1){
            return '有效用户';
        }else if(value == 2){
        	return '<span style="color:red;">锁定</span>';
        }else {
        	return '<span style="color:#E5B717;">未知状态用户</span>';
        }
    }
	
	//根据index拿到该行值
	function onClickRow(index) {
		var rows = $('#userList').datagrid('getRows');
		return rows[index];
		
	}
	
    function getSelectionsIds(){
    	var userList = $("#userList");
    	var sels = userList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#userAddWindow").window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个用户才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个用户!');
        		return ;
        	}
        	
        	$("#userEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#userList").datagrid("getSelections")[0];
        			$("#userEditForm").form("load", data);
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中用户!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("user/delete_batch",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除用户成功!',undefined,function(){
            					$("#userList").datagrid("reload");
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
        	$("#userList").datagrid("reload");
        }
    }];
</script>