package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Technology;
import org.hqu.production_ms.domain.TechnologyExample;
import org.hqu.production_ms.domain.customize.CustomResult;
import org.hqu.production_ms.domain.customize.EUDataGridResult;
import org.hqu.production_ms.mapper.TechnologyMapper;
import org.hqu.production_ms.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TechnologyServiceImpl implements TechnologyService{

	@Autowired
	TechnologyMapper technologyMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Technology technology) throws Exception{
		//查询工艺列表
		TechnologyExample example = new TechnologyExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Technology> list = technologyMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Technology> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Technology get(String string) throws Exception{
		return technologyMapper.selectByPrimaryKey(string);
	}
	
	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = technologyMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Technology technology) throws Exception{
		int i = technologyMapper.insert(technology);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工艺信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Technology technology) throws Exception{
		int i = technologyMapper.updateByPrimaryKey(technology);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工艺信息失败");
		}
	}
	
	@Override
	public List<Technology> find() throws Exception{
		TechnologyExample example = new TechnologyExample();
		return technologyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchTechnologyByTechnologyId(Integer page,
			Integer rows, String technologyId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Technology> list = technologyMapper.searchTechnologyByTechnologyId(technologyId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Technology> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTechnologyByTechnologyName(Integer page,
			Integer rows, String technologyName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Technology> list = technologyMapper.searchTechnologyByTechnologyName(technologyName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Technology> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
