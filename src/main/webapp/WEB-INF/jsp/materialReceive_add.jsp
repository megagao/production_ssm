<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="materialReceiveAddForm" class="materialReceiveForm" method="post">
	    <table cellpadding="5" >
	         <tr>
	            <td>物料收入编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="receiveId" data-options="required:true"
						   style="width: 160px;"/>
	            </td>
	        </tr>
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
	            	<input class="easyui-textbox" type="text" name="ammount" style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>收入日期:</td>
	            <td>
					<input class="easyui-datetimebox" name="receiveDate" data-options="required:true,showSeconds:true"
						   value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:160px">
				</td>
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
	    <input type="hidden" name="materialReceiveParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialReceiveAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearMaterialReceiveForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	
	var materialReceiveAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//customAddEditor = TAOTAO.createEditor("#customAddForm [name=file]");
		materialReceiveAddEditor = KindEditor.create("#materialReceiveAddForm [name=note]", TT.kingEditorParams);
	});
	//提交表单
	function submitMaterialReceiveAddForm(){
		//有效性验证
		if(!$('#materialReceiveAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		materialReceiveAddEditor.sync();
		//ajax的post方式提交表单
		//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("materialReceive/insert",$("#materialReceiveAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成功!');
				clearMaterialReceiveForm();				
				updateMaterialReceiveForm();	
			}else{
				$.messager.alert('提示',data.msg);
			}  
		}
		);
	}
	
	function clearMaterialReceiveForm(){
		$('#materialReceiveAddForm').form('reset');
		materialReceiveAddEditor.html('');
	}
	$('#cc').combo({    
	    required:true,    
	    multiple:true   
	});
	function updateMaterialReceiveForm(){
			$("#materialReceiveAddWindow").window('close');
			$("#materialReceiveList").datagrid("reload");
	}
</script>
