package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Technology;
import org.hqu.production_ms.domain.TechnologyRequirement;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.TechnologyRequirementPO;
import org.hqu.production_ms.service.TechnologyRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public TechnologyRequirement getItemById(@PathVariable String technologyRequirementId) {
		TechnologyRequirement technologyRequirement = technologyRequirementService.get(technologyRequirementId);
		return technologyRequirement;
	}
	
	
	@RequestMapping("/find")
	public String find() {
		return "technologyRequirement_list";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> technologyRequirementAddJudge() {
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
			if(!subject.isPermitted("technologyRequirement:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "technologyRequirement_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> technologyRequirementEditJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("technologyRequirement:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "technologyRequirement_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Technology> getData() {
		List<Technology> list = technologyRequirementService.find();
		return list;
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyRequirementPO technologyRequirementPO) {
		EUDataGridResult result = technologyRequirementService.getList(page, rows, technologyRequirementPO);
System.out.println(result);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(TechnologyRequirement technologyRequirement) throws Exception {
		CustomResult result;
		if(technologyRequirementService.get(technologyRequirement.getTechnologyRequirementId()) != null){
			result = new CustomResult(0, "该工艺要求编号已经存在，请更换工艺要求编号！", null);
		}else{
			result = technologyRequirementService.insert(technologyRequirement);
		}
		return result;
	}
	/*
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(TechnologyRequirement technologyRequirement) throws Exception {
		CustomResult result = technologyRequirementService.update(technologyRequirement);
		return result;
	}
	*/
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(TechnologyRequirement technologyRequirement) throws Exception {
		CustomResult result = technologyRequirementService.updateAll(technologyRequirement);
		return result;
	}

	@RequestMapping(value="/update_requirement")
	@ResponseBody
	private CustomResult updateNote(TechnologyRequirementPO technologyRequirement) throws Exception {
System.out.println("updateRequirement");
System.out.println(technologyRequirement.getRequirement());
		CustomResult result = technologyRequirementService.updateRequirement(technologyRequirement);
		return result;
	}
	
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> technologyRequirementDeleteJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
			if(!subject.isPermitted("technologyRequirement:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	/*
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = technologyRequirementService.delete(id);
		return result;
	}
	*/
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = technologyRequirementService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_technologyRequirement_by_technologyRequirementId")
	@ResponseBody
	public EUDataGridResult searchTechnologyRequirementByTechnologyRequirementId(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = technologyRequirementService.searchTechnologyRequirementByTechnologyRequirementId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_technologyRequirement_by_technologyName")
	@ResponseBody
	public EUDataGridResult searchTechnologyRequirementByTechnologyName(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = technologyRequirementService.searchTechnologyRequirementByTechnologyName(page, rows, searchValue);
		return result;
	}
}
