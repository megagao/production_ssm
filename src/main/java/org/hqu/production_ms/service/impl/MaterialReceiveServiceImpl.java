package org.hqu.production_ms.service.impl;

import java.util.List;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.MaterialReceive;
import org.hqu.production_ms.domain.po.MaterialReceivePO;
import org.hqu.production_ms.mapper.MaterialReceiveMapper;
import org.hqu.production_ms.service.MaterialReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
	@Autowired
	MaterialReceiveMapper materialReceiveMapper;
	//@Override
/*	public List<MaterialReceive> find() {
		// TODO Auto-generated method stub
		MaterialReceiveExample example = new MaterialReceiveExample();
		return materialReceiveMapper.selectByExample(example);	
	}
*/
	/*@Override
	public EUDataGridResult getList(int page, int rows,
		MaterialReceive materialReceive) {
		// TODO Auto-generated method stub
		//查询列表
		MaterialReceiveExample example = new MaterialReceiveExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceive> list = materialReceiveMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceive> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;		
	}*/

	@Override
	public EUDataGridResult getList(int page, int rows) {
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceive> list = materialReceiveMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceive> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public MaterialReceive get(String string) {
		// TODO Auto-generated method stub
		return materialReceiveMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(MaterialReceivePO materialReceive) {
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.insert(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(MaterialReceivePO materialReceive) {
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(MaterialReceivePO materialReceive) {
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(MaterialReceivePO materialReceive) {
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.updateNote(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	@Override
	public EUDataGridResult searchMaterialReceiveByReceiveId(int page, int rows, String receiveId){
        //分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceive> list = materialReceiveMapper.searchMaterialReceiveByReceiveId(receiveId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceive> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	 }
	@Override	
	public	EUDataGridResult searchMaterialReceiveByMaterialId(int page, int rows,String materialId){
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceive> list = materialReceiveMapper.searchMaterialReceiveByReceiveId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceive> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
		}
	
	
}
