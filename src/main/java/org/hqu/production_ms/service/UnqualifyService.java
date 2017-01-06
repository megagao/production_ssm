package org.hqu.production_ms.service;



import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;

public interface UnqualifyService {

	EUDataGridResult getList(Integer page, Integer rows, UnqualifyApply unqualifyApply);

	EUDataGridResult searchUnqualifyByUnqualifyId(int page, int rows, String unqualifyId);
	
	UnqualifyApply get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(UnqualifyApply unqualify);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UnqualifyApply unqualify);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(UnqualifyApply unqualify);
    
    CustomResult updateNote(UnqualifyApply unqualify);

	EUDataGridResult searchUnqualifyByProductName(Integer page, Integer rows,
			String productName);
}
