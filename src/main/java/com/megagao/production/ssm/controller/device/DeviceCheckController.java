package com.megagao.production.ssm.controller.device;


import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.DeviceCheck;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.service.DeviceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceCheck")
public class DeviceCheckController {
	
	@Autowired
	private DeviceCheckService deviceCheckService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getListType(Integer page, Integer rows, DeviceCheck deviceCheck) throws Exception{
		EUDataGridResult result = deviceCheckService.getList(page, rows, deviceCheck);
		return result;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "deviceCheck_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "deviceCheck_edit";
	}
	
	/*
	 *此处的method可以取两个值，
	 *一个是RequestMethod.GET，一个是RequestMethod.POST，
	 *就是请求该方法使用的模式，是get还是post，即参数提交的方法
	 *ajax或者form表单提交数据有两种方法，即get和post。
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid DeviceCheck deviceCheck, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(deviceCheckService.get(deviceCheck.getDeviceCheckId()) != null){
			result = new CustomResult(0, "该设备例检编号已经存在，请更换设备例检编号！", null);
		}else{
			result = deviceCheckService.insert(deviceCheck);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid DeviceCheck deviceCheck, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceCheckService.update(deviceCheck);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid DeviceCheck deviceCheck, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceCheckService.updateNote(deviceCheck);
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = deviceCheckService.deleteBatch(ids);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_deviceCheck_by_deviceCheckId")
	@ResponseBody
	public EUDataGridResult searchDeviceCheckByDeviceCheckId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = deviceCheckService.searchDeviceCheckByDeviceCheckId(page, rows, searchValue);
		return result;
	}
	
	//搜索
	@RequestMapping("/search_deviceCheck_by_deviceName")
	@ResponseBody
	public EUDataGridResult searchDeviceCheckByDeviceName(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = deviceCheckService.searchDeviceCheckByDeviceName(page, rows, searchValue);
		return result;
	}
}
