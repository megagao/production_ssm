<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="technologyPlanEditForm" class="technologyPlanForm" method="post">
		<input type="hidden" name="technologyPlanId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>工艺名称:</td>
	            <td>
	            	
	            	<input class="easyui-combobox" name="technologyId" panelHeight="auto"  
    					data-options="required:true,valueField:'technologyId',textField:'technologyName',
    						url:'technology/get_data',editable:false" /> 
	            </td>
	        </tr>
	        <tr>
	            <td>批次数量:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="batchAmount"/>
	            </td>
	        </tr>
	        <tr>
	            <td>计划开始时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="startPlan"     
        			data-options="required:true,showSeconds:true"> 
        		</td>
	        </tr>
	          
	        <tr>
	            <td>计划结束时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="endPlan"/>
	            </td>
	        </tr>
	        <tr>
	            <td>计划提交时间:</td>
	            <td>
	            	<input class="easyui-datetimebox"  name="commitPlan"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺计划开始时间:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="technologyStartPlan"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工艺计划结束时间:</td>
	            <td>
		            <input class="easyui-datetimebox" name="technologyEndPlan"/>
				</td>
	        </tr>
	         
	    </table>
	</form>
	<div style="padding-top:20px;">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTechnologyPlanEditForm()">
			&nbsp;&nbsp;提交&nbsp;&nbsp;
		</a>
	</div>
</div>
<script type="text/javascript">
	
	function submitTechnologyPlanEditForm(){
		$.get("technologyPlan/edit_judge",'',function(data){
    		/* if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ */
    			if(!$('#technologyPlanEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			
    			$.post("technologyPlan/update_all",$("#technologyPlanEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改工艺计划成功!','info',function(){
    						$("#technologyPlanEditWindow").window('close');
    						$("#technologyPlanList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    	});
	}
</script>
