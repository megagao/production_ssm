package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.ProcessCountCheck;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.COrderPO;
import org.hqu.production_ms.mapper.ProcessCountCheckMapper;
import org.hqu.production_ms.service.PCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PCountCheckServiceImpl implements PCountCheckService{

	@Autowired
	ProcessCountCheckMapper processCountCheckMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, ProcessCountCheck processCountCheck) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessCountCheck> list = processCountCheckMapper.find(processCountCheck);

		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(list);
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
		int i = processCountCheckMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(ProcessCountCheck processCountCheck) {
		int i = processCountCheckMapper.insert(processCountCheck);
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
	public CustomResult updateAll(ProcessCountCheck processCountCheck) {
		int i = processCountCheckMapper.updateByPrimaryKey(processCountCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(ProcessCountCheck processCountCheck) {
		
		int i = processCountCheckMapper.updateNote(processCountCheck);
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
	public EUDataGridResult searchPCountCheckByPCountCheckId(int page,
			int rows, String pCountCheckId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessCountCheck> list = processCountCheckMapper.searchPCountCheckByPCountCheckId(pCountCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessCountCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}



	
}
