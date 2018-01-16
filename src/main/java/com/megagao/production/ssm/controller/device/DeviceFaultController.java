package com.megagao.production.ssm.controller.device;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.DeviceFault;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.DeviceFaultService;
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
@RequestMapping("/deviceFault")
public class DeviceFaultController {
	
	@Autowired
	private DeviceFaultService deviceFaultService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getListType(Integer page, Integer rows, DeviceFault deviceFault) throws Exception{
		EUDataGridResult result = deviceFaultService.getList(page, rows, deviceFault);
		return result;
	}
	
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public DeviceFault getItemById(@PathVariable String orderId) throws Exception{
		DeviceFault device = deviceFaultService.get(orderId);
		return device;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<DeviceFault> getData() throws Exception{
		List<DeviceFault> list = deviceFaultService.find();
		return list;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "deviceFault_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "deviceFault_edit";
	}
	
	/*
	 *此处的method可以取两个值，
	 *一个是RequestMethod.GET，一个是RequestMethod.POST，
	 *就是请求该方法使用的模式，是get还是post，即参数提交的方法
	 *ajax或者form表单提交数据有两种方法，即get和post。
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid DeviceFault deviceFault, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(deviceFaultService.get(deviceFault.getDeviceFaultId()) != null){
			result = new CustomResult(0, "该设备故障编号已经存在，请更换设备故障编号！", null);
		}else{
			result = deviceFaultService.insert(deviceFault);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid DeviceFault deviceFault, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceFaultService.update(deviceFault);
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = deviceFaultService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid DeviceFault deviceFault, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceFaultService.updateNote(deviceFault);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid DeviceFault deviceFault, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceFaultService.updateAll(deviceFault);
	}
	
	//根据设备故障id查找
	@RequestMapping("/search_deviceFault_by_deviceFaultId")
	@ResponseBody
	public EUDataGridResult searchDeviceFaultByDeviceFaultId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = deviceFaultService.searchDeviceFaultByDeviceFaultId(page, rows, searchValue);
		return result;
	}
	
	//根据设备名查找
	@RequestMapping("/search_deviceFault_by_deviceName")
	@ResponseBody
	public EUDataGridResult searchDeviceFaultByDeviceName(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = deviceFaultService.searchDeviceFaultByDeviceName(page, rows, searchValue);
		return result;
	}
}
