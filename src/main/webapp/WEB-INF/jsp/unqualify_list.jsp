<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table id="unqualifyList" title="不合格品列表" class="easyui-datagrid"
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'unqualify/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_unqualify">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'unqualifyApplyId',align:'center',width:100">不合格品申请编号</th>
            <th data-options="field:'productId',align:'center',width:100,formatter:formatProduct">产品编号</th>
            <th data-options="field:'unqualifyItem',align:'center',width:100">不合格项目</th>
            <th data-options="field:'unqualifyCount',align:'center',width:100">不合格数量</th>
            <th data-options="field:'assemblyDate',align:'center',width:100,formatter:TAOTAO.formatDateTime">加工时间</th>
            <th data-options="field:'empId',align:'center',width:100">申请人</th>
            <th data-options="field:'applyDate',align:'center',width:100,formatter:TAOTAO.formatDateTime">申请时间</th>
            <th data-options="field:'note',align:'center',width:100,formatter:formatUnqualifyNote">备注</th>
        
        </tr>
    </thead>
</table>
<!-- 1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div  id="toolbar_unqualify" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='unqualify:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="unqualify_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='unqualify:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="unqualify_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='unqualify:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="unqualify_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="unqualify_reload()">刷新</a>  
	</div>  
	
    <div id="search_unqualify" style="float: right;">
        <input id="search_text_unqualify" class="easyui-searchbox"  
            data-options="searcher:doSearch_unqualify,prompt:'请输入...',menu:'#menu_unqualify'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_unqualify" style="width:120px"> 
			<div data-options="name:'unqualifyId'">不合格产品编号</div> 
			<div data-options="name:'productName'">产品名称</div> 
		</div>     
    </div>  

</div>


<!-- 1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div id="unqualifyEditWindow" class="easyui-window" title="编辑列表" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'unqualify/edit'" style="width:85%;height:90%;padding:10px;">
</div>
<div id="unqualifyAddWindow" class="easyui-window" title="编辑列表" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'unqualify/add'" style="width:85%;height:90%;padding:10px;">
</div>

<div id="unqualifyProductInfo" class="easyui-dialog" title="客户信息" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="unqualifyProductEditForm" method="post">
		<input type="hidden" name="productId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>产品名称:</td>
	            <td><input class="easyui-textbox" type="text" name="productName" data-options="required:true"></input></td>  
	        </tr>
	        <tr>
	            <td>产品种类:</td>
	            <td><input class="easyui-textbox" type="text" name="productType" data-options="required:true"></input></td>  
	        </tr>
	        <tr>
	            <td>产品状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" data-options="required:true,width:150, editable:false">
						<option value="1">有效产品</option>
						<option value="2">停产</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>相关图片:</td>
	            <td>
	            	 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" id="image" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>产品介绍:</td>
	            <td><textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitUnqualifyProductEditForm()">提交</a>
	</div>
</div>


<div id="unqualifyNoteDialog" class="easyui-dialog" title="产品介绍" data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'" style="width:55%;height:80%;padding:10px">
	<form id="unqualifyNoteForm" method="post">
		<input type="hidden" name="unqualifyApplyId"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateNote()">保存</a>
	</div>
</div>
  
<script>

