<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="departmentAddForm" class="departmentForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>部门编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="departmentId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>部门名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="departmentName" 
	            		data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>部门职责:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="departmentParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDepartmentAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearDepartmentAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var departmentAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//departmentAddEditor = TAOTAO.createEditor("#departmentAddForm [name=file]");
		departmentAddEditor = KindEditor.create("#departmentAddForm [name=note]", TT.kingEditorParams);
	});
	
	//提交表单
	function submitDepartmentAddForm(){
		//有效性验证
		if(!$('#departmentAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的部门要求
		departmentAddEditor.sync();
		
		//ajax的post方式提交表单
		//$("#departmentAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("department/insert",$("#departmentAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增部门成功!');
				clearDepartmentAddForm();
				$("#departmentAddWindow").window('close');
				$("#departmentList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearDepartmentAddForm(){
		$('#departmentAddForm').form('reset');
		departmentAddEditor.html('');
	}
</script>
