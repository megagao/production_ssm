package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Department;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface DepartmentService {
	
	List<Department> find();  
	
	EUDataGridResult getList(int page, int rows, Department department);
	
	Department get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(Department department);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Department department);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Department department);
    
    //更新备注
    CustomResult updateNote(Department department);
    
    List<Department> searchDepartmentByDepartmentId(String departmentId);

	EUDataGridResult searchDepartmentByDepartmentId(Integer page, Integer rows,
			String departmentId);

	EUDataGridResult searchDepartmentByDepartmentName(Integer page,
			Integer rows, String departmentName);
}
