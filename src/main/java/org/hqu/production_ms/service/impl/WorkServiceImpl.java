package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Work;
import org.hqu.production_ms.domain.WorkExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.WorkPO;
import org.hqu.production_ms.mapper.WorkMapper;
import org.hqu.production_ms.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class WorkServiceImpl implements WorkService{

	@Autowired
	WorkMapper workMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Work work) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Work> list = workMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Work> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Work get(String string) {
		
		return workMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		int i = workMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = workMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(WorkPO work) {
		int i = workMapper.insert(work);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(WorkPO work) {
		int i = workMapper.updateByPrimaryKeySelective(work);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(WorkPO work) {
		int i = workMapper.updateByPrimaryKey(work);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public List<Work> find() {
		WorkExample example = new WorkExample();
		return workMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchWorkByWorkId(Integer page, Integer rows,
			String workId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Work> list = workMapper.searchWorkByWorkId(workId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Work> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchWorkByWorkProduct(Integer page, Integer rows,
			String workProduct) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Work> list = workMapper.searchWorkByWorkProduct(workProduct);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Work> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchWorkByWorkDevice(Integer page, Integer rows,
			String workDevice) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Work> list = workMapper.searchWorkByWorkDevice(workDevice);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Work> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchWorkByWorkProcess(Integer page, Integer rows,
			String workProcess) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Work> list = workMapper.searchWorkByWorkProcess(workProcess);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Work> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


}
