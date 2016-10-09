package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.po.COrderPO;

public interface OrderService {
	
	EUDataGridResult getOrderList(int page, int rows, COrder cOrder);
	
	COrder get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(COrderPO cOrder);

	//更新部分字段，用的是updateSelective判断非空的字段进行更新
    CustomResult update(COrderPO cOrder);
    
    //更新全部字段，不判断非空，直接进行更新
    CustomResult updateAll(COrderPO cOrder);

    CustomResult changeStatus(String[] ids);
}
