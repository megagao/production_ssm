package com.megagao.production.ssm.controller.scheduling;

import java.util.List;

import javax.validation.Valid;

import com.megagao.production.ssm.domain.Product;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.service.ProductService;
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
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/get/{productId}")
	@ResponseBody
	public Product getItemById(@PathVariable String productId) throws Exception{
		Product cProduct = productService.get(productId);
		return cProduct;
	}
	
	@RequestMapping("/find")
	public String find() throws Exception{
		return "product_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Product> getData() throws Exception{
		return productService.find();
	}
	
	@RequestMapping("/add")
	public String add() throws Exception{
		return "product_add";
	}
	
	@RequestMapping("/edit")
	public String edit() throws Exception{
		return "product_edit";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Product product) throws Exception{
		EUDataGridResult result = productService.getList(page, rows, product);
		return result;
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(@Valid Product product, BindingResult bindingResult) throws Exception {
		CustomResult result;
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		if(productService.get(product.getProductId()) != null){
			result = new CustomResult(0, "该产品编号已经存在，请更换产品编号！", null);
		}else{
			result = productService.insert(product);
		}
		return result;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody
	private CustomResult update(@Valid Product product, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return productService.update(product);
	}
	
	@RequestMapping(value="/update_all")
	@ResponseBody
	private CustomResult updateAll(@Valid Product product, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return productService.updateAll(product);
	}
	
	@RequestMapping(value="/update_note")
	@ResponseBody
	private CustomResult updateNote(@Valid Product product, BindingResult bindingResult) throws Exception {
		if(bindingResult.hasErrors()){
			FieldError fieldError = bindingResult.getFieldError();
			return CustomResult.build(100, fieldError.getDefaultMessage());
		}
		return productService.updateNote(product);
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	private CustomResult delete(String id) throws Exception {
		CustomResult result = productService.delete(id);
		return result;
	}
	
	@RequestMapping(value="/delete_batch")
	@ResponseBody
	private CustomResult deleteBatch(String[] ids) throws Exception {
		CustomResult result = productService.deleteBatch(ids);
		return result;
	}
	
	//根据产品id查找
	@RequestMapping("/search_product_by_productId")
	@ResponseBody
	public EUDataGridResult searchProductByProductId(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = productService.searchProductByProductId(page, rows, searchValue);
		return result;
	}
	
	//根据产品名称查找
	@RequestMapping("/search_product_by_productName")
	@ResponseBody
	public EUDataGridResult searchProductByProductName(Integer page, Integer rows, String searchValue) throws Exception{
		EUDataGridResult result = productService.searchProductByProductName(page, rows, searchValue);
		return result;
	}
	
	//根据产品类型查找
	@RequestMapping("/search_product_by_productType")
	@ResponseBody
	public EUDataGridResult searchProductByProductType(Integer page, Integer rows, String searchValue) 
			throws Exception{
		EUDataGridResult result = productService.searchProductByProductType(page, rows, searchValue);
		return result;
	}
}
