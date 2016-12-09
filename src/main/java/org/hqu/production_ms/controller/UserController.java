package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
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
	private Map<String,Object> insert(UserPO user) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(userService.findByUserNameAndId(user.getUsername(), user.getId()).size()>0){
			map.put("msg", "该用户名已经存在，请更换用户名！");
			map.put("label", "1");
		}else if(userService.get(user.getId()) != null){
			map.put("msg", "该用户编号已经存在，请更换用户编号！");
			map.put("label", "2");
		}else{
			CustomResult result = userService.insert(user);
			if(result.getStatus() == 200){
				map.put("msg", "新增用户成功！");
				map.put("label", "200");
			}else{
				map.put("msg", "新增用户失败！");
				map.put("label", "0");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(UserPO user) throws Exception {
		CustomResult result = userService.update(user);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private Map<String,Object> updateAll(UserPO user) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(userService.findByUserNameAndId(user.getUsername(), user.getId()).size()>0){
			map.put("msg", "该用户名已经存在，请更换用户名！");
			map.put("label", "1");
		}else{
			CustomResult result = userService.updateAll(user);
			if(result.getStatus() == 200){
				map.put("msg", "更新用户成功！");
				map.put("label", "200");
			}else{
				map.put("msg", "更新用户失败！");
				map.put("label", "0");
			}
		}
		return map;
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
		System.out.println(ids);
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
