package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.ECheck;
import org.hqu.production_ms.domain.ECheckExample;

public interface ECheckMapper {
    int countByExample(ECheckExample example);

    int deleteByExample(ECheckExample example);

    int deleteByPrimaryKey(String checkId);

    int insert(ECheck record);

    int insertSelective(ECheck record);

    List<ECheck> selectByExample(ECheckExample example);

    ECheck selectByPrimaryKey(String checkId);

    int updateByExampleSelective(@Param("record") ECheck record, @Param("example") ECheckExample example);

    int updateByExample(@Param("record") ECheck record, @Param("example") ECheckExample example);

    int updateByPrimaryKeySelective(ECheck record);

    int updateByPrimaryKey(ECheck record);
}