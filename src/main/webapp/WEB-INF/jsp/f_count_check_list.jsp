<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>

<table  id="fCountCheckList" title="成品计数质检" class="easyui-datagrid"
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'f_count_check/list',
       	method:'get',fitColumns:true,pageSize:10,toolbar:toolbar_fCountCheck">
    <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'fCountCheckId',align:'center',width:100">成品计数质检编号</th>
            <th data-options="field:'orderId',align:'center',width:100,formatter:formatOrder">订单编号</th>
            <th data-options="field:'checkItem',align:'center',width:100">检验项目</th>
            <th data-options="field:'sample',align:'center',width:100">样本总数</th>
            <th data-options="field:'checkNumber',align:'center',width:100">抽检数</th>
            <th data-options="field:'unqualify',align:'center',width:100">不合格数</th>
            <th data-options="field:'qualify',align:'center',width:100">合格率</th>
            <th data-options="field:'cdate',align:'center',width:130,formatter:TAOTAO.formatDateTime">检验时间</th>
            <th data-options="field:'measureData',align:'center',width:100">实际测量数据</th>
            <th data-options="field:'empName',align:'center',width:100,formatter:formatEmp_fCount">检验人</th>
            <th data-options="field:'result',align:'center',width:100">检验结果</th>
            <th data-options="field:'note',align:'center',width:100,formatter:formatFCountCheckNote">备注</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_fCountCheck" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='fCountCheck:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="fCountCheck_add()">新增</a>  
		    </div>  
		</c:if>
		<c:if test="${per=='fCountCheck:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="fCountCheck_edit()">
					编辑
				</a>
		    </div>  
		</c:if>
		<c:if test="${per=='fCountCheck:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel" onclick="fCountCheck_delete()">
					删除
				</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload" onclick="fCountCheck_reload()">刷新</a>  
	</div>  
	
    <div id="search_fCountCheck" style="float: right;">
        <input id="search_text_fCountCheck" class="easyui-searchbox"  
            data-options="searcher:doSearch_fCountCheck,prompt:'请输入...',menu:'#menu_fCountCheck'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_fCountCheck" style="width:120px"> 
			<div data-options="name:'fCountCheckId'">成品计数质检编号</div> 
			<div data-options="name:'orderId'">订单编号</div>
		</div>     
    </div>  

</div>  
<!-- 111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111 -->

<div id="fCountCheckEditWindow" class="easyui-window" title="编辑成品计数质检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'f_count_check/edit'" style="width:65%;height:80%;padding:10px;">
</div>
<div id="fCountCheckAddWindow" class="easyui-window" title="添加成品计数质检" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save',href:'f_count_check/add'" style="width:65%;height:80%;padding:10px;">
</div>
<!-- ********************************************************************* -->
<div id="fCountOrderInfo" class="easyui-dialog" title="订单信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:65%;height:80%;padding:10px;">
	<form id="fCountOrderEditForm" method="post">
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
						   data-options="min:1,max:99999999,precision:2,required:true" />
	            	<input type="hidden" name="price"/>
	            </td>
	        </tr>
	        <tr>
	            <td>单位:</td>
	            <td><input  class="easyui-textbox" type="text" name="unit"/></td>
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
	            <td>
					<input class="easyui-datetimebox" name="orderDate"
        			data-options="required:true,showSeconds:true" value="5/5/2016 00:00:00" style="width:150px">
				</td>
	        </tr>
	        <tr>
	            <td>要求日期:</td>
	            <td>
					<input class="easyui-datetimebox" name="requestDate"
        			data-options="required:true,showSeconds:true" value="5/5/2016 00:00:00" style="width:150px">
				</td>
	        </tr>
	        <tr>
	            <td>合同扫描件:</td>
	            <td>
	            	 <div style="padding-top: 12px"><span id="fCountCheckPicSpan"></span></div>
	                 <input type="hidden" class="easyui-linkbutton fCountCheckPic" name="image"/>
	            </td>
	        </tr>
	        <tr>
	            <td>附件:</td>
	            <td>
	            	 <div id="fileuploader"><span id="fCountCheckFileSpan"></span></div>
	                 <input id="fCountCheckFile" type="hidden" name="file"/>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitfCountOrderEditForm()">提交</a>
	</div>
</div>


