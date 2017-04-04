<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<!-- Table -->
<table class="easyui-datagrid" id="deviceFault" title="设备故障列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,
       	url:'deviceFault/list',method:'get',pageSize:30, fitColumns:true,toolbar:toolbar_deviceFault">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'deviceFaultId',width:100,align:'center'">故障编号</th>
            <th data-options="field:'deviceName',width:100,align:'center',formatter:formatDevice_deviceFault">
				设备名称</th>
            <th data-options="field:'deviceFaultDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				故障日期</th>
            <th data-options="field:'deviceFaultCause',width:100,align:'center'">故障原因</th>
            <th data-options="field:'deviceFaultMaintenance',width:100,align:'center'">维修方式</th>
            <th data-options="field:'deviceFaultDetail',width:100,align:'center',formatter:formatDeviceFaultDetail">
				故障描述</th>
        </tr>
    </thead>
</table>

<!-- Toolbar -->
<div  id="toolbar_deviceFault" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='deviceFault:add'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="deviceFault_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceFault:edit'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="deviceFault_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceFault:delete'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="deviceFault_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="deviceFault_reload()">刷新</a>  
	</div>  
	
    <div id="search_deviceFault" style="float: right;">
        <input id="search_text_deviceFault" class="easyui-searchbox"  
            data-options="searcher:doSearch_deviceFault,prompt:'请输入...',menu:'#menu_deviceFault'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_deviceFault" style="width:120px"> 
			<div data-options="name:'deviceFaultId'">设备故障编号</div> 
			<div data-options="name:'deviceName'">设备名称</div>
		</div>     
    </div>  

</div>

<!-- deviceFaultAddWindow -->
<div id="deviceFaultAddWindow" class="easyui-window" title="添加设备故障" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'deviceFault/add'" style="width:65%;height:75%;padding:10px;">
</div>

<!-- deviceFaultEditWindow -->
<div id="deviceFaultEditWindow" class="easyui-window" title="编辑设备故障" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'deviceFault/edit'" style="width:65%;height:75%;padding:10px;">
</div>

<!-- 设备信息 -->
<div id="deviceInfo_deviceFault" class="easyui-dialog" title="设备信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="deviceEditForm_deviceFault" method="post">
	    
	    <table cellpadding="5">
	        <tr>
	           	<td>设备编号:</td>
	           	<td><input class="easyui-textbox" name="deviceId" data-options="editable:false"/></td>
	        </tr>
	        <tr>
	            <td>设备名称:</td>
	            <td><input class="easyui-textbox" name="deviceName" data-options="editable:false"/></td>
	        </tr>
	        <tr>
	            <td>设备种类:</td>
	            <td><input id="deviceTypeName" class="easyui-combobox" name="deviceTypeId" panelHeight="auto" value="01"
    					data-options="editable:false,valueField:'deviceTypeId',textField:'deviceTypeName',
    					url:'deviceType/get_data'" /></td>
	        </tr>
	        <tr>
	            <td>设备状态:</td>
	            <td>
	            	<select class="easyui-combobox" name="deviceStatusId" panelHeight="auto"
							data-options="required:true" style="width:173px">
						<option value="1" selected="selected">良好</option>
						<option value="2">故障</option>
						<option value="3">维修</option>
						<option value="4">报废</option>
					</select></td>
	        </tr>
	        <tr>
	            <td>设备购买日期:</td>
	            <td><input class="easyui-datetimebox" name="devicePurchaseDate"/></td>
	        </tr>
	        <tr>
	            <td>购买价格:</td>
	            <td><input class="easyui-numberbox" name="devicePurchasePrice"/></td>
	        </tr>
	        <tr>
	            <td>出厂日期:</td>
	            <td><input class="easyui-datetimebox" name="deviceManufactureDate"/></td>
	        </tr>
	        <tr>
	            <td>使用年限:</td>
	            <td><input class="easyui-datetimebox" name="deviceServiceLife"/></td>
	        </tr>
	        <tr>
	            <td>保管人:</td>
	            <td><input id="deviceKeeper" class="easyui-combobox" name="deviceKeeperId" panelHeight="auto"
						   value="001" data-options="required:true,editable:false,valueField:'deviceKeeperId',
						   textField:'deviceKeeper',url:'deviceFault/get_data'"/></td>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceEditForm_deviceFault()">提交</a>
	</div>
