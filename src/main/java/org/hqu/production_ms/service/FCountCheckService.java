package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.FinalCountCheck;
import org.hqu.production_ms.domain.customize.CustomResult;
import org.hqu.production_ms.domain.customize.EUDataGridResult;

public interface FCountCheckService {
	
	EUDataGridResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck)
    		throws Exception;

	FinalCountCheck get(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(FinalCountCheck finalCountCheck) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(FinalCountCheck finalCountCheck) throws Exception;
    
    CustomResult updateNote(FinalCountCheck finalCountCheck) throws Exception;

	EUDataGridResult searchFCountCheckByOrderId(Integer page, Integer rows,
			String orderId) throws Exception;
	
	EUDataGridResult searchFCountCheckByFCountCheckId(int page, int rows, String fCountCheckId) 
			throws Exception;
}
