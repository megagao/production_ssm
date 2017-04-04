<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<!-- Table -->
<table class="easyui-datagrid" id="deviceList" title="设备列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,
       	url:'deviceList/list',method:'get',pageSize:30, fitColumns:true,toolbar:toolbar_device">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true">
			</th>
        	<th data-options="field:'deviceId',width:100,align:'center'">
				设备编号
			</th>
            <th data-options="field:'deviceName',width:100,align:'center'">
				设备名称
			</th>
            <th data-options="field:'deviceTypeName',width:100,align:'center',formatter:formatDeviceType_deviceList">
				设备种类
			</th>
            <th data-options="field:'deviceStatusId',width:100,align:'center',formatter:TAOTAO.formatDeviceStatus">
				设备状态
			</th>
            <th data-options="field:'devicePurchaseDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				购买日期
			</th>
            <th data-options="field:'devicePurchasePrice',width:80,align:'center'">购买价格</th>
            <th data-options="field:'deviceManufactureDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				出厂日期
			</th>
            <th data-options="field:'deviceServiceLife',width:130,align:'center',formatter:TAOTAO.formatDate">
				使用年限
			</th>
            <th data-options="field:'deviceKeeper',width:100,align:'center',formatter:formatDeviceKeeper_deviceList">
				保管人
			</th>
            <th data-options="field:'note',width:100,align:'center',formatter:formatDeviceNote">备注</th>
        </tr>
    </thead>
</table>

<!-- Toolbar -->
<div  id="toolbar_device" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" > 
		<c:if test="${per=='device:add'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="device_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='device:edit'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="device_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='device:delete'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="device_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="device_reload()">刷新</a>  
	</div>  
	
    <div id="search_device" style="float: right;">
        <input id="search_text_device" class="easyui-searchbox"  
            data-options="searcher:doSearch_device,prompt:'请输入...',menu:'#menu_device'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_device" style="width:120px"> 
			<div data-options="name:'deviceId'">设备编号</div> 
			<div data-options="name:'deviceName'">设备名称</div>
			<div data-options="name:'deviceTypeName'">设备种类名称</div>
		</div>     
    </div>  

</div>

<!-- deviceAddWindow -->
<div id="deviceAddWindow" class="easyui-window" title="添加设备" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'deviceList/add'" style="width:65%;height:80%;padding:10px;">
</div>

<!-- deviceEditWindow -->
<div id="deviceEditWindow" class="easyui-window" title="编辑设备" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save',href:'deviceList/edit'" style="width:65%;height:80%;padding:10px;">
</div>

<!-- 设备种类信息 -->
<div id="deviceTypeInfo_deviceList" class="easyui-dialog" title="设备种类信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save'" style="width:33%;height:55%;padding:10px;">
	<form id="deviceTypeEditForm_deviceList" method="post">
	    <input type="hidden" name="deviceTypeId"/>
	    <table cellpadding="5">
	        <tr>
	           	<td>设备种类:</td>
	           	<td><input class="easyui-textbox" name="deviceTypeName" data-options="editable:false"/></td>
	        </tr>
	        <tr>
	            <td>设备型号:</td>
	            <td><input class="easyui-textbox" name="deviceTypeModel"/></td>
	        </tr>
	        <tr>
	            <td>设备规格:</td>
	            <td><input class="easyui-textbox" name="deviceTypeSpec"/></td>
	        </tr>
	        <tr>
	            <td>设备供应商:</td>
	            <td><input class="easyui-textbox" name="deviceTypeSupplier"/></td>
	        </tr>
	        <tr>
	            <td>设备生产商:</td>
	            <td><input class="easyui-textbox" name="deviceTypeProducer"/></td>
	        </tr>
	        <tr>
	            <td>台数:</td>
	            <td><input class="easyui-numberbox" name="deviceTypeQuantity"/></td>
	        </tr>
	        <tr>
	            <td>保修期:</td>
	            <td><input class="easyui-datetimebox" name="deviceTypeWarranty"/></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceTypeEditForm_deviceList()">提交</a>
	</div>
</div>

<!-- 设备保管人信息 -->
<div id="deviceKeeperInfo_deviceList" class="easyui-dialog" title="设备保管人信息" data-options="modal:true,
	closed:true,resizable:true,iconCls:'icon-save'" style="width:33%;height:65%;padding:10px;">
	<form id="deviceKeeperEditForm_deviceList" method="post">
		<input type="hidden" name="empId"/>
	    <table cellpadding="5">
	        <tr>
	           	<td>姓名:</td>
	           	<td><input class="easyui-textbox" name="empName" data-options="editable:false"/></td>
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<select id="sexCombobox" class="easyui-combobox" name="sex" panelHeight="auto" data-options="editable:false" style="width:173px">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>所属部门:</td>
	            <td>
	            	<input class="easyui-combobox" name="departmentId" panelHeight="auto"
    					data-options="valueField:'departmentId',textField:'departmentName',url:'department/get_data'" />
    			</td> 
	        </tr>
	        <tr>
	            <td>身份证号:</td>
	            <td><input class="easyui-textbox" name="idCode"/></td>
	        </tr>
	        <tr>
	            <td>学历:</td>
	            <td><input class="easyui-textbox" name="education"/></td>
	        </tr>
	        <tr>
	            <td>学位:</td>
	            <td><input class="easyui-textbox" name="degree"/></td>
	        </tr>
	        <tr>
	            <td>专业:</td>
	            <td><input class="easyui-textbox" name="major"/></td>
	        </tr>
	        <tr>
	            <td>受教育形式:</td>
	            <td><input class="easyui-textbox" name="educationForm"/></td>
	        </tr>
	        <tr>
	            <td>生日:</td>
	            <td><input class="easyui-datetimebox" name="birthday"/></td>
	        </tr>
	        <tr>
	            <td>入职日期:</td>
	            <td><input class="easyui-datetimebox" name="joinDate"/></td>
	        </tr>
	        <tr>
	            <td>员工状态:</td>
	            <td><input class="easyui-textbox" name="status"/></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceKeeperEditForm_deviceList()">提交</a>
	</div>
