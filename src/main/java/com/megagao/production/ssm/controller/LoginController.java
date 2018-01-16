package com.megagao.production.ssm.controller;

import com.megagao.production.ssm.util.CollectionsFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

import static com.megagao.production.ssm.common.Constants.VALIDATE_CODE;

/**
  * created on 2016年9月6日 
  *
  * @author  megagao
  */
@Controller
public class LoginController {

	/**
	 * shiro ajax登录 
	 */
	@RequestMapping(value = "/ajaxLogin")
	@ResponseBody
	public Map<String,Object> ajaxLogin(@RequestParam String username,
													  @RequestParam String password,
													  @RequestParam(required=false) String randomcode,
													  HttpSession session) throws Exception{
	    
		Map<String,Object> map = CollectionsFactory.newHashMap();
		
		if(randomcode !=null && !randomcode.equals("")){
	    	//取出session的验证码（正确的验证码）
	    	String validateCode = (String)session.getAttribute(VALIDATE_CODE);
			//页面中输入的验证和session中的验证进行对比 
			if(validateCode!=null && !randomcode.equals(validateCode)){
				//如果校验失败，将验证码错误失败信息放入map中
				map.put("msg", "randomcode_error");
				//直接返回，不再校验账号和密码 
				return map; 
			}
	    }
		Subject currentUser = SecurityUtils.getSubject();
	    if (!currentUser.isAuthenticated()) {
	    	UsernamePasswordToken token = new UsernamePasswordToken(username, password);
	        try{
	            currentUser.login(token);
	        }catch(UnknownAccountException ex){
	        	map.put("msg", "account_error");
	        }catch(IncorrectCredentialsException ex){
	        	map.put("msg", "password_error");
	        }catch(AuthenticationException ex){
	        	map.put("msg", "authentication_error");
	        }
	    }
	    //返回json数据
	    return map;
	}
}
