package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.EquipmentFailure;
import org.hqu.production_ms.domain.EquipmentFailureExample;

public interface EquipmentFailureMapper {
    int countByExample(EquipmentFailureExample example);

    int deleteByExample(EquipmentFailureExample example);

    int deleteByPrimaryKey(String failureId);

    int insert(EquipmentFailure record);

    int insertSelective(EquipmentFailure record);

    List<EquipmentFailure> selectByExample(EquipmentFailureExample example);

    EquipmentFailure selectByPrimaryKey(String failureId);

    int updateByExampleSelective(@Param("record") EquipmentFailure record, @Param("example") EquipmentFailureExample example);

    int updateByExample(@Param("record") EquipmentFailure record, @Param("example") EquipmentFailureExample example);

    int updateByPrimaryKeySelective(EquipmentFailure record);

    int updateByPrimaryKey(EquipmentFailure record);
}