<!-- 检验人信息 -->
<div id="empInfo_fCount" class="easyui-dialog" title="检验人信息" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:33%;height:65%;padding:10px;">
	<form id="empEditForm_fCount" method="post">
		<input type="hidden" name="empId"/>
	    <table cellpadding="5">
	        <tr>
	           	<td>姓名:</td>
	           	<td><input class="easyui-textbox" name="empName" data-options="editable:false"/></td>
	        </tr>
	        <tr>
	            <td>性别:</td>
	            <td>
	            	<select id="sexCombobox" class="easyui-combobox" name="sex" panelHeight="auto"
							data-options="editable:false" style="width:173px">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</td>
	        </tr>
	        <tr>
	            <td>所属部门:</td>
	            <td>
	            	<input class="easyui-combobox" name="departmentId" panelHeight="auto"
    					data-options="valueField:'departmentId',textField:'departmentName',url:'department/get_data'" />
    			</td> 
	        </tr>
	        <tr>
	            <td>身份证号:</td>
	            <td><input class="easyui-textbox" name="idCode"/></td>
	        </tr>
	        <tr>
	            <td>学历:</td>
	            <td><input class="easyui-textbox" name="education"/></td>
	        </tr>
	        <tr>
	            <td>学位:</td>
	            <td><input class="easyui-textbox" name="degree"/></td>
	        </tr>
	        <tr>
	            <td>专业:</td>
	            <td><input class="easyui-textbox" name="major"/></td>
	        </tr>
	        <tr>
	            <td>受教育形式:</td>
	            <td><input class="easyui-textbox" name="educationForm"/></td>
	        </tr>
	        <tr>
	            <td>生日:</td>
	            <td><input class="easyui-datetimebox" name="birthday"/></td>
	        </tr>
	        <tr>
	            <td>入职日期:</td>
	            <td><input class="easyui-datetimebox" name="joinDate"/></td>
	        </tr>
	        <tr>
	            <td>员工状态:</td>
	            <td><input class="easyui-textbox" name="status"/></td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitEmpEditForm_fCount()">提交</a>
	</div>
</div>

<!-- ********************************************************************* -->

<div id="fCountCheckNoteDialog" class="easyui-dialog" title="备注" data-options="modal:true,closed:true,resizable:true,
	iconCls:'icon-save'" style="width:55%;height:65%;padding:10px">
	<form id="fCountCheckNoteForm" method="post">
		<input type="hidden" name="fCountCheckId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>备注:</td>
	            <td>
	                <textarea style="width:800px;height:450px;visibility:hidden;" name="note"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateFCountCheckNote()">保存</a>
	</div>
