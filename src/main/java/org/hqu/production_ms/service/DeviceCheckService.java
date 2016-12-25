package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.DeviceCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceCheckService {

	
	//List
	EUDataGridResult getList(int page, int rows, DeviceCheck deviceCheck) throws Exception;
	
	//get
	DeviceCheck get(String string) throws Exception;

	//Insert
	CustomResult insert(DeviceCheck deviceCheck) throws Exception;
	
	//Delet
	CustomResult delete(String deviceCheckId) throws Exception;
	CustomResult deleteBatch(String[] deviceCheckIds) throws Exception;

	//Update
    CustomResult update(DeviceCheck deviceCheck) throws Exception;

    CustomResult updateNote(DeviceCheck deviceCheck) throws Exception;
    
	EUDataGridResult searchDeviceCheckByDeviceCheckId(Integer page,
			Integer rows, String deviceCheckId);

	EUDataGridResult searchDeviceCheckByDeviceName(Integer page, Integer rows,
			String deviceName);
}
