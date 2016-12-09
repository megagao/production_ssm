package org.hqu.production_ms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.DeviceType;
import org.hqu.production_ms.domain.Process;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.DeviceTypeService;
import org.hqu.production_ms.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceType")
public class DeviceTypeController {
	
	@Autowired
	private DeviceTypeService deviceTypeService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getListType(Integer page, Integer rows, DeviceType deviceType) throws Exception{
		EUDataGridResult result = deviceTypeService.getList(page, rows, deviceType);
		return result;
	}
	
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public DeviceType getItemById(@PathVariable String orderId) throws Exception{
		DeviceType device = deviceTypeService.get(orderId);
		return device;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<DeviceType> getData() throws Exception{
		List<DeviceType> list = deviceTypeService.find();
		return list;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "deviceType_add";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> deviceTypeAddJudge() throws Exception{
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
		return "deviceType_edit";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> deviceTypeEditJudge() throws Exception{
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
	public Map<String,Object> deviceTypeDeleteJudge() throws Exception{
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
	private CustomResult insert(DeviceType deviceType) throws Exception {
		CustomResult result;
		if(deviceTypeService.get(deviceType.getDeviceTypeId()) != null){
			result = new CustomResult(0, "该设备种类编号已经存在，请更换设备种类编号！", null);
		}else{
			result = deviceTypeService.insert(deviceType);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(DeviceType deviceType) throws Exception {
		CustomResult result = deviceTypeService.update(deviceType);
		return result;
	}

	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = deviceTypeService.deleteBatch(ids);
		return result;
	}
	
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(DeviceType deviceType) throws Exception {
		CustomResult result = deviceTypeService.updateAll(deviceType);
		return result;
	}
}
