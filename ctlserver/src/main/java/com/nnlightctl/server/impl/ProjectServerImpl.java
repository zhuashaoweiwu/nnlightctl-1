package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.LightingMapper;
import com.nnlightctl.dao.ProjectMapper;
import com.nnlightctl.jdbcdao.ProjectDao;
import com.nnlightctl.po.EleboxExample;
import com.nnlightctl.po.LightingExample;
import com.nnlightctl.po.Project;
import com.nnlightctl.po.ProjectExample;
import com.nnlightctl.request.ProjectConditionRequest;
import com.nnlightctl.request.ProjectRequest;
import com.nnlightctl.server.ProjectServer;
import com.nnlightctl.vo.ProjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServerImpl implements ProjectServer {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private LightingMapper lightingMapper;

    @Autowired
    private EleboxMapper eleboxMapper;

    @Override
    public Tuple.TwoTuple<List<ProjectView>, Integer> listProject(ProjectRequest request) {
        Tuple.TwoTuple<List<ProjectView>, Integer> result = new Tuple.TwoTuple<>();

        List<ProjectView> projectViewList1=new ArrayList<>(6);

        ProjectExample projectViewListExample=new ProjectExample();

        int totalNumber = projectMapper.countByExample(projectViewListExample);

        result.setSecond(totalNumber);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        projectViewListExample.setOrderByClause("id DESC");

        List<Project> projectList = projectMapper.selectByExample(projectViewListExample);

        for (Project project : projectList) {

            ProjectView projectView=new ProjectView();

            projectView.setId(project.getId());

            projectView.setProjectName(project.getProjectName());

            projectView.setCodeNumber(project.getCodeNumber());

            projectView.setLatitude(project.getLatitude());

            projectView.setLongitude(project.getLongitude());

            projectView.setMem(project.getMem());

            projectView.setState(project.getState());

            projectView.setContryName(projectMapper.selectByCountryId(project.getNnlightctlProjectCountryId()));

            projectView.setProvinceName(projectMapper.selectByProvinceId(project.getNnlightctlProjectProvinceId()));

            projectView.setCityName(projectMapper.selectByCityId(project.getNnlightctlProjectCityId()));

            projectViewList1.add(projectView);


        }


        //项目总数
        /*int total = projectMapper.countByExample(new ProjectExample());
        result.setSecond(total);*/

        for (ProjectView projectView1 : projectViewList1) {
            Long projectId = projectView1.getId();

            //项目对应的灯具数量
            LightingExample lightingExample = new LightingExample();
            lightingExample.createCriteria().andNnlightctlProjectIdEqualTo(projectId);
            projectView1.setLights(lightingMapper.countByExample(lightingExample));

            //项目对应的控制柜的数量
            EleboxExample eleboxExample = new EleboxExample();
            eleboxExample.createCriteria().andNnlightctlProjectIdEqualTo(projectId);
            projectView1.setEleboxs(eleboxMapper.countByExample(eleboxExample));
        }
        result.setFirst(projectViewList1);

        return result;
    }

    @Override
    public Project getProject(ProjectConditionRequest request) {
        Project project = projectMapper.selectByPrimaryKey(request.getId());
        if (project != null) {
            return project;
        } else {
            throw new RuntimeException("查无结果");
        }
    }

    @Override
    public int insertProject(ProjectRequest request) {
        if (request == null) {
            throw new RuntimeException("插入项目数据为空");
        }

        Project project = new Project();
        ReflectCopyUtil.beanSameFieldCopy(request, project);
        project.setGmtCreated(new Date());
        project.setGmtUpdated(new Date());
        project.setCodeNumber(request.getProjectCode());
        project.setCtype((byte) request.getType());
        project.setState((byte) 1);

        return projectMapper.insertSelective(project);
    }

    @Override
    public int updateProject(ProjectRequest request) {
        Project project = new Project();
        ReflectCopyUtil.beanSameFieldCopy(request, project);
        project.setGmtUpdated(new Date());
        project.setState((byte) request.getState());
        project.setCodeNumber(request.getProjectCode());
        project.setState((byte) 1);

        return projectMapper.updateByPrimaryKeySelective(project);
    }

    @Override
    public int getCountProjectByCode(String projectCode) {
        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andCodeNumberEqualTo(projectCode);
        int total = projectMapper.countByExample(projectExample);
        return total;
    }

    @Override
    public int deleteProject(List<Long> idList) {
        int ret = -1;

        for (Long id : idList) {

            int total= projectMapper.selectByLampController(id);

            System.err.println(total);

            if (projectMapper.selectByLampController(id)>0){
                ret=-10;
            }else if (projectMapper.selectByElebox(id)>0){
                ret=-20;
            }else {
                ret=projectMapper.deleteByPrimaryKey(id);
            }

        }
        return ret;
    }
}
