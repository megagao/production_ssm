<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="orderList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'order/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'orderId',align:'center',width:100">订单编号</th>
            <th data-options="field:'custom',align:'center',width:100,formatter:formatCus">订购客户</th>
            <th data-options="field:'product',align:'center',width:100,formatter:formatPro">订购产品</th>
            <th data-options="field:'quantity',align:'center',width:100">订购数量</th>
            <th data-options="field:'unitPrice',width:70,align:'center',formatter:TAOTAO.formatPrice">税前单价</th>
            <th data-options="field:'unit',width:70,align:'center'">单位</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatOrderStatus">状态</th>
            <th data-options="field:'orderDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">订购日期</th>
            <th data-options="field:'requestDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">要求日期</th>
            <th data-options="field:'note',width:100,align:'center', formatter:formatNote">订单要求</th>
            <th data-options="field:'image',width:100,align:'center', formatter:formatImg">相关图片</th>
            <th data-options="field:'note',width:100,align:'center', formatter:formatFile">订单附件</th>
        </tr>
    </thead>
</table>
<div id="orderEditWindow" class="easyui-window" title="编辑订单" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'order/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="noteDialog" class="easyui-dialog" title="订单要求" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:55%;height:80%;padding:10px">
	<form id="noteForm" class="itemForm" method="post">
		<input type="hidden" name="orderId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table><span style="color:green;font-size: 12;font-family: Microsoft YaHei;margin-left: 20px">已完成</span>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateNote()">保存</a>
	</div>
</div>
<script>

	var noteEditor ;

	function formatCus(value){ 
	    return value.customName;
	};  
	
	function  formatPro(value){ 
	    return value.productName;
	};

	function onClickRow(index) {
		var rows = $('#orderList').datagrid('getRows');
		return rows[index];
		
	}
	
	function formatNote(value, row, index){ 
		return "<a href=javascript:openNote("+index+")>"+"订单要求"+"</a>";
	}
	
	function formatImg(value, row, index){ 
		return "<a href="+value+" target='_blank'>"+"<img src="+value+" width='50px' height='50px' )/>"+"</a>";
	}
	
	function formatFile(value, row, index){ 
		return "<a href="+value+" target='_blank'>"+"<img src="+value+" width='50px' height='50px' )/>"+"</a>";
	}
	
	function  openNote(index){ 
		
		var row = onClickRow(index);
		$("#noteDialog").dialog({
    		onOpen :function(){
    			$("#noteForm [name=orderId]").val(row.orderId);
    			noteEditor = TAOTAO.createEditor("#noteForm [name=note]");
    			noteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#noteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	function updateNote(){
		noteEditor.sync();
		$.post("order/update",$("#noteForm").serialize(), function(data){
			if(data.status == 200){
				$("#noteDialog").dialog("close");
				$("#orderList").datagrid("reload");
			}else{
				$.messager.alert("操作提示", "更新备注失败！","error");
			}
		});
	}
	
    function getSelectionsIds(){
    	var orderList = $("#orderList");
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orderId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增订单')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	
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
        				fun:function(node){
        					TAOTAO.changeItemParam(node, "orderEditForm");
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
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
    },'-',{
        text:'下架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中订单!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/order/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架订单成功!',undefined,function(){
            					$("#orderList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'刷新',
        iconCls:'icon-reload',
        handler:function(){
        	$("#orderList").datagrid("reload");
        }
    }];
</script>