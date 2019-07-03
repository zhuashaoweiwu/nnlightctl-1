package com.nnlightctl.dao;

import com.nnlightctl.po.Project;
import com.nnlightctl.po.ProjectExample;
import java.util.List;

import com.nnlightctl.vo.ProjectView;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);

    String selectByCountryId(@Param("nnlightctlProjectCountryId") Long countryId);

    String selectByProvinceId(@Param("nnlightctlProjectProvinceId") Long provinceId);

    String selectByCityId(@Param("nnlightctlProjectCityId") Long cityId);

    int selectByLampController(@Param("param") Long projectId);

    int selectByElebox(@Param("param") Long eleboxId);

    List<Project> selectByEquipment(@Param("param") String projectName);




}