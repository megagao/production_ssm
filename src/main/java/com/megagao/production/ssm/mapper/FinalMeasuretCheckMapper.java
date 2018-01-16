package com.megagao.production.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.FinalMeasuretCheck;
import com.megagao.production.ssm.domain.FinalMeasuretCheckExample;
import com.megagao.production.ssm.domain.vo.FinalMeasuretCheckVO;

public interface FinalMeasuretCheckMapper {
	
	//扩展的mapper接口方法
	List<FinalMeasuretCheckVO> find(FinalMeasuretCheck finalMeasuretCheck);
	
	int updateNote(FinalMeasuretCheck finalMeasuretCheck);
	
	int deleteBatch(String[] ids);

	List<FinalMeasuretCheckVO> searchFMeasureCheckByOrderId(String orderId);
	
	List<FinalMeasuretCheckVO> searchFMeasureCheckByFMeasureCheckId(String finalMeasuretCheckId);
	
	//逆向工程生成的mapper接口
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
}