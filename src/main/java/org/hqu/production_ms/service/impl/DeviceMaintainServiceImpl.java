package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.DeviceMaintain;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.DeviceMaintainMapper;
import org.hqu.production_ms.service.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DeviceMaintainServiceImpl implements DeviceMaintainService{

	@Autowired
	DeviceMaintainMapper deviceMaintainMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, DeviceMaintain deviceMaintain) {
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
	public DeviceMaintain get(String id) {
		return deviceMaintainMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public CustomResult insert(DeviceMaintain deviceMaintain) {
		int i = deviceMaintainMapper.insert(deviceMaintain);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insertBatch(DeviceMaintain[] deviceMaintains) {
		for(int i=0;i<deviceMaintains.length;i++){
			CustomResult customResult = this.insert(deviceMaintains[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

	@Override
	public CustomResult delete(String deviceMaintainId) {
		int i = deviceMaintainMapper.deleteByPrimaryKey(deviceMaintainId);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] deviceMaintainIds) {
		int i = deviceMaintainMapper.deleteBatch(deviceMaintainIds);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(DeviceMaintain deviceMaintain) {
		int i = deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateBatch(DeviceMaintain[] deviceMaintains) {
		for(int i=0;i<deviceMaintains.length;i++){
			CustomResult customResult = this.update(deviceMaintains[i]);
		}
		//  ？？ 再改
		return CustomResult.ok();
	}

}
