<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceMaintainEditForm" class="deviceMaintainForm" method="post">
	    <input type="hidden" name="deviceMaintainId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>故障编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceFaultId" panelHeight="auto" value="001"
    					data-options="editable:false,valueField:'deviceFaultId',textField:'deviceFaultId',
    						url:'deviceFault/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>维修人:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceMaintainEmpId" panelHeight="auto" value="001"
    					data-options="required:true,editable:false,valueField:'empId',textField:'empName',
    						url:'employee/get_data', required:true" />
	            </td>
	        </tr>
	        <tr>
	            <td>维修日期:</td>
	            <td>
	            	<input class="easyui-datetimebox"  name="deviceMaintainDate" 
	            		value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>维修结果:</td>
	            <td>
	            	<input class="easyui-textbox" name="deviceMaintainResult"/>
	            </td>
	        </tr>
	        <tr>
	            <td>维修费用:</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" maxlength="10" name="deviceMaintainCost"/>
	            </td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td>
	            	<textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="deviceMaintainParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceMaintainEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var deviceMaintainEditEditor ;
	$(function(){
		//实例化编辑器
		deviceMaintainEditEditor = TAOTAO.createEditor("#deviceMaintainEditForm [name=note]");
	});
	
	function submitDeviceMaintainEditForm(){
		$.get("deviceMaintain/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceMaintainEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			deviceMaintainEditEditor.sync();
    			$.post("deviceMaintain/update",$("#deviceMaintainEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备维修成功!','info',function(){
    						$("#deviceMaintainEditWindow").window('close');
    						$("#deviceMaintain").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
</script>
