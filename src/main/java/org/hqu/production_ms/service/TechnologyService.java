package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Technology;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface TechnologyService {
	
	List<Technology> find();  
	
	EUDataGridResult getList(int page, int rows, Technology technology);

	Technology get(String string);
	
	/*
	CustomResult delete(String string);
	
	*/

	CustomResult deleteBatch(String[] ids);

	
	CustomResult insert(Technology technology);
	
	/*
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Custom custom);
    */
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Technology technology);
    /*
    //更新备注
    CustomResult updateNote(Custom custom);


    CustomResult changeStatus(String[] ids);
    */

	EUDataGridResult searchTechnologyByTechnologyId(Integer page, Integer rows,
			String technologyId);

	EUDataGridResult searchTechnologyByTechnologyName(Integer page,
			Integer rows, String technologyName);

}
