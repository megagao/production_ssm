package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.mapper.DeviceCheckMapper;
import com.megagao.production.ssm.domain.DeviceCheck;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.service.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService{

	@Autowired
    DeviceCheckMapper deviceCheckMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, DeviceCheck deviceCheck) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceCheck> list = deviceCheckMapper.find(deviceCheck);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceCheck get(String id) throws Exception {
		return deviceCheckMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public CustomResult insert(DeviceCheck deviceCheck) throws Exception {
		int i = deviceCheckMapper.insert(deviceCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备例检失败");
		}
	}

	@Override
	public CustomResult delete(String deviceCheckId) throws Exception {
		int i = deviceCheckMapper.deleteByPrimaryKey(deviceCheckId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceCheckIds) throws Exception {
		int i = deviceCheckMapper.deleteBatch(deviceCheckIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceCheck deviceCheck) throws Exception {
		int i = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备例检失败");
		}
	}

	@Override
	public EUDataGridResult searchDeviceCheckByDeviceCheckId(Integer page,
			Integer rows, String deviceCheckId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceCheck> list = deviceCheckMapper.searchDeviceCheckByDeviceCheckId(deviceCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchDeviceCheckByDeviceName(Integer page,
			Integer rows, String deviceName) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceCheck> list = deviceCheckMapper.searchDeviceCheckByDeviceName(deviceName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CustomResult updateNote(DeviceCheck deviceCheck) throws Exception {
		int i = deviceCheckMapper.updateNote(deviceCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改例检结果失败");
		}
	}
}
