package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.UnqualifyApply;
import org.hqu.production_ms.domain.UnqualifyApplyExample;

public interface UnqualifyApplyMapper {
	
	//扩展的mapper接口方法
	List<UnqualifyApply> find(UnqualifyApply unqualifyApply);
	
	int updateNote(UnqualifyApply unqualifyApply);
	
	int deleteBatch(String[] ids);
	
	List<UnqualifyApply> searchUnqualifyByUnqualifyId(String orderId);
	
    int countByExample(UnqualifyApplyExample example);

    int deleteByExample(UnqualifyApplyExample example);

    int deleteByPrimaryKey(String unqualifyApplyId);

    int insert(UnqualifyApply record);

    int insertSelective(UnqualifyApply record);

    List<UnqualifyApply> selectByExample(UnqualifyApplyExample example);

    UnqualifyApply selectByPrimaryKey(String unqualifyApplyId);

    int updateByExampleSelective(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByExample(@Param("record") UnqualifyApply record, @Param("example") UnqualifyApplyExample example);

    int updateByPrimaryKeySelective(UnqualifyApply record);

    int updateByPrimaryKey(UnqualifyApply record);
}