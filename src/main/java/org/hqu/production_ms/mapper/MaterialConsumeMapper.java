package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.MaterialConsume;
import org.hqu.production_ms.domain.MaterialConsumeExample;
import org.hqu.production_ms.domain.po.MaterialConsumePO;

public interface MaterialConsumeMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
		
	int updateNote(MaterialConsumePO materialConsume);
	
	List<MaterialConsume> find(MaterialConsume materialConsume);
	
    List<MaterialConsume> searchMaterialConsumeByConsumeId(String consumeId);
	
	List<MaterialConsume> searchMaterialConsumeByMaterialId(String materialId);
	
	List<MaterialConsume> searchMaterialConsumeByWorkId(String workId);
	
	//逆向工程生成的mapper接口
    int countByExample(MaterialConsumeExample example);

    int deleteByExample(MaterialConsumeExample example);

    int deleteByPrimaryKey(String consumeId);

    int insert(MaterialConsumePO record);

    int insertSelective(MaterialConsumePO record);

    List<MaterialConsume> selectByExample(MaterialConsumeExample example);

    MaterialConsume selectByPrimaryKey(String consumeId);

    int updateByExampleSelective(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByExample(@Param("record") MaterialConsume record, @Param("example") MaterialConsumeExample example);

    int updateByPrimaryKeySelective(MaterialConsumePO record);

    int updateByPrimaryKey(MaterialConsumePO record);
}