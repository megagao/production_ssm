package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Employee;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.EmployeeMapper;
import org.hqu.production_ms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public EUDataGridResult getListKeeper() {
		List<Employee> list = employeeMapper.listKeeper();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		//取记录总条数
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult getListMaintainEmp() {
		List<Employee> list = employeeMapper.listMaintainEmp();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		
		//取记录总条数
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
