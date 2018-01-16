package com.megagao.production.ssm.mapper.authority;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.vo.RoleVO;
import com.megagao.production.ssm.domain.authority.SysRoleExample;
import com.megagao.production.ssm.domain.authority.SysRole;

public interface SysRoleMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	int changeStatus(String[] ids);


    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRole role);

    int insertSelective(SysRole role);

    List<RoleVO> selectByExample(SysRoleExample example);

    RoleVO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleVO record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") RoleVO record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(SysRole role);

    int updateByPrimaryKey(SysRole role);

	List<RoleVO> searchRoleByRoleId(String roleId);

	List<RoleVO> searchRoleByRoleName(String roleName);
}