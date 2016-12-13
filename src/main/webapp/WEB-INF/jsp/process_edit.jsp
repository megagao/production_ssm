<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="processEditForm" class="processForm" method="post">
		<input type="hidden" name="processId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>工艺计划编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="technologyPlanId" panelHeight="auto"  
    					data-options="required:true,valueField:'technologyPlanId',textField:'technologyPlanId',url:'technologyPlan/get_data',editable:false" /> 
	            </td>
	        </tr>
	        <tr>
	            <td>工序顺序:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="sequence"> </td>
	            </td>
	        </tr>
	          
	        <tr>
	            <td>单件定额工时:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="quota"></input>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding-top:20px;">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitProcessEditForm()">&nbsp;&nbsp;提交&nbsp;&nbsp;</a>
	</div>
</div>

<script type="text/javascript">
	
	function submitProcessEditForm(){
		$.get("process/edit_judge",'',function(data){
    		/* if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ */
    			if(!$('#processEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			
    			$.post("process/update_all",$("#processEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改工序成功!','info',function(){
    						$("#processEditWindow").window('close');
    						$("#processList").datagrid("reload");
    						$("#processInfoWindow").window('close');
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		//}
    	});
		
	}
</script>
