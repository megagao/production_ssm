package com.megagao.production.ssm.domain.customize;

import java.util.List;

import com.megagao.production.ssm.domain.authority.SysPermission;


/**
 * created on 2016年9月8日 
 *
 * 用户身份信息，存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 *
 * @author  megagao
 * @version  0.0.1
 */
public class ActiveUser implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;//用户id（主键）
	private String username;// 用户名称
	private String userStatus;// 用户状态
	private String rolename;// 角色名称
	private String roleStatus;// 角色状态
	private List<SysPermission> menus;// 菜单
	private List<SysPermission> permissions;// 权限

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<SysPermission> getMenus() {
		return menus;
	}

	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}

	public List<SysPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}

}
