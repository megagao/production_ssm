package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.Technology;
import com.megagao.production.ssm.domain.TechnologyRequirement;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface TechnologyRequirementService {
	
	List<Technology> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, TechnologyRequirement technologyRequirement)
			throws Exception;

	TechnologyRequirement get(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;

	
	CustomResult insert(TechnologyRequirement technologyRequirement) throws Exception;
	
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(TechnologyRequirement technologyRequirement) throws Exception;
    
    //更新要求
    CustomResult updateRequirement(TechnologyRequirement technologyRequirement) 
    		throws Exception;

	EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(
			Integer page, Integer rows, String technologyRequirementId) throws Exception;

	EUDataGridResult searchTechnologyRequirementByTechnologyName(Integer page,
			Integer rows, String technologyName) throws Exception;
}
