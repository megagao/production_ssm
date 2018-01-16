package com.megagao.production.ssm.service;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.MaterialReceive;

public interface MaterialReceiveService {
		
	EUDataGridResult getList(int page, int rows) throws Exception;
	
	MaterialReceive get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;
	
	CustomResult insert(MaterialReceive materialReceive) throws Exception;
	
	//更新部分字段，用的是updateSelective判断非空的字段进行更新
	CustomResult update(MaterialReceive materialReceive) throws Exception;
	
	//更新全部字段，不判断非空，直接进行更新
	CustomResult updateAll(MaterialReceive materialReceive) throws Exception;
	
	//更新备注
	CustomResult updateNote(MaterialReceive materialReceive) throws Exception;
	
	EUDataGridResult searchMaterialReceiveByReceiveId(int page, int rows, String receiveId) throws Exception;
	
	EUDataGridResult searchMaterialReceiveByMaterialId(int page, int rows,
			String materialId) throws Exception;
}
