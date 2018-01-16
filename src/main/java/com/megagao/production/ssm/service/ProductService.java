package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.Product;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface ProductService {
	
	List<Product> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows, Product product) throws Exception;
	
	Product get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Product product) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Product product) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Product product) throws Exception;
    
    //更新备注
    CustomResult updateNote(Product product) throws Exception;
    
    EUDataGridResult searchProductByProductName(int page, int rows, 
    		String productName) throws Exception;

    EUDataGridResult searchProductByProductId(int page, int rows, 
    		String productId) throws Exception;
    
    EUDataGridResult searchProductByProductType(int page, int rows, 
    		String productType) throws Exception;
}
