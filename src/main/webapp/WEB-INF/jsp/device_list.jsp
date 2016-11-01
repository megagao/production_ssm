<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<!-- singleSelect:true, -->
<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->

<!-- <script type="text/javascript" src="js/json2.js"></script> -->
<!-- =。=   设置了过滤器后就可以自动分页了 -->
<!-- url:'device/list', -->

<table id="deviceList" title="设备台账" style="height:389px"></table>

<div style="margin:18x 0;"></div>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>

<script type="text/javascript">

	var deviceListEditIndex = undefined;
	function endEditing_deviceList() {
		if (deviceListEditIndex == undefined) {
console.log("endEditing_deviceList  undefined true");
			return true
		}
		if ($('#deviceList').datagrid('validateRow', deviceListEditIndex)) {
			
			/* deviceTypeName */
			var deviceTypeNameED_List = $('#deviceList').datagrid('getEditor',
					{
						index : deviceListEditIndex,
						field : 'deviceTypeId'
					});
			var deviceTypeName = $(deviceTypeNameED_List.target).combobox(
					'getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceTypeName'] = deviceTypeName;

			/* deviceStatus */
			var deviceStatusED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceStatusId'
			});
			var deviceStatus = $(deviceStatusED_List.target)
					.combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceStatus'] = deviceStatus;
			
			/* deviceKeeper */
			var deviceKeeperED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceKeeperId'
			});
			var deviceKeeper = $(deviceKeeperED_List.target)
					.combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceKeeper'] = deviceKeeper;

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

		var selections = $('#deviceList').datagrid('getSelections');
		if(selections.length >=2){
			$('#deviceList').datagrid('unselectAll');
			$('#deviceList').datagrid('selectRow',index);
		}
		
		if(index != deviceListEditIndex && deviceListEditIndex != undefined){
			/* deviceTypeName */
			var deviceTypeNameED_List = $('#deviceList').datagrid('getEditor',
					{
						index : deviceListEditIndex,
						field : 'deviceTypeId'
					});
			var deviceTypeName = $(deviceTypeNameED_List.target).combobox(
					'getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceTypeName'] = deviceTypeName;

			/* deviceStatus */
			var deviceStatusED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceStatusId'
			});
			var deviceStatus = $(deviceStatusED_List.target)
					.combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceStatus'] = deviceStatus;
			
			/* deviceKeeper */
			var deviceKeeperED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceKeeperId'
			});
			var deviceKeeper = $(deviceKeeperED_List.target)
					.combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceKeeper'] = deviceKeeper;
			
			
			$('#deviceList').datagrid('endEdit', deviceListEditIndex);
			deviceListEditIndex = undefined;
		}
