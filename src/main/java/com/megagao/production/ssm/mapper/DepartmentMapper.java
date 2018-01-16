package com.megagao.production.ssm.mapper;

import java.util.List;

import com.megagao.production.ssm.domain.DepartmentExample;
import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.Department;

public interface DepartmentMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	int updateNote(Department record);
		
	List<Department> searchDepartmentByDepartmentId(String departmentId);

	List<Department> searchDepartmentByDepartmentName(String departmentName);
	
		
	//逆向工程生成的mapper接口
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(String departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(String departmentId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}