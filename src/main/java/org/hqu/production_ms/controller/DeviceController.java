package org.hqu.production_ms.controller;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/device")
public class DeviceController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public COrder getItemById(@PathVariable String orderId) {
		COrder cOrder = orderService.get(orderId);
		return cOrder;
	}
	
	
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
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, COrder cOrder) {
		EUDataGridResult result = orderService.getList(page, rows, cOrder);
		return result;
	}
	
	/*@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(COrder cOrder) throws Exception {
		CustomResult result = orderService.insert(cOrder);
		return result;
	}*/
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = orderService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = orderService.deleteBatch(ids);
		return result;
	}
	
	@RequestMapping(value="/change_status")
	@ResponseBody
	public CustomResult changeStatus(String[] ids) {
		CustomResult result = orderService.changeStatus(ids);
		return result;
	}
}
