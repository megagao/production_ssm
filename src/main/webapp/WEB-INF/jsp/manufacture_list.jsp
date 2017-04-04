<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<link href="css/uploadfile.css" rel="stylesheet"> 
<script src="js/jquery.uploadfile.js"></script>
<script src="js/malsup.github.iojquery.form.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="manufactureList" title="生产计划列表" data-options="singleSelect:false,
		collapsible:true,pagination:true,rownumbers:true,url:'manufacture/list',method:'get',pageSize:10,
		fitColumns:true,toolbar:toolbar_manufacture">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'manufactureSn',align:'center',width:150">生产批号</th>
            <th data-options="field:'cOrder',align:'center',width:150,formatter:formatManuOrder">订单</th>
            <th data-options="field:'technology',align:'center',width:150,formatter:formatManuTechnology">工艺</th>
            <th data-options="field:'launchQuantity',align:'center',width:100">投产数量</th>
            <th data-options="field:'beginDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">开始日期</th>
            <th data-options="field:'endDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">结束日期</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_manufacture" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='manufacture:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="manufacture_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='manufacture:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="manufacture_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='manufacture:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="manufacture_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="manufacture_reload()">刷新</a>  
	</div>  
	
    <div id="search_manufacture" style="float: right;">
        <input id="search_text_manufacture" class="easyui-searchbox"  
            data-options="searcher:doSearch_manufacture,prompt:'请输入...',menu:'#menu_manufacture'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_manufacture" style="width:120px"> 
			<div data-options="name:'manufactureSn'">生产批号</div> 
			<div data-options="name:'manufactureOrderId'">订单编号</div> 
			<div data-options="name:'manufactureTechnologyName'">工艺</div>
		</div>     
    </div>  

</div>  

<div id="manufactureEditWindow" class="easyui-window" title="编辑生产计划" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'manufacture/edit'" style="width:40%;height:60%;padding:10px;">
</div>
<div id="manufactureAddWindow" class="easyui-window" title="添加生产计划" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'manufacture/add'" style="width:40%;height:60%;padding:10px;">
</div>

<div id="manuOrderInfo" class="easyui-dialog" title="订单信息" data-options="modal:true,closed:true,
		resizable:true,iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="manuOrderEditForm" method="post">
		<input type="hidden" name="orderId"/>
	    <table cellpadding="5">
	         <tr>
	            <td>订购客户:</td>
	            <td>
	            	<input id="custom" class="easyui-combobox" name="customId" data-options="required:true,
	            		valueField:'customId',textField:'customName',url:'custom/get_data', editable:false" />
	            </td>
	        </tr>
	        <tr>
	            <td>订购产品:</td>
	            <td>
	            	<input id="product" class="easyui-combobox" name="productId" data-options="valueField:'productId',
	            		textField:'productName',url:'product/get_data', editable:false" />
    			</td>  
	        </tr>
	        <tr>
	            <td>订购数量:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="quantity"
						   data-options="min:1,max:99999999,precision:0,required:true" />
				</td>
	        </tr>
	        <tr>
	            <td>税前单价:</td>
	            <td>
					<input class="easyui-numberbox" type="text" name="unitPrice"
						   data-options="min:1,max:99999999,precision:2,required:true"/>
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td>
					<input  class="easyui-textbox" type="text" name="unit"/>
				</td>
	        </tr>
	        <tr>
	            <td>订单状态:</td>
	            <td>
		            <select id="cc" class="easyui-combobox" name="status" data-options="required:true,width:150,
		            	editable:false">
						<option value="1">未开始</option>
						<option value="2">已开始</option>
						<option value="3">已完成</option>
						<option value="4">订单取消</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>订购日期:</td>
	            <td><input class="easyui-datetimebox" name="orderDate"     
        			data-options="required:true,showSeconds:true" value="5/5/2016 00:00:00" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>要求日期:</td>
	            <td><input class="easyui-datetimebox" name="requestDate"     
        			data-options="required:true,showSeconds:true" value="5/5/2016 00:00:00" style="width:150px"> </td>
	        </tr>
	        <tr>
	            <td>合同扫描件:</td>
	            <td>
	            	 <div style="padding-top: 12px"><span id="manuPicSpan"></span></div>
	                 <input type="hidden" class="easyui-linkbutton manuPic" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>附件:</td>
	            <td>
	            	 <div id="manuFileuploader"><span id="manuFileSpan"></span></div>
	                 <input id="manuFile" type="hidden" name="file"/>
	            </td>
	        </tr>
	        <tr>
	            <td>商品描述:</td>
	            <td>
	                <textarea style="width:800px;height:300px;visibility:visible;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitManuOrderEditForm()">提交</a>
	</div>