</div>

<!-- 设备备注信息-->
<div id="deviceNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:55%;height:65%;padding:10px;">
	<form id="deviceNoteForm" class="itemForm" method="post">
		<input type="hidden" name="deviceId"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateDeviceNote()">保存</a>
	</div>
</div>

<script>
function doSearch_device(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#deviceList").datagrid({
	        title:'设备列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_device", url:'deviceList/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'deviceId', width : 100, align:'center', title : '设备编号'},
				{field : 'deviceName', width : 100, align : 'center', title : '设备名称'},
				{field : 'deviceTypeName', width : 100, align : 'center', title : '设备种类',
					formatter:formatDeviceType_deviceList},
				{field : 'deviceStatusId', width : 100, title : '设备状态', align:'center',
					formatter:TAOTAO.formatDeviceStatus},
				{field : 'devicePurchaseDate', width : 130, title : '购买日期', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'devicePurchasePrice', width : 80, title : '购买价格', align:'center'},
				{field : 'deviceManufactureDate', width : 130, title : '出厂日期', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'deviceServiceLife', width : 130, title : '使用年限', align:'center',
					formatter:TAOTAO.formatDate},
				{field : 'deviceKeeper', width : 100, title : '保管人', align:'center',
					formatter:formatDeviceKeeper_deviceList},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatDeviceNote}
	        ] ],  
	    });
	}else{
		$("#deviceList").datagrid({  
	        title:'设备列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_device", url:'deviceList/search_device_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
					{field : 'ck', checkbox:true }, 
					{field : 'deviceId', width : 100, align:'center', title : '设备编号'},
					{field : 'deviceName', width : 100, align : 'center', title : '设备名称'},
					{field : 'deviceTypeName', width : 100, align : 'center', title : '设备种类',
						formatter:formatDeviceType_deviceList},
					{field : 'deviceStatusId', width : 100, title : '设备状态', align:'center',
						formatter:TAOTAO.formatDeviceStatus},
					{field : 'devicePurchaseDate', width : 130, title : '购买日期', align:'center',
						formatter:TAOTAO.formatDateTime},
					{field : 'devicePurchasePrice', width : 80, title : '购买价格', align:'center'}, 
					{field : 'deviceManufactureDate', width : 130, title : '出厂日期', align:'center',
						formatter:TAOTAO.formatDateTime},
					{field : 'deviceServiceLife', width : 130, title : '使用年限', align:'center',
						formatter:TAOTAO.formatDate},
					{field : 'deviceKeeper', width : 100, title : '保管人', align:'center',
						formatter:formatDeviceKeeper_deviceList},
					{field : 'note', width : 100, title : '备注', align:'center', formatter:formatDeviceNote}
	        ] ],  
	    });
	}
}

	/*********************************** Toolbar function ***********************************/
	function getDeviceSelectionsIds(){
		var deviceList = $("#deviceList");
		var sels = deviceList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].deviceId);
		}
		ids = ids.join(","); 
		return ids;
	}
	
	function device_add(){
    	$.get("deviceList/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#deviceAddWindow").window("open");
       		}
       	});
    }
    
    function device_edit(){
    	$.get("deviceList/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceSelectionsIds();
    	    	
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','必须选择一个设备才能编辑!');
    	    		return ;
    	    	}
    	    	if(ids.indexOf(',') > 0){
    	    		$.messager.alert('提示','只能选择一个设备!');
    	    		return ;
    	    	}
    	    	
    	    	$("#deviceEditWindow").window({
    	    		onLoad :function(){
    	    			//回显数据
    	    			var data = $("#deviceList").datagrid("getSelections")[0];
    	    			data.devicePurchaseDate = TAOTAO.formatDateTime(data.devicePurchaseDate);
    	    			data.deviceManufactureDate = TAOTAO.formatDateTime(data.deviceManufactureDate);
    	    			data.deviceServiceLife = TAOTAO.formatDateTime(data.deviceServiceLife);
    	    			$("#deviceEditForm").form("load", data);
    	    			deviceEditEditor.html(data.note);
    	    		}
    	    	}).window("open");
       		}
       	});
    }
    
    function device_delete(){
    	$.get("deviceList/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceSelectionsIds();
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','未选中设备!');
    	    		return ;
    	    	}
    	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的设备吗？',function(r){
    	    	    if (r){
    	    	    	var params = {"ids":ids};
    	            	$.post("deviceList/delete_batch",params, function(data){
    	        			if(data.status == 200){
    	        				$.messager.alert('提示','删除设备成功!',undefined,function(){
    	        					$("#deviceList").datagrid("reload");
    	        				});
    	        			}
    	        		});
    	    	    }
    	    	});
       		}
       	});
    }
    
    function device_reload(){
    	$("#deviceList").datagrid("reload");
    }
    
	/*********************************** Toolbar function ***********************************/
	
	var deviceNoteEditor ;
	
	//根据index拿到该行值
	function onDeviceClickRow(index) {
		var rows = $('#deviceList').datagrid('getRows');
		return rows[index];
		
	}
	
	/************************************ DeviceType Relative Object ************************************/ 
	//格式化设备种类
	function formatDeviceType_deviceList(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDeviceType_deviceList("+index+")>"+row.deviceTypeName+"</a>";
		}else{
			return "无";
		}
	};
	/* DeviceType Relative Object */ 
	
	//打开设备种类对话框
	function  openDeviceType_deviceList(index){ 
		var row = onDeviceClickRow(index);
		$("#deviceTypeInfo_deviceList").dialog({
    		onOpen :function(){
    			$.get("deviceType/get/"+row.deviceTypeId,'',function(data){
		    		//回显数据
		    		data.deviceTypeWarranty = TAOTAO.formatDateTime(data.deviceTypeWarranty);
		    		$("#deviceTypeInfo_deviceList").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交设备种类信息
	function submitDeviceTypeEditForm_deviceList(){
		$.get("deviceType/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceTypeEditForm_deviceList').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("deviceType/update_all",$("#deviceTypeEditForm_deviceList").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备种类信息成功!','info',function(){
    						$("#deviceTypeInfo_deviceList").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改设备种类信息失败!');
    				}
    			});
    		}
    	});
	}
	
	//提交设备保管人信息
	function submitDeviceKeeperEditForm_deviceList(){
		$.get("employee/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#deviceKeeperEditForm_deviceList').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("employee/update_all",$("#deviceKeeperEditForm_deviceList").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改保管人信息成功!','info',function(){
    						$("#deviceKeeperInfo_deviceList").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改保管人信息失败!');
    				}
    			});
    		}
    	});
	}
	/************************************ DeviceType Relative Object ************************************/
	
	/************************************ DeviceKeeper Relative Object ************************************/
	//格式化保管人信息
	function formatDeviceKeeper_deviceList(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDeviceKeeper_deviceList("+index+")>"+row.deviceKeeper+"</a>";
		}else{
			return "无";
		}
	};
	
	//打开保管人信息对话框
	function  openDeviceKeeper_deviceList(index){ 
		var row = onDeviceClickRow(index);
		$("#deviceKeeperInfo_deviceList").dialog({
    		onOpen :function(){
    			$.get("employee/get/"+row.deviceKeeperId,'',function(data){
		    		//回显数据
					data.birthday = TAOTAO.formatDateTime(data.birthday);
					data.joinDate = TAOTAO.formatDateTime(data.joinDate);
					data.departmentId=data.department.departmentId;
					data.departmentName=data.department.departmentName;
		    		$("#deviceKeeperInfo_deviceList").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交设备保管人信息
	function submitDeviceTypeEditForm_deviceList(){
		$.get("deviceType/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceTypeEditForm_deviceList').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("deviceType/update_all",$("#deviceTypeEditForm_deviceList").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备种类信息成功!','info',function(){
    						$("#deviceTypeInfo_deviceList").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改设备种类信息失败!');
    				}
    			});
    		}
    	});
	}
	/************************************ DeviceKeeper Relative Object ************************************/
	
	/************************************ NoteRelative Object ************************************/
	//格式化设备介绍
	function formatDeviceNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDeviceNote("+index+")>"+"设备介绍"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openDeviceNote(index){ 
		var row = onDeviceClickRow(index);
		$("#deviceNoteDialog").dialog({
			onOpen :function(){
				$("#deviceNoteForm [name=deviceId]").val(row.deviceId);
				deviceNoteEditor = TAOTAO.createEditor("#deviceNoteForm [name=note]");
				deviceNoteEditor.html(row.note);
			},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#deviceNoteForm [name=note]");
			}
		}).dialog("open");
	};
	
	function updateDeviceNote(){
		$.get("deviceList/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			deviceNoteEditor.sync();
    			$.post("deviceList/update_note",$("#deviceNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#deviceNoteDialog").dialog("close");
    					$("#deviceList").datagrid("reload");
    					$.messager.alert("操作提示", "更新设备介绍成功！");
    				}else{
    					$.messager.alert("操作提示", "更新设备介绍失败！","error");
    				}
    			});
    		}
    	});
	}
	/************************************ NoteRelative Object ************************************/
</script>