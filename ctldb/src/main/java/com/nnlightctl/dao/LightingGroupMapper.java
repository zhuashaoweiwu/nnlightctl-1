package com.nnlightctl.dao;

import com.nnlightctl.po.LightingGroup;
import com.nnlightctl.po.LightingGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightingGroupMapper {
    int countByExample(LightingGroupExample example);

    int deleteByExample(LightingGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LightingGroup record);

    int insertSelective(LightingGroup record);

    List<LightingGroup> selectByExample(LightingGroupExample example);

    LightingGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LightingGroup record, @Param("example") LightingGroupExample example);

    int updateByExample(@Param("record") LightingGroup record, @Param("example") LightingGroupExample example);

    int updateByPrimaryKeySelective(LightingGroup record);

    int updateByPrimaryKey(LightingGroup record);
}