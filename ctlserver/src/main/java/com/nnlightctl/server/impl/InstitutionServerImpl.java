package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.InstitutionMapper;
import com.nnlightctl.po.Institution;
import com.nnlightctl.po.InstitutionExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.InstitutionRequest;
import com.nnlightctl.request.MapProjectsToInstitutionRequest;
import com.nnlightctl.server.InstitutionServer;
import com.nnlightctl.vo.ProjectsToInstitutionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nnlightctl.jdbcdao.*;

import java.util.Date;
import java.util.List;

@Service
public class InstitutionServerImpl implements InstitutionServer {

    @Autowired
    private InstitutionMapper institutionMapper;
    @Autowired
    private ProjectDao projectDao;

    @Override
    public int addOrUpdateInstitution(InstitutionRequest request) {
        Institution institution = new Institution();
        ReflectCopyUtil.beanSameFieldCopy(request, institution);
        institution.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            institution.setGmtCreated(new Date());
            ret = institutionMapper.insertSelective(institution);
        } else {
            //更新
            ret = institutionMapper.updateByPrimaryKeySelective(institution);
        }

        return ret;
    }

    @Override
    public Tuple.TwoTuple<List<Institution>, Integer> listInstitution(BaseRequest request) {
        Tuple.TwoTuple<List<Institution>, Integer> tuple = new Tuple.TwoTuple<>();

        InstitutionExample institutionExample = new InstitutionExample();
        institutionExample.setOrderByClause("id DESC");

        int total = institutionMapper.countByExample(institutionExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        List<Institution> institutionList = institutionMapper.selectByExample(institutionExample);
        tuple.setFirst(institutionList);

        return tuple;
    }

    @Override
    public Institution getInstitutionById(Long id) {
        return institutionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteInstitution(List<Long> institutionIds) {
        for (Long id : institutionIds) {
            institutionMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public List<ProjectsToInstitutionView> mapProjectsToInstitution(MapProjectsToInstitutionRequest mapProjectsToInstitutionRequest){
        List<ProjectsToInstitutionView> projectsToInstitutionViewList = projectDao.mapProjectsToInstitution(mapProjectsToInstitutionRequest);
        return projectsToInstitutionViewList;
    }
}
