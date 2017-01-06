package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Work;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.WorkPO;

public interface WorkService {
	
	List<Work> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Work work) throws Exception;
	
	Work get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(WorkPO work) throws Exception;

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(WorkPO work) throws Exception;
    
    CustomResult update(WorkPO work) throws Exception;
    
	EUDataGridResult searchWorkByWorkId(Integer page, Integer rows,
			String workId) throws Exception;

	EUDataGridResult searchWorkByWorkProduct(Integer page, Integer rows,
			String workProduct) throws Exception;

	EUDataGridResult searchWorkByWorkDevice(Integer page, Integer rows,
			String workDevice) throws Exception;

	EUDataGridResult searchWorkByWorkProcess(Integer page, Integer rows,
			String workProcess) throws Exception;
}
