<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="processAddForm" class="processForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>工序编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="processId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺计划编号:</td>
	            </td>
	            <td>
	            	<input class="easyui-combobox" name="technologyPlanId" panelHeight="auto"
						   data-options="required:true,valueField:'technologyPlanId',textField:'technologyPlanId',
						   url:'technologyPlan/get_data',editable:false"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工序顺序:</td>
	            <td>
	            	<input class="easyui-numberbox" name="sequence" data-options="min:1,max:99999999,precision:0"/>
	            </td>
	        </tr>
	        <tr>
	            <td>单件定额工时:</td>
	            <td>
	            	<input class="easyui-numberbox" name="quota" data-options="min:1,max:99999999,precision:0"/>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="processParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitProcessAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearProcessAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	
	//提交表单
	function submitProcessAddForm(){
		//有效性验证
		if(!$('#processAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		//ajax的post方式提交表单
		//$("#processAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("process/insert",$("#processAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增工序成功!');
				clearProcessAddForm();
				$("#processAddWindow").window("close");
				$("#processList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearProcessAddForm(){
		$('#processAddForm').form('reset');
	}
</script>
