package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.DeviceFault;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceFaultService {

	//List
	EUDataGridResult getList(int page, int rows, DeviceFault deviceFault) throws Exception;
	
	//get
	DeviceFault get(String string) throws Exception;
	
	//find
	List<DeviceFault> find() throws Exception;

	//Insert
	CustomResult insert(DeviceFault deviceFault) throws Exception;
	
	//Delet
	CustomResult delete(String deviceFaultId) throws Exception;
	CustomResult deleteBatch(String[] deviceFaultIds) throws Exception;

	//Update
    CustomResult update(DeviceFault deviceFault) throws Exception;

	CustomResult updateNote(DeviceFault deviceFault) throws Exception;

	CustomResult updateAll(DeviceFault deviceFault) throws Exception;

	EUDataGridResult searchDeviceFaultByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId);

	EUDataGridResult searchDeviceFaultByDeviceName(Integer page, Integer rows,
			String deviceName);

}
