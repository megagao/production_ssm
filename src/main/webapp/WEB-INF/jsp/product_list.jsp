<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="productList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'product/list',method:'get',pageSize:20,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'productId',align:'center',width:100">产品编号</th>
            <th data-options="field:'productName',align:'center',width:100">产品名称</th>
            <th data-options="field:'productType',align:'center',width:100">产品种类</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatProductStatus">状态</th>
            <th data-options="field:'note',width:100,align:'center', formatter:formatNote">产品介绍</th>
            <th data-options="field:'image',width:100,align:'center', formatter:formatImg">相关图片</th>
        </tr>
    </thead>
</table>
<div id="productEditWindow" class="easyui-window" title="编辑产品" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'product/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="productAddWindow" class="easyui-window" title="添加产品" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'product/add'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="noteDialog" class="easyui-dialog" title="产品介绍" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:55%;height:80%;padding:10px">
	<form id="noteForm" class="itemForm" method="post">
		<input type="hidden" name="productId"/>
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
	
	//格式化产品介绍
	function formatNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openNote("+index+")>"+"产品介绍"+"</a>";
		}else{
			return "无";
		}
	}

	//根据index拿到该行值
	function onClickRow(index) {
		var rows = $('#productList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开订单要求富文本编辑器对话框
	function  openNote(index){ 
		var row = onClickRow(index);
		$("#noteDialog").dialog({
    		onOpen :function(){
    			$("#noteForm [name=productId]").val(row.productId);
    			noteEditor = TAOTAO.createEditor("#noteForm [name=note]");
    			noteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#noteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新订单要求
	function updateNote(){
		$.get("product/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			noteEditor.sync();
    			$.post("product/update_note",$("#noteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#noteDialog").dialog("close");
    					$("#productList").datagrid("reload");
    					$.messager.alert("操作提示", "更新产品介绍成功！");
    				}else{
    					$.messager.alert("操作提示", "更新产品介绍失败！");
    				}
    			});
    		}
    	});
	}
	
    function getSelectionsIds(){
    	var productList = $("#productList");
    	var sels = productList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].productId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$.get("product/add_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			$("#productAddWindow").window("open");
        		}
        	});
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	$.get("product/edit_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getSelectionsIds();
                	
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
                			
                			TAOTAO.init({
                				"pics" : data.image,
                			});
                		}
                	}).window("open");
        		}
        	});
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	$.get("product/delete_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getSelectionsIds();
                	if(ids.length == 0){
                		$.messager.alert('提示','未选中订单!');
                		return ;
                	}
                	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
                	    if (r){
                	    	var params = {"ids":ids};
                        	$.post("product/delete_batch",params, function(data){
                    			if(data.status == 200){
                    				$.messager.alert('提示','删除订单成功!',undefined,function(){
                    					$("#productList").datagrid("reload");
                    				});
                    			}
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
        	$("#productList").datagrid("reload");
        }
    }];
</script>