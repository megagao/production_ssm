<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<!-- singleSelect:true, -->
<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<table id="deviceFault" title="设备故障" style="height:389px"  
	data-options="
	   rownumbers:true,
	   toolbar:'#toobar_deviceFault',
	   url:'json/deviceFault_All.json',
	   method:'get',
	   pagination:true,
	   pageSize:10,
	   pageList:[10, 20, 30], 
	   remoteSort:false,
	   multiSort:true,
	   onClickRow: onClickRow_deviceFault,
	   onClickCell:onClickCell_deviceFault
	   ">

	<thead>
		<tr>

			<th data-options="field:'ck',checkbox:true"></th>

			<th
				data-options="field:'deviceFaultID',width:80,align:'center',sortable:true,
							type:'text'
			">故障编号</th>

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
									url:'json/deviceFault_Name.json',
									panelHeight:'auto' 
								}
							}
			
			">设备名称</th>

			<th
				data-options="field:'deviceFaultCause',width:120,align:'center', 
						editor:'text'
			">故障原因</th>
			
			<th
				data-options="field:'deviceFaultDetail',width:200,align:'center', 
						editor:'text'
			">故障描述</th>

			<th
				data-options="field:'deviceFaultDate',width:190,align:'center', sortable:true,
						editor:'datetimebox'
			">故障日期</th>

			<th
				data-options="field:'deviceFaultMaintenance',width:120,align:'center', 
						editor:'text'
			">维修方式</th>
			
		</tr>
	</thead>
</table>

<div style="margin:8px 0;"></div>

<div id="tabs_deviceFault" class="easyui-tabs"
	style="width:100%;height:331px">
	<!-- tabPosition="left" -->
	<div title="关于" style="padding:10px">
		<p style="font-size:16px">此选项卡包含“设备信息”一个选项卡 --></p>
		<ul style="font-size:14px">
			<li>点击每行数据的“设备编号”字段可查看相对应的详细信息</li>
		</ul>
	</div>

	<!-- Device Info Tab
	closable:true -->

	<div id="tab_device_deviceFault" title="设备信息"
		data-options="iconCls:'icon-tip',closable:true " style="padding:10px">
		<form id="tab_device_form_deviceFault" class="easyui-form" method="post">
			<table cellpadding="4">
				<tr>
					<td>设备名称 :</td>
					<td><input class="easyui-textbox" type="text"
						name="name_form_deviceFault" style="width:99px"
						data-options="editable:false" /></td>

					<td>设备种类 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeName_form_deviceFault" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>出厂日期 :</td>
					<td><input class="easyui-datetimebox" type="datetime"
						name="manufactureDate_form_deviceFault" style="width:138px"
						data-options="editable:false" /></td>

					<td>使用年限 :</td>
					<td><input class="easyui-textbox" type="text"
						name="serviceLife_form_deviceFault" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>购买日期 :</td>
					<td><input class="easyui-datetimebox" type="datetime"
						name="purchaseDate_form_deviceFault" style="width:138px"
						data-options="editable:false" /></td>

					<td>设备状态 :</td>
					<td><input class="easyui-textbox" type="text"
						name="status_form_deviceFault" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>保管人 :</td>
					<td><input class="easyui-textbox" type="text"
						name="keeper_form_deviceFault" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>备注 :</td>
					<td><input class="easyui-textbox" type="text"
						name="note_form_deviceFault" style="width:99px;height:99px;"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>不全....</td>
				</tr>
			</table>
		</form>
	</div>
 
 </div>
 
<div id="toobar_deviceFault" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="append_deviceFault()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-remove',plain:true" onclick="remove_deviceFault()">移除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-undo',plain:true" onclick="reject_deviceFault()">撤销</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true" onclick="accept_deviceFault()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-search',plain:true" onclick="getChanges_deviceFault()">查看改变</a>
</div>

<div style="margin:18x 0;"></div>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>

