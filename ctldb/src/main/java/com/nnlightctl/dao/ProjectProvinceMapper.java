package com.nnlightctl.dao;

import com.nnlightctl.po.ProjectProvince;
import com.nnlightctl.po.ProjectProvinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectProvinceMapper {
    int countByExample(ProjectProvinceExample example);

    int deleteByExample(ProjectProvinceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectProvince record);

    int insertSelective(ProjectProvince record);

    List<ProjectProvince> selectByExample(ProjectProvinceExample example);

    ProjectProvince selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectProvince record, @Param("example") ProjectProvinceExample example);

    int updateByExample(@Param("record") ProjectProvince record, @Param("example") ProjectProvinceExample example);

    int updateByPrimaryKeySelective(ProjectProvince record);

    int updateByPrimaryKey(ProjectProvince record);
}