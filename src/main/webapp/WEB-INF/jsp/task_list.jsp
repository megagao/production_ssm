<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="taskList" title="生产派工列表" data-options="singleSelect:false,collapsible:true,
		pagination:true,rownumbers:true,url:'task/list',method:'get',pageSize:10,fitColumns:true,toolbar:toolbar_task">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'taskId',align:'center',width:100">
				生产派工编号
			</th>
            <th data-options="field:'workId',align:'center',width:100,formatter:formatTaskWork">
				作业编号
			</th>
            <th data-options="field:'manufactureSn',align:'center',width:100,formatter:formatTaskManufacture">
				生产批号
			</th>
            <th data-options="field:'taskQuantity',align:'center',width:100">
				派工数量
			</th>
            <th data-options="field:'workingHours',width:100,align:'center'">
				派工工时
			</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_task" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='task:add'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="task_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='task:edit'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="task_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='task:delete'}">
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="task_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="task_reload()">刷新</a>  
	</div>  
	
    <div id="search_task" style="float: right;">
        <input id="search_text_task" class="easyui-searchbox"  
            data-options="searcher:doSearch_task,prompt:'请输入...',menu:'#menu_task'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_task" style="width:120px"> 
			<div data-options="name:'taskId'">生产派工编号</div> 
			<div data-options="name:'taskWorkId'">作业编号</div>
			<div data-options="name:'taskManufactureSn'">生产批号</div> 
		</div>     
    </div>  

</div>  
<div id="taskEditWindow" class="easyui-window" title="编辑生产派工" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'task/edit'" style="width:40%;height:55%;padding:10px;">
</div>
<div id="taskAddWindow" class="easyui-window" title="添加生产派工" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'task/add'" style="width:40%;height:55%;padding:10px;">
</div>

<div id="taskWorkInfo" class="easyui-dialog" title="作业信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:40%;height:55%;padding:10px;">
	<form id="taskWorkEditForm" method="post">
		<input type="hidden" name="workId"/>
	    <table cellpadding="5">
	    	<tr>
	            <td>工序号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="processNumber" data-options="required:true"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>产品:</td>
	            <td>
	            	<input class="easyui-combobox" name="productId" data-options="valueField:'productId',
	            		textField:'productName',url:'product/get_data', editable:false"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>工序:</td>
	            <td>
	            	<input class="easyui-combobox" name="processId" data-options="valueField:'processId',
	            		textField:'processId',url:'process/get_data', editable:false"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>设备:</td>
	            <td>
	            	<input class="easyui-combobox" name="deviceId" data-options="valueField:'deviceId',
	            		textField:'deviceName',url:'deviceList/get_data', editable:false"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>班产定额:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="rating"/>
    			</td>  
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTaskWorkEditForm()">提交</a>
	</div>
</div>
<div id="taskManufactureInfo" class="easyui-dialog" title="生产计划信息" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:40%;height:55%;padding:10px;">
	<form id="taskManufactureEditForm" method="post">
		<input type="hidden" name="id"/>
	    <table cellpadding="5">
	        <tr>
	            <td>生产批号:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="manufactureSn"/>
	            </td>
	        </tr>
	        <tr>
	            <td>订单编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="orderId" data-options="required:true,valueField:'orderId',
	            		textField:'orderId',url:'order/get_data', editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td>工艺:</td>
	            <td>
	            	<input class="easyui-combobox" name="technologyId" data-options="valueField:'technologyId',
	            		textField:'technologyName',url:'product/get_data', editable:false"/>
    			</td>  
	        </tr>
	        <tr>
	            <td>投产数量:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="launchQuantity"
						   data-options="min:1,max:99999999,precision:0,required:true"/>
				</td>
	        </tr>
	        <tr>
	            <td>订购日期:</td>
	            <td><input class="easyui-datetimebox" name="beginDate"     
        			data-options="showSeconds:true" value="5/5/2016 00:00:00" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>要求日期:</td>
	            <td><input class="easyui-datetimebox" name="endDate"     
        			data-options="showSeconds:true" value="5/5/2016 00:00:00" style="width:150px"> </td>
	        </tr>
	    </table>
	</form>
	<br><br>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitTaskManufactureEditForm()">提交</a>
	</div>
