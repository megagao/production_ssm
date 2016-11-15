<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
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
					<br><br>
					<span style="font-weight: bold;">部门管理：</span>
					<label><input name="permissionOption" type="checkbox" value="41" />部门新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="42" />部门修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="43" />部门删除 </label> 
					<br><br>
					<span style="font-weight: bold;">员工管理：</span>
					<label><input name="permissionOption" type="checkbox" value="51" />员工新增 </label> 
					<label><input name="permissionOption" type="checkbox" value="52" />员工修改 </label> 
					<label><input name="permissionOption" type="checkbox" value="53" />员工删除 </label> 
					<br><br><br>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updatePermission()">保存</a>
	</div>
</div>
<script type="text/javascript">
	function rolePermissionInit(){
		var roleId = $('#permissionForm [name=roleId]').val();
		$.get("permission/get_permission", {roleId : roleId}, function(data){
			//获得所要回显的值，此处为","分割的字符串
	        var checkeds = data.sysPermissionId;
			if(checkeds != ''){
				//拆分为字符串数组
		        checkArray =checkeds.split(",");
		    	//获得所有的复选框对象
			    var checkBoxAll = $("input[name='permissionOption']");
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
			}
		}); 
	}
	
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
				$("#permissionWindow").window("close");
				$("#roleList").datagrid("reload");
				$.messager.alert("操作提示", "更新权限成功！");
			}else{
				$.messager.alert("操作提示", "更新权限失败！","error");
			}
		});
    }
	
</script>
