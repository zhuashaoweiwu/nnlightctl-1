package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.ProjectCityMapper;
import com.nnlightctl.po.ProjectCity;
import com.nnlightctl.po.ProjectCityExample;
import com.nnlightctl.request.BaseRequest;
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
    public List<ProjectCity> listCity(BaseRequest request) {
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        ProjectCityExample example = new ProjectCityExample();
        example.setOrderByClause("id DESC");
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
}