</div>

<!-- 设备故障原因-->
<div id="deviceFaultDetailDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px;">
	<form id="deviceFaultDetailForm" class="itemForm" method="post">
	    <input type="hidden" name="deviceFaultId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>例检结果:</td>
	            <td>
	                <textarea style="width:800px;height:400px;visibility:hidden;" name="deviceFaultDetail"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateDeviceFaultDetail()">保存</a>
	</div>
</div>

<script>

function doSearch_deviceFault(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#deviceFault").datagrid({
	        title:'设备故障列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
				nowrap:true, toolbar:"toolbar_deviceFault", url:'deviceFault/list', method:'get',
				loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'deviceFaultId', width : 100, align:'center', title : '故障编号'},
				{field : 'deviceName', width : 100, align : 'center', title : '设备名称',
					formatter:formatDevice_deviceFault},
				{field : 'deviceFaultDate', width : 130, align : 'center', title : '故障日期',
					formatter:TAOTAO.formatDateTime},
				{field : 'deviceFaultCause', width : 100, title : '故障原因', align:'center'},
				{field : 'deviceFaultMaintenance', width : 100, title : '维修方式', align:'center'},
				{field : 'deviceFaultDetail', width : 100, title : '故障描述', align:'center',
					formatter:formatDeviceFaultDetail}
	        ] ],  
	    });
	}else{
		$("#deviceFault").datagrid({  
	        title:'设备故障列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
				nowrap:true, toolbar:"toolbar_deviceFault", url:'deviceFault/search_deviceFault_by_'+name
				+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'deviceFaultId', width : 100, align:'center', title : '故障编号'},
				{field : 'deviceName', width : 100, align : 'center', title : '设备名称',
					formatter:formatDevice_deviceFault},
				{field : 'deviceFaultDate', width : 130, align : 'center', title : '故障日期',
					formatter:TAOTAO.formatDateTime},
				{field : 'deviceFaultCause', width : 100, title : '故障原因', align:'center'},
				{field : 'deviceFaultMaintenance', width : 100, title : '维修方式', align:'center'},
				{field : 'deviceFaultDetail', width : 100, title : '故障描述', align:'center',
					formatter:formatDeviceFaultDetail}
	        ] ],  
	    });
	}
}

	/********************************** Toolbar function ***********************************/
	function getDeviceFaultSelectionsIds(){
		var deviceFault = $("#deviceFault");
		var sels = deviceFault.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].deviceFaultId);
		}
		ids = ids.join(","); 
		return ids;
	}
	
	function deviceFault_add(){
    	$.get("deviceFault/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#deviceFaultAddWindow").window("open");
       		}
       	});
    }
    
    function deviceFault_edit(){
    	$.get("deviceFault/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceFaultSelectionsIds();
    	    	
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','必须选择一个设备故障才能编辑!');
    	    		return ;
    	    	}
    	    	if(ids.indexOf(',') > 0){
    	    		$.messager.alert('提示','只能选择一个设备故障信息!');
    	    		return ;
    	    	}
    	    	
    	    	$("#deviceFaultEditWindow").window({
    	    		onLoad :function(){
    	    			//回显数据
    	    			var data = $("#deviceFault").datagrid("getSelections")[0];
    	    			data.deviceFaultDate = TAOTAO.formatDateTime(data.deviceFaultDate);
    	    			$("#deviceFaultEditForm").form("load", data);
    	    		
    	    			deviceFaultEditEditor.html(data.deviceFaultDetail);
    	    		}
    	    	}).window("open");
       		}
       	});
    }
    
    function deviceFault_delete(){
    	$.get("deviceFault/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceFaultSelectionsIds();
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','未选中设备故障!');
    	    		return ;
    	    	}
    	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的设备故障吗？',function(r){
    	    	    if (r){
    	    	    	var params = {"ids":ids};
    	            	$.post("deviceFault/delete_batch",params, function(data){
    	        			if(data.status == 200){
    	        				$.messager.alert('提示','删除设备故障成功!',undefined,function(){
    	        					$("#deviceFault").datagrid("reload");
    	        				});
    	        			}
    	        		});
    	    	    }
    	    	});
       		}
       	});
    }
    
    function deviceFault_reload(){
    	$("#deviceFault").datagrid("reload");
    }
    
	/*********************************** Toolbar function ***********************************/
	
	var noteEditor_device_deviceFault;
	
	var deviceFaultNoteEditor ;
	
	//根据index拿到该行值
	function onDeviceFaultClickRow(index) {
		var rows = $('#deviceFault').datagrid('getRows');
		return rows[index];
		
	}
	
	/************************************ DeviceFaultType Relative Object ************************************/ 
	//格式化设备名称
	function formatDevice_deviceFault(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDevice_deviceFault("+index+")>"+row.deviceName+"</a>";
		}else{
			return "无";
		}
	};
	/* DeviceFaultType Relative Object */ 
	
	//打开设备对话框
	function  openDevice_deviceFault(index){ 
		var row = onDeviceFaultClickRow(index);
		$("#deviceInfo_deviceFault").dialog({
    		onOpen :function(){
    			$.get("deviceList/get/"+row.deviceId,'',function(data){
		    		//回显数据
		    		noteEditor_device_deviceFault = TAOTAO.createEditor("#deviceEditForm_deviceFault [name=note]");
		    		
		    		data.devicePurchaseDate = TAOTAO.formatDateTime(data.devicePurchaseDate);
		    		data.deviceManufactureDate = TAOTAO.formatDateTime(data.deviceManufactureDate);
		    		data.deviceServiceLife = TAOTAO.formatDateTime(data.deviceServiceLife);
		    		
		    		$("#deviceInfo_deviceFault").form("load", data);
		    		noteEditor_device_deviceFault.html(data.note);
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#deviceEditForm_deviceFault [name=note]");
			}
    	}).dialog("open");
	};
	
	//提交设备信息
	function submitDeviceEditForm_deviceFault(){
		$.get("deviceList/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceEditForm_deviceFault').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			noteEditor_device_deviceFault.sync();
    			$.post("deviceList/update_all",$("#deviceEditForm_deviceFault").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备信息成功!','info',function(){
    						$("#deviceInfo_deviceFault").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改设备信息失败!');
    				}
    			});
    		}
    	});
	}
	/************************************ DeviceFaultType Relative Object ************************************/
	
	/************************************ NoteRelative Object ************************************/
	//格式化设备故障描述
	function formatDeviceFaultDetail(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDeviceFaultDetail("+index+")>"+"查看"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openDeviceFaultDetail(index){ 
		var row = onDeviceFaultClickRow(index);
		$("#deviceFaultDetailDialog").dialog({
			onOpen :function(){
				$("#deviceFaultDetailForm [name=deviceFaultId]").val(row.deviceFaultId);
				deviceFaultNoteEditor = TAOTAO.createEditor("#deviceFaultDetailForm [name=deviceFaultDetail]");
				deviceFaultNoteEditor.html(row.deviceFaultDetail);
			},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#deviceFaultDetailForm [name=deviceFaultDetail]");
			}
		}).dialog("open");
	};
	
	function updateDeviceFaultDetail(){
		$.get("deviceFault/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			deviceFaultNoteEditor.sync();
    			$.post("deviceFault/update_note",$("#deviceFaultDetailForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#deviceFaultDetailDialog").dialog("close");
    					$("#deviceFault").datagrid("reload");
    					$.messager.alert("操作提示", "更新设备故障原因成功！");
    				}else{
    					$.messager.alert("操作提示", "更新设备故障原因失败！","error");
    				}
    			});
    		}
    	});
	}
	/************************************ NoteRelative Object ***********************************/
</script>