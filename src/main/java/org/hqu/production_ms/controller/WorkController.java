package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Work;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.WorkPO;
import org.hqu.production_ms.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public Work getItemById(@PathVariable String workId) throws Exception{
		Work work = workService.get(workId);
		return work;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "work_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Work> getData() throws Exception{
		return workService.find();
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> workAddJudge() throws Exception{
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
			if(!subject.isPermitted("work:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "work_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> workEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("work:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "work_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Work work) throws Exception{
		EUDataGridResult result = workService.getList(page, rows, work);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(WorkPO work) throws Exception {
		CustomResult result;
		if(workService.get(work.getWorkId()) != null){
			result = new CustomResult(0, "该作业编号已经存在，请更换作业编号！", null);
		}else{
			result = workService.insert(work);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(WorkPO work) throws Exception {
		CustomResult result = workService.update(work);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(WorkPO work) throws Exception {
		CustomResult result = workService.updateAll(work);
		return result;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> workDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("work:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
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
	
	//搜索
	@RequestMapping("/search_work_by_workId")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_work_by_workProduct")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkProduct(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkProduct(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_work_by_workDevice")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkDevice(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkDevice(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_work_by_workProcess")
	@ResponseBody
	public EUDataGridResult searchWorkByWorkProcess(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = workService.searchWorkByWorkProcess(page, rows, searchValue);
		return result;
	}
}
