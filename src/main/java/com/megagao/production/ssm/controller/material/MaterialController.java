package com.megagao.production.ssm.controller.material;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.Material;
import com.megagao.production.ssm.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@RequestMapping("/get/{materialId}")
	@ResponseBody
	public Material getItemById(@PathVariable String materialId) throws Exception{
		Material cmaterial = materialService.get(materialId);
		return cmaterial;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "material_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Material> getData() throws Exception{
		return materialService.find();
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "material_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "material_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Material material) throws Exception{
		EUDataGridResult result = materialService.getList(page, rows, material);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Material material, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(materialService.get(material.getMaterialId()) != null){
			result = new CustomResult(0, "该物料编号已经存在，请更换物料编号！", null);
		}else{
			result = materialService.insert(material);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid Material material, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialService.update(material);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Material material, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialService.updateAll(material);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid Material material, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialService.updateNote(material);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = materialService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = materialService.deleteBatch(ids);
		return result;
	}
	
	//根据物料id查找
	@RequestMapping("/search_material_by_materialId")
	@ResponseBody
	public EUDataGridResult searchMaterialByMaterialId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = materialService.searchMaterialByMaterialId(page, rows, searchValue);
		return result;
	}
	
	//根据物料类型查找
	@RequestMapping("/search_material_by_materialType")
	@ResponseBody
	public EUDataGridResult searchMaterialByMaterialType(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = materialService.searchMaterialByMaterialType(page, rows, searchValue);
		return result;
	}
}