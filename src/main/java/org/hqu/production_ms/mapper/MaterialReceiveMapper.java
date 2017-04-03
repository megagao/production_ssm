package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.MaterialReceive;
import org.hqu.production_ms.domain.MaterialReceiveExample;
import org.hqu.production_ms.domain.po.MaterialReceivePO;

public interface MaterialReceiveMapper {
    
	//扩展的mapper接口方法
    List<MaterialReceive> find();
    
	int deleteBatch(String[] ids);
			
	int updateNote(MaterialReceivePO record);
	
    List<MaterialReceive> searchMaterialReceiveByReceiveId(String receiveId);
	
	List<MaterialReceive> searchMaterialReceiveByMaterialId(String materialId);
	
	//逆向工程生成的mapper接口
	int countByExample(MaterialReceiveExample example);

    int deleteByExample(MaterialReceiveExample example);

    int deleteByPrimaryKey(String receiveId);

    int insert(MaterialReceivePO record);

    int insertSelective(MaterialReceivePO record);

    List<MaterialReceive> selectByExample(MaterialReceiveExample example);

    MaterialReceive selectByPrimaryKey(String receiveId);

    int updateByExampleSelective(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByExample(@Param("record") MaterialReceive record, @Param("example") MaterialReceiveExample example);

    int updateByPrimaryKeySelective(MaterialReceivePO record);

    int updateByPrimaryKey(MaterialReceivePO record);
}