package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.ProcessMeasureCheck;
import org.hqu.production_ms.domain.ProcessMeasureCheckExample;
import org.hqu.production_ms.domain.po.ProcessMeasureCheckPO;

public interface ProcessMeasureCheckMapper {
	int updateNote(ProcessMeasureCheck processMeasureCheck);
	
	List<ProcessMeasureCheckPO> searchPMeasureCheckByPMeasureCheckId(String processMeasureCheckId);
	
	List<ProcessMeasureCheckPO> find(ProcessMeasureCheck processMeasureCheck);
	
	int deleteBatch(String[] ids);
	
    int countByExample(ProcessMeasureCheckExample example);

    int deleteByExample(ProcessMeasureCheckExample example);

    int deleteByPrimaryKey(String pMeasureCheckId);

    int insert(ProcessMeasureCheck record);

    int insertSelective(ProcessMeasureCheck record);

    List<ProcessMeasureCheck> selectByExample(ProcessMeasureCheckExample example);

    ProcessMeasureCheck selectByPrimaryKey(String pMeasureCheckId);

    int updateByExampleSelective(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByExample(@Param("record") ProcessMeasureCheck record, @Param("example") ProcessMeasureCheckExample example);

    int updateByPrimaryKeySelective(ProcessMeasureCheck record);

    int updateByPrimaryKey(ProcessMeasureCheck record);
}