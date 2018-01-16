package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.DeviceType;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface DeviceTypeService {
	
	EUDataGridResult getList(int page, int rows, DeviceType deviceType) throws Exception;
	
	DeviceType get(String string) throws Exception;
	
	List<DeviceType> find() throws Exception;
	
	CustomResult insert(DeviceType deviceType) throws Exception;
	
	CustomResult deleteBatch(String[] deviceTypeIds) throws Exception;

    CustomResult update(DeviceType deviceType) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(DeviceType deviceType) throws Exception;

	EUDataGridResult searchDeviceTypeByDeviceTypeId(Integer page, Integer rows,
			String deviceTypeId) throws Exception;

	EUDataGridResult searchDeviceTypeByDeviceTypeName(Integer page,
			Integer rows, String deviceTypeName) throws Exception;
}
