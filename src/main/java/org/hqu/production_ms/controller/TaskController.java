package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Task;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/get/{empId}")
	@ResponseBody
	public Task getItemById(@PathVariable String empId) {
		Task task = taskService.get(empId);
		return task;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "task_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Task> getData() {
		return taskService.find();
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> taskAddJudge() {
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
			if(!subject.isPermitted("task:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "task_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> taskEditJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("task:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "task_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Task task) {
		EUDataGridResult result = taskService.getList(page, rows, task);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(Task task) throws Exception {
		CustomResult result;
		if(taskService.get(task.getTaskId()) != null){
			result = new CustomResult(0, "该生产派工编号已经存在，请更换生产派工编号！", null);
		}else{
			result = taskService.insert(task);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(Task task) throws Exception {
		CustomResult result = taskService.update(task);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(Task task) throws Exception {
		CustomResult result = taskService.updateAll(task);
		return result;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> taskDeleteJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("task:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = taskService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = taskService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_task_by_taskId")
	@ResponseBody
	public EUDataGridResult searchTaskByTaskId(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = taskService.searchTaskByTaskId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_task_by_taskWorkId")
	@ResponseBody
	public EUDataGridResult searchTaskByTaskWorkId(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = taskService.searchTaskByTaskWorkId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_task_by_taskManufactureSn")
	@ResponseBody
	public EUDataGridResult searchTaskByTaskManufactureSn(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = taskService.searchTaskByTaskManufactureSn(page, rows, searchValue);
		return result;
	}
}