</div>
<script>
function doSearch_fCountCheck(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		$("#fCountCheckList").datagrid({
	        title:'成品计数质检', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_fCountCheck", url:'f_count_check/list', method:'get',
			loadMsg:'数据加载中......',  fitColumns:true,
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'fCountCheckId', width : 100, title : '成品计数质检编号', align:'center'},
				{field : 'orderId', width : 100, align : 'center', title : '订单编号',formatter:formatOrder},
				{field : 'checkItem', width : 100, align : 'center', title : '检验项目'},
				{field : 'sample', width : 100, title : '样本总数', align:'center'},
				{field : 'checkNumber', width : 100, title : '抽检数', align:'center'},
				{field : 'unqualify', width : 100, title : '不合格数', align:'center'},
				{field : 'qualify', width : 100, title : '合格率', align:'center'},
				{field : 'cdate', width : 130, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime},
				{field : 'measureData', width : 100, title : '实际测量数据', align:'center'},
				{field : 'empName', width : 100, title : '检验人', align:'center',formatter:formatEmp_fCount},
				{field : 'result', width : 100, title : '检验结果', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatFCountCheckNote}
	        ] ],  
	    });
	}else{
		$("#fCountCheckList").datagrid({  
	        title:'成品计数质检', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_fCountCheck", url:'f_count_check/search_fCountCheck_by_'
			+name+'?searchValue='+value, loadMsg:'数据加载中......',  fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'fCountCheckId', width : 100, title : '成品计数质检编号', align:'center'},
				{field : 'orderId', width : 100, align : 'center', title : '订单编号',formatter:formatOrder},
				{field : 'checkItem', width : 100, align : 'center', title : '检验项目'},
				{field : 'sample', width : 100, title : '样本总数', align:'center'},
				{field : 'checkNumber', width : 100, title : '抽检数', align:'center'},
				{field : 'unqualify', width : 100, title : '不合格数', align:'center'},
				{field : 'qualify', width : 100, title : '合格率', align:'center'},
				{field : 'cdate', width : 130, title : '检验时间', align:'center',formatter:TAOTAO.formatDateTime} ,
				{field : 'measureData', width : 100, title : '实际测量数据', align:'center'},
				{field : 'empName', width : 100, title : '检验人', align:'center',formatter:formatEmp_fCount},
				{field : 'result', width : 100, title : '检验结果', align:'center'},
				{field : 'note', width : 100, title : '备注', align:'center', formatter:formatFCountCheckNote}
	        ] ],  
	    });
	}
}

	var fCountNoteEditor ;
	
	var fCountCheckOrderEditor;
	
	//格式化订单信息
	function formatOrder(value, row, index){
		if(value !=null && value != ''){
			return "<a href=javascript:openFCountOrder("+index+")>"+value+"</a>";
		}else{
			return "无";
		}
	};  

	//根据index拿到该行值
	function onFCountClickRow(index) {
		var rows = $('#fCountCheckList').datagrid('getRows');
		return rows[index];
		
	}
	
	//8989898989898989898989898989898989898989898989898989898989898989898989898989898989
	function  openFCountOrder(index){ 
		var row = onFCountClickRow(index);
		$("#fCountOrderInfo").dialog({
    		onOpen :function(){
    			$.get("order/get/"+row.orderId,'',function(data){
    				fCountCheckOrderEditor = TAOTAO.createEditor("#fCountOrderEditForm [name=note]");	
 		    		//回显数据
 	        		data.customId = data.custom.customId; 
 	        		data.productId = data.product.productId; 
 	        		data.orderDate = TAOTAO.formatDateTime(data.orderDate);
 	        		data.requestDate = TAOTAO.formatDateTime(data.requestDate);
 	        		$("#fCountOrderEditForm").form("load", data);
 	        		fCountCheckOrderEditor.html(data.note);
 	        			
 	        		initFCountCheckPic({
 	        			"pics" : data.image,
 	        		});
 	        			
 	        		//加载上传过的文件
 	        		initFCountCheckUploadedFile();
    	    	});
    			
    		},
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#fCountOrderEditForm [name=note]");
			   	$("#fCountCheckFileSpan").html('');
			   	$("#fCountCheckPicSpan").html('');
			}
    	}).dialog("open");
	};
	
	// 加载图片
    function initFCountCheckPic(data){
    	$(".fCountCheckPic").each(function(i,e){
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
    			$("#fCountCheckPicSpan").html("<span style='font-size: 12px;font-family: Microsoft YaHei;'>无</span>");
    		}
    	});
    }
	
	//加载上传过的文件
	function initFCountCheckUploadedFile(){
		var files = $('#fCountCheckFile').val().split(","); 
		var k = false;
		for(var i in files){
			if(files[i] !=null && files[i] != ''){
				$("#fCountCheckFileSpan").append("<tr><td><a href='file/download?fileName="+files[i]+"'>" +
						"<span style='font-size: 12px;font-family: Microsoft YaHei;'>"
						+ files[i].substring(files[i].lastIndexOf("/")+1) + "</span></td><td></a> ");
				k = true;
			}
		}
		if(!k){
			$("#fCountCheckFileSpan").html("<span style='font-size: 16px;font-family: Microsoft YaHei;'>无</span>");
		}
	}
	
	function submitfCountOrderEditForm(){
		$.get("order/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			if(!$('#fCountOrderEditForm').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			fCountCheckOrderEditor.sync();
    			
    			$.post("order/update_all",$("#fCountOrderEditForm").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改订单信息成功!','info',function(){
    						$("#fCountOrderInfo").dialog("close");
    					});
    				}else{
    					$.messager.alert('提示', data.msg);
    				}
    			});
    		}
    	});
	}
	
	//格式化检验人信息
	function formatEmp_fCount(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openEmp_fCount("+index+")>"+value+"</a>";
		}else{
			return "无";
		}
	};
	
	//打开检验人信息对话框
	function  openEmp_fCount(index){ 
		var row = onFCountClickRow(index);
		$("#empInfo_fCount").dialog({
    		onOpen :function(){
    			$.get("employee/get/"+row.empId,'',function(data){
		    		//回显数据
					data.birthday = TAOTAO.formatDateTime(data.birthday);
					data.joinDate = TAOTAO.formatDateTime(data.joinDate);
					data.departmentId=data.department.departmentId;
					data.departmentName=data.department.departmentName;
		    		$("#empInfo_fCount").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交检验人信息
	function submitEmpEditForm_fCount(){
		$.get("employee/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#empEditForm_fCount').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}
    			$.post("employee/update_all",$("#empEditForm_fCount").serialize(), function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改检验人信息成功!','info',function(){
    						$("#empInfo_fCount").dialog("close");
    					});
    				}else{
    					$.messager.alert('错误', data.msg);
    				}
    			});
    		}
    	});
	}
	
	//格式化备注
	function formatFCountCheckNote(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openFCountNote("+index+")>"+"备注"+"</a>";
		}else{
			return "无";
		}
	}
	
	//打开备注对话框
	function  openFCountNote(index){ 
		var row = onFCountClickRow(index);
		$("#fCountCheckNoteDialog").dialog({
    		onOpen :function(){
    			$("#fCountCheckNoteForm [name=fCountCheckId]").val(row.fCountCheckId);
    			fCountNoteEditor = TAOTAO.createEditor("#fCountCheckNoteForm [name=note]");
    			fCountNoteEditor.html(row.note);
    		},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#fCountCheckNoteForm [name=note]");
			}
    	}).dialog("open");
	}
	
	//更新备注
	function updateFCountCheckNote(){
		$.get("fCountCheck/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{
    			fCountNoteEditor.sync();
    			$.post("f_count_check/update_note",$("#fCountCheckNoteForm").serialize(), function(data){
    				if(data.status == 200){
    					$("#fCountCheckNoteDialog").dialog("close");
    					$("#fCountCheckList").datagrid("reload");
    					$.messager.alert("操作提示", "更新备注成功！");
    				}else{
    					$.messager.alert("操作提示", "更新备注失败！");
    				}
    			});
    		}
    	});
	}
	
	function getFCountSelectionsIds(){
    	var sels = $("#fCountCheckList").datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].fCountCheckId);
    	}
    	ids = ids.join(","); 
    	return ids;
    }
    
