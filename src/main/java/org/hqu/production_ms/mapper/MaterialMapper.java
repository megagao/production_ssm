package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Material;
import org.hqu.production_ms.domain.MaterialExample;

public interface MaterialMapper {
	
	 //扩展的mapper接口方法
	int deleteBatch(String[] ids);
			
	int changeStatus(String[] ids);
			
	int updateNote(Material record);
		
	List<Material> searchMaterialByMaterialId(String materialId);
	
    int countByExample(MaterialExample example);

    int deleteByExample(MaterialExample example);

    int deleteByPrimaryKey(String materialId);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(String materialId);

    int updateByExampleSelective(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByExample(@Param("record") Material record, @Param("example") MaterialExample example);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);

	List<Material> searchMaterialByMaterialType(String materialName);
}