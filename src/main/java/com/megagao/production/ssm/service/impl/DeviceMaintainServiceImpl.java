package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.DeviceMaintain;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.mapper.DeviceMaintainMapper;
import com.megagao.production.ssm.service.DeviceMaintainService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService {

	@Autowired
    DeviceMaintainMapper deviceMaintainMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, DeviceMaintain deviceMaintain) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceMaintain> list = deviceMaintainMapper.find(deviceMaintain);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceMaintain get(String id) throws Exception {
		return deviceMaintainMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult insert(DeviceMaintain deviceMaintain) throws Exception {
		int i = deviceMaintainMapper.insert(deviceMaintain);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备维修信息失败");
		}
	}

	@Override
	public CustomResult delete(String deviceMaintainId) throws Exception {
		int i = deviceMaintainMapper.deleteByPrimaryKey(deviceMaintainId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceMaintainIds) throws Exception {
		int i = deviceMaintainMapper.deleteBatch(deviceMaintainIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceMaintain deviceMaintain) throws Exception {
		int i = deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备维修信息失败");
		}
	}

	@Override
	public CustomResult updateNote(DeviceMaintain deviceMaintain) throws Exception {
		int i = deviceMaintainMapper.updateNote(deviceMaintain);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备维修备注失败");
		}
	}

	@Override
	public EUDataGridResult searchDeviceMaintainByDeviceMaintainId(
			Integer page, Integer rows, String deviceMaintainId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceMaintain> list = deviceMaintainMapper.searchDeviceMaintainByDeviceMaintainId(deviceMaintainId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceMaintain> list = deviceMaintainMapper.searchDeviceMaintainByDeviceFaultId(deviceFaultId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceMaintain> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
