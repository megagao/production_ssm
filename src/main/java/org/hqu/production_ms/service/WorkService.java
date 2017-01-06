package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Work;
import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.po.WorkPO;

public interface WorkService {
	
	List<Work> find();  
	
	EUDataGridResult getList(int page, int rows, Work work);
	
	Work get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(WorkPO work);

    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(WorkPO work);
    
    CustomResult update(WorkPO work);
    
	EUDataGridResult searchWorkByWorkId(Integer page, Integer rows,
			String workId);

	EUDataGridResult searchWorkByWorkProduct(Integer page, Integer rows,
			String workProduct);

	EUDataGridResult searchWorkByWorkDevice(Integer page, Integer rows,
			String workDevice);

	EUDataGridResult searchWorkByWorkProcess(Integer page, Integer rows,
			String workProcess);
}
