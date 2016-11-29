package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.FinalMeasuretCheck;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.FinalMeasuretCheckMapper;
import org.hqu.production_ms.service.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MeasureServiceImpl implements MeasureService{

	@Autowired
	FinalMeasuretCheckMapper finalMeasuretCheckMapper; 
	
	@Override
	public EUDataGridResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasuretCheck) {
		
		PageHelper.startPage(page, rows);
		
		List<FinalMeasuretCheck> list = finalMeasuretCheckMapper.find(finalMeasuretCheck);

		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public FinalMeasuretCheck get(String string) {
		return finalMeasuretCheckMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		return null;
//		int i = unqualifyApplyMapper.deleteByPrimaryKey(string);
//		if(i>=0){
//			return CustomResult.ok();
//		}else{
//			return null;
//		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = finalMeasuretCheckMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(FinalMeasuretCheck finalMeasuretCheck) {
		System.out.println("hahahahahahh");
		int i = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
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
	public CustomResult updateAll(FinalMeasuretCheck finalMeasuretCheck) {
		int i = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(FinalMeasuretCheck finalMeasuretCheck) {
		
		int i = finalMeasuretCheckMapper.updateNote(finalMeasuretCheck);
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
	public EUDataGridResult searchFMeasureCheckByFMeasureCheckId(int page,
		int rows, String fMeasureCheckId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheck> list = finalMeasuretCheckMapper.searchFMeasureCheckByFMeasureCheckId(fMeasureCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchFMeasureCheckByOrderId(Integer page,
			Integer rows, String orderId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheck> list = finalMeasuretCheckMapper.searchFMeasureCheckByOrderId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheck> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
