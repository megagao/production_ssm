package com.megagao.production.ssm.controller.scheduling;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.vo.WorkVO;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.Work;
import com.megagao.production.ssm.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/work")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	@RequestMapping("/get/{workId}")
	@ResponseBody
	public WorkVO getItemById(@PathVariable String workId) throws Exception{
		WorkVO work = workService.get(workId);
		return work;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "work_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<WorkVO> getData() throws Exception{
		return workService.find();
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "work_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "work_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, WorkVO work) throws Exception{
		EUDataGridResult result = workService.getList(page, rows, work);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Work work, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(workService.get(work.getWorkId()) != null){
			result = new CustomResult(0, "该作业编号已经存在，请更换作业编号！", null);
		}else{
			result = workService.insert(work);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid Work work, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return workService.update(work);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Work work, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return workService.updateAll(work);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = workService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = workService.deleteBatch(ids);
		return result;
	}
	
	//根据作业id查找
	@RequestMapping("/search_work_by_workId")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkId(page, rows, searchValue);
		return result;
	}
	
	//根据产品名称查找
	@RequestMapping("/search_work_by_workProduct")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkProduct(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkProduct(page, rows, searchValue);
		return result;
	}
	
	//根据设备id查找
	@RequestMapping("/search_work_by_workDevice")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkDevice(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkDevice(page, rows, searchValue);
		return result;
	}
	
	//根据工序id查找
	@RequestMapping("/search_work_by_workProcess")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkProcess(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkProcess(page, rows, searchValue);
		return result;
	}
}
