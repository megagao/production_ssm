<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<!-- singleSelect:true, -->
<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<table id="deviceCheck" title="设备例检" style="height:389px"  
	data-options="
	   rownumbers:true,
	   toolbar:'#toobar_deviceCheck',
	   url:'json/deviceCheck_All.json',
	   method:'get',
	   pagination:true,
	   pageSize:10,
	   pageList:[10, 20, 30], 
	   remoteSort:false,
	   multiSort:true,
	   onClickRow: onClickRow_deviceCheck,
	   onClickCell:onClickCell_deviceCheck
	   ">

	<thead>
		<tr>

			<th data-options="field:'ck',checkbox:true"></th>

			<th
				data-options="field:'deviceCheckID',width:80,align:'center',sortable:true,
							type:'text'
			">例检编号</th>

			<th
				data-options="field:'deviceID',width:80,align:'center',sortable:true,
							editor:{
								type:'textbox',
								options:{
									required:true									
								}
							}
			">设备编号</th>

			<th
				data-options="field:'deviceIDD',width:100,align:'center',sortable:true,
							formatter:function(value,row){
								return row.deviceName;
							},
							editor:{
								type:'combobox',
								options:{
									valueField:'deviceIDD',
									textField:'deviceName',
									method:'get',
									url:'json/deviceCheck_Name.json',
									panelHeight:'auto' 
								}
							}
			
			">设备名称</th>

			<th
				data-options="field:'deviceCheckEmp',width:120,align:'center', 
						editor:'text'
			">例检人</th>

			<th
				data-options="field:'deviceCheckDate',width:190,align:'center', sortable:true,
						editor:'datetimebox'
			">例检时间</th>

			<th
				data-options="field:'deviceCheckResult',width:120,align:'center', 
						editor:'text'
			">例检结果</th>
			
			<th
				data-options="field:'deviceCheckFaultIDD',width:100,align:'center',sortable:true,
							formatter:function(value,row){
								return row.deviceCheckFaultID;
							},
							editor:{
								type:'combobox',
								options:{
									valueField:'deviceCheckFaultIDD',
									textField:'deviceCheckFaultID',
									method:'get',
									url:'json/deviceCheck_FaultID.json',
									panelHeight:'auto' 
								}
							}
			
			">设备故障编号</th>
			
			
		</tr>
	</thead>
</table>

<div style="margin:8px 0;"></div>

