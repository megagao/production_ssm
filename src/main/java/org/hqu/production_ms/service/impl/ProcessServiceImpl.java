package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Process;
import org.hqu.production_ms.domain.ProcessExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.TechnologyPlanMapper;
import org.hqu.production_ms.mapper.ProcessMapper;
import org.hqu.production_ms.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProcessServiceImpl implements ProcessService{

	@Autowired
	TechnologyPlanMapper technologyPlanMapper;
	
	@Autowired
	ProcessMapper processMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Process process) {
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
	public Process get(String string) {
		return processMapper.selectByPrimaryKey(string);
	}
	/*
	@Override
	public CustomResult delete(String string) {
		int i = customMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	 */
	
	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = processMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Process process) {
		int i = processMapper.insert(process);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
/*
	@Override
	public CustomResult update(Custom custom) {
		int i = customMapper.updateByPrimaryKeySelective(custom);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	*/
	@Override
	public CustomResult updateAll(Process process) {
		int i = processMapper.updateByPrimaryKey(process);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	/*
	@Override
	public CustomResult changeStatus(String[] ids) {
		customMapper.changeStatus(ids);
		return CustomResult.ok();
	}
*/
	@Override
	public List<Process> find() {
		ProcessExample example = new ProcessExample();
		return processMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchProcessByProcessId(Integer page,
			Integer rows, String processId) {
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
			Integer rows, String technologyPlanId) {
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
