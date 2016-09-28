package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.Product;
import org.hqu.production_ms.domain.ProductExample;
import org.hqu.production_ms.mapper.ProductMapper;
import org.hqu.production_ms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductMapper productMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Product product) {
		//查询商品列表
		ProductExample example = new ProductExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Product> list = productMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Product> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Product get(String string) {
		
		return productMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		productMapper.deleteByPrimaryKey(string);
		return CustomResult.ok();
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		productMapper.deleteBatch(ids);
		return CustomResult.ok();
	}

	@Override
	public CustomResult insert(Product product) {
		productMapper.insert(product);
		return CustomResult.ok();
	}

	@Override
	public CustomResult update(Product product) {
		productMapper.updateByPrimaryKeySelective(product);
		return CustomResult.ok();
	}

	@Override
	public List<Product> find() {
		ProductExample example = new ProductExample();
		
		return productMapper.selectByExample(example);
	}

}
