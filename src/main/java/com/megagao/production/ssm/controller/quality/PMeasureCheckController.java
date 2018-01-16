package com.megagao.production.ssm.controller.quality;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.PMeasureCheckService;
import com.megagao.production.ssm.domain.vo.COrderVO;
import com.megagao.production.ssm.domain.ProcessMeasureCheck;
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
@RequestMapping("/p_measure_check")
public class PMeasureCheckController {

	@Autowired
	private PMeasureCheckService pMeasureCheckService;
	
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
	@RequestMapping("/get/{orderId}")
	@ResponseBody
	public COrderVO getItemById(@PathVariable String orderId) throws Exception{
		return null;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "p_measure_check_list";
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "p_measure_check_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "p_measure_check_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getList(Integer page, Integer rows, ProcessMeasureCheck processMeasureCheck)
			throws Exception{
		EUDataGridResult result = pMeasureCheckService.getList(page, rows, processMeasureCheck);
		return result;
	}
	
	/*
	 *此处的method可以取两个值，
	 *一个是RequestMethod.GET，一个是RequestMethod.POST，
	 *就是请求该方法使用的模式，是get还是post，即参数提交的方法
	 *ajax或者form表单提交数据有两种方法，即get和post。
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult)
			throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		result = pMeasureCheckService.insert(processMeasureCheck);
		return result;
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult)
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return pMeasureCheckService.updateAll(processMeasureCheck);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid ProcessMeasureCheck processMeasureCheck, BindingResult bindingResult) 
			throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return pMeasureCheckService.updateNote(processMeasureCheck);
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		System.out.println(ids);
		CustomResult result = pMeasureCheckService.deleteBatch(ids);
		return result;
	}

	//根据工序计量质检id查找
	@RequestMapping("/search_pMeasureCheck_by_pMeasureCheckId")
	@ResponseBody
	public EUDataGridResult searchOrderByOrderId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = pMeasureCheckService
				.searchPMeasureCheckByPMeasureCheckId(page, rows, searchValue);
		return result;
	}
}
