package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.customize.CustomResult;
import org.hqu.production_ms.domain.customize.EUDataGridResult;
import org.hqu.production_ms.domain.authority.SysUser;

public interface UserService {
	
	EUDataGridResult getList(int page, int rows, SysUser sysUser) throws Exception;

	SysUser get(String string) throws Exception;
	
	List<SysUser> findByUserNameAndId(String username, String id) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(SysUser userPO) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(SysUser userPO) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(SysUser userPO) throws Exception;
    
    CustomResult changeStatus(String[] ids) throws Exception;
    
    List<SysUser> searchSysUserBySysUserName(String sysUserName) throws Exception;

	List<SysUser> searchSysUserBySysUserId(String sysUserId) throws Exception;

	EUDataGridResult searchUserByUserId(Integer page, Integer rows,
			String userId) throws Exception;

	EUDataGridResult searchUserByUserName(Integer page, Integer rows,
			String userName) throws Exception;

	EUDataGridResult searchUserByRoleName(Integer page, Integer rows,
			String roleName) throws Exception;
}
