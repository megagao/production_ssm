package com.megagao.production.ssm.controller.device;


import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.DeviceMaintainService;
import com.megagao.production.ssm.domain.DeviceMaintain;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceMaintain")
public class DeviceMaintainController {

	@Autowired
	private DeviceMaintainService deviceMaintainService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getListType(Integer page, Integer rows, DeviceMaintain deviceMaintain)
			throws Exception{
		EUDataGridResult result = deviceMaintainService.getList(page, rows, deviceMaintain);
		return result;
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "deviceMaintain_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "deviceMaintain_edit";
	}
	
	/*
	 *此处的method可以取两个值，
	 *一个是RequestMethod.GET，一个是RequestMethod.POST，
	 *就是请求该方法使用的模式，是get还是post，即参数提交的方法
	 *ajax或者form表单提交数据有两种方法，即get和post。
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(deviceMaintainService.get(deviceMaintain.getDeviceMaintainId()) != null){
			result = new CustomResult(0, "该设备维修编号已经存在，请更换设备维修编号！", null);
		}else{
			result = deviceMaintainService.insert(deviceMaintain);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return  deviceMaintainService.update(deviceMaintain);
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = deviceMaintainService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid DeviceMaintain deviceMaintain, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceMaintainService.updateNote(deviceMaintain);
	}
	
	//根据设备维修编号查找
	@RequestMapping("/search_deviceMaintain_by_deviceMaintainId")
	@ResponseBody
	public EUDataGridResult searchDeviceMaintainByDeviceMaintainId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = deviceMaintainService.searchDeviceMaintainByDeviceMaintainId(page, rows, searchValue);
		return result;
	}
	
	//根据设备故障编号查找
	@RequestMapping("/search_deviceMaintain_by_deviceFaultId")
	@ResponseBody
	public EUDataGridResult searchDeviceMaintainByDeviceFaultId(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = deviceMaintainService.searchDeviceMaintainByDeviceFaultId(page, rows, searchValue);
		return result;
	}
}
