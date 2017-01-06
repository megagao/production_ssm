package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.UserPO;

public interface UserService {
	
	EUDataGridResult getList(int page, int rows, SysUser sysUser);
	
	SysUser get(String string);
	
	List<SysUser> findByUserNameAndId(String username, String id);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(UserPO userPO);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UserPO userPO);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(UserPO userPO);
    
    CustomResult changeStatus(String[] ids);
    
    List<SysUser> searchSysUserBySysUserName(String sysUserName);

	List<SysUser> searchSysUserBySysUserId(String sysUserId);

	EUDataGridResult searchUserByUserId(Integer page, Integer rows,
			String userId);

	EUDataGridResult searchUserByUserName(Integer page, Integer rows,
			String userName);

	EUDataGridResult searchUserByRoleName(Integer page, Integer rows,
			String roleName);
}
