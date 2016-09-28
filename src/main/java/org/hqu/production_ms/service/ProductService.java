package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.Product;

public interface ProductService {
	
	List<Product> find();  
	
	EUDataGridResult getList(int page, int rows, Product product);
	
	Product get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(Product product);

    CustomResult update(Product product);
}
