<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<table class="easyui-datagrid" id="technologyRequirementList" title="工艺要求列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,rownumbers:true,url:'technologyRequirement/list',method:'get',pageSize:30,fitColumns:true,toolbar:toolbar_technologyRequirement">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'technologyRequirementId',width:100,align:'center'">
				工艺要求编号
			</th>
            <th data-options="field:'technologyName',width:120,align:'center',
            		formatter:formatTechnology_technologyRequirement">
				工艺名称
			</th>
            <th data-options="field:'requirement',width:100,align:'center',formatter:formatRequirement">
				工艺要求
			</th>
            <th data-options="field:'addTime',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				工艺要求添加时间
			</th>
            <th data-options="field:'reviseTime',width:130,align:'center',formatter:TAOTAO.formatDateTime">
				工艺要求修改时间
			</th>
        </tr>
    </thead>
</table>

<div  id="toolbar_technologyRequirement" style=" height: 22px; padding: 3px 11px; background: #fafafa;">  
	
	<c:forEach items="${sessionScope.sysPermissionList}" var="per" >
		<c:if test="${per=='technologyRequirement:add' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-add"
				   onclick="technologyRequirement_add()">新增</a>
		    </div>  
		</c:if>
		<c:if test="${per=='technologyRequirement:edit' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit"
				   onclick="technologyRequirement_edit()">编辑</a>
		    </div>  
		</c:if>
		<c:if test="${per=='technologyRequirement:delete' }" >
		    <div style="float: left;">  
		        <a href="#" class="easyui-linkbutton" plain="true" icon="icon-cancel"
				   onclick="technologyRequirement_delete()">删除</a>
		    </div>  
		</c:if>
	</c:forEach>
	
	<div class="datagrid-btn-separator"></div>  
	
	<div style="float: left;">  
		<a href="#" class="easyui-linkbutton" plain="true" icon="icon-reload"
		   onclick="technologyRequirement_reload()">刷新</a>
	</div>  
	
    <div id="search_technologyRequirement" style="float: right;">
        <input id="search_text_technologyRequirement" class="easyui-searchbox"  
            data-options="searcher:doSearch_technologyRequirement,prompt:'请输入...',menu:'#menu_technologyRequirement'"  
            style="width:250px;vertical-align: middle;">
        </input>
        <div id="menu_technologyRequirement" style="width:120px"> 
			<div data-options="name:'technologyRequirementId'">工艺要求编号</div> 
			<div data-options="name:'technologyName'">工艺名称</div>
		</div>     
    </div>  

</div> 

<div id="technologyRequirementEditWindow" class="easyui-window" title="编辑工艺要求"
	 data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'technologyRequirement/edit'"
	 style="width:65%;height:65%;padding:10px;">
</div>
<div id="technologyRequirementAddWindow" class="easyui-window" title="添加工艺要求"
	 data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save',href:'technologyRequirement/add'"
	 style="width:65%;height:65%;padding:10px;">
</div>

<!-- 工艺信息 -->
<div id="technologyInfo_technologyRequirement" class="easyui-dialog" title="工艺信息"
	 data-options="modal:true,closed:true,resizable:true,iconCls:'icon-save'"
	 style="width:40%;height:55%;padding:10px;">
	<form id="technologyEditForm_technologyRequirement" method="post">
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
					<input class="easyui-textbox" type="text" name="vitalProcessPeriod"/>
				</td>
	        </tr>
	        <tr>
	            <td>标准加工能力:</td>
	            <td>
					<input class="easyui-numberbox" maxlength="11" name="standardCapacity"/>
				</td>
	        </tr>
	        <tr>
	            <td>加班标准加工能力:</td>
	            <td>
					<input class="easyui-numberbox" maxlength="11" name="overtimeStandardCapacity"/>
				</td>
	        </tr>
	        <tr>
	            <td>加班超额加工能力:</td>
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
	    <a href="javascript:void(0)" class="easyui-linkbutton"
		   onclick="submitTechnologyEditForm_technologyRequirement()">提交</a>
	</div>
</div>
 
