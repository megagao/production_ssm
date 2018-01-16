package com.megagao.production.ssm.mapper.authority;

import java.util.List;

import com.megagao.production.ssm.domain.authority.SysRolePermissionExample;
import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.authority.SysRolePermission;

public interface SysRolePermissionMapper {
	int updateRolePermission(SysRolePermission sysRolePermission);
	
    int countByExample(SysRolePermissionExample example);

    int deleteByExample(SysRolePermissionExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    List<SysRolePermission> selectByExample(SysRolePermissionExample example);

    SysRolePermission selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByExample(@Param("record") SysRolePermission record, @Param("example") SysRolePermissionExample example);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}