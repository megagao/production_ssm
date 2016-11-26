package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.MaterialConsume;
import org.hqu.production_ms.domain.po.MaterialConsumePO;


public interface MaterialConsumeService {
    
	List<MaterialConsume> find(); 
	
	EUDataGridResult getList(int page, int rows, MaterialConsume materialConsume);
	
	MaterialConsume get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(MaterialConsumePO materialConsume);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(MaterialConsumePO materialConsume);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(MaterialConsumePO materialConsume);
    
    CustomResult updateNote(MaterialConsumePO materialConsume);

    CustomResult changeStatus(String[] ids);
    
    EUDataGridResult searchMaterialConsumeByConsumeId(int page, int rows, String consumeId);
	
   	EUDataGridResult searchMaterialConsumeByMaterialId(int page, int rows,
   			String materialId);
   	
   	EUDataGridResult searchMaterialConsumeByWorkId(int page, int rows,
   			String workId);
    
}
