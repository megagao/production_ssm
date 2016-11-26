package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.ProcessMeasureCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.COrderPO;

public interface PMeasureCheckService {
	
	EUDataGridResult searchPMeasureCheckByPMeasureCheckId(int page, int rows, String pMeasureCheckId);
	
	EUDataGridResult getList(int page, int rows, ProcessMeasureCheck processMeasureCheck);
	
	COrder get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(ProcessMeasureCheck processMeasureCheck);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(COrderPO cOrder);
    
    //更新全部字段，不判断非空，直接进行更新
    //CustomResult updateAll(PMeasureCheckService pMeasureCheckService);
    
    CustomResult updateNote(ProcessMeasureCheck processMeasureCheck);

    CustomResult changeStatus(String[] ids);

	CustomResult updateAll(ProcessMeasureCheck processMeasureCheck);
}
