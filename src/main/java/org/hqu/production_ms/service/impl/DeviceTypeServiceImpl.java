package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.DeviceType;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.DeviceTypeMapper;
import org.hqu.production_ms.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService{

	@Autowired
	DeviceTypeMapper deviceTypeMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, DeviceType deviceType) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceType> list = deviceTypeMapper.find(deviceType);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult getList_Type() {

		List<DeviceType> list = deviceTypeMapper.listType();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		//取记录总条数
		PageInfo<DeviceType> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceType get(String id) {
		return deviceTypeMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public CustomResult insert(DeviceType deviceType) {
		int i = deviceTypeMapper.insert(deviceType);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insertBatch(DeviceType[] deviceTypes) {
		for(int i=0;i<deviceTypes.length;i++){
			CustomResult customResult = this.insert(deviceTypes[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

	@Override
	public CustomResult delete(String deviceTypeId) {
		int i = deviceTypeMapper.deleteByPrimaryKey(deviceTypeId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceTypeIds) {
		int i = deviceTypeMapper.deleteBatch(deviceTypeIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceType deviceType) {
		int i = deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateBatch(DeviceType[] deviceTypes) {
		for(int i=0;i<deviceTypes.length;i++){
			CustomResult customResult = this.update(deviceTypes[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

}
