<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<table id="deviceType" title="设备种类" style="height:auto"
	data-options="
	   rownumbers:true,
	   toolbar:'#toobar_deviceType',
	   url:'json/deviceType_All.json',
	   method:'get',
	   pagination:true,
	   pageSize:10,
	   pageList:[10, 20, 30], 
	   onClickRow: onClickRow">

	<thead>
		<tr>

			<th data-options="field:'ck',checkbox:true"></th>

			<th
				data-options="field:'deviceTypeId',width:80,align:'center', 
							type:'text'
			">Id</th>

			<th
				data-options="field:'deviceTypeIdd',width:100,align:'center' ,
							formatter:function(value,row){
								return row.deviceTypeName;
							},
							editor:{
								type:'combobox',
								options:{
									valueField:'deviceTypeIdd',
									textField:'deviceTypeName',
									method:'get',
									url:'json/deviceType_Name.json',
									panelHeight:'auto',
									required:true
								}
							}
			">名称</th>

			<th
				data-options="field:'deviceTypeModel',width:100,align:'center', 
						editor:'text'
			">型号</th>


			<th
				data-options="field:'deviceTypeSpec',width:190,align:'center', 
						editor:'text'
			">规格</th>

			<th
				data-options="field:'deviceTypeSupplier',width:100,align:'center',
						editor:'text'
			">供应商</th>

			<th
				data-options="field:'deviceTypeProducer',width:190,align:'center', 
							editor:'text'
			">生产商</th>

			<th
				data-options="field:'deviceTypeQuantity',width:100,align:'center', 
						editor:{ 
							type:'numberbox',
							options:{
								min:0,
								max:99999
							}
						}
				">台数</th>

			<th
				data-options="field:'deviceTypeWarranty',width:120,align:'center', 
						editor:'datetimebox'
			">保修期</th>

		</tr>
	</thead>
</table>

<div style="margin:8px 0;"></div>

<div id="toobar_deviceType" style="height:auto;">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-edit',plain:true"
		onclick="edit_deviceType()">编辑</a> <a href="javascript:void(0)"
		class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"
		onclick="append_deviceType()">添加</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-remove',plain:true"
		onclick="remove_deviceType()">移除</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-undo',plain:true"
		onclick="reject_deviceType()">撤销</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true"
		onclick="accept_deviceType()">保存</a> <a href="javascript:void(0)"
		class="easyui-linkbutton"
		data-options="iconCls:'icon-search',plain:true"
		onclick="getChanges_deviceType()">查看改变</a>

</div>

<div style="margin:18x 0;"></div>


<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>

