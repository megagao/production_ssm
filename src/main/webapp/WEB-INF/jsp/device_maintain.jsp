<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<!-- singleSelect:true, -->
<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<table id="deviceMaintain" title="设备维修" style="height:389px"></table>

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
			
			/* deviceMaintainEmp */
			var deviceMaintainEmpED = $('#deviceMaintain').datagrid('getEditor', {
				index : deviceMaintainEditIndex,
				field : 'deviceMaintainEmpId'
			});
			var deviceMaintainEmp = $(deviceMaintainEmpED.target).combobox('getText');
			$('#deviceMaintain').datagrid('getRows')[deviceMaintainEditIndex]['deviceMaintainEmp'] = deviceMaintainEmp;
			
			/* End Edit */
			$('#deviceMaintain').datagrid('endEdit', deviceMaintainEditIndex);
			deviceMaintainEditIndex = undefined;
			return true;
		} else {
			return false;
		}
	}

	function onClickRow_deviceMaintain(index, row) {
		
		var selections = $('#deviceMaintain').datagrid('getSelections');
		if(selections.length >=2){
			$('#deviceMaintain').datagrid('unselectAll');
			$('#deviceMaintain').datagrid('selectRow',index);
		}
		
		if(index != deviceMaintainEditIndex && deviceMaintainEditIndex != undefined){
			
			/* deviceMaintainEmp */
			var deviceMaintainEmpED = $('#deviceMaintain').datagrid('getEditor', {
				index : deviceMaintainEditIndex,
				field : 'deviceMaintainEmpId'
			});
			var deviceMaintainEmp = $(deviceMaintainEmpED.target).combobox('getText');
			$('#deviceMaintain').datagrid('getRows')[deviceMaintainEditIndex]['deviceMaintainEmp'] = deviceMaintainEmp;
			
			$('#deviceMaintain').datagrid('endEdit', deviceMaintainEditIndex);
			deviceMaintainEditIndex = undefined;
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
		if(selections.length==0){
			$.messager.alert('提示','请至少选择一条设备维修信息进行移除！','warning');
        	return ;
		}
		
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
		
		if(deviceMaintainEditIndex != undefined){
			
			/* deviceMaintainEmp */
			var deviceMaintainEmpED = $('#deviceMaintain').datagrid('getEditor', {
				index : deviceMaintainEditIndex,
				field : 'deviceMaintainEmpId'
			});
			var deviceMaintainEmp = $(deviceMaintainEmpED.target).combobox('getText');
			$('#deviceMaintain').datagrid('getRows')[deviceMaintainEditIndex]['deviceMaintainEmp'] = deviceMaintainEmp;
		
			$('#deviceMaintain').datagrid('endEdit', deviceMaintainEditIndex);
			deviceMaintainEditIndex = undefined;
		}
	
		//sync with database before accept
		var rowsInserted = $('#deviceMaintain').datagrid('getChanges', 'inserted');
		var rowsDeleted = $('#deviceMaintain').datagrid('getChanges', 'deleted');
		var rowsUpdated = $('#deviceMaintain').datagrid('getChanges', 'updated');

		//sync
		//Inserted
		for (var i = 0; i < rowsInserted.length; i++) {
			$.post("deviceMaintain/insert",rowsInserted[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('添加成功!');
				}
			});
		}
		
		//Deleted
		for (var i = 0; i < rowsDeleted.length; i++) {
			$.post("deviceMaintain/delete",{"deviceMaintainId":rowsDeleted[i].deviceMaintainId}, function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('删除成功!');
				}
			});
		}
		 
		//Updated
		for (var i = 0; i < rowsUpdated.length; i++) {
			$.post("deviceMaintain/update",rowsUpdated[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('更新成功!');
				}
			});
		}

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

<%--
	var ifElse = false;
	function cellStyler(value, row, index) {
		//if (value > 30){
		/* if(ifElse){ */
			return 'color:red;';
		/* } */
	} 
--%>
	
</script>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>


<%------------------------------------- $.datagrid----------------------------------------------%>

