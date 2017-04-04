<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="roleList" title="角色列表" data-options="singleSelect:false,collapsible:true,
		pagination:true,rownumbers:true,url:'role/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_role">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'roleId',align:'center',width:150">角色编号</th>
            <th data-options="field:'roleName',align:'center',width:150">角色名</th>
            <th data-options="field:'permission',align:'center',width:150,formatter:formatPermission">权限</th>
            <th data-options="field:'available',width:150,align:'center',formatter:formatRoleStatus">状态</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_role" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='role:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="role_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='role:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="role_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='role:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="role_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="role_reload()">刷新</a>  
	</div>  
	
    <div id="search_role" style="float: right;">
        <input id="search_text_role" class="easyui-searchbox"  
            data-options="searcher:doSearch_role,prompt:'请输入...',menu:'#menu_role'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_role" style="width:120px"> 
			<div data-options="name:'roleId'">角色编号</div> 
			<div data-options="name:'roleName'">角色名称</div>
		</div>     
    </div>  
</div>  

<div id="roleEditWindow" class="easyui-window" title="编辑角色" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'role/edit'" style="width:45%;height:60%;padding:10px;">
</div>
<div id="roleAddWindow" class="easyui-window" title="添加角色" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'role/add'" style="width:45%;height:60%;padding:10px;">
</div>

<div id="permissionWindow" class="easyui-window" title="权限管理" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'role/permission'" style="width:45%;height:60%;padding:10px;">
</div>
<script>
function doSearch_role(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#roleList").datagrid({
	        title:'角色列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_role", url:'role/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'roleId', width : 150, align:'center', title : '角色编号'},
				{field : 'roleName', width : 150, align : 'center', title : '角色名'},
				{field : 'permission', width : 150, align : 'center', title : '权限', formatter:formatPermission},
				{field : 'available', width : 150, title : '状态', align:'center', formatter:formatRoleStatus},
	        ] ],  
	    });
	}else{
		$("#roleList").datagrid({  
	        title:'角色列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_role", url:'role/search_role_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'roleId', width : 150, align:'center', title : '角色编号'},
				{field : 'roleName', width : 150, align : 'center', title : '角色名'},
				{field : 'permission', width : 150, align : 'center', title : '权限', formatter:formatPermission},
				{field : 'available', width : 150, title : '状态', align:'center', formatter:formatRoleStatus},
	        ] ],  
	    });
	}
}

	//格式化客户介绍
	function formatPermission(value, row, index){ 
		return "<a href=javascript:openPermission("+index+")>"+"权限"+"</a>";
	}
	function formatRoleStatus(value){
        if (value == 1){
            return '有效';
        }else if(value == 2){
        	return '<span style="color:red;">锁定</span>';
        }else {
        	return '<span style="color:#E5B717;">未知状态角色</span>';
        }
    }
	
	//根据index拿到该行值
	function onRoleClickRow(index) {
		var rows = $('#roleList').datagrid('getRows');
		return rows[index];
		
	}
	
	function getRoleSelectionsIds(){
    	var roleList = $("#roleList");
    	var sels = roleList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].roleId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
	var j;
	function  openPermission(index){ 
		var data = onRoleClickRow(index);
		$("#permissionWindow").window({
    		onLoad :function(){
    			//回显数据
    			$("#permissionForm").form("load", data);
    			rolePermissionInit();
    		}
    	}).window("open");
	};
	
	function role_add(){
    	$.get("role/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#roleAddWindow").window("open");
       		}
       	});
    }
    
    function role_edit(){
    	$.get("role/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getRoleSelectionsIds();
            	
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个角色才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个角色!');
            		return ;
            	}
            	
            	$("#roleEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#roleList").datagrid("getSelections")[0];
            			$("#roleEditForm").form("load", data);
            			permissionInit();
            		}
            	}).window("open");
       		}
       	});
    }
    
    function role_delete(){
    	$.get("role/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getRoleSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中角色!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除ID为 '+ids+' 的角色吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("role/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除角色成功!',undefined,function(){
                					$("#roleList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function role_reload(){
    	$("#roleList").datagrid("reload");
    }
</script>