<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="technologyAddForm" class="technologyForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>工艺编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="technologyId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="technologyName" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>外协价格:</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" maxlength="10" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>瓶颈工序工期:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="vitalProcessPeriod"/>
	            </td>
	        </tr>
	        <tr>
	            <td>标准加工能力:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="standardCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>加班标准加工能力:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="overtimeStandardCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>加班超额加工能力:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="overtimeOverfulfilCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>二班工序能力:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="doubleCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>超负荷工序能力:</td>
	            <td>
		            <input class="easyui-numberbox" maxlength="11" name="overfulfilCapacity"/>
				</td>
	        </tr>
	    </table>
	    <input type="hidden" name="technologyParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTechnologyAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearTechnologyAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitTechnologyAddForm(){
		//有效性验证
		if(!$('#technologyAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}

		//ajax的post方式提交表单
		//$("#technologyAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("technology/insert",$("#technologyAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增工艺成功!');
				clearTechnologyAddForm();
				$("#technologyAddWindow").window("close");
				$("#technologyList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearTechnologyAddForm(){
		$('#technologyAddForm').form('reset');
	}
</script>
