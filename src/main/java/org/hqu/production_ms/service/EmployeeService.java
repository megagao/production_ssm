package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Employee;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.EmployeePO;

public interface EmployeeService {
	
	List<Employee> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Employee employee) throws Exception;
	
	Employee get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(EmployeePO employee) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(EmployeePO employee) throws Exception;
    
    CustomResult update(EmployeePO employee) throws Exception;
    
    List<Employee> searchEmployeeByEmployeeName(String employeeName) throws Exception;

	List<Employee> searchEmployeeByEmployeeId(String employeeId) throws Exception;

	//根据员工id查找员工信息
	EUDataGridResult searchEmployeeByEmployeeId(Integer page, Integer rows,
			String employeeId) throws Exception;

	//根据员工姓名查找员工信息
	EUDataGridResult searchEmployeeByEmployeeName(Integer page, Integer rows,
			String employeeName) throws Exception;

	//根据部门名称查找员工信息
	EUDataGridResult searchEmployeeByDepartmentName(Integer page, Integer rows,
			String departmentName) throws Exception;
}
