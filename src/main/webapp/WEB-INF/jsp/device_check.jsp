<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="GBK"%>

<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<!-- singleSelect:true, -->
<!-- 此注解放table_data-options里会导致在IE里显示不正常  -- "IE真的是狠严（ruo）格（zhi）啊" -->
<table id="deviceCheck" title="设备例检" style="height:389px"></table>

<div style="margin:18x 0;"></div>

<%------------------------------------- ADD DELETE UPDATE SEARCH -------------------------------------%>

<script type="text/javascript">
	var deviceCheckEditIndex = undefined;
	
	function ENDEDITWHENBLUR_DEVICECHECK(){
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
	}
	
	function endEditing_deviceCheck() {
		if (deviceCheckEditIndex == undefined) {
			return true
		}
		if ($('#deviceCheck').datagrid('validateRow', deviceCheckEditIndex)) {
			ENDEDITWHENBLUR_DEVICECHECK();			
			return true;
		} else {
			return false;
		}
	}

	function onClickRow_deviceCheck(index, row) {

		var selections = $('#deviceCheck').datagrid('getSelections');
		if(selections.length >=2){
			$('#deviceCheck').datagrid('unselectAll');
			$('#deviceCheck').datagrid('selectRow',index);
		}
		
		if(index != deviceCheckEditIndex && deviceCheckEditIndex != undefined){
			ENDEDITWHENBLUR_DEVICECHECK();
		}
	}
	
	function onBeforeLoad_deviceCheck() {
		deviceCheckEditIndex = undefined;
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

			var Nowadays = new Date();
			
			$('#deviceCheck').datagrid('appendRow', {
				deviceCheckId : newId_int,
				deviceCheckDate : Nowadays.format("yyyy-MM-dd hh:mm:ss")
			});
			deviceCheckEditIndex = $('#deviceCheck').datagrid('getRows').length - 1;
			$('#deviceCheck').datagrid('selectRow', deviceCheckEditIndex)
					.datagrid('beginEdit', deviceCheckEditIndex);

			$('#deviceCheck').datagrid('clearSelections');
		}
	}

	function remove_deviceCheck() {
		var selections = $('#deviceCheck').datagrid('getSelections');
		if(selections.length==0){
			$.messager.alert('提示','请至少选择一条设备例检信息进行移除！','warning');
        	return ;
		}

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
	
		if(deviceCheckEditIndex != undefined){
			ENDEDITWHENBLUR_DEVICECHECK();
		}
	
		//sync with database before accept
		var rowsInserted = $('#deviceCheck').datagrid('getChanges', 'inserted');
		var rowsDeleted = $('#deviceCheck').datagrid('getChanges', 'deleted');
		var rowsUpdated = $('#deviceCheck').datagrid('getChanges', 'updated');

		//sync
		//Inserted
		var iI = 0;
		for (var i = 0; i < rowsInserted.length; i++) {
			$.post("deviceCheck/insert",rowsInserted[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					iI++;
				}
				if(iI==rowsInserted.length && iI>0){
					console.log('添加成功!');
					$.messager.show({
						title:'保存状态',
						msg:'添加成功',
						timeout:2000,
						showType:'show'
					});
				}
			});
		}
		
		
		//Deleted
		var iD = 0;
		for (var i = 0; i < rowsDeleted.length; i++) {
			$.post("deviceCheck/delete",{"deviceCheckId":rowsDeleted[i].deviceCheckId}, function(data){
			console.log(data.status);
				if(data.status == 200){
					iD++;
				}
				if(iD==rowsDeleted.length && iD>0){
					console.log('删除成功!');
					$.messager.show({
						title:'保存状态',
						msg:'删除成功',
						timeout:2000,
						showType:'show'
					});
				}
			});
		}
		
		 
		//Updated
		var iU = 0;
		for (var i = 0; i < rowsUpdated.length; i++) {
			$.post("deviceCheck/update",rowsUpdated[i], function(data){
			console.log(data.status);
				if(data.status == 200){
					iU++;
				}
				if(iU==rowsUpdated.length && iU>0){
					console.log('更新成功!');
					$.messager.show({
						title:'保存状态',
						msg:'更新成功',
						timeout:2000,
						showType:'show'
					});
				}
			});
		}
		
	 	
	
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

<%------------------------------------- $.datagrid----------------------------------------------%>

