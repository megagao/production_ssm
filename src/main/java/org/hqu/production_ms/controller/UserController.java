package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.po.UserPO;
import org.hqu.production_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/get/{userId}")
	@ResponseBody
	public SysUser getItemById(@PathVariable String userId) {
		SysUser sysUser = userService.get(userId);
		return sysUser;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "user_list";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> userAddJudge() {
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("user:add")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "user_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> userEditJudge() {
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("user:edit")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "user_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, SysUser sysUser) {
		EUDataGridResult result = userService.getList(page, rows, sysUser);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(UserPO user) throws Exception {
		CustomResult result = userService.insert(user);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(UserPO user) throws Exception {
		CustomResult result = userService.update(user);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(UserPO user) throws Exception {
		CustomResult result = userService.updateAll(user);
		return result;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> userDeleteJudge() {
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("user:delete")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = userService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		System.out.println(ids);
		CustomResult result = userService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/change_status")
	@ResponseBody
	public CustomResult changeStatus(String[] ids) {
		CustomResult result = userService.changeStatus(ids);
		return result;
	}
}
