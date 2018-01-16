package com.megagao.production.ssm.service.impl;

import java.util.List;

import com.megagao.production.ssm.domain.MaterialReceive;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.vo.MaterialReceiveVO;
import com.megagao.production.ssm.service.MaterialReceiveService;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.mapper.MaterialReceiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MaterialReceiveServiceImpl implements MaterialReceiveService {
	
	@Autowired
	MaterialReceiveMapper materialReceiveMapper;

	@Override
	public EUDataGridResult getList(int page, int rows) throws Exception{
		
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceiveVO> list = materialReceiveMapper.find();
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceiveVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	@Override
	public MaterialReceive get(String string) throws Exception{
		// TODO Auto-generated method stub
		return materialReceiveMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) throws Exception{
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) throws Exception{
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(MaterialReceive materialReceive) throws Exception{
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.insert(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "新增物料收入信息失败");
		}
	}

	@Override
	public CustomResult update(MaterialReceive materialReceive) throws Exception{
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.updateByPrimaryKeySelective(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料收入信息失败");
		}
	}

	@Override
	public CustomResult updateAll(MaterialReceive materialReceive) throws Exception{
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.updateByPrimaryKey(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料收入信息失败");
		}
	}

	@Override
	public CustomResult updateNote(MaterialReceive materialReceive) throws Exception{
		// TODO Auto-generated method stub
		int i = materialReceiveMapper.updateNote(materialReceive);
		if(i>0){
			return CustomResult.ok();
		}else{
			return CustomResult.build(101, "修改物料收入备注失败");
		}
	}
	
	@Override
	public EUDataGridResult searchMaterialReceiveByReceiveId(int page, int rows, String receiveId)
			throws Exception{
        //分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceiveVO> list = materialReceiveMapper.searchMaterialReceiveByReceiveId(receiveId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceiveVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	 }
	
	@Override	
	public	EUDataGridResult searchMaterialReceiveByMaterialId(int page, int rows,String materialId)
			throws Exception{
		//分页处理
		PageHelper.startPage(page, rows);
		List<MaterialReceiveVO> list = materialReceiveMapper.searchMaterialReceiveByMaterialId(materialId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<MaterialReceiveVO> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
