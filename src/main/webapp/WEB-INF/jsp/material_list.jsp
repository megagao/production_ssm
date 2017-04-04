<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="materialList" title="物料信息" data-options="singleSelect:false,collapsible:true,
	pagination:true,rownumbers:true,url:'material/list',method:'get',pageSize:10,fitColumns:true,
	toolbar:toolbar_material">
    <thead>
         <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'materialId',align:'center',width:100">物料编号</th>
            <th data-options="field:'materialType',align:'center',width:100">物料类型</th>
            <th data-options="field:'status',width:100,align:'center',formatter:TAOTAO.formatMaterialStatus">
				物料状态
			</th>
            <th data-options="field:'remaining',align:'center',width:100">剩余数量</th>
            <th data-options="field:'note',width:100,align:'center', formatter:formatMaterialNote">备注</th>
          
        </tr>
    </thead>
</table>

<div  id="toolbar_material" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='material:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="material_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='material:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="material_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='material:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="material_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="material_reload()">刷新</a>  
	</div>  
	
    <div id="search_material" style="float: right;">
        <input id="search_text_material" class="easyui-searchbox"  
            data-options="searcher:doSearch_material,prompt:'请输入...',menu:'#menu_material'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_material" style="width:120px"> 
			<div data-options="name:'materialId'">物料编号</div> 	
			<div data-options="name:'materialType'">物料类型</div> 		
		</div>     
    </div>  

</div>  

<div id="materialEditWindow" class="easyui-window" title="编辑物料" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'material/edit'" style="width:65%;height:65%;padding:10px;">
</div>
<div id="materialAddWindow" class="easyui-window" title="添加物料" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'material/add'" style="width:65%;height:65%;padding:10px;">
</div>
<div id="materialNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:55%;height:65%;padding:10px;">
	<form id="materialNoteForm" class="itemForm" method="post">
		<input type="hidden" name="materialId"/>
	    <table cellpadding="10" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:450px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateMaterialNote()">保存</a>
	</div>
</div>
<script>

function doSearch_material(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#materialList").datagrid({
	        title:'物料信息', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_material", url:'material/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 	       
				{field : 'ck', checkbox:true },
				{field : 'materialId', width : 100, title : '物料编号', align:'center'},
				{field : 'materialType', width : 100, align : 'center', title : '物料类型'},
				{field : 'status', width : 100, align : 'center', title : '物料状态'},
				{field : 'remaining', width : 100, title : '剩余数量', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center',formatter:formatMaterialNote}
	        ] ],  
	    });
	}else{
		$("#materialList").datagrid({  
	        title:'物料信息', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_material", url:'material/search_material_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'materialId', width : 100, title : '物料编号', align:'center'},
				{field : 'materialType', width : 100, align : 'center', title : '物料类型'},
				{field : 'status', width : 100, align : 'center', title : '物料状态'},
				{field : 'remaining', width : 100, title : '剩余数量', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center',formatter:formatMaterialNote}
	        ] ],  
	    });
	}
}

	var materialNoteEditor;
	
	//根据index拿到该行值
	function onMaterialClickRow(index) {
		var rows = $('#materialList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化客户介绍
	function formatMaterialNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openMaterialNote("+index+")>"+"详情"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openMaterialNote(index){ 
		
		var row = onMaterialClickRow(index);
		$("#materialNoteDialog").dialog({
			onOpen :function(){
				$("#materialNoteForm [name=materialId]").val(row.materialId);
				materialNoteEditor = TAOTAO.createEditor("#materialNoteForm [name=note]");
				materialNoteEditor.html(row.note);
				
			},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#materialNoteForm [name=note]");
			}
		}).dialog("open");
	};
	
	function updateMaterialNote(){
		$.get("material/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			materialNoteEditor.sync();
    			$.post("material/update_note",$("#materialNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#materialNoteDialog").dialog("close");
    					$("#materialList").datagrid("reload");
    					$.messager.alert("操作提示", "更新物料详情成功！");
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	
	function getMaterialSelectionsIds(){
		var materialList = $("#materialList");
		var sels = materialList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].materialId);
		}
		ids = ids.join(","); 
		
		return ids;
	}
	
	function material_add(){
    	$.get("material/add_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			$("#materialAddWindow").window("open");
        		}
        	});
	    }
    
    function material_edit(){
    	$.get("material/edit_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getMaterialSelectionsIds();
        	    	
        	    	if(ids.length == 0){
        	    		$.messager.alert('提示','必须选择一个记录才能编辑!');
        	    		return ;
        	    	}
        	    	if(ids.indexOf(',') > 0){
        	    		$.messager.alert('提示','只能选择一个记录!');
        	    		return ;
        	    	}     	    	
        	    	$("#materialEditWindow").window({
        	    		onLoad :function(){
        	    			//回显数据
        	    			var data = $("#materialList").datagrid("getSelections")[0];
        	    			$("#materialEditForm").form("load", data);
        	    			materialEditEditor.html(data.note);
        	    		}
        	    	}).window("open");
        		}
        	});
	    }
    
    
    function material_delete(){
    		$.get("material/delete_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getMaterialSelectionsIds();
        	    	if(ids.length == 0){
        	    		$.messager.alert('提示','未选中记录!');
        	    		return ;
        	    	}
        	    	$.messager.confirm('确认','确定删除编号为 '+ids+' 的记录吗？',function(r){
        	    	    if (r){
        	    	    	var params = {"ids":ids};
        	            	$.post("material/delete_batch",params, function(data){
        	        			if(data.status == 200){
        	        				$.messager.alert('提示','删除成功!',undefined,function(){
        	        					$("#materialList").datagrid("reload");
        	        				});
        	        			}
        	        		});
        	    	    }
        	    	});
        		}
        	});
	    
    }
    
    function material_reload(){
    	$("#materialList").datagrid("reload");
    }
</script>