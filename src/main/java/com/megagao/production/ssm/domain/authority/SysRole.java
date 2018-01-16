package com.megagao.production.ssm.domain.authority;

public class SysRole {
	private String roleId;

    private String roleName;

    private String available;
    
    private String permission;

	public String getRoleId() {
		return roleId;
	}
  	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}
}
