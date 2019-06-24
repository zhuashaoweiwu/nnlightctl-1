package com.nnlightctl.server.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LampControllerMapper;
import com.nnlightctl.dao.LamppostMapper;
import com.nnlightctl.dao.LightingModelMapper;
import com.nnlightctl.dao.ProjectMapper;
import com.nnlightctl.parameter.LampControllerParameter;
import com.nnlightctl.po.LampController;
import com.nnlightctl.po.Lamppost;
import com.nnlightctl.po.LightingModel;
import com.nnlightctl.po.Project;
import com.nnlightctl.request.LampControllerConditionRequest;
import com.nnlightctl.request.LampControllerRequest;
import com.nnlightctl.request.deployRequest.DeployLightingRequest;
import com.nnlightctl.server.LampControllerServer;
import com.nnlightctl.vo.DeployLightingView;
import com.nnlightctl.vo.LampControllerView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LampControllerImpl implements LampControllerServer {

    private static final Logger logger= LoggerFactory.getLogger(LampControllerImpl.class);


    @Autowired
    private LampControllerMapper lampControllerMapper;

    @Autowired
    private LamppostMapper lamppostMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private LightingModelMapper lightingModelMapper;



    //判断标志位
    private Integer flag = null;

    @Override
    public int addOrUpdateLampController(LampControllerRequest request) {

        LampController lampController = new LampController();

        ReflectCopyUtil.beanSameFieldCopy(request, lampController);

        int ret = -1;

        if (request.getId() == null) {

            for (String equipmentNumber : lampControllerMapper.getAllEquipmentNumber()) {

                if (request.getEquipmentNumber().equals(equipmentNumber)){

                    ret=-2;

                    return ret;
                }
            }

            //新增用户
            ret = lampControllerMapper.insert(lampController);
        } else {


            //修改用户
            ret = lampControllerMapper.updateByPrimaryKey(lampController);

        }
        return ret;
    }

    @Override
    public int deleteLampController(LampControllerConditionRequest request) {

        //得到id
        List<Long> lampControllerIds = request.getLampControllerIds();

        if (lampControllerIds == null) {
            flag = -1;
        } else {
            for (Long lampControllerId : lampControllerIds) {
                flag = lampControllerMapper.deleteByPrimaryKey(lampControllerId);
                if (flag < 0) {
                    flag = -2;
                }
            }
        }

        return flag;
    }

    @Override
    public Tuple.TwoTuple<List<LampControllerView>, Integer> listLampController(LampControllerConditionRequest request) {
        Tuple.TwoTuple<List<LampControllerView>, Integer> twoTuple = new Tuple.TwoTuple<>();

        List<LampControllerView> lampControllerList = new ArrayList<>(8);

        int total = lampControllerMapper.selectByCount();

        twoTuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        LampController lampController = new LampController();

        ReflectCopyUtil.beanSameFieldCopy(request,lampController);


        List<LampController> lampControllers = lampControllerMapper.selectAll(lampController);

        for (LampController lampControllerNew : lampControllers) {

            LampControllerView lampControllerView = new LampControllerView();

            ReflectCopyUtil.beanSameFieldCopy(lampControllerNew, lampControllerView);

            lampControllerList.add(lampControllerView);

        }
        twoTuple.setFirst(lampControllerList);

        return twoTuple;
    }


    @Override
    public List<LampController> SelectByParameter(LampControllerConditionRequest request) {

        LampControllerParameter parameter = new LampControllerParameter();

        parameter.setLampModel(request.getLampModel());

        parameter.setLampName(request.getLampName());

        parameter.setLatitude(request.getLatitude());

        parameter.setLongitude(request.getLongtitude());

        parameter.setCommunicationMode(request.getCommunicationMode());

        parameter.setDimmingMode(request.getDimmingMode());

        List<LampController> lampControllerList = lampControllerMapper.selectByParameter(parameter);
        return lampControllerList;
    }

    @Override
    public LampController selectByIdLampController(LampControllerConditionRequest request) {

        Long requestId = request.getId();

        LampController lampController = lampControllerMapper.selectById(requestId);


        return lampController;
    }

    @Override
    public List<String> queryLightingByLoop(Long loopId) {
        return lampControllerMapper.queryLightingByLoop(loopId);
    }


    @Override
    public List<Map<String,Object>> queryLightingUnLoop() {
        return lampControllerMapper.queryLightingUnLoop();
    }



    public Tuple.TwoTuple<List<DeployLightingView>, Integer> selectByExampleDeployLighting(LampControllerConditionRequest request) {

        Tuple.TwoTuple<List<DeployLightingView>, Integer> listDeployLighting = new Tuple.TwoTuple<>();

        LampController lampController=new LampController();

        ReflectCopyUtil.beanSameFieldCopy(request,lampController);
        Page<Object> page = PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        List<DeployLightingView> deployLightingViews = lampControllerMapper.selectByExampleDeployLighting(lampController);
        listDeployLighting.setSecond((int) page.getTotal());
        listDeployLighting.setFirst(deployLightingViews);
        return listDeployLighting;
    }

    @Override
    public int deployUpdateLighting(LampControllerRequest request) {

        LampController lampController = new LampController();

        ReflectCopyUtil.beanSameFieldCopy(request, lampController);

        
        lampController.setDeployState(1);

        int flag = lampControllerMapper.updateByPrimaryKey(lampController);

        return flag;
    }

    @Override
    public List<LampController> selectByLampModel(LampControllerRequest request) {

        String lampModel = request.getLampModel();

        List<LampController> lampControllerList = lampControllerMapper.selectByLampModel(lampModel);

        return lampControllerList;
    }

    @Override
    public List<DeployLightingView> selectByIdDeployLighting(LampControllerRequest request) {

        Long id = request.getId();

        List<DeployLightingView> lightingViews=new ArrayList<>(7);

        DeployLightingView deployLightingView = lampControllerMapper.selectByIdDeployLighting(id);

        lightingViews.add(deployLightingView);

        return lightingViews;
    }

    @Override
    public int deleteDeployLighting(LampControllerConditionRequest request) {

        List<Long> lampControllerIds = request.getLampControllerIds();

        int flag=-1;

        for (Long lampControllerId : lampControllerIds) {

            flag = lampControllerMapper.updateByDeployLightingState(lampControllerId);

        }
        return flag;
    }

    @Override
    public Boolean updateShowDeployLighting(DeployLightingRequest request) {

        try {
            LampController lampController=new LampController();

            lampController.setId(request.getLampControllerId());

            lampController.setEquipmentNumber(request.getEquipmentNumber());

            lampController.setLampModel(request.getLampModel());

            lampController.setMem(request.getMem());

            lampController.setStaticPower(request.getStaticPower());

            /**
             * 修改单灯控制器的数据
             */
            lampControllerMapper.updateByPrimaryKey(lampController);

            Lamppost lamppost=new Lamppost();

            lamppost.setId(request.getNnlightctlLamppostId());

            lamppost.setLamppostModel(request.getLamppostModel());

            lamppost.setLampheadNumber(request.getLamppostNumber());

            /**
             * 灯杆
             */

            lamppostMapper.updateByPrimaryKeyLamppost(lamppost);

            Project project=new Project();

            project.setId(request.getNnlightctlProjectId());

            /**
             * 项目
             */

            project.setProjectName(request.getProjectName());

            projectMapper.updateByPrimaryKeySelective(project);

            /**
             * 灯具类型
             */
            LightingModel lightingModel=new LightingModel();

            lightingModel.setId(request.getNnlightctlLampModelId());

            lightingModel.setEquipmentNumber(request.getModelType());

            lightingModelMapper.updateByPrimaryKeySelective(lightingModel);

            return Boolean.TRUE;


        } catch (Exception e) {
            e.printStackTrace();

            logger.info("修改失败");
        }


        return Boolean.FALSE;
    }


}
