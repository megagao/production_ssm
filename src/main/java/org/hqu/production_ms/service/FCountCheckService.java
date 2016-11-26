package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.FinalCountCheck;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface FCountCheckService {

	EUDataGridResult searchFCountCheckByFCountCheckId(int page, int rows, String fCountCheckId);
	
	FinalCountCheck get(String string);
	
	CustomResult deleteBatch(String[] ids);

	CustomResult insert(FinalCountCheck finalCountCheck);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UnqualifyApply unqualify);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(FinalCountCheck finalCountCheck);
    
    CustomResult updateNote(FinalCountCheck finalCountCheck);

    CustomResult changeStatus(String[] ids);
    
    EUDataGridResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck);

	EUDataGridResult searchFCountCheckByOrderId(Integer page, Integer rows,
			String orderId);
}
