package com.megagao.production.ssm.service;



import com.megagao.production.ssm.domain.UnqualifyApply;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface UnqualifyService {

	EUDataGridResult getList(Integer page, Integer rows, UnqualifyApply unqualifyApply) throws Exception;

	EUDataGridResult searchUnqualifyByUnqualifyId(int page, int rows, String unqualifyId) throws Exception;
	
	UnqualifyApply get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(UnqualifyApply unqualify) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(UnqualifyApply unqualify) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(UnqualifyApply unqualify) throws Exception;
    
    CustomResult updateNote(UnqualifyApply unqualify) throws Exception;

	EUDataGridResult searchUnqualifyByProductName(Integer page, Integer rows,
			String productName) throws Exception;
}
