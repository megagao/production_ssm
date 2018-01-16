package com.megagao.production.ssm.domain.authority;

import javax.validation.constraints.Size;

public class SysUser {
	
	@Size(max=36, message="用户编号过长！")
	private String id;

	@Size(max=64, message="用户名过长！")
    private String username;

	@Size(max=32, message="密码过长！")
    private String password;
    
	@Size(max=1, message="用户状态输入非法！")
    private String locked;
    
	@Size(max=128, message="角色名过长！")
    private String roleName;
    
	@Size(max=36, message="角色编号非法！")
    private String roleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
