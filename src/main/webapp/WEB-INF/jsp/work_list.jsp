<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="workList" title="作业列表" data-options="singleSelect:false,collapsible:true,
		pagination:true,rownumbers:true,url:'work/list',method:'get',pageSize:10, fitColumns:true,toolbar:toolbar_work">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'workId',align:'center',width:100">作业编号</th>
            <th data-options="field:'processNumber',align:'center',width:100">工序号</th>
            <th data-options="field:'product',align:'center',width:100,formatter:formatWorkProduct">产品</th>
            <th data-options="field:'process',align:'center',width:100,formatter:formatWorkProcess">工序</th>
            <th data-options="field:'device',align:'center',width:100,formatter:formatWorkDevice">设备</th>
            <th data-options="field:'rating',width:100,align:'center'">班产定额</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_work" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='work:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="work_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='work:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="work_edit()">编辑</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='work:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="work_delete()">删除</a>  
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="work_reload()">刷新</a>  
	</div>  
	
    <div id="search_work" style="float: right;">
        <input id="search_text_work" class="easyui-searchbox"  
            data-options="searcher:doSearch_work,prompt:'请输入...',menu:'#menu_work'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_work" style="width:120px"> 
			<div data-options="name:'workId'">作业编号</div> 
			<div data-options="name:'workProduct'">产品名称</div> 
			<div data-options="name:'workDevice'">设备名称</div> 
			<div data-options="name:'workProcess'">工序</div> 
		</div>     
    </div>  
</div>  

<div id="workEditWindow" class="easyui-window" title="编辑作业" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'work/edit'" style="width:40%;height:55%;padding:10px;">
</div>
<div id="workAddWindow" class="easyui-window" title="添加作业" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save',href:'work/add'" style="width:40%;height:55%;padding:10px;">
</div>

<div id="workProductInfo" class="easyui-dialog" title="产品信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="workProductEditForm" method="post">
		<input type="hidden" name="productId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>产品名称:</td>
	            <td><input class="easyui-textbox" type="text" name="productName" data-options="required:true"/></td>
	        </tr>
	        <tr>
	            <td>产品种类:</td>
	            <td><input class="easyui-textbox" type="text" name="productType" data-options="required:true"/></td>
	        </tr>
	        <tr>
	            <td>产品状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" data-options="required:true,width:150">
						<option value="1">有效产品</option>
						<option value="2">停产</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>相关图片:</td>
	            <td>
	            	 <div style="padding-top: 12px"><span id="workProductPicSpan"></span></div>
	                 <input type="hidden" class="easyui-linkbutton workProductPic" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>产品介绍:</td>
	            <td><textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitWorkProductEditForm()">提交</a>
	</div>
</div>

<div id="workProcessInfo" class="easyui-dialog" title="工序信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:35%;height:40%;padding:10px;">
	<form id="workProcessForm" method="post">
		<input type="hidden" name="processId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>工艺计划编号:</td>
	            <td>
	            	<input class="easyui-combobox" name="technologyPlanId" panelHeight="auto"  
    					data-options="required:true,valueField:'technologyPlanId',textField:'technologyPlanId',
    					url:'technologyPlan/get_data',editable:false"/> 
	            </td>
	        </tr>
	        <tr>
	            <td>工序顺序:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="sequence"/>
    			</td>  
	        </tr>
	         <tr>
	            <td>单件定额工时:</td>
	            <td>
	            	<input class="easyui-numberbox" type="text" name="quota"/>
    			</td>  
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitWorkProcessForm()">提交</a>
	</div>
</div>

