<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="measureAddForm" class="measureForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>成品计量质检编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="fMeasureCheckId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>订单编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="orderId"  panelHeight="auto"
						   data-options="valueField:'orderId',textField:'orderId',url:'order/get_data',required:true,
						   editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td>检验项目:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="checkItem"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>检验时间:</td>
	            <td>
					<input class="easyui-datetimebox" name="cdate" data-options="required:true,showSeconds:true"
						   value="date.format('yyyy-MM-dd hh:mm:ss')" style="width:150px">
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
	    <input type="hidden" name="measureParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="measureSubmitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearMeasureAddForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	var measureAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//加载文件上传插件
		
		//创建富文本编辑器
		//measureAddEditor = TAOTAO.createEditor("#measureAddForm [name=file]");
		measureAddEditor = KindEditor.create("#measureAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据订单的分类id取订单 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "measureAddForm");
		}});
	});
	
	//提交表单
	function measureSubmitForm(){
		//有效性验证
		if(!$('#measureAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的订单要求
		measureAddEditor.sync();
		
		$.post("measure/insert",$("#measureAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成品计量质检成功!');
				clearMeasureAddForm();
				$("#measureAddWindow").window('close');
				$("#measureList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			} 
		});
	}
	
	function clearMeasureAddForm(){
		$('#measureAddForm').form('reset');
		measureAddEditor.html('');
	}
</script>
