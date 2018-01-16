package com.megagao.production.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.ProcessCountCheck;
import com.megagao.production.ssm.domain.ProcessCountCheckExample;
import com.megagao.production.ssm.domain.vo.ProcessCountCheckVO;

public interface ProcessCountCheckMapper {
	
	//扩展的mapper接口方法
	int updateNote(ProcessCountCheck processCountCheck);
	
	int deleteBatch(String[] ids);
	
	List<ProcessCountCheckVO> searchPCountCheckByPCountCheckId(String pCountCheckId);
	
	List<ProcessCountCheckVO> find(ProcessCountCheck processCountCheck);
	
	//逆向工程生成的mapper接口
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