</div>

<div id="manuTechnologyInfo" class="easyui-dialog" title="工艺信息" data-options="modal:true,closed:true,resizable:true,
		iconCls:'icon-save'" style="width:40%;height:55%;padding:10px;">
	<form id="manuTechnologyEditForm" class="technologyForm" method="post">
		<input type="hidden" name="technologyId"/>
	    <table cellpadding="5">
	        <tr>
	            <td>工艺名称:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="technologyName" data-options="required:true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>外协价格:</td>
	            <td>
	            	<input class="easyui-numberbox" precision="2" maxlength="10" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>瓶颈工序工期:</td>
	            <td>
	            	<input class="easyui-textbox" type="text" name="vitalProcessPeriod" />
	            </td>
	        </tr>
	        <tr>
	            <td>标准加工能力:</td>
	            <td>
	            	<input class="easyui-numberbox"  maxlength="11" name="standardCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>加班标准加工能力:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="overtimeStandardCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>加班超额教工能力:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="overtimeOverfulfilCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>二班工序能力:</td>
	            <td>
	            	<input class="easyui-numberbox" maxlength="11" name="doubleCapacity"/>
	            </td>
	        </tr>
	        <tr>
	            <td>超负荷工序能力:</td>
	            <td>
		            <input class="easyui-numberbox" maxlength="11" name="overfulfilCapacity"/>
				</td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitManuTechnologyEditForm()">提交</a>
	</div>
</div>

