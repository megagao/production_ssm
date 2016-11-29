package org.hqu.production_ms.service.impl;

import java.util.List;



import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.MaterialConsume;
import org.hqu.production_ms.domain.MaterialConsumeExample;
import org.hqu.production_ms.domain.po.MaterialConsumePO;
import org.hqu.production_ms.mapper.MaterialConsumeMapper;
import org.hqu.production_ms.service.MaterialConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MaterialConsumeServiceImpl implements MaterialConsumeService {

	@Autowired
	MaterialConsumeMapper materialConsumeMapper;
	
	@Override
	public List<MaterialConsume> find() {
		// TODO Auto-generated method stub
		MaterialConsumeExample example = new MaterialConsumeExample();
		return materialConsumeMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult getList(int page, int rows, MaterialConsume materialConsume) {
		// TODO Auto-generated method stub
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsume> list = materialConsumeMapper.find(materialConsume);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public MaterialConsume get(String id) {
		// TODO Auto-generated method stub
		return materialConsumeMapper.selectByPrimaryKey(id);
	}

	@Override
	public CustomResult delete(String id) {
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.deleteByPrimaryKey(id);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(MaterialConsumePO materialConsume) {
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.insert(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(MaterialConsumePO materialConsume) {
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.updateByPrimaryKeySelective(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(MaterialConsumePO materialConsume) {
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.updateByPrimaryKey(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(MaterialConsumePO materialConsume) {
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.updateNote(materialConsume);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult changeStatus(String[] ids) {
		// TODO Auto-generated method stub
		int i = materialConsumeMapper.changeStatus(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public EUDataGridResult searchMaterialConsumeByConsumeId(int page, int rows, String consumeId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsume> list = materialConsumeMapper.searchMaterialConsumeByConsumeId(consumeId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public EUDataGridResult searchMaterialConsumeByMaterialId(int page, int rows, String materialId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsume> list = materialConsumeMapper.searchMaterialConsumeByMaterialId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchMaterialConsumeByWorkId(int page, int rows, String workId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialConsume> list = materialConsumeMapper.searchMaterialConsumeByWorkId(workId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialConsume> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

}
