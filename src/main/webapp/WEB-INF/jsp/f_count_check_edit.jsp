<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="fCountCheckEditForm" class="fCountCheckForm" method="post">
		<input type="hidden" name="fCountCheckId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>订单编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="orderId"   
    					data-options="valueField:'orderId',textField:'orderId',url:'order/get_data',
    						required:true, editable:false, required:true" />  
	            </td>
	        </tr>
	        <tr>
	            <td>检验项目:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="checkItem"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>样本总数:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="sample"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>抽检数:</td>
	             <td>
	            	<input class="easyui-numberbox" type="text" name="checkNumber"/>
    			</td>   
	        </tr>
	        <tr>
	            <td>不合格数:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="unqualify"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>合格率:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="qualify" data-options="max:1,precision:2"/>
				</td>
	        </tr>
	          <tr>
	            <td>检验时间:</td>
	            <td>
					<input class="easyui-datetimebox" name="cdate" data-options="required:true,showSeconds:true"
						   style="width:150px">
        		</td>   
	        </tr>
	          <tr>
	            <td>实际测量数据:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="measureData"/>
    			</td>  
	        </tr>
	          <tr>
	            <td>检验人:</td>
	            <td>
	            	<input class="easyui-combobox" name="empId" panelHeight="auto" data-options="required:true,
	            	 editable:false,valueField:'empId',textField:'empName',url:'employee/get_data'"/>
    			</td>  
	        </tr>
	          <tr>
	            <td>检验结果:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="result"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="fCountCheckEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	var fCountCheckEditEditor ;
	
	$(function(){
		//实例化富文本编辑器
		fCountCheckEditEditor = TAOTAO.createEditor("#fCountCheckEditForm [name=note]");
	});
	
	//同步kindeditor中的内容
	fCountCheckEditEditor.sync();
	function fCountCheckEditForm(){
		if(!$('#fCountCheckEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		fCountCheckEditEditor.sync();
		$.post("f_count_check/update_all",$("#fCountCheckEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改表单成功!','info',function(){
					$("#fCountCheckList").datagrid("reload");
					$("#fCountCheckEditWindow").window('close');
				});
			}else{
				$.messager.alert('提示', data.msg);
			}
		});
	}
</script>
