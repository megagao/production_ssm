Date.prototype.format = function(format){ 
    var o =  { 
    "M+" : this.getMonth()+1, //month 
    "d+" : this.getDate(), //day 
    "h+" : this.getHours(), //hour 
    "m+" : this.getMinutes(), //minute 
    "s+" : this.getSeconds(), //second 
    "q+" : Math.floor((this.getMonth()+3)/3), //quarter 
    "S" : this.getMilliseconds() //millisecond 
    };
    if(/(y+)/.test(format)){ 
    	format = format.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    }
    for(var k in o)  { 
	    if(new RegExp("("+ k +")").test(format)){ 
	    	format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
	    } 
    } 
    return format; 
};

//全局ajax事件，处理session过期跳转登录
$.ajaxSetup({
	complete:function(XMLHttpRequest,sessionStatus){
		var sessionstatus = XMLHttpRequest.getResponseHeader("session-status");
		if(sessionstatus=="timeout"){
		     $.messager.alert('提示信息', "登录超时！请重新登录！", 'info',function(){
		         window.location.href = 'login';
		     });
		} 
    }
});

var TT = TAOTAO = {
	// 编辑器参数
	kingEditorParams : {
		//指定上传文件参数名称
		filePostName  : "uploadFile",
		//指定上传文件请求的url。
		uploadJson : 'pic/upload',
		//上传类型，分别为image、flash、media、file
		dir : "image"
	},
	// 格式化日期
	formatDate : function(val,row){
		var now = new Date(val);
    	return now.format("yyyy-MM-dd");
	},
	// 格式化时间
	formatDateTime : function(val,row){
		var now = new Date(val);
    	return now.format("yyyy-MM-dd hh:mm:ss");
	},
	// 格式化性别
	formatSex : function(val,row){
		if (val == 1){
            return '男';
        }else if(val == 2){
        	return '女';
        }else {
        	return '<span style="color:#E5B717;">未知</span>';
        }
	},
	//格式化设备的状态
	formatDeviceStatus : function formatStatus(val,row){
        if (val == 1){
            return '良好';
        }else if(val == 2){
        	return '故障';
        } else if(val == 3){
        	return '维修';
        } else if(val == 4){
        	return '报废';
        }else {
        	return '<span style="color:#ff0000;">未知</span>'
        }
    },
    
	// 格式化连接
	formatUrl : function(val,row){
		if(val){
			return "<a href='"+val+"' target='_blank'>查看</a>";			
		}
		return "";
	},
	
	// 格式化价格
	formatPrice : function(val,row){
		return (val/1000).toFixed(2);
	},
	
	// 格式化订单的状态
	formatOrderStatus : function formatStatus(val,row){
        if (val == 1){
            return '未开始';
        }else if(val == 2){
        	return '<span style="font-weight:bold;">已开始</span>';
        } else if(val == 3){
        	return '<span style="color:green;">已完成</span>';
        } else if(val == 4){
        	return '<span style="color:red;">订单取消</span>';
        }else {
        	return '<span style="color:#E5B717;">未知状态</span>';
        }
    },
    // 格式化客户的状态
    formatCustomStatus : function formatStatus(val,row){
        if (val == 1){
            return '有效客户';
        }else if(val == 2){
        	return '<span style="color:red;">无效客户</span>';
        }else {
        	return '<span style="color:#E5B717;">未知状态</span>';
        }
    },
    // 格式化产品的状态
    formatProductStatus : function formatStatus(val,row){
        if (val == 1){
            return '有效产品';
        }else if(val == 2){
        	return '<span style="color:red;">停产</span>';
        }else {
        	return '<span style="color:#E5B717;">未知状态</span>';
        }
    },
    init : function(data){
    	// 初始化图片上传组件
    	this.initPicUpload(data);
    },
    // 初始化图片上传组件
    initPicUpload : function(data){
    	$(".picFileUpload").each(function(i,e){
    		var _ele = $(e);
    		_ele.siblings("div.pics").remove();
    		_ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
    		// 回显图片
        	if(data && data.pics){
        		var imgs = data.pics.split(",");
        		for(var i in imgs){
        			if($.trim(imgs[i]).length > 0){
        				_ele.siblings(".pics").find("ul").append("<li><a id='img"+i+"' href='"+imgs[i]+"' target='_blank'>" +
        						"<img src='"+imgs[i]+"' width='80' height='50' /></a> " +
        							"<a id='del"+i+"' href='javascript:removeImg("+i+");'>" +
        								"<span style='font-size: 16px;font-family: Microsoft YaHei;;margin-left: 16px'>" +
        								"删除</span></a></li>");
        			}
        		}
        	}
        	//给“上传图片按钮”绑定click事件.
        	$(e).click(function(){
        		var form = $(this).parentsUntil("form").parent("form");
        		//打开图片上传窗口
        		KindEditor.editor(TT.kingEditorParams).loadPlugin('multiimage',function(){
        			var editor = this;
        			editor.plugin.multiImageDialog({
						clickFn : function(urlList) {
							var imgArray = [];
							KindEditor.each(urlList, function(i, data) {
								imgArray.push(data.url);
								form.find(".pics ul").append("<li><a id='img"+i+"' href='"+data.url+"' target='_blank'>" +
										"<img src='"+data.url+"' width='80' height='50' /></a>" +
											"<a id='del"+i+"' href='javascript:removeImg("+i+");'>" +
												"<span style='font-size: 16px;font-family: Microsoft YaHei;;margin-left: 16px'>" +
												"删除</span></a></li>");
							});
							var origin = form.find("[name=image]").val();
							if(origin != null){
								var originUrls = origin.split(",");  
								for(var i in originUrls){
									imgArray.push(originUrls[i]);
								}
							}
							form.find("[name=image]").val(imgArray.join(","));
							editor.hideDialog();
						}
					});
        		});
        	});
    	});
    },
    
    // 初始化图片上传组件
    initProductPicUpload : function(data){
    	$(".productPicFileUpload").each(function(i,e){
    		var _ele = $(e);
    		_ele.siblings("div.pics").remove();
    		_ele.after('\
    			<div class="pics">\
        			<ul></ul>\
        		</div>');
    		// 回显图片
        	if(data && data.pics){
        		var imgs = data.pics.split(",");
        		for(var i in imgs){
        			if($.trim(imgs[i]).length > 0){
        				_ele.siblings(".pics").find("ul").append("<li><a id='productImg"+i+"' href='"+imgs[i]+"' target='_blank'>" +
        						"<img src='"+imgs[i]+"' width='80' height='50' /></a> " +
        							"<a id='productDel"+i+"' href='javascript:removeProductImg("+i+");'>" +
        								"<span style='font-size: 16px;font-family: Microsoft YaHei;;margin-left: 16px'>" +
        								"删除</span></a></li>");
        			}
        		}
        	}
        	//给“上传图片按钮”绑定click事件.
        	$(e).click(function(){
        		var form = $(this).parentsUntil("form").parent("form");
        		//打开图片上传窗口
        		KindEditor.editor(TT.kingEditorParams).loadPlugin('multiimage',function(){
        			var editor = this;
        			editor.plugin.multiImageDialog({
						clickFn : function(urlList) {
							var imgArray = [];
							KindEditor.each(urlList, function(i, data) {
								imgArray.push(data.url);
								form.find(".pics ul").append("<li><a id='productImg"+i+"' href='"+data.url+"' target='_blank'>" +
										"<img src='"+data.url+"' width='80' height='50' /></a>" +
											"<a id='productDel"+i+"' href='javascript:removeProductImg("+i+");'>" +
												"<span style='font-size: 16px;font-family: Microsoft YaHei;;margin-left: 16px'>" +
												"删除</span></a></li>");
							});
							var origin = form.find("[name=image]").val();
							if(origin != null){
								var originUrls = origin.split(",");  
								for(var i in originUrls){
									imgArray.push(originUrls[i]);
								}
							}
							form.find("[name=image]").val(imgArray.join(","));
							editor.hideDialog();
						}
					});
        		});
        	});
    	});
    },
    
    createEditor : function(select){
    	return KindEditor.create(select, TT.kingEditorParams);
    },
    
    /**
     * 创建一个窗口，关闭窗口后销毁该窗口对象。<br/>
     * 
     * 默认：<br/>
     * width : 80% <br/>
     * height : 80% <br/>
     * title : (空字符串) <br/>
     * 
     * 参数：<br/>
     * width : <br/>
     * height : <br/>
     * title : <br/>
     * url : 必填参数 <br/>
     * onLoad : function 加载完窗口内容后执行<br/>
     * 
     * 
     */
    createWindow : function(params){
    	$("<div>").css({padding:"5px"}).window({
    		width : params.width?params.width:"80%",
    		height : params.height?params.height:"80%",
    		modal:true,
    		title : params.title?params.title:" ",
    		href : params.url,
		    onClose : function(){
		    	$(this).window("destroy");
		    },
		    onLoad : function(){
		    	if(params.onLoad){
		    		params.onLoad.call(this);
		    	}
		    }
    	}).window("open");
    },
    
    closeCurrentWindow : function(){
    	$(".panel-tool-close").click();
    },
    
    getSelectionsIds : function (select){
    	var list = $(select);
    	var sels = list.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    },
    
    /**
     * 初始化单图片上传组件 <br/>
     * 选择器为：.onePicUpload <br/>
     * 上传完成后会设置input内容以及在input后面追加<img> 
     */
    initOnePicUpload : function(){
    	$(".onePicUpload").click(function(){
			var _self = $(this);
			KindEditor.editor(TT.kingEditorParams).loadPlugin('image', function() {
				this.plugin.imageDialog({
					showRemote : false,
					clickFn : function(url, title, width, height, border, align) {
						var input = _self.siblings("input");
						input.parent().find("img").remove();
						input.val(url);
						input.after("<a href='"+url+"' target='_blank'><img src='"+url+"' width='80' height='50'/></a>");
						this.hideDialog();
					}
				});
			});
		});
    },
    
};

