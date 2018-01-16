package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.Department;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface DepartmentService {
	
	List<Department> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Department department) throws Exception;
	
	Department get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Department department) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Department department) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Department department) throws Exception;
    
    //更新备注
    CustomResult updateNote(Department department) throws Exception;
    
    List<Department> searchDepartmentByDepartmentId(String departmentId) throws Exception;

	EUDataGridResult searchDepartmentByDepartmentId(Integer page, Integer rows,
			String departmentId) throws Exception;

	EUDataGridResult searchDepartmentByDepartmentName(Integer page,
			Integer rows, String departmentName) throws Exception;
}
