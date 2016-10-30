package org.hqu.production_ms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hqu.production_ms.domain.Device;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/deviceList")
public class DeviceListController {
	
	@Autowired
	private DeviceService deviceService;
	
	@InitBinder
    public void InitBinder(HttpServletRequest request,
            ServletRequestDataBinder binder) {
        // 不要删除下行注释!!! 将来"yyyy-MM-dd"将配置到properties文件中
        // SimpleDateFormat dateFormat = new
        // SimpleDateFormat(getText("date.format", request.getLocale()));
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null, new CustomDateEditor(
                dateFormat, true));
    }
	
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public Device getItemById(@PathVariable String orderId) {
		Device device = deviceService.get(orderId);
		return device;
	}
	
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, Device device) {
		EUDataGridResult result = deviceService.getList(page, rows, device);
		return result;
	}
	
	@RequestMapping("/list_name")
	@ResponseBody
	public List<?> getList_Name() {
	EUDataGridResult result = deviceService.getList_Name();
		return result.getRows();
	}
	
	@RequestMapping("/list_type")
	@ResponseBody
	public List<?> getList_Type() {
	EUDataGridResult result = deviceService.getList_Type();
		return result.getRows();
	}
	
	
	/*
	 *此处的method可以取两个值，
	 *一个是RequestMethod.GET，一个是RequestMethod.POST，
	 *就是请求该方法使用的模式，是get还是post，即参数提交的方法
	 *ajax或者form表单提交数据有两种方法，即get和post。
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(Device device) throws Exception {
		CustomResult result = deviceService.insert(device);
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String deviceId) throws Exception {
		CustomResult result = deviceService.delete(deviceId);
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(Device device) throws Exception {
		CustomResult result = deviceService.update(device);
		return result;
	}
}
