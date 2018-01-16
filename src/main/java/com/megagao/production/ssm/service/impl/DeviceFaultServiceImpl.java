package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.DeviceFault;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.mapper.DeviceFaultMapper;
import com.megagao.production.ssm.service.DeviceFaultService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.vo.DeviceFaultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService {

	@Autowired
    DeviceFaultMapper deviceFaultMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, DeviceFault deviceFault) throws Exception {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceFaultVO> list = deviceFaultMapper.find(deviceFault);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceFaultVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceFault get(String id) throws Exception {
		return deviceFaultMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<DeviceFault> find() throws Exception {
		List<DeviceFault> list = deviceFaultMapper.getData();
		return list;
	}
	
	@Override
	public CustomResult insert(DeviceFault deviceFault) throws Exception {
		int i = deviceFaultMapper.insert(deviceFault);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备故障失败");
		}
	}

	@Override
	public CustomResult delete(String deviceFaultId) throws Exception {
		int i = deviceFaultMapper.deleteByPrimaryKey(deviceFaultId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceFaultIds) throws Exception {
		int i = deviceFaultMapper.deleteBatch(deviceFaultIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceFault deviceFault) throws Exception {
		int i = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备故障信息失败");
		}
	}

	@Override
	public CustomResult updateNote(DeviceFault deviceFault) throws Exception {
		int i = deviceFaultMapper.updateNote(deviceFault);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增设备故障备注失败");
		}
	}

	@Override
	public CustomResult updateAll(DeviceFault deviceFault) throws Exception {
		int i = deviceFaultMapper.updateByPrimaryKey(deviceFault);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改设备故障信息失败");
		}
	}

	@Override
	public EUDataGridResult searchDeviceFaultByDeviceFaultId(Integer page,
			Integer rows, String deviceFaultId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceFault> list = deviceFaultMapper.searchDeviceFaultByDeviceFaultId(deviceFaultId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceFault> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchDeviceFaultByDeviceName(Integer page,
			Integer rows, String deviceName) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceFault> list = deviceFaultMapper.searchDeviceFaultByDeviceName(deviceName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceFault> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
