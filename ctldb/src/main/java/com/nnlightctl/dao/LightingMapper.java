package com.nnlightctl.dao;

import com.nnlightctl.po.Lighting;
import com.nnlightctl.po.LightingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightingMapper {
    int countByExample(LightingExample example);

    int deleteByExample(LightingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Lighting record);

    int insertSelective(Lighting record);

    List<Lighting> selectByExample(LightingExample example);

    Lighting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Lighting record, @Param("example") LightingExample example);

    int updateByExample(@Param("record") Lighting record, @Param("example") LightingExample example);

    int updateByPrimaryKeySelective(Lighting record);

    int updateByPrimaryKey(Lighting record);

    List<Lighting> selectByExampleDeploy(LightingExample example);
}