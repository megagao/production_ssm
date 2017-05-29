package org.hqu.production_ms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.authority.SysPermission;
import org.hqu.production_ms.domain.customize.ActiveUser;
import org.hqu.production_ms.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FirstController {

	@Autowired
	private SysService sysService;
	
	//跳转登录
	@RequestMapping(value={"/","/first","/login"})
	public String first(Model model)throws Exception{
		return "login";
	}
	
	//首页
	@RequestMapping("/home")
	public String home(HttpSession session, Model model)throws Exception{
		
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		
		List<SysPermission> permissionList = null;
		
		try {
			permissionList = sysService.findPermissionListByUserId(activeUser.getUserid());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> sysPermissionList = new ArrayList<String>();
		if(permissionList != null){
			for(int i=0;i<permissionList.size();i++){
				sysPermissionList.add(permissionList.get(i).getPercode());
			}
		}

		//通过model传到页面
		model.addAttribute("activeUser", activeUser);
		/*model.addAttribute("sysPermissionsList", sysPermissionsList);*/
		
		//session
		session.setAttribute("sysPermissionList", sysPermissionList);
		
		return "home";
	}
}	
