<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceAddForm" class="deviceForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>设备编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceId" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>设备名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceName" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>设备种类:</td>
	            <td>
	            	<input id="deviceTypeName" class="easyui-combobox" name="deviceTypeId" panelHeight="auto" value="01"
    					data-options="editable:false,valueField:'deviceTypeId',textField:'deviceTypeName',
    					url:'deviceType/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>设备状态:</td>
	            <td>
	            	<select id="deviceStatusCombobox" class="easyui-combobox" name="deviceStatusId" panelHeight="auto"
							data-options="required:true" style="width:173px">
						<option value="1" selected="selected">良好</option>
						<option value="2">故障</option>
						<option value="3">维修</option>
						<option value="4">报废</option>
					</select>
	            </td>
	        </tr>
	        <tr>
	            <td>购买日期:</td>
	            <td>
	            	<input id="dd" class="easyui-datetimebox"  name="devicePurchaseDate"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>购买价格:</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" maxlength="11" name="devicePurchasePrice"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>出厂日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceManufactureDate"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>使用年限:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceServiceLife"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddForm_device()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm_device()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var deviceAddEditor ;

	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		deviceAddEditor = KindEditor.create("#deviceAddForm [name=note]", TT.kingEditorParams);
		
		//
		var date=new Date();
	});
	//提交表单
	function submitAddForm_device(){
		//有效性验证
		if(!$('#deviceAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		deviceAddEditor.sync();
		//ajax的post方式提交表单
		//$("#deviceAddForm").serialize()将表单序列号为key-value形式的字符串
		console.log($("#deviceAddForm").serialize());
		$.post("deviceList/insert",$("#deviceAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增设备成功!');
				clearForm_device();
				$("#deviceAddWindow").window("close");
				$("#deviceList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearForm_device(){
		$('#deviceAddForm').form('reset');
		deviceAddEditor.html('');
	}
</script>
