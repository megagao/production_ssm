package com.megagao.production.ssm.controller.device;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.Device;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceList")
public class DeviceListController {

	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, Device device) throws Exception{
		EUDataGridResult result = deviceService.getList(page, rows, device);
		return result;
	}
	
	@RequestMapping("/get/{deviceId}")
	@ResponseBody
	public Device getItemById(@PathVariable String deviceId) throws Exception{
		Device device = deviceService.get(deviceId);
		return device;
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Device> getData() throws Exception{
		return deviceService.find();
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "deviceList_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "deviceList_edit";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Device device, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(deviceService.get(device.getDeviceId()) != null){
			result = new CustomResult(0, "该设备编号已经存在，请更换设备编号！", null);
		}else{
			result = deviceService.insert(device);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid Device device, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceService.update(device);
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = deviceService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid Device device, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceService.updateNote(device);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Device device, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return deviceService.updateAll(device);
	}
	
	//根据设备编号查找设备
	@RequestMapping("/search_device_by_deviceId")
	@ResponseBody
	public EUDataGridResult searchDeviceByDeviceId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = deviceService.searchDeviceByDeviceId(page, rows, searchValue);
		return result;
	}
	
	//根据设备名称查找设备
	@RequestMapping("/search_device_by_deviceName")
	@ResponseBody
	public EUDataGridResult searchDeviceByDeviceName(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = deviceService.searchDeviceByDeviceName(page, rows, searchValue);
		return result;
	}
	
	//根据设备种类名称查找设备
	@RequestMapping("/search_device_by_deviceTypeName")
	@ResponseBody
	public EUDataGridResult searchDeviceByDeviceTypeName(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = deviceService.searchDeviceByDeviceTypeName(page, rows, searchValue);
		return result;
	}
}
