package com.nnlightctl.dao;

import com.nnlightctl.po.LightSignalLog;
import com.nnlightctl.po.LightSignalLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightSignalLogMapper {
    int countByExample(LightSignalLogExample example);

    int deleteByExample(LightSignalLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LightSignalLog record);

    int insertSelective(LightSignalLog record);

    List<LightSignalLog> selectByExample(LightSignalLogExample example);

    LightSignalLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LightSignalLog record, @Param("example") LightSignalLogExample example);

    int updateByExample(@Param("record") LightSignalLog record, @Param("example") LightSignalLogExample example);

    int updateByPrimaryKeySelective(LightSignalLog record);

    int updateByPrimaryKey(LightSignalLog record);
}