<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
 <!-- singleSelect:true, -->
<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->

<!-- =。=   设置了过滤器后就可以自动分页了 -->

<table id="deviceList" title="设备列表" style="height:389px" 
	data-options="
	   rownumbers:true,
	   toolbar:'#toobar_deviceList',
	   url:'json/datagrid_data1.json',
	   method:'get',
	   pagination:true,
	   pageSize:10,
	   pageList:[10, 20, 30], 
	   remoteSort:false,
	   multiSort:true,
	   onClickRow: onClickRow_deviceList,
	   onClickCell: onClickCell_deviceList">

	<thead>
		<tr>

			<th data-options="field:'ck',checkbox:true"></th>

			<th
				data-options="field:'deviceID',width:80,align:'center',sortable:true,
							type:'text'
			">ID</th>

			<th
				data-options="field:'deviceName',width:100,align:'center',sortable:true,
							formatter:function(value,row){
								return row.deviceName;
							},
							editor:{
								type:'combobox',
								options:{
									valueField:'deviceIDD',
									textField:'deviceName',
									method:'get',
									url:'json/datagrid_data2.json',
									panelHeight:'auto',
									required:true
								}
							}
			
			">名称</th>

			<th
				data-options="field:'deviceTypeName',width:100,align:'center' ,sortable:true,
							formatter:function(value,row){
								return row.deviceTypeName;
							},
							editor:{
								type:'combobox',
								options:{
									valueField:'deviceTypeID',
									textField:'deviceTypeName',
									method:'get',
									url:'json/datagrid_data3.json',
									editable:false,
									panelHeight:'auto' 
								}
							}
				
			
			">种类</th>

			<th
				data-options="field:'deviceStatus',width:100,align:'center',sortable:true,
						formatter:function(value,row){
							return row.deviceStatus;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'deviceStatusID',
								textField:'deviceStatus',
								url:'json/datagrid_data4.json',
								method:'get',
								editable:false,
								panelHeight:'auto'
							}
						}
				
			">状态</th>


			<th
				data-options="field:'devicePurchaseDate',width:190,align:'center', sortable:true,
						editor:'datetimebox'
			">购买日期</th>

			<th
				data-options="field:'devicePurchasePrice',width:100,align:'center',
						editor:{
							type:'numberbox',
							options:{
								min:0,
								max:999999,
								precision:2
							}
						}
					
			">购买价格</th>

			<th
				data-options="field:'deviceManufactureDate',width:190,align:'center',sortable:true, 
							editor:'datetimebox'
			">出厂日期</th>

			<th
				data-options="field:'deviceServiceLife',width:100,align:'center',sortable:true,
						editor:{ 
							type:'numberbox',
							options:{
								min:0,
								max:12
							}
						}
				">使用年限</th>

			<th
				data-options="field:'deviceKeeper',width:120,align:'center', 
						editor:'text'
			">保管人</th>

			<th
				data-options="field:'note',width:270,align:'center',
						editor:'text'
			">备注</th>
		</tr>
	</thead>
</table>
 
<div style="margin:8px 0;"></div>

