<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="roleAddForm" class="roleForm" method="post">
		<span>角色编号:</span>
        	<input class="easyui-textbox" type="text" name="roleId" data-options="required:true"></input><br><br>
        <span>角色名&nbsp:</span>
        	<input class="easyui-textbox" type="text" name="roleName" data-options="required:true"></input><br><br>
        <span >状&nbsp态&nbsp:</span>
            <select class="easyui-combobox" name="available" data-options="width:150">
				<option value="1">有效</option>
				<option value="2">锁定</option>
			</select><br><br>
        <span >权&nbsp限&nbsp:</span><br><br>
	        <input type="hidden" name="permission" ></input>
           	<span style="font-weight: bold;">订单管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="11" />订单新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="12" />订单修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="13" />订单删除 </label> 
			<br><br>
            <span style="font-weight: bold;">客户管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="21" />客户新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="22" />客户修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="23" />客户删除 </label> 
			<br><br>
            <span style="font-weight: bold;">产品管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="31" />产品新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="32" />产品修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="33" />产品删除 </label> 
			<br><br><br>
	</form>
	<br><br>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitRoleAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitRoleAddForm(){
		//有效性验证
		if(!$('#roleAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		//ajax的post方式提交表单
		//$("#roleAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("role/insert",$("#roleAddForm").serialize(), function(data){
			if(data.label == 200){
				if($("input[name='permissionOption2']:checked").length>0){
					var permission = '';
					$("input[name='permissionOption2']:checked").each(function(){
						permission += $(this).val()+',';
					}); 
					$("#roleEditForm [name=permission]").val(permission);
				}
				
				$.messager.alert('提示', data.msg);
				clearForm();
				$("#roleList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	function clearForm(){
		$('#roleAddForm').form('reset');
	}
	$('#cc').combo({    
	    required:true,    
	    multiple:true   
	});
</script>