</div>
<script>
function doSearch_task(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#taskList").datagrid({
	        title:'生产派工列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_task", url:'task/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'taskId', width : 100, title : '生产派工编号', align:'center'},
				{field : 'workId', width : 100, align : 'center', title : '作业编号', formatter:formatTaskWork},
				{field : 'manufactureSn', width : 100, align : 'center', title : '生产批号',
					formatter:formatTaskManufacture},
				{field : 'workingHours', width : 100, title : '派工数量', align:'center'},
				{field : 'unitPrice', width : 100, title : '派工工时', align:'center'},
	        ] ],  
	    });
	}else{
		$("#taskList").datagrid({  
	        title:'生产派工列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_task", url:'task/search_task_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'taskId', width : 100, title : '生产派工编号', align:'center'},
				{field : 'workId', width : 100, align : 'center', title : '作业编号', formatter:formatTaskWork},
				{field : 'manufactureSn', width : 100, align : 'center', title : '生产批号',
					formatter:formatTaskManufacture},
				{field : 'workingHours', width : 100, title : '派工数量', align:'center'},
				{field : 'unitPrice', width : 100, title : '派工工时', align:'center'},
	        ] ],  
	    });
	}
}

//格式化作业信息
	function  formatTaskWork(value, row, index){ 
		if(value == null){
			return '无';
		}
		else{
			return "<a href=javascript:openTaskWork("+index+")>"+value+"</a>";
		}
	};
	
	//格式化生产计划信息
	function  formatTaskManufacture(value, row, index){ 
		if(value == null){
			return '无';
		}
		else{
			return "<a href=javascript:openTaskManufacture("+index+")>"+value+"</a>";
		}
		
	};
	
	//根据index拿到该行值
	function onTaskClickRow(index) {
		var rows = $('#taskList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开作业信息对话框
	function  openTaskWork(index){ 
		var row = onTaskClickRow(index);
		$("#taskWorkInfo").dialog({
    		onOpen :function(){
    			$.get("work/get/"+row.workId,'',function(data){
  		    		data.processId = data.process.processId; 
  	        		data.productId = data.product.productId;
  	        		data.deviceId = data.device.deviceId;
  		    		//回显数据
  		    		$("#taskWorkEditForm").form("load", data);
    	    	});
    		},
    	}).dialog("open");
	};
	
	function submitTaskWorkEditForm(){
		$.get("work/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#taskWorkEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			
    			$.post("work/update_all",$("#taskWorkEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改作业成功!','info',function(){
    						$("#taskWorkInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改作业失败!');
    				}
    			});
    		}
    	});
	}
	
	//打开生产计划信息对话框
	function  openTaskManufacture(index){ 
		var row = onTaskClickRow(index);
		$("#taskManufactureInfo").dialog({
    		onOpen :function(){
    			$.get("manufacture/get/"+row.manufactureSn,'',function(data){
    				data.orderId = data.cOrder.orderId; 
        			data.technologyId = data.technology.technologyId; 
        			data.beginDate = TAOTAO.formatDateTime(data.beginDate);
           			data.endDate = TAOTAO.formatDateTime(data.endDate);
    		    	//回显数据
    		    	$("#taskManufactureEditForm").form("load", data);
    	    	});
    		},
    	}).dialog("open");
	};
	
	function submitTaskManufactureEditForm(){
		$.get("manufacture/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#taskManufactureEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("manufacture/update_all",$("#taskManufactureEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#taskManufactureInfo").dialog("close");
    					$.messager.alert('提示','修改生产计划成功!');
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	
    function getTaskSelectionsIds(){
    	var taskList = $("#taskList");
    	var sels = taskList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].taskId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
    function task_add(){
    	$.get("task/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#taskAddWindow").window("open");
       		}
       	});
    }
    
    function task_edit(){
    	$.get("task/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getTaskSelectionsIds();
            	
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个生产派工才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个生产派工!');
            		return ;
            	}
            	
            	$("#taskEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#taskList").datagrid("getSelections")[0];
            			$("#taskEditForm").form("load", data);
            		}
            	}).window("open");
       		}
       	});
    }
    
    function task_delete(){
    	$.get("task/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getTaskSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中生产派工!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除ID为 '+ids+' 的生产派工吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("task/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除生产派工成功!',undefined,function(){
                					$("#taskList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
      		}
      	});
    }
    
    function task_reload(){
    	$("#taskList").datagrid("reload");
    }
</script>