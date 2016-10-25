package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.authority.SysRoleExample;
import org.hqu.production_ms.domain.authority.SysRolePermission;
import org.hqu.production_ms.domain.authority.SysRolePermissionExample;
import org.hqu.production_ms.domain.authority.SysUserRole;
import org.hqu.production_ms.domain.authority.SysUserRoleExample;
import org.hqu.production_ms.domain.po.RolePO;
import org.hqu.production_ms.mapper.authority.SysRoleMapper;
import org.hqu.production_ms.mapper.authority.SysRolePermissionMapper;
import org.hqu.production_ms.mapper.authority.SysUserRoleMapper;
import org.hqu.production_ms.service.RoleService;
import org.hqu.production_ms.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Autowired
	SysUserRoleMapper sysUserRoleMapper;
	
	@Autowired
	SysRolePermissionMapper sysRolePermissionMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, SysRole sysRole) {
		//查询列表
		SysRoleExample example = new SysRoleExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<SysRole> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


	@Override
	public List<SysRole> findByRoleNameAndId(String rolename, String id) {
		SysRoleExample example = new SysRoleExample();
		SysRoleExample.Criteria criteria = example.createCriteria();
		criteria.andRoleNameEqualTo(rolename);
		if(id != null){
			criteria.andRoleIdNotEqualTo(id);
		}
		List<SysRole> sysRoleList = sysRoleMapper.selectByExample(example);
		return sysRoleList;
	}

	
	@Override
	public SysRole get(String string) {
		return sysRoleMapper.selectByPrimaryKey(string);
	}


	@Override
	public SysRole findRoleByUserId(String userId) {
		SysUserRoleExample example = new SysUserRoleExample();
		SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andSysUserIdEqualTo(userId);
		SysUserRole sysUserRole = sysUserRoleMapper.selectByExample(example).get(0);
		SysRole sysRole = sysRoleMapper.selectByPrimaryKey(sysUserRole.getSysRoleId());
		return sysRole;
	}
	
	@Override
	public CustomResult delete(String string) {
		int i = sysRoleMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = sysRoleMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(RolePO role) {
		//在业务层整合
		SysRolePermission sysRolePermission = new SysRolePermission();
		sysRolePermission.setId(IDUtils.genStringId());
		sysRolePermission.setSysRoleId(role.getRoleId());
		sysRolePermission.setSysPermissionId(role.getPermission());
		//存角色权限表
		int k = sysRolePermissionMapper.insertSelective(sysRolePermission);
		
		int i = sysRoleMapper.insert(role);
		if(i>0 && k>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(RolePO role) {
		int i = sysRoleMapper.updateByPrimaryKeySelective(role);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(RolePO role) {
		//在业务层整合处理
		SysRolePermission sysRolePermission = new SysRolePermission();
		sysRolePermission.setSysPermissionId(role.getPermission());
		//修改角色权限表
		SysRolePermissionExample example = new SysRolePermissionExample();
		SysRolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(role.getRoleId());
		int k = sysRolePermissionMapper.updateByExampleSelective(sysRolePermission, example);
		
		int i = sysRoleMapper.updateByPrimaryKey(role);
		if(i>0 && k>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public List<SysRole> find() {
		SysRoleExample example = new SysRoleExample();
		return sysRoleMapper.selectByExample(example);
	}

}
