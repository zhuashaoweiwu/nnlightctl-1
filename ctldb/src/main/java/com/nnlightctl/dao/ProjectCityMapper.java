package com.nnlightctl.dao;

import com.nnlightctl.po.ProjectCity;
import com.nnlightctl.po.ProjectCityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCityMapper {
    int countByExample(ProjectCityExample example);

    int deleteByExample(ProjectCityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectCity record);

    int insertSelective(ProjectCity record);

    List<ProjectCity> selectByExample(ProjectCityExample example);

    ProjectCity selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectCity record, @Param("example") ProjectCityExample example);

    int updateByExample(@Param("record") ProjectCity record, @Param("example") ProjectCityExample example);

    int updateByPrimaryKeySelective(ProjectCity record);

    int updateByPrimaryKey(ProjectCity record);
}