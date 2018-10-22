package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.InstitutionMapper;
import com.nnlightctl.dao.ProjectMapper;
import com.nnlightctl.po.Institution;
import com.nnlightctl.po.InstitutionExample;
import com.nnlightctl.po.Project;
import com.nnlightctl.po.ProjectExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.InstitutionConditionRequest;
import com.nnlightctl.request.InstitutionRequest;
import com.nnlightctl.request.MapProjectsToInstitutionRequest;
import com.nnlightctl.server.InstitutionServer;
import com.nnlightctl.vo.InstitutionView;
import com.nnlightctl.vo.ProjectsToInstitutionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nnlightctl.jdbcdao.*;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InstitutionServerImpl implements InstitutionServer {

    @Autowired
    private InstitutionMapper institutionMapper;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public int addOrUpdateInstitution(InstitutionRequest request) {
        Institution institution = new Institution();
        ReflectCopyUtil.beanSameFieldCopy(request, institution);
        institution.setGmtUpdated(new Date());
        if (institution.getNnlightctlInstitutionIdParent() == 0) {
            institution.setInstitutionLevel((byte)0);
        } else {
            institution.setInstitutionLevel((byte)1);
        }

        int ret = -1;
        if (request.getId() == null) {
            //新增
            institution.setGmtCreated(new Date());
            institution.setCreateTime(new Date());
            ret = institutionMapper.insertSelective(institution);
        } else {
            //更新
            ret = institutionMapper.updateByPrimaryKeySelective(institution);
        }

        return ret;
    }
    @Override
    public int getCountInstitutionByName(String institutionName){
        InstitutionExample institutionExample = new InstitutionExample();
        institutionExample.createCriteria().andInstitutionNameEqualTo(institutionName);
        int total = institutionMapper.countByExample(institutionExample);
        return total;
    }

    @Override
    public Tuple.TwoTuple<List<InstitutionView>, Integer> listInstitution(InstitutionRequest request) {
        Tuple.TwoTuple<List<InstitutionView>, Integer> tuple = new Tuple.TwoTuple<>();

        InstitutionExample institutionExample = new InstitutionExample();
        InstitutionExample.Criteria criteria = institutionExample.createCriteria();
        if (!StringUtils.isEmpty(request.getAddr())) {
            criteria.andAddrLike("%" + request.getAddr() + "%");
        }

        if (!StringUtils.isEmpty(request.getInstitutionName())) {
            criteria.andInstitutionNameLike("%" + request.getInstitutionName() + "%");
        }

        institutionExample.setOrderByClause("id DESC");

        int total = institutionMapper.countByExample(institutionExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        List<Institution> institutionList = institutionMapper.selectByExample(institutionExample);
        List<InstitutionView> institutionViewList = new ArrayList<>();
        if (!institutionList.isEmpty()){
            for (int i = 0 ; i<institutionList.size() ; i++){
                    Institution  institution = institutionMapper.selectByPrimaryKey(institutionList.get(i).getNnlightctlInstitutionIdParent());
                    InstitutionView institutionView = new InstitutionView();
                    institutionView.setAddr(institutionList.get(i).getAddr());
                    institutionView.setCreateTime(institutionList.get(i).getCreateTime());
                    institutionView.setGmtCreated(institutionList.get(i).getGmtCreated());
                    institutionView.setGmtUpdated(institutionList.get(i).getGmtUpdated());
                    institutionView.setId(institutionList.get(i).getId());
                    institutionView.setInstitutionLevel(institutionList.get(i).getInstitutionLevel());
                    institutionView.setInstitutionName(institutionList.get(i).getInstitutionName());
                    institutionView.setMem(institutionList.get(i).getMem());
                    institutionView.setNnlightctlInstitutionIdParent(institutionList.get(i).getNnlightctlInstitutionIdParent());
                    if (null != institution){
                        institutionView.setParentName(institution.getInstitutionName());
                    }
                    institutionViewList.add(institutionView);
            }
        }

        tuple.setFirst(institutionViewList);

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

    @Override
    public List<Project> listProjectByInsitutionId(Long insitutionId) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andNnlightctlInstitutionIdEqualTo(insitutionId);

        return projectMapper.selectByExample(projectExample);
    }

    @Override
    public int updateMapProjects2Institution(InstitutionConditionRequest request) {
        if (request.getInstitutionId() == null) {
            throw new RuntimeException("请选择一个机构");
        }

        return projectDao.mapProject2Insitution2(request);
    }

    @Override
    public List<Project> listNotBeProjects() {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andNnlightctlInstitutionIdIsNull();

        return projectMapper.selectByExample(projectExample);
    }
}