<div id="technologyRequirementNoteDialog" class="easyui-dialog" title="工艺要求" data-options="modal:true,closed:true,
	resizable:true,iconCls:'icon-save'" style="width:55%;height:65%;padding:10px;">
	<form id="technologyRequirementNoteForm" class="itemForm" method="post">
		<input type="hidden" name="technologyRequirementId"/>
	    <table cellpadding="5" >
	        <tr>
	            <td>工艺要求:</td>
	            <td>
	                <textarea style="width:800px;height:400px;visibility:hidden;" name="requirement"></textarea>
	            </td>
	        </tr>
	    </table>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateTechnologyRequirementNote()">保存</a>
	</div>
</div>

 
<script>
function doSearch_technologyRequirement(value,name){ //用户输入用户名,点击搜素,触发此函数  
	if(value == null || value == ''){
		
		$("#technologyRequirementList").datagrid({
	        title:'工艺要求列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_technologyRequirement", url:'technologyRequirement/list', method:'get',
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [
				{field : 'ck', checkbox:true },
				{field : 'technologyRequirementId', width : 100, align:'center', title : '工艺要求编号'},
				{field : 'technologyName', width : 120, align : 'center', title : '工艺名称',
					formatter:formatTechnology_technologyRequirement},
				{field : 'requirement', width : 100, align : 'center', title : '工艺要求',
					formatter:formatRequirement},
				{field : 'addTime', width : 130, title : '工艺要求增加时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'reviseTime', width : 130, title : '工艺要求修改时间', align:'center',
					formatter:TAOTAO.formatDateTime}
	        ] ],  
	    });
	}else{
		$("#technologyRequirementList").datagrid({  
	        title:'工艺要求列表', singleSelect:false, collapsible:true, pagination:true, rownumbers:true, method:'get',
			nowrap:true, toolbar:"toolbar_technologyRequirement",
			url:'technologyRequirement/search_technologyRequirement_by_'+name+'?searchValue='+value,
			loadMsg:'数据加载中......', fitColumns:true,//允许表格自动缩放,以适应父容器
	        columns : [ [ 
				{field : 'ck', checkbox:true },
				{field : 'technologyRequirementId', width : 100, align:'center', title : '工艺要求编号'},
				{field : 'technologyName', width : 120, align : 'center', title : '工艺名称',
					formatter:formatTechnology_technologyRequirement},
				{field : 'requirement', width : 100, align : 'center', title : '工艺要求',
					formatter:formatRequirement},
				{field : 'addTime', width : 130, title : '工艺要求增加时间', align:'center',
					formatter:TAOTAO.formatDateTime},
				{field : 'reviseTime', width : 130, title : '工艺要求修改时间', align:'center',
					formatter:TAOTAO.formatDateTime}
	        ] ],  
	    });
	}
}

	var technologyRequirementNoteEditor ;
	
	//根据index拿到该行值
	function onTechnologyRequirementClickRow(index) {
		var rows = $('#technologyRequirementList').datagrid('getRows');
		return rows[index];
		
	}
	
	//格式化工艺信息
	function formatTechnology_technologyRequirement(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openTechnology_technologyRequirement("+index+")>"+row.technologyName+"</a>";
		}else{
			return "无";
		}
	};  
	
	//格式化工艺要求
	function formatRequirement(value, row, index){ 
		if(value !=null && value != ''){
			return "<a href=javascript:openTechnologyRequirementNote("+index+")>"+"工艺要求"+"</a>";
		}else{
			return "无";
		}
	}
	
	//打开工艺信息对话框
	function  openTechnology_technologyRequirement(index){ 
		var row = onTechnologyRequirementClickRow(index);
		$("#technologyInfo_technologyRequirement").dialog({
    		onOpen :function(){
    			$.get("technology/get/"+row.technologyId,'',function(data){
		    		//回显数据
		    		$("#technologyEditForm_technologyRequirement").form("load", data);
    	    	});
    		}
    	}).dialog("open");
	};
	
	//提交工艺信息
	function submitTechnologyEditForm_technologyRequirement(){
		$.get("technology/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			if(!$('#technologyEditForm_technologyRequirement').form('validate')){
    				$.messager.alert('提示','表单还未填写完成!');
    				return ;
    			}

    			$.post("technology/update_all",$("#technologyEditForm_technologyRequirement").serialize(),
						function(data){
    				if(data.status == 200){
    					$.messager.alert('提示','修改工艺成功!','info',function(){
    						$("#technologyInfo_technologyRequirement").dialog("close");
    					});
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	function  openTechnologyRequirementNote(index){ 
		
		var row = onTechnologyRequirementClickRow(index);
	console.log(row);
		$("#technologyRequirementNoteDialog").dialog({
			onOpen :function(){
				$("#technologyRequirementNoteForm [name=technologyRequirementId]").val(row.technologyRequirementId);
				technologyRequirementNoteEditor =
						TAOTAO.createEditor("#technologyRequirementNoteForm [name=requirement]");
				technologyRequirementNoteEditor.html(row.requirement);
				
			},
		
			onBeforeClose: function (event, ui) {
				// 关闭Dialog前移除编辑器
			   	KindEditor.remove("#technologyRequirementNoteForm [name=requirement]");
			}
		}).dialog("open");
	};
	
	function updateTechnologyRequirementNote(){
		$.get("technologyRequirement/edit_judge",'',function(data){
    		if(data.msg != null){
    			$.messager.alert('提示', data.msg);
    		}else{ 
    			technologyRequirementNoteEditor.sync();
    			$.post("technologyRequirement/update_requirement",$("#technologyRequirementNoteForm").serialize(),
						function(data){
    				if(data.status == 200){
    					$("#technologyRequirementNoteDialog").dialog("close");
    					$("#technologyRequirementList").datagrid("reload");
    					$.messager.alert("操作提示", "更新工艺要求成功！");
    				}else{
    					$.messager.alert('提示',data.msg);
    				}
    			});
    		}
    	});
	}
	
	function getTechnologyRequirementSelectionsIds(){
		var technologyRequirementList = $("#technologyRequirementList");
		var sels = technologyRequirementList.datagrid("getSelections");
		var ids = [];
		for(var i in sels){
			ids.push(sels[i].technologyRequirementId);
		}
		ids = ids.join(","); 
		
		return ids;
	}
	
	function technologyRequirement_add(){
    	$.get("technologyRequirement/add_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{
       			$("#technologyRequirementAddWindow").window("open");
       		}
       	});
    }
    
    function technologyRequirement_edit(){
    	$.get("technologyRequirement/edit_judge",'',function(data){
      		if(data.msg != null){
      			$.messager.alert('提示', data.msg);
      		}else{ 
      			var ids = getTechnologyRequirementSelectionsIds();
      	    	
      	    	if(ids.length == 0){
      	    		$.messager.alert('提示','必须选择一个工艺要求才能编辑!');
      	    		return ;
      	    	}
      	    	if(ids.indexOf(',') > 0){
      	    		$.messager.alert('提示','只能选择一个工艺要求!');
      	    		return ;
      	    	}
      	    	
      	    	$("#technologyRequirementEditWindow").window({
      	    		onLoad :function(){
      	    			//回显数据
              			var data = $("#technologyRequirementList").datagrid("getSelections")[0];
              			data.addTime = TAOTAO.formatDateTime(data.addTime);
              			data.reviseTime = TAOTAO.formatDateTime(data.reviseTime);
              			$("#technologyRequirementEditForm").form("load", data);
              			requirementEditEditor.html(data.requirement);
      	    		}
      	    	}).window("open");
      		}
      	});
    }
    
    function technologyRequirement_delete(){
    	$.get("technologyRequirement/delete_judge",'',function(data){
       		if(data.msg != null){
       			$.messager.alert('提示', data.msg);
       		}else{ 
       			var ids = getTechnologyRequirementSelectionsIds();
       	    	if(ids.length == 0){
       	    		$.messager.alert('提示','未选中工艺要求!');
       	    		return ;
       	    	}
       	    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的工艺要求吗？',function(r){
       	    	    if (r){
       	    	    	var params = {"ids":ids};
       	            	$.post("technologyRequirement/delete_batch",params, function(data){
       	        			if(data.status == 200){
       	        				$.messager.alert('提示','删除工艺要求成功!',undefined,function(){
       	        					$("#technologyRequirementList").datagrid("reload");
       	        				});
       	        			}
       	        		});
       	    	    }
       	    	});
       		}
       	});
    }
    
    function technologyRequirement_reload(){
    	$("#technologyRequirementList").datagrid("reload");
    }
</script>