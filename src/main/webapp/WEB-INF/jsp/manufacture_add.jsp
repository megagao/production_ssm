<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="manufactureAddForm" class="manufactureForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>生产批号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="manufactureSn" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>订单编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="orderId"  panelHeight="auto" data-options="required:true,
	            		valueField:'orderId',textField:'orderId',url:'order/get_data', editable:false"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺:</td>
	            <td>
	            	<input class="easyui-combobox" name="technologyId"  panelHeight="auto"
						   data-options="valueField:'technologyId',textField:'technologyName',url:'technology/get_data',
						   editable:false, required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>投产数量:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="launchQuantity"
						   data-options="min:1,max:99999999,precision:0"/>
				</td>
	        </tr>
	        <tr>
	            <td>订购日期:</td>
	            <td>
					<input class="easyui-datetimebox" name="beginDate"
        				data-options="showSeconds:true"  value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px">
				</td>
	        </tr>
	        <tr>
	            <td>要求日期:</td>
	            <td>
					<input class="easyui-datetimebox" name="endDate"
        				data-options="showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px">
				</td>
	        </tr>
	    </table>
	</form>
	<br><br>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitManufactureAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearManufactureAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitManufactureAddForm(){
		//有效性验证
		if(!$('#manufactureAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		//ajax的post方式提交表单
		//$("#manufactureAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("manufacture/insert",$("#manufactureAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示', '新增生产计划成功!');
				clearManufactureAddForm();
				$("#manufactureAddWindow").window('close');
				$("#manufactureList").datagrid("reload");
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
	
	function clearManufactureAddForm(){
		$('#manufactureAddForm').form('reset');
	}
</script>
