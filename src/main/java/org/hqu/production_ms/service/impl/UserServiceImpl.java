package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.po.COrderPO;
import org.hqu.production_ms.domain.po.UserPO;
import org.hqu.production_ms.mapper.COrderMapper;
import org.hqu.production_ms.mapper.authority.SysUserMapper;
import org.hqu.production_ms.service.OrderService;
import org.hqu.production_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	SysUserMapper sysUserMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, SysUser sysUser) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<UserPO> list = sysUserMapper.find(sysUser);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UserPO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

/*	@Override
	public COrder get(String id) {
		
		return cOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult delete(String id) {
		int i = cOrderMapper.deleteByPrimaryKey(id);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = cOrderMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(COrderPO cOrder) {
		int i = cOrderMapper.insert(cOrder);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(COrderPO cOrder) {
		int i = cOrderMapper.updateByPrimaryKeySelective(cOrder);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(COrderPO cOrder) {
		int i = cOrderMapper.updateByPrimaryKey(cOrder);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(COrderPO cOrder) {
		int i = cOrderMapper.updateNote(cOrder);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public CustomResult changeStatus(String[] ids) {
		int i = cOrderMapper.changeStatus(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}*/

	@Override
	public CustomResult insert(UserPO userPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomResult update(UserPO userPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomResult updateAll(UserPO userPO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser get(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomResult delete(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomResult changeStatus(String[] ids) {
		// TODO Auto-generated method stub
		return null;
	}
}
