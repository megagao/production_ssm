package org.hqu.production_ms.mapper.authority;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.authority.SysRoleExample;
import org.hqu.production_ms.domain.po.RolePO;

public interface SysRoleMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	int changeStatus(String[] ids);
	
	
    int countByExample(SysRoleExample example);

    int deleteByExample(SysRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(RolePO role);

    int insertSelective(RolePO role);

    List<SysRole> selectByExample(SysRoleExample example);

    SysRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    int updateByPrimaryKeySelective(RolePO role);

    int updateByPrimaryKey(RolePO role);

	List<SysRole> searchRoleByRoleId(String roleId);

	List<SysRole> searchRoleByRoleName(String roleName);
}