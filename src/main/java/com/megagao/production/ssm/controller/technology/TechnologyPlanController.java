package com.megagao.production.ssm.controller.technology;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.TechnologyPlan;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.vo.TechnologyPlanVO;
import com.megagao.production.ssm.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/technologyPlan")
public class TechnologyPlanController {

	@Autowired
	private TechnologyPlanService technologyPlanService;
	
	@RequestMapping("/get/{technologyPlanId}")
	@ResponseBody
	public TechnologyPlan getItemById(@PathVariable String technologyPlanId) throws Exception{
		TechnologyPlan technologyPlan = technologyPlanService.get(technologyPlanId);
		return technologyPlan;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "technologyPlan_list";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "technologyPlan_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "technologyPlan_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<TechnologyPlan> getData() throws Exception{
		List<TechnologyPlan> list = technologyPlanService.find();
		return list;
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyPlanVO technologyPlanPO)
			throws Exception{
		EUDataGridResult result = technologyPlanService.getList(page, rows, technologyPlanPO);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid TechnologyPlan technologyPlan, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(technologyPlanService.get(technologyPlan.getTechnologyPlanId()) != null){
			result = new CustomResult(0, "该工艺计划编号已经存在，请更换工艺计划编号！", null);
		}else{
			result = technologyPlanService.insert(technologyPlan);
		}
		return result;
	}

	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid TechnologyPlan technologyPlan, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return technologyPlanService.updateAll(technologyPlan);
	}

	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = technologyPlanService.deleteBatch(ids);
		return result;
	}
	
	//根据工艺计划id查找
	@RequestMapping("/search_technologyPlan_by_technologyPlanId")
	@ResponseBody
	public EUDataGridResult searchTechnologyPlanByTechnologyPlanId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = technologyPlanService.searchTechnologyPlanByTechnologyPlanId(page, rows, searchValue);
		return result;
	}
	
	//根据工艺名称查找
	@RequestMapping("/search_technologyPlan_by_technologyName")
	@ResponseBody
	public EUDataGridResult searchTechnologyPlanByTechnologyName(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = technologyPlanService.searchTechnologyPlanByTechnologyName(page, rows, searchValue);
		return result;
	}
}
