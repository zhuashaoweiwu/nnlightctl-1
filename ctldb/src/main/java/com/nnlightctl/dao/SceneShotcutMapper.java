package com.nnlightctl.dao;

import com.nnlightctl.po.SceneShotcut;
import com.nnlightctl.po.SceneShotcutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SceneShotcutMapper {
    int countByExample(SceneShotcutExample example);

    int deleteByExample(SceneShotcutExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SceneShotcut record);

    int insertSelective(SceneShotcut record);

    List<SceneShotcut> selectByExample(SceneShotcutExample example);

    SceneShotcut selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SceneShotcut record, @Param("example") SceneShotcutExample example);

    int updateByExample(@Param("record") SceneShotcut record, @Param("example") SceneShotcutExample example);

    int updateByPrimaryKeySelective(SceneShotcut record);

    int updateByPrimaryKey(SceneShotcut record);
}