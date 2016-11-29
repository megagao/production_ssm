package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.ProcessMeasureCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.COrderPO;
import org.hqu.production_ms.mapper.ProcessMeasureCheckMapper;
import org.hqu.production_ms.service.PMeasureCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PMeasureCheckServiceImpl implements PMeasureCheckService{

	@Autowired
	ProcessMeasureCheckMapper processMeasureCheckMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, ProcessMeasureCheck processMeasureCheck) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessMeasureCheck> list = processMeasureCheckMapper.find(processMeasureCheck);

		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public COrder get(String id) {
		return null;
		
//		return cOrderMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult delete(String id) {
		return null;
//		int i = cOrderMapper.deleteByPrimaryKey(id);
//		if(i>=0){
//			return CustomResult.ok();
//		}else{
//			return null;
//		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = processMeasureCheckMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(ProcessMeasureCheck processMeasureCheck) {
		int i = processMeasureCheckMapper.insert(processMeasureCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(COrderPO cOrder) {
		return null;
//		int i = cOrderMapper.updateByPrimaryKeySelective(cOrder);
//		if(i>=0){
//			return CustomResult.ok();
//		}else{
//			return null;
//		}
	}

	@Override
	public CustomResult updateAll(ProcessMeasureCheck processMeasureCheck) {
		int i = processMeasureCheckMapper.updateByPrimaryKey(processMeasureCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(ProcessMeasureCheck processMeasureCheck) {
		
		int i = processMeasureCheckMapper.updateNote(processMeasureCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public CustomResult changeStatus(String[] ids) {
		return null;
//		int i = cOrderMapper.changeStatus(ids);
//		if(i>=0){
//			return CustomResult.ok();
//		}else{
//			return null;
//		}
	}

	@Override
	public EUDataGridResult searchPMeasureCheckByPMeasureCheckId(int page,
			int rows, String pMeasureCheckId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessMeasureCheck> list = processMeasureCheckMapper.searchPMeasureCheckByPMeasureCheckId(pMeasureCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessMeasureCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
