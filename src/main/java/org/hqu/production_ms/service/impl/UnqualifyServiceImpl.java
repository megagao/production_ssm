package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.UnqualifyApplyMapper;
import org.hqu.production_ms.service.UnqualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UnqualifyServiceImpl implements UnqualifyService{

	@Autowired
	UnqualifyApplyMapper unqualifyApplyMapper; 
	
	@Override
	public EUDataGridResult getList(Integer page, Integer rows, UnqualifyApply unqualifyApply) {
		
		PageHelper.startPage(page, rows);
		List<UnqualifyApply> list = unqualifyApplyMapper.find(unqualifyApply);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public UnqualifyApply get(String string) {
		return unqualifyApplyMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		int i = unqualifyApplyMapper.deleteByPrimaryKey(string);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = unqualifyApplyMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(UnqualifyApply unqualify) {
		int i = unqualifyApplyMapper.insert(unqualify);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(UnqualifyApply unqualify) {
		int i = unqualifyApplyMapper.updateByPrimaryKeySelective(unqualify);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(UnqualifyApply unqualifyApply) {
		int i = unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(UnqualifyApply unqualify) {
		
		int i = unqualifyApplyMapper.updateNote(unqualify);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public EUDataGridResult searchUnqualifyByUnqualifyId(int page, int rows,
			String unqualifyId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<UnqualifyApply> list = unqualifyApplyMapper.searchUnqualifyByUnqualifyId(unqualifyId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<UnqualifyApply> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	





}
