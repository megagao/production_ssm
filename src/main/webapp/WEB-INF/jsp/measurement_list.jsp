<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table  id="measureList" title="成品计量质检	" class="easyui-datagrid"
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'measure/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_fMeasureCheck">
    <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'fMeasureCheckId',align:'center',width:100">成品计量质检编号</th>
            <th data-options="field:'orderId',align:'center',width:100,formatter:formatOrder">订单编号</th>
            <th data-options="field:'checkItem',align:'center',width:100">检验项目</th>
            <th data-options="field:'cdate',align:'center',width:100,formatter:TAOTAO.formatDateTime">检验时间</th>
            <th data-options="field:'measureData',align:'center',width:100">实际测量数据</th>
            <th data-options="field:'empId',align:'center',width:100">检验人员编号</th>
            <th data-options="field:'result',align:'center',width:100">检验结果</th>
            <th data-options="field:'note',align:'center',width:100,formatter:formatFMeasureNote">备注</th>
        </tr>
    </thead>
</table>

<!-- 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div  id="toolbar_fMeasureCheck" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='fMeasureCheck:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="fMeasureCheck_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='fMeasureCheck:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="fMeasureCheck_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='fMeasureCheck:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="fMeasureCheck_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="fMeasureCheck_reload()">刷新</a>  
	</div>  
	
    <div id="search_fMeasureCheck" style="float: right;">
        <input id="search_text_fMeasureCheck" class="easyui-searchbox"  
            data-options="searcher:doSearch_fMeasureCheck,prompt:'请输入...',menu:'#menu_fMeasureCheck'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_fMeasureCheck" style="width:120px"> 
			<div data-options="name:'fMeasureCheckId'">成品计量质检编号</div> 
			<div data-options="name:'orderId'">订单编号</div> 
		</div>     
    </div>  

</div>  

<div id="measureEditWindow" class="easyui-window" title="编辑订单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'measure/edit'" style="width:80%;height:95%;padding:10px;">
</div>
<div id="measureAddWindow" class="easyui-window" title="添加订单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'measure/add'" style="width:80%;height:95%;padding:10px;">
</div>



<!-- ********************************************************************* -->
<div id="fMeasureOrderInfo" class="easyui-dialog" title="订单信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="fMeasureOrderEditForm" method="post">
			<input type="hidden" name="orderId"/>
	    <table cellpadding="5">
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
	            <td><input  class="easyui-textbox" type="text" name="unit"></input></td>
	        </tr>
	        <tr>
	            <td>订单状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" data-options="required:true,width:150, editable:false">
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
	                 <input type="hidden" id="image" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>附件:</td>
	            <td>
	            	 <div id="fileuploader"><span id="fMeasurementFileSpan"></span></div>
	                 <input id="fMeasurementFile" type="hidden" name="file"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitfMeasureOrderEditForm()">提交</a>
	</div>
</div>

<!-- ********************************************************************* -->
<div id="fMeasureNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:55%;height:80%;padding:10px">
	<form id="fMeasureNoteForm" class="itemForm" method="post">
		<input type="hidden" name="fMeasureCheckId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateFMeasureNote()">保存</a>
	</div>
