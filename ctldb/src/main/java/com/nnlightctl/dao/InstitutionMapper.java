package com.nnlightctl.dao;

import com.nnlightctl.po.Institution;
import com.nnlightctl.po.InstitutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InstitutionMapper {
    int countByExample(InstitutionExample example);

    int deleteByExample(InstitutionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Institution record);

    int insertSelective(Institution record);

    List<Institution> selectByExample(InstitutionExample example);

    Institution selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Institution record, @Param("example") InstitutionExample example);

    int updateByExample(@Param("record") Institution record, @Param("example") InstitutionExample example);

    int updateByPrimaryKeySelective(Institution record);

    int updateByPrimaryKey(Institution record);
}