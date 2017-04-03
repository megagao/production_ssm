package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.DeviceCheck;
import org.hqu.production_ms.domain.DeviceCheckExample;

public interface DeviceCheckMapper {
	
	//扩展的mapper接口方法
	List<DeviceCheck> find(DeviceCheck deviceCheck);
	
	int deleteBatch(String[] deviceCheckIds);
	
	//根据设备id查找设备例检信息
	List<DeviceCheck> searchDeviceCheckByDeviceCheckId(String deviceCheckId);

	//根据设备名称查找设备例检信息
	List<DeviceCheck> searchDeviceCheckByDeviceName(String deviceName);
	
    
	//逆向工程生成的mapper接口
    int countByExample(DeviceCheckExample example);

    int deleteByExample(DeviceCheckExample example);

    int deleteByPrimaryKey(String deviceCheckId);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    List<DeviceCheck> selectByExample(DeviceCheckExample example);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByExampleSelective(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByExample(@Param("record") DeviceCheck record, @Param("example") DeviceCheckExample example);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);

	int updateNote(DeviceCheck deviceCheck);
}