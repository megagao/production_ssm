<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="materialConsumeAddForm" class="materialConsumeForm" method="post">
	    <table cellpadding="5" >
	         <tr>
	            <td>物料消耗编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="consumeId" data-options="required:true"
						   style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>所属工作:</td>
	            <td>
	            	<input class="easyui-combobox" name="workId"  panelHeight="auto"
    					data-options="required:true,valueField:'workId',textField:'workId',url:'work/get_data'"
						   style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>物料:</td>
	            <td>
	            	<input class="easyui-combobox" name="materialId"  panelHeight="auto" data-options="required:true,
	            	valueField:'materialId',textField:'materialId',url:'material/get_data',
	            	editable:false" style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>消耗数量:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="consumeAmount" style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>消耗日期:</td>
	            <td>
					<input class="easyui-datetimebox" name="consumeDate"
        			data-options="required:true,showSeconds:true" value="date.format('yyyy-MM-dd hh:mm:ss')"
						   style="width:160px">
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
	    <input type="hidden" name="materialConsumeParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialConsumeAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearMaterialConsumeForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	
	var materialConsumeAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//customAddEditor = TAOTAO.createEditor("#customAddForm [name=file]");
		materialConsumeAddEditor = KindEditor.create("#materialConsumeAddForm [name=note]", TT.kingEditorParams);
	});
	//提交表单
	function submitMaterialConsumeAddForm(){
		//有效性验证
		if(!$('#materialConsumeAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		materialConsumeAddEditor.sync();
		//ajax的post方式提交表单
		//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("materialConsume/insert",$("#materialConsumeAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成功!');
				clearMaterialConsumeForm();				
				$("#materialConsumeAddWindow").window('close');
				$("#materialConsumeList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}  
		}
		);
	}
	
	function clearMaterialConsumeForm(){
		$('#materialConsumeAddForm').form('reset');
		materialConsumeAddEditor.html('');
	}
</script>
