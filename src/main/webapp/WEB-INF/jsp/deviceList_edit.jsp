<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceEditForm" class="deviceForm" method="post">
	    <input type="hidden" name="deviceId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>设备名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceName" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>设备种类:</td>
	            <td>
	            	<input id="deviceTypeName" class="easyui-combobox" name="deviceTypeId" panelHeight="auto"
    					data-options="required:true,editable:false,valueField:'deviceTypeId',textField:'deviceTypeName',
    					url:'deviceType/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>设备状态:</td>
	            <td>
	            	<select id="deviceStatusCombobox" class="easyui-combobox" name="deviceStatusId" panelHeight="auto"
							style="width:173px" editable=false>
						<option value="1">良好</option>
						<option value="2">故障</option>
						<option value="3">维修</option>
						<option value="4">报废</option> 
					</select>
	            </td>
	        </tr>
	        <tr>
	            <td>购买日期:</td>
	            <td>
	            	<input class="easyui-datetimebox"  data-options="formatter:TAOTAO.formatDatetime"
						   name="devicePurchaseDate"/>
	            </td>
	        </tr>
	        
	        <tr>
	            <td>购买价格:</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" maxlength="11" name="devicePurchasePrice"/>
	            </td>
	        </tr>
	        <tr>
	            <td>出厂日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceManufactureDate"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>使用年限:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceServiceLife"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>保管人:</td>
	            <td>
		            <input id="deviceKeeper" class="easyui-combobox" name="deviceKeeperId" panelHeight="auto"
    					data-options="required:true,editable:false,valueField:'empId',textField:'empName',
    					url:'employee/get_data'" />
				</td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="deviceParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var deviceEditEditor ;
	$(function(){
		//实例化编辑器
		deviceEditEditor = TAOTAO.createEditor("#deviceEditForm [name=note]");
		
	});
	
	function submitDeviceEditForm(){
		$.get("deviceList/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			deviceEditEditor.sync();
    			$.post("deviceList/update",$("#deviceEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备成功!','info',function(){
    						$("#deviceEditWindow").window('close');
    						$("#deviceList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
</script>
