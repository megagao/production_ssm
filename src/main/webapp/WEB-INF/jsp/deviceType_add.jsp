<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceTypeAddForm" class="deviceTypeForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>设备种类编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceTypeId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>设备种类名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceTypeName" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>型号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceTypeModel"/>
	            </td>
	        </tr>
	        <tr>
	            <td>规格:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceTypeSpec"/>
	            </td>
	        </tr>
	        <tr>
	            <td>供应商:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceTypeSupplier"/>
	            </td>
	        </tr>
	        <tr>
	            <td>生产商:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceTypeProducer"/>
	            </td>
	        </tr>
	        <tr>
	            <td>台数:</td>
	            <td>
	            	<input class="easyui-numberbox" name="deviceTypeQuantity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>保修期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceTypeWarranty"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="deviceTypeParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddForm_deviceType()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm_deviceType()">重置</a>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		var date=new Date();
	});
	
	//提交表单
	function submitAddForm_deviceType(){
		//有效性验证
		if(!$('#deviceTypeAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		$.post("deviceType/insert",$("#deviceTypeAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增设备种类成功!');
				clearForm_deviceType();
				$("#deviceTypeAddWindow").window("close");
				$("#deviceType").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearForm_deviceType(){
		$('#deviceTypeAddForm').form('reset');
	}
	
	$('#deviceTypeStatusCombobox').combo({    
	    required:true,    
	    multiple:true   
	});
</script>
