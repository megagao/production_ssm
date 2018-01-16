package com.megagao.production.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.UnqualifyApply;
import com.megagao.production.ssm.domain.UnqualifyApplyExample;
import com.megagao.production.ssm.domain.vo.UnqualifyApplyVO;

public interface UnqualifyApplyMapper {
	
	//扩展的mapper接口方法
	List<UnqualifyApplyVO> find(UnqualifyApply unqualifyApply);
	
	int updateNote(UnqualifyApply unqualifyApply);
	
	int deleteBatch(String[] ids);
	
	List<UnqualifyApplyVO> searchUnqualifyByUnqualifyId(String orderId);
	
	List<UnqualifyApplyVO> searchUnqualifyByProductName(String productName);
	
	//逆向工程生成的mapper接口	
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