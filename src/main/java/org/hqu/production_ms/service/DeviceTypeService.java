package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.DeviceType;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceTypeService {

	
	//List
	EUDataGridResult getList(int page, int rows, DeviceType deviceType);
	DeviceType get(String string);

	//List_Type
	EUDataGridResult getList_Type();

	//Insert
	CustomResult insert(DeviceType deviceType);
	CustomResult insertBatch(DeviceType[] deviceTypes);
	
	//Delet
	CustomResult delete(String deviceTypeId);
	CustomResult deleteBatch(String[] deviceTypeIds);

	//Update
    CustomResult update(DeviceType deviceType);
    CustomResult updateBatch(DeviceType[] deviceTypes);
    
}
