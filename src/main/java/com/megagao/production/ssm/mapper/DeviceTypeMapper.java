package com.megagao.production.ssm.mapper;

import java.util.List;

import com.megagao.production.ssm.domain.DeviceTypeExample;
import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.DeviceType;

public interface DeviceTypeMapper {
	//扩展的mapper接口方法
	List<DeviceType> find(DeviceType deviceType);
	
	List<DeviceType> listType();
	
	int deleteBatch(String[] deviceTypeIds);

	//根据设备种类id查找设备种类信息
	List<DeviceType> searchDeviceTypeByDeviceTypeId(String deviceTypeId);

	//根据设备种类名称查找设备种类信息
	List<DeviceType> searchDeviceTypeByDeviceTypeName(String deviceTypeName);
	
    
	//逆向工程生成的mapper接口
    int countByExample(DeviceTypeExample example);

    int deleteByExample(DeviceTypeExample example);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    List<DeviceType> selectByExample(DeviceTypeExample example);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByExampleSelective(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByExample(@Param("record") DeviceType record, @Param("example") DeviceTypeExample example);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);
}