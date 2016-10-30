package org.hqu.production_ms.controller;

import java.util.List;

import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list_keeper")
	@ResponseBody
	public List<?> getListKeeper() {
	EUDataGridResult result = employeeService.getListKeeper();
		return result.getRows();
	}
	
	@RequestMapping("/list_maintainEmp")
	@ResponseBody
	public List<?> getListMaintainEmp() {
	EUDataGridResult result = employeeService.getListMaintainEmp();
		return result.getRows();
	}
}
