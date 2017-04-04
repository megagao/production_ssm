<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="workEditForm" class="workForm" method="post">
		<input type="hidden" name="workId"/>
	    <table cellpadding="5">
	    	<tr>
	            <td>工序号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="processNumber" data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>产品:</td>
	            <td>
	            	<input class="easyui-combobox" name="productId"   panelHeight="auto"
    					data-options="valueField:'productId',textField:'productName',url:'product/get_data', 
    						editable:false, required:true" />
    			</td>  
	        </tr>
	        <tr>
	            <td>工序:</td>
	            <td>
	            	<input class="easyui-combobox" name="processId"   panelHeight="auto"
    					data-options="valueField:'processId',textField:'processId',url:'process/get_data',
    						 editable:false, required:true" />
    			</td>  
	        </tr>
	        <tr>
	            <td>设备:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceId"   panelHeight="auto"
    					data-options="valueField:'deviceId',textField:'deviceName',url:'deviceList/get_data',
    						 editable:false, required:true" />
    			</td>  
	        </tr>
	        <tr>
	            <td>班产定额:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="rating"/>
    			</td>  
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitWorkEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	function submitWorkEditForm(){
		if(!$('#workEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		$.post("work/update_all",$("#workEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改作业成功!','info',function(){
					$("#workEditWindow").window('close');
					$("#workList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
</script>
