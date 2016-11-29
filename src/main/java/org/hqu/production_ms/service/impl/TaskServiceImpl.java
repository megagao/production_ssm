package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Task;
import org.hqu.production_ms.domain.TaskExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.TaskMapper;
import org.hqu.production_ms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskMapper taskMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Task task) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Task get(String string) {
		
		return taskMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		int i = taskMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = taskMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Task task) {
		int i = taskMapper.insert(task);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(Task task) {
		int i = taskMapper.updateByPrimaryKeySelective(task);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(Task task) {
		int i = taskMapper.updateByPrimaryKey(task);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public List<Task> find() {
		TaskExample example = new TaskExample();
		return taskMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchTaskByTaskId(Integer page, Integer rows,
			String taskId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.searchTaskByTaskId(taskId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTaskByTaskWorkId(Integer page, Integer rows,
			String taskWorkId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.searchTaskByTaskWorkId(taskWorkId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchTaskByTaskManufactureSn(Integer page,
			Integer rows, String taskManufactureSn) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Task> list = taskMapper.searchTaskByTaskManufactureSn(taskManufactureSn);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Task> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