<div id="workDeviceInfo" class="easyui-dialog" title="设备信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="workDeviceEditForm" method="post">
	    <input type="hidden" name="deviceId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>设备名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="deviceName" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>设备种类:</td>
	            <td>
	            	<input id="deviceTypeName" class="easyui-combobox" name="deviceTypeId" panelHeight="auto"
    					data-options="required:true,editable:false,valueField:'deviceTypeId',textField:'deviceTypeName',
    						url:'deviceType/get_data'" />
	            </td>
	        </tr>
	        <tr>
	            <td>设备状态:</td>
	            <td>
	            	<select id="deviceStatusCombobox" class="easyui-combobox" name="deviceStatusId"  style="width:173px" 
	            		data-options="editable:false" panelHeight="auto">
						<option value="1">良好</option>
						<option value="2">故障</option>
						<option value="3">维修</option>
						<option value="4">报废</option> 
					</select>
	            </td>
	        </tr>
	        <tr>
	            <td>购买日期:</td>
	            <td>
	            	<input class="easyui-datetimebox"  data-options="formatter:TAOTAO.formatDatetime"
						   name="devicePurchaseDate"/>
	            </td>
	        </tr>
	        
	        <tr>
	            <td>购买价格:</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" maxlength="11" name="devicePurchasePrice"/>
	            </td>
	        </tr>
	        <tr>
	            <td>出厂日期:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceManufactureDate"/>
	            </td>
	        </tr>
	        <tr>
	            <td>使用年限:</td>
	            <td>
	            	<input class="easyui-datetimebox" name="deviceServiceLife"/>
	            </td>
	        </tr>
	        <tr>
	            <td>保管人:</td>
	            <td>
		            <input id="deviceKeeper" class="easyui-combobox" name="deviceKeeperId" panelHeight="auto"
    					data-options="required:true,editable:false,valueField:'deviceKeeperId',textField:'deviceKeeper',
    						url:'employee/get_data'" />
				</td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	    <input type="hidden" name="deviceParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitWorkDeviceEditForm()">提交</a>
	</div>
</div>

