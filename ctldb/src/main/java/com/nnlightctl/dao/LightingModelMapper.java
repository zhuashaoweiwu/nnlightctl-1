package com.nnlightctl.dao;

import com.nnlightctl.po.LightingModel;
import com.nnlightctl.po.LightingModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightingModelMapper {
    int countByExample(LightingModelExample example);

    int deleteByExample(LightingModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LightingModel record);

    int insertSelective(LightingModel record);

    List<LightingModel> selectByExample(LightingModelExample example);

    LightingModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LightingModel record, @Param("example") LightingModelExample example);

    int updateByExample(@Param("record") LightingModel record, @Param("example") LightingModelExample example);

    int updateByPrimaryKeySelective(LightingModel record);

    int updateByPrimaryKey(LightingModel record);
}