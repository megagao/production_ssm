package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.FinalMeasuretCheck;
import org.hqu.production_ms.domain.customize.CustomResult;
import org.hqu.production_ms.domain.customize.EUDataGridResult;
import org.hqu.production_ms.domain.vo.FinalMeasuretCheckVO;
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
	public EUDataGridResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasuretCheck) throws Exception{
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.find(finalMeasuretCheck);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public FinalMeasuretCheck get(String string) throws Exception{
		return finalMeasuretCheckMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = finalMeasuretCheckMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(FinalMeasuretCheck finalMeasuretCheck) throws Exception{
		System.out.println("hahahahahahh");
		int i = finalMeasuretCheckMapper.insert(finalMeasuretCheck);
		System.out.println("ddddddddddddd");
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增成品计量质检信息失败");
		}
	}

	@Override
	public CustomResult updateAll(FinalMeasuretCheck finalMeasuretCheck) throws Exception{
		int i = finalMeasuretCheckMapper.updateByPrimaryKey(finalMeasuretCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计量质检信息失败");
		}
	}

	@Override
	public CustomResult updateNote(FinalMeasuretCheck finalMeasuretCheck) throws Exception{
		
		int i = finalMeasuretCheckMapper.updateNote(finalMeasuretCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计量质检备注失败");
		}
	}

	@Override
	public EUDataGridResult searchFMeasureCheckByFMeasureCheckId(int page,
		int rows, String fMeasureCheckId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.searchFMeasureCheckByFMeasureCheckId(fMeasureCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchFMeasureCheckByOrderId(Integer page,
			Integer rows, String orderId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalMeasuretCheckVO> list = finalMeasuretCheckMapper.searchFMeasureCheckByOrderId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalMeasuretCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
