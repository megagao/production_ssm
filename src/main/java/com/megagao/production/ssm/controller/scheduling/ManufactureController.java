package com.megagao.production.ssm.controller.scheduling;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.Manufacture;
import com.megagao.production.ssm.domain.vo.ManufactureVO;
import com.megagao.production.ssm.service.ManufactureService;
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
	public ManufactureVO getItemById(@PathVariable String manufactureId) throws Exception{
		ManufactureVO manufacture = manufactureService.get(manufactureId);
		return manufacture;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "manufacture_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<ManufactureVO> getData() throws Exception{
		return manufactureService.find();
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "manufacture_add";
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
	private CustomResult insert(@Valid Manufacture manufacture, BindingResult bindingResult) throws Exception {
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
	private CustomResult update(@Valid Manufacture manufacture, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return manufactureService.update(manufacture);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Manufacture manufacture, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return manufactureService.updateAll(manufacture);
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
	
	//根据生产流水号查找
	@RequestMapping("/search_manufacture_by_manufactureSn")
	@ResponseBody
	public EUDataGridResult searchManufactureByManufactureSn(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = manufactureService.searchManufactureByManufactureSn(page, rows, searchValue);
		return result;
	}
	
	//根据订单id查找
	@RequestMapping("/search_manufacture_by_manufactureOrderId")
	@ResponseBody
	public EUDataGridResult searchManufactureByManufactureOrderId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = manufactureService.searchManufactureByManufactureOrderId(page, rows, searchValue);
		return result;
	}
	
	//根据工艺名称查找
	@RequestMapping("/search_manufacture_by_manufactureTechnologyName")
	@ResponseBody
	public EUDataGridResult searchManufactureByManufactureTechnologyName(Integer page, Integer rows
			, String searchValue) throws Exception{
		EUDataGridResult result = manufactureService.searchManufactureByManufactureTechnologyName(page, 
				rows, searchValue);
		return result;
	}
}
