package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.MaterialConsume;
import org.hqu.production_ms.domain.po.MaterialConsumePO;


public interface MaterialConsumeService {
    
	List<MaterialConsume> find() throws Exception; 
	
	EUDataGridResult getList(int page, int rows, MaterialConsume materialConsume) 
			throws Exception;
	
	MaterialConsume get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(MaterialConsumePO materialConsume) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(MaterialConsumePO materialConsume) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(MaterialConsumePO materialConsume) throws Exception;
    
    CustomResult updateNote(MaterialConsumePO materialConsume) throws Exception;

    EUDataGridResult searchMaterialConsumeByConsumeId(int page, int rows, String consumeId) 
    		throws Exception;
	
   	EUDataGridResult searchMaterialConsumeByMaterialId(int page, int rows,
   			String materialId) throws Exception;
   	
   	EUDataGridResult searchMaterialConsumeByWorkId(int page, int rows,
   			String workId) throws Exception;
}
