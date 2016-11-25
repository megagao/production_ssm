package org.hqu.production_ms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hqu.production_ms.domain.Product;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.ActiveUser;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
//import org.hqu.production_ms.service.unqualifyService;
import org.hqu.production_ms.service.UnqualifyService;
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
@RequestMapping("/unqualify")
public class UnqualifyProductController {
	
	@Autowired
	private UnqualifyService unqualifyService;
	
	
	
	
	@RequestMapping("/add_judge")
	@ResponseBody
	public Map<String,Object> unqualifyAddJudge() {
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
			if(!subject.isPermitted("unqualify:add")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	
	
	
	@RequestMapping("/edit_judge")
	@ResponseBody
	public Map<String,Object> unqualifyEditJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("unqualify:edit")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	
	@RequestMapping("/delete_judge")
	@ResponseBody
	public Map<String,Object> unqualifyDeleteJudge() {
		Subject subject = SecurityUtils.getSubject();
		ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
		Map<String,Object> map = new HashMap<String,Object>();
		if(!activeUser.getUserStatus().equals("1")){
			map.put("msg", "您的账户已被锁定，请切换账户登录！");
		}else if(!activeUser.getRoleStatus().equals("1")){
			map.put("msg", "当前角色已被锁定，请切换账户登录！");
		}else{
			if(!subject.isPermitted("unqualify:delete")){
				map.put("msg", "您没有权限，请切换用户登录！");
			}
		}
		return map;
	}
	
	
	
	@RequestMapping("/search_unqualify_by_unqualifyId")
	@ResponseBody
	public EUDataGridResult searchUnqualifyByUnqualifyId(Integer page, Integer rows, String searchValue) {
		EUDataGridResult result = unqualifyService.searchUnqualifyByUnqualifyId(page, rows, searchValue);
		return result;
	}
	
	
	
	
	
	
	
	
	@InitBinder
    public void InitBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) {
        // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
        // SimpleDateFormat dateFormat = new
        // SimpleDateFormat(getText("date.format", request.getLocale()));
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
                dateFormat, true));
    }
	
//	@RequestMapping("/get/{productId}")
//	@ResponseBody
//	public Product getItemById(@PathVariable String productId) {
//		Product cProduct = unqualifyService.get(productId);
//		return cProduct;
//	}
	
	@RequestMapping("/find")
	public String find() {
		return "unqualify_list";
	}
	
//	@RequestMapping("/get_data")
//	@ResponseBody
//	public List<Product> getData() {
//		return unqualifyService.find();
//	}
//	
	@RequestMapping("/add")
	public String add() {
		return "unqualify_add";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "unqualify_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, UnqualifyApply unqualifyApply) {
		EUDataGridResult result = unqualifyService.getList(page, rows, unqualifyApply);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(UnqualifyApply unqualifyApply) throws Exception {
		CustomResult result = unqualifyService.insert(unqualifyApply);
		return result;
	}
	
//	@RequestMapping(value="/update")
//	@ResponseBody
//	private CustomResult update(Product product) throws Exception {
//		CustomResult result = unqualifyService.update(product);
//		return result;
//	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(UnqualifyApply unqualifyApply) throws Exception {
		CustomResult result = unqualifyService.updateAll(unqualifyApply);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(UnqualifyApply unqualifyApply) throws Exception {
		CustomResult result = unqualifyService.updateNote(unqualifyApply);
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = unqualifyService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = unqualifyService.deleteBatch(ids);
		return result;
	}
	
}
