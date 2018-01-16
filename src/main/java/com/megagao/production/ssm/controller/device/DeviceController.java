package com.megagao.production.ssm.controller.device;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceController {

	@RequestMapping("/deviceList")
	public String deviceList() throws Exception{
		return "deviceList";
	}
	
	@RequestMapping("/deviceType")
	public String deviceType() throws Exception{
		return "deviceType";
	}
	
	@RequestMapping("/deviceCheck")
	public String deviceCheck() throws Exception{
		return "deviceCheck";
	}
	
	@RequestMapping("/deviceFault")
	public String deviceFault() throws Exception{
		return "deviceFault";
	}
	
	@RequestMapping("/deviceMaintain")
	public String deviceMaintain() throws Exception{
		return "deviceMaintain";
	}
	
}
