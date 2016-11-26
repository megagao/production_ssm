package org.hqu.production_ms.service;


import org.hqu.production_ms.domain.FinalMeasuretCheck;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface MeasureService {
	EUDataGridResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasuretCheck);

	FinalMeasuretCheck get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(FinalMeasuretCheck finalMeasuretCheck);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UnqualifyApply unqualify);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(FinalMeasuretCheck finalMeasuretCheck);
    
    CustomResult updateNote(FinalMeasuretCheck finalMeasuretCheck);

    CustomResult changeStatus(String[] ids);

    EUDataGridResult searchFMeasureCheckByFMeasureCheckId(int page, int rows, String fMeasureCheckId);
    
	EUDataGridResult searchFMeasureCheckByOrderId(Integer page, Integer rows,
			String orderId);
}
