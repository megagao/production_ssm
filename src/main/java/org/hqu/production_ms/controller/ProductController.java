package org.hqu.production_ms.controller;

import java.util.List;

import org.hqu.production_ms.domain.Custom;
import org.hqu.production_ms.domain.Product;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public Product getItemById(@PathVariable String productId) {
		Product cProduct = productService.get(productId);
		return cProduct;
	}
	
	@RequestMapping("/find")
	public String find() {
		return "product_list";
	}
	
	@RequestMapping("/get_data")
	@ResponseBody
	public List<Product> getData() {
		return productService.find();
	}
	
	@RequestMapping("/add")
	public String add() {
		return "product_add";
	}
	
	/*@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows, Product cProduct) {
		EUDataGridResult result = productService.getProductList(page, rows, cProduct);
		return result;
	}*/
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	@ResponseBody
	private CustomResult insert(Product cProduct) throws Exception {
		CustomResult result = productService.insert(cProduct);
		return result;
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
	
}