//////////////////////////////////////////////////////////////////////////

function fCountCheck_add(){
	$.get("fCountCheck/add_judge",'',function(data){
   		if(data.msg != null){
   			$.messager.alert('提示', data.msg);
   		}else{
   			$("#fCountCheckAddWindow").window("open");
   		}
   	});
}

function fCountCheck_edit(){
	$.get("fCountCheck/edit_judge",'',function(data){
   		if(data.msg != null){
   			$.messager.alert('提示', data.msg);
   		}else{
   			var ids = getFCountSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个成品计数质检才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个成品计数质检!');
        		return ;
        	}
        	
        	$("#fCountCheckEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#fCountCheckList").datagrid("getSelections")[0];
        			data.cdate = TAOTAO.formatDateTime(data.cdate);
        			$("#fCountCheckEditForm").form("load", data);
        			fCountCheckEditEditor.html(data.note);
        			
        		}
        	}).window("open");
   		}
   	});
}

function fCountCheck_delete(){
	$.get("fCountCheck/delete_judge",'',function(data){
   		if(data.msg != null){
   			$.messager.alert('提示', data.msg);
   		}else{
   			var ids = getFCountSelectionsIds();
           	if(ids.length == 0){
           		$.messager.alert('提示','未选中成品计数质检!');
           		return ;
           	}
           	$.messager.confirm('确认','确定删除ID为 '+ids+' 的成品计数质检吗？',function(r){
           	    if (r){
           	    	var params = {"ids":ids};
                   	$.post("f_count_check/delete_batch",params, function(data){
               			if(data.status == 200){
               				$.messager.alert('提示','删除成品计数质检成功!',undefined,function(){
               					$("#fCountCheckList").datagrid("reload");
               				});
               			}
               		});
           	    }
           	});
   		}
   	});
}

function fCountCheck_reload(){
	$("#fCountCheckList").datagrid("reload");
}
</script>
