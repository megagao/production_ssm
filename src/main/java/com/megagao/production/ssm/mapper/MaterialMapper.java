package com.megagao.production.ssm.mapper;

import java.util.List;

import com.megagao.production.ssm.domain.Material;
import com.megagao.production.ssm.domain.MaterialExample;
import org.apache.ibatis.annotations.Param;

public interface MaterialMapper {
	
	 //扩展的mapper接口方法
	int deleteBatch(String[] ids);
			
	int changeStatus(String[] ids);
			
	int updateNote(Material record);
		
	List<Material> searchMaterialByMaterialId(String materialId);

	List<Material> searchMaterialByMaterialType(String materialName);
	
	//逆向工程生成的mapper接口
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
}