<div id="tabs_deviceList" class="easyui-tabs"
	style="width:100%;height:331px">
	<!-- tabPosition="left" -->
	<div title="关于" style="padding:10px">
		<p style="font-size:16px">此选项卡包含”设备种类信息“和”设备保管人信息“两个选项卡 --></p>
			<ul style="font-size:14px">
				<li >点击每行数据的”种类“字段或”保管人“字段可查看相对应的设备种类或设备保管人的详细信息</li>
			</ul>
	</div>

	<!-- 
	Device Type Tab
	closable:true
	 -->
	<div id="tab_deviceType" title="设备种类信息" data-options="iconCls:'icon-tip',closable:true "
		style="padding:10px">
		<form id="tab_deviceType_form" class="easyui-form" method="post">
			<table cellpadding="4">
				<tr>
					<td>种类名称 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeName_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>

					<td>种类编号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeID_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>种类规格 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeSpec_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>

					<td>种类型号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeVersion_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>种类供应商 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeSupplier_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>

					<td>种类生产商 :</td>
					<td><input class="easyui-textbox" type="text"
						name="typeProducer_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>种类保修期 :</td>
					<td><input class="easyui-datetimebox" type="datetime"
						name="typeMaintenancePeriod_form_deviceList" style="width:138px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>种类台数 :</td>
					<td><input class="easyui-numberbox" type="number"
						name="typeQuantity_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>
				</tr>


			</table>
		</form>
	</div>

	<!-- 
	Device Keeper
	closable:true
	 -->
	<div id="tab_deviceKeeper" title="设备保管人信息"
		data-options="iconCls:'icon-tip',closable:true  " style="padding:10px">
		<form id="tab_deviceKeeper_form" class="easyui-form" method="post">
			<table cellpadding="4">
				<tr>
					<td>编号 :</td>
					<td><input class="easyui-textbox" type="text"
						name="empID_form_deviceList" style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>姓名 :</td>
					<td><input class="easyui-textbox" type="text"
						name="empName_form_deviceList" style="width:99px"
						data-options="editable:false" /></td>

					<td>性别 :</td>
					<td><input class="easyui-textbox" type="text"
						name="empSex_form_deviceList" style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>出生日期 :</td>
					<td><input class="easyui-datebox" type="date"
						name="empBirthday_form_deviceList" style="width:147px"
						data-options="editable:false" /></td>

					<td>身份证号 :</td>
					<td><input class="easyui-numberbox" type="number"
						name="empPersonalIdentity_form_deviceList" style="width:156px"
						data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>入职日期 :</td>
					<td><input class="easyui-datebox" type="date"
						name="empEntryDate_form_deviceList" style="width:147px"
						data-options="editable:false" /></td>

					<td>所属部门 :</td>
					<td><input class="easyui-textbox" type="text" name="empDept_form_deviceList"
						style="width:99px" data-options="editable:false" /></td>
				</tr>
				<tr>
					<td>员工状态 :</td>
					<td><input class="easyui-textbox" type="text" name="empStatus_form_deviceList"
						style="width:99px" data-options="editable:false" /></td>
				</tr>

				<tr>
					<td>不全....</td>
				</tr>
			</table>
		</form>
	</div>
</div>


<div id="toobar_deviceList" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-add',plain:true" onclick="append_deviceList()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-remove',plain:true" onclick="remove_deviceList()">移除</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-undo',plain:true" onclick="reject_deviceList()">撤销</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-save',plain:true" onclick="accept_deviceList()">保存</a>
	<a href="javascript:void(0)" class="easyui-linkbutton"
		data-options="iconCls:'icon-search',plain:true,disable:true" onclick="getChanges_deviceList()">查看改变</a>
</div>

<div style="margin:18x 0;"></div>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>

