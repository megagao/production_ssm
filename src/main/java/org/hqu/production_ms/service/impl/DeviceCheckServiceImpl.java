package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.DeviceCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.DeviceCheckMapper;
import org.hqu.production_ms.service.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceCheckServiceImpl implements DeviceCheckService{

	@Autowired
	DeviceCheckMapper deviceCheckMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, DeviceCheck deviceCheck) {
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
	public DeviceCheck get(String id) {
		return deviceCheckMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public CustomResult insert(DeviceCheck deviceCheck) {
		int i = deviceCheckMapper.insert(deviceCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insertBatch(DeviceCheck[] deviceChecks) {
		for(int i=0;i<deviceChecks.length;i++){
			CustomResult customResult = this.insert(deviceChecks[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

	@Override
	public CustomResult delete(String deviceCheckId) {
		int i = deviceCheckMapper.deleteByPrimaryKey(deviceCheckId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceCheckIds) {
		int i = deviceCheckMapper.deleteBatch(deviceCheckIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceCheck deviceCheck) {
		int i = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateBatch(DeviceCheck[] deviceChecks) {
		for(int i=0;i<deviceChecks.length;i++){
			CustomResult customResult = this.update(deviceChecks[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

}
