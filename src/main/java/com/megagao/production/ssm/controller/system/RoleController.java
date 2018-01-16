package com.megagao.production.ssm.controller.system;

import java.util.List;

import com.megagao.production.ssm.domain.vo.RoleVO;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.authority.SysRole;
import com.megagao.production.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/get/{roleId}")
	@ResponseBody
	public RoleVO getItemById(@PathVariable String roleId) throws Exception{
		RoleVO sysRole = roleService.get(roleId);
		return sysRole;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "role_list";
	}
	
	@RequestMapping("/permission")
	public String permission() throws Exception{
		return "role_permission";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<RoleVO> getData() throws Exception{
		return roleService.find();
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "role_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "role_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, RoleVO role) throws Exception{
		EUDataGridResult result = roleService.getList(page, rows, role);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid SysRole role, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(roleService.findByRoleNameAndId(role.getRoleName(), role.getRoleId()).size()>0){
			result = new CustomResult(0, "该角色名已经存在，请更换角色名！", null);
		}else if(roleService.get(role.getRoleId()) != null){
			result = new CustomResult(0, "该角色编号已经存在，请更换角色编号！", null);
		}else{
			result = roleService.insert(role);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(SysRole role) throws Exception {
		CustomResult result = roleService.update(role);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid SysRole role, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(roleService.findByRoleNameAndId(role.getRoleName(), role.getRoleId()).size()>0){
			result = new CustomResult(0, "该角色名已经存在，请更换角色名！", null);
		}else if(roleService.get(role.getRoleId()) != null){
			result = new CustomResult(0, "该角色编号已经存在，请更换角色编号！", null);
		}else{
			result = roleService.updateAll(role);
		}
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = roleService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = roleService.deleteBatch(ids);
		return result;
	}
	
	//根据角色id查找
	@RequestMapping("/search_role_by_roleId")
	@ResponseBody
	public EUDataGridResult searchRoleByRoleId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = roleService.searchRoleByRoleId(page, rows, searchValue);
		return result;
	}
	
	//根据角色名查找
	@RequestMapping("/search_role_by_roleName")
	@ResponseBody
	public EUDataGridResult searchRoleByRoleName(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = roleService.searchRoleByRoleName(page, rows, searchValue);
		return result;
	}
}
