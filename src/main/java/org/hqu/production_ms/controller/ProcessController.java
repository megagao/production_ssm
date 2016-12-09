package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Process;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> processAddJudge() throws Exception{
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
			if(!subject.isPermitted("process:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "process_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> processEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("process:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
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
	private CustomResult insert(Process process) throws Exception {
		CustomResult result;
		if(processService.get(process.getProcessId()) != null){
			result = new CustomResult(0, "该工序编号已经存在，请更换工序编号！", null);
		}else{
			result = processService.insert(process);
		}
		return result;
	}
	/*
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(Process process) throws Exception {
		CustomResult result = processService.update(process);
		return result;
	}
	*/
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(Process process) throws Exception {
		CustomResult result = processService.updateAll(process);
		return result;
	}
	
	/*
	@RequestMapping(value="/update_requirement")
	@ResponseBody
	private CustomResult updateNote(Process process) throws Exception {
		CustomResult result = processService.updateRequirement(process);
		return result;
	}
	*/
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> processDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
			if(!subject.isPermitted("process:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	/*
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = processService.delete(id);
		return result;
	}
	*/
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = processService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_process_by_processId")
	@ResponseBody
	public EUDataGridResult searchProcessByProcessId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = processService.searchProcessByProcessId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_process_by_technologyPlanId")
	@ResponseBody
	public EUDataGridResult searchProcessByTechnologyPlanId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = processService.searchProcessByTechnologyPlanId(page, rows, searchValue);
		return result;
	}
}
