package com.megagao.production.ssm.mapper;

import java.util.List;

import com.megagao.production.ssm.domain.vo.ProcessMeasureCheckVO;
import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.ProcessMeasureCheck;
import com.megagao.production.ssm.domain.ProcessMeasureCheckExample;

public interface ProcessMeasureCheckMapper {
	
	//扩展的mapper接口方法
	int updateNote(ProcessMeasureCheck processMeasureCheck);
	
	int deleteBatch(String[] ids);
	
	List<ProcessMeasureCheckVO> searchPMeasureCheckByPMeasureCheckId(String processMeasureCheckId);
	
	List<ProcessMeasureCheckVO> find(ProcessMeasureCheck processMeasureCheck);
	
	//逆向工程生成的mapper接口
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