package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.vo.WorkVO;
import com.megagao.production.ssm.domain.WorkExample;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.Work;
import com.megagao.production.ssm.mapper.WorkMapper;
import com.megagao.production.ssm.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class WorkServiceImpl implements WorkService{

	@Autowired
	WorkMapper workMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, WorkVO work) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<WorkVO> list = workMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public WorkVO get(String string) throws Exception{
		return workMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception{
		int i = workMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = workMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Work work) throws Exception{
		int i = workMapper.insert(work);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增作业信息失败");
		}
	}

	@Override
	public CustomResult update(Work work) throws Exception{
		int i = workMapper.updateByPrimaryKeySelective(work);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改作业信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Work work) throws Exception{
		int i = workMapper.updateByPrimaryKey(work);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改作业信息失败");
		}
	}

	@Override
	public List<WorkVO> find() throws Exception{
		WorkExample example = new WorkExample();
		return workMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchWorkByWorkId(Integer page, Integer rows,
			String workId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<WorkVO> list = workMapper.searchWorkByWorkId(workId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchWorkByWorkProduct(Integer page, Integer rows,
			String workProduct) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<WorkVO> list = workMapper.searchWorkByWorkProduct(workProduct);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchWorkByWorkDevice(Integer page, Integer rows,
			String workDevice) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<WorkVO> list = workMapper.searchWorkByWorkDevice(workDevice);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchWorkByWorkProcess(Integer page, Integer rows,
			String workProcess) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<WorkVO> list = workMapper.searchWorkByWorkProcess(workProcess);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<WorkVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