<div id="tabs_deviceCheck" class="easyui-tabs"
	style="width:100%;height:331px">
	<!-- tabPosition="left" -->
	<div title="关于" style="padding:10px">
		<p style="font-size:16px">此选项卡包含“设备信息”、“设备例检人信息”和“设备故障信息”三个选项卡 --></p>
		<ul style="font-size:14px">
			<li>点击每行数据的“设备编号”字段或“例检人”字段或“设备故障编号”字段可查看相对应的详细信息</li>
		</ul>
	</div>

	<!-- Device Info Tab
	closable:true -->

	<div id="tab_device_deviceCheck" title="设备信息"
		data-options="iconCls:'icon-tip',closable:true " style="padding:10px">
		<form id="tab_device_form_deviceCheck" class="easyui-form" method="post">
			<table cellpadding="4">
				<tr>
					<td>设备名称 :</td>
					<td><input class="easyui-textbox" type="text"
						name="name_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>

					<td>设备种类 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeName_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>出厂日期 :</td>
					<td><input class="easyui-datetimebox" type="datetime"
						name="manufactureDate_form_deviceCheck" style="width:138px"
						data-options="editable:false" /></td>

					<td>使用年限 :</td>
					<td><input class="easyui-textbox" type="text"
						name="serviceLife_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>购买日期 :</td>
					<td><input class="easyui-datetimebox" type="datetime"
						name="purchaseDate_form_deviceCheck" style="width:138px"
						data-options="editable:false" /></td>

					<td>设备状态 :</td>
					<td><input class="easyui-textbox" type="text"
						name="status_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>保管人 :</td>
					<td><input class="easyui-textbox" type="text"
						name="keeper_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>备注 :</td>
					<td><input class="easyui-textbox" type="text"
						name="note_form_deviceCheck" style="width:99px;height:99px;"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>不全....</td>
				</tr>
			</table>
		</form>
	</div>
 
	<!-- Device Emp Tab
	closable:true -->
	<div id="tab_deviceEmp_deviceCheck" title="设备例检人信息"
		data-options="iconCls:'icon-tip',closable:true  " style="padding:10px">
		<form id="tab_deviceEmp_form_deviceCheck" class="easyui-form" method="post">
			<table cellpadding="4">
				<tr>
					<td>编号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="empID_form_deviceCheck" style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>姓名 :</td>
					<td><input class="easyui-textbox" type="text"
						name="empName_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>

					<td>性别 :</td>
					<td><input class="easyui-textbox" type="text"
						name="empSex_form_deviceCheck" style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>出生日期 :</td>
					<td><input class="easyui-datebox" type="date"
						name="empBirthday_form_deviceCheck" style="width:147px"
						data-options="editable:false" /></td>

					<td>身份证号 :</td>
					<td><input class="easyui-numberbox" type="number"
						name="empPersonalIdentity_form_deviceCheck" style="width:156px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>入职日期 :</td>
					<td><input class="easyui-datebox" type="date"
						name="empEntryDate_form_deviceCheck" style="width:147px"
						data-options="editable:false" /></td>

					<td>所属部门 :</td>
					<td><input class="easyui-textbox" type="text" name="empDept_form_deviceCheck"
						style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>员工状态 :</td>
					<td><input class="easyui-textbox" type="text" name="empStatus_form_deviceCheck"
						style="width:99px" data-options="editable:false" /></td>
				</tr>

				<tr>
					<td>不全....</td>
				</tr>
			</table>
		</form>
	</div>
	
	<!-- Device Fault Tab
	closable:true -->
	<div id="tab_deviceFault_deviceCheck" title="设备故障信息"
		data-options="iconCls:'icon-tip',closable:true  " style="padding:10px">
		<form id="tab_deviceFault_form_deviceCheck" class="easyui-form" method="post">
			<table cellpadding="4">
				<tr>
					<td>故障编号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="faultID_form_deviceCheck" style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>设备编号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="deviceID_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>

					<td>设备名称 :</td>
					<td><input class="easyui-textbox" type="text"
						name="deviceName_form_deviceCheck" style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>故障日期 :</td>
					<td><input class="easyui-datebox" type="date"
						name="faultDate_form_deviceCheck" style="width:147px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>故障原因 :</td>
					<td><input class="easyui-textbox" type="text"
						name="faultCause_form_deviceCheck" style="width:147px;height:147px;"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>维修方式 :</td>
					<td><input class="easyui-textbox" type="text" name="maintenance_form_deviceCheck"
						style="width:147px" data-options="editable:false" /></td>
				</tr>

			</table>
		</form>
	</div>
</div>

 
<div id="toobar_deviceCheck" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="append_deviceCheck()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-remove',plain:true" onclick="remove_deviceCheck()">移除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-undo',plain:true" onclick="reject_deviceCheck()">撤销</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true" onclick="accept_deviceCheck()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-search',plain:true" onclick="getChanges_deviceCheck()">查看改变</a>
</div>

<div style="margin:18x 0;"></div>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>

