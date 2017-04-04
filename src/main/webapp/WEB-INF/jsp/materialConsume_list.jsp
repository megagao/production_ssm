<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="materialConsumeList" title="物料消耗列表" data-options="singleSelect:false,
		collapsible:true,pagination:true,rownumbers:true,url:'materialConsume/list',method:'get',pageSize:10,fitColumns:true,
		toolbar:toolbar_materialConsume">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'consumeId',align:'center',width:100">物料消耗编号</th>
            <th data-options="field:'work',align:'center',width:100,formatter:formatWork">所属作业</th>
            <th data-options="field:'material',align:'center',width:100,formatter:formatMaterial">物料</th>
            <th data-options="field:'consumeAmount',align:'center',width:100">消耗数量</th>
            <th data-options="field:'consumeDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				消耗日期
			</th>
            <th data-options="field:'sender',width:100,align:'center'">发送者</th>
            <th data-options="field:'receiver',width:100,align:'center'">接收者</th>           
            <th data-options="field:'note',width:100,align:'center', formatter:formatMaterialConsumeNote">备注</th>            
        </tr>
    </thead>
</table>

<div  id="toolbar_materialConsume" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='materialConsume:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="materialConsume_add()">
					新增
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='materialConsume:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="materialConsume_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='materialConsume:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel"
				   onclick="materialConsume_delete()">删除</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="materialConsume_reload()">
			刷新
		</a>
	</div>  
	
    <div id="search_materialConsume" style="float: right;">
        <input id="search_text_materialConsume" class="easyui-searchbox"  
            data-options="searcher:doSearch_materialConsume,prompt:'请输入...',menu:'#menu_materialConsume'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_materialConsume" style="width:120px"> 
			<div data-options="name:'consumeId'">物料消耗编号</div> 
			<div data-options="name:'workId'">作业编号</div>
			<div data-options="name:'materialId'">物料编号</div> 
		</div>     
    </div>  

</div>  

<div id="materialConsumeEditWindow" class="easyui-window" title="编辑" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'materialConsume/edit'" style="width:65%;height:75%;padding:10px;">
</div>
<div id="materialConsumeAddWindow" class="easyui-window" title="添加" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'materialConsume/add'" style="width:65%;height:75%;padding:10px;">
</div>

<div id="materialConsumeNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px">
	<form id="materialConsumeNoteForm" class="itemForm" method="post">
		<input type="hidden" name="consumeId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:450px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table><span style="color:green;font-size: 12px;font-family: Microsoft YaHei;margin-left: 20px"></span>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateMaterialConsumeNote()">保存</a>
	</div>
</div>
<!-- 物料对话框内容信息 -->
<div id="materialConsumeMaterialInfo" class="easyui-dialog" title="物料信息" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:65%;height:65%;padding:10px;">
	<form id="materialConsumeMaterialForm" method="post">
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
	            	<input class="easyui-numberbox" type="text" name="remaining"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialConsumeMaterialEditForm()">
			提交
		</a>
	</div>
</div>
<!-- 工作表对话框信息内容 -->
<div id="materialConsumeWorkInfo" class="easyui-dialog" title="作业信息" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:40%;height:55%;padding:10px;">
<form id="materialConsumeWorkForm" class="workForm" method="post">
		<input type="hidden" name="workId"/>
	    <table cellpadding="5">
	    	<tr>
	            <td>工序号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="processNumber" data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>产品:</td>
	            <td>
	            	<input class="easyui-combobox" name="productId"   
    					data-options="valueField:'productId',textField:'productName',url:'product/get_data'"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>工序:</td>
	            <td>
	            	<input class="easyui-combobox" name="processId"   
    					data-options="valueField:'processId',textField:'processId',url:'process/get_data'"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>设备:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceId"   
    					data-options="valueField:'deviceId',textField:'deviceName',url:'deviceList/get_data'"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>班产定额:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="rating"/>
    			</td>  
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitMaterialConsumeWorkForm()">提交</a>
	</div>
