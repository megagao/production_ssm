package org.hqu.production_ms.controller;

import java.util.List;

import org.hqu.production_ms.domain.Custom;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public Custom getItemById(@PathVariable String customId) {
		Custom custom = customService.get(customId);
		return custom;
	}
	
	
	@RequestMapping("/find")
	public String find() {
		return "custom_list";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "custom_add";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "custom_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Custom> getData() {
		 List<Custom> list = customService.find();
		return list;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Custom custom) {
		EUDataGridResult result = customService.getList(page, rows, custom);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(Custom custom) throws Exception {
		CustomResult result = customService.insert(custom);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(Custom custom) throws Exception {
		CustomResult result = customService.update(custom);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(Custom custom) throws Exception {
		CustomResult result = customService.updateAll(custom);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(Custom custom) throws Exception {
		CustomResult result = customService.updateNote(custom);
		return result;
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
	public CustomResult changeStatus(String[] ids) {
		CustomResult result = customService.changeStatus(ids);
		return result;
	}
}
