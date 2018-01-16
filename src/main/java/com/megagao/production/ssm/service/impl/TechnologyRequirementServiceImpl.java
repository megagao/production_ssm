package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.vo.TechnologyRequirementVO;
import com.megagao.production.ssm.mapper.TechnologyMapper;
import com.megagao.production.ssm.service.TechnologyRequirementService;
import com.megagao.production.ssm.domain.Technology;
import com.megagao.production.ssm.domain.TechnologyExample;
import com.megagao.production.ssm.domain.TechnologyRequirement;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.mapper.TechnologyRequirementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TechnologyRequirementServiceImpl implements TechnologyRequirementService {

	@Autowired
    TechnologyMapper technologyMapper;
	
	@Autowired
	TechnologyRequirementMapper technologyRequirementMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, TechnologyRequirement technologyRequirement) 
			throws Exception{
		System.out.println("fff");
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyRequirementVO> list = technologyRequirementMapper.find(technologyRequirement);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TechnologyRequirement get(String string) throws Exception{
		return technologyRequirementMapper.selectByPrimaryKey(string);
	}
	
	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = technologyRequirementMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(TechnologyRequirement technologyRequirement) throws Exception{
		int i = technologyRequirementMapper.insert(technologyRequirement);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工艺要求信息失败");
		}
	}

	@Override
	public CustomResult updateAll(TechnologyRequirement technologyRequirement) throws Exception{
		int i = technologyRequirementMapper.updateByPrimaryKey(technologyRequirement);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工艺要求信息失败");
		}
	}

	@Override
	public CustomResult updateRequirement(TechnologyRequirement technologyRequirement) 
			throws Exception{
System.out.println("updateRequirement_service:");
System.out.println(technologyRequirement.getRequirement());
		int i = technologyRequirementMapper.updateRequirement(technologyRequirement);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工艺要求失败");
		}
	}

	@Override
	public List<Technology> find() throws Exception{
		TechnologyExample example = new TechnologyExample();
		return technologyMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(
			Integer page, Integer rows, String technologyRequirementId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyRequirementVO> list = technologyRequirementMapper
				.searchTechnologyRequirementByTechnologyRequirementId(technologyRequirementId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTechnologyRequirementByTechnologyName(
			Integer page, Integer rows, String technologyName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyRequirementVO> list = technologyRequirementMapper
				.searchTechnologyRequirementByTechnologyName(technologyName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyRequirementVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
