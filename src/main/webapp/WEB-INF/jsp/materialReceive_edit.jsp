
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="materialReceiveEditForm" class="materialReceiveForm" method="post">
		<input type="hidden" name="receiveId"/>
	    <table cellpadding="5">	
	    	<tr>
	            <td>物料编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="materialId"  panelHeight="auto" data-options="required:true,
	            		valueField:'materialId',textField:'materialId',url:'material/get_data', editable:false"
						style="width: 160px;"/>
	            </td>
	        </tr>       	     
	        <tr>
	            <td>收入数量:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="ammount" style="width: 160px;"/>
	            </td>
	        </tr>
	        </tr>
	         <tr>
	            <td>收入日期:</td>
	            <td><input class="easyui-datetimebox" name="receiveDate"     
        			data-options="required:true,showSeconds:true" style="width:160px"> </td>
	        </tr>  	        
	        <tr>
	            <td>发送者:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="sender" style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>接收者:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="receiver" style="width: 160px;"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialReceiveEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var materialReceiveEditEditor ;
	$(function(){
		//实例化编辑器
		materialReceiveEditEditor = TAOTAO.createEditor("#materialReceiveEditForm [name=note]");
	});
	
	function submitMaterialReceiveEditForm(){
		$.get("materialReceive/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#materialReceiveEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			materialReceiveEditEditor.sync();
    			$.post("materialReceive/update_all",$("#materialReceiveEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改成功!','info',function(){
    						$("#materialReceiveEditWindow").window('close');
    						$("#materialReceiveList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				} 
    			});
    		}
    	});	
	}
</script>
