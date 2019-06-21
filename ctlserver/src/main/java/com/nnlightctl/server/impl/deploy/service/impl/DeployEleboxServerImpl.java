package com.nnlightctl.server.impl.deploy.service.impl;

import com.nnlight.common.PubMethod;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.SystemConfig;
import com.nnlightctl.dao.*;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.po.EleboxRelation;
import com.nnlightctl.po.ElectricityMeter;
import com.nnlightctl.po.LampController;
import com.nnlightctl.po.PhotoPeriod;
import com.nnlightctl.request.deployRequest.DeployEleboxModelLoopRequest;
import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.request.deployRequest.DeployElectricityMeter;
import com.nnlightctl.request.deployRequest.DeployExleboxArrangeRequest;
import com.nnlightctl.request.deployRequest.DeployPhotoperiodRequest;
import com.nnlightctl.server.ElectricityMeterServer;
import com.nnlightctl.server.PhotoperiodServer;
import com.nnlightctl.server.deploy.service.DeployEleboxServer;
import com.nnlightctl.vo.DeployEleboxModifyForView;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeployEleboxServerImpl implements DeployEleboxServer {


    private static final Logger logger = LoggerFactory.getLogger(DeployEleboxServerImpl.class);

    @Autowired
    private EleboxMapper eleboxMapper;

    @Autowired
    private EleboxModelMapper eleboxModelMapper;

    @Autowired
    private EleboxModelLoopMapper eleboxModelLoopMapper;

    @Autowired
    private EleboxRelationMapper eleboxRelationMapper;

    @Autowired
    private LampControllerMapper lampControllerMapper;

    @Autowired
    private PhotoperiodMapper photoperiodMapper;

    @Autowired
    ElectricityMeterMapper electricityMeterMapper;

    @Autowired
    private ElectricityMeterServer meterServer;

    @Autowired
    private PhotoperiodServer photoperiodServer;

    @Override
    public int insertElebox(DeployEleboxRequest request) {
        Elebox elebox = new Elebox();
        ReflectCopyUtil.beanSameFieldCopy(request, elebox);
        elebox.setGmtCreated(new Date());
        elebox.setGmtUpdated(new Date());
        return eleboxMapper.insertSelective(elebox);
    }

    @Override
    public int updateElebox(DeployEleboxRequest request) {
        Elebox elebox = new Elebox();
        ReflectCopyUtil.beanSameFieldCopy(request, elebox);
        elebox.setGmtUpdated(new Date());
        return eleboxMapper.updateByPrimaryKeySelective(elebox);
    }

    @Override
    public Boolean deployExleboxArrange(DeployExleboxArrangeRequest request) throws RuntimeException {

        try {
            if (!PubMethod.isEmpty(request.getExleboxModelIds())) /**部署开关*/
                modelDeploy(request.getExleboxId(), request.getExleboxModelIds(), request.getModelLoopRequests());
            if (!PubMethod.isEmpty(request.getElectricityMeterIds())) { /**部署电表*/
                DeployElectricityMeter deployElectricityMeter = new DeployElectricityMeter();

                deployElectricityMeter.setEleboxId(request.getExleboxId());

                deployElectricityMeter.setElectricityMeterIds(request.getElectricityMeterIds());

                meterServer.deployElectricityMeter(deployElectricityMeter);

            }/**部署光照计*/
            if (!PubMethod.isEmpty(request.getPhotoperiodIds())) {

                DeployPhotoperiodRequest photoperiodRequest = new DeployPhotoperiodRequest();

                photoperiodRequest.setEleboxId(request.getExleboxId());

                photoperiodRequest.setPhotoperiodIds(request.getPhotoperiodIds());

                photoperiodServer.deployPhotoperiod(photoperiodRequest);
            }
            if (!PubMethod.isEmpty(request.getCentralizeControllerIds())) {
            }/**部署集中控制器*/
        } catch (Exception e) {
            logger.error("部署失败.");
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new RuntimeException("服务忙,部署控制柜失败请稍后再试。");
        }

        return Boolean.TRUE;
    }

    @Override
    public Boolean deployExleboxDelete(Long exleBoxId) throws RuntimeException {
        try {
            List<EleboxRelation> eleboxRelations = eleboxRelationMapper.selectByEleboxId(exleBoxId);
            if (PubMethod.isEmpty(eleboxRelations)) return Boolean.FALSE;
            for (EleboxRelation eleboxRelation : eleboxRelations) {
                switch (eleboxRelation.getEleboxModelType()) {
                    case 1:
                        //更改所有单灯loop为控部署状态置为0
                        lampControllerMapper.updateByEleboxId(exleBoxId);
                        List<Long> modelIds = eleboxModelMapper.selectModelIdByEleboxId(exleBoxId);
                        if(!PubMethod.isEmpty(modelIds))
                        //删除所有回路
                        eleboxModelLoopMapper.deleteByEleboxModelIds(modelIds);
                        //置空开关模块的控制柜ID
                        eleboxModelMapper.modifyEleboxId(exleBoxId);
                        break;
                    case 3:
                        //删除电表
                        meterServer.deleteDeployEletricityMeterAndPhotoriod(exleBoxId, (byte) 3);
                        break;
                    case 4:
                        //删除关照计
                        meterServer.deleteDeployEletricityMeterAndPhotoriod(exleBoxId, (byte) 4);
                }
            }
            //删除关联表
            eleboxRelationMapper.deleteByEleboxId(exleBoxId);
        } catch (Exception e) {
            logger.error("部署失败.");
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new RuntimeException("服务忙,部署控制柜失败请稍后再试。");
        }
        return Boolean.TRUE;
    }

    @Override
    public void deployExleboxModify(DeployExleboxArrangeRequest request) throws RuntimeException {

        if (this.deployExleboxDelete(request.getExleboxId()))
            this.deployExleboxArrange(request);
    }

    @Override
    public List<DeployEleboxModifyForView> modifyByView(Long eleboxId) throws RuntimeException {
        List<DeployEleboxModifyForView> reslutList = new ArrayList<DeployEleboxModifyForView>();

        List<EleboxRelation> eleboxRelations = eleboxRelationMapper.selectByEleboxId(eleboxId);
        for (EleboxRelation eleboxRelation : eleboxRelations) {
            switch (eleboxRelation.getEleboxModelType()) {
                case SystemConfig.getInfo.getConstant.SwitchModle:
                    reslutList.add(getEleboxModel(eleboxRelation.getEleboxModelId()));
                    break;
                case SystemConfig.getInfo.getConstant.WattHour:
                    reslutList.add(getElectricityMeterModel(eleboxRelation.getEleboxModelId()));
                    break;
                case SystemConfig.getInfo.getConstant.Illumination:
                    reslutList.add(getPhotoperiodModel(eleboxRelation.getEleboxModelId()));
                    break;
            }
        }
        return reslutList;
    }


    private DeployEleboxModifyForView getElectricityMeterModel(Long eleboxModelId) {
        DeployEleboxModifyForView deployEleboxModifyForView = new DeployEleboxModifyForView();
        ElectricityMeter electricityMeter = electricityMeterMapper.selectByPrimaryKey(eleboxModelId);
        if (PubMethod.isEmpty(electricityMeter)) return new DeployEleboxModifyForView();
        deployEleboxModifyForView.setId(electricityMeter.getId());
        deployEleboxModifyForView.setModelCode(electricityMeter.getEquipmentNumber());
        deployEleboxModifyForView.setModelName(electricityMeter.getElectricityName());
        deployEleboxModifyForView.setEquType(SystemConfig.getInfo.getConstant.WattHour);
        deployEleboxModifyForView.setModelType(electricityMeter.getElectricityModel());
        deployEleboxModifyForView.setExleboxModel(getMap(electricityMeter));
        return deployEleboxModifyForView;
    }


    private DeployEleboxModifyForView getPhotoperiodModel(Long eleboxModelId) {
        DeployEleboxModifyForView deployEleboxModifyForView = new DeployEleboxModifyForView();
        PhotoPeriod photoPeriod = photoperiodMapper.selectById(eleboxModelId);
        if (PubMethod.isEmpty(photoPeriod)) return new DeployEleboxModifyForView();
        deployEleboxModifyForView.setId(photoPeriod.getId());
        deployEleboxModifyForView.setModelCode(photoPeriod.getEquipmentNumber());
        deployEleboxModifyForView.setModelName(photoPeriod.getPhotoperiodName());
        deployEleboxModifyForView.setEquType(SystemConfig.getInfo.getConstant.Illumination);
        deployEleboxModifyForView.setModelType(photoPeriod.getPhotoperiodModel());
        deployEleboxModifyForView.setExleboxModel(getMap(photoPeriod));
        return deployEleboxModifyForView;
    }

    private Map<String, Object> getMap(Object o) {
        try {
            return BeanUtils.describe(o);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private DeployEleboxModifyForView getEleboxModel(Long eleboxModelId) {
        DeployEleboxModifyForView deployEleboxModifyForView = new DeployEleboxModifyForView();
        EleboxModel eleboxModel = eleboxModelMapper.selectByPrimaryKey(eleboxModelId);
        if (PubMethod.isEmpty(eleboxModel)) return new DeployEleboxModifyForView();
        deployEleboxModifyForView.setId(eleboxModel.getId());
        deployEleboxModifyForView.setModelCode(eleboxModel.getModelCode());
        deployEleboxModifyForView.setModelName(eleboxModel.getModelName());
        deployEleboxModifyForView.setEquType(SystemConfig.getInfo.getConstant.SwitchModle);
        deployEleboxModifyForView.setModelType(eleboxModel.getModelType());
        List<Map<String, Object>> reList = eleboxModelLoopMapper.selectModelLoopAndLigh(eleboxModelId);

        Map<String, Object> resltMap = getMap(eleboxModel);
        resltMap.put("modelLoopRequests", reList);
//        Map<String, Object> resltMap = new HashMap<String, Object>() {{
//            put("loopCount", eleboxModel.getLoopCount());
//            put("communicationMethods", eleboxModel.getCommunicationMethods());
//            put("maxElectric", eleboxModel.getMaxElectric());
//            put("loadElectric", eleboxModel.getLoadElectric());
//            put("installationMethods", eleboxModel.getInstallationMethods());
//            put("mem", eleboxModel.getMem());
//            put("modelInfo",eleboxModel);
//        }};
        deployEleboxModifyForView.setExleboxModel(resltMap);
        return deployEleboxModifyForView;
    }


    private void modelDeploy(Long exleboxId, List<Long> exleboxModelIds, List<DeployEleboxModelLoopRequest> modelLoopRequests) {

        for (Long exleboxModelId : exleboxModelIds) {
            for (DeployEleboxModelLoopRequest loopRequest : modelLoopRequests) {
                if (loopRequest.getExleboxModelId().equals(exleboxModelId)) {
                    EleboxModelLoop eleboxModelLoop = new EleboxModelLoop();
                    eleboxModelLoop.setState((byte) 1);
                    eleboxModelLoop.setLoopCode(loopRequest.getLoopCode());
                    eleboxModelLoop.setNnlightctlEleboxModelId(exleboxModelId);
                    eleboxModelLoop.setMem(loopRequest.getMem());
                    eleboxModelLoop.setGmtCreated(new Date());
                    eleboxModelLoop.setGmtUpdated(new Date());
                    eleboxModelLoopMapper.insertSelective(eleboxModelLoop);
                    List<Long> lightingList = loopRequest.getLightingList();
                    for (Long lightId : lightingList) {
                        LampController lampController = new LampController();
                        lampController.setId(lightId);
                        lampController.setModelDeployState(SystemConfig.getInfo.getConstant.YesDeploy);
                        lampController.setNnlightctlEleboxId(exleboxId);
                        lampController.setNnlightctlEleboxLoopId(eleboxModelLoop.getId());
                        lampControllerMapper.updateByPrimaryKey(lampController);
//                        Lighting lighting = new Lighting();
//                        lighting.setId(lightId);
//                        lighting.setNnlightctlEleboxId(exleboxId);
//                        lighting.setNnlightctlEleboxModelLoopId(eleboxModelLoop.getId());
//                        lighting.setGmtUpdated(new Date());
//                        lighting.setDeployState((byte) 1);
//                        lightingMapper.updateByPrimaryKeySelective(lighting);
                    }
                }
            }

            EleboxModel eleboxModel = new EleboxModel();
            eleboxModel.setId(exleboxModelId);
            eleboxModel.setNnlightctlEleboxId(exleboxId);
            eleboxModel.setGmtUpdated(new Date());
            eleboxModel.setDeployStatus((byte) 1);
            eleboxModelMapper.updateByPrimaryKeySelective(eleboxModel);
            EleboxRelation eleboxRelation = new EleboxRelation();
            eleboxRelation.setEleboxId(exleboxId);
            eleboxRelation.setEleboxModelId(exleboxModelId);
            eleboxRelation.setEleboxModelType(SystemConfig.getInfo.getConstant.SwitchModle);
            eleboxRelation.setGmtCreated(new Date());
            eleboxRelation.setGmtUpdated(new Date());
            eleboxRelationMapper.insertSelective(eleboxRelation);
        }
    }


}
