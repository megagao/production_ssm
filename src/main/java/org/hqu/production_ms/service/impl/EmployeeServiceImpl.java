package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Employee;
import org.hqu.production_ms.domain.EmployeeExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.EmployeePO;
import org.hqu.production_ms.mapper.EmployeeMapper;
import org.hqu.production_ms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeMapper employeeMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Employee employee) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Employee> list = employeeMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Employee> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Employee get(String string) {
		
		return employeeMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		int i = employeeMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = employeeMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(EmployeePO employee) {
		int i = employeeMapper.insert(employee);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(EmployeePO employee) {
		int i = employeeMapper.updateByPrimaryKeySelective(employee);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(EmployeePO employee) {
		int i = employeeMapper.updateByPrimaryKey(employee);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public List<Employee> find() {
		EmployeeExample example = new EmployeeExample();
		return employeeMapper.selectByExample(example);
	}
}
