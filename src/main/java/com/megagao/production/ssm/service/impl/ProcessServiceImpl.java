package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.Process;
import com.megagao.production.ssm.domain.ProcessExample;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.mapper.ProcessMapper;
import com.megagao.production.ssm.service.ProcessService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.mapper.TechnologyPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	TechnologyPlanMapper technologyPlanMapper;
	
	@Autowired
    ProcessMapper processMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Process process) throws Exception{
		//查询商品列表
		ProcessExample example = new ProcessExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Process> list = processMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Process> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Process get(String string) throws Exception{
		return processMapper.selectByPrimaryKey(string);
	}
	
	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = processMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Process process) throws Exception{
		int i = processMapper.insert(process);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增工序信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Process process) throws Exception{
		int i = processMapper.updateByPrimaryKey(process);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改工序信息失败");
		}
	}

	@Override
	public List<Process> find() throws Exception{
		ProcessExample example = new ProcessExample();
		return processMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchProcessByProcessId(Integer page,
			Integer rows, String processId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Process> list = processMapper.searchProcessByProcessId(processId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Process> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchProcessByTechnologyPlanId(Integer page,
			Integer rows, String technologyPlanId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<Process> list = processMapper.searchProcessByTechnologyPlanId(technologyPlanId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Process> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
