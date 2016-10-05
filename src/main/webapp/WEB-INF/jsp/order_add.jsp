<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

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
	            	<input id="custom" class="easyui-combobox" name="customId"   
    					data-options="required:true,valueField:'customId',textField:'customName',url:'custom/get_data'" />  
	            </td>
	        </tr>
	        <tr>
	            <td>订购产品:</td>
	            <td>
	            	<input id="product" class="easyui-combobox" name="productId"   
    					data-options="valueField:'productId',textField:'productName',url:'product/get_data'" />
    			</td>  
	        </tr>
	        <tr>
	            <td>订购数量:</td>
	            <td><input class="easyui-numberbox" type="text" name="quantity" data-options="min:1,max:99999999,precision:0" /></td>
	        </tr>
	        <tr>
	            <td>税前单价:</td>
	            <td><input class="easyui-numberbox" type="text" name="unitPrice" data-options="min:1,max:99999999,precision:2" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td><input class="easyui-textbox" type="text" name="unit"></input></td>
	        </tr>
	        <tr>
	            <td>订单状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" style="width:200px;" data-options="required:true,width:150">
						<option value="1">未开始</option>
						<option value="2">已开始</option>
						<option value="3">订单取消</option>
						<option value="4">已完成</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>订购日期:</td>
	            <td><input class="easyui-datetimebox" name="orderDate"     
        			data-options="required:true,showSeconds:true" value="5/5/2016 00:00:00" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>要求日期:</td>
	            <td><input class="easyui-datetimebox" name="requestDate"     
        			data-options="required:true,showSeconds:true" value="5/5/2016 00:00:00" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>合同扫描件:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>附件:</td>
	            <td>
	            	 <!--<a href="javascript:void(0)" class="easyui-linkbutton fileUpload">附件</a>  -->
	                 <!-- <input type="file" name="choosefile" value="选择文件"/>
	                 <input type="hidden" name="file"/>
	                 <button onclick="uploadFile()">上传</button> -->
	                 <!-- <iframe src="file_upload.jsp"></iframe>  -->
	                 <div id="fileuploader">上传文件</div>
	                 <input type="hidden" name="file"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
$(document).ready(function() {
	$("#fileuploader").uploadFile({
		url:"file/upload",
		maxFileCount: 5,                //上传文件个数（多个时修改此处
	    returnType: 'json',              //服务返回数据
	    allowedTypes: 'word,sql,txt,ppt,pdf',  //允许上传的文件式
	    showDone: false,                     //是否显示"Done"(完成)按钮
	    showDelete: true,                  //是否显示"Delete"(删除)按钮
	    deleteCallback: function(data,pd)
	    {
	        //文件删除时的回调方法。
	        //如：以下ajax方法为调用服务器端删除方法删除服务器端的文件
	        var fileUrl = data.url;
	        $.ajax({
	            cache: false,
	            url: "file/delete",
	            dataType: "json",
	            data: {fileName:data.url},
	            success: function(data) 
	            {
	                if(data.data=="success"){
	                    pd.statusbar.hide();        //删除成功后隐藏进度条等
	                    $('#image').val('');
	                    var urls = $('#orderAddForm [name=file]').val().split(",");  //将删除的文件url从urls中移除
	                    var deletedUrls = [];
	                	for(var i in urls){
	                		if(urls[i] != fileUrl){
	                			deletedUrls.push(urls[i]);
	                		}
	                	}
	                	deletedUrls = deletedUrls.join(",");
	                	$('#orderAddForm [name=file]').val(deletedUrls);
	                 }else{
	                        console.log(data.message);  //打印服务器返回的错误信息
	                 }
	              }
	        }); 
	    },
	    onSuccess: function(files,data,xhr,pd)
	    {
	        //上传成功后的回调方法。本例中是将返回的文件名保到一个hidden类开的input中，以便后期数据处理
	        if(data&&data.error==0){
	        	$.messager.alert('提示','上传完成!');
	        	if( $('#orderAddForm [name=file]').val() != null && $('#orderAddForm [name=file]').val() != ''){
	        		/* alert($('#orderAddForm [name=file]').val()); */
	        		$('#orderAddForm [name=file]').val($('#orderAddForm [name=file]').val()+","+data.url);
	        	}else{
	            	$('#orderAddForm [name=file]').val(data.url);
	        	}
	        }
	    }
	});
});
	
	var orderAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//orderAddEditor = TAOTAO.createEditor("#orderAddForm [name=file]");
		orderAddEditor = KindEditor.create("#orderAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "orderAddForm");
		}});
	});
	
 	function uploadFile(){
		$.post("file/upload",$("#orderAddForm [name=choosefile]"), function(data){
			if(data.error == 0){
				$.messager.alert('提示','新增商品成功!');
			}
		});
	} 
	
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#orderAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//取商品价格，单位为“分”
		$("#orderAddForm [name=price]").val(eval($("#orderAddForm [name=priceView]").val()) * 100);
		//同步文本框中的商品描述
		orderAddEditor.sync();
		//取商品的规格
		var paramJson = [];
		$("#orderAddForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		});
		//把json对象转换成字符串
		paramJson = JSON.stringify(paramJson);
		$("#orderAddForm [name=orderParams]").val(paramJson);
		
		//ajax的post方式提交表单
		//$("#orderAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("order/insert",$("#orderAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增商品成功!');
				clearForm();
			}
		});
	}
	
	function clearForm(){
		$('#orderAddForm').form('reset');
		orderAddEditor.html('');
	}
	$('#cc').combo({    
	    required:true,    
	    multiple:true   
	});
</script>
