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

    CustomResult update(COrderPO cOrder);
    
    CustomResult updateAll(COrderPO cOrder);

    CustomResult changeStatus(String[] ids);
}
