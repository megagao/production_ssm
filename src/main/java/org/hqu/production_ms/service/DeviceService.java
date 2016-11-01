package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.Device;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceService {

	
	//List
	EUDataGridResult getList(int page, int rows, Device device);
	Device get(String string);

	//List_Name
	EUDataGridResult getList_Name();
	//List_Type
	EUDataGridResult getList_Type();

	//Insert
	CustomResult insert(Device device);
	CustomResult insertBatch(Device[] devices);
	
	//Delet
	CustomResult delete(String deviceId);
	CustomResult deleteBatch(String[] deviceIds);

	//Update
    CustomResult update(Device device);
    CustomResult updateBatch(Device[] devices);
    
}
