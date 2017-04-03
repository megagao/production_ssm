package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Process;
import org.hqu.production_ms.domain.ProcessExample;

public interface ProcessMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);

	List<Process> searchProcessByProcessId(String processId);

	List<Process> searchProcessByTechnologyPlanId(String technologyPlanId);
	
	//逆向工程生成的mapper接口
	int countByExample(ProcessExample example);

    int deleteByExample(ProcessExample example);

    int deleteByPrimaryKey(String processId);

    int insert(Process record);

    int insertSelective(Process record);

    List<Process> selectByExample(ProcessExample example);

    Process selectByPrimaryKey(String processId);

    int updateByExampleSelective(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByExample(@Param("record") Process record, @Param("example") ProcessExample example);

    int updateByPrimaryKeySelective(Process record);

    int updateByPrimaryKey(Process record);
}