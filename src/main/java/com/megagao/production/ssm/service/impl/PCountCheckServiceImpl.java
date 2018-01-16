package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.ProcessCountCheck;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.mapper.ProcessCountCheckMapper;
import com.megagao.production.ssm.service.PCountCheckService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.vo.ProcessCountCheckVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PCountCheckServiceImpl implements PCountCheckService {

	@Autowired
    ProcessCountCheckMapper processCountCheckMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, ProcessCountCheck processCountCheck) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessCountCheckVO> list = processCountCheckMapper.find(processCountCheck);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = processCountCheckMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(ProcessCountCheck processCountCheck) throws Exception{
		int i = processCountCheckMapper.insert(processCountCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工序计数质检信息失败");
		}
	}

	@Override
	public CustomResult updateAll(ProcessCountCheck processCountCheck) throws Exception{
		int i = processCountCheckMapper.updateByPrimaryKey(processCountCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工序计数质检信息失败");
		}
	}

	@Override
	public CustomResult updateNote(ProcessCountCheck processCountCheck) throws Exception{
		
		int i = processCountCheckMapper.updateNote(processCountCheck);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工序计数质检备注失败");
		}
	}

	@Override
	public EUDataGridResult searchPCountCheckByPCountCheckId(int page,
			int rows, String pCountCheckId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<ProcessCountCheckVO> list = processCountCheckMapper.searchPCountCheckByPCountCheckId(pCountCheckId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ProcessCountCheckVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
