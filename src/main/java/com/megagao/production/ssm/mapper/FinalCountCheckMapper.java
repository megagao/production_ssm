package com.megagao.production.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.FinalCountCheck;
import com.megagao.production.ssm.domain.FinalCountCheckExample;
import com.megagao.production.ssm.domain.vo.FinalCountCheckVO;

public interface FinalCountCheckMapper {
	
	//扩展的mapper接口方法
	List<FinalCountCheckVO> find(FinalCountCheck finalCountCheck);
	
	int updateNote(FinalCountCheck finalCountCheck);
	
	int deleteBatch(String[] ids);
	
    List<FinalCountCheckVO> searchFCountCheckByFCountCheckId(String fCountCheckId);
    
	List<FinalCountCheckVO> searchFCountCheckByOrderId(String orderId);
	
	//逆向工程生成的mapper接口
    int countByExample(FinalCountCheckExample example);

    int deleteByExample(FinalCountCheckExample example);

    int deleteByPrimaryKey(String fCountCheckId);

    int insert(FinalCountCheck record);

    int insertSelective(FinalCountCheck record);

    List<FinalCountCheck> selectByExample(FinalCountCheckExample example);

    FinalCountCheck selectByPrimaryKey(String fCountCheckId);

    int updateByExampleSelective(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByExample(@Param("record") FinalCountCheck record, @Param("example") FinalCountCheckExample example);

    int updateByPrimaryKeySelective(FinalCountCheck record);

    int updateByPrimaryKey(FinalCountCheck record);
}