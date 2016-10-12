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
				data-options="field:'deviceFaultId',width:80,align:'center',sortable:true,
							type:'text'
			">故障编号</th>

			<th
				data-options="field:'deviceId',width:80,align:'center',sortable:true,
							editor:{
								type:'textbox',
								options:{
									required:true									
								}
							}
			">设备编号</th>

			<th
				data-options="field:'deviceIdd',width:100,align:'center',sortable:true,
							formatter:function(value,row){
								return row.deviceName;
							},
							editor:{
								type:'combobox',
								options:{
									valueField:'deviceIdd',
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

<div id="toobar_deviceFault" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true"
		onclick="edit_deviceFault()">编辑</a><a href="javascript:void(0)"
		class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
		onclick="append_deviceFault()">添加</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-remove',plain:true"
		onclick="remove_deviceFault()">移除</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-undo',plain:true"
		onclick="reject_deviceFault()">撤销</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true"
		onclick="accept_deviceFault()">保存</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-search',plain:true"
		onclick="getChanges_deviceFault()">查看改变</a>
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
				field : 'deviceIdd'
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

		if (onClickCellFieldValue_deviceFault === "deviceId") {
			var tabs_deviceFault = $("#tabs_deviceFault");
			var detailInfoTab = tabs_deviceFault.tabs("getTab", "设备信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceFault.tabs("select", "设备信息");
			loadData_name_form_deviceFault(row.deviceName);
		}

	}

	function edit_deviceFault() {

		/* 得到所有选择行的索引 */
		var rowSelections = $('#deviceFault').datagrid('getSelections');
		if (rowSelections.length == 0) {
			return;
		}
		if (rowSelections.length >= 2) {
			$.messager.alert('提示', '请选择一条记录进入编辑！', 'warning');
			return;
		}
		/* 得到选择行的索引 */
		var rowSelection = rowSelections[0];
		var rowSelectionIndex = $('#deviceFault').datagrid('getRowIndex',
				rowSelection);

		/* 进入编辑状态 */
		if (deviceFaultEditIndex != rowSelectionIndex) {
			if (endEditing_deviceFault()) {
				$('#deviceFault').datagrid('selectRow', rowSelectionIndex)
						.datagrid('beginEdit', rowSelectionIndex);
				deviceFaultEditIndex = rowSelectionIndex;
			} else {
				$('#deviceFault').datagrid('selectRow', deviceFaultEditIndex);
			}
		}

		$('#deviceFault').datagrid('clearSelections');
	}

	function append_deviceFault() {
		if (endEditing_deviceFault()) {
			var newIdIndex = $('#deviceFault').datagrid('getRows').length - 1;
			var newId_string = $('#deviceFault').datagrid('getRows')[newIdIndex].deviceFaultId;
			var newId_int = parseInt(newId_string) + 1;
			if (newId_int < 10)
				newId_int = "00" + newId_int;
			else if (newId_int < 100)
				newId_int = "0" + newId_int;

			$('#deviceFault').datagrid('appendRow', {
				deviceFaultId : newId_int
			});
			deviceFaultEditIndex = $('#deviceFault').datagrid('getRows').length - 1;
			$('#deviceFault').datagrid('selectRow', deviceFaultEditIndex)
					.datagrid('beginEdit', deviceFaultEditIndex);

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
		if (selections.length > 0) {
			deviceFaultEditIndex = undefined;
		}
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
			field : 'deviceFaultId',
			type : 'text',
			options : {
				precision : -1
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceId',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceFaultDate',
			type : 'datetimebox',
			options : {
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		} ]);
	});
</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>
