package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.TechnologyPlan;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface TechnologyPlanService {
	
	List<TechnologyPlan> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, TechnologyPlan technologyPlan) throws Exception;

	TechnologyPlan get(String string) throws Exception;
	
	/*
	CustomResult delete(String string) throws Exception;
	
	*/

	CustomResult deleteBatch(String[] ids) throws Exception;

	
	CustomResult insert(TechnologyPlan technologyPlan) throws Exception;
	
	/*
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Custom custom) throws Exception;
    */
	
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(TechnologyPlan technologyPlan) throws Exception;

	EUDataGridResult searchTechnologyPlanByTechnologyPlanId(Integer page,
			Integer rows, String technologyPlanId) throws Exception;

	EUDataGridResult searchTechnologyPlanByTechnologyName(Integer page,
			Integer rows, String technologyName) throws Exception;
}
