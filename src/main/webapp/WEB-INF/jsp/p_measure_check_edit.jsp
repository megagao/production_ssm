<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="pMeasureCheckEditForm" class="pMeasureCheckForm" method="post">
		<input type="hidden" name="pMeasureCheckId"/>
	    <table cellpadding="5">
	        <tr>
	        	<td>工序编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="processId" panelHeight="auto" data-options="required:true,
	            		valueField:'processId',textField:'processId',url:'process/get_data',editable:false"/>
	            </td>
	        </tr>
	        <tr>
	            <td>检验项目:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="checkItem"/>
	            </td>  
	        </tr>
	        <tr>
	            <td>检验时间:</td>
	            <td><input class="easyui-datetimebox" name="cdate"     
        			data-options="required:true,showSeconds:true" style="width:150px"> 
        		</td>
	        </tr>
	        <tr>
	            <td>实际测量数据:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="measureData"/>
	            </td>
	        </tr>
	        <tr>
	            <td>检验人:</td>
	            <td>
	            	<input class="easyui-combobox" name="empId" panelHeight="auto" data-options="required:true,
	            		editable:false,valueField:'empId',textField:'empName',url:'employee/get_data'"/>
	            </td>
	        </tr>
	        <tr>
	            <td>检验结果:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="result"/>
	            </td>
	        </tr>
	       
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="pMeasureCheckSubmitForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	var pMeasureCheckEditEditor ;
	$(function(){
		//实例化富文本编辑器
		pMeasureCheckEditEditor = TAOTAO.createEditor("#pMeasureCheckEditForm [name=note]");
	});
	//同步kindeditor中的内容
	pMeasureCheckEditEditor.sync();
	
	function pMeasureCheckSubmitForm(){
		if(!$('#pMeasureCheckEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		pMeasureCheckEditEditor.sync();
		
		$.post("p_measure_check/update_all",$("#pMeasureCheckEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改工序计量质检成功!','info',function(){
					$("#pMeasureCheckEditWindow").window('close');
					$("#pMeasureCheckList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
</script>
