package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.FinalMeasuretCheck;
import org.hqu.production_ms.domain.FinalMeasuretCheckExample;

public interface FinalMeasuretCheckMapper {
	
	//扩展的mapper接口方法
	List<FinalMeasuretCheck> find(FinalMeasuretCheck finalMeasuretCheck);
	
	int updateNote(FinalMeasuretCheck finalMeasuretCheck);
	
	int deleteBatch(String[] ids);
		
    int countByExample(FinalMeasuretCheckExample example);

    int deleteByExample(FinalMeasuretCheckExample example);

    int deleteByPrimaryKey(String fMeasureCheckId);

    int insert(FinalMeasuretCheck record);

    int insertSelective(FinalMeasuretCheck record);

    List<FinalMeasuretCheck> selectByExample(FinalMeasuretCheckExample example);

    FinalMeasuretCheck selectByPrimaryKey(String fMeasureCheckId);

    int updateByExampleSelective(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByExample(@Param("record") FinalMeasuretCheck record, @Param("example") FinalMeasuretCheckExample example);

    int updateByPrimaryKeySelective(FinalMeasuretCheck record);

    int updateByPrimaryKey(FinalMeasuretCheck record);

	List<FinalMeasuretCheck> searchFMeasureCheckByOrderId(String orderId);
	
	List<FinalMeasuretCheck> searchFMeasureCheckByFMeasureCheckId(String finalMeasuretCheckId);
}