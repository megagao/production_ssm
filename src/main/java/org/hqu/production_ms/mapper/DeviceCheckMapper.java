package org.hqu.production_ms.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.DeviceCheck;
import org.hqu.production_ms.domain.DeviceCheckExample;

public interface DeviceCheckMapper {
    int countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);
}