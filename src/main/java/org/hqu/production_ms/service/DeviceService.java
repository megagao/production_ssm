package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Device;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DeviceService {

	//List
	EUDataGridResult getList(int page, int rows, Device device) throws Exception;
	
	//find
	List<Device> find() throws Exception;
	
	//get
	Device get(String string) throws Exception;
	/*List<Device> find() throws Exception;*/
	
	/*Device get(String string) throws Exception;*/

	//Insert
	CustomResult insert(Device device) throws Exception;
	
	//Delete
	CustomResult deleteBatch(String[] deviceIds) throws Exception;

	//Update Device
    CustomResult update(Device device) throws Exception;

    //Update Device.note
	CustomResult updateNote(Device device) throws Exception;

	//更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Device device) throws Exception;

	EUDataGridResult searchDeviceByDeviceId(Integer page, Integer rows,
			String deviceId);

	EUDataGridResult searchDeviceByDeviceName(Integer page, Integer rows,
			String deviceName);

	EUDataGridResult searchDeviceByDeviceTypeName(Integer page, Integer rows,
			String deviceTypeName);

}
