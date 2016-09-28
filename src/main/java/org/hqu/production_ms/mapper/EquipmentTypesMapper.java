package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.EquipmentTypes;
import org.hqu.production_ms.domain.EquipmentTypesExample;

public interface EquipmentTypesMapper {
    int countByExample(EquipmentTypesExample example);

    int deleteByExample(EquipmentTypesExample example);

    int deleteByPrimaryKey(String typesId);

    int insert(EquipmentTypes record);

    int insertSelective(EquipmentTypes record);

    List<EquipmentTypes> selectByExample(EquipmentTypesExample example);

    EquipmentTypes selectByPrimaryKey(String typesId);

    int updateByExampleSelective(@Param("record") EquipmentTypes record, @Param("example") EquipmentTypesExample example);

    int updateByExample(@Param("record") EquipmentTypes record, @Param("example") EquipmentTypesExample example);

    int updateByPrimaryKeySelective(EquipmentTypes record);

    int updateByPrimaryKey(EquipmentTypes record);
}