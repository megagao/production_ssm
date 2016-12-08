package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.ProcessCountCheck;
import org.hqu.production_ms.domain.ProcessCountCheckExample;

public interface ProcessCountCheckMapper {
	int updateNote(ProcessCountCheck processCountCheck);
	
	List<ProcessCountCheck> searchPCountCheckByPCountCheckId(String pCountCheckId);
	
	List<ProcessCountCheck> find(ProcessCountCheck processCountCheck);
	
	int deleteBatch(String[] ids);
	
    int countByExample(ProcessCountCheckExample example);

    int deleteByExample(ProcessCountCheckExample example);

    int deleteByPrimaryKey(String pCountCheckId);

    int insert(ProcessCountCheck record);

    int insertSelective(ProcessCountCheck record);

    List<ProcessCountCheck> selectByExample(ProcessCountCheckExample example);

    ProcessCountCheck selectByPrimaryKey(String pCountCheckId);

    int updateByExampleSelective(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByExample(@Param("record") ProcessCountCheck record, @Param("example") ProcessCountCheckExample example);

    int updateByPrimaryKeySelective(ProcessCountCheck record);

    int updateByPrimaryKey(ProcessCountCheck record);
}