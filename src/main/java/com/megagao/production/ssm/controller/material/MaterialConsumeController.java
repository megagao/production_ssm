package com.megagao.production.ssm.controller.material;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.vo.MaterialConsumeVO;
import com.megagao.production.ssm.service.MaterialConsumeService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.MaterialConsume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public MaterialConsume getItemById(@PathVariable String orderId) throws Exception{
		MaterialConsume materialConsume = materialConsumeService.get(orderId);
		return materialConsume;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<MaterialConsume> getData() throws Exception{
		 List<MaterialConsume> list = materialConsumeService.find();
		return list;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "materialConsume_list";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "materialConsume_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "materialConsume_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, MaterialConsumeVO materialConsume) throws Exception{
		EUDataGridResult result = materialConsumeService.getList(page, rows, materialConsume);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid MaterialConsume materialConsume, BindingResult bindingResult)
			throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(materialConsumeService.get(materialConsume.getConsumeId()) != null){
			result = new CustomResult(0, "该订单编号已经存在，请更换订单编号！", null);
		}else{
			result = materialConsumeService.insert(materialConsume);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid MaterialConsume materialConsume, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialConsumeService.update(materialConsume);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid MaterialConsume materialConsume, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialConsumeService.updateAll(materialConsume);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid MaterialConsume materialConsume, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return materialConsumeService.updateNote(materialConsume);
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
	
	//根据客户id查找
	@RequestMapping("/search_materialConsume_by_consumeId")
	@ResponseBody
	public EUDataGridResult searchMaterialConsumeByConsumeId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = materialConsumeService.searchMaterialConsumeByConsumeId(page, rows, searchValue);
		return result;
	}

	//根据物料id查找
	@RequestMapping("/search_materialConsume_by_materialId")
	@ResponseBody
	public EUDataGridResult searchMaterialConsumeByMaterialId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = materialConsumeService.searchMaterialConsumeByMaterialId(page, rows, searchValue);
		return result;
	}

	//根据作业id查找
	@RequestMapping("/search_materialConsume_by_workId")
	@ResponseBody
	public EUDataGridResult searchMaterialConsumeByWorkId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = materialConsumeService.searchMaterialConsumeByWorkId(page, rows, searchValue);
		return result;
	}
}

