<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<html>
<head>
<TITLE>生产管理平台</TITLE>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<LINK rel="stylesheet" type="text/css" href="${baseurl}styles/style.css">
<LINK rel="stylesheet" type="text/css" href="${baseurl}styles/login.css">
<LINK rel="stylesheet" type="text/css"	href="${baseurl}js/easyui/themes/default/easyui.css">
<LINK rel="stylesheet" type="text/css"	href="${baseurl}js/easyui/themes/icon.css">

<STYLE type="text/css">
.btnalink {
	cursor: hand;
	display: block;
	width: 80px;
	height: 29px;
	float: left;
	margin: 12px 28px 12px auto;
	line-height: 30px;
	background: url('${baseurl}images/login/btnbg.jpg') no-repeat;
	font-size: 14px;
	color: #fff;
	font-weight: bold;
	text-decoration: none;
}
</STYLE>
<%@ include file="/WEB-INF/jsp/common_js.jsp"%>

<script type="text/javascript">

	//登录提示方法
	function loginsubmit() {
		
 		var uname = $("#username");  
    	var pwd = $("#password");  
    	var rcode = $("#randomcode");  
    
    	if ($.trim(uname.val()) == ""){ 
           	$("#userspan").html("<font color='red'>用户名不能为空！</font>");
           	userId.focus();  
       	}else if ($.trim(pwd.val()) == ""){  
    	   	$("#userspan").html("");
           	$("#passsword_span").html("<font color='red'>密码不能为空！</font>");
           	pwd.focus();  
       	}else if ($.trim(rcode.val()) == ""){  
    	   	$("#passsword_span").html("");
    	   	$("#randomcode_span").html("<font color='red'>验证码不能为空！</font>");
    	   	rcode.focus();  
		}else{  
    	   
			$("#randomcode_span").html("");
            
            $.ajax( {  
            	url:'${baseurl}login',// 跳转到 action  
            	data:{  
            		username : uname.val(),
     	            password : pwd.val(),
     	            randomcode : rcode.val()
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
    	   	      
	    	   /*  $.post("${baseurl}login", {
               	username : username,
               	password : password,
               	randomcode : randomcode
				}, callback, "json");
            	function callback(data) {
 	             	if(data=="success"){
 	             		location.href="${baseurl}welcome";
 	             	}else{
 	              		alert(data);
            		}  
 				} */
          	}
        
		}  
	
	
</SCRIPT>
</HEAD>
<BODY style="background: #f6fdff url(${baseurl}images/login/bg1.jpg) repeat-x;">
		<DIV class="logincon">

			<DIV class="title">
				<span style="font: bold;font-size: 40;font-family: "宋体";">生 产 管 理 系 统</span>
			</DIV>

			<DIV class="cen_con">
				<IMG alt="" src="${baseurl}images/login/bg2.png">
			</DIV>

			<DIV class="tab_con">

				<input type="password" style="display:none;" />
				<TABLE class="tab" border="0" cellSpacing="6" cellPadding="8">
					<TBODY>
						<TR>
							<TD>用户名：</TD>
							<TD colSpan="2"><input type="text" id="username"
								name="username" style="WIDTH: 130px" /><span id="userspan"></span></TD>
						</TR>
						<TR>
							<TD>密 码：</TD>
							<TD>
								<input type="password" id="password" name="password" style="WIDTH: 130px" />
								<span id="passsword_span"></span>
							</TD>
						</TR>
						<TR>
							<TD>验证码：</TD>
							<TD>
								<input id="randomcode" name="randomcode" size="8" /> <img
									id="randomcode_img" src="${baseurl}validatecode.jsp" alt=""
									width="56" height="20" align='absMiddle' /> 
								<a href=javascript:randomcode_refresh()>刷新</a>
								<span id="randomcode_span"></span>
									
							</TD>
						</TR>

						<TR align="center">
							<TD colSpan="2" align="center">
							 <input type="button" class="btnalink" onclick="loginsubmit()" value="登&nbsp;&nbsp;录" /> 
							 <span  id="error_span"></span>
							</TD>
						</TR>
						
					</TBODY>
				</TABLE>

			</DIV>
		</DIV>
</BODY>
</HTML>