<script>
function doSearch_manufacture(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#manufactureList").datagrid({
	        title:'生产计划列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_manufacture", url:'manufacture/list', method:'get', loadMsg:'数据加载中......',
			fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'manufactureSn', width : 150, title : '生产批号', align:'center'},
				{field : 'cOrder', width : 100, align : 'center', title : '订单', formatter:formatManuOrder},
				{field : 'technology', width : 100, align : 'center', title : '工艺', formatter:formatManuTechnology},
				{field : 'launchQuantity', width : 100, title : '投产数量', align:'center'},
				{field : 'beginDate', width : 130, title : '开始日期', align:'center', formatter:TAOTAO.formatDateTime},
				{field : 'endDate', width : 130, title : '结束日期', align:'center', formatter:TAOTAO.formatDateTime},
	        ] ],  
	    });
	}else{
		$("#manufactureList").datagrid({  
	        title:'生产计划列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_manufacture", url:'manufacture/search_manufacture_by_'
			+name+'?searchValue='+value, loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'manufactureSn', width : 150, title : '生产批号', align:'center'},
				{field : 'cOrder', width : 100, align : 'center', title : '订单', formatter:formatManuOrder},
				{field : 'technology', width : 100, align : 'center', title : '工艺', formatter:formatManuTechnology},
				{field : 'launchQuantity', width : 100, title : '投产数量', align:'center'},
				{field : 'beginDate', width : 130, title : '开始日期', align:'center', formatter:TAOTAO.formatDateTime},
				{field : 'endDate', width : 130, title : '结束日期', align:'center', formatter:TAOTAO.formatDateTime},
	        ] ],  
	    });
	}
}

	var manuOrderEditor;
	
	//根据index拿到该行值
	function onManufactureClickRow(index) {
		var rows = $('#manufactureList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化订单信息
	function formatManuOrder(value, row, index){ 
		if(row.cOrder.orderId !=null && row.cOrder.orderId != ''){
			return "<a href=javascript:openManuOrder("+index+")>"+row.cOrder.orderId+"</a>";
		}else{
			return "无";
		}
	};  
	
	function  openManuOrder(index){ 
		var row = onManufactureClickRow(index);
		$("#manuOrderInfo").dialog({
    		onOpen :function(){
    			$.get("order/get/"+row.cOrder.orderId,'',function(data){
    				manuOrderEditor = TAOTAO.createEditor("#manuOrderEditForm [name=note]");	
 		    		//回显数据
 	        		data.customId = data.custom.customId; 
 	        		data.productId = data.product.productId; 
 	        		data.orderDate = TAOTAO.formatDateTime(data.orderDate);
 	        		data.requestDate = TAOTAO.formatDateTime(data.requestDate);
 	        		$("#manuOrderEditForm").form("load", data);
 	        		manuOrderEditor.html(data.note);
 	        			
 	        		//加载图片
 	        		initManuPic({
           				"pics" : data.image,
           			});
 	        		//加载上传过的文件
 	        		initManuUploadedFile();
    	    	});
    			
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#manuOrderEditForm [name=note]");
			   	clearManuSpan();
			}
    	}).dialog("open");
	};
	
	// 加载图片
    function initManuPic(data){
    	$(".manuPic").each(function(i,e){
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
        				_ele.siblings(".pics").find("ul").append("<li><a id='img"+i+"' href='"+imgs[i]+"' " +
								"target='_blank'>" + "<img src='"+imgs[i]+"' width='80' height='50' /></a> ");
        				j = true;
        			}
        		}
        	}
        	if(!j){
    			$("#manuPicSpan").html("<span style='font-size: 12px;font-family: Microsoft YaHei;'>无</span>");
    		}
    	});
    }
    
	//加载上传过的文件
	function initManuUploadedFile(){
		var files = $('#manuFile').val().split(","); 
		var k = false;
		for(var i in files){
			if(files[i] !=null && files[i] != ''){
				$("#manuFileSpan").append("<tr><td><a href='file/download?fileName="+files[i]+"'>" +
						"<span style='font-size: 16px;font-family: Microsoft YaHei;'>"
						+ files[i].substring(files[i].lastIndexOf("/")+1) + "</span></td><td></a> ");
				k = true;
			}
		}
		if(!k){
			$("#manuFileSpan").html("<span style='font-size: 12px;font-family: Microsoft YaHei;'>无</span>");
		}
	}
	
	function clearManuSpan(){
		$("#manuPicSpan").html('');
		$("#manuFileSpan").html('');
	}
	
	function submitManuOrderEditForm(){
		$.get("order/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#manuOrderEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			manuOrderEditor.sync();
    			$.post("order/update_all",$("#manuOrderEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改订单成功!','info',function(){
    						$("#manuOrderInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	//格式化工艺信息
	function formatManuTechnology(value, row, index){ 
		return "<a href=javascript:ManuTechnology("+index+")>"+row.technology.technologyName+"</a>";
	};  
	
	function  ManuTechnology(index){ 
		var row = onManufactureClickRow(index);
			$("#manuTechnologyInfo").dialog({
	    		onOpen :function(){
	    			$.get("technology/get/"+row.technology.technologyId,'',function(data){
	 		    		//回显数据
	 	        		$("#manuTechnologyEditForm").form("load", data);
	    	    	});
	    			
	    		},
	    	}).dialog("open");
	};
	
	function submitManuTechnologyEditForm(){
		$.get("technology/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#manuTechnologyEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			
    			$.post("technology/update_all",$("#manuTechnologyEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改工艺成功!','info',function(){
    						$("#manuTechnologyInfo").dialog('close');
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
		
	}
	
    function getManufactureSelectionsIds(){
    	var manufactureList = $("#manufactureList");
    	var sels = manufactureList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].manufactureSn);
    	}
    	ids = ids.join(","); 
    	
    	return ids;
    }
    
    function manufacture_add(){
    	$.get("manufacture/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#manufactureAddWindow").window("open");
       		}
       	});
    }
    
    function manufacture_edit(){
    	$.get("manufacture/edit_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			var ids = getManufactureSelectionsIds();
	        	
	        	if(ids.length == 0){
	        		$.messager.alert('提示','必须选择一个生产计划才能编辑!');
	        		return ;
	        	}
	        	if(ids.indexOf(',') > 0){
	        		$.messager.alert('提示','只能选择一个生产计划!');
	        		return ;
	        	}
	        	
	        	$("#manufactureEditWindow").window({
	        		onLoad :function(){
	        			//回显数据
	        			var data = $("#manufactureList").datagrid("getSelections")[0];
	        			data.orderId = data.cOrder.orderId; 
	        			data.technologyId = data.technology.technologyId; 
	        			data.beginDate = TAOTAO.formatDateTime(data.beginDate);
               			data.endDate = TAOTAO.formatDateTime(data.endDate);
	        			$("#manufactureEditForm").form("load", data);
	        		}
	        	}).window("open");
       		}
       	});
    }
    
    function manufacture_delete(){
    	$.get("manufacture/delete_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{
      			var ids = getManufactureSelectionsIds();
	        	if(ids.length == 0){
	        		$.messager.alert('提示','未选中生产计划!');
	        		return ;
	        	}
	        	$.messager.confirm('确认','确定删除生产批号为 '+ids+' 的生产计划吗？',function(r){
	        	    if (r){
	        	    	var params = {"ids":ids};
	                	$.post("manufacture/delete_batch",params, function(data){
	            			if(data.status == 200){
	            				$.messager.alert('提示','删除生产计划成功!',undefined,function(){
	            					$("#manufactureList").datagrid("reload");
	            				});
	            			}
	            		});
	        	    }
	        	});
      		}
      	});
    }
    
    function manufacture_reload(){
    	$("#manufactureList").datagrid("reload");
    }
    
</script>