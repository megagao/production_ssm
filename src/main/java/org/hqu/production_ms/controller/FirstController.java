package org.hqu.production_ms.controller;

import javax.servlet.http.HttpSession;

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
	
	//首页
	@RequestMapping("/home")
	public String welcome(HttpSession session, Model model)throws Exception{
		
		Object obj = session.getAttribute("activeUser");
		
		if(obj != null && !obj.equals("")){
			return "home";
		}else{
			return "login";
		}
	}
}	
