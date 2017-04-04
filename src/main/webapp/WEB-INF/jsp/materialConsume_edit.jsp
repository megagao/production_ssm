<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script src="js/malsup.github.iojquery.form.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="materialConsumeEditForm" class="materialConsumeForm" method="post">
		<input type="hidden" name="consumeId"/>
	    <table cellpadding="5">
	         <tr>
	            <td>所属作业:</td>
	            <td>
	            	<input id="work" class="easyui-combobox" name="workId"  panelHeight="auto"
						   data-options="required:true,valueField:'workId',textField:'workId',url:'work/get_data'"
						   style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>物料:</td>
	            <td>
	            	<input id="material" class="easyui-combobox" name="materialId"  panelHeight="auto"
    					data-options="valueField:'materialId',textField:'materialId',url:'material/get_data',
    					required:true" style="width: 160px;, editable:false"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>消耗数量:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="consumeAmount"
						   data-options="min:1,max:99999999,precision:0,required:true" style="width: 160px;"/>
				</td>
	        </tr>
	         <tr>
	            <td>消耗日期:</td>
	            <td><input class="easyui-datetimebox" name="consumeDate"     
        			data-options="required:true,showSeconds:true" style="width:160px"> </td>
	        </tr>  	        
	        <tr>
	            <td>发送者:</td>
	            <td>
					<input class="easyui-textbox" type="text" name="sender"
						   data-options="min:1,max:99999999,precision:2,required:true" style="width: 160px;"/>
	            </td>	
	         </tr>   
	         <tr>
	            <td>接收者:</td>
	            <td>
					<input class="easyui-textbox" type="text" name="receiver"
						   data-options="min:1,max:99999999,precision:2,required:true" style="width: 160px;"/>
	            </td>	
	         </tr>        	         
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:visible;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialConsumeEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	var materialConsumeEditEditor ;
	$(function(){
		//实例化富文本编辑器
		materialConsumeEditEditor = TAOTAO.createEditor("#materialConsumeEditForm [name=note]");
	});
	//同步kindeditor中的内容
	materialConsumeEditEditor.sync();
	
	function submitMaterialConsumeEditForm(){
		if(!$('#materialConsumeEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		materialConsumeEditEditor.sync();
		
		$.post("materialConsume/update_all",$("#materialConsumeEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改成功!','info',function(){
					$("#materialConsumeEditWindow").window('close');
					$("#materialConsumeList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示',data.msg);
			}  
		});
	}
</script>
