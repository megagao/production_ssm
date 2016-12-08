package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Process;
import org.hqu.production_ms.domain.ProcessExample;
import org.hqu.production_ms.domain.TechnologyPlan;

public interface ProcessMapper {
	//扩展的mapper接口方法
	List<TechnologyPlan> find(TechnologyPlan technologyPlan);
	
	int deleteBatch(String[] ids);
	//
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

	List<Process> searchProcessByProcessId(String processId);

	List<Process> searchProcessByTechnologyPlanId(String technologyPlanId);
}