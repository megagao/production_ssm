package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.DeviceFault;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.DeviceFaultMapper;
import org.hqu.production_ms.service.DeviceFaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceFaultServiceImpl implements DeviceFaultService{

	@Autowired
	DeviceFaultMapper deviceFaultMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, DeviceFault deviceFault) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<DeviceFault> list = deviceFaultMapper.find(deviceFault);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<DeviceFault> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public DeviceFault get(String id) {
		return deviceFaultMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public EUDataGridResult getList_FaultId() {

		List<DeviceFault> list = deviceFaultMapper.listFaultId();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		//取记录总条数
		PageInfo<DeviceFault> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	
	@Override
	public CustomResult insert(DeviceFault deviceFault) {
		int i = deviceFaultMapper.insert(deviceFault);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insertBatch(DeviceFault[] deviceFaults) {
		for(int i=0;i<deviceFaults.length;i++){
			CustomResult customResult = this.insert(deviceFaults[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

	@Override
	public CustomResult delete(String deviceFaultId) {
		int i = deviceFaultMapper.deleteByPrimaryKey(deviceFaultId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceFaultIds) {
		int i = deviceFaultMapper.deleteBatch(deviceFaultIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceFault deviceFault) {
		int i = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateBatch(DeviceFault[] deviceFaults) {
		for(int i=0;i<deviceFaults.length;i++){
			CustomResult customResult = this.update(deviceFaults[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

}
