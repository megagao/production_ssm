package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.TechnologyPlan;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface TechnologyPlanService {
	
	List<TechnologyPlan> find();  
	
	EUDataGridResult getList(int page, int rows, TechnologyPlan technologyPlan);

	TechnologyPlan get(String string);
	
	/*
	CustomResult delete(String string);
	
	*/

	CustomResult deleteBatch(String[] ids);

	
	CustomResult insert(TechnologyPlan technologyPlan);
	
	/*
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Custom custom);
    */
	
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(TechnologyPlan technologyPlan);

	EUDataGridResult searchTechnologyPlanByTechnologyPlanId(Integer page,
			Integer rows, String technologyPlanId);

	EUDataGridResult searchTechnologyPlanByTechnologyName(Integer page,
			Integer rows, String technologyName);
}
