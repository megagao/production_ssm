package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Manufacture;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.ManufacturePO;
import org.hqu.production_ms.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
	
	@Autowired
	private ManufactureService manufactureService;
	
	@RequestMapping("/get/{manufactureId}")
	@ResponseBody
	public Manufacture getItemById(@PathVariable String manufactureId) throws Exception{
		Manufacture manufacture = manufactureService.get(manufactureId);
		return manufacture;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "manufacture_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Manufacture> getData() throws Exception{
		return manufactureService.find();
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> manufactureAddJudge() throws Exception{
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
			if(!subject.isPermitted("manufacture:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "manufacture_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> manufactureEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("manufacture:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "manufacture_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows) throws Exception{
		EUDataGridResult result = manufactureService.getList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid ManufacturePO manufacture, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(manufactureService.get(manufacture.getManufactureSn()) != null){
			result = new CustomResult(0, "该生产批号已经存在，请更换生产批号！", null);
		}else{
			result = manufactureService.insert(manufacture);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid ManufacturePO manufacture, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return manufactureService.update(manufacture);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid ManufacturePO manufacture, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return manufactureService.updateAll(manufacture);
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> manufactureDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("manufacture:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = manufactureService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		System.out.println(ids);
		CustomResult result = manufactureService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_manufacture_by_manufactureSn")
	@ResponseBody
	public EUDataGridResult searchManufactureByManufactureSn(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = manufactureService.searchManufactureByManufactureSn(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_manufacture_by_manufactureOrderId")
	@ResponseBody
	public EUDataGridResult searchManufactureByManufactureOrderId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = manufactureService.searchManufactureByManufactureOrderId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_manufacture_by_manufactureTechnologyName")
	@ResponseBody
	public EUDataGridResult searchManufactureByManufactureTechnologyName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = manufactureService.searchManufactureByManufactureTechnologyName(page, rows, searchValue);
		return result;
	}
}
