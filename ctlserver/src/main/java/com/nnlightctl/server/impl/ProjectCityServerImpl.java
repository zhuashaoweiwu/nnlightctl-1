package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.ProjectCityMapper;
import com.nnlightctl.po.Project;
import com.nnlightctl.po.ProjectCity;
import com.nnlightctl.po.ProjectCityExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.CityConditionRequest;
import com.nnlightctl.request.ProjectCityConditionRequest;
import com.nnlightctl.request.ProjectCityRequest;
import com.nnlightctl.server.ProjectCityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectCityServerImpl implements ProjectCityServer {

    @Autowired
    private ProjectCityMapper projectCityMapper;

    @Override
    public List<ProjectCity> listCity(CityConditionRequest request) {
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        ProjectCityExample example = new ProjectCityExample();
        example.setOrderByClause("id DESC");

        if (request.getNnlightctlProjectProvinceId() != null) {
            example.createCriteria().andNnlightctlProjectProvinceIdEqualTo(request.getNnlightctlProjectProvinceId());
        }

        return projectCityMapper.selectByExample(example);
    }

    @Override
    public ProjectCity getCity(ProjectCityConditionRequest request) {
        ProjectCityExample example = new ProjectCityExample();
        example.createCriteria().andCodeNumberEqualTo(request.getCodeNumber());
        List<ProjectCity> projectCityList = projectCityMapper.selectByExample(example);
        if (projectCityList != null && projectCityList.size() > 0) {
            return projectCityList.get(0);
        } else {
            throw new RuntimeException("查无结果");
        }
    }

    @Override
    public ProjectCity getCityById(Long id) {
        return projectCityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addOrUpdateCity(ProjectCityRequest request) {
        int ret = -1;
        ProjectCity projectCity = new ProjectCity();
        ReflectCopyUtil.beanSameFieldCopy(request, projectCity);
        projectCity.setGmtUpdated(new Date());

        if (request.getId() == null) {  //新增
            projectCity.setGmtCreated(new Date());
            ret = projectCityMapper.insertSelective(projectCity);
        } else {    //修改
            ret = projectCityMapper.updateByPrimaryKeySelective(projectCity);
        }
        return ret;
    }
    @Override
    public int getCountCityByCodeNumber(String codeNumber){
        ProjectCityExample projectCityExample = new ProjectCityExample();
        projectCityExample.createCriteria().andCodeNumberEqualTo(codeNumber);
        int total = projectCityMapper.countByExample(projectCityExample);
        return total;
    }
    @Override
    public int getCountCityByCityName(String cityName){
        ProjectCityExample projectCityExample = new ProjectCityExample();
        projectCityExample.createCriteria().andCityNameEqualTo(cityName);
        int total = projectCityMapper.countByExample(projectCityExample);
        return total;
    }
}
