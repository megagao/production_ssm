package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Task;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface TaskService {
	
	List<Task> find();  
	
	EUDataGridResult getList(int page, int rows, Task task);
	
	Task get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(Task task);

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Task task);
    
    CustomResult update(Task task);
    
	EUDataGridResult searchTaskByTaskId(Integer page, Integer rows,
			String taskId);

	EUDataGridResult searchTaskByTaskWorkId(Integer page, Integer rows,
			String taskWorkId);

	EUDataGridResult searchTaskByTaskManufactureSn(Integer page, Integer rows,
			String taskManufactureSn);
}
