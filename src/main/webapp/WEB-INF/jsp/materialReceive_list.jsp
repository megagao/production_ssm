<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="materialReceiveList" title="物料收入列表" data-options="singleSelect:false,
		collapsible:true,pagination:true,rownumbers:true,url:'materialReceive/list',method:'get',pageSize:10,
		fitColumns:true,toolbar:toolbar_materialReceive">
    <thead>
         <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'receiveId',align:'center',width:100">物料收入编号</th>
            <th data-options="field:'material',width:100,align:'center',formatter:formatMaterial">物料</th>
            <th data-options="field:'ammount',align:'center',width:100">收入数量</th>
            <th data-options="field:'receiveDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				收入日期
			</th>
            <th data-options="field:'sender',align:'center',width:100">发送者</th>
            <th data-options="field:'receiver',align:'center',width:100">接收者</th>
            <th data-options="field:'note',width:100,align:'center', formatter:formatMaterialReceiveNote">备注</th>        
        </tr>
    </thead>
</table>

<div  id="toolbar_materialReceive" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='materialReceive:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="materialReceive_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='materialReceive:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="materialReceive_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='materialReceive:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="materialReceive_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="materialReceive_reload()">
			刷新
		</a>
	</div>  
	
    <div id="search_materialReceive" style="float: right;">
        <input id="search_text_materialReceive" class="easyui-searchbox"  
            data-options="searcher:doSearch_materialReceive,prompt:'请输入...',menu:'#menu_materialReceive'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_materialReceive" style="width:120px"> 
			<div data-options="name:'receiveId'">物料收入编号</div> 
			<div data-options="name:'materialId'">物料编号</div>	
		</div>     
    </div>  

</div>  

<div id="materialReceiveEditWindow" class="easyui-window" title="编辑物料收入" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'materialReceive/edit'" style="width:65%;height:75%;padding:10px;">
</div>
<div id="materialReceiveAddWindow" class="easyui-window" title="添加物料收入" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'materialReceive/add'" style="width:65%;height:75%;padding:10px;">
</div>
<div id="materialReceiveNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px;">
	<form id="materialReceiveNoteForm" class="itemForm" method="post">
		<input type="hidden" name="receiveId"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateMaterialReceiveNote()">保存</a>
	</div>
</div>

<div id="materialInfo" class="easyui-dialog" title="物料信息" data-options="modal:true,closed:true,resizable:true,
		iconCls:'icon-save'" style="width:65%;height:65%;padding:10px;">
	<form id="materialReceiveMaterialEditForm" method="post">
		<input type="hidden" name="materialId"/>
	    <table cellpadding="5">
	          <tr>
	            <td>物料类型:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="materialType" style="width: 280px;"/>
	            </td>
	        </tr>
	        <tr>
	            <td>物料状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" style="width:200px;" data-options="width:150,
		            		editable:false">
						<option value="充足">充足</option>
						<option value="正常">正常</option>
						<option value="短缺">短缺</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>剩余数量:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="remaining"/>
	            </td>
	        </tr>
	        
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialReceiveMaterialEditForm()">提交</a>
	</div>
</div>


<script>

