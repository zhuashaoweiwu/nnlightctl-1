package com.nnlightctl.server.impl.deploy.service.impl;

import com.nnlight.common.PubMethod;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.SystemConfig;
import com.nnlightctl.dao.*;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.po.EleboxRelation;
import com.nnlightctl.po.LampController;
import com.nnlightctl.request.deployRequest.DeployEleboxModelLoopRequest;
import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.request.deployRequest.DeployExleboxArrangeRequest;
import com.nnlightctl.server.deploy.service.DeployEleboxServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
            if (!PubMethod.isEmpty(request.getElectricityMeterIds())) {
            }/**部署电表*/
//                modelDeploy(request.getExleboxId(), request.getExleboxModelIds(), request.getModelLoopRequests());
            if (!PubMethod.isEmpty(request.getPhotoperiodIds())) {
            }/**部署光照计*/
//                modelDeploy(request.getExleboxId(), request.getExleboxModelIds(), request.getModelLoopRequests());
            if (!PubMethod.isEmpty(request.getCentralizeControllerIds())) {
            }/**部署集中控制器*/
//                modelDeploy(request.getExleboxId(), request.getExleboxModelIds(), request.getModelLoopRequests());

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
            List<Long> modelIds = eleboxModelMapper.selectModelIdByEleboxId(exleBoxId);
            //更改所有单灯loop为控部署状态置为0
            lampControllerMapper.updateByEleboxId(exleBoxId);
            //删除所有回路
            eleboxModelLoopMapper.deleteByEleboxModelIds(modelIds);
            //置空开关模块的控制柜ID
            eleboxModelMapper.modifyEleboxId(exleBoxId);
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
    public void deployExleboxModify (DeployExleboxArrangeRequest request) throws RuntimeException {
        this.deployExleboxDelete(request.getExleboxId());
        this.deployExleboxArrange(request);
    }


    private void modelDeploy(Long exleboxId, List<Long> exleboxModelIds, List<DeployEleboxModelLoopRequest> modelLoopRequests) {

        for (Long exleboxModelId : exleboxModelIds) {
            for (DeployEleboxModelLoopRequest loopRequest : modelLoopRequests) {
                if (loopRequest.getExleboxModelId().equals(exleboxModelId)) {
                    EleboxModelLoop eleboxModelLoop = new EleboxModelLoop();
                    eleboxModelLoop.setState((byte) 1);
                    eleboxModelLoop.setLoopCode(loopRequest.getLoopCode());
                    eleboxModelLoop.setNnlightctlEleboxModelId(exleboxModelId);
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
