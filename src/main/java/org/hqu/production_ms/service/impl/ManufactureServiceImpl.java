package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Manufacture;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.ManufacturePO;
import org.hqu.production_ms.mapper.ManufactureMapper;
import org.hqu.production_ms.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ManufactureServiceImpl implements ManufactureService{

	@Autowired
	ManufactureMapper manufactureMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<Manufacture> list = manufactureMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Manufacture> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Manufacture get(String id) {
		
		return manufactureMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult delete(String id) {
		int i = manufactureMapper.deleteByPrimaryKey(id);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = manufactureMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(ManufacturePO manufacture) {
		int i = manufactureMapper.insert(manufacture);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(ManufacturePO manufacture) {
		int i = manufactureMapper.updateByPrimaryKeySelective(manufacture);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(ManufacturePO manufacture) {
		int i = manufactureMapper.updateByPrimaryKey(manufacture);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

}
