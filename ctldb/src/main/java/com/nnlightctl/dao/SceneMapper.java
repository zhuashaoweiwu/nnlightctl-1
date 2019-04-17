package com.nnlightctl.dao;

import com.nnlightctl.po.Scene;
import com.nnlightctl.po.SceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SceneMapper {
    int countByExample(SceneExample example);

    int deleteByExample(SceneExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Scene record);

    int insertSelective(Scene record);

    List<Scene> selectByExample(SceneExample example);

    Scene selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Scene record, @Param("example") SceneExample example);

    int updateByExample(@Param("record") Scene record, @Param("example") SceneExample example);

    int updateByPrimaryKeySelective(Scene record);

    int updateByPrimaryKey(Scene record);
}