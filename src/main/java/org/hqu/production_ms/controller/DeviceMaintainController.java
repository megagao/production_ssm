package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.Map;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.DeviceMaintain;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.DeviceMaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {
	
	@Autowired
	private DeviceMaintainService deviceMaintainService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getListType(Integer page, Integer rows, DeviceMaintain deviceMaintain) throws Exception{
		EUDataGridResult result = deviceMaintainService.getList(page, rows, deviceMaintain);
		return result;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "deviceMaintain_add";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> deviceMaintainAddJudge() throws Exception{
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
			if(!subject.isPermitted("custom:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "deviceMaintain_edit";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> deviceMaintainEditJudge() throws Exception{
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
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> deviceMaintainDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
			if(!subject.isPermitted("custom:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	/*
	 *此处的method可以取两个值，
	 *一个是RequestMethod.GET，一个是RequestMethod.POST，
	 *就是请求该方法使用的模式，是get还是post，即参数提交的方法
	 *ajax或者form表单提交数据有两种方法，即get和post。
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(DeviceMaintain deviceMaintain) throws Exception {
		CustomResult result;
		if(deviceMaintainService.get(deviceMaintain.getDeviceMaintainId()) != null){
			result = new CustomResult(0, "该设备维修编号已经存在，请更换设备维修编号！", null);
		}else{
			result = deviceMaintainService.insert(deviceMaintain);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(DeviceMaintain deviceMaintain) throws Exception {
		CustomResult result = deviceMaintainService.update(deviceMaintain);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = deviceMaintainService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(DeviceMaintain deviceMaintain) throws Exception {
		CustomResult result = deviceMaintainService.updateNote(deviceMaintain);
		return result;
	}
}
