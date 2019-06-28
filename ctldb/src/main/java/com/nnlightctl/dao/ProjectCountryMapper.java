package com.nnlightctl.dao;

import com.nnlightctl.po.ProjectCountry;
import com.nnlightctl.po.ProjectCountryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCountryMapper {
    int countByExample(ProjectCountryExample example);

    int deleteByExample(ProjectCountryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectCountry record);

    int insertSelective(ProjectCountry record);

    List<ProjectCountry> selectByExample(ProjectCountryExample example);

    ProjectCountry selectByCodeName(@Param("param") String codeNumber);

    ProjectCountry selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectCountry record, @Param("example") ProjectCountryExample example);

    int updateByExample(@Param("record") ProjectCountry record, @Param("example") ProjectCountryExample example);

    int updateByPrimaryKeySelective(ProjectCountry record);

    int updateByPrimaryKey(ProjectCountry record);
}