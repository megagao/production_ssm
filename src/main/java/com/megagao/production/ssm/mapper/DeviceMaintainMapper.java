package com.megagao.production.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.DeviceMaintain;
import com.megagao.production.ssm.domain.DeviceMaintainExample;

public interface DeviceMaintainMapper {
	//扩展的mapper接口方法
	List<DeviceMaintain> find(DeviceMaintain deviceMaintain);

	int updateNote(DeviceMaintain deviceMaintain);
	
	int deleteBatch(String[] DeviceMaintainIds);
    
	//根据设备维修id查找设备维修信息
	List<DeviceMaintain> searchDeviceMaintainByDeviceMaintainId(String deviceMaintainId);

	//根据设备故障id查找设备维修信息
	List<DeviceMaintain> searchDeviceMaintainByDeviceFaultId(String deviceFaultId);
	
	
	//逆向工程生成的mapper接口
    int countByExample(DeviceMaintainExample example);

    int deleteByExample(DeviceMaintainExample example);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    List<DeviceMaintain> selectByExample(DeviceMaintainExample example);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByExampleSelective(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByExample(@Param("record") DeviceMaintain record, @Param("example") DeviceMaintainExample example);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);
}