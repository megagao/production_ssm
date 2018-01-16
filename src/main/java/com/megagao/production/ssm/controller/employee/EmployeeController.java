package com.megagao.production.ssm.controller.employee;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.EmployeeService;
import com.megagao.production.ssm.domain.vo.EmployeeVO;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/get/{empId}")
	@ResponseBody
	public EmployeeVO getItemById(@PathVariable String empId) throws Exception{
		EmployeeVO employee = employeeService.get(empId);
		return employee;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "employee_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Employee> getData() throws Exception{
		return employeeService.find();
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "employee_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "employee_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, EmployeeVO employee) throws Exception{
		EUDataGridResult result = employeeService.getList(page, rows, employee);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Employee employee, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(employeeService.get(employee.getEmpId()) != null){
			result = new CustomResult(0, "该员工编号已经存在，请更换员工编号！", null);
		}else{
			result = employeeService.insert(employee);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid Employee employee, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return employeeService.update(employee);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Employee employee, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return employeeService.updateAll(employee);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = employeeService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = employeeService.deleteBatch(ids);
		return result;
	}
	
	//根据员工id查找
	@RequestMapping("/search_employee_by_employeeId")
	@ResponseBody
	public EUDataGridResult searchEmployeeByEmployeeId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = employeeService.searchEmployeeByEmployeeId(page, rows, searchValue);
		return result;
	}
	
	//根据员工姓名查找
	@RequestMapping("/search_employee_by_employeeName")
	@ResponseBody
	public EUDataGridResult searchEmployeeByEmployeeName(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = employeeService.searchEmployeeByEmployeeName(page, rows, searchValue);
		return result;
	}
	
	//根据部门名称查找
	@RequestMapping("/search_employee_by_departmentName")
	@ResponseBody
	public EUDataGridResult searchEmployeeByDepartmentName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = employeeService.searchEmployeeByDepartmentName(page, rows, searchValue);
		return result;
	}
}
