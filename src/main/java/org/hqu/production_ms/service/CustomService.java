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

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Custom custom);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Custom custom);
    
    //更新备注
    CustomResult updateNote(Custom custom);


    CustomResult changeStatus(String[] ids);
}
