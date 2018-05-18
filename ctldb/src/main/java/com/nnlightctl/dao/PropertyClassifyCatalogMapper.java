package com.nnlightctl.dao;

import com.nnlightctl.po.PropertyClassifyCatalog;
import com.nnlightctl.po.PropertyClassifyCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropertyClassifyCatalogMapper {
    int countByExample(PropertyClassifyCatalogExample example);

    int deleteByExample(PropertyClassifyCatalogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PropertyClassifyCatalog record);

    int insertSelective(PropertyClassifyCatalog record);

    List<PropertyClassifyCatalog> selectByExample(PropertyClassifyCatalogExample example);

    PropertyClassifyCatalog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PropertyClassifyCatalog record, @Param("example") PropertyClassifyCatalogExample example);

    int updateByExample(@Param("record") PropertyClassifyCatalog record, @Param("example") PropertyClassifyCatalogExample example);

    int updateByPrimaryKeySelective(PropertyClassifyCatalog record);

    int updateByPrimaryKey(PropertyClassifyCatalog record);
}