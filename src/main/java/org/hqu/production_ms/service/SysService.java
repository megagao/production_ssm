package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.authority.SysPermission;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.customize.ActiveUser;

/**
 * created on 2016年9月6日 
 *
 * 认证授权服务接口
 *
 * @author  megagao
 * @version  0.0.1
 */
public interface SysService {
	
	/**
	 * 根据用户的身份和密码 进行认证，如果认证通过，返回用户身份信息
	 *
	 * @param  userCode, password
	 * @return 用户身份信息ActiveUser
	 */
	public ActiveUser authenticat(String userCode,String password) throws Exception;
	
	/**
	 * 根据用户id查询用户信息
	 *
	 * @param  userid
	 * @return  用户信息
	 */
	public SysUser getSysUserByUserId(String userid)throws Exception;
	
	/**
	 * 根据用户名查询用户信息
	 *
	 * @param  username
	 * @return  用户信息
	 */
	public SysUser getSysUserByName(String username)throws Exception;
	
	//根据用户id查询权限范围的菜单
	/**
	 * 根据用户id查询权限范围的菜单
	 *
	 * @param  userid
	 * @return  权限范围的菜单
	 */
	public List<SysPermission> findMenuListByUserId(String userid) throws Exception;
	
	/**
	 * 根据用户id查询权限范围的url
	 *
	 * @param  userid
	 * @return  权限范围的url
	 */
	public List<SysPermission> findPermissionListByUserId(String userid) throws Exception;
}
