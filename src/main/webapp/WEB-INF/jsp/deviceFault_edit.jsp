<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceFaultEditForm" class="deviceFaultForm" method="post">
	    <input type="hidden" name="deviceFaultId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>设备名称:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceId" panelHeight="auto" data-options="editable:false,
	            			valueField:'deviceId',textField:'deviceName',url:'deviceList/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>故障日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceFaultDate"/>
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
	    <input type="hidden" name="deviceFaultParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceFaultEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var deviceFaultEditEditor ;
	$(function(){
		//实例化编辑器
		deviceFaultEditEditor = TAOTAO.createEditor("#deviceFaultEditForm [name=deviceFaultDetail]");
		
	});
	
	function submitDeviceFaultEditForm(){
		$.get("deviceFault/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceFaultEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			deviceFaultEditEditor.sync();
    			$.post("deviceFault/update",$("#deviceFaultEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备故障成功!','info',function(){
    						$("#deviceFaultEditWindow").window('close');
    						$("#deviceFault").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
</script>
