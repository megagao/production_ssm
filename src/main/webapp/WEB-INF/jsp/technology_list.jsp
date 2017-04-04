<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="technologyList" title="工艺列表" data-options="singleSelect:false,collapsible:true,
		pagination:true,rownumbers:true,url:'technology/list',method:'get',pageSize:30,fitColumns:true,
		toolbar:toolbar_technology">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'technologyId',width:100,align:'center'">工艺编号</th>
            <th data-options="field:'technologyName',width:100,align:'center'">工艺名称</th>
            <th data-options="field:'price',width:100,align:'center'">外协价格</th>
            <th data-options="field:'vitalProcessPeriod',width:140,align:'center'">瓶颈工序工期</th>
            <th data-options="field:'standardCapacity',width:140,align:'center'">标准加工能力</th>
            <th data-options="field:'overtimeStandardCapacity',width:160,align:'center'">加班标准加工能力</th>
            <th data-options="field:'overtimeOverfulfilCapacity',width:160,align:'center'">加班超额加工能力</th>
            <th data-options="field:'doubleCapacity',width:140,align:'center'">二倍工序能力</th>
            <th data-options="field:'overfulfilCapacity',width:160,align:'center'">超负荷工序能力</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_technology" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per == 'technology:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="technology_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='technology:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="technology_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='technology:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="technology_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="technology_reload()">
			刷新
		</a>
	</div>  
	
    <div id="search_technology" style="float: right;">
        <input id="search_text_technology" class="easyui-searchbox"  
            data-options="searcher:doSearch_technology,prompt:'请输入...',menu:'#menu_technology'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_technology" style="width:120px"> 
			<div data-options="name:'technologyId'">工艺编号</div> 
			<div data-options="name:'technologyName'">工艺名称</div>
		</div>     
    </div>  

</div>

<div id="technologyEditWindow" class="easyui-window" title="编辑工艺" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'technology/edit'" style="width:40%;height:55%;padding:10px;">
</div>

<div id="technologyAddWindow" class="easyui-window" title="添加工艺" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'technology/add'" style="width:40%;height:55%;padding:10px;">
</div>
 
<script>
function doSearch_technology(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#technologyList").datagrid({
	        title:'工艺列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_technology", url:'technology/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'technologyId', width : 100, align:'center', title : '工艺编号'},
				{field : 'technologyName', width : 100, align : 'center', title : '工艺名称'},
				{field : 'price', width : 100, align : 'center', title : '外协价格'},
				{field : 'vitalProcessPeriod', width : 140, title : '瓶颈工序工期', align:'center'},
				{field : 'standardCapacity', width : 140, title : '标准加工能力', align:'center'},
				{field : 'overtimeStandardCapacity', width : 160, title : '加班标准加工能力', align:'center'},
				{field : 'overtimeOverfulfilCapacity', width : 160, title : '加班超额加工能力', align:'center'},
				{field : 'doubleCapacity', width : 140, title : '二倍工序能力', align:'center'},
				{field : 'overfulfilCapacity', width : 160, title : '超负荷工序能力', align:'center'},
	        ] ],  
	    });
	}else{
		$("#technologyList").datagrid({  
	        title:'工艺列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_technology", url:'technology/search_technology_by_'+name+'?searchValue='
				+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'technologyId', width : 100, align:'center', title : '工艺编号'},
				{field : 'technologyName', width : 100, align : 'center', title : '工艺名称'},
				{field : 'price', width : 100, align : 'center', title : '外协价格'},
				{field : 'vitalProcessPeriod', width : 140, title : '瓶颈工序工期', align:'center'},
				{field : 'standardCapacity', width : 140, title : '标准加工能力', align:'center'},
				{field : 'overtimeStandardCapacity', width : 160, title : '加班标准加工能力', align:'center'},
				{field : 'overtimeOverfulfilCapacity', width : 160, title : '加班超额加工能力', align:'center'},
				{field : 'doubleCapacity', width : 140, title : '二倍工序能力', align:'center'},
				{field : 'overfulfilCapacity', width : 160, title : '超负荷工序能力', align:'center'},
	        ] ],  
	    });
	}
}

	var technologyNoteEditor ;
	
	//根据index拿到该行值
	function onTechnologyClickRow(index) {
		var rows = $('#technologyList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化客户介绍
	function formatTechnologyNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openTechnologyNote("+index+")>"+"客户介绍"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openTechnologyNote(index){ 
		
		var row = onTechnologyClickRow(index);
		$("#technologyNoteDialog").dialog({
			onOpen :function(){
				$("#technologyNoteForm [name=technologyId]").val(row.technologyId);
				technologyNoteEditor = TAOTAO.createEditor("#technologyNoteForm [name=note]");
				technologyNoteEditor.html(row.note);
				
			},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#technologyNoteForm [name=note]");
			}
		}).dialog("open");
	};
	
	function updateTechnologyNote(){
		$.get("technology/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			technologyNoteEditor.sync();
    			$.post("technology/update_note",$("#technologyNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#technologyNoteDialog").dialog("close");
    					$("#technologyList").datagrid("reload");
    					$.messager.alert("操作提示", "更新客户介绍成功！");
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	function getTechnologySelectionsIds(){
		var technologyList = $("#technologyList");
		var sels = technologyList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].technologyId);
		}
		ids = ids.join(","); 
		
		return ids;
	}
	
	function technology_add(){
    	$.get("technology/add_judge",'',function(data){
       		if(data.msg != null){
       			//$.messager.alert('提示', data.msg);
       			$("#technologyAddWindow").window("open");
       		}else{
       			$("#technologyAddWindow").window("open");
       		}
       	});
    }
    
    function technology_edit(){
    	$.get("technology/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{ 
       			var ids = getTechnologySelectionsIds();
       	    	
       	    	if(ids.length == 0){
       	    		$.messager.alert('提示','必须选择一个工艺才能编辑!');
       	    		return ;
       	    	}
       	    	if(ids.indexOf(',') > 0){
       	    		$.messager.alert('提示','只能选择一个工艺!');
       	    		return ;
       	    	}
       	    	
       	    	$("#technologyEditWindow").window({
       	    		onLoad :function(){
       	    			//回显数据
       	    			var data = $("#technologyList").datagrid("getSelections")[0];
       	    			$("#technologyEditForm").form("load", data);
       	    		}
       	    	}).window("open");
       		}
       	});
    }
    
    function technology_delete(){
    	$.get("technology/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{ 
       			var ids = getTechnologySelectionsIds();
       	    	if(ids.length == 0){
       	    		$.messager.alert('提示','未选中工艺!');
       	    		return ;
       	    	}
       	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的工艺吗？',function(r){
       	    	    if (r){
       	    	    	var params = {"ids":ids};
       	            	$.post("technology/delete_batch",params, function(data){
       	        			if(data.status == 200){
       	        				$("#technologyList").datagrid("reload");
       	        				$.messager.alert('提示','删除工艺成功!');
       	        			}else{ 
       	        				$.messager.alert('提示', data.msg);
       	        			}
       	        		});
       	    	    }
       	    	});
       		}
       	});
    }
    
    function technology_reload(){
    	$("#technologyList").datagrid("reload");
    }
</script>