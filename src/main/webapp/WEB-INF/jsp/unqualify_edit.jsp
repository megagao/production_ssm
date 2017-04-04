<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="unqualifyApplyEditForm" class="unqualifyApplyForm" method="post">
		<input type="hidden" name="unqualifyApplyId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>产品名称:</td>
	            <td>
	            	<input class="easyui-combobox" name="productId"  panelHeight="auto"
						   data-options="valueField:'productId',textField:'productName',url:'product/get_data',
						   required:true, editable:false"/>
	            </td>
	        </tr>
	        <tr>
	            <td>不合格项目:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="unqualifyItem"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>不合格数量:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="unqualifyCount"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>加工时间:</td>
	             <td>
					 <input class="easyui-datetimebox" name="assemblyDate"
        			data-options="required:true,showSeconds:true" style="width:150px">
				 </td>
	        </tr>
	        <tr>
	            <td>申请人:</td>
	            <td>
	            	<input class="easyui-combobox" name="empId" panelHeight="auto" data-options="required:true,
	            		editable:false,valueField:'empId',textField:'empName',url:'employee/get_data'"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>申请时间:</td>
	             <td>
					 <input class="easyui-datetimebox" name="applyDate"
        			data-options="required:true,showSeconds:true" value="5/5/2016 00:00:00" style="width:150px">
				 </td>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	var unqualifyApplyEditEditor ;
	$(function(){
		//实例化富文本编辑器
		unqualifyApplyEditEditor = TAOTAO.createEditor("#unqualifyApplyEditForm [name=note]");
	});
	//同步kindeditor中的内容
	unqualifyApplyEditEditor.sync();
	
	function submitEditForm(){
		if(!$('#unqualifyApplyEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		unqualifyApplyEditEditor.sync();
		$.post("unqualify/update_all",$("#unqualifyApplyEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改不合格品申请成功!','info',function(){
					$("#unqualifyEditWindow").window('close');
					$("#unqualifyList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
</script>
