<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="materialAddForm" class="materialForm" method="post">
	    <table cellpadding="5" >
	         <tr>
	            <td>物料编号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="materialId" data-options="required:true"
						   style="width: 160px;"/>
	            </td>
	        </tr>
	     <!--   <tr>
	            <td>所属工作号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="workId" style="width: 280px;"></input>
	            </td>
	        </tr>-->
	        <tr>
	            <td>物料类型:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="materialType" style="width: 160px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>物料状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" panelHeight="auto" style="width: 160px;"
							data-options="editable:false">
						<option value="充足">充足</option>
						<option value="正常">正常</option>
						<option value="短缺">短缺</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>剩余数量:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="remaining" style="width: 160px;"/>
	            </td>
	        </tr>
	        
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="materialParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialAddForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearMaterialForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	var materialAddEditor ;
	//页面初始化完毕后执行此方法
	$(function(){
		//创建富文本编辑器
		//customAddEditor = TAOTAO.createEditor("#customAddForm [name=file]");
		materialAddEditor = KindEditor.create("#materialAddForm [name=note]", TT.kingEditorParams);
	});
	//提交表单
	function submitMaterialAddForm(){
		//有效性验证
		if(!$('#materialAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的备注
		materialAddEditor.sync();
		//ajax的post方式提交表单
		//$("#customAddForm").serialize()将表单序列号为key-value形式的字符串
		$.post("material/insert",$("#materialAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增成功!');
				clearMaterialForm();
				updateMaterialForm();	
			}else{
				$.messager.alert('提示',data.msg);
			}  
		}
		
		);
	}
	
	function clearMaterialForm(){
		$('#materialAddForm').form('reset');
		materialAddEditor.html('');
	}
	$('#cc').combo({    
	    required:true,    
	    multiple:true   
	});
	function updateMaterialForm(){
			$("#materialAddWindow").window('close');
			$("#materialList").datagrid("reload");
	}
</script>
