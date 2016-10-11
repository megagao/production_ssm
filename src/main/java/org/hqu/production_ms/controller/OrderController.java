package org.hqu.production_ms.controller;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.po.COrderPO;
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
	
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public COrder getItemById(@PathVariable String orderId) {
		COrder cOrder = orderService.get(orderId);
		return cOrder;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "order_list";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "order_add";
	}
	
	@RequestMapping("/edit")
	public String edit() {
		return "order_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, COrder cOrder) {
		EUDataGridResult result = orderService.getList(page, rows, cOrder);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(COrderPO cOrder) throws Exception {
		CustomResult result = orderService.insert(cOrder);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(COrderPO cOrder) throws Exception {
		CustomResult result = orderService.update(cOrder);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(COrderPO cOrder) throws Exception {
		CustomResult result = orderService.updateAll(cOrder);
		return result;
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(COrderPO cOrder) throws Exception {
		CustomResult result = orderService.updateNote(cOrder);
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
		System.out.println(ids);
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
