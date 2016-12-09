package org.hqu.production_ms.controller;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.MaterialReceive;
import org.hqu.production_ms.domain.po.MaterialReceivePO;
import org.hqu.production_ms.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("/materialReceive")
public class MaterialReceiveController {

	@Autowired
	private MaterialReceiveService materialReceiveService;
	
	@RequestMapping("/get/{receiveId}")
	@ResponseBody
	public MaterialReceive getItemById(@PathVariable String receiveId) throws Exception{
		MaterialReceive cmaterial = materialReceiveService.get(receiveId);
		return cmaterial;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "materialReceive_list";
	}
	/*
	@RequestMapping("/get_data")
	@ResponseBody
	/*public List<MaterialReceive> getData() {
		return materialReceiveService.find();
	}
	*/
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> materialReceiveAddJudge() throws Exception{
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
			if(!subject.isPermitted("materialReceive:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "materialReceive_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> materialReceiveEditJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("materialReceive:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "materialReceive_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows) throws Exception{
		EUDataGridResult result = materialReceiveService.getList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(MaterialReceivePO materialReceive) throws Exception {
		CustomResult result;
		if(materialReceiveService.get(materialReceive.getReceiveId()) != null){
			result = new CustomResult(0, "该产品编号已经存在，请更换产品编号！", null);
		}else{
			result = materialReceiveService.insert(materialReceive);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(MaterialReceivePO materialReceive) throws Exception {
		CustomResult result = materialReceiveService.update(materialReceive);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(MaterialReceivePO materialReceive) throws Exception {
		CustomResult result = materialReceiveService.updateAll(materialReceive);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(MaterialReceivePO materialReceive) throws Exception {
		CustomResult result = materialReceiveService.updateNote(materialReceive);
		return result;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> materialDeleteJudge() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("materialReceive:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = materialReceiveService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = materialReceiveService.deleteBatch(ids);
		return result;
	}
	
	   //搜索
		@RequestMapping("/search_materialReceive_by_receiveId")
		@ResponseBody
		public EUDataGridResult searchMaterialReceiveByReceiveId(Integer page, Integer rows, String searchValue) 
				throws Exception{
			EUDataGridResult result = materialReceiveService.searchMaterialReceiveByReceiveId(page, rows, searchValue);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_materialReceive_by_materialId")
		@ResponseBody
		public EUDataGridResult searchMaterialReceiveByMaterialId(Integer page, Integer rows, String searchValue)
				throws Exception{
			EUDataGridResult result = materialReceiveService.searchMaterialReceiveByMaterialId(page, rows, searchValue);
			return result;
		}
}
