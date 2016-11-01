<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<table id="deviceType" title="设备种类" style="height:auto"></table>

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

	function onClickRow_deviceType(index, row) {
		var selections = $('#deviceType').datagrid('getSelections');
		if(selections.length >=2){
			$('#deviceType').datagrid('unselectAll');
			$('#deviceType').datagrid('selectRow',index);
		}
		
		if(index != deviceTypeEditIndex && deviceTypeEditIndex != undefined){
console.log("=.=")
			/* deviceTypeName */
			var deviceTypeNameED_List = $('#deviceType').datagrid('getEditor',{
				index : deviceTypeEditIndex,
				field : 'deviceTypeIdd'
			});
			var deviceTypeName = $(deviceTypeNameED_List.target).combobox(
					'getText');
			$('#deviceType').datagrid('getRows')[deviceTypeEditIndex]['deviceTypeName'] = deviceTypeName;

			$('#deviceType').datagrid('endEdit', deviceTypeEditIndex);
			deviceTypeEditIndex = undefined;
		}
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
		if(selections.length==0){
			$.messager.alert('提示','请至少选择一条设备类型信息进行移除！','warning');
        	return ;
		}

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
	
		if(deviceTypeEditIndex != undefined){
			/* deviceTypeName */
			var deviceTypeNameED_List = $('#deviceType').datagrid('getEditor',{
				index : deviceTypeEditIndex,
				field : 'deviceTypeIdd'
			});
			var deviceTypeName = $(deviceTypeNameED_List.target).combobox(
					'getText');
			$('#deviceType').datagrid('getRows')[deviceTypeEditIndex]['deviceTypeName'] = deviceTypeName;

			$('#deviceType').datagrid('endEdit', deviceTypeEditIndex);
			deviceTypeEditIndex = undefined;
		}
	
		//sync with database before accept
		var rowsInserted = $('#deviceType').datagrid('getChanges', 'inserted');
		var rowsDeleted = $('#deviceType').datagrid('getChanges', 'deleted');
		var rowsUpdated = $('#deviceType').datagrid('getChanges', 'updated');

		//sync
		//Inserted
		for (var i = 0; i < rowsInserted.length; i++) {
			$.post("deviceType/insert",rowsInserted[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('添加成功!');
				}
			});
		}
		
		//Deleted
		for (var i = 0; i < rowsDeleted.length; i++) {
			$.post("deviceType/delete",{"deviceTypeId":rowsDeleted[i].deviceTypeId}, function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('删除成功!');
				}
			});
		}
		 
		//Updated
		for (var i = 0; i < rowsUpdated.length; i++) {
			$.post("deviceType/update",rowsUpdated[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('更新成功!');
				}
			});
		}
	 	
		
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


<%------------------------------------- $.datagrid----------------------------------------------%>

<script type="text/javascript">
	$(function() {
		  	var list_type;
			$.ajax({    
			      url:'deviceType/list_type',    
			      dataType : 'json',    
			      type : 'GET',    
			      async:false,  
			      success: function (data){    
			      	list_type = data; 
			      }    
			}); 
			/* debugger;    */
			$('#deviceType').datagrid(  
                    {  
					   toolbar:'##toobar_deviceType',
					   url:'deviceType/list',
					   method:'get',
					   pagination:true,
					   pageSize:10,
					   pageList:[10, 20, 30], 
					   remoteSort:false,
					   multiSort:true,
					   onClickRow: onClickRow_deviceType,
                       columns : [ [  
                                {  
                                    field : 'ck',  
                                    checkbox : true  
                                },  
                                {  
                                    field : 'deviceTypeId',  
                                    title : 'ID',  
                                    width : 80,  
                                    align : 'center',
                                    sortable:true,  
                                    type:'text'
                                },  
                                {  
                                    field : 'deviceTypeIdd',  
                                    title : '名称',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true, 
                                    formatter:function(value,row){
										return row.deviceTypeName;
									},
									editor:{
										type:'combobox',
										options:{
											data:list_type,
											valueField:'deviceTypeIdd',
											textField:'deviceTypeName',
											panelHeight:'auto',
											required:true
										}
									}
                                },  
                                {  
                                    field : 'deviceTypeModel',  
                                    title : '型号',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true, 
                                    editor:'text'
                                },  
                                {  
                                    field : 'deviceTypeSpec',  
                                    title : '规格',  
                                    width : 190,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'text'
                                },
                                {  
                                    field : 'deviceTypeSupplier',  
                                    title : '供应商',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'text'
                                },
                                {  
                                    field : 'deviceTypeProducer',  
                                    title : '生产商',  
                                    width : 190,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'text'
                                },
                                {  
                                    field : 'deviceTypeQuantity',  
                                    title : '台数',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:{ 
										type:'numberbox',
										options:{
											min:0,
											max:99999
										}
									}
                                },
                                {  
                                    field : 'deviceTypeWarranty',  
                                    title : '保修期',  
                                    width : 120,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'datetimebox',
                                    formatter:TAOTAO.formatDateTime
                                }
                                 ] ],  
                        toolbar : [  
                                {  
                                    id : "deviceTypeEdit",
                                    class:"easyui-linkbutton",  
                                    text : '编辑',  
                                    iconCls : 'icon-edit',
                                    plain:true,  
                                    handler : edit_deviceType
                                },  
                                {  
                                    id : "deviceTypeAdd",
                                    class:"easyui-linkbutton",  
                                    text : '添加',
                                    iconCls:'icon-add',
                                    plain:true,  
                                    handler : append_deviceType
                                },  
                                {  
                                    id : "deviceTypeRemove",
                                    class:"easyui-linkbutton",  
                                    text : '移除',
                                    iconCls:'icon-remove',
                                    plain:true,  
                                    handler : remove_deviceType
                                },  
                                {  
                                    id : "deviceTypeReject",
                                    class:"easyui-linkbutton",  
                                    text : '撤销',
                                    iconCls:'icon-undo',
                                    plain:true,  
                                    handler : reject_deviceType
                                },  
                                {  
                                    id : "deviceTypeSave",
                                    class:"easyui-linkbutton",  
                                    text : '保存',
                                    iconCls:'icon-save',
                                    plain:true,  
                                    handler : accept_deviceType
                                },  
                                {  
                                    id : "deviceTypeGetChanged",
                                    class:"easyui-linkbutton",  
                                    text : '查看改变',
                                    iconCls:'icon-search', 
                                    plain:true, 
                                    handler : getChanges_deviceType
                                } ]  
                    }); 		
	});
</script>

<%------------------------------------- $.datagrid----------------------------------------------%>


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
