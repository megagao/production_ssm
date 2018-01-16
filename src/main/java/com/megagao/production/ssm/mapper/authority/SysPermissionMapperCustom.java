package com.megagao.production.ssm.mapper.authority;

import java.util.List;

import com.megagao.production.ssm.domain.authority.SysPermission;

/**
 * 
 * <p>Title: SysPermissionMapperCustom</p>
 * <p>Description: 权限mapper</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-23下午2:55:28
 * @version 1.0
 */
public interface SysPermissionMapperCustom {
	
	//根据用户id查询菜单
	public List<SysPermission> findMenuListByUserId(String userid)throws Exception;
	//根据用户id查询权限url
	public String findPermissionByUserId(String userid)throws Exception;

}