<script type="text/javascript">
	var deviceListEditIndex = undefined;
	function endEditing_deviceList() {
		if (deviceListEditIndex == undefined) {
			return true
		}
		if ($('#deviceList').datagrid('validateRow', deviceListEditIndex)) {
			/* deviceName */
			var deviceNameED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceName'
			});
			var deviceName = $(deviceNameED_List.target).combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceName'] = deviceName;
			/* deviceTypeName */
			var deviceTypeNameED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceTypeName'
			});
			var deviceTypeName = $(deviceTypeNameED_List.target).combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceTypeName'] = deviceTypeName;
			/* deviceStatus */
			var deviceStatusED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceStatus'
			});
			var deviceStatus = $(deviceStatusED_List.target).combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceStatus'] = deviceStatus;
			/* End Edit */
			$('#deviceList').datagrid('endEdit', deviceListEditIndex);
			deviceListEditIndex = undefined;
			return true;
		} else {
			return false;
		}
	}

	var onClickCellFieldValue_deviceList = "";

	function onClickCell_deviceList(index, field) {
		onClickCellFieldValue_deviceList = field;
	}

	function onClickRow_deviceList(index, row) {

		if (deviceListEditIndex != index) {
			if (endEditing_deviceList()) {
				$('#deviceList').datagrid('selectRow', index).datagrid(
						'beginEdit', index);
				deviceListEditIndex = index;
			} else {
				$('#deviceList').datagrid('selectRow', deviceListEditIndex);
			}
			$('#deviceList').datagrid('clearSelections');
		}

		if (onClickCellFieldValue_deviceList === "deviceTypeName") {
			var tabs_deviceList = $("#tabs_deviceList");
			var detailInfoTab = tabs_deviceList.tabs("getTab", "设备种类信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceList.tabs("select", "设备种类信息");
			loadDataToDeviceTypeNameInfoForm(row.deviceTypeName);
		} else if (onClickCellFieldValue_deviceList === "deviceKeeper") {
			var tabs_deviceList = $("#tabs_deviceList");
			var detailInfoTab = tabs_deviceList.tabs("getTab", "设备保管人信息");
			detailInfoTab.panel('options').tab.show();
			tabs_deviceList.tabs("select", "设备保管人信息");
			loadDataToDeviceKeeperNameInfoForm(row.deviceKeeper);
		} 
	}

	function append_deviceList() {
	
		if (endEditing_deviceList()) {
			var newIDIndex = $('#deviceList').datagrid('getRows').length - 1;
console.log("newIDIndex : "+newIDIndex);
			var newID_string = $('#deviceList').datagrid('getRows')[newIDIndex].deviceID;
			var newID_int = parseInt(newID_string) + 1;
			if (newID_int < 10)
				newID_int = "00" + newID_int;
			else if (newID_int < 100)
				newID_int = "0" + newID_int;

			$('#deviceList').datagrid('appendRow', {
				deviceID : newID_int
			});
			
			deviceListEditIndex = $('#deviceList').datagrid('getRows').length - 1;
			$('#deviceList').datagrid('selectRow', deviceListEditIndex).datagrid(
					'beginEdit', deviceListEditIndex);

			$('#deviceList').datagrid('clearSelections');
		}
		
/* $('#tt').datagrid({pageNumber: max}); */		
	}

	function remove_deviceList() {
		var selections = $('#deviceList').datagrid('getSelections');

		for (var i = 0; i < selections.length; i++) {
			var selectionIndex = $('#deviceList').datagrid('getRowIndex',
					selections[i]);
			$('#deviceList').datagrid('deleteRow', selectionIndex);
		}
		deviceListEditIndex = undefined;
		/* $('#deviceList').datagrid('reload');  */
	}

	function accept_deviceList() {
		if (endEditing_deviceList()) {
			$('#deviceList').datagrid('acceptChanges');
		}
	}

	function reject_deviceList() {

		$('#deviceList').datagrid('rejectChanges');
		deviceListEditIndex = undefined;
	}

	function getChanges_deviceList() {
		var rows = $('#deviceList').datagrid('getChanges');
		alert(rows.length + ' rows are changed!');
	}

</script>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>


<%------------------------------------- 语境菜单 ----------------------------------------------%>
 
<script type="text/javascript">
	$(function() {
		$('#deviceList').datagrid({
			fitColumns : true,
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
				if (!deviceListContextMenu) {
					createColumnMenu_deviceList();
				}
				deviceListContextMenu.menu('show', {
					left : e.pageX,
				});
			}
		});
	});
	var deviceListContextMenu;
	function createColumnMenu_deviceList() {
		deviceListContextMenu = $('<div/>').appendTo('body');
		deviceListContextMenu.menu({
			onClick : function(item) {
				if (item.iconCls == 'icon-ok') {
					$('#deviceList').datagrid('hideColumn', item.name);
					deviceListContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-empty'
					});
				} else {
					$('#deviceList').datagrid('showColumn', item.name);
					deviceListContextMenu.menu('setIcon', {
						target : item.target,
						iconCls : 'icon-ok'
					});
				}
			}
		});
		var fields = $('#deviceList').datagrid('getColumnFields');
		for (var i = 1; i < fields.length; i++) {
			var field = fields[i];
			var col = $('#deviceList').datagrid('getColumnOption', field);
			deviceListContextMenu.menu('appendItem', {
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
		var dg = $('#deviceList').datagrid({
			filterBtnIconCls : 'icon-filter'
		});
 
	dg.datagrid('enableFilter', [ {
			field : 'deviceID',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceTypeName',
			type : 'combobox',
			options : {
				valueField : 'deviceTypeID',
				textField : 'deviceTypeName',
				method : 'get',
				url : 'json/datagrid_data3_1.json',
				panelHeight : 'auto',
				editable : false,
				onChange : function(value) {
					if (value != "ALL") {
						dg.datagrid('addFilterRule', {
							field : 'deviceTypeName',
							op : 'equal',
							value : value
						});
					}
					if (value == "ALL" || value == '') {
						dg.datagrid('removeFilterRule', 'deviceTypeName');
					}
					dg.datagrid('doFilter');
				}
			}
		}, {
			field : 'deviceStatus',
			type : 'combobox',
			options : {
				valueField : 'deviceStatusID',
				textField : 'deviceStatus',
				method : 'get',
				url : 'json/datagrid_data4_1.json',
				panelHeight : 'auto',
				editable : false,
				onChange : function(value) {
					if (value != "ALL") {
						dg.datagrid('addFilterRule', {
							field : 'deviceStatus',
							op : 'equal',
							value : value
						});
					}
					if (value == "ALL" || value == '') {
						dg.datagrid('removeFilterRule', 'deviceStatus');
					}
					dg.datagrid('doFilter');
				}
			}
		}, {
			field : 'devicePurchaseDate',
			type : 'datetimebox',
			options : {
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'devicePurchasePrice',
			type : 'numberbox',
			options : {
				precision : 2
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceManufactureDate',
			type : 'datetimebox',
			options : {
				editable : false
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceServiceLife',
			type : 'numberbox',
			options : {
				precision : 0
			},
			op : [ 'contains', 'equal', 'notequal', 'less', 'greater' ]
		} ]);

	});
</script>

<%------------------------------------- JQuery Easy UI Filter -------------------------------------%>

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>

<script type="text/javascript">
	function mouseEnterEvent_deviceList() {
		var tabs = $('#tabs_deviceList').tabs().tabs('tabs');
		for (var i = 0; i < tabs.length; i++) {
			tabs[i].panel('options').tab.unbind().bind('mouseenter', {
				index : i
			}, function(e) {
				$('#tabs_deviceList').tabs('select', e.data.index);
			});
		}
	};
</script>

<%------------------------------------- Tabs Mouseenter Event -------------------------------------%>

<%-------------------------------------  Tabs  -------------------------------------%>

<script type="text/javascript">
	
	/* 静态载入数据，仅为测试，后再动态从数据库载入 */
	/* Load data_deviceTypeName to tab_tab_deviceType */
	function loadDataToDeviceTypeNameInfoForm(deviceTypeName) {
		/* var rows = $('#deviceList').datagrid('getRows');
		var deviceTypeName = rows[index].deviceTypeName; */
		$('#tab_deviceType_form').form('load', {
			typeName_form_deviceList : deviceTypeName

		});
	}
	/* 静态载入数据，仅为测试 ，后再动态从数据库载入*/
	/* Load data_deviceKeeperName to tab_tab_deviceKeeper */
	function loadDataToDeviceKeeperNameInfoForm(deviceKeeperName) {
		/* var rows = $('#deviceList').datagrid('getRows');
		var deviceTypeName = rows[index].deviceTypeName; */
		$('#tab_deviceKeeper_form').form('load', {
			empName_form_deviceList : deviceKeeperName

		});
	}
</script> 

<%------------------------------------- Add or Remove Tabs  -------------------------------------%>

<%--------------------------------------------------------------------------%>

<script>
	$(function() {
		mouseEnterEvent_deviceList();

		var deviceList_Tab_Type = $('#tabs_deviceList').tabs('getTab', "设备种类信息").panel(
				'options').tab;
		deviceList_Tab_Type.hide();
		var deviceList_Tab_Keeper = $('#tabs_deviceList').tabs('getTab', "设备保管人信息").panel(
				'options').tab;
		deviceList_Tab_Keeper.hide();
	});
	$('#tabs_deviceList').tabs(
			{
				onBeforeClose : function(title, index) {
					if (title === "设备种类信息") {
						var deviceList_Tab_Type = $('#tabs_deviceList').tabs('getTab',
								"设备种类信息").panel('options').tab;
						deviceList_Tab_Type.hide();
					} else if (title === "设备保管人信息") {
						var deviceList_Tab_Keeper = $('#tabs_deviceList').tabs('getTab',
								"设备保管人信息").panel('options').tab;
						deviceList_Tab_Keeper.hide();
					}
					/* 手动选择新选项卡，否则被隐藏的选项卡的内容无法隐藏 */
					$("#tabs_deviceList").tabs("select", 0);

					return false; // 阻止关闭
				}
	});

<%--------------------------------------------------------------------------%>