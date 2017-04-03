package org.hqu.production_ms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.hqu.production_ms.domain.Manufacture;
import org.hqu.production_ms.domain.ManufactureExample;
import org.hqu.production_ms.domain.po.ManufacturePO;

public interface ManufactureMapper {
	
	//扩展的mapper接口方法
	List<Manufacture> find();
	
	int deleteBatch(String[] ids);
	
	List<Manufacture> searchManufactureByManufactureSn(String manufactureSn);

	List<Manufacture> searchManufactureByManufactureOrderId(
			String manufactureOrderId);

	List<Manufacture> searchManufactureByManufactureTechnologyName(
			String manufactureTechnologyName);
	
	//逆向工程生成的mapper接口
    int countByExample(ManufactureExample example);

    int deleteByExample(ManufactureExample example);

    int deleteByPrimaryKey(String manufactureSn);

    int insert(ManufacturePO record);

    int insertSelective(ManufacturePO record);

    List<Manufacture> selectByExample(ManufactureExample example);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByExampleSelective(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByExample(@Param("record") Manufacture record, @Param("example") ManufactureExample example);

    int updateByPrimaryKeySelective(ManufacturePO record);

    int updateByPrimaryKey(ManufacturePO record);
}