<script>
function doSearch_work(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#workList").datagrid({
	        title:'作业列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_work", url:'work/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'workId', width : 100, title : '作业编号', align:'center'},
				{field : 'processNumber', width : 100, align : 'center', title : '工序号'},
				{field : 'product', width : 100, align : 'center', title : '产品', formatter:formatWorkProduct},
				{field : 'process', width : 100, title : '工序', align:'center', formatter:formatWorkProcess},
				{field : 'device', width : 100, title : '设备', align:'center',formatter:formatWorkDevice},
				{field : 'rating', width : 100, title : '班产定额', align:'center'}
	        ] ],
	    });
	}else{
		$("#workList").datagrid({  
	        title:'作业列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_work", url:'work/search_work_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'workId', width : 100, title : '作业编号', align:'center'},
				{field : 'processNumber', width : 100, align : 'center', title : '工序号'},
				{field : 'product', width : 100, align : 'center', title : '产品', formatter:formatWorkProduct},
				{field : 'process', width : 100, title : '工序', align:'center', formatter:formatWorkProcess},
				{field : 'device', width : 100, title : '设备', align:'center',formatter:formatWorkDevice},
				{field : 'rating', width : 100, title : '班产定额', align:'center'}
	        ] ],  
	    });
	}
}
	var workProductEditor;
	var workDeviceEditor;
	
	//格式化工序信息
	function  formatWorkProcess(value, row, index){ 
		if(value == null){
			return '无';
		}
		else{
			return "<a href=javascript:openWorkProcess("+index+")>"+row.process.processId+"</a>";
		}
	};
	
	//格式化产品信息
	function  formatWorkProduct(value, row, index){ 
		if(value == null){
			return '无';
		}
		else{
			return "<a href=javascript:openWorkProduct("+index+")>"+value.productName+"</a>";
		}
		
	};
	
	//格式化设备信息
	function  formatWorkDevice(value, row, index){ 
		if(value == null){
			return '无';
		}
		else{
			return "<a href=javascript:openWorkDevice("+index+")>"+row.device.deviceName+"</a>";
		}
	};
	
	//根据index拿到该行值
	function onWorkClickRow(index) {
		var rows = $('#workList').datagrid('getRows');
		return rows[index];
		
	}
	
	//打开产品信息对话框
	function  openWorkProduct(index){ 
		var row = onWorkClickRow(index);
		$("#workProductInfo").dialog({
    		onOpen :function(){
    			$.get("product/get/"+row.product.productId,'',function(data){
    				
    				workProductEditor = TAOTAO.createEditor("#workProductEditForm [name=note]");	
		    		//回显数据
		    		$("#workProductEditForm").form("load", data);
		    		workProductEditor.html(data.note);
		    		
		    		initWorkProductPic({
        				"pics" : data.image,
        			});
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#workProductEditForm [name=note]");
			   	$("#workProductPicSpan").html('');
			}
    	}).dialog("open");
	};
	
	// 加载图片
    function initWorkProductPic(data){
    	$(".workProductPic").each(function(i,e){
    		var _ele = $(e);
    		_ele.siblings("div.pics").remove();
    		_ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
    		// 回显图片
    		var j = false;
        	if(data && data.pics){
        		var imgs = data.pics.split(",");
        		for(var i in imgs){
        			if($.trim(imgs[i]).length > 0){
        				_ele.siblings(".pics").find("ul").append("<li><a id='img"+i+"' href='"+imgs[i]+"' target='_blank'>" +
        						"<img src='"+imgs[i]+"' width='80' height='50' /></a> ");
        				j = true;
        			}
        		}
        	}
        	if(!j){
    			$("#workProductPicSpan").html("<span style='font-size: 12px;font-family: Microsoft YaHei;'>无</span>");
    		}
    	});
    }
	
	function submitWorkProductEditForm(){
		$.get("product/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#workProductEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			workProductEditor.sync();
    			
    			$.post("product/update_all",$("#workProductEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改产品成功!','info',function(){
    						$("#workProductInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改产品失败!');
    				}
    			});
    		}
    	});
	}
	
	//打开工序信息对话框
	function  openWorkProcess(index){ 
		var row = onWorkClickRow(index);
		
		$("#workProcessInfo").dialog({
			onOpen :function(){
				$.get("process/get/"+row.process.processId,'',function(data){
		    		//回显数据
		    		$("#workProcessForm").form("load", data);
		    	});
			},
		}).dialog("open");
	};
	
	function submitWorkProcessForm(){
		//此处写工序信息
		$.get("process/edit_judge",'',function(data){
			if(data.msg != null){
				$.messager.alert('提示', data.msg);
			}else{
				if(!$('#workProcessForm').form('validate')){
					$.messager.alert('提示','表单还未填写完成!');
					return ;
				}
				//此处写工序信息
				$.post("process/update_all",$("#workProcessForm").serialize(), function(data){
					if(data.status == 200){
						$.messager.alert('提示','修改工序成功!','info',function(){
							$("#workProcessInfo").dialog("close");
						});
					}else{
						$.messager.alert('提示', data.msg);
					}
				});
			}
		});
	}
	
	//打开设备信息对话框
	function  openWorkDevice(index){ 
		var row = onWorkClickRow(index);
		$("#workDeviceInfo").dialog({
    		onOpen :function(){
    			$.get("deviceList/get/"+row.device.deviceId,'',function(data){
    				
    				workDeviceEditor = TAOTAO.createEditor("#workDeviceEditForm [name=note]");	
		    		//回显数据
		    		data.devicePurchaseDate = TAOTAO.formatDateTime(data.devicePurchaseDate);
	    			data.deviceManufactureDate = TAOTAO.formatDateTime(data.deviceManufactureDate);
	    			data.deviceServiceLife = TAOTAO.formatDateTime(data.deviceServiceLife);
	    			$("#workDeviceEditForm").form("load", data);
		    		workDeviceEditor.html(data.note);
    	    	});
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#workDeviceEditForm [name=note]");
			}
    	}).dialog("open");
	};
	
	function submitWorkDeviceEditForm(){
		$.get("deviceList/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#workDeviceEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			workDeviceEditor.sync();
    			
    			$.post("deviceList/update",$("#workDeviceEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改设备成功!','info',function(){
    						$("#workDeviceInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误','修改设备失败!');
    				}
    			});
    		}
    	});
	}
	
    function getWorkSelectionsIds(){
    	var workList = $("#workList");
    	var sels = workList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].workId);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function work_add(){
    	$.get("work/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#workAddWindow").window("open");
       		}
       	});
    }
    
    function work_edit(){
    	$.get("work/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getWorkSelectionsIds();
            	
            	if(ids.length == 0){
            		$.messager.alert('提示','必须选择一个作业才能编辑!');
            		return ;
            	}
            	if(ids.indexOf(',') > 0){
            		$.messager.alert('提示','只能选择一个作业!');
            		return ;
            	}
            	
            	$("#workEditWindow").window({
            		onLoad :function(){
            			//回显数据
            			var data = $("#workList").datagrid("getSelections")[0];
            			data.processId = data.process.processId; 
            			data.productId = data.product.productId;
            			data.deviceId = data.device.deviceId;
            			$("#workEditForm").form("load", data);
            		}
            	}).window("open");
       		}
       	});
    }
    
    function work_delete(){
    	$.get("work/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getWorkSelectionsIds();
            	if(ids.length == 0){
            		$.messager.alert('提示','未选中作业!');
            		return ;
            	}
            	$.messager.confirm('确认','确定删除ID为 '+ids+' 的作业吗？',function(r){
            	    if (r){
            	    	var params = {"ids":ids};
                    	$.post("work/delete_batch",params, function(data){
                			if(data.status == 200){
                				$.messager.alert('提示','删除作业成功!',undefined,function(){
                					$("#workList").datagrid("reload");
                				});
                			}
                		});
            	    }
            	});
       		}
       	});
    }
    
    function work_reload(){
    	$("#workList").datagrid("reload");
    }
</script>