</div>
<script>
function doSearch_fMeasureCheck(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#measureList").datagrid({
	        title:'订单列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_fMeasureCheck", url:'measure/list', method:'get', loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'fMeasureCheckId', width : 100, title : '成品计量质检编号', align:'center'},
	             	{field : 'orderId', width : 100, align : 'center', title : '订单编号'},
	             	{field : 'checkItem', width : 100, align : 'center', title : '检验项目'}, 
	             	{field : 'cdate', width : 100, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime}, 
	             	{field : 'measureData', width : 100, title : '实际测量数据', align:'center'}, 
	            	{field : 'empId', width : 100, title : '检验人员编号', align:'center'}, 
	             	{field : 'result', width : 100, title : '检验结果', align:'center'}, 
	             	{field : 'note', width : 100, title : '备注', align:'center', formatter:formatFMeasureNote} 
	        ] ],  
	    });
	}else{
		$("#measureList").datagrid({  
	        title:'订单列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_fMeasureCheck", url:'measure/search_fMeasureCheck_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	                 	{field : 'ck', checkbox:true }, 
		             	{field : 'fMeasureCheckId', width : 100, title : '成品计量质检编号', align:'center'},
		             	{field : 'orderId', width : 100, align : 'center', title : '订单编号'},
		             	{field : 'checkItem', width : 100, align : 'center', title : '检验项目'}, 
		             	{field : 'cdate', width : 100, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime}, 
		             	{field : 'measureData', width : 100, title : '实际测量数据', align:'center'}, 
		            	{field : 'empId', width : 100, title : '检验人员编号', align:'center'}, 
		             	{field : 'result', width : 100, title : '检验结果', align:'center'}, 
		             	{field : 'note', width : 100, title : '备注', align:'center', formatter:formatFMeasureNote} 
	        ] ],  
	    });
	}
}

	var	fMeasureNoteEditor;
	var fMeasureCheckOrderEditor;
	
	//格式化订单信息
	function formatOrder(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openFMeasureOrder("+index+")>"+value+"</a>";
		}else{
			return "无";
		}
	};  

	//格式化备注
	function formatFMeasureNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openFMeasureNote("+index+")>"+"备注"+"</a>";
		}else{
			return "无";
		}
	}
	
	//根据index拿到该行值
	function onFMeasureClickRow(index) {
		var rows = $('#measureList').datagrid('getRows');
		return rows[index];
		
	}
	
	function  openFMeasureOrder(index){ 
		var row = onFMeasureClickRow(index);
		$("#fMeasureOrderInfo").dialog({
    		onOpen :function(){
    			$.get("order/get/"+row.orderId,'',function(data){
    				fMeasureCheckOrderEditor = TAOTAO.createEditor("#fMeasureOrderEditForm [name=note]");	
 		    		//回显数据
 	        		data.customId = data.custom.customId; 
 	        		data.productId = data.product.productId; 
 	        		data.orderDate = TAOTAO.formatDateTime(data.orderDate);
 	        		data.requestDate = TAOTAO.formatDateTime(data.requestDate);
 	        		$("#fMeasureOrderEditForm").form("load", data);
 	        		fMeasureCheckOrderEditor.html(data.note);
 	        			
 	        		TAOTAO.init({
 	        			"pics" : data.image,
 	        		});
 	        			
 	        		//加载上传过的文件
 	        		initFMeasurementUploadedFile();
    	    	});
    			
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#fMeasureOrderEditForm [name=note]");
			   	clearManuUploadedFile();
			}
    	}).dialog("open");
	};
	
	//加载上传过的文件
	function initFMeasurementUploadedFile(){
		var files = $('#fMeasurementFile').val().split(","); 
		var k = false;
		for(var i in files){
			if(files[i] !=null && files[i] != ''){
				$("#fMeasurementFileSpan").append("<tr><td><a href='file/download?fileName="+files[i]+"'>" +
						"<span style='font-size: 12px;font-family: Microsoft YaHei;'>"
						+ files[i].substring(files[i].lastIndexOf("/")+1) + "</span></td><td></a> ");
				k = true;
			}
		}
		if(!k){
			$("#fMeasurementFileSpan").html("<span style='font-size: 16px;font-family: Microsoft YaHei;'>无</span>");
		}
	}
	function clearManuUploadedFile(){
		$("#fMeasurementFileSpan").html('');
	}
	//提交订单编辑表单
	function submitfMeasureOrderEditForm(){
		$.get("order/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#fMeasureOrderEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			fMeasureCheckOrderEditor.sync();
    			
    			$.post("order/update_all",$("#fMeasureOrderEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改产品成功!','info',function(){
    						$("#fMeasureOrderInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				} 
    			});
    		}
    	});
	}
	
	//打开备注对话框
	function  openFMeasureNote(index){ 
		var row = onFMeasureClickRow(index);
		$("#fMeasureNoteDialog").dialog({
    		onOpen :function(){
    			$("#fMeasureNoteForm [name=fMeasureCheckId]").val(row.fMeasureCheckId);
    			fMeasureNoteEditor = TAOTAO.createEditor("#fMeasureNoteForm [name=note]");
    			fMeasureNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#fMeasureNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新备注
	function updateFMeasureNote(){
		$.get("measure/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			fMeasureNoteEditor.sync();
    			$.post("measure/update_note",$("#fMeasureNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#fMeasureNoteDialog").dialog("close");
    					$("#measureList").datagrid("reload");
    					$.messager.alert("操作提示", "更新备注成功！");
    				}else{
    					$.messager.alert("操作提示", "更新备注失败！");
    				}
    			});
    		}
    	});
	}
	
function getFMeasureSelectionsIds(){
    	
    	var sels = $("#measureList").datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].fMeasureCheckId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
//////////////////////////////////////////////////////////////////////////
function fMeasureCheck_add(){
	$.get("measure/add_judge",'',function(data){
   		if(data.msg != null){
   			$.messager.alert('提示', data.msg);
   		}else{
   			$("#measureAddWindow").window("open");
   		}
   	});
}

function fMeasureCheck_edit(){
	$.get("measure/edit_judge",'',function(data){
   		if(data.msg != null){
   			$.messager.alert('提示', data.msg);
   		}else{
   			var ids = getFMeasureSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个产品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个产品!');
        		return ;
        	}
        	
        	$("#measureEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#measureList").datagrid("getSelections")[0];
        			data.cdate = TAOTAO.formatDateTime(data.cdate);
        			$("#measureEditForm").form("load", data);
        			measureEditEditor.html(data.note);
        			
        		}
        	}).window("open");
   		}
   	});
}

function fMeasureCheck_delete(){
	$.get("measure/delete_judge",'',function(data){
   		if(data.msg != null){
   			$.messager.alert('提示', data.msg);
   		}else{
   			var ids = getFMeasureSelectionsIds();
           	if(ids.length == 0){
           		$.messager.alert('提示','未选中订单!');
           		return ;
           	}
           	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
           	    if (r){
           	    	var params = {"ids":ids};
                   	$.post("measure/delete_batch",params, function(data){
               			if(data.status == 200){
               				$.messager.alert('提示','删除订单成功!',undefined,function(){
               					$("#measureList").datagrid("reload");
               				});
               			}
               		});
           	    }
           	});
   		}
   	});
}

function fMeasureCheck_reload(){
	$("#measureList").datagrid("reload");
}
</script>
