<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<!-- singleSelect:true, -->
<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<table id="deviceMaintain" title="设备维修" style="height:389px"
	data-options="
	   rownumbers:true,
	   toolbar:'#toobar_deviceMaintain',
	   url:'json/deviceMaintain_All.json',
	   method:'get',
	   pagination:true,
	   pageSize:10,
	   pageList:[10, 20, 30], 
	   remoteSort:false,
	   multiSort:true,
	   onClickRow: onClickRow_deviceMaintain,
	   onClickCell:onClickCell_deviceMaintain
	   ">

	<thead>
		<tr>

			<th data-options="field:'ck',checkbox:true"></th>

			<th
				data-options="field:'deviceMaintainId',width:80,align:'center',sortable:true,
							type:'text'
			">维修编号</th>

			<th
				data-options="field:'deviceFaultId',width:80,align:'center',sortable:true,
							editor:{
								type:'textbox',
								options:{
									required:true									
								}
							}
			">故障编号</th>

			<th
				data-options="field:'deviceMaintainEmp',width:100,align:'center',sortable:true,
							editor:'text'
			">维修人</th>

			<th
				data-options="field:'deviceMaintainDate',width:120,align:'center',
						editor:'datetimebox'
			">维修日期</th>

			<th
				data-options="field:'deviceMaintainDetail',width:138,align:'center', 
						editor:'text'
			">维修结果</th>

			<th
				data-options="field:'deviceMaintainCost',width:190,align:'center', sortable:true,
						editor:{
							type:'numberbox',
							options:{
								min:0,
								max:99999,
								precision:2
							}
						}
			">维修费用</th>

			<th
				data-options="field:'note',width:200,align:'center', 
						editor:'text'
			">备注</th>

		</tr>
	</thead>
</table>

<div style="margin:8px 0;"></div>

<div id="toobar_deviceMaintain" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true"
		onclick="edit_deviceMaintain()">编辑</a><a href="javascript:void(0)"
		class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
		onclick="append_deviceMaintain()">添加</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-remove',plain:true"
		onclick="remove_deviceMaintain()">移除</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-undo',plain:true"
		onclick="reject_deviceMaintain()">撤销</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true"
		onclick="accept_deviceMaintain()">保存</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-search',plain:true"
		onclick="getChanges_deviceMaintain()">查看改变</a>
</div>

<div style="margin:18x 0;"></div>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>

