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
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/{orderId}")
	@ResponseBody
	public COrder getItemById(@PathVariable String orderId) {
		COrder cOrder = orderService.get(orderId);
		return cOrder;
	}
	
	
	@RequestMapping("/find")
	public String find() {
		return "order_list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, COrder cOrder) {
		EUDataGridResult result = orderService.getOrderList(page, rows, cOrder);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(COrder cOrder) throws Exception {
		CustomResult result = orderService.insert(cOrder);
		return result;
	}
	
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