console.log(selections);
	}

	function edit_deviceList() {
	 	
		/* 得到所有选择行的索引 */
		var rowSelections = $('#deviceList').datagrid('getSelections');
		if(rowSelections.length==0){
			return;		
		}
		if(rowSelections.length>=2){
			$.messager.alert('提示','请选择一条记录进入编辑！','warning');
        	return ;
		}
		/* 得到选择行的索引 */
		var rowSelection = rowSelections[0];

		var rowSelectionIndex = $('#deviceList').datagrid('getRowIndex',rowSelection);
 
		/* 进入编辑状态 */
		if (deviceListEditIndex != rowSelectionIndex) {
			if (endEditing_deviceList()) {
				$('#deviceList').datagrid('selectRow', rowSelectionIndex).datagrid(
						'beginEdit', rowSelectionIndex);
				deviceListEditIndex = rowSelectionIndex;
			} else {
				$('#deviceList').datagrid('selectRow', deviceListEditIndex);
			}
		}
console.log(rowSelection);
	
<%--
		$('#deviceList').datagrid('selectRow', 0).datagrid(
						'beginEdit', 0);
--%>

		$('#deviceList').datagrid('clearSelections');
	 
	}

	function append_deviceList() {

		if (endEditing_deviceList()) { 

<%--  	
			var options = $('#deviceList').datagrid('getPager').data('pagination').options;
			//当前页码
			var currentPage = options.pageNumber;
			//总条目数
			var totalRows = options.total;
			//总页数
			var totalPages = Math.ceil(totalRows/options.pageSize);
			$('#deviceList').datagrid({pageNumber: totalPages});
			/* append_deviceList_assist(); */
--%>

			var newIdIndex = $('#deviceList').datagrid('getRows').length - 1;
			console.log("newIdIndex : " + newIdIndex);
			var newId_string = $('#deviceList').datagrid('getRows')[newIdIndex].deviceId;
			var newId_int = parseInt(newId_string) + 1;
			if (newId_int < 10)
				newId_int = "00" + newId_int;
			else if (newId_int < 100)
				newId_int = "0" + newId_int;

			$('#deviceList').datagrid('appendRow', {
				deviceId : newId_int
			});

			deviceListEditIndex = $('#deviceList').datagrid('getRows').length - 1;
			$('#deviceList').datagrid('selectRow', deviceListEditIndex)
					.datagrid('beginEdit', deviceListEditIndex);

			$('#deviceList').datagrid('clearSelections');
		}
	}

	function remove_deviceList() {

		var selections = $('#deviceList').datagrid('getSelections');
		if(selections.length==0){
			$.messager.alert('提示','请至少选择一条设备信息进行移除！','warning');
        	return ;
		}
		
		for (var i = 0; i < selections.length; i++) {
			var selectionIndex = $('#deviceList').datagrid('getRowIndex',
					selections[i]);
			$('#deviceList').datagrid('deleteRow', selectionIndex);
		}
		if (selections.length > 0) {
			deviceListEditIndex = undefined;
		}
	}

	function accept_deviceList() {
	
		if(deviceListEditIndex != undefined){
			/* deviceTypeName */
			var deviceTypeNameED_List = $('#deviceList').datagrid('getEditor',
					{
						index : deviceListEditIndex,
						field : 'deviceTypeId'
					});
			var deviceTypeName = $(deviceTypeNameED_List.target).combobox(
					'getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceTypeName'] = deviceTypeName;

			/* deviceStatus */
			var deviceStatusED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceStatusId'
			});
			var deviceStatus = $(deviceStatusED_List.target)
					.combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceStatus'] = deviceStatus;
			
			/* deviceKeeper */
			var deviceKeeperED_List = $('#deviceList').datagrid('getEditor', {
				index : deviceListEditIndex,
				field : 'deviceKeeperId'
			});
			var deviceKeeper = $(deviceKeeperED_List.target)
					.combobox('getText');
			$('#deviceList').datagrid('getRows')[deviceListEditIndex]['deviceKeeper'] = deviceKeeper;
			
			
			$('#deviceList').datagrid('endEdit', deviceListEditIndex);
			deviceListEditIndex = undefined;
		}
	 
		//sync with database before accept
		var rowsInserted = $('#deviceList').datagrid('getChanges', 'inserted');
		var rowsDeleted = $('#deviceList').datagrid('getChanges', 'deleted');
		var rowsUpdated = $('#deviceList').datagrid('getChanges', 'updated');
		
		//sync
		//Inserted
		for (var i = 0; i < rowsInserted.length; i++) {
			$.post("deviceList/insert",rowsInserted[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('添加成功!');
				}
			});
		}
		
		//Deleted
		for (var i = 0; i < rowsDeleted.length; i++) {
			$.post("deviceList/delete",{"deviceId":rowsDeleted[i].deviceId}, function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('删除成功!');
				}
			});
		}
		 
		//Updated
		for (var i = 0; i < rowsUpdated.length; i++) {
			$.post("deviceList/update",rowsUpdated[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					console.log('更新成功!');
				}
			});
		}
	 	 
		 
		if (endEditing_deviceList()) {
			$('#deviceList').datagrid('acceptChanges');
		}

	}

	function reject_deviceList() {

		$('#deviceList').datagrid('rejectChanges');
		deviceListEditIndex = undefined;
	}

	function getChanges_deviceList() {
/* $('#deviceList').datagrid('endEdit', 6);
deviceListEditIndex = undefined; */
		var rowsInserted = $('#deviceList').datagrid('getChanges', 'inserted');
		var rowsDeleted = $('#deviceList').datagrid('getChanges', 'deleted');
		var rowsUpdated = $('#deviceList').datagrid('getChanges', 'updated');
		/* alert(rows.length + ' rows are changed!'); */
		console.log(rowsInserted.length + ' rows are inserted changed!');
		console.log(rowsDeleted.length + ' rows are deleted changed!');
		console.log(rowsUpdated.length + ' rows are updated changed!');
		console.log(rowsInserted);
		console.log(rowsDeleted);
		console.log(rowsUpdated);
	}
	
</script>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>


<%------------------------------------- $.datagrid----------------------------------------------%>

