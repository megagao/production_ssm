package org.hqu.production_ms.mapper;

import java.util.List;
import org.hqu.production_ms.domain.COrder;

public interface COrderMapper {
	
	List<COrder> find(COrder cOrder);
	
	COrder get(String string);
	
    int delete(String string);

    int deleteBatch(String[] ids);

    int insert(COrder cOrder);

    COrder selectByPrimaryKey(String orderId);

    int update(COrder cOrder);

    int changeStatus(String[] ids);
}