<script type="text/javascript">
	var deviceFaultEditIndex = undefined;
	function endEditing_deviceFault() {
		if (deviceFaultEditIndex == undefined) {
			return true
		}
		if ($('#deviceFault').datagrid('validateRow', deviceFaultEditIndex)) {
			/* deviceName */
			var deviceNameED = $('#deviceFault').datagrid('getEditor', {
				index : deviceFaultEditIndex,
				field : 'deviceIDD'
			});
			var deviceName = $(deviceNameED.target).combobox('getText');
			$('#deviceFault').datagrid('getRows')[deviceFaultEditIndex]['deviceName'] = deviceName;
			
			/* End Edit */
			$('#deviceFault').datagrid('endEdit', deviceFaultEditIndex);
			deviceFaultEditIndex = undefined;
			return true;
		} else {
			return false;
		}
	}
	
	
	var onClickCellFieldValue_deviceFault = "";
	function onClickCell_deviceFault(index, field) {
		onClickCellFieldValue_deviceFault = field;
	} 


	function onClickRow_deviceFault(index, row) {
		if (deviceFaultEditIndex != index) {
			if (endEditing_deviceFault()) {
				$('#deviceFault').datagrid('selectRow', index).datagrid(
						'beginEdit', index);
				deviceFaultEditIndex = index;
			} else {
				$('#deviceFault').datagrid('selectRow', deviceFaultEditIndex);
			}
			/* 这里有bug：点击任意行，然后点击移除，再点击其他行时表格编辑状态出现错误，换个思路解决一下。 */
			$('#deviceFault').datagrid('clearSelections');
		}

		if (onClickCellFieldValue_deviceFault === "deviceID") {
			var tabs_deviceFault = $("#tabs_deviceFault");
			var detailInfoTab = tabs_deviceFault.tabs("getTab", "设备信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceFault.tabs("select", "设备信息");
loadData_name_form_deviceFault(row.deviceName);	 	
		} 

	}
 
	function append_deviceFault() {
		if (endEditing_deviceFault()) {
			var newIDIndex = $('#deviceFault').datagrid('getRows').length - 1;
			var newID_string = $('#deviceFault').datagrid('getRows')[newIDIndex].deviceFaultID;
			var newID_int = parseInt(newID_string) + 1;
			if (newID_int < 10)
				newID_int = "00" + newID_int;
			else if (newID_int < 100)
				newID_int = "0" + newID_int;

			$('#deviceFault').datagrid('appendRow', {
				deviceFaultID : newID_int
			});
			deviceFaultEditIndex = $('#deviceFault').datagrid('getRows').length - 1;
			$('#deviceFault').datagrid('selectRow', deviceFaultEditIndex).datagrid(
					'beginEdit', deviceFaultEditIndex);

			$('#deviceFault').datagrid('clearSelections');
		}
	}

	function remove_deviceFault() {
		var selections = $('#deviceFault').datagrid('getSelections');

		for (var i = 0; i < selections.length; i++) {
			var selectionIndex = $('#deviceFault').datagrid('getRowIndex',
					selections[i]);
			$('#deviceFault').datagrid('deleteRow', selectionIndex);
		}
		deviceFaultEditIndex = undefined;
	}

	function accept_deviceFault() {
		if (endEditing_deviceFault()) {
			$('#deviceFault').datagrid('acceptChanges');
		}
	}

	function reject_deviceFault() {
		$('#deviceFault').datagrid('rejectChanges');
		deviceFaultEditIndex = undefined;
	}

	function getChanges_deviceFault() {
		var rows = $('#deviceFault').datagrid('getChanges');
		alert(rows.length + ' rows are changed!');
	}
 
</script>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>


<%------------------------------------- 语境菜单 ----------------------------------------------%>
  
<script type="text/javascript">
	$(function() {
		$('#deviceFault').datagrid({
			fitColumns : true,
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
				if (!deviceFaultContextMenu) {
					createColumnMenu_deviceFault();
				}
				deviceFaultContextMenu.menu('show', {
					left : e.pageX,
				});
			}
		});
	});
	var deviceFaultContextMenu;
	function createColumnMenu_deviceFault() {
		deviceFaultContextMenu = $('<div/>').appendTo('body');
		deviceFaultContextMenu.menu({
			onClick : function(item) {
				if (item.iconCls == 'icon-ok') {
					$('#deviceFault').datagrid('hideColumn', item.name);
					deviceFaultContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					$('#deviceFault').datagrid('showColumn', item.name);
					deviceFaultContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
		var fields = $('#deviceFault').datagrid('getColumnFields');
		for (var i = 1; i < fields.length; i++) {
			var field = fields[i];
			var col = $('#deviceFault').datagrid('getColumnOption', field);
			deviceFaultContextMenu.menu('appendItem', {
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
	
		var deviceFaultForFilter = $('#deviceFault').datagrid({
			filterBtnIconCls : 'icon-filter'
		});

		deviceFaultForFilter.datagrid('enableFilter', [ {
			field : 'deviceFaultID',
			type : 'text',
			options : {
				precision : -1
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
			field : 'deviceFaultDate',
			type : 'datetimebox',
			options:{
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}
		]);
	});

</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>
 
<script type="text/javascript">
	function mouseEnterEvent_deviceFault() {
		var deviceFaultTabs = $('#tabs_deviceFault').tabs().tabs('tabs');
		for (var i = 0; i < deviceFaultTabs.length; i++) {
			deviceFaultTabs[i].panel('options').tab.unbind().bind('mouseenter', {
				index : i
			}, function(e) {
				$('#tabs_deviceFault').tabs('select', e.data.index);
			});
		}
	};
</script>

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>

<%-------------------------------------  Tabs  -------------------------------------%>
 
<script type="text/javascript">
	
	/* 静态载入数据，仅为测试，后再动态从数据库载入 */
	function loadData_name_form_deviceFault(deviceName) {
		$('#tab_device_form_deviceFault').form('load', {
			name_form_deviceFault : deviceName

		});
	}
</script> 
 
<%------------------------------------- Add or Remove Tabs  -------------------------------------%>

<%--------------------------------------------------------------------------%>

<script>
	$(function() {

		mouseEnterEvent_deviceFault();

		 var deviceFault_Tab_DeviceInfo = $('#tabs_deviceFault').tabs('getTab', "设备信息").panel(
				'options').tab;
		deviceFault_Tab_DeviceInfo.hide(); 
		
	});
	$('#tabs_deviceFault').tabs(
			{
				onBeforeClose : function(title, index) {
					if (title === "设备信息") {
						var deviceFault_Tab_DeviceInfo = $('#tabs_deviceFault').tabs('getTab',
								"设备信息").panel('options').tab;
						deviceFault_Tab_DeviceInfo.hide();
					} 
					/* 手动选择新选项卡，否则被隐藏的选项卡的内容无法隐藏 */
					$("#tabs_deviceFault").tabs("select", 0);

					return false; // 阻止关闭
				}
			});
</script>

<%--------------------------------------------------------------------------%>