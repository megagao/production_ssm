<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>
<%@ include file="/WEB-INF/jsp/common_css.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>生产管理系统</title>
</head>
<body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="用户登录" data-options="closable:false,draggable:false" style="width:400px;height:300px;padding:10px;">
       	<div style="margin-left: 50px;margin-top: 50px;">
       		<div style="margin-bottom:20px;">
	            <div>
	            	用户名: <input id="username" class="easyui-textbox" data-options="required:true" style="width:200px;height:32px"/>
	            </div>
	            <div>
	            	<span id="userspan"></span>
	            </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	密&nbsp;&nbsp;码: <input id="password" class="easyui-textbox" type="password" style="width:200px;height:32px" />
	            </div>
	            <div>
	            	<span id="passsword_span"></span>
	            </div>
	        </div>
	        <div>
	            <a id="login" class="easyui-linkbutton" iconCls="icon-ok" style="width:100px;height:32px;margin-left: 50px">登录</a>
	        </div>
	        <div>
	            	<span id="error_span"></span>
	        </div>
       	</div>
    </div>
    
    <script type="text/javascript">
    	$("#login").click(function(){
    		
    		var uname = $("#username");  
        	var pwd = $("#password");  
        
        	if ($.trim(uname.val()) == ""){ 
        		$("#passsword_span").html("");
               	$("#userspan").html("<font color='red'>用户名不能为空！</font>");
               	uname.focus();  
           	}else if ($.trim(pwd.val()) == ""){  
        	   	$("#userspan").html("");
               	$("#passsword_span").html("<font color='red'>密码不能为空！</font>");
               	pwd.focus();  
           	}else{  
           		$("#userspan").html("");
    			$("#passsword_span").html("");
    			
                $.ajax( {  
                	url:'${baseurl}login',// 跳转到 action  
                	data:{  
                		username : uname.val(),
         	            password : pwd.val(),
                	},  
                	type:'post',  
                	cache:false,  
                	dataType:'json',  
                	success:function(data) {  
                		if(data.msg =="success" ){  
                	        location.href="${baseurl}home";  
                	  	}else{  
                	  		$("#error_span").html("<font color='red'>用户名或密码错误！</font>");
                	    }  
                	},  
                	error : function() {  
                	    // view("异常！");  
                	    alert("异常！");  
                	}  
    			}); 
			}
    	});
    </script>
</body>
</html>