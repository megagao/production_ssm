package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Device;
import org.hqu.production_ms.domain.DeviceType;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.DeviceMapper;
import org.hqu.production_ms.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	DeviceMapper deviceMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Device device) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Device> list = deviceMapper.find(device);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult getList_Name() {

		List<Device> list = deviceMapper.listName();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		//取记录总条数
		PageInfo<Device> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult getList_Type() {

		List<DeviceType> list = deviceMapper.listType();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		//取记录总条数
		PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public Device get(String id) {
		return deviceMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public CustomResult insert(Device device) {
		int i = deviceMapper.insert(device);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insertBatch(Device[] devices) {
		for(int i=0;i<devices.length;i++){
			CustomResult customResult = this.insert(devices[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

	@Override
	public CustomResult delete(String deviceId) {
		int i = deviceMapper.deleteByPrimaryKey(deviceId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceIds) {
		int i = deviceMapper.deleteBatch(deviceIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(Device device) {
		int i = deviceMapper.updateByPrimaryKeySelective(device);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateBatch(Device[] devices) {
		for(int i=0;i<devices.length;i++){
			CustomResult customResult = this.update(devices[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

}
