package com.megagao.production.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.megagao.production.ssm.domain.vo.ManufactureVO;
import com.megagao.production.ssm.domain.ManufactureExample;
import com.megagao.production.ssm.domain.Manufacture;

public interface ManufactureMapper {
	
	//扩展的mapper接口方法
	List<ManufactureVO> find();
	
	int deleteBatch(String[] ids);
	
	List<ManufactureVO> searchManufactureByManufactureSn(String manufactureSn);

	List<ManufactureVO> searchManufactureByManufactureOrderId(
            String manufactureOrderId);

	List<ManufactureVO> searchManufactureByManufactureTechnologyName(
            String manufactureTechnologyName);
	
	//逆向工程生成的mapper接口
    int countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    List<ManufactureVO> selectByExample(ManufactureExample example);

    ManufactureVO selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);
}