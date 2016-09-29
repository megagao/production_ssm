<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="orderAddForm" class="orderForm" method="post">
	    <table cellpadding="5" >
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
	            <td><input class="easyui-numberbox" type="text" name="quantity" data-options="min:1,max:99999999,precision:0,required:true" /></td>
	        </tr>
	        <tr>
	            <td>税前单价:</td>
	            <td><input class="easyui-numberbox" type="text" name="unitPrice" data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td><input class="easyui-textbox" type="text" name="unit" data-options="required:true" style="width: 280px;"></input></td>
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
	            <td>商品描述:</td>
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
				clearForm()
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