<script type="text/javascript">
	var deviceTypeEditIndex = undefined;
	function endEditing_deviceType() {
		if (deviceTypeEditIndex == undefined) {
			return true;
		}
		if ($('#deviceType').datagrid('validateRow', deviceTypeEditIndex)) {

			/* deviceTypeName */
			var deviceTypeNameED = $('#deviceType').datagrid('getEditor', {
				index : deviceTypeEditIndex,
				field : 'deviceTypeIdd'
			});
			var deviceTypeName = $(deviceTypeNameED.target).combobox('getText');
			$('#deviceType').datagrid('getRows')[deviceTypeEditIndex]['deviceTypeName'] = deviceTypeName;

			/* End Edit */
			/* BugBOSS    td  json  format*/
			$('#deviceType').datagrid('endEdit', deviceTypeEditIndex);
			deviceTypeEditIndex = undefined;
			var rows = $('#deviceType').datagrid('getChanges', 'inserted');
			return true;
		} else {
			return false;
		}

	}

	function onClickRow(index, row) {

	}
	
	function edit_deviceType() {
		
		/* 得到所有选择行的索引 */
		var rowSelections = $('#deviceType').datagrid('getSelections');
		if(rowSelections.length==0){
			return;		
		}
		if(rowSelections.length>=2){
			$.messager.alert('提示','请选择一条记录进入编辑！','warning');
        	return ;
		}
		/* 得到选择行的索引 */
		var rowSelection = rowSelections[0];
		var rowSelectionIndex = $('#deviceType').datagrid('getRowIndex',rowSelection);

		/* 进入编辑状态 */
		if (deviceTypeEditIndex != rowSelectionIndex) {
			if (endEditing_deviceType()) {
				$('#deviceType').datagrid('selectRow', rowSelectionIndex).datagrid(
						'beginEdit', rowSelectionIndex);
				deviceTypeEditIndex = rowSelectionIndex;
			} else {
				$('#deviceType').datagrid('selectRow', deviceTypeEditIndex);
			}
		}
		
		$('#deviceType').datagrid('clearSelections');
	}

	function append_deviceType() {
		if (endEditing_deviceType()) {
			var newIdIndex = $('#deviceType').datagrid('getRows').length - 1;
			var newId_string = $('#deviceType').datagrid('getRows')[newIdIndex].deviceTypeId;
			var newId_int = parseInt(newId_string) + 1;
			if (newId_int < 10)
				newId_int = "0" + newId_int;

			$('#deviceType').datagrid('appendRow', {
				deviceTypeId : newId_int
			});
			deviceTypeEditIndex = $('#deviceType').datagrid('getRows').length - 1;
			$('#deviceType').datagrid('selectRow', deviceTypeEditIndex)
					.datagrid('beginEdit', deviceTypeEditIndex);

			$('#deviceType').datagrid('clearSelections');
		}
	}

	function remove_deviceType() {
		var selections = $('#deviceType').datagrid('getSelections');

		for (var i = 0; i < selections.length; i++) {
			var selectionIndex = $('#deviceType').datagrid('getRowIndex',
					selections[i]);
			$('#deviceType').datagrid('deleteRow', selectionIndex);
		}
		if (selections.length > 0) {
			deviceTypeEditIndex = undefined;
		}
	}

	function accept_deviceType() {
		if (endEditing_deviceType()) {
			$('#deviceType').datagrid('acceptChanges');
		}
	}

	function reject_deviceType() {
		$('#deviceType').datagrid('rejectChanges');
		deviceTypeEditIndex = undefined;
	}

	function getChanges_deviceType() {
		var rows = $('#deviceType').datagrid('getChanges');
		alert(rows.length + ' rows are changed!');
	}
</script>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>


<%------------------------------------- 语境菜单 ----------------------------------------------%>

<script type="text/javascript">
	$(function() {
		$('#deviceType').datagrid({
			fitColumns : true,
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
				if (!deviceTypeContextMenu) {
					createColumnMenu_deviceType();
				}
				deviceTypeContextMenu.menu('show', {
					left : e.pageX,
				});
			}
		});
	});
	var deviceTypeContextMenu;
	function createColumnMenu_deviceType() {
		deviceTypeContextMenu = $('<div/>').appendTo('body');
		deviceTypeContextMenu.menu({
			onClick : function(item) {
				if (item.iconCls == 'icon-ok') {
					$('#deviceType').datagrid('hideColumn', item.name);
					deviceTypeContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					$('#deviceType').datagrid('showColumn', item.name);
					deviceTypeContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
		var fields = $('#deviceType').datagrid('getColumnFields');
		for (var i = 1; i < fields.length; i++) {
			var field = fields[i];
			var col = $('#deviceType').datagrid('getColumnOption', field);
			deviceTypeContextMenu.menu('appendItem', {
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

<!-- 这里出了莫名其妙的错~ -->

<script>
	$(function() {

		var deviceTypeForFilter = $('#deviceType').datagrid({
			filterBtnIconCls : 'icon-filter'
		});
		deviceTypeForFilter.datagrid('enableFilter', [ {
			field : 'deviceTypeId',
			type : 'text',
			options : {
				precision : -1
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceTypeWarranty',
			type : 'datetimebox',
			options : {
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceTypeQuantity',
			type : 'numberbox',
			options : {
				min : 0,
				max : 99999,
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		} ]);
	});
</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>
