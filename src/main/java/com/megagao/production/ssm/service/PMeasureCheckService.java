package com.megagao.production.ssm.service;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.ProcessMeasureCheck;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;

public interface PMeasureCheckService {
	
	EUDataGridResult searchPMeasureCheckByPMeasureCheckId(int page, int rows, 
			String pMeasureCheckId) throws Exception;
	
	EUDataGridResult getList(int page, int rows, ProcessMeasureCheck processMeasureCheck) 
			throws Exception;
	
	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(ProcessMeasureCheck processMeasureCheck) throws Exception;

	CustomResult updateAll(ProcessMeasureCheck processMeasureCheck) throws Exception;
    
    CustomResult updateNote(ProcessMeasureCheck processMeasureCheck) throws Exception;
}
