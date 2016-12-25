package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Technology;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface TechnologyService {
	
	List<Technology> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Technology technology) throws Exception;

	Technology get(String string) throws Exception;
	
	/*
	CustomResult delete(String string) throws Exception;
	
	*/

	CustomResult deleteBatch(String[] ids) throws Exception;

	
	CustomResult insert(Technology technology) throws Exception;
	
	/*
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Custom custom) throws Exception;
    */
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Technology technology) throws Exception;
    /*
    //更新备注
    CustomResult updateNote(Custom custom) throws Exception;


    CustomResult changeStatus(String[] ids) throws Exception;
    */

	EUDataGridResult searchTechnologyByTechnologyId(Integer page, Integer rows,
			String technologyId) throws Exception;

	EUDataGridResult searchTechnologyByTechnologyName(Integer page,
			Integer rows, String technologyName) throws Exception;

}
