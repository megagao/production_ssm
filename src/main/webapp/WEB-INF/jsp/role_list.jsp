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

<div id="permissionDialog" class="easyui-dialog" title="权限管理" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:55%;height:80%;padding:10px;">
	<form id="permissionForm" class="itemForm" method="post"> 
	            	<input type="hidden" name="roleId"/>
		            <span style="font-weight: bold;">订单管理：</span>
					<label><input name="permissionOption" type="checkbox" value="11" />订单新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="12" />订单修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="13" />订单删除 </label> 
					<br><br>
		            <span style="font-weight: bold;">客户管理：</span>
					<label><input name="permissionOption" type="checkbox" value="21" />客户新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="22" />客户修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="23" />客户删除 </label> 
					<br><br>
		            <span style="font-weight: bold;">产品管理：</span>
					<label><input name="permissionOption" type="checkbox" value="31" />产品新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="32" />产品修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="33" />产品删除 </label> 
					<br><br><br>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updatePermission()">保存</a>
	</div>
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
	function onClickRow(index) {
		var rows = $('#roleList').datagrid('getRows');
		return rows[index];
		
	}
	
	function getSelectionsIds(){
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
		
		var row = onClickRow(index);
		$("#permissionDialog").dialog({
			onOpen :function(){
				//回显
				$("#permissionForm [name=roleId]").val(row.roleId);
				var roleId = row.roleId;
				$.get("permission/get_permission", {roleId : roleId}, function(data){
					//获得所要回显的值，此处为","分割的字符串
			        var checkeds = data.sysPermissionId;
			        //拆分为字符串数组
			        var checkArray =checkeds.split(",");
			        j = checkArray.length;
			    	//获得所有的复选框对象
				    var checkBoxAll = $("input[name='permissionOption']");
				    //获得所有复选框的value值，然后，用checkArray中的值和他们比较，如果有，则说明该复选框被选中
				    for(var i=0;i<checkArray.length;i++){
					    //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
					    $.each(checkBoxAll,function(j,checkbox){
						    //获取复选框的value属性
						    var checkValue=$(checkbox).val();
						    if(checkArray[i]==checkValue){
						    	$(checkbox).attr("checked",true);
						    }
					    });
				   }
				}); 
			},
		
			onBeforeClose: function (event, ui) {
			}
		}).dialog("open");
	};
	
    function updatePermission(){
    	var permission = '';
    	if($("input[name='permissionOption']:checkbox:checked").length>0){
			$("input[name='permissionOption']:checkbox:checked").each(function(){
				permission += $(this).val()+',';
			}); 
		}
			var roleId = $("#permissionForm [name=roleId]").val();
			$.post('permission/update_by_roleid', { roleId : roleId, permission : permission }, function(data){
				if(data.status == 200){
					$("#permissionDialog").dialog("close");
					$("#roleList").datagrid("reload");
					$.messager.alert("操作提示", "更新权限成功！");
				}else{
					$.messager.alert("操作提示", "更新权限失败！","error");
				}
			});
    }
    
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
        	var ids = getSelectionsIds();
        	
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
        	var ids = getSelectionsIds();
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