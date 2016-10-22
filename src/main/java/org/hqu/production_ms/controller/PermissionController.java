package org.hqu.production_ms.controller;

import java.util.List;

import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.authority.SysRolePermission;
import org.hqu.production_ms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/get/{permissionId}")
	@ResponseBody
	public SysRolePermission getItemById(@PathVariable String permissionId) {
		SysRolePermission sysRolePermission = permissionService.get(permissionId);
		return sysRolePermission;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "permission_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<SysRolePermission> getData() {
		return permissionService.find();
	}
	
	@RequestMapping("/add")
	public String add() {
		return "permission_add";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "permission_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, SysRolePermission sysRolePermission) {
		EUDataGridResult result = permissionService.getList(page, rows, sysRolePermission);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(SysRolePermission sysRolePermission) throws Exception {
		CustomResult result = permissionService.insert(sysRolePermission);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(SysRolePermission sysRolePermission) throws Exception {
		CustomResult result = permissionService.update(sysRolePermission);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(SysRolePermission sysRolePermission) throws Exception {
		CustomResult result = permissionService.updateAll(sysRolePermission);
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = permissionService.delete(id);
		return result;
	}
}
