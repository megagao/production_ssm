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
				data-options="field:'deviceMaintainID',width:80,align:'center',sortable:true,
							type:'text'
			">维修编号</th>

			<th
				data-options="field:'deviceFaultID',width:80,align:'center',sortable:true,
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

<div id="tabs_deviceMaintain" class="easyui-tabs"
	style="width:100%;height:331px">
	<!-- tabPosition="left" -->
	<div title="关于" style="padding:10px">
		<p style="font-size:16px">此选项卡包含“设备故障信息”一个选项卡 --></p>
		<ul style="font-size:14px">
			<li>点击每行数据的“故障编号”字段可查看相对应的详细信息</li>
		</ul>
	</div>

	<!-- Device Fault Tab
	closable:true -->
	<div id="tab_deviceFault_deviceMaintain" title="设备故障信息"
		data-options="iconCls:'icon-tip',closable:true  " style="padding:10px">
		<form id="tab_deviceFault_form_deviceMaintain" class="easyui-form"
			method="post">
			<table cellpadding="4">
				<tr>
					<td>故障编号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="faultID_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>设备编号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="deviceID_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>

					<td>设备名称 :</td>
					<td><input class="easyui-textbox" type="text"
						name="deviceName_form_deviceCheck" style="width:99px"
						data-options="editable:false" /></td>
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
						name="faultCause_form_deviceCheck"
						style="width:147px;height:147px;" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>维修方式 :</td>
					<td><input class="easyui-textbox" type="text"
						name="maintenance_form_deviceCheck" style="width:147px"
						data-options="editable:false" /></td>
				</tr>

			</table>
		</form>
	</div>

</div>

<div id="toobar_deviceMaintain" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true"
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
	function onClickCell_deviceMaintain(index, field) {
		onClickCellFieldValue_deviceMaintain = field;
	}

	function onClickRow_deviceMaintain(index, row) {
		if (deviceMaintainEditIndex != index) {
			if (endEditing_deviceMaintain()) {
				$('#deviceMaintain').datagrid('selectRow', index).datagrid(
						'beginEdit', index);
				deviceMaintainEditIndex = index;
			} else {
				$('#deviceMaintain').datagrid('selectRow',
						deviceMaintainEditIndex);
			}
			/* 这里有bug：点击任意行，然后点击移除，再点击其他行时表格编辑状态出现错误，换个思路解决一下。 */
			$('#deviceMaintain').datagrid('clearSelections');
		}

		 if (onClickCellFieldValue_deviceMaintain === "deviceFaultID") {
			var tabs_deviceMaintain = $("#tabs_deviceMaintain");
			var detailInfoTab = tabs_deviceMaintain.tabs("getTab", "设备故障信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceMaintain.tabs("select", "设备故障信息");
loadData_faultID_form_deviceMaintain(row.deviceFaultID); 	 	
		} 

	}

	function append_deviceMaintain() {
		if (endEditing_deviceMaintain()) {
			var newIDIndex = $('#deviceMaintain').datagrid('getRows').length - 1;
			var newID_string = $('#deviceMaintain').datagrid('getRows')[newIDIndex].deviceMaintainID;
			var newID_int = parseInt(newID_string) + 1;
			if (newID_int < 10)
				newID_int = "00" + newID_int;
			else if (newID_int < 100)
				newID_int = "0" + newID_int;

			$('#deviceMaintain').datagrid('appendRow', {
				deviceMaintainID : newID_int
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
		deviceMaintainEditIndex = undefined;
	}

	function accept_deviceMaintain() {
		if (endEditing_deviceMaintain()) {
			$('#deviceMaintain').datagrid('acceptChanges');
		}
	}

	function reject_deviceMaintain() {
		$('#deviceMaintain').datagrid('rejectChanges');
		deviceMaintainEditIndex = undefined;
	}

	function getChanges_deviceMaintain() {
		var rows = $('#deviceMaintain').datagrid('getChanges');
		alert(rows.length + ' rows are changed!');
	}
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
			field : 'deviceMaintainID',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceFaultID',
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

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>

<script type="text/javascript">
	function mouseEnterEvent_deviceMaintain() {
		var deviceMaintainTabs = $('#tabs_deviceMaintain').tabs().tabs('tabs');
		for (var i = 0; i < deviceMaintainTabs.length; i++) {
			deviceMaintainTabs[i].panel('options').tab.unbind().bind('mouseenter', {
				index : i
			}, function(e) {
				$('#tabs_deviceMaintain').tabs('select', e.data.index);
			});
		}
	};
</script>

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>

<%-------------------------------------  Tabs  -------------------------------------%>
 
<script type="text/javascript">
	
	/* 静态载入数据，仅为测试，后再动态从数据库载入 */
	function loadData_faultID_form_deviceMaintain(deviceFaultID) {
		$('#tab_deviceFault_form_deviceMaintain').form('load', {
			faultID_form_deviceCheck : deviceFaultID

		});
	}
</script> 

<%------------------------------------- Add or Remove Tabs  -------------------------------------%>

<%--------------------------------------------------------------------------%>
 
<script>
	$(function() {

		mouseEnterEvent_deviceMaintain();

		 var tab_deviceFault_deviceMaintain = $('#tabs_deviceMaintain').tabs('getTab', "设备故障信息").panel(
				'options').tab;
		tab_deviceFault_deviceMaintain.hide(); 
		
	});
	$('#tabs_deviceMaintain').tabs(
			{
				onBeforeClose : function(title, index) {
					if (title === "设备故障信息") {
						var tab_deviceFault_deviceMaintain = $('#tabs_deviceMaintain').tabs('getTab',
								"设备故障信息").panel('options').tab;
						tab_deviceFault_deviceMaintain.hide();
					} 
					/* 手动选择新选项卡，否则被隐藏的选项卡的内容无法隐藏 */
					$("#tabs_deviceMaintain").tabs("select", 0);

					return false; // 阻止关闭
				}
			});
</script>

<%--------------------------------------------------------------------------%>