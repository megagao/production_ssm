<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="manufactureList" title="生产计划列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'manufacture/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'manufactureSn',align:'center',width:150">生产批号</th>
            <th data-options="field:'cOrder',align:'center',width:150,formatter:formatManuOrder">订单</th>
            <th data-options="field:'technology',align:'center',width:150,formatter:formatManuTechnology">工艺</th>
            <th data-options="field:'launchQuantity',align:'center',width:100">投产数量</th>
            <th data-options="field:'beginDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">开始日期</th>
            <th data-options="field:'endDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">结束日期</th>
        </tr>
    </thead>
</table>
<div id="manufactureEditWindow" class="easyui-window" title="编辑生产计划" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'manufacture/edit'" style="width:45%;height:60%;padding:10px;">
</div>
<div id="manufactureAddWindow" class="easyui-window" title="添加生产计划" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'manufacture/add'" style="width:45%;height:60%;padding:10px;">
</div>

<div id="orderInfoWindow" class="easyui-window" title="订单信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'order/edit'" style="width:65%;height:80%;padding:10px;">
</div>

<script>
	//根据index拿到该行值
	function onManufactureClickRow(index) {
		var rows = $('#manufactureList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化订单信息
	function formatManuOrder(value, row, index){ 
		return "<a href=javascript:openManuOrder("+index+")>订单</a>";
	};  
	
	function  openManuOrder(index){ 
		var row = onManufactureClickRow(index);
		$.get("order/get/"+row.orderId,'',function(data){
			$("#orderInfoWindow").window({
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
    	});
	};
	
	//格式化工艺信息
	function formatManuTechnology(value, row, index){ 
		return "<a href=javascript:ManuTechnology("+index+")>工艺</a>";
	};  
	
	function  ManuTechnology(index){ 
		var row = onManufactureClickRow(index);
		$.get("technology/get/"+row.technologyId,'',function(data){
			$("#technologyInfoWindow").window({
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
    	});
	};
	
    function getManufactureSelectionsIds(){
    	var manufactureList = $("#manufactureList");
    	var sels = manufactureList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].manufactureSn);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#manufactureAddWindow").window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getManufactureSelectionsIds();
        	
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个生产计划才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个生产计划!');
        		return ;
        	}
        	
        	$("#manufactureEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#manufactureList").datagrid("getSelections")[0];
        			$("#manufactureEditForm").form("load", data);
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getManufactureSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中生产计划!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除生产批号为 '+ids+' 的生产计划吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("manufacture/delete_batch",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除生产计划成功!',undefined,function(){
            					$("#manufactureList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'刷新',
        iconCls:'icon-reload',
        handler:function(){
        	$("#manufactureList").datagrid("reload");
        }
    }];
</script>