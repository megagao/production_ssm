package com.megagao.production.ssm.controller.device;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.DeviceTypeService;
import com.megagao.production.ssm.domain.DeviceType;
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
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "deviceType_edit";
	}
	
	/*
	 *此处的method可以取两个值，
	 *一个是RequestMethod.GET，一个是RequestMethod.POST，
	 *就是请求该方法使用的模式，是get还是post，即参数提交的方法
	 *ajax或者form表单提交数据有两种方法，即get和post。
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid DeviceType deviceType, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(deviceTypeService.get(deviceType.getDeviceTypeId()) != null){
			result = new CustomResult(0, "该设备种类编号已经存在，请更换设备种类编号！", null);
		}else{
			result = deviceTypeService.insert(deviceType);
		}
		return result;
	}

	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = deviceTypeService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid DeviceType deviceType, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceTypeService.update(deviceType);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid DeviceType deviceType, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceTypeService.updateAll(deviceType);
	}
	
	//根据设备种类编号查找
	@RequestMapping("/search_deviceType_by_deviceTypeId")
	@ResponseBody
	public EUDataGridResult searchDeviceTypeByDeviceTypeId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = deviceTypeService.searchDeviceTypeByDeviceTypeId(page, rows, searchValue);
		return result;
	}
	
	//根据设备种类名称查找
	@RequestMapping("/search_deviceType_by_deviceTypeName")
	@ResponseBody
	public EUDataGridResult searchDeviceTypeByDeviceTypeName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = deviceTypeService.searchDeviceTypeByDeviceTypeName(page, rows, searchValue);
		return result;
	}
}
