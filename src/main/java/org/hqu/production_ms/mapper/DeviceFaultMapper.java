package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.DeviceFault;
import org.hqu.production_ms.domain.DeviceFaultExample;
import org.hqu.production_ms.domain.po.DeviceFaultPO;

public interface DeviceFaultMapper {
	//扩展的mapper接口方法
	List<DeviceFaultPO> find(DeviceFault deviceFault);
		
	List<DeviceFault> getData();
	
	int deleteBatch(String[] deviceFaultIds);
	
	int updateNote(DeviceFault deviceFault);
    
	//自动生成的mapper接口方法
    int countByExample(DeviceFaultExample example);

    int deleteByExample(DeviceFaultExample example);

    int deleteByPrimaryKey(String deviceFaultId);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    List<DeviceFault> selectByExample(DeviceFaultExample example);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByExampleSelective(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByExample(@Param("record") DeviceFault record, @Param("example") DeviceFaultExample example);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

	List<DeviceFault> searchDeviceFaultByDeviceFaultId(String deviceFaultId);

	List<DeviceFault> searchDeviceFaultByDeviceName(String deviceName);

}