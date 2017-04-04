<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="technologyPlanAddForm" class="technologyPlanForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>工艺计划编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="technologyPlanId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺名称:</td>
	            </td>
	            <td>
	            	<input class="easyui-combobox" name="technologyId" panelHeight="auto" data-options="required:true,
	            		valueField:'technologyId',textField:'technologyName',url:'technology/get_data',editable:false"/>
	            </td>
	        </tr>
	        <tr>
	            <td>批次数量:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="batchAmount"/>
	            </td>
	        </tr>
	        <tr>
	            <td>计划开始时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="startPlan"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>计划结束时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="endPlan"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>计划提交时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="commitPlan"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺计划开始时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="technologyStartPlan"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺计划结束时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="technologyEndPlan"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="technologyPlanParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTechnologyPlanAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearTechnologyPlanAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	//提交表单
	function submitTechnologyPlanAddForm(){
		//有效性验证
		if(!$('#technologyPlanAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//ajax的post方式提交表单
		$.post("technologyPlan/insert",$("#technologyPlanAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增工艺计划成功!');
				clearTechnologyPlanAddForm();
				$("#technologyPlanAddWindow").window("close");
				$("#technologyPlanList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearTechnologyPlanAddForm(){
		$('#technologyPlanAddForm').form('reset');
	}
</script>
