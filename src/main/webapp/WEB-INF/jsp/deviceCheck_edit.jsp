<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceCheckEditForm" class="deviceCheckForm" method="post">
	    <input type="hidden" name="deviceCheckId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>设备名称:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceId" panelHeight="auto" 
    					data-options="editable:false,valueField:'deviceId',textField:'deviceName',
    						url:'deviceList/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>例检人:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceCheckEmpId" panelHeight="auto" 
    					data-options="required:true,editable:false,valueField:'empId',textField:'empName',
    						url:'employee/get_data'" />
	            </td>
	        </tr>
	        <tr>
	            <td>例检时间:</td>
	            <td>
	            	<input class="easyui-datetimebox"  name="deviceCheckDate" />
	            </td>
	        </tr>
	        <tr>
	            <td>例检故障编号:</td>
	            <td>
	            	<input class="easyui-textbox" name="deviceCheckFaultId"/>
	            </td>
	        </tr>
	        <tr>
	            <td>例检结果:</td>
	            <td>
	            	<textarea style="width:800px;height:300px;visibility:hidden;" name="deviceCheckResult"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="deviceCheckParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceCheckEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var deviceCheckEditEditor ;
	
	$(function(){
		//实例化编辑器
		deviceCheckEditEditor = TAOTAO.createEditor("#deviceCheckEditForm [name=deviceCheckResult]");
		
	});
	
	function submitDeviceCheckEditForm(){
		$.get("deviceCheck/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceCheckEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			deviceCheckEditEditor.sync();
    			$.post("deviceCheck/update",$("#deviceCheckEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备例检成功!','info',function(){
    						$("#deviceCheckEditWindow").window('close');
    						$("#deviceCheck").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
		
	}
</script>
