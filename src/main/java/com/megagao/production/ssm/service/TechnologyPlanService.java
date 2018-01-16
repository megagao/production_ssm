package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.TechnologyPlan;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface TechnologyPlanService {
	
	List<TechnologyPlan> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, TechnologyPlan technologyPlan) throws Exception;

	TechnologyPlan get(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;

	
	CustomResult insert(TechnologyPlan technologyPlan) throws Exception;
	
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(TechnologyPlan technologyPlan) throws Exception;

	EUDataGridResult searchTechnologyPlanByTechnologyPlanId(Integer page,
			Integer rows, String technologyPlanId) throws Exception;

	EUDataGridResult searchTechnologyPlanByTechnologyName(Integer page,
			Integer rows, String technologyName) throws Exception;
}