//格式化图片
function formatImg(value, row, index){ 
	
	if(value !=null && value != ''){
		var urls = value.split(",");  
		var resultStr = '';
		for(var i in urls){
			if(urls[i] != null && urls[i] != ''){
				resultStr +="<a href="+urls[i]+" target='_blank'>"+"<img src="+urls[i]+" width='50px' height='50px' )/>"+"</a></br></br>";
			}
		}
		return resultStr;
	}else{
		return "无";
	}
}

//删除图片并删除图片在页面的显示
function removeImg(i){
	var picName = $('#img'+i).attr("href");
	//alert($('#image').val());
	$.ajax({
        cache: false,
        url: "pic/delete",
        dataType: "json",
        data: {picName:picName},
        success: function(data) 
        {
            if(data.data=="success"){
            	$('#img'+i).remove();		//删除成功后在页面上删除该图片的显示
            	$('#del'+i).remove();        
                var urls = $('#image').val().split(",");  //将删除的文件url从urls中移除
                var deletedUrls = [];
            	for(var k in urls){
            		if(urls[k] != picName){
            			deletedUrls.push(urls[k]);
            		}
            	}
            	deletedUrls = deletedUrls.join(",");
            	$('#image').val(deletedUrls);
             }else{
                console.log(data.message);  //打印服务器返回的错误信息
             }
          }
    }); 
}

