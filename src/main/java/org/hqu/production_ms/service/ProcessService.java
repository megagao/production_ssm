package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Process;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface ProcessService {
	
	List<Process> find();  
	
	EUDataGridResult getList(int page, int rows, Process process);

	Process get(String string);
	
	/*
	CustomResult delete(String string);
	
	*/

	CustomResult deleteBatch(String[] ids);

	
	CustomResult insert(Process process);
	
	/*
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Custom custom);
    */
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Process process);
    /*
    //更新要求
    CustomResult updateRequirement(Process process);

   
    CustomResult changeStatus(String[] ids);
    */

	EUDataGridResult searchProcessByProcessId(Integer page, Integer rows,
			String processId);

	EUDataGridResult searchProcessByTechnologyPlanId(Integer page,
			Integer rows, String technologyPlanId);
}
