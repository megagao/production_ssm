package com.megagao.production.ssm.controller.material;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.MaterialReceive;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.MaterialReceiveService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	
	/*@RequestMapping("/get_data")
	@ResponseBody
	public List<MaterialReceive> getData() {
		return materialReceiveService.find();
	}*/
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "materialReceive_add";
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
	private CustomResult insert(@Valid MaterialReceive materialReceive, BindingResult bindingResult)
			throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(materialReceiveService.get(materialReceive.getReceiveId()) != null){
			result = new CustomResult(0, "该产品编号已经存在，请更换产品编号！", null);
		}else{
			result = materialReceiveService.insert(materialReceive);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid MaterialReceive materialReceive, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialReceiveService.update(materialReceive);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid MaterialReceive materialReceive, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialReceiveService.updateAll(materialReceive);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid MaterialReceive materialReceive, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialReceiveService.updateNote(materialReceive);
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
	
	//根据物料接收id查找
	@RequestMapping("/search_materialReceive_by_receiveId")
	@ResponseBody
	public EUDataGridResult searchMaterialReceiveByReceiveId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = materialReceiveService.searchMaterialReceiveByReceiveId(page, rows, searchValue);
		return result;
	}

	//根据物料id查找
	@RequestMapping("/search_materialReceive_by_materialId")
	@ResponseBody
	public EUDataGridResult searchMaterialReceiveByMaterialId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = materialReceiveService.searchMaterialReceiveByMaterialId(page, rows, searchValue);
		return result;
	}
}
