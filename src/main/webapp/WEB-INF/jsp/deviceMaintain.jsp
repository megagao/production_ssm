<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<!-- Table -->
<table class="easyui-datagrid" id="deviceMaintain" title="设备维修列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,
       	url:'deviceMaintain/list',method:'get',pageSize:30, fitColumns:true,toolbar:toolbar_deviceMaintain">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'deviceMaintainId',width:100,align:'center'">设备维修编号</th>
            <th data-options="field:'deviceFaultId',width:100,align:'center',
            	formatter:formatDeviceFault_deviceMaintain">故障编号</th>
            <th data-options="field:'deviceMaintainEmp',width:100,align:'center'">维修人</th>
            <th data-options="field:'deviceMaintainDate',width:100,align:'center',
            	formatter:TAOTAO.formatDateTime">维修日期</th>
            <th data-options="field:'deviceMaintainResult',width:100,align:'center'">维修结果</th>
            <th data-options="field:'deviceMaintainCost',width:100,align:'center'">维修费用</th>
            <th data-options="field:'note',width:100,align:'center',formatter:formatDeviceMaintainNote">备注</th>
        </tr>
    </thead>
</table>

<!-- Toolbar -->
<div  id="toolbar_deviceMaintain" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='deviceMaintain:add'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" 
		        	onclick="deviceMaintain_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceMaintain:edit'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" 
		        	onclick="deviceMaintain_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceMaintain:delete'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" 
		        	onclick="deviceMaintain_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" 
			onclick="deviceMaintain_reload()">刷新</a>  
	</div>  
	
    <div id="search_deviceMaintain" style="float: right;">
        <input id="search_text_deviceMaintain" class="easyui-searchbox"  
            data-options="searcher:doSearch_deviceMaintain,prompt:'请输入...',menu:'#menu_deviceMaintain'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_deviceMaintain" style="width:120px"> 
			<div data-options="name:'deviceMaintainId'">设备维修编号</div> 
			<div data-options="name:'deviceFaultId'">故障编号</div>
		</div>     
    </div>  

</div>

<!-- deviceMaintainAddWindow -->
<div id="deviceMaintainAddWindow" class="easyui-window" title="添加设备维修" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'deviceMaintain/add'" style="width:65%;height:80%;padding:10px;">
</div>

<!-- deviceMaintainEditWindow -->
<div id="deviceMaintainEditWindow" class="easyui-window" title="编辑设备维修" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'deviceMaintain/edit'" style="width:65%;height:80%;padding:10px;">
</div>

<!-- 设备故障信息 -->
<div id="deviceFaultInfo_deviceMaintain" class="easyui-dialog" title="设备信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="deviceFaultEditForm_deviceMaintain" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>故障编号:</td>
	            <td>
	            	<input class="easyui-textbox"  name="deviceFaultId" data-options="editable:false"/>
	            </td>
	        </tr>
	        <tr>
	            <td>设备名称:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceId" panelHeight="auto" 
    					data-options="editable:false,valueField:'deviceId',textField:'deviceName',
    						url:'deviceList/get_data'" />
	            </td>
	        </tr>
	        <tr>
	            <td>故障日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceFaultDate"/>
	            </td>
	        </tr>
	        <tr>
	            <td>故障原因:</td>
	            <td>
	            	<input class="easyui-textbox"  name="deviceFaultCause"/>
	            </td>
	        </tr>
	        <tr>
	            <td>维修方式:</td>
	            <td>
	            	<input class="easyui-textbox" name="deviceFaultMaintenance"/>
	            </td>
	        </tr>
	        <tr>
	            <td>故障描述:</td>
	            <td>
	            	<textarea style="width:800px;height:300px;visibility:hidden;" name="deviceFaultDetail"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" 
	    	onclick="submitDeviceFaultEditForm_deviceMaintain()">提交</a>
	</div>
</div>

<!-- 设备维修原因-->
<div id="deviceMaintainNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px;">
	<form id="deviceMaintainNoteForm" class="itemForm" method="post">
	    <input type="hidden" name="deviceMaintainId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:400px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateDeviceMaintainNote()">保存</a>
	</div>
</div>

<script>

