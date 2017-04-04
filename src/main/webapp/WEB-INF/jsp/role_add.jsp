<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="roleAddForm" class="roleForm" method="post">
		<span>角色编号:</span>
        	<input class="easyui-textbox" type="text" name="roleId" data-options="required:true"/><br><br>
        <span>角色名&nbsp:</span>
        	<input class="easyui-textbox" type="text" name="roleName" data-options="required:true"/><br><br>
        <span >状&nbsp态&nbsp:</span>
            <select class="easyui-combobox" name="available" panelHeight="auto" data-options="width:150,
            		editable:false">
				<option value="1">有效</option>
				<option value="2">锁定</option>
			</select><br><br>
        <span >权&nbsp限&nbsp:</span><br><br>
	        <input type="hidden" name="permission"/>
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
			<br><br>
			<span style="font-weight: bold;">作业管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="61" />作业新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="62" />作业修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="63" />作业删除 </label> 
			<br><br>
			<span style="font-weight: bold;">生产计划管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="71" />生产计划新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="72" />生产计划修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="73" />生产计划删除 </label> 
			<br><br>
			<span style="font-weight: bold;">生产派工管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="81" />生产派工新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="82" />生产派工修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="83" />生产派工删除 </label>
			<br><br>
			<span style="font-weight: bold;">工艺管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="91" />工艺新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="92" />工艺修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="93" />工艺删除 </label> 
			<br><br>
			<span style="font-weight: bold;">工序管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="101" />工序新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="102" />工序修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="103" />工序删除 </label> 
			<br><br>
			<span style="font-weight: bold;">工艺计划管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="111" />工艺计划新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="112" />工艺计划修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="113" />工艺计划删除 </label> 
			<br><br>
			<span style="font-weight: bold;">工艺要求管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="121" />工艺要求新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="122" />工艺要求修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="123" />工艺要求删除 </label> 
			<br><br>
			<span style="font-weight: bold;">物料管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="181" />物料新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="182" />物料修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="183" />物料删除 </label> 
			<br><br>
			<span style="font-weight: bold;">物料收入管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="191" />物料收入新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="192" />物料收入修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="193" />物料收入删除 </label>  
			<br><br>
			<span style="font-weight: bold;">物料消耗管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="221" />物料消耗新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="222" />物料消耗修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="223" />物料消耗删除 </label> 
			<br><br>
			<span style="font-weight: bold;">成品计数质检：</span>
			<label><input name="permissionOption2" type="checkbox" value="131" />成品计数质检新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="132" />成品计数质检修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="133" />成品计数质检删除 </label>  
			<br><br>
			<span style="font-weight: bold;">成品计量质检：</span>
			<label><input name="permissionOption2" type="checkbox" value="141" />成品计量质检新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="142" />成品计量质检修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="143" />成品计量质检删除 </label> 
			<br><br>
			<span style="font-weight: bold;">工序计数质检：</span>
			<label><input name="permissionOption2" type="checkbox" value="151" />工序计数质检新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="152" />工序计数质检修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="153" />工序计数质检删除 </label>  
			<br><br>
			<span style="font-weight: bold;">工序计量质检：</span>
			<label><input name="permissionOption2" type="checkbox" value="161" />工序计量质检新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="162" />工序计量质检修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="163" />工序计量质检删除 </label>
			<br><br>
			<span style="font-weight: bold;">不合格品申请：</span>
			<label><input name="permissionOption2" type="checkbox" value="171" />不合格品申请新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="172" />不合格品申请修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="173" />不合格品申请删除 </label>   
			<br><br>
			<span style="font-weight: bold;">设备台账管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="231" />设备台账新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="232" />设备台账修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="233" />设备台账删除 </label> 
			<br><br>
			<span style="font-weight: bold;">设备种类管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="271" />设备种类新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="272" />设备种类修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="273" />设备种类删除 </label> 
			<br><br>
			<span style="font-weight: bold;">设备例检管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="241" />设备例检新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="242" />设备例检修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="243" />设备例检删除 </label> 
			<br><br>
			<span style="font-weight: bold;">设备故障管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="251" />设备故障新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="252" />设备故障修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="253" />设备故障删除 </label> 
			<br><br>
			<span style="font-weight: bold;">设备维修管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="261" />设备维修新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="262" />设备维修修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="263" />设备维修删除 </label> 
			<br><br>
			<span style="font-weight: bold;">部门管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="41" />部门新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="42" />部门修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="43" />部门删除 </label> 
			<br><br>
			<span style="font-weight: bold;">员工管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="51" />员工新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="52" />员工修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="53" />员工删除 </label> 
			<br><br>
			<span style="font-weight: bold;">用户管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="201" />用户新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="202" />用户修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="203" />用户删除 </label> 
			<br><br>
			<span style="font-weight: bold;">角色管理：</span>
			<label><input name="permissionOption2" type="checkbox" value="211" />角色新增 </label> 
			<label><input name="permissionOption2" type="checkbox" value="212" />角色修改 </label> 
			<label><input name="permissionOption2" type="checkbox" value="213" />角色删除 </label> 
			<br><br><br>
	</form>
	<br><br>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitRoleAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearRoleAddForm()">重置</a>
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
		
		if($("input[name='permissionOption2']:checked").length>0){
			var permission = '';
			$("input[name='permissionOption2']:checked").each(function(){
				permission += $(this).val()+',';
			}); 
			$("#roleAddForm [name=permission]").val(permission);
		}

		//ajax的post方式提交表单
		//$("#roleAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("role/insert",$("#roleAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示',data.msg);
				clearRoleAddForm();
				$("#roleAddWindow").window('close');
				$("#roleList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearRoleAddForm(){
		$('#roleAddForm').form('reset');
	}
</script>
