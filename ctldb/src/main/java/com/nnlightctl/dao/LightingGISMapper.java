package com.nnlightctl.dao;

import com.nnlightctl.po.LightingGIS;
import com.nnlightctl.po.LightingGISExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LightingGISMapper {
    int countByExample(LightingGISExample example);

    int deleteByExample(LightingGISExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LightingGIS record);

    int insertUploadData(LightingGIS record);

    int insertSelective(LightingGIS record);

    List<LightingGIS> selectByExample(LightingGISExample example);

    LightingGIS selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LightingGIS record, @Param("example") LightingGISExample example);

    int updateByExample(@Param("record") LightingGIS record, @Param("example") LightingGISExample example);

    int updateByPrimaryKeySelective(LightingGIS record);

    int updateByPrimaryKey(LightingGIS record);
}