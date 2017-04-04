<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<!-- Table -->
<table class="easyui-datagrid" id="deviceCheck" title="设备例检列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,
       	url:'deviceCheck/list',method:'get',pageSize:30, fitColumns:true,toolbar:toolbar_deviceCheck">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'deviceCheckId',width:100,align:'center'">设备例检编号</th>
            <th data-options="field:'deviceId',width:100,align:'center'">设备编号</th>
            <th data-options="field:'deviceName',width:100,align:'center',formatter:formatDevice_deviceCheck">
            	设备名称</th>
            <th data-options="field:'deviceCheckEmp',width:100,align:'center',formatter:formatEmp_deviceCheck">
            	例检人</th>
            <th data-options="field:'deviceCheckDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">
            	例检时间</th>
            <th data-options="field:'deviceCheckResult',width:100,align:'center',
            	formatter:formatDeviceCheckResult_deviceCheck">例检结果</th>
            <th data-options="field:'deviceCheckFaultId',width:100,align:'center'">例检故障编号</th>
        </tr>
    </thead>
</table>

<!-- Toolbar -->
<div  id="toolbar_deviceCheck" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='deviceCheck:add'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="deviceCheck_add()">
		        	新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceCheck:edit'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="deviceCheck_edit()">
		        	编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='deviceCheck:delete'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="deviceCheck_delete()">
		        	删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="deviceCheck_reload()">
			刷新</a>  
	</div>  
	
    <div id="search_deviceCheck" style="float: right;">
        <input id="search_text_deviceCheck" class="easyui-searchbox"  
            data-options="searcher:doSearch_deviceCheck,prompt:'请输入...',menu:'#menu_deviceCheck'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_deviceCheck" style="width:120px"> 
			<div data-options="name:'deviceCheckId'">设备例检编号</div> 
			<div data-options="name:'deviceName'">设备名称</div>
		</div>     
    </div>  

</div>

<!-- deviceCheckAddWindow -->
<div id="deviceCheckAddWindow" class="easyui-window" title="添加设备例检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'deviceCheck/add'" style="width:65%;height:80%;padding:10px;">
</div>

<!-- deviceCheckEditWindow -->
<div id="deviceCheckEditWindow" class="easyui-window" title="编辑设备例检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'deviceCheck/edit'" style="width:65%;height:80%;padding:10px;">
</div>

<!-- 设备信息 -->
<div id="deviceInfo_deviceCheck" class="easyui-dialog" title="设备信息" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="deviceEditForm_deviceCheck" method="post">
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
	            <td><input id="deviceTypeName" class="easyui-combobox" name="deviceTypeId" panelHeight="auto" 
	            	value="01" data-options="editable:false,valueField:'deviceTypeId',textField:'deviceTypeName',
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
	            <td><input class="easyui-datetimebox" name="deviceManufactureDate" /></td>
	        </tr>
	        <tr>
	            <td>使用年限:</td>
	            <td><input class="easyui-datetimebox" name="deviceServiceLife" /></td>
	        </tr>
	        <tr>
	            <td>保管人:</td>
	            <td><input id="deviceKeeper" class="easyui-combobox" name="deviceKeeperId" panelHeight="auto" 
    					data-options="required:true,editable:false,valueField:'empId',textField:'empName',
    						url:'employee/get_data'" /></td>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitDeviceEditForm_deviceCheck()">
	    	提交</a>
	</div>
</div>

<!-- 设备例检人信息 -->
<div id="empInfo_deviceCheck" class="easyui-dialog" title="设备例检人信息" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save'" style="width:33%;height:65%;padding:10px;">
	<form id="empEditForm_deviceCheck" method="post">
		<input type="hidden" name="empId"/>
	    <table cellpadding="5">
	        <tr>
	           	<td>姓名:</td>
	           	<td><input class="easyui-textbox" name="empName" data-options="editable:false"/></td>
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<select id="sexCombobox" class="easyui-combobox" name="sex" panelHeight="auto" 
	            		data-options="editable:false" style="width:173px">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>所属部门:</td>
	            <td>
	            	<input class="easyui-combobox" name="departmentId" panelHeight="auto"
    					data-options="valueField:'departmentId',textField:'departmentName',
    						url:'department/get_data'" />
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
	            <td><input class="easyui-textbox" name="major" /></td>
	        </tr>
	        <tr>
	            <td>受教育形式:</td>
	            <td><input class="easyui-textbox" name="educationForm" /></td>
	        </tr>
	        <tr>
	            <td>生日:</td>
	            <td><input class="easyui-datetimebox" name="birthday" /></td>
	        </tr>
	        <tr>
	            <td>入职日期:</td>
	            <td><input class="easyui-datetimebox" name="joinDate" /></td>
	        </tr>
	        <tr>
	            <td>员工状态:</td>
	            <td><input class="easyui-textbox" name="status" /></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEmpEditForm_deviceCheck()">
	    	提交</a>
	</div>
