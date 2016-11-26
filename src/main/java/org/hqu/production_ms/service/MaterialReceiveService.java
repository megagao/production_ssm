package org.hqu.production_ms.service;

//import java.util.List;

import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

import org.hqu.production_ms.domain.MaterialReceive;
import org.hqu.production_ms.domain.po.MaterialReceivePO;

public interface MaterialReceiveService {

	   // List<MaterialReceive> find();  
		
		EUDataGridResult getList(int page, int rows);
		
		MaterialReceive get(String string);
		
		CustomResult delete(String string);

		CustomResult deleteBatch(String[] ids);

		CustomResult insert(MaterialReceivePO materialReceive);

		//更新部分字段，用的是updateSelective判断非空的字段进行更新
	    CustomResult update(MaterialReceivePO materialReceive);
	    
	    //更新全部字段，不判断非空，直接进行更新
	    CustomResult updateAll(MaterialReceivePO materialReceive);
	    
	    //更新备注
	    CustomResult updateNote(MaterialReceivePO materialReceive);
	    
	    EUDataGridResult searchMaterialReceiveByReceiveId(int page, int rows, String receiveId);
		
		EUDataGridResult searchMaterialReceiveByMaterialId(int page, int rows,
				String materialId);
}
