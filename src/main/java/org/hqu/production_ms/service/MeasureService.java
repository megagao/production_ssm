package org.hqu.production_ms.service;


import org.hqu.production_ms.domain.FinalMeasuretCheck;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface MeasureService {
	EUDataGridResult getList(Integer page, Integer rows, FinalMeasuretCheck 
			finalMeasuretCheck) throws Exception;

	FinalMeasuretCheck get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(FinalMeasuretCheck finalMeasuretCheck) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UnqualifyApply unqualify) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(FinalMeasuretCheck finalMeasuretCheck) throws Exception;
    
    CustomResult updateNote(FinalMeasuretCheck finalMeasuretCheck) throws Exception;

    CustomResult changeStatus(String[] ids) throws Exception;

    EUDataGridResult searchFMeasureCheckByFMeasureCheckId(int page, int rows, 
    		String fMeasureCheckId) throws Exception;
    
	EUDataGridResult searchFMeasureCheckByOrderId(Integer page, Integer rows,
			String orderId) throws Exception;
}
