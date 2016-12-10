package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.TechnologyRequirement;
import org.hqu.production_ms.domain.TechnologyRequirementExample;

public interface TechnologyRequirementMapper {
	//扩展的mapper接口方法
	int updateRequirement(TechnologyRequirement technologyRequirement);
	
	List<TechnologyRequirement> find(TechnologyRequirement technologyRequirement);
	
	int deleteBatch(String[] ids);
	//
	int countByExample(TechnologyRequirementExample example);

    int deleteByExample(TechnologyRequirementExample example);

    int deleteByPrimaryKey(String technologyRequirementId);

    int insert(TechnologyRequirement record);

    int insertSelective(TechnologyRequirement record);

    List<TechnologyRequirement> selectByExample(TechnologyRequirementExample example);

    TechnologyRequirement selectByPrimaryKey(String technologyRequirementId);

    int updateByExampleSelective(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByExample(@Param("record") TechnologyRequirement record, @Param("example") TechnologyRequirementExample example);

    int updateByPrimaryKeySelective(TechnologyRequirement record);

    int updateByPrimaryKey(TechnologyRequirement record);

	List<TechnologyRequirement> searchTechnologyRequirementByTechnologyRequirementId(
			String technologyRequirementId);

	List<TechnologyRequirement> searchTechnologyRequirementByTechnologyName(
			String technologyName);
}