package org.hqu.production_ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hqu.production_ms.domain.SysPermission;
import org.hqu.production_ms.domain.SysUser;
import org.hqu.production_ms.service.SysService;
import org.hqu.production_ms.mapper.authority.SysUserMapper;
import org.hqu.production_ms.domain.SysUserExample;
import org.hqu.production_ms.mapper.authority.SysPermissionMapperCustom;

import org.hqu.production_ms.exception.CustomException;
import org.hqu.production_ms.domain.ActiveUser;

/**
 * created on 2016年9月6日 
 *
 * 认证和授权的服务接口
 *
 * @author  megagao
 * @version  0.0.1
 */
@Service
public class SysServiceImpl implements SysService {
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysPermissionMapperCustom sysPermissionMapperCustom;
	
	@Override
	public ActiveUser authenticat(String username, String password)
			throws Exception {
		/**
	认证过程：
	根据用户身份（账号）查询数据库，如果查询不到用户不存在
	对输入的密码 和数据库密码 进行比对，如果一致，认证通过
		 */
		//根据用户账号查询数据库
		SysUser sysUser = this.getSysUserByName(username);
		
		if(sysUser == null){
			return null;
		}
		
		//对输入的密码 和数据库密码 进行比对，如果一致，认证通过
		if(!password.equals(sysUser.getPassword())){
			return null;
		}
		//得到用户id
		String userid = sysUser.getId();
		//根据用户id查询菜单 
		List<SysPermission> menus =this.findMenuListByUserId(userid);
		
		//根据用户id查询权限url
		List<SysPermission> permissions = this.findPermissionListByUserId(userid);
		
		//认证通过，返回用户身份信息
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(sysUser.getId());
		activeUser.setUsername(sysUser.getUsername());//用户名称
		
		//放入权限范围的菜单和url
		activeUser.setMenus(menus);
		activeUser.setPermissions(permissions);
		
		return activeUser;
	}
	public SysUser getSysUserByUserId(String userid)throws Exception{
		
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsernameEqualTo(userid);
		
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		
		if(list!=null && list.size()==1){
			return list.get(0);
		}	
		
		return null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String userid)
			throws Exception {
		
		return sysPermissionMapperCustom.findMenuListByUserId(userid);
	}

	@Override
	public List<SysPermission> findPermissionListByUserId(String userid)
			throws Exception {
		
		return this.sysPermissionMapperCustom.findPermissionListByUserId(userid);
	}

	@Override
	public SysUser getSysUserByName(String username) throws Exception {
		
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		
		List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
		
		if(list!=null && list.size()==1){
			return list.get(0);
		}	
		
		return null;
	}

}
