<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="technologyRequirementAddForm" class="technologyRequirementForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>工艺要求编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="technologyRequirementId"
						   data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺名称:</td>
	            </td>
	            <td>
	            	<input class="easyui-combobox" name="technologyId" panelHeight="auto" 
    					data-options="required:true,valueField:'technologyId',textField:'technologyName',
    						url:'technologyRequirement/get_data',editable:false" />  
	            </td>
	        </tr>
	        <tr>
	            <td>工艺要求添加时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="addTime"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺要求修改时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" type="text" name="reviseTime"
						   value="date.format('yyyy-MM-dd hh:mm:ss')"/>
	            </td>
	        </tr>
	         <tr>
	            <td>工艺要求:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="requirement"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="technologyRequirementParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTechnologyRequirementAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearTechnologyRequirementAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var technologyRequirementAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		technologyRequirementAddEditor = KindEditor.create("#technologyRequirementAddForm [name=requirement]",
				TT.kingEditorParams);
	});
	
	//提交表单
	function submitTechnologyRequirementAddForm(){
		//有效性验证
		if(!$('#technologyRequirementAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		//同步文本框中的订单要求
		technologyRequirementAddEditor.sync();
		
		//ajax的post方式提交表单
		//$("#technologyRequirementAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("technologyRequirement/insert",$("#technologyRequirementAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增工艺要求成功!');
				clearTechnologyRequirementAddForm();
				$("#technologyRequirementAddWindow").window("close");
				$("#technologyRequirementList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearTechnologyRequirementAddForm(){
		$('#technologyRequirementAddForm').form('reset');
	}
</script>