function doSearch_deviceMaintain(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#deviceMaintain").datagrid({
	        title:'设备维修列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_deviceMaintain", url:'deviceMaintain/list', method:'get',
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'deviceMaintainId', width : 100, align:'center', title : '维修编号'},
				{field : 'deviceFaultId', width : 100, align : 'center', title : '故障编号',
					formatter:formatDeviceFault_deviceMaintain},
				{field : 'deviceMaintainEmp', width : 100, align : 'center', title : '维修人'},
				{field : 'deviceMaintainDate', width : 100, title : '维修日期', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'deviceMaintainResult', width : 100, title : '维修结果', align:'center'},
				{field : 'deviceMaintainCost', width : 100, title : '维修费用', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center',formatter:formatDeviceMaintainNote}
	        ] ],  
	    });
	}else{
		$("#deviceMaintain").datagrid({  
	        title:'设备维修列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_deviceMaintain", url:'deviceMaintain/search_deviceMaintain_by_'
			+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'deviceMaintainId', width : 100, align:'center', title : '维修编号'},
				{field : 'deviceFaultId', width : 100, align : 'center', title : '故障编号',
					formatter:formatDeviceFault_deviceMaintain},
				{field : 'deviceMaintainEmp', width : 100, align : 'center', title : '维修人'},
				{field : 'deviceMaintainDate', width : 100, title : '维修日期', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'deviceMaintainResult', width : 100, title : '维修结果', align:'center'},
				{field : 'deviceMaintainCost', width : 100, title : '维修费用', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center',formatter:formatDeviceMaintainNote}
	        ] ],  
	    });
	}
}

	/********************************** Toolbar function ***********************************/
	function getDeviceMaintainSelectionsIds(){
		var deviceMaintain = $("#deviceMaintain");
		var sels = deviceMaintain.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].deviceMaintainId);
		}
		ids = ids.join(","); 
		return ids;
	}
	
	function deviceMaintain_add(){
    	$.get("deviceMaintain/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#deviceMaintainAddWindow").window("open");
       		}
       	});
    }
    
    function deviceMaintain_edit(){
    	$.get("deviceMaintain/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceMaintainSelectionsIds();
    	    	
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','必须选择一个设备维修才能编辑!');
    	    		return ;
    	    	}
    	    	if(ids.indexOf(',') > 0){
    	    		$.messager.alert('提示','只能选择一个设备维修信息!');
    	    		return ;
    	    	}
    	    	
    	    	$("#deviceMaintainEditWindow").window({
    	    		onLoad :function(){
    	    			//回显数据
    	    			var data = $("#deviceMaintain").datagrid("getSelections")[0];
    	    			data.deviceMaintainDate = TAOTAO.formatDateTime(data.deviceMaintainDate);
    	    			$("#deviceMaintainEditForm").form("load", data);
    	    		
    	    			deviceMaintainEditEditor.html(data.note);
    	    		}
    	    	}).window("open");
       		}
       	});
    }
    
    function deviceMaintain_delete(){
    	$.get("deviceMaintain/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceMaintainSelectionsIds();
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','未选中设备维修!');
    	    		return ;
    	    	}
    	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的设备维修吗？',function(r){
    	    	    if (r){
    	    	    	var params = {"ids":ids};
    	            	$.post("deviceMaintain/delete_batch",params, function(data){
    	        			if(data.status == 200){
    	        				$.messager.alert('提示','删除设备维修成功!',undefined,function(){
    	        					$("#deviceMaintain").datagrid("reload");
    	        				});
    	        			}
    	        		});
    	    	    }
    	    	});
       		}
       	});
    }
    
    function deviceMaintain_reload(){
    	$("#deviceMaintain").datagrid("reload");
    }
    
	/*********************************** Toolbar function ***********************************/
	
	var noteEditor_device_deviceMaintain;
	
	var deviceMaintainNoteEditor ;
	
	//根据index拿到该行值
	function onDeviceMaintainClickRow(index) {
		var rows = $('#deviceMaintain').datagrid('getRows');
		return rows[index];
	}
	
	/************************************ DeviceMaintainType Relative Object ************************************/ 
	//格式化设备故障编号
	function formatDeviceFault_deviceMaintain(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDeviceFault_deviceMaintain("+index+")>"+row.deviceFaultId+"</a>";
		}else{
			return "无";
		}
	};
	/* DeviceMaintainType Relative Object */ 
	
	//打开设备故障对话框
	function  openDeviceFault_deviceMaintain(index){ 
		var row = onDeviceMaintainClickRow(index);
		$("#deviceFaultInfo_deviceMaintain").dialog({
    		onOpen :function(){
    			$.get("deviceFault/get/"+row.deviceFaultId,'',function(data){
		    		//回显数据
		    		noteEditor_device_deviceMaintain =
							TAOTAO.createEditor("#deviceFaultEditForm_deviceMaintain [name=deviceFaultDetail]");
		    		
		    		data.deviceFaultDate = TAOTAO.formatDateTime(data.deviceFaultDate);
		    		$("#deviceFaultInfo_deviceMaintain").form("load", data);
		    		noteEditor_device_deviceMaintain.html(data.deviceFaultDetail);
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#deviceFaultEditForm_deviceMaintain [name=deviceFaultDetail]");
			}
    	}).dialog("open");
	};
	
	//提交设备信息
	function submitDeviceFaultEditForm_deviceMaintain(){
		$.get("deviceFault/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceFaultEditForm_deviceMaintain').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			noteEditor_device_deviceMaintain.sync();
    	console.log($("#deviceFaultEditForm_deviceMaintain").serialize());
    			$.post("deviceFault/update_all",$("#deviceFaultEditForm_deviceMaintain").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备故障信息成功!','info',function(){
    						$("#deviceFaultInfo_deviceMaintain").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改设备故障信息失败!');
    				}
    			});
    		}
    	});
	}
	/************************************ DeviceMaintainType Relative Object ************************************/
	
	/************************************ NoteRelative Object ************************************/
	//格式化设备维修描述
	function formatDeviceMaintainNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDeviceMaintainNote("+index+")>"+"查看"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openDeviceMaintainNote(index){ 
		var row = onDeviceMaintainClickRow(index);
		$("#deviceMaintainNoteDialog").dialog({
			onOpen :function(){
				$("#deviceMaintainNoteForm [name=deviceMaintainId]").val(row.deviceMaintainId);
				deviceMaintainNoteEditor = TAOTAO.createEditor("#deviceMaintainNoteForm [name=note]");
				deviceMaintainNoteEditor.html(row.note);
			},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#deviceMaintainNoteForm [name=deviceMaintainNote]");
			}
		}).dialog("open");
	};
	
	function updateDeviceMaintainNote(){
		$.get("deviceMaintain/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			deviceMaintainNoteEditor.sync();
    			$.post("deviceMaintain/update_note",$("#deviceMaintainNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#deviceMaintainNoteDialog").dialog("close");
    					$("#deviceMaintain").datagrid("reload");
    					$.messager.alert("操作提示", "更新设备维修备注成功！");
    				}else{
    					$.messager.alert("操作提示", "更新设备维修备注失败！","error");
    				}
    			});
    		}
    	});
	}
	/************************************ NoteRelative Object ***********************************/
</script>