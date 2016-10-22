<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="roleEditForm" class="roleForm" method="post">
		<input type="hidden" name="roleId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>角色名:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="rolename" ></input>
	            </td>
	        </tr>
	        <tr>
	            <td>状态:</td>
	            <td>
		            <select class="easyui-combobox" name="available" data-options="width:150">
						<option value="1">有效</option>
						<option value="2">锁定</option>
					</select>
				</td>
	        </tr>
	         <tr>
	            <td>权限:</td>
	            <td>
	            	<input type="hidden" name="permission" ></input>
	            </td>
	            <br>
	            <td>
		            <span>订单管理：</span>
					<label><input name="permissionOption" type="checkbox" value="11" />订单新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="12" />订单修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="13" />订单删除 </label> 
				</td>
				  <td>
		            <span>客户管理：</span>
					<label><input name="permissionOption" type="checkbox" value="21" />客户新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="22" />客户修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="23" />客户删除 </label> 
				</td>
				  <td>
		            <span>产品管理：</span>
					<label><input name="permissionOption" type="checkbox" value="31" />产品新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="32" />产品修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="33" />产品删除 </label> 
				</td>
	        </tr>
	    </table>
	    
	</form>
	<br><br>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitForm(){
		if(!$('#roleEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("role/update_all",$("#roleEditForm").serialize(), function(data){
			if($("input[name='permission']:checkbox:checked").length>0){
				value = '';
				$("input[name='permission']:checkbox:checked").each(function(){
				  value += $(this).val()+',';
				}); 
				var roleId = $("#permissionForm [name=roleId]").val();
				$.post('permission/update', { roleId : roleId, value : value }, function(data){
					if(data.status == 200){
						$("#permissionDialog").dialog("close");
						$("#roleList").datagrid("reload");
						$.messager.alert("操作提示", "更新权限成功！");
					}else{
						$.messager.alert("操作提示", "更新权限失败！","error");
					}
				});
	    	}
			
			if(data.status == 200){
				$.messager.alert('提示','修改订单成功!','info',function(){
					$("#roleEditWindow").window('close');
					$("#roleList").datagrid("reload");
				});
			}else{
				$.messager.alert('错误','修改订单失败!');
			}
		});
	}
	
</script>
