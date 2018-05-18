package com.nnlightctl.dao;

import com.nnlightctl.po.SystemParam;
import com.nnlightctl.po.SystemParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemParamMapper {
    int countByExample(SystemParamExample example);

    int deleteByExample(SystemParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemParam record);

    int insertSelective(SystemParam record);

    List<SystemParam> selectByExample(SystemParamExample example);

    SystemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemParam record, @Param("example") SystemParamExample example);

    int updateByExample(@Param("record") SystemParam record, @Param("example") SystemParamExample example);

    int updateByPrimaryKeySelective(SystemParam record);

    int updateByPrimaryKey(SystemParam record);
}