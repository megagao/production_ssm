package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.Custom;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.mapper.CustomMapper;
import com.megagao.production.ssm.service.CustomService;
import com.megagao.production.ssm.domain.CustomExample;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CustomServiceImpl implements CustomService {

	@Autowired
    CustomMapper customMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Custom custom) throws Exception{
		//查询客户列表
		CustomExample example = new CustomExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Custom> list = customMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Custom> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Custom get(String string) throws Exception{
		return customMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception{
		int i = customMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = customMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Custom custom) throws Exception{
		int i = customMapper.insert(custom);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增客户失败");
		}
	}

	@Override
	public CustomResult update(Custom custom) throws Exception{
		int i = customMapper.updateByPrimaryKeySelective(custom);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改客户失败");
		}
	}
	
	@Override
	public CustomResult updateAll(Custom custom) throws Exception{
		int i = customMapper.updateByPrimaryKey(custom);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改客户失败");
		}
	}

	@Override
	public CustomResult updateNote(Custom custom) throws Exception{
		int i = customMapper.updateNote(custom);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "更新客户介绍失败");
		}
	}

	@Override
	public CustomResult changeStatus(String[] ids) throws Exception{
		customMapper.changeStatus(ids);
		return CustomResult.ok();
	}

	@Override
	public List<Custom> find() throws Exception{
		CustomExample example = new CustomExample();
		return customMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchCustomByCustomName(int page, int rows, String customName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Custom> list =  customMapper.searchCustomByCustomName(customName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Custom> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult searchCustomByCustomId(int page, int rows, String customId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Custom> list =  customMapper.searchCustomByCustomId(customId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Custom> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
