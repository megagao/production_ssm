package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.Material;;


public interface MaterialService {

    List<Material> find() throws Exception;  
	
	EUDataGridResult getList(int page, int rows, Material material) throws Exception;
	
	Material get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Material material) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Material material) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Material material) throws Exception;
    
    //更新备注
    CustomResult updateNote(Material material) throws Exception;
    
    EUDataGridResult searchMaterialByMaterialId(int page, int rows, String materialId) 
    		throws Exception;

	EUDataGridResult searchMaterialByMaterialType(Integer page, Integer rows,
			String materialType) throws Exception;
}