</div>
<script>
    function doSearch_materialConsume(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#materialConsumeList").datagrid({
	        title:'物料消耗列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_materialConsume", url:'materialConsume/list', method:'get',
			loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 	      	        
				{field : 'ck', checkbox:true },
				{field : 'consumeId', width : 100, title : '物料消耗编号', align:'center'},
				{field : 'work', width : 100, align : 'center', title : '所属作业', formatter:formatWork},
				{field : 'material', width : 100, align : 'center', title : '物料', formatter:formatMaterial},
				{field : 'consumeAmount', width : 100, title : '消耗数量', align:'center'},
				{field : 'consumeDate', width : 130, title : '消耗日期', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'sender', width : 100, title : '发送者', align:'center'},
				{field : 'receiver', width : 100, title : '接收者', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatMaterialConsumeNote}
	        ] ],  
	    });
	}else{
		$("#materialConsumeList").datagrid({  
	        title:'物料消耗列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_materialConsume", url:'materialConsume/search_materialConsume_by_'
			+name+'?searchValue='+value, loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'consumeId', width : 100, title : '物料消耗编号', align:'center'},
				{field : 'work', width : 100, align : 'center', title : '所属作业', formatter:formatWork},
				{field : 'material', width : 100, align : 'center', title : '物料', formatter:formatMaterial},
				{field : 'consumeAmount', width : 100, title : '消耗数量', align:'center'},
				{field : 'consumeDate', width : 130, title : '消耗日期', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'sender', width : 100, title : '发送者', align:'center'},
				{field : 'receiver', width : 100, title : '接收者', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatMaterialConsumeNote}
	        ] ],  
	    });
	}
}
	var materialConsumeNoteEditor ;
	
	var materialConsumeMaterialEditor;
	
	//格式化工作表
	function formatWork(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openWork("+index+")>"+value.workId+"</a>";
		}else{
			return "无";
		}
	};  
	
	//格式化物料信息
	function  formatMaterial(value, row, index){ 
		if(value.materialId !=null && value.materialId != ''){
			return "<a href=javascript:openMaterial("+index+")>"+value.materialId+"</a>";
		}else{
			return "无";
		}
	};
	
	//格式化备注
	function formatMaterialConsumeNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openMaterialConsumeNote("+index+")>"+"详情"+"</a>";
		}else{
			return "无";
		}
	}

	//根据index拿到该行值
	function onMaterialConsumeClickRow(index) {
		var rows = $('#materialConsumeList').datagrid('getRows');
		return rows[index];
		
	}
	//打开工作表信息对话框
	function  openWork(index){ 
		var row = onMaterialConsumeClickRow(index);
		$("#materialConsumeWorkInfo").dialog({
    		onOpen :function(){
    			$.get("work/get/"+row.work.workId,'',function(data){
    				data.processId = data.process.processId; 
  	        		data.productId = data.product.productId;
  	        		data.deviceId = data.device.deviceId;
		    		//回显数据
		    		$("#materialConsumeWorkForm").form("load", data);
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#materialConsumeWorkForm [name=note]");
			}
    	}).dialog("open");
	};
	
	//提交作业信息
	function submitMaterialConsumeWorkForm(){
		$.get("work/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#materialConsumeWorkForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			$.post("work/update_all",$("#materialConsumeWorkForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改成功!','info',function(){
    						$("#materialConsumeWorkInfo").dialog('close');
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}  
    			});
    		}
    	});	
	}
	
	
	//打开物料信息对话框
	function  openMaterial(index){ 
		var row = onMaterialConsumeClickRow(index);
		$("#materialConsumeMaterialInfo").dialog({
    		onOpen :function(){
    			$.get("material/get/"+row.material.materialId,'',function(data){
    				
    				materialConsumeMaterialEditor = TAOTAO.createEditor("#materialConsumeMaterialForm [name=note]");	
		    		//回显数据
		    		$("#materialConsumeMaterialForm").form("load", data);
		    		materialConsumeMaterialEditor.html(data.note);		   
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#materialConsumeMaterialForm [name=note]");
			}
    	}).dialog("open");
	};
	//提交物料对话框信息
	function submitMaterialConsumeMaterialEditForm(){
		$.get("material/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#materialConsumeMaterialForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			materialConsumeMaterialEditor.sync();
    			$.post("material/update_all",$("#materialConsumeMaterialForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改成功!','info',function(){
    						$("#materialConsumeMaterialInfo").dialog('close');
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}  
    			});
    		}
    	});	
	}
	
	//打开备注对话框
	function  openMaterialConsumeNote(index){ 
		var row = onMaterialConsumeClickRow(index);
		$("#materialConsumeNoteDialog").dialog({
    		onOpen :function(){
    			$("#materialConsumeNoteForm [name=consumeId]").val(row.consumeId);
    			materialConsumeNoteEditor = TAOTAO.createEditor("#materialConsumeNoteForm [name=note]");
    			materialConsumeNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#materialConsumeNoteForm [name=note]");
			}
    	}).dialog("open");
		
	};
	
	//更新备注
	function updateMaterialConsumeNote(){
		$.get("materialConsume/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			materialConsumeNoteEditor.sync();
    			$.post("materialConsume/update_note",$("#materialConsumeNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#materialConsumeNoteDialog").dialog("close");
    					$("#materialConsumeList").datagrid("reload");
    					$.messager.alert("操作提示", "更新物料消耗详情成功！");
    				}else{
    					$.messager.alert('提示',data.msg);
    				}  
    			});
    		}
    	});
	}
	
    function getMaterialConsumeSelectionsIds(){
    	var materialConsumeList = $("#materialConsumeList");
    	var sels = materialConsumeList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].consumeId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }

    function materialConsume_add(){
    	$.get("materialConsume/add_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			$("#materialConsumeAddWindow").window("open");
        		}
        	});
       	
    }
    
    function materialConsume_edit(){
    	$.get("materialConsume/edit_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getMaterialConsumeSelectionsIds();
                	
                	if(ids.length == 0){
                		$.messager.alert('提示','必须选择一个记录才能编辑!');
                		return ;
                	}
                	if(ids.indexOf(',') > 0){
                		$.messager.alert('提示','只能选择一个记录!');
                		return ;
                	}
                	
                	$("#materialConsumeEditWindow").window({
                		onLoad :function(){
                			//回显数据
                			var data = $("#materialConsumeList").datagrid("getSelections")[0];
                			if(data.work !=null && data.work != ''){
                				data.workId = data.work.workId; 
                			}
                			if(data.material.materialId !=null && data.material.materialId != ''){
                				data.materialId = data.material.materialId;
                			}
                			data.consumeDate = TAOTAO.formatDateTime(data.consumeDate);
                			$("#materialConsumeEditForm").form("load", data);
                			materialConsumeEditEditor.html(data.note);              		
                		}
                	}
                	).window("open");
        		}
       	});
    }
    
    function materialConsume_delete(){
    	$.get("materialConsume/delete_judge",'',function(data){
        		if(data.msg != null){
        			$.messager.alert('提示', data.msg);
        		}else{
        			var ids = getMaterialConsumeSelectionsIds();
                	if(ids.length == 0){
                		$.messager.alert('提示','未选中记录!');
                		return ;
                	}
                	$.messager.confirm('确认','确定删除ID为 '+ids+' 的记录吗？',function(r){
                	    if (r){
                	    	var params = {"ids":ids};
                        	$.post("materialConsume/delete_batch",params, function(data){
                    			if(data.status == 200){
                    				$.messager.alert('提示','删除成功!',undefined,function(){
                    					$("#materialConsumeList").datagrid("reload");
                    				});
                    			}
                    		});
                	    }
                	});
        		}
        	});
      
    }
    
    function materialConsume_reload(){
    	$("#materialConsumeList").datagrid("reload");
    }
    
</script>