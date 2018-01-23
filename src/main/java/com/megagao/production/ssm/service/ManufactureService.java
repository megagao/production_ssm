package com.megagao.production.ssm.service;

import java.util.List;

import com.megagao.production.ssm.domain.Manufacture;
import com.megagao.production.ssm.domain.customize.CustomResult;
import com.megagao.production.ssm.domain.customize.EUDataGridResult;
import com.megagao.production.ssm.domain.vo.ManufactureVO;

public interface ManufactureService {
	
	List<ManufactureVO> find() throws Exception;
	
	EUDataGridResult getList(int page, int rows) throws Exception;

	ManufactureVO get(String string) throws Exception;
	
	CustomResult delete(String string) throws Exception;

	CustomResult deleteBatch(String[] ids) throws Exception;

	CustomResult insert(Manufacture manufacture) throws Exception;

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(Manufacture manufacture) throws Exception;
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(Manufacture manufacture) throws Exception;
    
	EUDataGridResult searchManufactureByManufactureSn(Integer page,
			Integer rows, String manufactureSn) throws Exception;
	
	EUDataGridResult searchManufactureByManufactureOrderId(Integer page,
			Integer rows, String manufactureOrderId) throws Exception;

	EUDataGridResult searchManufactureByManufactureTechnologyName(Integer page,
			Integer rows, String manufactureTechnologyName) throws Exception;
}
