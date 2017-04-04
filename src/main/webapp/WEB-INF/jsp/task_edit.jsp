<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="taskEditForm" class="taskForm" method="post">
		<input type="hidden" name="taskId"/>
	    <table cellpadding="5">
	    	<tr>
	            <td>作业编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="workId"  panelHeight="auto"
    					data-options="valueField:'workId',textField:'workId',url:'work/get_data', 
    						editable:false, required:true" />
    			</td>  
	        </tr>
	        <tr>
	            <td>生产批号:</td>
	            <td>
	            	<input class="easyui-combobox" name="manufactureSn"   panelHeight="auto"
    						data-options="valueField:'manufactureSn',textField:'manufactureSn',
    						url:'manufacture/get_data', editable:false, required:true" />
    			</td>  
	        </tr>
	        <tr>
	            <td>派工数量:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="taskQuantity"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>派工工时:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="workingHours"/>
    			</td>  
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTaskEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitTaskEditForm(){
		if(!$('#taskEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("task/update_all",$("#taskEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改生产派工成功!','info',function(){
					$("#taskEditWindow").window('close');
					$("#taskList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
</script>
