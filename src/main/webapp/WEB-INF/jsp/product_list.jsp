<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="productList" title="产品列表" data-options="singleSelect:false,collapsible:true,
		pagination:true,rownumbers:true,url:'product/list',method:'get',pageSize:20, fitColumns:true,
		toolbar:toolbar_product">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'productId',align:'center',width:150">
				产品编号
			</th>
            <th data-options="field:'productName',align:'center',width:150">
				产品名称
			</th>
            <th data-options="field:'productType',align:'center',width:150">
				产品种类
			</th>
            <th data-options="field:'status',width:100,align:'center',formatter:TAOTAO.formatProductStatus">
				状态
			</th>
            <th data-options="field:'note',width:150,align:'center', formatter:formatProductNote">
				产品介绍
			</th>
            <th data-options="field:'image',width:150,align:'center', formatter:formatImg">
				相关图片
			</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_product" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='product:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="product_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='product:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="product_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='product:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="product_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="product_reload()">
			刷新
		</a>
	</div>  
	
    <div id="search_product" style="float: right;">
        <input id="search_text_product" class="easyui-searchbox"  
            data-options="searcher:doSearch_product,prompt:'请输入...',menu:'#menu_product'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_product" style="width:120px"> 
			<div data-options="name:'productId'">产品编号</div> 
			<div data-options="name:'productName'">产品名称</div>
			<div data-options="name:'productType'">产品种类</div>
		</div>     
    </div>  

</div> 

<div id="productEditWindow" class="easyui-window" title="编辑产品" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'product/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="productAddWindow" class="easyui-window" title="添加产品" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'product/add'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="productNoteDialog" class="easyui-dialog" title="产品介绍" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:55%;height:65%;padding:10px">
	<form id="productNoteForm" class="itemForm" method="post">
		<input type="hidden" name="productId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:450px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateProductNote()">保存</a>
	</div>
</div>
<script>
function doSearch_product(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#productList").datagrid({
	        title:'产品列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_product", url:'product/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'productId', width : 150, title : '产品编号', align:'center'},
				{field : 'productName', width : 150, align : 'center', title : '产品名称'},
				{field : 'productType', width : 150, align : 'center', title : '产品种类'},
				{field : 'status', width : 100, title : '状态', align:'center', formatter:TAOTAO.formatProductStatus},
				{field : 'note', width : 150, title : '产品介绍', align:'center', formatter:formatProductNote},
				{field : 'image', width : 150, title : '相关图片', align:'center',formatter:formatImg},
	        ] ],  
	    });
	}else{
		$("#productList").datagrid({  
	        title:'产品列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_product", url:'product/search_product_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'productId', width : 150, title : '产品编号', align:'center'},
				{field : 'productName', width : 150, align : 'center', title : '产品名称'},
				{field : 'productType', width : 150, align : 'center', title : '产品种类'},
				{field : 'status', width : 100, title : '状态', align:'center', formatter:TAOTAO.formatProductStatus},
				{field : 'note', width : 150, title : '产品介绍', align:'center', formatter:formatProductNote},
				{field : 'image', width : 150, title : '相关图片', align:'center',formatter:formatImg},
	        ] ],  
	    });
	}
}

	var productNoteEditor ;
	
	//格式化产品介绍
	function formatProductNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openProductNote("+index+")>"+"产品介绍"+"</a>";
		}else{
			return "无";
		}
	}

	//根据index拿到该行值
	function onProductClickRow(index) {
		var rows = $('#productList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开产品要求富文本编辑器对话框
	function  openProductNote(index){ 
		var row = onProductClickRow(index);
		$("#productNoteDialog").dialog({
    		onOpen :function(){
    			$("#productNoteForm [name=productId]").val(row.productId);
    			productNoteEditor = TAOTAO.createEditor("#productNoteForm [name=note]");
    			productNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#productNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新产品要求
	function updateProductNote(){
		$.get("product/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			productNoteEditor.sync();
    			$.post("product/update_note",$("#productNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#productNoteDialog").dialog("close");
    					$("#productList").datagrid("reload");
    					$.messager.alert("操作提示", "更新产品介绍成功！");
    				}else{
    					$.messager.alert("操作提示", "更新产品介绍失败！");
    				}
    			});
    		}
    	});
	}
	
    function getProductSelectionsIds(){
    	var productList = $("#productList");
    	var sels = productList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].productId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function product_add(){
    	$.get("product/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#productAddWindow").window({
            		onclose :function(){
            			$(".productPicFileUpload").siblings("div.pics").find("ul > li").remove();
            		}
            	}).window("open");
       		}
       	});
    }
    
    function product_edit(){
    	$.get("product/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getProductSelectionsIds();
            	
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个产品才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个产品!');
            		return ;
            	}
            	
            	$("#productEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#productList").datagrid("getSelections")[0];
            			$("#productEditForm").form("load", data);
            			productEditEditor.html(data.note);
            			
            			TAOTAO.initProductPicUpload({
            				"pics" : data.image,
            			});
            		},
            		onclose :function(){
            			$(".productPicFileUpload").siblings("div.pics").find("ul > li").remove();
            		}
            	}).window("open");
       		}
       	});
    }
    
    function product_delete(){
    	$.get("product/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getProductSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中产品!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除ID为 '+ids+' 的产品吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("product/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除产品成功!',undefined,function(){
                					$("#productList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
       		}
       	});
    }
    
    function product_reload(){
    	$("#productList").datagrid("reload");
    }
    
</script>