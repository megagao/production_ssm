package com.megagao.production.ssm.controller.technology;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.Process;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.ProcessService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/process")
public class ProcessController {

	@Autowired
	private ProcessService processService;
	
	@RequestMapping("/get/{processId}")
	@ResponseBody
	public Process getItemById(@PathVariable String processId) throws Exception{
		Process process = processService.get(processId);
		return process;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "process_list";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "process_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "process_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Process> getData() throws Exception{
		List<Process> list = processService.find();
		return list;
	}

	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Process process) throws Exception{
		EUDataGridResult result = processService.getList(page, rows, process);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Process process, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(processService.get(process.getProcessId()) != null){
			result = new CustomResult(0, "该工序编号已经存在，请更换工序编号！", null);
		}else{
			result = processService.insert(process);
		}
		return result;
	}

	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Process process, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return processService.updateAll(process);
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = processService.deleteBatch(ids);
		return result;
	}
	
	//根据工序id查找
	@RequestMapping("/search_process_by_processId")
	@ResponseBody
	public EUDataGridResult searchProcessByProcessId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = processService.searchProcessByProcessId(page, rows, searchValue);
		return result;
	}
	
	//根据工序计划id查找
	@RequestMapping("/search_process_by_technologyPlanId")
	@ResponseBody
	public EUDataGridResult searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = processService.searchProcessByTechnologyPlanId(page, rows, searchValue);
		return result;
	}
}