function doSearch_unqualify(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#unqualifyList").datagrid({
	        title:'不合格品列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_unqualify", url:'unqualify/list', method:'get', loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'unqualifyApplyId', width : 100, title : '不合格品申请编号', align:'center'},
	             	{field : 'productId', width : 100, align : 'center', title : '产品编号', formatter:formatProduct},
	             	{field : 'unqualifyItem', width : 100, align : 'center', title : '不合格项目'}, 
	             	{field : 'unqualifyCount', width : 100, title : '不合格数量', align:'center'}, 
	             	{field : 'assemblyDate', width : 100, title : '加工时间', align:'center', formatter:TAOTAO.formatDateTime}, 
	            	{field : 'empId', width : 100, title : '申请人', align:'center'}, 
	             	{field : 'applyDate', width : 100, title : '申请时间', align:'center', formatter:TAOTAO.formatDateTime}, 
	             	{field : 'note', width : 100, title : '备注', align:'center',formatter:formatUnqualifyNote}
	        ] ],  
	    });
	}else{
		$("#unqualifyList").datagrid({  
	        title:'不合格品列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', nowrap:true,  
	        toolbar:"toolbar_unqualify", url:'unqualify/search_unqualify_by_'+name+'?searchValue='+value, loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'unqualifyApplyId', width : 100, title : '不合格品申请编号', align:'center'},
	             	{field : 'productId', width : 100, align : 'center', title : '产品编号', formatter:formatProduct},
	             	{field : 'unqualifyItem', width : 100, align : 'center', title : '不合格项目'}, 
	             	{field : 'unqualifyCount', width : 100, title : '不合格数量', align:'center'}, 
	             	{field : 'assemblyDate', width : 100, title : '加工时间', align:'center', formatter:TAOTAO.formatDateTime}, 
	            	{field : 'empId', width : 100, title : '申请人', align:'center'}, 
	             	{field : 'applyDate', width : 100, title : '申请时间', align:'center', formatter:TAOTAO.formatDateTime}, 
	             	{field : 'note', width : 100, title : '备注', align:'center',formatter:formatUnqualifyNote}
	        ] ],  
	    });
	}
}

	var unqualifyNoteEditor ;
	
	var unqualifyProductEditor;
	
	//格式化产品信息
	function  formatProduct(value, row, index){ 
		if(row.productName !=null && row.productName != ''){
			return "<a href=javascript:openUnqualifyProduct("+index+")>"+row.productName+"</a>";
		}else{
			return "无";
		}
	};
	
	//打开产品信息对话框
	function  openUnqualifyProduct(index){ 
		var row = onUnqualifyClickRow(index);
		$("#unqualifyProductInfo").dialog({
    		onOpen :function(){
    			$.get("product/get/"+row.productId,'',function(data){
    				
    				unqualifyProductEditor = TAOTAO.createEditor("#unqualifyProductEditForm [name=note]");	
		    		//回显数据
		    		$("#unqualifyProductEditForm").form("load", data);
		    		unqualifyProductEditor.html(data.note);
		    		
		    		TAOTAO.init({
        				"pics" : data.image,
        			});
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#unqualifyProductEditForm [name=note]");
			}
    	}).dialog("open");
	};
	
	
	//根据index拿到该行值
	function onUnqualifyClickRow(index) {
		var rows = $('#unqualifyList').datagrid('getRows');
		return rows[index];
		
	}
	
	
	function submitUnqualifyProductEditForm(){
		$.get("product/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#unqualifyProductEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			unqualifyProductEditor.sync();
    			
    			$.post("product/update_all",$("#unqualifyProductEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改产品成功!','info',function(){
    						$("#unqualifyProductInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改产品失败!');
    				}
    			});
    		}
    	});
	}
	
	//格式化产品介绍
	function formatUnqualifyNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openUnqualifyNote("+index+")>"+"备注"+"</a>";
		}else{
			return "无";
		}
	}

	//根据index拿到该行值
	function onUnqualifyClickRow(index) {
		var rows = $('#unqualifyList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开备注编辑对话框
	function  openUnqualifyNote(index){ 
		var row = onUnqualifyClickRow(index);
		$("#unqualifyNoteDialog").dialog({
    		onOpen :function(){
    			$("#unqualifyNoteForm [name=unqualifyApplyId]").val(row.unqualifyApplyId);
    			unqualifyNoteEditor = TAOTAO.createEditor("#unqualifyNoteForm [name=note]");
    			unqualifyNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#unqualifyNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新订单要求
	function updateNote(){
		$.get("unqualify/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			unqualifyNoteEditor.sync();
    			$.post("unqualify/update_note",$("#unqualifyNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#unqualifyNoteDialog").dialog("close");
    					$("#unqualifyList").datagrid("reload");
    					$.messager.alert("操作提示", "更新备注成功！");
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	
    function getSelectionsIds(){
    	
    	var sels = $("#unqualifyList").datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].unqualifyApplyId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function unqualify_add(){
    	$.get("unqualify/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#unqualifyAddWindow").window("open");
       		}
       	});
    }
    
    function unqualify_edit(){
    	$.get("unqualify/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getSelectionsIds();
               	
               	if(ids.length == 0){
               		$.messager.alert('提示','必须选择一个订单才能编辑!');
               		return ;
               	}
               	if(ids.indexOf(',') > 0){
               		$.messager.alert('提示','只能选择一个订单!');
               		return ;
               	}
               	
               	$("#unqualifyEditWindow").window({
               		onLoad :function(){
               			//回显数据
               			
               			
               			
               			var data = $("#unqualifyList").datagrid("getSelections")[0];
            			data.assemblyDate = TAOTAO.formatDateTime(data.assemblyDate);
            			data.applyDate = TAOTAO.formatDateTime(data.applyDate);
            			$("#unqualifyApplyEditForm").form("load", data);
            			unqualifyApplyEditEditor.html(data.note);
               			
               			
               			
               		}
               	}).window("open");
       		}
       	});
    }
    
    function unqualify_delete(){
    	$.get("unqualify/delete_judge",'',function(data){
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
                       	$.post("unqualify/delete_batch",params, function(data){
                   			if(data.status == 200){
                   				$.messager.alert('提示','删除订单成功!',undefined,function(){
                   					$("#unqualifyList").datagrid("reload");
                   				});
                   			}
                   		});
               	    }
               	});
       		}
       	});
    }
    
    function unqualify_reload(){
    	$("#unqualifyList").datagrid("reload");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
    var toolbar_unqualify = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$("#unqualifyAddWindow").window("open");
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个产品才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个产品!');
        		return ;
        	}
        	
        	$("#unqualifyEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#unqualifyList").datagrid("getSelections")[0];
        			data.assemblyDate = TAOTAO.formatDateTime(data.assemblyDate);
        			data.applyDate = TAOTAO.formatDateTime(data.applyDate);
        			$("#unqualifyApplyEditForm").form("load", data);
        			unqualifyApplyEditEditor.html(data.note);
        			
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
                	$.post("unqualify/delete_batch",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除订单成功!',undefined,function(){
            					$("#unqualifyList").datagrid("reload");
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
        	$("#unqualifyList").datagrid("reload");
        }
    }];
    */
</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>

<style>
.icon-filter {
	background: url('image/filter.png') no-repeat center center;
}
</style>

<script>
	$(function() {
		var dg = $('#unqualifyList').datagrid({
			filterBtnIconCls : 'icon-filter'
		});

		dg.datagrid('enableFilter');

	});
</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>