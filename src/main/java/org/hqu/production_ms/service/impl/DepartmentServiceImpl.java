package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.Department;
import org.hqu.production_ms.domain.DepartmentExample;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.mapper.DepartmentMapper;
import org.hqu.production_ms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, Department department) {
		//查询商品列表
		DepartmentExample example = new DepartmentExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public Department get(String string) {
		
		return departmentMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		int i = departmentMapper.deleteByPrimaryKey(string);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = departmentMapper.deleteBatch(ids);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(Department department) {
		int i = departmentMapper.insert(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(Department department) {
		int i = departmentMapper.updateByPrimaryKeySelective(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(Department department) {
		int i = departmentMapper.updateByPrimaryKey(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateNote(Department department) {
		int i = departmentMapper.updateNote(department);
		if(i>0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}
	
	@Override
	public List<Department> find() {
		DepartmentExample example = new DepartmentExample();
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> searchDepartmentByDepartmentId(String departmentId) {
		DepartmentExample example = new DepartmentExample();
		DepartmentExample.Criteria criteria = example.createCriteria();
		criteria.andDepartmentIdLike(departmentId);
		return departmentMapper.selectByExample(example);
	}

	@Override
	public EUDataGridResult searchDepartmentByDepartmentId(Integer page,
			Integer rows, String departmentId) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.searchDepartmentByDepartmentId(departmentId);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public EUDataGridResult searchDepartmentByDepartmentName(Integer page,
			Integer rows, String departmentName) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<Department> list = departmentMapper.searchDepartmentByDepartmentName(departmentName);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<Department> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