<script type="text/javascript">
	var ifElse = false;
	var deviceMaintainEditIndex = undefined;
	function endEditing_deviceMaintain() {
		if (deviceMaintainEditIndex == undefined) {
			return true
		}
		if ($('#deviceMaintain').datagrid('validateRow',
				deviceMaintainEditIndex)) {

			/* End Edit */
			$('#deviceMaintain').datagrid('endEdit', deviceMaintainEditIndex);
			deviceMaintainEditIndex = undefined;
			return true;
		} else {
			return false;
		}
	}

	var onClickCellFieldValue_deviceMaintain = "";
	function onClickCell_deviceMaintain(index, field, value) {
		onClickCellFieldValue_deviceMaintain = field;
	}

	function onClickRow_deviceMaintain(index, row) {
		console.log(row);
		if (onClickCellFieldValue_deviceMaintain === "deviceFaultId") {
			var tabs_deviceMaintain = $("#tabs_deviceMaintain");
			var detailInfoTab = tabs_deviceMaintain.tabs("getTab", "设备故障信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceMaintain.tabs("select", "设备故障信息");
			loadData_faultId_form_deviceMaintain(row.deviceFaultId);
		}

	}

	function edit_deviceMaintain() {

		/* 得到所有选择行的索引 */
		var rowSelections = $('#deviceMaintain').datagrid('getSelections');
		if (rowSelections.length == 0) {
			return;
		}
		if (rowSelections.length >= 2) {
			$.messager.alert('提示', '请选择一条记录进入编辑！', 'warning');
			return;
		}
		/* 得到选择行的索引 */
		var rowSelection = rowSelections[0];
		var rowSelectionIndex = $('#deviceMaintain').datagrid('getRowIndex',
				rowSelection);

		/* 进入编辑状态 */
		if (deviceMaintainEditIndex != rowSelectionIndex) {
			if (endEditing_deviceMaintain()) {
				$('#deviceMaintain').datagrid('selectRow', rowSelectionIndex)
						.datagrid('beginEdit', rowSelectionIndex);
				deviceMaintainEditIndex = rowSelectionIndex;
			} else {
				$('#deviceMaintain').datagrid('selectRow',
						deviceMaintainEditIndex);
			}
		}

		$('#deviceMaintain').datagrid('clearSelections');
	}

	function append_deviceMaintain() {
		if (endEditing_deviceMaintain()) {
			var newIdIndex = $('#deviceMaintain').datagrid('getRows').length - 1;
			var newId_string = $('#deviceMaintain').datagrid('getRows')[newIdIndex].deviceMaintainId;
			var newId_int = parseInt(newId_string) + 1;
			if (newId_int < 10)
				newId_int = "00" + newId_int;
			else if (newId_int < 100)
				newId_int = "0" + newId_int;

			$('#deviceMaintain').datagrid('appendRow', {
				deviceMaintainId : newId_int
			});
			deviceMaintainEditIndex = $('#deviceMaintain').datagrid('getRows').length - 1;
			$('#deviceMaintain').datagrid('selectRow', deviceMaintainEditIndex)
					.datagrid('beginEdit', deviceMaintainEditIndex);

			$('#deviceMaintain').datagrid('clearSelections');
		}
	}

	function remove_deviceMaintain() {
		var selections = $('#deviceMaintain').datagrid('getSelections');

		for (var i = 0; i < selections.length; i++) {
			var selectionIndex = $('#deviceMaintain').datagrid('getRowIndex',
					selections[i]);
			$('#deviceMaintain').datagrid('deleteRow', selectionIndex);
		}
		if (selections.length > 0) {
			deviceMaintainEditIndex = undefined;
		}
	}

	function accept_deviceMaintain() {

		if (endEditing_deviceMaintain()) {
			$('#deviceMaintain').datagrid('acceptChanges');
		}

		/* $('#deviceMaintain').datagrid('reload'); */
	}

	function reject_deviceMaintain() {
		$('#deviceMaintain').datagrid('rejectChanges');
		deviceMaintainEditIndex = undefined;
	}

	function getChanges_deviceMaintain() {
		var rows = $('#deviceMaintain').datagrid('getChanges');
		alert(rows.length + ' rows are changed!');
	}
<%--
	function cellStyler(value, row, index) {
		//if (value > 30){
		/* if(ifElse){ */
			return 'color:red;';
		/* } */
	} 
	--%>
	
</script>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>


<%------------------------------------- 语境菜单 ----------------------------------------------%>

<script type="text/javascript">
	$(function() {
		$('#deviceMaintain').datagrid({
			fitColumns : true,
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
				if (!deviceMaintainContextMenu) {
					createColumnMenu_deviceMaintain();
				}
				deviceMaintainContextMenu.menu('show', {
					left : e.pageX,
				});
			}
		});
	});
	var deviceMaintainContextMenu;
	function createColumnMenu_deviceMaintain() {
		deviceMaintainContextMenu = $('<div/>').appendTo('body');
		deviceMaintainContextMenu.menu({
			onClick : function(item) {
				if (item.iconCls == 'icon-ok') {
					$('#deviceMaintain').datagrid('hideColumn', item.name);
					deviceMaintainContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					$('#deviceMaintain').datagrid('showColumn', item.name);
					deviceMaintainContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
		var fields = $('#deviceMaintain').datagrid('getColumnFields');
		for (var i = 1; i < fields.length; i++) {
			var field = fields[i];
			var col = $('#deviceMaintain').datagrid('getColumnOption', field);
			deviceMaintainContextMenu.menu('appendItem', {
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

		var deviceMaintainForFilter = $('#deviceMaintain').datagrid({
			filterBtnIconCls : 'icon-filter'
		});

		deviceMaintainForFilter.datagrid('enableFilter', [ {
			field : 'deviceMaintainId',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceFaultId',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceMaintainDate',
			type : 'datetimebox',
			options : {
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		} ]);
	});
</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>