<script type="text/javascript">
	$(function() {
			var list_maintainEmp;
			$.ajax({    
			      url:'employee/list_maintainEmp',    
			      dataType : 'json',    
			      type : 'GET',    
			      async:false,  
			      success: function (data){    
			      	list_maintainEmp = data; 
			      }    
			}); 
			/* debugger;  */  
			$('#deviceMaintain').datagrid(  
                    {  
					   toolbar:'##toobar_deviceMaintain',
					   url:'deviceMaintain/list',
					   method:'get',
					   pagination:true,
					   pageSize:10,
					   pageList:[10, 20, 30], 
					   remoteSort:false,
					   multiSort:true,
					   onClickRow: onClickRow_deviceMaintain,
                       columns : [ [  
                                {  
                                    field : 'ck',  
                                    checkbox : true  
                                },  
                                {  
                                    field : 'deviceMaintainId',  
                                    title : '维修编号',  
                                    width : 80,  
                                    align : 'center',
                                    sortable:true,  
                                    type:'text'
                                },  
                                {  
                                    field : 'deviceFaultId',  
                                    title : '故障编号',  
                                    width : 80,  
                                    align : 'center',
                                    sortable:true, 
                                   editor:{
										type:'textbox',
										options:{
											required:true									
										}
									}
                                },  
                                {  
                                    field : 'deviceMaintainEmpId',  
                                    title : '维修人',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true, 
                                    formatter:function(value,row){
										return row.deviceMaintainEmp;
									},
									editor:{
										type:'combobox',
										options:{
											data:list_maintainEmp,
											valueField:'deviceMaintainEmpId',
											textField:'deviceMaintainEmp',
											panelHeight:'auto' 
										}
									}
                                },  
                                {  
                                    field : 'deviceMaintainDate',  
                                    title : '维修日期',  
                                    width : 120,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'datetimebox'
                                },
                                {  
                                    field : 'deviceMaintainDetail',  
                                    title : '维修结果',  
                                    width : 138,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'text'
                                },
                                {  
                                    field : 'deviceMaintainCost',  
                                    title : '维修费用',  
                                    width : 190,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:{
										type:'numberbox',
										options:{
											min:0,
											max:99999,
											precision:2
										}
									}
                                },
                                {  
                                    field : 'note',  
                                    title : '备注',  
                                    width : 200,  
                                    align : 'center',
                                    editor:'text'
                                }
                                 ] ],  
                        toolbar : [  
                                {  
                                    id : "deviceMaintainEdit",
                                    class:"easyui-linkbutton",  
                                    text : '编辑',  
                                    iconCls : 'icon-edit',
                                    plain:true,  
                                    handler : edit_deviceMaintain
                                },  
                                {  
                                    id : "deviceMaintainAdd",
                                    class:"easyui-linkbutton",  
                                    text : '添加',
                                    iconCls:'icon-add',
                                    plain:true,  
                                    handler : append_deviceMaintain
                                },  
                                {  
                                    id : "deviceMaintainRemove",
                                    class:"easyui-linkbutton",  
                                    text : '移除',
                                    iconCls:'icon-remove',
                                    plain:true,  
                                    handler : remove_deviceMaintain
                                },  
                                {  
                                    id : "deviceMaintainReject",
                                    class:"easyui-linkbutton",  
                                    text : '撤销',
                                    iconCls:'icon-undo',
                                    plain:true,  
                                    handler : reject_deviceMaintain
                                },  
                                {  
                                    id : "deviceMaintainSave",
                                    class:"easyui-linkbutton",  
                                    text : '保存',
                                    iconCls:'icon-save',
                                    plain:true,  
                                    handler : accept_deviceMaintain
                                },  
                                {  
                                    id : "deviceMaintainGetChanged",
                                    class:"easyui-linkbutton",  
                                    text : '查看改变',
                                    iconCls:'icon-search', 
                                    plain:true, 
                                    handler : getChanges_deviceMaintain
                                } ]  
                    }); 		
	});
</script>

<%------------------------------------- $.datagrid----------------------------------------------%>


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
			field : 'deviceMaintainId',
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
