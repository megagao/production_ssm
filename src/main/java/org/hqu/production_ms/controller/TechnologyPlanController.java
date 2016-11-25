package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.TechnologyPlan;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.TechnologyPlanPO;
import org.hqu.production_ms.service.TechnologyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public TechnologyPlan getItemById(@PathVariable String technologyPlanId) {
		TechnologyPlan technologyPlan = technologyPlanService.get(technologyPlanId);
		return technologyPlan;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "technologyPlan_list";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> technologyPlanAddJudge() {
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
			if(!subject.isPermitted("technologyPlan:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "technologyPlan_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> technologyPlanEditJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("technologyPlan:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "technologyPlan_edit";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<TechnologyPlan> getData() {
		List<TechnologyPlan> list = technologyPlanService.find();
		return list;
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, TechnologyPlanPO technologyPlanPO) {
		EUDataGridResult result = technologyPlanService.getList(page, rows, technologyPlanPO);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(TechnologyPlan technologyPlan) throws Exception {
		CustomResult result;
		if(technologyPlanService.get(technologyPlan.getTechnologyPlanId()) != null){
			result = new CustomResult(0, "该工艺计划编号已经存在，请更换工艺计划编号！", null);
		}else{
			result = technologyPlanService.insert(technologyPlan);
		}
		return result;
	}
	/*
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(TechnologyPlan technologyPlan) throws Exception {
		CustomResult result = technologyPlanService.update(technologyPlan);
		return result;
	}
	*/
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(TechnologyPlan technologyPlan) throws Exception {
		CustomResult result = technologyPlanService.updateAll(technologyPlan);
		return result;
	}
	/*
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(TechnologyPlan technologyPlan) throws Exception {
		CustomResult result = technologyPlanService.updateNote(technologyPlan);
		return result;
	}
	*/
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> technologyPlanDeleteJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
			if(!subject.isPermitted("technologyPlan:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	/*
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = technologyPlanService.delete(id);
		return result;
	}
	*/
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = technologyPlanService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_technologyPlan_by_technologyPlanId")
	@ResponseBody
	public EUDataGridResult searchTechnologyPlanByTechnologyPlanId(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = technologyPlanService.searchTechnologyPlanByTechnologyPlanId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_technologyPlan_by_technologyName")
	@ResponseBody
	public EUDataGridResult searchTechnologyPlanByTechnologyName(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = technologyPlanService.searchTechnologyPlanByTechnologyName(page, rows, searchValue);
		return result;
	}
}
