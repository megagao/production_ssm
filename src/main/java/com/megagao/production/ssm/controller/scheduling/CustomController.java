package com.megagao.production.ssm.controller.scheduling;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.Custom;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/custom")
public class CustomController {

	@Autowired
	private CustomService customService;
	
	@RequestMapping("/get/{customId}")
	@ResponseBody
	public Custom getItemById(@PathVariable String customId) throws Exception{
		Custom custom = customService.get(customId);
		return custom;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "custom_list";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "custom_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "custom_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Custom> getData() throws Exception{
		 List<Custom> list = customService.find();
		return list;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Custom custom) throws Exception{
		EUDataGridResult result = customService.getList(page, rows, custom);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Custom custom, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(customService.get(custom.getCustomId()) != null){
			result = new CustomResult(0, "该客户编号已经存在，请更换客户编号！", null);
		}else{
			result = customService.insert(custom);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid Custom custom, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return customService.update(custom);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Custom custom, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return customService.updateAll(custom);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid Custom custom, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return customService.updateNote(custom);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = customService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = customService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/change_status")
	@ResponseBody
	public CustomResult changeStatus(String[] ids) throws Exception{
		CustomResult result = customService.changeStatus(ids);
		return result;
	}
	
	//根据客户id查找
	@RequestMapping("/search_custom_by_customId")
	@ResponseBody
	public EUDataGridResult searchCustomByCustomId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = customService.searchCustomByCustomId(page, rows, searchValue);
		return result;
	}
	
	//根据客户名查找
	@RequestMapping("/search_custom_by_customName")
	@ResponseBody
	public EUDataGridResult searchCustomByCustomName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = customService.searchCustomByCustomName(page, rows, searchValue);
		return result;
	}
	
}
