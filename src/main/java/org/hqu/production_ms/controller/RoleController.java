package org.hqu.production_ms.controller;

import java.util.List;

import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.po.RolePO;
import org.hqu.production_ms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/get/{roleId}")
	@ResponseBody
	public SysRole getItemById(@PathVariable String roleId) {
		SysRole sysRole = roleService.get(roleId);
		return sysRole;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "role_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<SysRole> getData() {
		return roleService.find();
	}
	
	@RequestMapping("/add")
	public String add() {
		return "role_add";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "role_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, SysRole role) {
		EUDataGridResult result = roleService.getList(page, rows, role);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(RolePO role) throws Exception {
		CustomResult result = roleService.insert(role);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(RolePO role) throws Exception {
		CustomResult result = roleService.update(role);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(RolePO role) throws Exception {
		CustomResult result = roleService.updateAll(role);
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
	
}
