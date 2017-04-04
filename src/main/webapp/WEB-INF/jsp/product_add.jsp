<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="productAddForm" class="productForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>产品编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="productId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>产品名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="productName" data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>产品种类:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="productType" data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>产品状态:</td>
	            <td>
		            <select class="easyui-combobox" name="status" panelHeight="auto" data-options="required:true,
		            		width:150, editable:false">
						<option value="1">有效产品</option>
						<option value="2">停产</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>相关图片:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton productPicFileUpload">上传图片</a>
	                 <input type="hidden" id="productImage" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>产品介绍:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="productParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitProductAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearProductAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	var productAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//productAddEditor = TAOTAO.createEditor("#productAddForm [name=file]");
		productAddEditor = KindEditor.create("#productAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.initProductPicUpload({fun:function(node){
			//根据产品的分类id取产品 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "productAddForm");
		}});
	});
	
	//提交表单
	function submitProductAddForm(){
		//有效性验证
		if(!$('#productAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的产品要求
		productAddEditor.sync();
		
		//ajax的post方式提交表单
		//$("#productAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("product/insert",$("#productAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增产品成功!');
				clearProductAddForm();
				$("#productAddWindow").window('close');
				$(".productPicFileUpload").siblings("div.pics").find("ul > li").remove();
				$("#productList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearProductAddForm(){
		$('#productAddForm').form('reset');
		productAddEditor.html('');
	}
</script>
