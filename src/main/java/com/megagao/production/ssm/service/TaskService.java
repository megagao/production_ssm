package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.Task;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface TaskService {
	
	List<Task> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, Task task) throws Exception;
	
	Task get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Task task) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Task task) throws Exception;
    
    CustomResult update(Task task) throws Exception;
    
	EUDataGridResult searchTaskByTaskId(Integer page, Integer rows,
			String taskId) throws Exception;

	EUDataGridResult searchTaskByTaskWorkId(Integer page, Integer rows,
			String taskWorkId) throws Exception;

	EUDataGridResult searchTaskByTaskManufactureSn(Integer page, Integer rows,
			String taskManufactureSn) throws Exception;
}
