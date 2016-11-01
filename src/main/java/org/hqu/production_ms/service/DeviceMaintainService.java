package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.DeviceMaintain;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceMaintainService {
	
	//List
	EUDataGridResult getList(int page, int rows, DeviceMaintain deviceMaintain);
	DeviceMaintain get(String string);
	
	//Insert
	CustomResult insert(DeviceMaintain deviceMaintain);
	CustomResult insertBatch(DeviceMaintain[] deviceMaintains);
	
	//Delet
	CustomResult delete(String deviceMaintainId);
	CustomResult deleteBatch(String[] deviceMaintainIds);

	//Update
    CustomResult update(DeviceMaintain deviceMaintain);
    CustomResult updateBatch(DeviceMaintain[] deviceMaintains);
    
}
