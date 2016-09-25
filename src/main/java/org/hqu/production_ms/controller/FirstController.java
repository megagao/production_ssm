package org.hqu.production_ms.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.ActiveUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FirstController {
	
	//跳转登录
	@RequestMapping("/first")
	public String first(Model model)throws Exception{
		
		return "login";
	}
	
	//跳转登录
	@RequestMapping("/")
	public String welcome(Model model)throws Exception{
		
		return "login";
	}
	
	//首页
	@RequestMapping("/home")
	public String home(HttpSession session, Model model)throws Exception{
		
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		//通过model传到页面
		model.addAttribute("activeUser", activeUser);
		
		return "home";
	}
}	
