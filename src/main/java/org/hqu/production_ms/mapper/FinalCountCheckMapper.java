package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.FinalCountCheck;
import org.hqu.production_ms.domain.FinalCountCheckExample;
import org.hqu.production_ms.domain.po.FinalCountCheckPO;

public interface FinalCountCheckMapper {
	//扩展的mapper接口方法
	List<FinalCountCheckPO> find(FinalCountCheck finalCountCheck);
	
	int updateNote(FinalCountCheck finalCountCheck);
	
	int deleteBatch(String[] ids);
	
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

    List<FinalCountCheckPO> searchFCountCheckByFCountCheckId(String fCountCheckId);
    
	List<FinalCountCheckPO> searchFCountCheckByOrderId(String orderId);
}