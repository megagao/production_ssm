package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Employee;
import org.hqu.production_ms.domain.EmployeeExample;
import org.hqu.production_ms.domain.po.EmployeePO;

public interface EmployeeMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	List<Employee> find();

	List<Employee> searchEmployeeByEmployeeId(String employeeId);

	List<Employee> searchEmployeeByEmployeeName(String employeeName);

	List<Employee> searchEmployeeByDepartmentName(String departmentName);
	
	//逆向工程生成的mapper接口
	Employee selectSingleEmployee(String empId);
		
    int countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(String empId);

    int insert(EmployeePO record);

    int insertSelective(EmployeePO record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(String empId);

    int updateByExampleSelective(@Param("record") EmployeePO record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") EmployeePO record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(EmployeePO record);

    int updateByPrimaryKey(EmployeePO record);
}