<script type="text/javascript">
	var deviceCheckEditIndex = undefined;
	function endEditing_deviceCheck() {
		if (deviceCheckEditIndex == undefined) {
			return true
		}
		if ($('#deviceCheck').datagrid('validateRow', deviceCheckEditIndex)) {
			/* deviceName */
			var deviceNameED = $('#deviceCheck').datagrid('getEditor', {
				index : deviceCheckEditIndex,
				field : 'deviceIDD'
			});
			var deviceName = $(deviceNameED.target).combobox('getText');
			$('#deviceCheck').datagrid('getRows')[deviceCheckEditIndex]['deviceName'] = deviceName;
			
			/* deviceCheckFaultID */
			var deviceCheckFaultIDED = $('#deviceCheck').datagrid('getEditor', {
				index : deviceCheckEditIndex,
				field : 'deviceCheckFaultIDD'
			});
			var deviceCheckFaultID = $(deviceCheckFaultIDED.target).combobox('getText');
			$('#deviceCheck').datagrid('getRows')[deviceCheckEditIndex]['deviceCheckFaultID'] = deviceCheckFaultID;

			/* End Edit */
			$('#deviceCheck').datagrid('endEdit', deviceCheckEditIndex);
			deviceCheckEditIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	
	
	var onClickCellFieldValue_deviceCheck = "";
	function onClickCell_deviceCheck(index, field) {
		onClickCellFieldValue_deviceCheck = field;
	} 


	function onClickRow_deviceCheck(index, row) {
		if (deviceCheckEditIndex != index) {
			if (endEditing_deviceCheck()) {
				$('#deviceCheck').datagrid('selectRow', index).datagrid(
						'beginEdit', index);
				deviceCheckEditIndex = index;
			} else {
				$('#deviceCheck').datagrid('selectRow', deviceCheckEditIndex);
			}
			$('#deviceCheck').datagrid('clearSelections');
		}

		if (onClickCellFieldValue_deviceCheck === "deviceID") {
			var tabs_deviceCheck = $("#tabs_deviceCheck");
			var detailInfoTab = tabs_deviceCheck.tabs("getTab", "设备信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceCheck.tabs("select", "设备信息");
loadData_name_form_deviceCheck(row.deviceID);		
		} else if (onClickCellFieldValue_deviceCheck === "deviceCheckEmp") {
			var tabs_deviceCheck = $("#tabs_deviceCheck");
			var detailInfoTab = tabs_deviceCheck.tabs("getTab", "设备例检人信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceCheck.tabs("select", "设备例检人信息");
loadData_empName_form_deviceCheck(row.deviceCheckEmp);
		}else if (onClickCellFieldValue_deviceCheck === "deviceCheckFaultIDD") {
			var tabs_deviceCheck = $("#tabs_deviceCheck");
			var detailInfoTab = tabs_deviceCheck.tabs("getTab", "设备故障信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceCheck.tabs("select", "设备故障信息");
loadData_faultID_form_deviceCheck(row.deviceCheckFaultIDD);
		}

	}
 
	function append_deviceCheck() {
		if (endEditing_deviceCheck()) {
			var newIDIndex = $('#deviceCheck').datagrid('getRows').length - 1;
			var newID_string = $('#deviceCheck').datagrid('getRows')[newIDIndex].deviceCheckID;
			var newID_int = parseInt(newID_string) + 1;
			if (newID_int < 10)
				newID_int = "00" + newID_int;
			else if (newID_int < 100)
				newID_int = "0" + newID_int;

			$('#deviceCheck').datagrid('appendRow', {
				deviceCheckID : newID_int
			});
			deviceCheckEditIndex = $('#deviceCheck').datagrid('getRows').length - 1;
			$('#deviceCheck').datagrid('selectRow', deviceCheckEditIndex).datagrid(
					'beginEdit', deviceCheckEditIndex);

			$('#deviceCheck').datagrid('clearSelections');
		}
	}

	function remove_deviceCheck() {
		var selections = $('#deviceCheck').datagrid('getSelections');

		for (var i = 0; i < selections.length; i++) {
			var selectionIndex = $('#deviceCheck').datagrid('getRowIndex',
					selections[i]);
			$('#deviceCheck').datagrid('deleteRow', selectionIndex);
		}
		deviceCheckEditIndex = undefined;
	}

	function accept_deviceCheck() {
		if (endEditing_deviceCheck()) {
			$('#deviceCheck').datagrid('acceptChanges');
		}
	}

	function reject_deviceCheck() {
		$('#deviceCheck').datagrid('rejectChanges');
		deviceCheckEditIndex = undefined;
	}

	function getChanges_deviceCheck() {
		var rows = $('#deviceCheck').datagrid('getChanges');
		alert(rows.length + ' rows are changed!');
	}
 
</script>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>


<%------------------------------------- 语境菜单 ----------------------------------------------%>
  
<script type="text/javascript">
	$(function() {
		$('#deviceCheck').datagrid({
			fitColumns : true,
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
				if (!deviceCheckContextMenu) {
					createColumnMenu_deviceCheck();
				}
				deviceCheckContextMenu.menu('show', {
					left : e.pageX,
				});
			}
		});
	});
	var deviceCheckContextMenu;
	function createColumnMenu_deviceCheck() {
		deviceCheckContextMenu = $('<div/>').appendTo('body');
		deviceCheckContextMenu.menu({
			onClick : function(item) {
				if (item.iconCls == 'icon-ok') {
					$('#deviceCheck').datagrid('hideColumn', item.name);
					deviceCheckContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					$('#deviceCheck').datagrid('showColumn', item.name);
					deviceCheckContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
		var fields = $('#deviceCheck').datagrid('getColumnFields');
		for (var i = 1; i < fields.length; i++) {
			var field = fields[i];
			var col = $('#deviceCheck').datagrid('getColumnOption', field);
			deviceCheckContextMenu.menu('appendItem', {
				text : col.title,
				name : field,
				iconCls : 'icon-ok'
			});
		}
	}
</script>
 
<%------------------------------------- 语境菜单 ----------------------------------------------%>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>

<style>
.icon-filter {
	background: url('image/filter.png') no-repeat center center;
}
</style>

<script>
	$(function() {
	
		var deviceCheckForFilter = $('#deviceCheck').datagrid({
			filterBtnIconCls : 'icon-filter'
		});

		deviceCheckForFilter.datagrid('enableFilter', [ {
			field : 'deviceCheckID',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceID',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceCheckDate',
			type : 'datetimebox',
			options:{
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceCheckFaultIDD',
			type : 'text',
			options : {
				precision : -1
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}]);
	});

</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>
 
<script type="text/javascript">
	function mouseEnterEvent_deviceCheck() {
		var deviceCheckTabs = $('#tabs_deviceCheck').tabs().tabs('tabs');
		for (var i = 0; i < deviceCheckTabs.length; i++) {
			deviceCheckTabs[i].panel('options').tab.unbind().bind('mouseenter', {
				index : i
			}, function(e) {
				$('#tabs_deviceCheck').tabs('select', e.data.index);
			});
		}
	};
</script>

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>

<%-------------------------------------  Tabs  -------------------------------------%>
 
<script type="text/javascript">
	
	/* 静态载入数据，仅为测试，后再动态从数据库载入 */
	function loadData_name_form_deviceCheck(deviceName) {
		$('#tab_device_form_deviceCheck').form('load', {
			name_form_deviceCheck : deviceName

		});
	}
	/* 静态载入数据，仅为测试 ，后再动态从数据库载入*/
	function loadData_empName_form_deviceCheck(deviceEmpName) {
		$('#tab_deviceEmp_form_deviceCheck').form('load', {
			empName_form_deviceCheck : deviceEmpName

		});
	}
	/* 静态载入数据，仅为测试 ，后再动态从数据库载入*/
	function loadData_faultID_form_deviceCheck(deviceCheckFaultIDD) {
		$('#tab_deviceFault_form_deviceCheck').form('load', {
			faultID_form_deviceCheck : deviceCheckFaultIDD

		});
	}
</script> 

<%------------------------------------- Add or Remove Tabs  -------------------------------------%>

<%--------------------------------------------------------------------------%>

<script>
	$(function() {
		mouseEnterEvent_deviceCheck();

		 var deviceCheck_Tab_DeviceInfo = $('#tabs_deviceCheck').tabs('getTab', "设备信息").panel(
				'options').tab;
		deviceCheck_Tab_DeviceInfo.hide(); 
		
		var deviceCheck_Tab_Emp = $('#tabs_deviceCheck').tabs('getTab', "设备例检人信息").panel(
				'options').tab;
		deviceCheck_Tab_Emp.hide();
		
		var deviceCheck_Tab_Fault = $('#tabs_deviceCheck').tabs('getTab', "设备故障信息").panel(
				'options').tab;
		deviceCheck_Tab_Fault.hide();
	});
	$('#tabs_deviceCheck').tabs(
			{
				onBeforeClose : function(title, index) {
					if (title === "设备信息") {
						var deviceCheck_Tab_DeviceInfo = $('#tabs_deviceCheck').tabs('getTab',
								"设备信息").panel('options').tab;
						deviceCheck_Tab_DeviceInfo.hide();
					} else if (title === "设备例检人信息") {
						var deviceCheck_Tab_Emp = $('#tabs_deviceCheck').tabs('getTab',
								"设备例检人信息").panel('options').tab;
						deviceCheck_Tab_Emp.hide();
					} else if (title === "设备故障信息") {
						var deviceCheck_Tab_Fault = $('#tabs_deviceCheck').tabs('getTab',
								"设备故障信息").panel('options').tab;
						deviceCheck_Tab_Fault.hide();
					}
					/* 手动选择新选项卡，否则被隐藏的选项卡的内容无法隐藏 */
					$("#tabs_deviceCheck").tabs("select", 0);

					return false; // 阻止关闭
				}
			});
</script>

<%--------------------------------------------------------------------------%>