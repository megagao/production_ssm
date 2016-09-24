package org.hqu.production_ms.service;

import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;

public interface OrderService {
	
	EUDataGridResult getOrderList(int page, int rows, COrder cOrder);
	
	COrder get(String string);
	
	CustomResult delete(String string);

	CustomResult deleteBatch(String[] ids);

	CustomResult insert(COrder cOrder);

    CustomResult update(COrder cOrder);

    CustomResult changeStatus(String[] ids);
}
