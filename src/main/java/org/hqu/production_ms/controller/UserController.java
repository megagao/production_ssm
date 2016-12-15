package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.UserPO;
import org.hqu.production_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public SysUser getItemById(@PathVariable String userId) throws Exception{
		SysUser sysUser = userService.get(userId);
		return sysUser;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "user_list";
	}
	
	@RequestMapping("/role")
	public String userRole() throws Exception{
		return "user_role_edit";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> userAddJudge() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("user:add")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "user_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> userEditJudge() throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();  
		Subject currentUser = SecurityUtils.getSubject();
		if(!currentUser.isPermitted("user:edit")){
			map.put("msg", "您没有权限，请切换用户登录！");
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "user_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, SysUser sysUser) throws Exception{
		EUDataGridResult result = userService.getList(page, rows, sysUser);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid UserPO user, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(userService.findByUserNameAndId(user.getUsername(), user.getId()).size()>0){
			return CustomResult.build(101, "该用户名已经存在，请更换用户名!");
		}else if(userService.get(user.getId()) != null){
			return CustomResult.build(101, "该用户编号已经存在，请更换用户编号！");
		}
		result = userService.insert(user);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid UserPO user, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return userService.update(user);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid UserPO user, BindingResult bindingResult) throws Exception {
		CustomResult result; 
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(userService.findByUserNameAndId(user.getUsername(), user.getId()).size()>0){
			return CustomResult.build(101, "该用户名已经存在，请更换用户名！");
		}
		
		result = userService.updateAll(user);
		return result;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> userDeleteJudge() throws Exception{
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
		CustomResult result = userService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/change_status")
	@ResponseBody
	public CustomResult changeStatus(String[] ids) throws Exception{
		CustomResult result = userService.changeStatus(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_user_by_userId")
	@ResponseBody
	public EUDataGridResult searchUserByUserId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = userService.searchUserByUserId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_user_by_userName")
	@ResponseBody
	public EUDataGridResult searchUserByUserName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = userService.searchUserByUserName(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_user_by_roleName")
	@ResponseBody
	public EUDataGridResult searchUserByRoleName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = userService.searchUserByRoleName(page, rows, searchValue);
		return result;
	}
}
