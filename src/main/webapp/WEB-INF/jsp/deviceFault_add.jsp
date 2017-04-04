<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceFaultAddEmp" class="deviceFaultForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>故障编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceFaultId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>设备名称:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceId" panelHeight="auto" value="001"
    					data-options="editable:false,valueField:'deviceId',textField:'deviceName',
    					url:'deviceList/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>故障日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceFaultDate"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>故障原因:</td>
	            <td>
	            	<input class="easyui-textbox"  name="deviceFaultCause"/>
	            </td>
	        </tr>
	        <tr>
	            <td>维修方式:</td>
	            <td>
	            	<input class="easyui-textbox" name="deviceFaultMaintenance"/>
	            </td>
	        </tr>
	        <tr>
	            <td>故障描述:</td>
	            <td>
	            	<textarea style="width:800px;height:300px;visibility:hidden;" name="deviceFaultDetail"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="deviceParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddForm_deviceFault()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm_deviceFault()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var deviceFaultAddEditor ;

	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		deviceFaultAddEditor = KindEditor.create("#deviceFaultAddEmp [name=deviceFaultDetail]", TT.kingEditorParams);
		
		//
		var date=new Date();
	});
	//提交表单
	function submitAddForm_deviceFault(){
		//有效性验证
		if(!$('#deviceFaultAddEmp').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		deviceFaultAddEditor.sync();
		//ajax的post方式提交表单
		//$("#deviceFaultAddEmp").serialize()将表单序列号为key-value形式的字符串
		console.log($("#deviceFaultAddEmp").serialize());
		$.post("deviceFault/insert",$("#deviceFaultAddEmp").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增设备故障信息成功!');
				clearForm_deviceFault();
				$("#deviceFaultAddWindow").window("close");
				$("#deviceFault").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearForm_deviceFault(){
		$('#deviceFaultAddEmp').form('reset');
		deviceFaultAddEditor.html('');
	}
</script>
