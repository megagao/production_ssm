package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.DeviceCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceCheckService {

	
	//List
	EUDataGridResult getList(int page, int rows, DeviceCheck deviceCheck);
	DeviceCheck get(String string);

	//Insert
	CustomResult insert(DeviceCheck deviceCheck);
	CustomResult insertBatch(DeviceCheck[] deviceChecks);
	
	//Delet
	CustomResult delete(String deviceCheckId);
	CustomResult deleteBatch(String[] deviceCheckIds);

	//Update
    CustomResult update(DeviceCheck deviceCheck);
    CustomResult updateBatch(DeviceCheck[] deviceChecks);
    
}