function doSearch_materialReceive(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#materialReceiveList").datagrid({
	        title:'物料收入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_materialReceive", url:'materialReceive/list', method:'get',
			loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 	       
				{field : 'ck', checkbox:true },
				{field : 'receiveId', width : 100, title : '物料收入编号', align:'center'},
				{field : 'material', width : 100, align : 'center', title : '物料', formatter:formatMaterial},
				{field : 'ammount', width : 100, align : 'center', title : '收入数量'},
				{field : 'receiveDate', width : 130, title : '收入日期', align:'center',formatter:TAOTAO.formatDateTime},
				{field : 'sender', width : 100, title : '发送者', align:'center'},
				{field : 'receiver', width : 100, title : '接收者', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatMaterialReceiveNote}
	        ] ],  
	    });
	}else{
		$("#materialReceiveList").datagrid({  
	        title:'物料收入列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_materialReceive", url:'materialReceive/search_materialReceive_by_'
			+name+'?searchValue='+value, loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'receiveId', width : 100, title : '物料收入编号', align:'center'},
				{field : 'material', width : 100, align : 'center', title : '物料', formatter:formatMaterial},
				{field : 'ammount', width : 100, align : 'center', title : '收入数量'},
				{field : 'receiveDate', width : 130, title : '收入日期', align:'center',formatter:TAOTAO.formatDateTime},
				{field : 'sender', width : 100, title : '发送者', align:'center'},
				{field : 'receiver', width : 100, title : '接收者', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatMaterialReceiveNote}
	        ] ],  
	    });
	}
}

	var materialReceiveNoteEditor ;
	
	var materialReceiveMaterialEditor;
	
	//根据index拿到该行值
	function onMaterialReceiveClickRow(index) {
		var rows = $('#materialReceiveList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化物料信息
	function formatMaterial(value, row, index){ 
		if(value.materialId !=null && value.materialId != ''){
			return "<a href=javascript:openMaterialReceiveMaterial("+index+")>"+value.materialId+"</a>";
		}else{
			return "无";
		}
	};  
	

	//打开物料信息对话框
	function  openMaterialReceiveMaterial(index){ 
		var row = onMaterialReceiveClickRow(index);
		$("#materialInfo").dialog({
    		onOpen :function(){
    			$.get("material/get/"+row.material.materialId,'',function(data){
    				materialReceiveMaterialEditor = TAOTAO.createEditor("#materialReceiveMaterialEditForm [name=note]");	
		    		//回显数据
		    		$("#materialReceiveMaterialEditForm").form("load", data);
		    		materialReceiveMaterialEditor.html(data.note);		   
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#materialReceiveMaterialEditForm [name=note]");
			}
    	}).dialog("open");
	};
	
	function submitMaterialReceiveMaterialEditForm(){
		$.get("material/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#materialReceiveMaterialEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			materialReceiveMaterialEditor.sync();
    			$.post("material/update_all",$("#materialReceiveMaterialEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改成功!','info',function(){
    						$("#materialInfo").dialog('close');
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				} 
    			});
    		}
    	});	
	}
	
	function formatMaterialReceiveNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openMaterialReceiveNote("+index+")>"+"详情"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openMaterialReceiveNote(index){ 
		var row = onMaterialReceiveClickRow(index);
		$("#materialReceiveNoteDialog").dialog({
			onOpen :function(){
				$("#materialReceiveNoteForm [name=receiveId]").val(row.receiveId);
				materialReceiveNoteEditor = TAOTAO.createEditor("#materialReceiveNoteForm [name=note]");
				materialReceiveNoteEditor.html(row.note);
				
			},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#materialReceiveNoteForm [name=note]");
			}
		}).dialog("open");
	};
	
	function updateMaterialReceiveNote(){
		$.get("materialReceive/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			materialReceiveNoteEditor.sync();
    			$.post("materialReceive/update_note",$("#materialReceiveNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#materialReceiveNoteDialog").dialog("close");
    					$("#materialReceiveList").datagrid("reload");
    					$.messager.alert("操作提示", "更新物料收入详情成功！");
    				}else{
    					$.messager.alert('提示',data.msg);
    				} 
    			});
    		}
    	});
	}
	
	function getMaterialReceiveSelectionsIds(){
		var materialReceiveList = $("#materialReceiveList");
		var sels = materialReceiveList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].receiveId);
		}
		ids = ids.join(","); 
		
		return ids;
	}
	
	  function materialReceive_add(){
    	$.get("materialReceive/add_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			$("#materialReceiveAddWindow").window("open");
        		}
        	});
	    
    }
    
    function materialReceive_edit(){
    	$.get("materialReceive/edit_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getMaterialReceiveSelectionsIds();
        	    	
        	    	if(ids.length == 0){
        	    		$.messager.alert('提示','必须选择一个记录才能编辑!');
        	    		return ;
        	    	}
        	    	if(ids.indexOf(',') > 0){
        	    		$.messager.alert('提示','只能选择一个记录!');
        	    		return ;
        	    	}     	    	
        	    	$("#materialReceiveEditWindow").window({
        	    		onLoad :function(){
        	    			//回显数据
        	    			var data = $("#materialReceiveList").datagrid("getSelections")[0];
        	    			if(data.material.materialId !=null && data.material.materialId != ''){
                				data.materialId = data.material.materialId;
                			}
        	    			data.receiveDate = TAOTAO.formatDateTime(data.receiveDate);
        	    			$("#materialReceiveEditForm").form("load", data);
        	    			materialReceiveEditEditor.html(data.note);
        	    		}
        	    	}).window("open");
        		}
        	});
	    }
    
    function materialReceive_delete(){
    	$.get("materialReceive/delete_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getMaterialReceiveSelectionsIds();
        	    	if(ids.length == 0){
        	    		$.messager.alert('提示','未选中记录!');
        	    		return ;
        	    	}
        	    	$.messager.confirm('确认','确定删除编号为 '+ids+' 的记录吗？',function(r){
        	    	    if (r){
        	    	    	var params = {"ids":ids};
        	            	$.post("materialReceive/delete_batch",params, function(data){
        	        			if(data.status == 200){
        	        				$.messager.alert('提示','删除成功!',undefined,function(){
        	        					$("#materialReceiveList").datagrid("reload");
        	        				});
        	        			}
        	        		});
        	    	    }
        	    	});
        		}
        	});
    }
    
    function materialReceive_reload(){
    	$("#materialReceiveList").datagrid("reload");
    }
	
</script>