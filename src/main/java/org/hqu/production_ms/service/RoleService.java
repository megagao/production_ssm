package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.RolePO;

public interface RoleService {
	
	List<SysRole> find();
	
	SysRole findRoleByUserId(String userId);
	
	EUDataGridResult getList(int page, int rows, SysRole sysRole);
	
	List<SysRole> findByRoleNameAndId(String rolename, String id);
	
	SysRole get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(RolePO role);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(RolePO role);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(RolePO role);
    
    List<SysRole> searchSysRoleBySysRoleName(String sysRoleName);

	List<SysRole> searchSysRoleBySysRoleId(String sysRoleId);

	EUDataGridResult searchRoleByRoleId(Integer page, Integer rows,
			String roleId);

	EUDataGridResult searchRoleByRoleName(Integer page, Integer rows,
			String roleName);
}
