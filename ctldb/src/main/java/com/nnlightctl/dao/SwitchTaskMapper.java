package com.nnlightctl.dao;

import com.nnlightctl.po.SwitchTask;
import com.nnlightctl.po.SwitchTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SwitchTaskMapper {
    int countByExample(SwitchTaskExample example);

    int deleteByExample(SwitchTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SwitchTask record);

    int insertSelective(SwitchTask record);

    List<SwitchTask> selectByExample(SwitchTaskExample example);

    SwitchTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SwitchTask record, @Param("example") SwitchTaskExample example);

    int updateByExample(@Param("record") SwitchTask record, @Param("example") SwitchTaskExample example);

    int updateByPrimaryKeySelective(SwitchTask record);

    int updateByPrimaryKey(SwitchTask record);
}