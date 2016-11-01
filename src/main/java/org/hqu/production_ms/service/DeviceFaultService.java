package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.DeviceFault;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceFaultService {
	
	//List
	EUDataGridResult getList(int page, int rows, DeviceFault deviceFault);
	DeviceFault get(String string);
	
	//List_FaultId
	EUDataGridResult getList_FaultId();

	//Insert
	CustomResult insert(DeviceFault deviceFault);
	CustomResult insertBatch(DeviceFault[] deviceFaults);
	
	//Delet
	CustomResult delete(String deviceFaultId);
	CustomResult deleteBatch(String[] deviceFaultIds);

	//Update
    CustomResult update(DeviceFault deviceFault);
    CustomResult updateBatch(DeviceFault[] deviceFaults);
    
}
