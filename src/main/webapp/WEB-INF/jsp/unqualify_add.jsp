<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="unqualifyAddForm" class="unqualifyForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>不合格产品申请编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="unqualifyApplyId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>产品名称:</td>
	            <td>
	            	<input class="easyui-combobox" name="productId"  panelHeight="auto"
    					data-options="valueField:'productId',textField:'productName',url:'product/get_data',
    						required:true, editable:false" />  
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
	             <td><input class="easyui-datetimebox" name="assemblyDate" data-options="required:true,showSeconds:true"
							value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px">
        		</td>  
	        </tr>
	        <tr>
	            <td>申请人:</td>
	            <td>
	            	<input class="easyui-combobox" name="empId" panelHeight="auto" 
    					data-options="required:true,editable:false,valueField:'empId',textField:'empName',
    						url:'employee/get_data'" />
    			</td>  
	        </tr>
	        <tr>
	            <td>申请时间:</td>
	             <td>
					 <input class="easyui-datetimebox" name="applyDate" data-options="required:true,showSeconds:true"
							value="5/5/2016 00:00:00" style="width:150px">
				 </td>
				
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="unqualifyParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="unqualifySubmitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearUnqualifyAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var unqualifyAddForm ;
	
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//unqualifyAddForm = TAOTAO.createEditor("#unqualifyAddForm [name=file]");
		unqualifyAddForm = KindEditor.create("#unqualifyAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据订单的分类id取订单 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "unqualifyAddForm");
		}});
	});
	
	//提交表单
	function unqualifySubmitForm(){
		//有效性验证
		if(!$('#unqualifyAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的订单要求
		unqualifyAddForm.sync();
		
		//ajax的post方式提交表单
		//$("#unqualifyAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("unqualify/insert",$("#unqualifyAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增不合格品申请成功!');
				clearUnqualifyAddForm();
				$("#unqualifyAddWindow").window('close');
				$("#unqualifyList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearUnqualifyAddForm(){
		$('#unqualifyAddForm').form('reset');
		unqualifyAddForm.html('');
	}
</script>
