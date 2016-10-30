package org.hqu.production_ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/device")
public class DeviceController {
	
	
	/*************************  Left Menu  *************************/
	
	@RequestMapping("/deviceList")
	public String deviceList() {
		return "device_list";
	}
	
	@RequestMapping("/deviceType")
	public String deviceType() {
		return "device_type";
	}
	
	@RequestMapping("/deviceCheck")
	public String deviceCheck() {
		return "device_check";
	}
	
	@RequestMapping("/deviceFault")
	public String deviceFault() {
		return "device_fault";
	}
	
	@RequestMapping("/deviceMaintain")
	public String deviceMaintain() {
		return "device_maintain";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "device_list_test";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "device_add";
	}
	
	/*************************  Left Menu  *************************/

}
