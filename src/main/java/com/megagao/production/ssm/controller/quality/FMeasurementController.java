package com.megagao.production.ssm.controller.quality;


import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.MeasureService;
import com.megagao.production.ssm.domain.FinalMeasuretCheck;
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
@RequestMapping("/measure")
public class FMeasurementController {

	@Autowired
	private MeasureService measureService;
	
	/*
	 * @responsebody表示该方法的返回结果直接写入HTTP response body中。
	 * 一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径，
	 * 加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
	 * 比如异步获取json数据，加上@responsebody后，会直接返回json数据。
	 * 
	 * GET模式下，这里使用了@PathVariable绑定输入参数，非常适合Restful风格。
	 * 因为隐藏了参数与路径的关系，可以提升网站的安全性，静态化页面，降低恶意攻击风险。
	 * POST模式下，使用@RequestBody绑定请求对象，Spring会帮你进行协议转换，将Json、Xml协议转换成你需要的对象。
	 * @ResponseBody可以标注任何对象，由Srping完成对象——协议的转换。
	 * 
	 * 一般是指定要response 的type 比如json 或 xml 。
	 * 可以直接用jackson或jaxb的包，然后就可以自动返回了，
	 * xml中也无需多的配置，就可以使用了
	 * 
	 */
	@RequestMapping("/get/{finalMeasuretCheckId}")
	@ResponseBody
	public FinalMeasuretCheck getItemById(@PathVariable String finalMeasuretCheckId) throws Exception{
		FinalMeasuretCheck finalMeasuretCheck = measureService.get(finalMeasuretCheckId);
		return finalMeasuretCheck;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "measurement_list";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "measurement_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "measurement_edit";
	}

	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, FinalMeasuretCheck finalMeasuretCheck) 
			throws Exception{
		EUDataGridResult result = measureService.getList(page, rows, finalMeasuretCheck);
		return result;
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid FinalMeasuretCheck finalMeasuretCheck, BindingResult bindingResult)
			throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(measureService.get(finalMeasuretCheck.getfMeasureCheckId()) != null){
			result = new CustomResult(0, "该成品计量质检编号已经存在，请更换！", null);
		}else{
			result = measureService.insert(finalMeasuretCheck);
		}
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid FinalMeasuretCheck finalMeasuretCheck, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return measureService.updateAll(finalMeasuretCheck);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid FinalMeasuretCheck finalMeasuretCheck, BindingResult bindingResult) 
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return measureService.updateNote(finalMeasuretCheck);
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = measureService.deleteBatch(ids);
		return result;
	}

	//根据成品计量质检id查找
	@RequestMapping("/search_fMeasureCheck_by_fMeasureCheckId")
	@ResponseBody
	public EUDataGridResult searchFMeasureCheckByFMeasureCheckId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = measureService.searchFMeasureCheckByFMeasureCheckId(page, rows, searchValue);
		return result;
	}

	//根据订单id查找
	@RequestMapping("/search_fMeasureCheck_by_orderId")
	@ResponseBody
	public EUDataGridResult searchFMeasureCheckByOrderId(Integer page, Integer rows, String searchValue)
			throws Exception{
		EUDataGridResult result = measureService.searchFMeasureCheckByOrderId(page, rows, searchValue);
		return result;
	}
}
