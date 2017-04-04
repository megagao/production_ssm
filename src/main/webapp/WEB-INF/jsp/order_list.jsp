<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table class="easyui-datagrid" id="orderList" title="订单列表" data-options="singleSelect:false,collapsible:true,
	pagination:true,rownumbers:true,url:'order/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_order">
    <thead>
        <tr>
			<th data-options="field:'ck',checkbox:true"></th>
			<th data-options="field:'orderId',align:'center',width:100">订单编号</th>
			<th data-options="field:'custom',align:'center',width:100,formatter:formatCustom">订购客户</th>
			<th data-options="field:'product',align:'center',width:100,formatter:formatProduct">订购产品</th>
			<th data-options="field:'quantity',align:'center',width:100">订购数量</th>
			<th data-options="field:'unitPrice',width:70,align:'center'">税前单价</th>
			<th data-options="field:'unit',width:70,align:'center'">单位</th>
			<th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatOrderStatus">状态</th>
			<th data-options="field:'orderDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">订购日期</th>
			<th data-options="field:'requestDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">要求日期</th>
			<th data-options="field:'note',width:100,align:'center', formatter:formatOrderNote">订单要求</th>
			<th data-options="field:'image',width:100,align:'center', formatter:formatImg">相关图片</th>
			<th data-options="field:'file',width:180,align:'center', formatter:formatFile">订单附件</th>
        </tr>
    </thead>
</table> 

<div  id="toolbar_order" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='order:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="order_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='order:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="order_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='order:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="order_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="order_reload()">刷新</a>  
	</div>  
	
    <div id="search_order" style="float: right;">
        <input id="search_text_order" class="easyui-searchbox"  
            data-options="searcher:doSearch_order,prompt:'请输入...',menu:'#menu_order'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_order" style="width:120px"> 
			<div data-options="name:'orderId'">订单编号</div> 
			<div data-options="name:'orderCustom'">客户名称</div>
			<div data-options="name:'orderProduct'">产品名称</div> 
		</div>     
    </div>  
</div>  

<div id="orderEditWindow" class="easyui-window" title="编辑订单" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'order/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="orderAddWindow" class="easyui-window" title="添加订单" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'order/add'" style="width:65%;height:80%;padding:10px;">
</div>

<div id="orderCustomInfo" class="easyui-dialog" title="客户信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="orderCustomEditForm" method="post">
		<input type="hidden" name="customId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>客户名称:</td>
	            <td><input class="easyui-textbox" type="text" name="customName" data-options="required:true"/></td>
	        </tr>
	        <tr>
	            <td>客户全称:</td>
	            <td><input class="easyui-textbox" type="text" name="fullName" style="width: 280px;"/></td>
	        </tr>
	        <tr>
	            <td>地址:</td>
	            <td><input class="easyui-textbox" type="text" name="address" style="width: 280px;"/></td>
	        </tr>
	        <tr>
	            <td>传真:</td>
	            <td><input class="easyui-textbox" type="text" name="fax"/></td>
	        </tr>
	        <tr>
	            <td>邮箱:</td>
	            <td><input class="easyui-textbox" type="text" name="email"/></td>
	        </tr>
	        <tr>
	            <td>经理姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="ownerName"/></td>
	        </tr>
	        <tr>
	            <td>联系电话:</td>
	            <td><input class="easyui-textbox" type="text" name="ownerTel"/></td>
	        </tr>
	        <tr>
	            <td>客户状态:</td>
	            <td>
		            <select class="easyui-combobox" name="status" style="width:200px;" data-options="width:150">
						<option value="1">有效客户</option>
						<option value="2">无效客户</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td><textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOrderCustomEditForm()">提交</a>
	</div>
</div>
<div id="orderProductInfo" class="easyui-dialog" title="产品信息" data-options="modal:true,closed:true,resizable:true,
		iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="orderProductEditForm" method="post">
		<input type="hidden" name="productId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>产品名称:</td>
	            <td><input class="easyui-textbox" type="text" name="productName" data-options="required:true"/></td>
	        </tr>
	        <tr>
	            <td>产品种类:</td>
	            <td><input class="easyui-textbox" type="text" name="productType" data-options="required:true"/></td>
	        </tr>
	        <tr>
	            <td>产品状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" data-options="required:true,width:150">
						<option value="1">有效产品</option>
						<option value="2">停产</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>相关图片:</td>
	            <td>
	            <div style="padding-top: 12px"><span id="orderProductPicSpan"></span></div>
	                 <input type="hidden" class="easyui-linkbutton orderProductPic" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>产品介绍:</td>
	            <td><textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitOrderProductEditForm()">提交</a>
	</div>
