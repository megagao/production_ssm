package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Custom;
import org.hqu.production_ms.domain.CustomExample;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.mapper.CustomMapper;
import org.hqu.production_ms.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CustomServiceImpl implements CustomService{

	@Autowired
	CustomMapper customMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Custom custom) {
		//查询商品列表
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
	public Custom get(String string) {
		return customMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		int i = customMapper.deleteByPrimaryKey(string);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = customMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Custom custom) {
		int i = customMapper.insert(custom);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(Custom custom) {
		int i = customMapper.updateByPrimaryKeySelective(custom);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public CustomResult updateAll(Custom custom) {
		int i = customMapper.updateByPrimaryKey(custom);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(Custom custom) {
		int i = customMapper.updateNote(custom);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult changeStatus(String[] ids) {
		customMapper.changeStatus(ids);
		return CustomResult.ok();
	}

	@Override
	public List<Custom> find() {
		CustomExample example = new CustomExample();
		return customMapper.selectByExample(example);
	}
}
