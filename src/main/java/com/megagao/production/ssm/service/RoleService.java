package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.vo.RoleVO;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.authority.SysRole;

public interface RoleService {
	
	List<RoleVO> find() throws Exception;
	
	RoleVO findRoleByUserId(String userId) throws Exception;
	
	EUDataGridResult getList(int page, int rows, RoleVO sysRole) throws Exception;
	
	List<RoleVO> findByRoleNameAndId(String rolename, String id) throws Exception;
	
	RoleVO get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(SysRole role) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(SysRole role) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(SysRole role) throws Exception;
    
    List<RoleVO> searchSysRoleBySysRoleName(String sysRoleName) throws Exception;

	List<RoleVO> searchSysRoleBySysRoleId(String sysRoleId) throws Exception;

	EUDataGridResult searchRoleByRoleId(Integer page, Integer rows,
			String roleId) throws Exception;

	EUDataGridResult searchRoleByRoleName(Integer page, Integer rows,
			String roleName) throws Exception;
}
