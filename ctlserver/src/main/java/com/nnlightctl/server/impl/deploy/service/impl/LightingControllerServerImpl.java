package com.nnlightctl.server.impl.deploy.service.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LamppostMapper;
import com.nnlightctl.dao.LightingMapper;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.request.deployRequest.DeployLighting;
import com.nnlightctl.request.deployRequest.LightingConditionRequest;
import com.nnlightctl.server.LightModelServer;
import com.nnlightctl.server.ProjectServer;
import com.nnlightctl.server.deploy.service.LightingControllerServer;
import com.nnlightctl.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class LightingControllerServerImpl implements LightingControllerServer {

    @Autowired
    private LightingMapper lightingMapper;

    @Autowired
    private LightModelServer lightModelServer;


    @Autowired
    private ProjectServer projectServer;

    @Autowired
    private LamppostMapper lamppostMapper;



    private List<Lighting> lightings=new ArrayList<>(8);

    private int flag=-1;

    @Override
    public int addOrUpdateLightingController(LightRequest request) {

        Lighting lighting=new Lighting();

        ReflectCopyUtil.beanSameFieldCopy(request,lighting);

        if (request.getId()==null){

            //新增 未部署 0 未部署

            lighting.setDeployState(0);

            flag=lightingMapper.insertSelective(lighting);

        }else {

            //修改

               flag=lightingMapper.updateByPrimaryKeySelective(lighting);

        }
        return flag;
    }

    @Override
    public int deteleLightingController(LightingConditionRequest request) {

        List<Long> lightingControllerIds = request.getLightingControllerIds();

        for (Long lightingControllerId : lightingControllerIds) {

            flag=lightingMapper.deleteByPrimaryKey(lightingControllerId);
        }
        return flag;
    }

    @Override
    public Tuple.TwoTuple<List<Lighting>,Integer> listLightingController(LightingConditionRequest request) {

        Tuple.TwoTuple<List<Lighting>,Integer> tuple=new Tuple.TwoTuple<>();

        LightingExample lightingExample=new LightingExample();

        LightingExample.Criteria criteria = lightingExample.createCriteria();


        if (!StringUtils.isEmpty(request.getLampName())){

            criteria.andLampNameLike("%"+request.getLampName()+"%");
        }

        if (!StringUtils.isEmpty(request.getLampModel())){

            criteria.andLampModelLike("%"+request.getLampModel()+"%");
        }

        if (!StringUtils.isEmpty(request.getUid())){

           criteria.andUidLike("%"+request.getUid()+"%");
        }

        int total = lightingMapper.countByExample(lightingExample);

        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(),request.getPageSize());

        lightings = lightingMapper.selectByExample(lightingExample);

        tuple.setFirst(lightings);

        return tuple;
    }

    @Override
    public Lighting selectLightingController(LightingConditionRequest request) {


        Long id = request.getId();

        Lighting lighting = lightingMapper.selectByPrimaryKey(id);
        return lighting;
    }

    @Override
    public DeployLighting selectLightDeploy() {

        /**
         * 单灯控制器
         * 型号   id
         */
        DeployLighting deployLighting=new DeployLighting();

        List<LampControllerView> lampControllerList = lightingMapper.selectLampControllerType();

        deployLighting.setLampControllerViews(lampControllerList);


        /**
         * 灯具
         * 灯具的型号
         */
        Tuple.TwoTuple<List<LightingModel>, Integer> listIntegerTwoTuple = lightModelServer.listLightModel(new LightModelConditionRequest());

        List<LightingModel> first = listIntegerTwoTuple.getFirst();

        List<LightingView> lightingViews = new ArrayList<>();

        for (LightingModel lightingModel : first) {

            LightingView lightingView=new LightingView();

            lightingView.setId(lightingModel.getId());
            //灯具的型号
            lightingView.setModelType(lightingModel.getEquipmentNumber());

            lightingViews.add(lightingView);
        }

        deployLighting.setLightingViews(lightingViews);


        /**
         *
         * 灯杆
         * 灯杆型号
         *  灯头数
         */
        List<LamppostView> lamppostViews=new ArrayList<>();

        List<String> selectAllLamppostType = lamppostMapper.selectAllLamppostType();

        for (String lamppostType : selectAllLamppostType) {

            LamppostView lamppostView=new LamppostView();

            lamppostView.setLamppostModel(lamppostType);

            List<LamppostEquipment> lamppostEquipments = lamppostMapper.selectByLamppostType(lamppostType);

            lamppostView.setLamppostEquipmentList(lamppostEquipments);

            lamppostViews.add(lamppostView);
        }

        deployLighting.setLamppostViews(lamppostViews);

        /**
         * 项目
         */
        List<ProjectView> projectViewList = new ArrayList<>();

        Tuple.TwoTuple<List<ProjectView>, Integer> listIntegerTwoTuple2 = projectServer.listProject(new ProjectRequest());

        for (ProjectView projectView : listIntegerTwoTuple2.getFirst()) {

            ProjectView projectView1=new ProjectView();

            projectView1.setId(projectView.getId());

            projectView1.setProjectName(projectView.getProjectName());

            projectViewList.add(projectView1);

        }
        deployLighting.setProjectViewList(projectViewList);
        return deployLighting;
    }




}
