<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="orderList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'order/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'orderId',width:100">订单编号</th>
            <th data-options="field:'custom',width:100,formatter:formatCus">订购客户</th>
            <th data-options="field:'product',width:100,formatter:formatPro">订购产品</th>
            <th data-options="field:'quantity',width:100">订购数量</th>
            <th data-options="field:'unitPrice',width:70,align:'right',formatter:TAOTAO.formatPrice">税前单价</th>
            <th data-options="field:'unit',width:70,align:'right'">单位</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatOrderStatus">状态</th>
            <th data-options="field:'orderDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">订购日期</th>
            <th data-options="field:'requestDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">要求日期</th>
            <th data-options="field:'note',width:130,align:'center'">订单要求</th>
        </tr>
    </thead>
</table>
<div id="orderEditWindow" class="easyui-window" title="编辑订单" data-options="modal:true,closed:true,iconCls:'icon-save',href:'order/edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

	function formatCus(value){ 
	    return value.customName;
	}; 
	function  formatPro (value){ 
	    return value.productName;
	};

    function getSelectionsIds(){
    	var orderList = $("#orderList");
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orderId);
    	}
    	/* ids = ids.join(","); */
    	
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
        		$.messager.alert('提示','必须选择一个商品才能编辑!');
        		return ;
        	}
        	if(ids.length >= 2){
        		$.messager.alert('提示','只能选择一个商品!');
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
        			alert(data.orderDate)
        			alert(data.note)
        			$("#orderEditForm").form("load", data);
        			
        			
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
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/order/delete_batch",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
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
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/order/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','下架商品成功!',undefined,function(){
            					$("#orderList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'上架',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中商品!');
        		return ;
        	}
        	$.messager.confirm('确认','确定上架ID为 '+ids+' 的商品吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/order/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','上架商品成功!',undefined,function(){
            					$("#orderList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>