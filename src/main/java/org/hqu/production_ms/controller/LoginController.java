package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.hqu.production_ms.domain.ActiveUser;
import org.hqu.production_ms.service.SysService;

 /**
  * created on 2016年9月6日 
  *
  * 登陆和退出
  *
  * @author  megagao
  * @version  0.0.1
  */
@Controller
public class LoginController {
	
	@Autowired
	private SysService sysService;
	
	
	//用户登陆提交方法
	/**
	 * 
	 * <p>Title: login</p>
	 * <p>Description: </p>
	 * @param session
	 * @param randomcode 输入的验证码
	 * @param usercode 用户账号
	 * @param password 用户密码 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public @ResponseBody Map<String,Object> login(HttpServletRequest request, HttpServletResponse response,
			HttpSession session)throws Exception{
		
		Map<String,Object> map = new HashMap<String,Object>();  
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		//调用service校验用户账号和密码的正确性
		ActiveUser activeUser = sysService.authenticat(username, password);
		
		if(activeUser!=null){
			
			//如果service校验通过，将用户身份记录到session
			session.setAttribute("activeUser", activeUser);
			//重定向到商品查询页面
			map.put("msg", "success");
		}else{
			map.put("msg", "用户名或密码错误！");
		}
		return map; 
	}
	
	
	//登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	/*@RequestMapping("/login")
	public String login(HttpServletRequest request) throws Exception{
		
		//如果登陆失败从request中获取认证异常信息，shiroLoginFailure就是shiro异常类的全限定名
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				throw new CustomException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {
				throw new CustomException("用户名/密码错误");
			} else if("randomCodeError".equals(exceptionClassName)){
				throw new CustomException("验证码错误 ");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		//此方法不处理登陆成功（认证成功），shiro认证成功会自动跳转到上一个请求路径
		//登陆失败还到login页面
		return "login";
	}*/
	
/*	//用户退出
	@RequestMapping("/logout")
	public String logout(HttpSession session)throws Exception{
		
		//session失效
		session.invalidate();
		//重定向到商品查询页面
		return "redirect:/first.action";
		
	}*/
	

}
