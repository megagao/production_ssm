package org.hqu.production_ms.service;

import java.util.List;

import org.hqu.production_ms.domain.custom.CustomResult;
import org.hqu.production_ms.domain.custom.EUDataGridResult;
import org.hqu.production_ms.domain.Material;;


public interface MaterialService {

    List<Material> find();  
	
	EUDataGridResult getList(int page, int rows, Material material);
	
	Material get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(Material material);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Material material);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Material material);
    
    //更新备注
    CustomResult updateNote(Material material);
    
    EUDataGridResult searchMaterialByMaterialId(int page, int rows, String materialId);

	EUDataGridResult searchMaterialByMaterialType(Integer page, Integer rows,
			String materialType);
}
