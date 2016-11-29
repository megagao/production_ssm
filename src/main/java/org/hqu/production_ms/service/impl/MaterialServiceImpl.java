package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.Material;
import org.hqu.production_ms.domain.MaterialExample;
import org.hqu.production_ms.mapper.MaterialMapper;
import org.hqu.production_ms.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialMapper materialMapper;
	
	@Override
	public List<Material> find() {
		// TODO Auto-generated method stub
		MaterialExample example = new MaterialExample();
		return materialMapper.selectByExample(example);	
	}

	@Override
	public EUDataGridResult getList(int page, int rows, Material material) {
		// TODO Auto-generated method stub
		
		//查询列表
		MaterialExample example = new MaterialExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Material> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;		
	}

	@Override
	public Material get(String string) {
		// TODO Auto-generated method stub
		return materialMapper.selectByPrimaryKey(string);
		
	}

	@Override
	public CustomResult delete(String string) {
		// TODO Auto-generated method stub
		int i = materialMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
		
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		// TODO Auto-generated method stub
		int i = materialMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
		
	}

	@Override
	public CustomResult insert(Material material) {
		// TODO Auto-generated method stub
		int i = materialMapper.insert(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(Material material) {
		// TODO Auto-generated method stub
		int i = materialMapper.updateByPrimaryKeySelective(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
		
	}

	@Override
	public CustomResult updateAll(Material material) {
		// TODO Auto-generated method stub
		int i = materialMapper.updateByPrimaryKey(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(Material material) {
		// TODO Auto-generated method stub
		int i = materialMapper.updateNote(material);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	@Override
	public EUDataGridResult searchMaterialByMaterialId(int page, int rows, String materialId){
        //分页处理
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.searchMaterialByMaterialId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Material> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchMaterialByMaterialType(Integer page,
			Integer rows, String materialType) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Material> list = materialMapper.searchMaterialByMaterialType(materialType);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Material> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
}
