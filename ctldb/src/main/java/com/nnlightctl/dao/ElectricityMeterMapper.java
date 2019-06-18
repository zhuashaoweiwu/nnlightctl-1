package com.nnlightctl.dao;

import com.nnlightctl.parameter.ElectricityMeterParameter;
import com.nnlightctl.po.ElectricityMeter;
import com.nnlightctl.po.ElectricityMeterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElectricityMeterMapper {
    long countByExample(ElectricityMeterExample example);

    int deleteByExample(ElectricityMeterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ElectricityMeter record);

    int insertSelective(ElectricityMeter record);

    List<ElectricityMeter> selectByExample(ElectricityMeterExample example);

    ElectricityMeter selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ElectricityMeter record, @Param("example") ElectricityMeterExample example);

    int updateByExample(@Param("record") ElectricityMeter record, @Param("example") ElectricityMeterExample example);

    int updateByPrimaryKeySelective(ElectricityMeter record);

    int updateByPrimaryKey(ElectricityMeter record);

    List<ElectricityMeter> selectByParams(@Param("params") ElectricityMeterParameter parameter);
}