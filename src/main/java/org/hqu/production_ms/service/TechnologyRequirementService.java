package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Technology;
import org.hqu.production_ms.domain.TechnologyRequirement;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface TechnologyRequirementService {
	
	List<Technology> find();  
	
	EUDataGridResult getList(int page, int rows, TechnologyRequirement technologyRequirement);

	TechnologyRequirement get(String string);
	
	/*
	CustomResult delete(String string);
	
	*/

	CustomResult deleteBatch(String[] ids);

	
	CustomResult insert(TechnologyRequirement technologyRequirement);
	
	/*
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Custom custom);
    */
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(TechnologyRequirement technologyRequirement);
    
    //更新要求
    CustomResult updateRequirement(TechnologyRequirement technologyRequirement);

	EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(
			Integer page, Integer rows, String technologyRequirementId);

	EUDataGridResult searchTechnologyRequirementByTechnologyName(Integer page,
			Integer rows, String technologyName);
}
