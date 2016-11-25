package org.hqu.production_ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.MaterialConsume;
import org.hqu.production_ms.domain.po.MaterialConsumePO;
import org.hqu.production_ms.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/materialConsume")
public class MaterialConsumeController {
	
	@Autowired
	private MaterialConsumeService materialConsumeService;
	
	@RequestMapping("/get/{consumeId}")
	@ResponseBody
	public MaterialConsume getItemById(@PathVariable String orderId) {
		MaterialConsume materialConsume = materialConsumeService.get(orderId);
		return materialConsume;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<MaterialConsume> getData() {
		 List<MaterialConsume> list = materialConsumeService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "materialConsume_list";
	}
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> orderAddJudge() {
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
			if(!subject.isPermitted("materialConsume:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/add")
	public String add() {
		return "materialConsume_add";
	}
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> orderEditJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("materialConsume:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "materialConsume_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, MaterialConsume materialConsume) {
		EUDataGridResult result = materialConsumeService.getList(page, rows, materialConsume);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(MaterialConsumePO materialConsume) throws Exception {
		CustomResult result;
		if(materialConsumeService.get(materialConsume.getConsumeId()) != null){
			result = new CustomResult(0, "该订单编号已经存在，请更换订单编号！", null);
		}else{
			result = materialConsumeService.insert(materialConsume);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(MaterialConsumePO materialConsume) throws Exception {
		CustomResult result = materialConsumeService.update(materialConsume);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(MaterialConsumePO materialConsume) throws Exception {
		CustomResult result = materialConsumeService.updateAll(materialConsume);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(MaterialConsumePO materialConsume) throws Exception {
		CustomResult result = materialConsumeService.updateNote(materialConsume);
		return result;
	}
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> orderDeleteJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("materialConsume:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = materialConsumeService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		System.out.println(ids);
		CustomResult result = materialConsumeService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/change_status")
	@ResponseBody
	public CustomResult changeStatus(String[] ids) {
		CustomResult result = materialConsumeService.changeStatus(ids);
		return result;
	}
	
	//搜索
		@RequestMapping("/search_materialConsume_by_consumeId")
		@ResponseBody
		public EUDataGridResult searchMaterialConsumeByConsumeId(Integer page, Integer rows, String searchValue) {
			EUDataGridResult result = materialConsumeService.searchMaterialConsumeByConsumeId(page, rows, searchValue);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_materialConsume_by_materialId")
		@ResponseBody
		public EUDataGridResult searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue) {
			EUDataGridResult result = materialConsumeService.searchMaterialConsumeByMaterialId(page, rows, searchValue);
			return result;
		}
		
		//搜索
		@RequestMapping("/search_materialConsume_by_workId")
		@ResponseBody
		public EUDataGridResult searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue) {
			EUDataGridResult result = materialConsumeService.searchMaterialConsumeByWorkId(page, rows, searchValue);
			return result;
		}
}

