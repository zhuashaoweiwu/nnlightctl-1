package com.nnlightctl.dao;

import com.nnlightctl.po.AlarmConfig;
import com.nnlightctl.po.AlarmConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarmConfigMapper {
    int countByExample(AlarmConfigExample example);

    int deleteByExample(AlarmConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AlarmConfig record);

    int insertSelective(AlarmConfig record);

    List<AlarmConfig> selectByExample(AlarmConfigExample example);

    AlarmConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AlarmConfig record, @Param("example") AlarmConfigExample example);

    int updateByExample(@Param("record") AlarmConfig record, @Param("example") AlarmConfigExample example);

    int updateByPrimaryKeySelective(AlarmConfig record);

    int updateByPrimaryKey(AlarmConfig record);
}