<script type="text/javascript">
	$(function() {
		  	var list_type;
		  	var list_keeper;
			$.ajax({    
			      url:'deviceList/list_type',    
			      dataType : 'json',    
			      type : 'GET',    
			      async:false,  
			      success: function (data){    
			      	list_type = data; 
			      }    
			}); 
			$.ajax({    
			      url:'employee/list_keeper',    
			      dataType : 'json',    
			      type : 'GET',    
			      async:false,  
			      success: function (data){    
			      	list_keeper = data; 
			      }    
			}); 
			/* debugger; */   
			$('#deviceList').datagrid(  
                    {  
					   toolbar:'#toobar_deviceList',
					   url:'deviceList/list',
					   method:'get',
					   pagination:true,
					   pageSize:10,
					   pageList:[10, 20, 30], 
					   remoteSort:false,
					   multiSort:true,
					   onClickRow: onClickRow_deviceList,
					   onClickCell: onClickCell_deviceList,  
                       columns : [ [  
                                {  
                                    field : 'ck',  
                                    checkbox : true  
                                },  
                                {  
                                    field : 'deviceId',  
                                    title : 'ID',  
                                    width : 80,  
                                    align : 'center',
                                    sortable:true,  
                                    type:'text'
                                },  
                                {  
                                    field : 'deviceName',  
                                    title : '名称',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true,  
                                    editor : {  
                                        type : 'text'  
                                    }  
                                },  
                                {  
                                    field : 'deviceTypeId',  
                                    title : '种类',  
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
											valueField:'deviceTypeId',
											textField:'deviceTypeName',
											editable:false,
											panelHeight:'auto' 
										}
									}
                                },  
                                {  
                                    field : 'deviceStatusId',  
                                    title : '状态',  
                                    width : 70,  
                                    align : 'center',
                                    sortable:true,  
                                    formatter:function(value,row){
										return row.deviceStatus;
									},
									editor:{
										type:'combobox',
										options:{
											valueField:'deviceStatusId',
											textField:'deviceStatus',
											editable:false,
											panelHeight:'auto',
											data : [ {  
					                            deviceStatusId : '1',  
					                            deviceStatus : '良好'  
					                        }, {  
					                            deviceStatusId : '2',  
					                            deviceStatus : '故障'  
					                        }, {  
					                            deviceStatusId : '3',  
					                            deviceStatus : '维修'  
					                        }, {  
					                            deviceStatusId : '4',  
					                            deviceStatus : '报废'  
					                        }]  

										}
									} 
                                },
                                {  
                                    field : 'devicePurchaseDate',  
                                    title : '购买日期',  
                                    width : 170,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'datetimebox',
                                    formatter:TAOTAO.formatDateTime
                                },
                                {  
                                    field : 'devicePurchasePrice',  
                                    title : '购买价格',  
                                    width : 80,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:{
										type:'numberbox',
										options:{
											min:0,
											max:999999,
											precision:2
										}
									}
                                },
                                {  
                                    field : 'deviceManufactureDate',  
                                    title : '出厂日期',  
                                    width : 170,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'datetimebox',
                                    formatter:TAOTAO.formatDateTime
                                },
                                {  
                                    field : 'deviceServiceLife',  
                                    title : '使用年限',  
                                    width : 170,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'datetimebox',
                                    formatter:TAOTAO.formatDateTime
                                },
                                {  
                                    field : 'deviceKeeperId',  
                                    title : '保管人',  
                                    width : 120,  
                                    align : 'center',
                                    formatter:function(value,row){
										return row.deviceKeeper;
									},
									editor:{
										type:'combobox',
										options:{
											data:list_keeper,
											valueField:'deviceKeeperId',
											textField:'deviceKeeper',
											editable:false,
											panelHeight:'auto'
										}
									}
                                },
                                {  
                                    field : 'note',  
                                    title : '备注',  
                                    width : 270,  
                                    align : 'center',
                                    editor:'text'
                                }
                                 ] ],  
                        toolbar : [  
                                {  
                                    id : "deviceEdit",
                                    class:"easyui-linkbutton",  
                                    text : '编辑',  
                                    iconCls : 'icon-edit',
                                    plain:true,  
                                    handler : edit_deviceList
                                },  
                                {  
                                    id : "deviceAdd",
                                    class:"easyui-linkbutton",  
                                    text : '添加',
                                    iconCls:'icon-add',
                                    plain:true,  
                                    handler : append_deviceList
                                },  
                                {  
                                    id : "deviceRemove",
                                    class:"easyui-linkbutton",  
                                    text : '移除',
                                    iconCls:'icon-remove',
                                    plain:true,  
                                    handler : remove_deviceList
                                },  
                                {  
                                    id : "deviceReject",
                                    class:"easyui-linkbutton",  
                                    text : '撤销',
                                    iconCls:'icon-undo',
                                    plain:true,  
                                    handler : reject_deviceList
                                },  
                                {  
                                    id : "deviceSave",
                                    class:"easyui-linkbutton",  
                                    text : '保存',
                                    iconCls:'icon-save',
                                    plain:true,  
                                    handler : accept_deviceList
                                },  
                                {  
                                    id : "deviceGetChanged",
                                    class:"easyui-linkbutton",  
                                    text : '查看改变',
                                    iconCls:'icon-search', 
                                    plain:true, 
                                    handler : getChanges_deviceList
                                } ]  
                    }); 		
	});
</script>

<%------------------------------------- $.datagrid----------------------------------------------%>


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
			field : 'deviceId',
			type : 'text',
			options : {
				precision : -2
			},
			op : [ 'equal', 'notequal', 'less', 'greater' ]
		}, {
			field : 'deviceStatusId',
			type : 'combobox',
			options : {
				valueField : 'deviceStatusId',
				textField : 'deviceStatus',
				method : 'get',
				url : 'json/deviceList_Status_Filter.json',
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
<!-- 
<script>
	$(function() {
		$('#deviceList').datagrid({
		
		});
	});

</script>
 -->