</div>

<!-- 设备例检备注信息-->
<div id="deviceCheckResultDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px;">
	<form id="deviceCheckResultForm" class="itemForm" method="post">
		<input type="hidden" name="deviceCheckId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>例检结果:</td>
	            <td>
	                <textarea style="width:800px;height:400px;visibility:hidden;" name="deviceCheckResult">
	                </textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateDeviceCheckResult()">保存</a>
	</div>
</div>

<script>

function doSearch_deviceCheck(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#deviceCheck").datagrid({
	        title:'设备例检列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
	        	nowrap:true,  
	        toolbar:"toolbar_deviceCheck", url:'deviceCheck/list', method:'get', loadMsg:'数据加载中......', 
	        	fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
	             	{field : 'ck', checkbox:true }, 
	             	{field : 'deviceCheckId', width : 100, align:'center', title : '设备例检编号'},
	             	{field : 'deviceId', width : 100, align : 'center', title : '设备编号'},
	             	{field : 'deviceName', width : 100, align : 'center', title : '设备名称', 
	             				formatter:formatDevice_deviceCheck}, 
	             	{field : 'deviceCheckEmp', width : 100, title : '例检人', align:'center',
	             				formatter:formatEmp_deviceCheck}, 
	             	{field : 'deviceCheckDate', width : 130, title : '例检时间', align:'center',
	             				formatter:TAOTAO.formatDateTime}, 
	            	{field : 'deviceCheckResult', width : 100, title : '例检结果', align:'center',
	             				formatter:formatDeviceCheckResult_deviceCheck}, 
	             	{field : 'deviceCheckFaultId', width : 100, title : '例检故障编号', align:'center'}, 
	        ] ],  
	    });
	}else{
		$("#deviceCheck").datagrid({  
	        title:'设备例检列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get', 
	        	nowrap:true,  
	        toolbar:"toolbar_deviceCheck", url:'deviceCheck/search_deviceCheck_by_'+name+'?searchValue='+value, 
	        	loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器  
	        columns : [ [ 
					{field : 'ck', checkbox:true }, 
					{field : 'deviceCheckId', width : 100, align:'center', title : '设备例检编号'},
					{field : 'deviceId', width : 100, align : 'center', title : '设备编号'},
					{field : 'deviceName', width : 100, align : 'center', title : '设备名称', 
								formatter:formatDevice_deviceCheck}, 
					{field : 'deviceCheckEmp', width : 100, title : '例检人', align:'center',
								formatter:formatEmp_deviceCheck}, 
					{field : 'deviceCheckDate', width : 130, title : '例检时间', align:'center',
								formatter:TAOTAO.formatDateTime}, 
					{field : 'deviceCheckResult', width : 100, title : '例检结果', align:'center',
								formatter:formatDeviceCheckResult_deviceCheck}, 
					{field : 'deviceCheckFaultId', width : 100, title : '例检故障编号', align:'center'}, 
	        ] ],  
	    });
	}
}

	/********************************** Toolbar function ***********************************/
	function getDeviceCheckSelectionsIds(){
		var deviceCheck = $("#deviceCheck");
		var sels = deviceCheck.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].deviceCheckId);
		}
		ids = ids.join(","); 
		return ids;
	}
	
	function deviceCheck_add(){
    	$.get("deviceCheck/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#deviceCheckAddWindow").window("open");
       		}
       	});
    }
    
    function deviceCheck_edit(){
    	$.get("deviceCheck/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceCheckSelectionsIds();
    	    	
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','必须选择一个设备例检才能编辑!');
    	    		return ;
    	    	}
    	    	if(ids.indexOf(',') > 0){
    	    		$.messager.alert('提示','只能选择一个设备例检信息!');
    	    		return ;
    	    	}
    	    	
    	    	$("#deviceCheckEditWindow").window({
    	    		onLoad :function(){
    	    			//回显数据
    	    			var data = $("#deviceCheck").datagrid("getSelections")[0];
    	    			data.deviceCheckDate = TAOTAO.formatDateTime(data.deviceCheckDate);
    	    		console.log(data);
    	    			$("#deviceCheckEditForm").form("load", data);
    	    		
    	    			deviceCheckEditEditor.html(data.deviceCheckResult);
    	    		}
    	    	}).window("open");
       		}
       	});
    }
    
    function deviceCheck_delete(){
    	$.get("deviceCheck/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getDeviceCheckSelectionsIds();
    	    	if(ids.length == 0){
    	    		$.messager.alert('提示','未选中设备例检!');
    	    		return ;
    	    	}
    	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的设备例检吗？',function(r){
    	    	    if (r){
    	    	    	var params = {"ids":ids};
    	            	$.post("deviceCheck/delete_batch",params, function(data){
    	        			if(data.status == 200){
    	        				$.messager.alert('提示','删除设备例检成功!',undefined,function(){
    	        					$("#deviceCheck").datagrid("reload");
    	        				});
    	        			}
    	        		});
    	    	    }
    	    	});
       		}
       	});
    }
    
    function deviceCheck_reload(){
    	$("#deviceCheck").datagrid("reload");
    }
    
	/*********************************** Toolbar function ***********************************/
	
	var noteEditor_device_deviceCheck;
	
	var deviceCheckNoteEditor ;
	
	//根据index拿到该行值
	function onDeviceCheckClickRow(index) {
		var rows = $('#deviceCheck').datagrid('getRows');
		return rows[index];
		
	}
	
	/************************************ DeviceCheckType Relative Object ************************************/ 
	//格式化设备名称
	function formatDevice_deviceCheck(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDevice_deviceCheck("+index+")>"+row.deviceName+"</a>";
		}else{
			return "无";
		}
	};
	/* DeviceCheckType Relative Object */ 
	
	//打开设备对话框
	function  openDevice_deviceCheck(index){ 
		var row = onDeviceCheckClickRow(index);
		$("#deviceInfo_deviceCheck").dialog({
    		onOpen :function(){
    			$.get("deviceList/get/"+row.deviceId,'',function(data){
		    		//回显数据
		    		noteEditor_device_deviceCheck = TAOTAO.createEditor("#deviceEditForm_deviceCheck [name=note]");
		    		
		    		data.devicePurchaseDate = TAOTAO.formatDateTime(data.devicePurchaseDate);
		    		data.deviceManufactureDate = TAOTAO.formatDateTime(data.deviceManufactureDate);
		    		data.deviceServiceLife = TAOTAO.formatDateTime(data.deviceServiceLife);
		    		
		    		$("#deviceInfo_deviceCheck").form("load", data);
		    		noteEditor_device_deviceCheck.html(data.note);
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#deviceEditForm_deviceCheck [name=note]");
			}
    	}).dialog("open");
	};
	
	//提交设备信息
	function submitDeviceEditForm_deviceCheck(){
		$.get("deviceList/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#deviceEditForm_deviceCheck').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			//同步文本框中的备注
    			noteEditor_device_deviceCheck.sync();
    			$.post("deviceList/update_all",$("#deviceEditForm_deviceCheck").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备信息成功!','info',function(){
    						$("#deviceInfo_deviceCheck").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误', data.msg);
    				}
    			});
    		}
    	});
	}
	/************************************ DeviceCheckType Relative Object ************************************/
	//格式化例检人信息
	function formatEmp_deviceCheck(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openEmp_deviceCheck("+index+")>"+row.deviceCheckEmp+"</a>";
		}else{
			return "无";
		}
	};
	
	//打开例检人信息对话框
	function  openEmp_deviceCheck(index){ 
		var row = onDeviceCheckClickRow(index);
		$("#empInfo_deviceCheck").dialog({
    		onOpen :function(){
    			$.get("employee/get/"+row.deviceCheckEmpId,'',function(data){
		    		//回显数据
					data.birthday = TAOTAO.formatDateTime(data.birthday);
					data.joinDate = TAOTAO.formatDateTime(data.joinDate);
					data.departmentId=data.department.departmentId;
					data.departmentName=data.department.departmentName;
		    		$("#empInfo_deviceCheck").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交设备例检人信息
	function submitEmpEditForm_deviceCheck(){
		$.get("employee/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#empEditForm_deviceCheck').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("employee/update_all",$("#empEditForm_deviceCheck").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改例检人信息成功!','info',function(){
    						$("#empInfo_deviceCheck").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误', data.msg);
    				}
    			});
    		}
    	});
	}
	
	/************************************ NoteRelative Object ************************************/
	//格式化设备例检结果
	function formatDeviceCheckResult_deviceCheck(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openDeviceCheckResult("+index+")>"+"查看"+"</a>";
		}else{
			return "无";
		}
	}
	
	function  openDeviceCheckResult(index){ 
		var row = onDeviceCheckClickRow(index);
		$("#deviceCheckResultDialog").dialog({
			onOpen :function(){
				$("#deviceCheckResultForm [name=deviceCheckId]").val(row.deviceCheckId);
				deviceCheckNoteEditor = TAOTAO.createEditor("#deviceCheckResultForm [name=deviceCheckResult]");
				deviceCheckNoteEditor.html(row.deviceCheckResult);
			},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#deviceCheckResultForm [name=deviceCheckResult]");
			}
		}).dialog("open");
	};
	
	function updateDeviceCheckResult(){
		$.get("deviceCheck/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			deviceCheckNoteEditor.sync();
    			$.post("deviceCheck/update_note",$("#deviceCheckResultForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#deviceCheckResultDialog").dialog("close");
    					$("#deviceCheck").datagrid("reload");
    					$.messager.alert("操作提示", "更新设备例检结果成功！");
    				}else{
    					$.messager.alert("操作提示",  data.msg);
    				}
    			});
    		}
    	});
	}
	/************************************ NoteRelative Object ***********************************/
</script>