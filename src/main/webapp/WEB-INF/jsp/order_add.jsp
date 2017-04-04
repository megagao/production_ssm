<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="orderAddForm" class="orderForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>订单编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="orderId" data-options="required:true"></input>
	            </td>
	        </tr>
	        <tr>
	            <td>订购客户:</td>
	            <td>
	            	<input id="custom" class="easyui-combobox" name="customId"  panelHeight="auto"
    					data-options="required:true,valueField:'customId',textField:'customName',url:'custom/get_data',
    					editable:false" />
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
						   data-options="min:1,max:99999999,precision:0"/>
				</td>
	        </tr>
	        <tr>
	            <td>税前单价:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="unitPrice"
						   data-options="min:1,max:99999999,precision:2" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td><input class="easyui-textbox" type="text" name="unit"/></td>
	        </tr>
	        <tr>
	            <td>订单状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" panelHeight="auto"
							data-options="required:true, width:150, editable:false">
						<option value="1">未开始</option>
						<option value="2">已开始</option>
						<option value="3">已完成</option>
						<option value="4">订单取消</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>订购日期:</td>
	            <td>
					<input class="easyui-datetimebox" name="orderDate" data-options="required:true,showSeconds:true"
						   value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px">
				</td>
	        </tr>
	        <tr>
	            <td>要求日期:</td>
	            <td>
					<input class="easyui-datetimebox" name="requestDate" data-options="required:true,showSeconds:true"
						   value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px">
				</td>
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
	                 <!-- <iframe src="file_upload.jsp"></iframe>  -->
	                 <div id="orderAddFileUploader">上传文件</div>
	                 <input type="hidden" id="orderAddFile" name="file"/>
	            </td>
	        </tr>
	        <tr>
	            <td>订单要求:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="orderParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOrderAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearOrderADDForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	var orderAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//加载文件上传插件
		initOrderAddFileUpload();
		//创建富文本编辑器
		//orderAddEditor = TAOTAO.createEditor("#orderAddForm [name=file]");
		orderAddEditor = KindEditor.create("#orderAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据订单的分类id取订单 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "orderAddForm");
		}});
	});
	
	//提交表单
	function submitOrderAddForm(){
		//有效性验证
		if(!$('#orderAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的订单要求
		orderAddEditor.sync();
		
		//ajax的post方式提交表单
		//$("#orderAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("order/insert",$("#orderAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增订单成功!');
				clearOrderADDForm();
				$("#orderAddWindow").window('close');
				$(".picFileUpload").siblings("div.pics").find("ul > li").remove();
				$(".ajax-file-upload-container > .ajax-file-upload-statusbar").remove();
				$("#orderList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearOrderADDForm(){
		$('#orderAddForm').form('reset');
		orderAddEditor.html('');
	}
</script>
