package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Technology;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/technology")
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@RequestMapping("/get/{technologyId}")
	@ResponseBody
	public Technology getItemById(@PathVariable String technologyId) throws Exception{
		Technology technology = technologyService.get(technologyId);
		return technology;
	}
	
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "technology_list";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> technologyAddJudge() throws Exception{
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>(); 
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("technology:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "technology_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> technologyEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("technology:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "technology_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Technology> getData() throws Exception{
		 List<Technology> list = technologyService.find();
		return list;
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Technology technology) 
			throws Exception{
		EUDataGridResult result = technologyService.getList(page, rows, technology);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Technology technology, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(technologyService.get(technology.getTechnologyId()) != null){
			result = new CustomResult(0, "该工艺编号已经存在，请更换工艺编号！", null);
		}else{
			result = technologyService.insert(technology);
		}
		return result;
	}
	/*
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(Technology technology) throws Exception {
		CustomResult result = technologyService.update(technology);
		return result;
	}
	*/
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Technology technology, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return technologyService.updateAll(technology);
	}
	/*
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(Technology technology) throws Exception {
		CustomResult result = technologyService.updateNote(technology);
		return result;
	}
	*/
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> technologyDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
			if(!subject.isPermitted("technology:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	/*
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = technologyService.delete(id);
		return result;
	}
	*/
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = technologyService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_technology_by_technologyId")
	@ResponseBody
	public EUDataGridResult searchTechnologyByTechnologyId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = technologyService.searchTechnologyByTechnologyId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_technology_by_technologyName")
	@ResponseBody
	public EUDataGridResult searchTechnologyByTechnologyName(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = technologyService.searchTechnologyByTechnologyName(page, rows, searchValue);
		return result;
	}
	
}
