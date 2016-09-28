package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.EquipmentType;
import org.hqu.production_ms.domain.EquipmentTypeExample;

public interface EquipmentTypeMapper {
    int countByExample(EquipmentTypeExample example);

    int deleteByExample(EquipmentTypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(EquipmentType record);

    int insertSelective(EquipmentType record);

    List<EquipmentType> selectByExample(EquipmentTypeExample example);

    EquipmentType selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") EquipmentType record, @Param("example") EquipmentTypeExample example);

    int updateByExample(@Param("record") EquipmentType record, @Param("example") EquipmentTypeExample example);

    int updateByPrimaryKeySelective(EquipmentType record);

    int updateByPrimaryKey(EquipmentType record);
}