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
	   onClickRow: onClickRow_deviceCheck
	   ">

	<thead>
		<tr>

			<th data-options="field:'ck',checkbox:true"></th>

			<th
				data-options="field:'deviceCheckId',width:80,align:'center',sortable:true,
							type:'text'
			">例检编号</th>

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
				data-options="field:'deviceCheckFaultIdd',width:100,align:'center',sortable:true,
							formatter:function(value,row){
								return row.deviceCheckFaultId;
							},
							editor:{
								type:'combobox',
								options:{
									valueField:'deviceCheckFaultIdd',
									textField:'deviceCheckFaultId',
									method:'get',
									url:'json/deviceCheck_FaultId.json',
									panelHeight:'auto' 
								}
							}
			
			">设备故障编号</th>


		</tr>
	</thead>
</table>

<div style="margin:8px 0;"></div>

<div id="toobar_deviceCheck" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true"
		onclick="edit_deviceCheck()">编辑</a><a href="javascript:void(0)"
		class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
		onclick="append_deviceCheck()">添加</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-remove',plain:true"
		onclick="remove_deviceCheck()">移除</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-undo',plain:true"
		onclick="reject_deviceCheck()">撤销</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true"
		onclick="accept_deviceCheck()">保存</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-search',plain:true"
		onclick="getChanges_deviceCheck()">查看改变</a>
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
				field : 'deviceIdd'
			});
			var deviceName = $(deviceNameED.target).combobox('getText');
			$('#deviceCheck').datagrid('getRows')[deviceCheckEditIndex]['deviceName'] = deviceName;

			/* deviceCheckFaultId */
			var deviceCheckFaultIdED = $('#deviceCheck').datagrid('getEditor',
					{
						index : deviceCheckEditIndex,
						field : 'deviceCheckFaultIdd'
					});
			var deviceCheckFaultId = $(deviceCheckFaultIdED.target).combobox(
					'getText');
			$('#deviceCheck').datagrid('getRows')[deviceCheckEditIndex]['deviceCheckFaultId'] = deviceCheckFaultId;

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

		if (onClickCellFieldValue_deviceCheck === "deviceId") {
			var tabs_deviceCheck = $("#tabs_deviceCheck");
			var detailInfoTab = tabs_deviceCheck.tabs("getTab", "设备信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceCheck.tabs("select", "设备信息");
			loadData_name_form_deviceCheck(row.deviceId);
		} else if (onClickCellFieldValue_deviceCheck === "deviceCheckEmp") {
			var tabs_deviceCheck = $("#tabs_deviceCheck");
			var detailInfoTab = tabs_deviceCheck.tabs("getTab", "设备例检人信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceCheck.tabs("select", "设备例检人信息");
			loadData_empName_form_deviceCheck(row.deviceCheckEmp);
		} else if (onClickCellFieldValue_deviceCheck === "deviceCheckFaultIdd") {
			var tabs_deviceCheck = $("#tabs_deviceCheck");
			var detailInfoTab = tabs_deviceCheck.tabs("getTab", "设备故障信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceCheck.tabs("select", "设备故障信息");
			loadData_faultId_form_deviceCheck(row.deviceCheckFaultIdd);
		}
	}

	function edit_deviceCheck() {

		/* 得到所有选择行的索引 */
		var rowSelections = $('#deviceCheck').datagrid('getSelections');
		if (rowSelections.length == 0) {
			return;
		}
		if (rowSelections.length >= 2) {
			$.messager.alert('提示', '请选择一条记录进入编辑！', 'warning');
			return;
		}
		/* 得到选择行的索引 */
		var rowSelection = rowSelections[0];
		var rowSelectionIndex = $('#deviceCheck').datagrid('getRowIndex',
				rowSelection);

		/* 进入编辑状态 */
		if (deviceCheckEditIndex != rowSelectionIndex) {
			if (endEditing_deviceCheck()) {
				$('#deviceCheck').datagrid('selectRow', rowSelectionIndex)
						.datagrid('beginEdit', rowSelectionIndex);
				deviceCheckEditIndex = rowSelectionIndex;
			} else {
				$('#deviceCheck').datagrid('selectRow', deviceCheckEditIndex);
			}
		}

		$('#deviceCheck').datagrid('clearSelections');
	}

	function append_deviceCheck() {
		if (endEditing_deviceCheck()) {
			var newIdIndex = $('#deviceCheck').datagrid('getRows').length - 1;
			var newId_string = $('#deviceCheck').datagrid('getRows')[newIdIndex].deviceCheckId;
			var newId_int = parseInt(newId_string) + 1;
			if (newId_int < 10)
				newId_int = "00" + newId_int;
			else if (newId_int < 100)
				newId_int = "0" + newId_int;

			$('#deviceCheck').datagrid('appendRow', {
				deviceCheckId : newId_int
			});
			deviceCheckEditIndex = $('#deviceCheck').datagrid('getRows').length - 1;
			$('#deviceCheck').datagrid('selectRow', deviceCheckEditIndex)
					.datagrid('beginEdit', deviceCheckEditIndex);

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
		if (selections.length > 0) {
			deviceCheckEditIndex = undefined;
		}
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
			field : 'deviceCheckId',
			type : 'text',
			options : {
				precision : -2
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
			field : 'deviceCheckDate',
			type : 'datetimebox',
			options : {
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceCheckFaultIdd',
			type : 'text',
			options : {
				precision : -1
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		} ]);
	});
</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>
