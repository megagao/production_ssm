package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.customize.CustomResult;
import org.hqu.production_ms.domain.customize.EUDataGridResult;
import org.hqu.production_ms.domain.po.RolePO;

public interface RoleService {
	
	List<SysRole> find() throws Exception;
	
	SysRole findRoleByUserId(String userId) throws Exception;
	
	EUDataGridResult getList(int page, int rows, SysRole sysRole) throws Exception;
	
	List<SysRole> findByRoleNameAndId(String rolename, String id) throws Exception;
	
	SysRole get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(RolePO role) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(RolePO role) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(RolePO role) throws Exception;
    
    List<SysRole> searchSysRoleBySysRoleName(String sysRoleName) throws Exception;

	List<SysRole> searchSysRoleBySysRoleId(String sysRoleId) throws Exception;

	EUDataGridResult searchRoleByRoleId(Integer page, Integer rows,
			String roleId) throws Exception;

	EUDataGridResult searchRoleByRoleName(Integer page, Integer rows,
			String roleName) throws Exception;
}
