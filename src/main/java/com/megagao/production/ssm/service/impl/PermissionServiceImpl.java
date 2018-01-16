package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.authority.SysRolePermission;
import com.megagao.production.ssm.domain.authority.SysRolePermissionExample;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.mapper.authority.SysRolePermissionMapper;
import com.megagao.production.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
    SysRolePermissionMapper sysRolePermissionMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, SysRolePermission sysRolePermission)
			throws Exception{
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
	public SysRolePermission get(String string) throws Exception{
		return sysRolePermissionMapper.selectByPrimaryKey(string);
	}

	@Override
	public SysRolePermission getByRoleId(String string) throws Exception{
		SysRolePermissionExample example = new SysRolePermissionExample();
		SysRolePermissionExample.Criteria criteria = example.createCriteria();
		criteria.andSysRoleIdEqualTo(string);
		return sysRolePermissionMapper.selectByExample(example).get(0);
	}
	
	@Override
	public CustomResult delete(String string) throws Exception{
		int i = sysRolePermissionMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(SysRolePermission sysRolePermission) throws Exception{
		int i = sysRolePermissionMapper.insert(sysRolePermission);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增权限失败");
		}
	}

	@Override
	public CustomResult update(SysRolePermission sysRolePermission) throws Exception{
		int i = sysRolePermissionMapper.updateByPrimaryKeySelective(sysRolePermission);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改权限失败");
		}
	}

	@Override
	public CustomResult updateByRoleId(String roleId, String permission) throws Exception{
		SysRolePermission sysRolePermission = new SysRolePermission();
		sysRolePermission.setSysPermissionId(permission);
		sysRolePermission.setSysRoleId(roleId);
		//修改角色权限表
		int i = sysRolePermissionMapper.updateRolePermission(sysRolePermission);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public CustomResult updateAll(SysRolePermission sysRolePermission) throws Exception{
		int i = sysRolePermissionMapper.updateByPrimaryKey(sysRolePermission);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改权限失败");
		}
	}

	@Override
	public List<SysRolePermission> find() throws Exception{
		SysRolePermissionExample example = new SysRolePermissionExample();
		return sysRolePermissionMapper.selectByExample(example);
	}
}