//删除图片并删除图片在页面的显示
function removeProductImg(i){
	var picName = $('#productImg'+i).attr("href");
	//alert($('#image').val());
	$.ajax({
        cache: false,
        url: "pic/delete",
        dataType: "json",
        data: {picName:picName},
        success: function(data) 
        {
            if(data.data=="success"){
            	$('#productImg'+i).remove();		//删除成功后在页面上删除该图片的显示
            	$('#productDel'+i).remove();        
                var urls = $('#productImage').val().split(",");  //将删除的文件url从urls中移除
                var deletedUrls = [];
            	for(var k in urls){
            		if(urls[k] != picName){
            			deletedUrls.push(urls[k]);
            		}
            	}
            	deletedUrls = deletedUrls.join(",");
            	$('#productImage').val(deletedUrls);
             }else{
                console.log(data.message);  //打印服务器返回的错误信息
             }
          }
    }); 
}


//格式化文件在datagrid中的显示
function formatFile(value, row, index){ 
	if(value !=null && value != ''){
		var urls = value.split(",");  
		var resultStr ='';
		for(var i in urls){
			if(urls[i] !=null && urls[i] != ''){
			resultStr +="<a href='file/download?fileName="+urls[i]+"'>"+urls[i].substring(urls[i].lastIndexOf("/")+1)+"</a></br></br>";
			}
		}
		return resultStr;
	}else{
		return "无";
	}
}

