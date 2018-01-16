package com.megagao.production.ssm.controller.technology;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.vo.TechnologyRequirementVO;
import com.megagao.production.ssm.domain.Technology;
import com.megagao.production.ssm.domain.TechnologyRequirement;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/technologyRequirement")
public class TechnologyRequirementController {

	@Autowired
	private TechnologyRequirementService technologyRequirementService;
	
	@RequestMapping("/get/{technologyRequirementId}")
	@ResponseBody
	public TechnologyRequirement getItemById(@PathVariable String technologyRequirementId)
			throws Exception{
		TechnologyRequirement technologyRequirement = technologyRequirementService
				.get(technologyRequirementId);
		return technologyRequirement;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "technologyRequirement_list";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "technologyRequirement_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "technologyRequirement_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Technology> getData() throws Exception{
		List<Technology> list = technologyRequirementService.find();
		return list;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyRequirementVO technologyRequirementPO)
			throws Exception{
		EUDataGridResult result = technologyRequirementService.getList(page, rows,
				technologyRequirementPO);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult)
			throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(technologyRequirementService.get(technologyRequirement.getTechnologyRequirementId()) != null){
			result = new CustomResult(0, "该工艺要求编号已经存在，请更换工艺要求编号！", null);
		}else{
			result = technologyRequirementService.insert(technologyRequirement);
		}
		return result;
	}

	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return technologyRequirementService.updateAll(technologyRequirement);
	}

	@RequestMapping(value="/update_requirement")
	@ResponseBody
	private CustomResult updateNote(@Valid TechnologyRequirement technologyRequirement, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return technologyRequirementService.updateRequirement(technologyRequirement);
	}

	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = technologyRequirementService.deleteBatch(ids);
		return result;
	}
	
	//根据工艺要求id查找
	@RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
	@ResponseBody
	public EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(Integer page, Integer rows,
			String searchValue) throws Exception{
		EUDataGridResult result = technologyRequirementService
				.searchTechnologyRequirementByTechnologyRequirementId(page, rows, searchValue);
		return result;
	}
	
	//根据工艺名称查找
	@RequestMapping("/search_technologyRequirement_by_technologyName")
	@ResponseBody
	public EUDataGridResult searchTechnologyRequirementByTechnologyName(Integer page, Integer rows,
			String searchValue) throws Exception{
		EUDataGridResult result = technologyRequirementService
				.searchTechnologyRequirementByTechnologyName(page, rows, searchValue);
		return result;
	}
}
