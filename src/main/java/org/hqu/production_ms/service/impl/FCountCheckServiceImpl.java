package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.FinalCountCheck;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.FinalCountCheckMapper;
import org.hqu.production_ms.service.FCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class FCountCheckServiceImpl implements FCountCheckService{

	@Autowired
	FinalCountCheckMapper finalCountCheckMapper; 
	
	@Override
	public EUDataGridResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck) {
		
		PageHelper.startPage(page, rows);
		List<FinalCountCheck> list = finalCountCheckMapper.find(finalCountCheck);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public FinalCountCheck get(String string) {
		return finalCountCheckMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = finalCountCheckMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(FinalCountCheck finalCountCheck) {
		System.out.println("hahahahahahh");
		int i = finalCountCheckMapper.insert(finalCountCheck);
		System.out.println("ddddddddddddd");
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(UnqualifyApply unqualify) {
		return null;
//		int i = unqualifyApplyMapper.updateByPrimaryKeySelective(unqualify);
//		if(i>=0){
//			return CustomResult.ok();
//		}else{
//			return null;
//		}
	}

	@Override
	public CustomResult updateAll(FinalCountCheck finalCountCheck) {
		int i = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(FinalCountCheck finalCountCheck) {
		
		int i = finalCountCheckMapper.updateNote(finalCountCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult changeStatus(String[] ids) {
		return null;
//		int i = unqualifyApplyMapper.changeStatus(ids);
//		if(i>=0){
//			return CustomResult.ok();
//		}else{
//			return null;
//		}
	}

	@Override
	public EUDataGridResult searchFCountCheckByFCountCheckId(int page,
			int rows, String fCountCheckId) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalCountCheck> list = finalCountCheckMapper.searchFCountCheckByFCountCheckId(fCountCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchFCountCheckByOrderId(Integer page,
			Integer rows, String orderId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalCountCheck> list = finalCountCheckMapper.searchFCountCheckByOrderId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	




	


}