</div>
<div id="orderNoteDialog" class="easyui-dialog" title="订单要求" data-options="modal:true,closed:true,resizable:true,
		iconCls:'icon-save'" style="width:55%;height:65%;padding:10px">
	<form id="orderNoteForm" class="itemForm" method="post">
		<input type="hidden" name="orderId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td><textarea style="width:800px;height:450px;visibility:hidden;" name="note"></textarea></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateOrderNote()">保存</a>
	</div>
</div>
<script>
function doSearch_order(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#orderList").datagrid({
	        title:'订单列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_order", url:'order/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'orderId', width : 100, align:'center', title : '订单编号'},
				{field : 'custom', width : 100, align : 'center', title : '订购客户', formatter:formatCustom},
				{field : 'product', width : 100, align : 'center', title : '订购产品', formatter:formatProduct},
				{field : 'quantity', width : 100, title : '订购数量', align:'center'},
				{field : 'unitPrice', width : 70, title : '税前单价', align:'center'},
				{field : 'unit', width : 70, title : '单位', align:'center'},
				{field : 'status', width : 60, title : '状态', align:'center', formatter:TAOTAO.formatOrderStatus},
				{field : 'orderDate', width : 130, title : '订购日期', align:'center', formatter:TAOTAO.formatDateTime},
				{field : 'requestDate', width : 130, title : '要求日期', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'note', width : 100, title : '订单要求', align:'center', formatter:formatOrderNote},
				{field : 'image', width : 100, title : '相关图片', align:'center', formatter:formatImg},
				{field : 'file',  width : 100, title : '订单附件', align:'center', formatter:formatFile}
	        ] ],  
	    });
	}else{
		$("#orderList").datagrid({  
	        title:'订单列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_order", url:'order/search_order_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'orderId', width : 100, title : '订单编号', align:'center'},
	             	{field : 'custom', width : 100, align : 'center', title : '订购客户', formatter:formatCustom},
	             	{field : 'product', width : 100, title : '订购产品', formatter:formatProduct}, 
	             	{field : 'quantity', width : 100, title : '订购数量', align:'center'}, 
	             	{field : 'unitPrice', width : 70, title : '税前单价', align:'center'}, 
	            	{field : 'unit', width : 70, title : '单位', align:'center'}, 
	             	{field : 'status', width : 60, title : '状态', align:'center', formatter:TAOTAO.formatOrderStatus}, 
	             	{field : 'orderDate', width : 130, title : '订购日期', align:'center',
						formatter:TAOTAO.formatDateTime},
	             	{field : 'requestDate', width : 130, title : '要求日期', align:'center',
						formatter:TAOTAO.formatDateTime},
	             	{field : 'note', width : 100, title : '订单要求', align:'center', formatter:formatOrderNote}, 
	             	{field : 'image', width : 100, title : '相关图片', align:'center', formatter:formatImg}, 
	             	{field : 'file',  width : 100, title : '订单附件', align:'center', formatter:formatFile}
	        ] ],  
	    });
	}
}
	var orderNoteEditor ;
	
	var orderProductEditor;
	
	var orderCustomEditor;
	
	//格式化客户信息
	function formatCustom(value, row, index){ 
		if(value !=null && value != ''){
			var row = onOrderClickRow(index); 
			return "<a href=javascript:openOrderCustom("+index+")>"+value.customName+"</a>";
		}else{
			return "无";
		}
	};  
	
	//格式化产品信息
	function  formatProduct(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openOrderProduct("+index+")>"+value.productName+"</a>";
		}else{
			return "无";
		}
	};
	
	//格式化订单要求
	function formatOrderNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openOrderNote("+index+")>"+"订单要求"+"</a>";
		}else{
			return "无";
		}
	}

	//根据index拿到该行值
	function onOrderClickRow(index) {
		var rows = $('#orderList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开客户信息对话框
	function  openOrderCustom(index){ 
		var row = onOrderClickRow(index);
		$("#orderCustomInfo").dialog({
    		onOpen :function(){
    			$.get("custom/get/"+row.custom.customId,'',function(data){
    				orderCustomEditor = TAOTAO.createEditor("#orderCustomEditForm [name=note]");	
		    		//回显数据
		    		$("#orderCustomEditForm").form("load", data);
		    		orderCustomEditor.html(data.note);
		    		
		    		TAOTAO.init({
        				"pics" : data.image,
        			});
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#orderCustomEditForm [name=note]");
			}
    	}).dialog("open");
	};
	
	function submitOrderCustomEditForm(){
		$.get("custom/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#orderCustomEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			orderCustomEditor.sync();
    			$.post("custom/update_all",$("#orderCustomEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改客户成功!','info',function(){
    						$("#orderCustomInfo").dialog("close");
    						$("#orderList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	//打开产品信息对话框
	function  openOrderProduct(index){ 
		var row = onOrderClickRow(index);
		$("#orderProductInfo").dialog({
    		onOpen :function(){
    			$.get("product/get/"+row.product.productId,'',function(data){
    				
    				orderProductEditor = TAOTAO.createEditor("#orderProductEditForm [name=note]");	
		    		//回显数据
		    		$("#orderProductEditForm").form("load", data);
		    		orderProductEditor.html(data.note);
		    		
		    		//加载图片
 	        		initOrderProductPic({
           				"pics" : data.image,
           			});
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#orderProductEditForm [name=note]");
			   	clearManuSpan();
			}
    	}).dialog("open");
	};
	
	// 加载图片
    function initOrderProductPic(data){
    	$(".orderProductPic").each(function(i,e){
    		var _ele = $(e);
    		_ele.siblings("div.pics").remove();
    		_ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
    		// 回显图片
    		var j = false;
        	if(data && data.pics){
        		var imgs = data.pics.split(",");
        		for(var i in imgs){
        			if($.trim(imgs[i]).length > 0){
        				_ele.siblings(".pics").find("ul").append("<li><a id='img"+i+"' href='"+imgs[i]+"' target='_blank'>" +
        						"<img src='"+imgs[i]+"' width='80' height='50' /></a> ");
        				j = true;
        			}
        		}
        	}
        	if(!j){
    			$("#orderProductPic").html("<span style='font-size: 12px;font-family: Microsoft YaHei;'>无</span>");
    		}
    	});
    }
	
    function clearManuSpan(){
		$("#orderProductPic").html('');
	}
    
	function submitOrderProductEditForm(){
		$.get("product/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#orderProductEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			orderProductEditor.sync();
    			
    			$.post("product/update_all",$("#orderProductEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改产品成功!','info',function(){
    						$("#orderProductInfo").dialog("close");
    						$("#orderList").datagrid("reload");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	//打开订单要求富文本编辑器对话框
	function  openOrderNote(index){ 
		var row = onOrderClickRow(index);
		$("#orderNoteDialog").dialog({
    		onOpen :function(){
    			$("#orderNoteForm [name=orderId]").val(row.orderId);
    			orderNoteEditor = TAOTAO.createEditor("#orderNoteForm [name=note]");
    			orderNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#orderNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新订单要求
	function updateOrderNote(){
		$.get("order/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			orderNoteEditor.sync();
    			$.post("order/update_note",$("#orderNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#orderNoteDialog").dialog("close");
    					$("#orderList").datagrid("reload");
    					$.messager.alert("操作提示", "更新订单要求成功！");
    				}else{
    					$.messager.alert("操作提示", "更新订单要求失败！");
    				}
    			});
    		}
    	});
	}
	
    function getOrderSelectionsIds(){
    	var orderList = $("#orderList");
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orderId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function order_add(){
    	$.get("order/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#orderAddWindow").window("open");
       		}
       	});
    }
    
    function order_edit(){
    	$.get("order/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getOrderSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个订单才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个订单!');
               		return ;
               	}
               	
               	$("#orderEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			var data = $("#orderList").datagrid("getSelections")[0];
               			data.customId = data.custom.customId; 
               			data.productId = data.product.productId; 
               			data.orderDate = TAOTAO.formatDateTime(data.orderDate);
               			data.requestDate = TAOTAO.formatDateTime(data.requestDate);
               			$("#orderEditForm").form("load", data);
               			orderEditEditor.html(data.note);
               			
               			TAOTAO.init({
               				"pics" : data.image,
               			});
               			
               			//加载文件上传插件
               			initOrderEditFileUpload();
               			//加载上传过的文件
               			initUploadedFile();
               		}
               	}).window("open");
       		}
       	});
    }
    
    function order_delete(){
    	$.get("order/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getOrderSelectionsIds();
              	if(ids.length == 0){
              		$.messager.alert('提示','未选中订单!');
              		return ;
              	}
              	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
              	    if (r){
              	    	var params = {"ids":ids};
                      	$.post("order/delete_batch",params, function(data){
                  			if(data.status == 200){
                  				$.messager.alert('提示','删除订单成功!',undefined,function(){
                  					$("#orderList").datagrid("reload");
                  				});
                  			}
                  		});
              	    }
              	});
      		}
      	});
    }
    
    function order_reload(){
    	$("#orderList").datagrid("reload");
    }
</script>