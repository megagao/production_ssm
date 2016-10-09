package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.COrder;
import org.hqu.production_ms.domain.COrderExample;
import org.hqu.production_ms.domain.po.COrderPO;

public interface COrderMapper {
	
	//扩展的mapper接口方法
	List<COrder> find(COrder cOrder);
	
	int deleteBatch(String[] ids);
	
	int changeStatus(String[] ids);
	
	int updateNote(COrderPO cOrder);
	
	//自动生成的mapper接口方法
    int countByExample(COrderExample example);

    int deleteByExample(COrderExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(COrderPO record);

    int insertSelective(COrderPO record);

    List<COrder> selectByExample(COrderExample example);

    COrder selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByExample(@Param("record") COrder record, @Param("example") COrderExample example);

    int updateByPrimaryKeySelective(COrderPO record);

    int updateByPrimaryKey(COrderPO cOrder);
}