<script type="text/javascript">
	$(function() {
		  	var list_name;
		  	var list_faultid;
			$.ajax({    
			      url:'deviceList/list_name',    
			      dataType : 'json',    
			      type : 'GET',    
			      async:false,  
			      success: function (data){    
			      	list_name = data; 
			      }    
			});
			$.ajax({    
			      url:'deviceFault/list_faultid',    
			      dataType : 'json',    
			      type : 'GET',    
			      async:false,  
			      success: function (data){    
			      	list_faultid = data; 
			      }    
			}); 
			/* debugger;  */  
			$('#deviceCheck').datagrid(  
                    {  
					   toolbar:'##toobar_deviceCheck',
					   url:'deviceCheck/list',
					   method:'get',
					   pagination:true,
					   pageSize:10,
					   pageList:[10, 20, 30], 
					   remoteSort:false,
					   multiSort:true,
					   onClickRow: onClickRow_deviceCheck,
					   onBeforeLoad:onBeforeLoad_deviceCheck,
                       columns : [ [  
                                {  
                                    field : 'ck',  
                                    checkbox : true  
                                },  
                                {  
                                    field : 'deviceCheckId',  
                                    title : '例检编号',  
                                    width : 80,  
                                    align : 'center',
                                    sortable:true,  
                                    type:'text'
                                },  
                                {  
                                    field : 'deviceId',  
                                    title : '设备编号',  
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
                                    field : 'deviceIdd',  
                                    title : '设备名称',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true, 
                                    formatter:function(value,row){
										return row.deviceName;
									},
									editor:{
										type:'combobox',
										options:{
											data:list_name,
											valueField:'deviceIdd',
											textField:'deviceName',
											panelHeight:'auto' 
										}
									}
                                },  
                                {  
                                    field : 'deviceCheckEmp',  
                                    title : '例检人',  
                                    width : 120,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'text'
                                },
                                {  
                                    field : 'deviceCheckDate',  
                                    title : '例检时间',  
                                    width : 190,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'datetimebox'
                                },
                                {  
                                    field : 'deviceCheckResult',  
                                    title : '例检结果',  
                                    width : 120,  
                                    align : 'center',
                                    sortable:true,  
                                    editor:'text'
                                },
                                {  
                                    field : 'deviceCheckFaultIdd',  
                                    title : '例检故障编号',  
                                    width : 100,  
                                    align : 'center',
                                    sortable:true,  
                                    formatter:function(value,row){
										return row.deviceCheckFaultId;
									},
									editor:{
										type:'combobox',
										options:{
											data:list_faultid,
											valueField:'deviceCheckFaultIdd',
											textField:'deviceCheckFaultId',
											panelHeight:'auto' 
										}
									}
                                }
                                 ] ],  
                        toolbar : [  
                                {  
                                    id : "deviceCheckEdit",
                                    class:"easyui-linkbutton",  
                                    text : '编辑',  
                                    iconCls : 'icon-edit',
                                    plain:true,  
                                    handler : edit_deviceCheck
                                },  
                                {  
                                    id : "deviceCheckAdd",
                                    class:"easyui-linkbutton",  
                                    text : '添加',
                                    iconCls:'icon-add',
                                    plain:true,  
                                    handler : append_deviceCheck
                                },  
                                {  
                                    id : "deviceCheckRemove",
                                    class:"easyui-linkbutton",  
                                    text : '移除',
                                    iconCls:'icon-remove',
                                    plain:true,  
                                    handler : remove_deviceCheck
                                },  
                                {  
                                    id : "deviceCheckReject",
                                    class:"easyui-linkbutton",  
                                    text : '撤销',
                                    iconCls:'icon-undo',
                                    plain:true,  
                                    handler : reject_deviceCheck
                                },  
                                {  
                                    id : "deviceCheckSave",
                                    class:"easyui-linkbutton",  
                                    text : '保存',
                                    iconCls:'icon-save',
                                    plain:true,  
                                    handler : accept_deviceCheck
                                },  
                                {  
                                    id : "deviceCheckGetChanged",
                                    class:"easyui-linkbutton",  
                                    text : '查看改变',
                                    iconCls:'icon-search', 
                                    plain:true, 
                                    handler : getChanges_deviceCheck
                                } ]  
                    }); 		
	});
</script>

<%------------------------------------- $.datagrid----------------------------------------------%>


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
