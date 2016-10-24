package org.hqu.production_ms.mapper.authority;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.authority.SysUser;
import org.hqu.production_ms.domain.authority.SysUserExample;
import org.hqu.production_ms.domain.po.UserPO;

public interface SysUserMapper {
	//扩展的mapper接口方法
	List<UserPO> find(SysUser record);
	
	int deleteBatch(String[] ids);
	
	int changeStatus(String[] ids);
	
	
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserPO userPO);

    int insertSelective(UserPO userPO);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(UserPO userPO);

    int updateByPrimaryKey(UserPO userPO);
}