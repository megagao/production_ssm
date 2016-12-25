package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.DeviceMaintain;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceMaintainService {

	//List
	EUDataGridResult getList(int page, int rows, DeviceMaintain deviceMaintain) throws Exception;
	
	//get
	DeviceMaintain get(String string) throws Exception;
	
	//Insert
	CustomResult insert(DeviceMaintain deviceMaintain) throws Exception;
	
	//Delet
	CustomResult delete(String deviceMaintainId) throws Exception;
	CustomResult deleteBatch(String[] deviceMaintainIds) throws Exception;

	//Update
    CustomResult update(DeviceMaintain deviceMaintain) throws Exception;

	CustomResult updateNote(DeviceMaintain deviceMaintain) throws Exception;

	EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page,
			Integer rows, String deviceMaintainId);

	EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId);

}
