package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Product;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface ProductService {
	
	List<Product> find();  
	
	EUDataGridResult getList(int page, int rows, Product product);
	
	Product get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(Product product);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Product product);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Product product);
    
    //更新备注
    CustomResult updateNote(Product product);
    
    EUDataGridResult searchProductByProductName(int page, int rows, 
    		String productName);

    EUDataGridResult searchProductByProductId(int page, int rows, 
    		String productId);
    
    EUDataGridResult searchProductByProductType(int page, int rows, 
    		String productType);
}
