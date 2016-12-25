package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.FinalCountCheck;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface FCountCheckService {

	EUDataGridResult searchFCountCheckByFCountCheckId(int page, int rows, String fCountCheckId) 
			throws Exception;
	
	FinalCountCheck get(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(FinalCountCheck finalCountCheck) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UnqualifyApply unqualify) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(FinalCountCheck finalCountCheck) throws Exception;
    
    CustomResult updateNote(FinalCountCheck finalCountCheck) throws Exception;

    CustomResult changeStatus(String[] ids) throws Exception;
    
    EUDataGridResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck)
    		throws Exception;

	EUDataGridResult searchFCountCheckByOrderId(Integer page, Integer rows,
			String orderId) throws Exception;
}
