<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="departmentEditForm" class="departmentForm" method="post">
		<input type="hidden" name="departmentId"/>
	    <table cellpadding="5">
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
	                <textarea style="width:800px;height:400px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDepartmentEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var departmentEditEditor ;
	
	$(function(){
		//实例化富文本编辑器
		departmentEditEditor = TAOTAO.createEditor("#departmentEditForm [name=note]");
	});
	//同步kindeditor中的内容
	departmentEditEditor.sync();
	
	function submitDepartmentEditForm(){
		$.get("department/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#departmentEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			departmentEditEditor.sync();
    			
    			$.post("department/update_all",$("#departmentEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改部门成功!','info',function(){
    						$("#departmentEditWindow").window('close');
    						$("#departmentList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
</script>
