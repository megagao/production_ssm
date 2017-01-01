package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Work;
import org.hqu.production_ms.domain.WorkExample;
import org.hqu.production_ms.domain.po.WorkPO;

public interface WorkMapper {
	
	//扩展的mapper接口方法
	int deleteBatch(String[] ids);
	
	List<Work> find();

	List<Work> searchWorkByWorkId(String workId);

	List<Work> searchWorkByWorkProduct(String workProduct);

	List<Work> searchWorkByWorkDevice(String workDevice);

	List<Work> searchWorkByWorkProcess(String workProcess);
	
	//逆向工程生成的mapper接口
    int countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(String workId);

    int insert(WorkPO record);

    int insertSelective(WorkPO record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(String workId);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(WorkPO record);

    int updateByPrimaryKey(WorkPO record);
}