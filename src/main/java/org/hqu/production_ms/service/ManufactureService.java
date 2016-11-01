package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.Manufacture;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.ManufacturePO;

public interface ManufactureService {
	
	EUDataGridResult getList(int page, int rows);
	
	Manufacture get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(ManufacturePO manufacture);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(ManufacturePO manufacture);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(ManufacturePO manufacture);
    
}
