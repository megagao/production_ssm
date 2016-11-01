<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="roleEditForm" class="roleForm" method="post">
		<input id="roleId" type="hidden" name="roleId"/>
	            <span>角色名:</span>
	            	<input class="easyui-textbox" type="text" name="roleName" ></input><br><br>
	            <span >状&nbsp态:</span>
		            <select class="easyui-combobox" name="available" data-options="width:150">
						<option value="1">有效</option>
						<option value="2">锁定</option>
					</select><br><br>
	        <span >权限:</span><br><br>
	        <input type="hidden" name="permission" ></input>
           	<span style="font-weight: bold;">订单管理：</span>
			<label><input name="permissionOption1" type="checkbox" value="11" />订单新增 </label> 
			<label><input name="permissionOption1" type="checkbox" value="12" />订单修改 </label> 
			<label><input name="permissionOption1" type="checkbox" value="13" />订单删除 </label> 
			<br><br>
            <span style="font-weight: bold;">客户管理：</span>
			<label><input name="permissionOption1" type="checkbox" value="21" />客户新增 </label> 
			<label><input name="permissionOption1" type="checkbox" value="22" />客户修改 </label> 
			<label><input name="permissionOption1" type="checkbox" value="23" />客户删除 </label> 
			<br><br>
            <span style="font-weight: bold;">产品管理：</span>
			<label><input name="permissionOption1" type="checkbox" value="31" />产品新增 </label> 
			<label><input name="permissionOption1" type="checkbox" value="32" />产品修改 </label> 
			<label><input name="permissionOption1" type="checkbox" value="33" />产品删除 </label> 
			<br><br><br>
	</form>
	<br><br>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitRoleEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function permissionInit(){
		var roleId = $('#roleEditForm [name=roleId]').val();
		$.get("permission/get_permission", {roleId : roleId}, function(data){
			//获得所要回显的值，此处为","分割的字符串
	        var checkeds = data.sysPermissionId;
	        //拆分为字符串数组
	        checkArray =checkeds.split(",");
	    	//获得所有的复选框对象
		    var checkBoxAll = $("input[name='permissionOption1']");
		    //获得所有复选框的value值，然后，用checkArray中的值和他们比较，如果有，则说明该复选框被选中
		    for(var i=0;i<checkArray.length-1;i++){
			    //获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
			    $.each(checkBoxAll,function(j,checkbox){
				    //获取复选框的value属性
				    var checkValue=$(checkbox).val();
				    
				    if(checkArray[i]==checkValue){
				    	/* alert("checkArray[i] = "+checkArray[i])
					    alert("checkValue = "+checkValue) */
				    	$(checkbox).prop("checked",true);
				    }
			    });
		   }
		}); 
	}
	
	function submitRoleEditForm(){
		if(!$('#roleEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
	
		$.post("role/update_all",$("#roleEditForm").serialize(), function(data){
			if(data.label == 200){
				if($("input[name='permissionOption1']:checked").length>0){
					var permission = '';
					$("input[name='permissionOption1']:checked").each(function(){
						permission += $(this).val()+',';
					}); 
					$("#roleEditForm [name=permission]").val(permission);
				}
				$.messager.alert('提示', data.msg);
				$("#roleEditWindow").window('close');
				$("#roleList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
</script>