//加载文件上传插件
function initOrderAddFileUpload(){
	$("#orderAddFileUploader").uploadFile({
		url:"file/upload",
		maxFileCount: 5,                //上传文件个数（多个时修改此处
	    returnType: 'json',              //服务返回数据
	    allowedTypes: 'doc,docx,excel,sql,txt,ppt,pdf',  //允许上传的文件式
	    showDone: false,                     //是否显示"Done"(完成)按钮
	    showDelete: true,                  //是否显示"Delete"(删除)按钮
	    deleteCallback: function(data,pd)
	    {
	        //文件删除时的回调方法。
	        //如：以下ajax方法为调用服务器端删除方法删除服务器端的文件
	        var fileUrl = data.url;
	        $.ajax({
	            cache: false,
	            url: "file/delete",
	            dataType: "json",
	            data: {fileName:data.url},
	            success: function(data) 
	            {
	                if(data.data=="success"){
	                    pd.statusbar.hide();        //删除成功后隐藏进度条等
	                    $('#image').val('');
	                    var urls = $('#orderAddForm [name=file]').val().split(",");  //将删除的文件url从urls中移除
	                    var deletedUrls = [];
	                	for(var i in urls){
	                		if(urls[i] != fileUrl){
	                			deletedUrls.push(urls[i]);
	                		}
	                	}
	                	deletedUrls = deletedUrls.join(",");
	                	$('#orderAddForm [name=file]').val(deletedUrls);
	                 }else{
	                        console.log(data.message);  //打印服务器返回的错误信息
	                 }
	              }
	        }); 
	    },
	    onSuccess: function(files,data,xhr,pd)
	    {
	        //上传成功后的回调方法。本例中是将返回的文件名保到一个hidden类开的input中，以便后期数据处理
	        if(data&&data.error==0){
	        	$.messager.alert('提示','上传完成!');
	        	if( $('#orderAddForm [name=file]').val() != null && $('#orderAddForm [name=file]').val() != ''){
	        		/* alert($('#orderAddForm [name=file]').val()); */
	        		$('#orderAddForm [name=file]').val($('#orderAddForm [name=file]').val()+","+data.url);
	        	}else{
	            	$('#orderAddForm [name=file]').val(data.url);
	        	}
	        }
	    }
	});
}	

