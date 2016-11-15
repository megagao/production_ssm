package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Employee;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.EmployeePO;

public interface EmployeeService {
	
	List<Employee> find();  
	
	EUDataGridResult getList(int page, int rows, Employee employee);
	
	Employee get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(EmployeePO employee);

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(EmployeePO employee);
    
    CustomResult update(EmployeePO employee);
}
