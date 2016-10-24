package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.authority.SysRolePermission;

public interface PermissionService {
	
	List<SysRolePermission> find();  
	
	EUDataGridResult getList(int page, int rows, SysRolePermission sysRolePermission);
	
	SysRolePermission get(String string);
	
	SysRolePermission getByRoleId(String string);
	
	CustomResult delete(String string);

	CustomResult insert(SysRolePermission sysRolePermission);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(SysRolePermission sysRolePermission);
    
    //根据角色id更新角色权限表
    CustomResult updateByRoleId(String roleId, String permission);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(SysRolePermission sysRolePermission);
}
