package org.hqu.production_ms.domain;

import java.util.List;

/**
 * created on 2016年9月6日 
 *
 * 用户身份信息，存入session 由于tomcat将session会序列化在本地硬盘上，所以使用Serializable接口
 *
 * @author  megagao
 * @version  0.0.1
 */
public class ActiveUser implements java.io.Serializable {
    
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id（主键）
	 */
	private String userid;
	
	/**
	 * 用户名称
	 */
    private String username;

    /**
     * 菜单
     */
    private List<SysPermission> menus; 
    
    /**
     * 权限
     */
    private List<SysPermission> permissions; 

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

}
