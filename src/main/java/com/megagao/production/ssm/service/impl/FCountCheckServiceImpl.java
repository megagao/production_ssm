package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.FinalCountCheck;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.vo.FinalCountCheckVO;
import com.megagao.production.ssm.mapper.FinalCountCheckMapper;
import com.megagao.production.ssm.service.FCountCheckService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class FCountCheckServiceImpl implements FCountCheckService {

	@Autowired
    FinalCountCheckMapper finalCountCheckMapper;
	
	@Override
	public EUDataGridResult getList(Integer page, Integer rows, FinalCountCheck finalCountCheck)
			throws Exception{
		PageHelper.startPage(page, rows);
		List<FinalCountCheckVO> list = finalCountCheckMapper.find(finalCountCheck);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public FinalCountCheck get(String string) throws Exception{
		return finalCountCheckMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = finalCountCheckMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(FinalCountCheck finalCountCheck) throws Exception{
		System.out.println("hahahahahahh");
		int i = finalCountCheckMapper.insert(finalCountCheck);
		System.out.println("ddddddddddddd");
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增成品计数质检信息失败");
		}
	}

	@Override
	public CustomResult updateAll(FinalCountCheck finalCountCheck) throws Exception{
		int i = finalCountCheckMapper.updateByPrimaryKey(finalCountCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计数质检信息失败");
		}
	}

	@Override
	public CustomResult updateNote(FinalCountCheck finalCountCheck) throws Exception{
		
		int i = finalCountCheckMapper.updateNote(finalCountCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改成品计数质检备注失败");
		}
	}

	@Override
	public EUDataGridResult searchFCountCheckByFCountCheckId(int page,
			int rows, String fCountCheckId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalCountCheckVO> list = finalCountCheckMapper.searchFCountCheckByFCountCheckId(fCountCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchFCountCheckByOrderId(Integer page,
			Integer rows, String orderId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<FinalCountCheckVO> list = finalCountCheckMapper.searchFCountCheckByOrderId(orderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<FinalCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
