<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="roleList" title="角色列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'role/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'roleId',align:'center',width:150">角色编号</th>
            <th data-options="field:'roleName',align:'center',width:150">角色名</th>
            <th data-options="field:'permission',align:'center',width:150,formatter:formatPermission">权限</th>
            <th data-options="field:'available',width:150,align:'center',formatter:formatRoleStatus">状态</th>
        </tr>
    </thead>
</table>
<div id="roleEditWindow" class="easyui-window" title="编辑角色" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'role/edit'" style="width:45%;height:60%;padding:10px;">
</div>
<div id="roleAddWindow" class="easyui-window" title="添加角色" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'role/add'" style="width:45%;height:60%;padding:10px;">
</div>

<div id="permissionWindow" class="easyui-window" title="权限管理" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'role/permission'" style="width:45%;height:60%;padding:10px;">
</div>
<script>

	//格式化客户介绍
	function formatPermission(value, row, index){ 
		return "<a href=javascript:openPermission("+index+")>"+"权限"+"</a>";
	}
	function formatRoleStatus(value){
        if (value == 1){
            return '有效';
        }else if(value == 2){
        	return '<span style="color:red;">锁定</span>';
        }else {
        	return '<span style="color:#E5B717;">未知状态角色</span>';
        }
    }
	
	//根据index拿到该行值
	function onRoleClickRow(index) {
		var rows = $('#roleList').datagrid('getRows');
		return rows[index];
		
	}
	
	function getRoleSelectionsIds(){
    	var roleList = $("#roleList");
    	var sels = roleList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].roleId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
	var j;
	function  openPermission(index){ 
		var data = onRoleClickRow(index);
		$("#permissionWindow").window({
    		onLoad :function(){
    			//回显数据
    			$("#permissionForm").form("load", data);
    			rolePermissionInit();
    		}
    	}).window("open");
	};
	
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#roleAddWindow").window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getRoleSelectionsIds();
        	
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个角色才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个角色!');
        		return ;
        	}
        	
        	$("#roleEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#roleList").datagrid("getSelections")[0];
        			$("#roleEditForm").form("load", data);
        			permissionInit();
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getRoleSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中角色!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的角色吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("role/delete_batch",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除角色成功!',undefined,function(){
            					$("#roleList").datagrid("reload");
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
        	$("#roleList").datagrid("reload");
        }
    }];
</script>