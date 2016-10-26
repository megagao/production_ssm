package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.Device;
import org.hqu.production_ms.domain.EUDataGridResult;

public interface DeviceService {
	
	EUDataGridResult getList(int page, int rows, Device device);
	
	Device get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(Device device);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Device device);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Device device);
    
    CustomResult updateNote(Device device);

    CustomResult changeStatus(String[] ids);
}
