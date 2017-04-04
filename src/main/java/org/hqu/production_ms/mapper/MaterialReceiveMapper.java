package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.MaterialReceiveExample;
import org.hqu.production_ms.domain.MaterialReceive;
import org.hqu.production_ms.domain.vo.MaterialReceiveVO;

public interface MaterialReceiveMapper {
    
	//扩展的mapper接口方法
    List<MaterialReceiveVO> find();
    
	int deleteBatch(String[] ids);
			
	int updateNote(MaterialReceive record);
	
    List<MaterialReceiveVO> searchMaterialReceiveByReceiveId(String receiveId);
	
	List<MaterialReceiveVO> searchMaterialReceiveByMaterialId(String materialId);
	
	//逆向工程生成的mapper接口
	int countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceive record);

    int insertSelective(MaterialReceive record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceive record);

    int updateByPrimaryKey(MaterialReceive record);
}