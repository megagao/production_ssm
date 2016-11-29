package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.TechnologyPlan;
import org.hqu.production_ms.domain.TechnologyPlanExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.TechnologyMapper;
import org.hqu.production_ms.mapper.TechnologyPlanMapper;
import org.hqu.production_ms.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TechnologyPlanServiceImpl implements TechnologyPlanService{

	@Autowired
	TechnologyMapper technologyMapper;
	
	@Autowired
	TechnologyPlanMapper technologyPlanMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, TechnologyPlan technologyPlan) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyPlan> list = technologyPlanMapper.find(technologyPlan);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TechnologyPlan get(String string) {
		return technologyPlanMapper.selectByPrimaryKey(string);
	}
	/*
	@Override
	public CustomResult delete(String string) {
		int i = customMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	 */
	
	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = technologyPlanMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(TechnologyPlan technologyPlan) {
		int i = technologyPlanMapper.insert(technologyPlan);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
/*
	@Override
	public CustomResult update(Custom custom) {
		int i = customMapper.updateByPrimaryKeySelective(custom);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	*/
	@Override
	public CustomResult updateAll(TechnologyPlan technologyPlan) {
		int i = technologyPlanMapper.updateByPrimaryKey(technologyPlan);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
/*
	@Override
	public CustomResult updateNote(Custom custom) {
		int i = customMapper.updateNote(custom);
		if(i>0){
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
*/
	@Override
	public List<TechnologyPlan> find() {
		TechnologyPlanExample example = new TechnologyPlanExample();
		return technologyPlanMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchTechnologyPlanByTechnologyPlanId(
			Integer page, Integer rows, String technologyPlanId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<TechnologyPlan> list = technologyPlanMapper.searchTechnologyPlanByTechnologyPlanId(technologyPlanId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTechnologyPlanByTechnologyName(Integer page,
			Integer rows, String technologyName) {
		//分页处理
				PageHelper.startPage(page, rows);
				List<TechnologyPlan> list = technologyPlanMapper.searchTechnologyPlanByTechnologyName(technologyName);
				//创建一个返回值对象
				EUDataGridResult result = new EUDataGridResult();
				result.setRows(list);
				//取记录总条数
				PageInfo<TechnologyPlan> pageInfo = new PageInfo<>(list);
				result.setTotal(pageInfo.getTotal());
				return result;
	}
	
}