//加载文件上传插件
function initOrderEditFileUpload(){
	$("#orderEditFileUploader").uploadFile({
		url:"file/upload",
		maxFileCount: 5,                //上传文件个数（多个时修改此处
	    returnType: 'json',              //服务返回数据
	    allowedTypes: 'doc,docx,excel,sql,txt,ppt,pdf',  //允许上传的文件式
	    showDone: false,                     //是否显示"Done"(完成)按钮
	    showDelete: true,                  //是否显示"Delete"(删除)按钮
	    deleteCallback: function(data,pd)
	    {
	        //文件删除时的回调方法。
	        //如：以下ajax方法为调用服务器端删除方法删除服务器端的文件
	        var fileUrl = data.url;
	        $.ajax({
	            cache: false,
	            url: "file/delete",
	            dataType: "json",
	            data: {fileName:data.url},
	            success: function(data) 
	            {
	                if(data.data=="success"){
	                    pd.statusbar.hide();        //删除成功后隐藏进度条等
	                    $('#image').val('');
	                    var urls = $('#orderEditForm [name=file]').val().split(",");  //将删除的文件url从urls中移除
	                    var deletedUrls = [];
	                	for(var i in urls){
	                		if(urls[i] != fileUrl){
	                			deletedUrls.push(urls[i]);
	                		}
	                	}
	                	deletedUrls = deletedUrls.join(",");
	                	$('#orderEditForm [name=file]').val(deletedUrls);
	                 }else{
	                        console.log(data.message);  //打印服务器返回的错误信息
	                 }
	              }
	        }); 
	    },
	    onSuccess: function(files,data,xhr,pd)
	    {
	        //上传成功后的回调方法。本例中是将返回的文件名保到一个hidden类开的input中，以便后期数据处理
	        if(data&&data.error==0){
	        	$.messager.alert('提示','上传完成!');
	        	if( $('#orderEditForm [name=file]').val() != null && $('#orderEditForm [name=file]').val() != ''){
	        		/*alert($('#orderEditForm [name=file]').val()); */
	        		$('#orderEditForm [name=file]').val($('#orderEditForm [name=file]').val()+","+data.url);
	        	}else{
	            	$('#orderEditForm [name=file]').val(data.url);
	        	}
	        }
	    }
	});
}	

//删除文件并删除文件在页面的显示
function removeFile(i){
	var fileName = $('#file'+i).attr("href");
	$.ajax({
        cache: false,
        url: "file/delete",
        dataType: "json",
        data: {fileName:fileName},
        success: function(data) 
        {
            if(data.data=="success"){
            	$('#img'+i);
            	$('#file'+i).remove();		//删除成功后在页面上删除该文件的显示
            	$('#delFile'+i).remove();        
                var urls = $('#orderEditFile').val().split(",");  //将删除的文件url从urls中移除
                var deletedUrls = [];
                tempDelFileName = fileName.substring(0,fileName.lastIndexOf("/"));
                delFileName = tempDelFileName.substring(tempDelFileName.lastIndexOf("/"))+fileName.substring(fileName.lastIndexOf("/"));
                for(var k in urls){
            		if(urls[k] != delFileName){
            			deletedUrls.push(urls[k]);
            		}
            	}
            	deletedUrls = deletedUrls.join(",");
            	$('#orderEditFile').val(deletedUrls);
             }else{
                    console.log(data.message);  //打印服务器返回的错误信息
             }
          }
    }); 
}

//加载上传过的文件
function initUploadedFile(){
	var _ele = $("#orderEditFileUploader");
	_ele.after('\
			<table class="file">\
			</table>');
	var files = $('#orderEditFile').val().split(","); 
	for(var i in files){
		if(files[i] !=null && files[i] != ''){
			_ele.siblings(".file").append("<tr><td><a id='file"+i+"' href='file/download?fileName="+files[i]+"'>" +
					"<span style='font-size: 16px;font-family: Microsoft YaHei;'>"
					+ files[i].substring(files[i].lastIndexOf("/")+1) + "</span></td><td></a> " 
						+"<a id='delFile"+i+"' href='javascript:removeFile("+i+");'>" 
						+"<span style='font-size: 16px;font-family: Microsoft YaHei;;margin-left: 30px'>"+"删除</span></a></td></tr>");
		}
	}
}
