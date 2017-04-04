<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="materialEditForm" class="materialForm" method="post">
		<input type="hidden" name="materialId"/>
	    <table cellpadding="5">
	        
	       <!--   <tr>
	            <td>所属工作号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="workId" style="width: 280px;"></input>
	            </td>
	        </tr>-->
	        <tr>
	            <td>物料类型:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="materialType" style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>物料状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" panelHeight="auto" style="width:160px;"
							data-options="width:160, editable:false">
						<option value="充足">充足</option>
						<option value="正常">正常</option>
						<option value="短缺">短缺</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>剩余数量:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="remaining" style="width: 160px;"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var materialEditEditor ;
	$(function(){
		//实例化编辑器
		materialEditEditor = TAOTAO.createEditor("#materialEditForm [name=note]");
	});
	
	function submitMaterialEditForm(){
		$.get("material/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#materialEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			materialEditEditor.sync();
    			$.post("material/update_all",$("#materialEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改成功!','info',function(){
    						$("#materialEditWindow").window('close');
    						$("#materialList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});	
	}
</script>
