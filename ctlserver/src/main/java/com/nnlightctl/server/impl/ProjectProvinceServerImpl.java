package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.ProjectProvinceMapper;
import com.nnlightctl.po.ProjectProvince;
import com.nnlightctl.po.ProjectProvinceExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ProjectProvinceConditionRequest;
import com.nnlightctl.request.ProjectProvinceRequest;
import com.nnlightctl.server.ProjectProvinceServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectProvinceServerImpl implements ProjectProvinceServer {

    @Autowired
    private ProjectProvinceMapper projectProvinceMapper;

    @Override
    public List<ProjectProvince> listProvince(BaseRequest request) {
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        ProjectProvinceExample example = new ProjectProvinceExample();
        example.setOrderByClause("id DESC");
        return projectProvinceMapper.selectByExample(example);
    }

    @Override
    public ProjectProvince getProvince(ProjectProvinceConditionRequest request) {
        ProjectProvinceExample example = new ProjectProvinceExample();
        example.createCriteria().andCodeNumberEqualTo(request.getCodeNumber());
        List<ProjectProvince> projectProvinceList = this.projectProvinceMapper.selectByExample(example);
        if (projectProvinceList != null && projectProvinceList.size() > 0) {
            return projectProvinceList.get(0);
        } else {
            throw new RuntimeException("查无结果");
        }
    }

    @Override
    public int addOrUpdateProvince(ProjectProvinceRequest request) {
        if (request == null) {
            throw new RuntimeException("操作对象为空");
        }
        int ret = -1;
        ProjectProvince projectProvince = new ProjectProvince();
        ReflectCopyUtil.beanSameFieldCopy(request, projectProvince);
        projectProvince.setGmtUpdated(new Date());

        if (request.getId() == null) {  //新增
            projectProvince.setGmtCreated(new Date());
            ret = this.projectProvinceMapper.insertSelective(projectProvince);
        } else {
            ret = this.projectProvinceMapper.updateByPrimaryKeySelective(projectProvince);
        }
        return ret;
    }
}
