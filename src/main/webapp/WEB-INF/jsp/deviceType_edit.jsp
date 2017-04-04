<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceTypeEditForm" class="deviceTypeForm" method="post">
	    <input type="hidden" name="deviceTypeId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>设备种类名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceTypeName"/>
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
	            	<input class="easyui-datebox" name="deviceTypeWarranty" value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="deviceTypeParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceTypeEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitDeviceTypeEditForm(){
		$.get("deviceType/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceTypeEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			console.log($("#deviceTypeEditForm").serialize());
    			$.post("deviceType/update",$("#deviceTypeEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备种类成功!','info',function(){
    						$("#deviceTypeEditWindow").window('close');
    						$("#deviceType").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
</script>
