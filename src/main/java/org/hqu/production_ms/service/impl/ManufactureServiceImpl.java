package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.vo.ManufactureVO;
import org.hqu.production_ms.domain.ManufactureExample;
import org.hqu.production_ms.domain.customize.CustomResult;
import org.hqu.production_ms.domain.customize.EUDataGridResult;
import org.hqu.production_ms.domain.Manufacture;
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
	public EUDataGridResult getList(int page, int rows) throws Exception{
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<ManufactureVO> list = manufactureMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Manufacture get(String id) throws Exception{
		
		return manufactureMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult delete(String id) throws Exception{
		int i = manufactureMapper.deleteByPrimaryKey(id);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		int i = manufactureMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Manufacture manufacture) throws Exception{
		int i = manufactureMapper.insert(manufacture);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增生产计划信息失败");
		}
	}

	@Override
	public CustomResult update(Manufacture manufacture) throws Exception{
		int i = manufactureMapper.updateByPrimaryKeySelective(manufacture);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改生产计划信息失败");
		}
	}

	@Override
	public CustomResult updateAll(Manufacture manufacture) throws Exception{
		int i = manufactureMapper.updateByPrimaryKey(manufacture);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改生产计划信息失败");
		}
	}

	@Override
	public List<Manufacture> find() throws Exception{
		ManufactureExample example = new ManufactureExample();
		return manufactureMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchManufactureByManufactureSn(Integer page,
			Integer rows, String manufactureSn) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<ManufactureVO> list = manufactureMapper.searchManufactureByManufactureSn(manufactureSn);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchManufactureByManufactureOrderId(Integer page,
			Integer rows, String manufactureOrderId) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<ManufactureVO> list = manufactureMapper.searchManufactureByManufactureOrderId(manufactureOrderId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchManufactureByManufactureTechnologyName(
			Integer page, Integer rows, String manufactureTechnologyName) throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<ManufactureVO> list = manufactureMapper
				.searchManufactureByManufactureTechnologyName(manufactureTechnologyName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<ManufactureVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
