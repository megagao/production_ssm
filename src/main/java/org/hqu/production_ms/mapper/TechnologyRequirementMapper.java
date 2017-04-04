package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.TechnologyRequirement;
import org.hqu.production_ms.domain.TechnologyRequirementExample;
import org.hqu.production_ms.domain.vo.TechnologyRequirementVO;

public interface TechnologyRequirementMapper {
	
	//扩展的mapper接口方法
	int updateRequirement(TechnologyRequirement technologyRequirement);
	
	List<TechnologyRequirementVO> find(TechnologyRequirement technologyRequirement);
	
	int deleteBatch(String[] ids);
	
	List<TechnologyRequirementVO> searchTechnologyRequirementByTechnologyRequirementId(
            String technologyRequirementId);

	List<TechnologyRequirementVO> searchTechnologyRequirementByTechnologyName(
            String technologyName);
	
	//逆向工程生成的mapper接口
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
}