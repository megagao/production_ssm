package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.authority.SysRolePermission;
import org.hqu.production_ms.domain.authority.SysRolePermissionExample;
import org.hqu.production_ms.mapper.authority.SysRolePermissionMapper;
import org.hqu.production_ms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	SysRolePermissionMapper sysRolePermissionMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, SysRolePermission sysRolePermission) {
		//查询列表
		SysRolePermissionExample example = new SysRolePermissionExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<SysRolePermission> list = sysRolePermissionMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<SysRolePermission> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public SysRolePermission get(String string) {
		return sysRolePermissionMapper.selectByPrimaryKey(string);
	}

	@Override
	public SysRolePermission getByRoleId(String string) {
		SysRolePermissionExample example = new SysRolePermissionExample();
		SysRolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(string);
		return sysRolePermissionMapper.selectByExample(example).get(0);
	}
	
	@Override
	public CustomResult delete(String string) {
		int i = sysRolePermissionMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(SysRolePermission sysRolePermission) {
		int i = sysRolePermissionMapper.insert(sysRolePermission);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(SysRolePermission sysRolePermission) {
		int i = sysRolePermissionMapper.updateByPrimaryKeySelective(sysRolePermission);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateByRoleId(String roleId, String permission) {
		SysRolePermission sysRolePermission = new SysRolePermission();
		sysRolePermission.setSysPermissionId(permission);
		//修改角色权限表
		SysRolePermissionExample example = new SysRolePermissionExample();
		SysRolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(roleId);
		int i = sysRolePermissionMapper.updateByExampleSelective(sysRolePermission, example);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public CustomResult updateAll(SysRolePermission sysRolePermission) {
		int i = sysRolePermissionMapper.updateByPrimaryKey(sysRolePermission);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public List<SysRolePermission> find() {
		SysRolePermissionExample example = new SysRolePermissionExample();
		return sysRolePermissionMapper.selectByExample(example);
	}
}
