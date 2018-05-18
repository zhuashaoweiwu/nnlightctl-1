package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.ProjectCountryMapper;
import com.nnlightctl.po.ProjectCountry;
import com.nnlightctl.po.ProjectCountryExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ProjectCountryConditionRequest;
import com.nnlightctl.request.ProjectCountryRequest;
import com.nnlightctl.server.ProjectCountryServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectCountryServerImpl implements ProjectCountryServer {

    @Autowired
    private ProjectCountryMapper projectCountryMapper;

    @Override
    public int addOrUpdateCountry(ProjectCountryRequest request) {
        if (request == null) {
            throw  new RuntimeException("操作对象为空");
        }
        int ret = -1;
        ProjectCountry projectCountry = new ProjectCountry();
        ReflectCopyUtil.beanSameFieldCopy(request, projectCountry);
        projectCountry.setGmtUpdated(new Date());

        if (request.getId() == null) {   //新增
            projectCountry.setGmtCreated(new Date());
            ret = projectCountryMapper.insertSelective(projectCountry);
        } else {    //修改
            ret = projectCountryMapper.updateByPrimaryKeySelective(projectCountry);
        }

        return ret;
    }

    @Override
    public List<ProjectCountry> listCountry(BaseRequest request) {
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        ProjectCountryExample projectCountryExample = new ProjectCountryExample();
        projectCountryExample.setOrderByClause("id DESC");
        List<ProjectCountry> projectCountryList = projectCountryMapper.selectByExample(projectCountryExample);
        return projectCountryList;
    }

    @Override
    public ProjectCountry getCountry(ProjectCountryConditionRequest request) {
        ProjectCountryExample example = new ProjectCountryExample();
        example.createCriteria().andCodeNumberEqualTo(request.getCodeNumber());
        List<ProjectCountry> projectCountryList = this.projectCountryMapper.selectByExample(example);
        if (projectCountryList != null && projectCountryList.size() > 0) {
            return projectCountryList.get(0);
        } else {
            throw new RuntimeException("查无结果");
        }
    }
}
