<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="orderEditForm" class="orderForm" method="post">
		<input type="hidden" name="orderId"/>
	    <table cellpadding="5">
	         <tr>
	            <td>订购客户:</td>
	            <td>
	            	<input id="custom" class="easyui-combobox" name="customId"  panelHeight="auto"
						   data-options="required:true,valueField:'customId',textField:'customName',
						   url:'custom/get_data', editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td>订购产品:</td>
	            <td>
	            	<input id="product" class="easyui-combobox" name="productId"  panelHeight="auto" 
    					data-options="valueField:'productId',textField:'productName',url:'product/get_data',
    					editable:false, required:true" />
    			</td>  
	        </tr>
	        <tr>
	            <td>订购数量:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="quantity"
						   data-options="min:1,max:99999999,precision:0,required:true" />
				</td>
	        </tr>
	        <tr>
	            <td>税前单价:</td>
	            <td><input class="easyui-numberbox" type="text" name="unitPrice"
						   data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td><input  class="easyui-textbox" type="text" name="unit"/></td>
	        </tr>
	        <tr>
	            <td>订单状态:</td>
	            <td>
		            <select class="easyui-combobox" name="status" panelHeight="auto" data-options="required:true,
		            		width:150, editable:false">
						<option value="1">未开始</option>
						<option value="2">已开始</option>
						<option value="3">已完成</option>
						<option value="4">订单取消</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>订购日期:</td>
	            <td><input class="easyui-datetimebox" name="orderDate"     
        			data-options="required:true,showSeconds:true" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>要求日期:</td>
	            <td><input class="easyui-datetimebox" name="requestDate"     
        			data-options="required:true,showSeconds:true" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>合同扫描件:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" id="image" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>附件:</td>
	            <td>
	            	 <div id="orderEditFileUploader">上传文件</div>
	                 <input id="orderEditFile" type="hidden" name="file"/>
	            </td>
	        </tr>
	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:visible;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOrderEditForm()">提交</a>
	</div>
</div>
<script type="text/javascript">
	
	var orderEditEditor ;
	$(function(){
		//实例化富文本编辑器
		orderEditEditor = TAOTAO.createEditor("#orderEditForm [name=note]");
	});
	//同步kindeditor中的内容
	orderEditEditor.sync();
	
	function submitOrderEditForm(){
		if(!$('#orderEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		orderEditEditor.sync();
		
		$.post("order/update_all",$("#orderEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改订单成功!','info',function(){
					$("#orderEditWindow").window('close');
					$("#orderList").datagrid("reload");
				});
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
</script>
