package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.TechnologyPlan;
import org.hqu.production_ms.domain.TechnologyPlanExample;

public interface TechnologyPlanMapper {
	
	//扩展的mapper接口方法
	List<TechnologyPlan> find(TechnologyPlan technologyPlan);
	
	int deleteBatch(String[] ids);

	List<TechnologyPlan> searchTechnologyPlanByTechnologyPlanId(
            String technologyPlanId);

	List<TechnologyPlan> searchTechnologyPlanByTechnologyName(
            String technologyName);
	
	//逆向工程生成的mapper接口
	int countByExample(TechnologyPlanExample example);

    int deleteByExample(TechnologyPlanExample example);

    int deleteByPrimaryKey(String technologyPlanId);

    int insert(TechnologyPlan record);

    int insertSelective(TechnologyPlan record);

    List<TechnologyPlan> selectByExample(TechnologyPlanExample example);

    TechnologyPlan selectByPrimaryKey(String technologyPlanId);

    int updateByExampleSelective(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByExample(@Param("record") TechnologyPlan record, @Param("example") TechnologyPlanExample example);

    int updateByPrimaryKeySelective(TechnologyPlan record);

    int updateByPrimaryKey(TechnologyPlan record);
}