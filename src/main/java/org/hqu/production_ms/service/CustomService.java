package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.Custom;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;

public interface CustomService {
	
	List<Custom> find();  
	
	EUDataGridResult getList(int page, int rows, Custom custom);
	
	Custom get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(Custom custom);

    CustomResult update(Custom custom);

    CustomResult changeStatus(String[] ids);
}
