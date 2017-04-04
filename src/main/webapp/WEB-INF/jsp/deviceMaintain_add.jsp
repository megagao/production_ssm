<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="deviceMaintainAddEmp" class="deviceMaintainForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>设备维修编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceMaintainId" data-options="required:true">
	            	</input>
	            </td>
	        </tr>
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
	            		value="date.format('yyyy-MM-dd hh:mm:ss')"></input>
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
	    <input type="hidden" name="deviceParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitAddForm_deviceMaintain()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm_deviceMaintain()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	var deviceMaintainAddEditor ;

	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		deviceMaintainAddEditor = KindEditor.create("#deviceMaintainAddEmp [name=note]", TT.kingEditorParams);
		
		//
		var date=new Date();
	});
	//提交表单
	function submitAddForm_deviceMaintain(){
		//有效性验证
		if(!$('#deviceMaintainAddEmp').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		deviceMaintainAddEditor.sync();
		//ajax的post方式提交表单
		//$("#deviceMaintainAddEmp").serialize()将表单序列号为key-value形式的字符串
		console.log($("#deviceMaintainAddEmp").serialize());
		$.post("deviceMaintain/insert",$("#deviceMaintainAddEmp").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增设备维修信息成功!');
				clearForm_deviceMaintain();
				$("#deviceMaintainAddWindow").window("close");
				$("#deviceMaintain").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearForm_deviceMaintain(){
		$('#deviceMaintainAddEmp').form('reset');
		deviceMaintainAddEditor.html('');
	}
</script>
