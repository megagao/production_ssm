<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">

<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>

<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<div style="padding:10px 10px 10px 10px">
	<form id="pMeasureCheckAddForm" class="pMeasureCheckForm" method="post">
	    <table cellpadding="5" >
	        <tr>
	            <td>工序计量质检编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="pMeasureCheckId" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>工序编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="processId" panelHeight="auto" data-options="required:true,
	            		valueField:'processId',textField:'processId',url:'process/get_data',editable:false"/>
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
	    <input type="hidden" name="pMeasureCheckParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="pMeasureChecksubmitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearPMeasureCheckForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	var pMeasureCheckAddEditor  ;
	//页面初始化完毕后执行此方法
	$(function(){
		//加载文件上传插件
		
		//创建富文本编辑器
		//pMeasureCheckAddEditor  = TAOTAO.createEditor("#pMeasureCheckAddForm [name=file]");
		pMeasureCheckAddEditor  = KindEditor.create("#pMeasureCheckAddForm [name=note]", TT.kingEditorParams);
		//初始化类目选择和图片上传器
		TAOTAO.init({fun:function(node){
			//根据订单的分类id取订单 的规格模板，生成规格信息。第四天内容。
			TAOTAO.changeItemParam(node, "pMeasureCheckAddForm");
		}});
	});
	
	//提交表单
	function pMeasureChecksubmitForm(){
		//有效性验证
		if(!$('#pMeasureCheckAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的订单要求
		pMeasureCheckAddEditor .sync();
		
		//ajax的post方式提交表单
		$.post("p_measure_check/insert",$("#pMeasureCheckAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增工序计量质检成功!');
				clearPMeasureCheckForm();
				$("#pMeasureCheckAddWindow").window('close');
				$("#pMeasureCheckList").datagrid("reload");
			}else{
				$.messager.alert('提示',data.msg);
			}
		});
	}
	
	function clearPMeasureCheckForm(){
		$('#pMeasureCheckAddForm').form('reset');
		pMeasureCheckAddEditor .html('');
	}
</script>
