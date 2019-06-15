package com.nnlightctl.server.impl.deploy.service.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.SystemConfig;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.dao.EleboxRelationMapper;
import com.nnlightctl.dao.LightingMapper;
import com.nnlightctl.po.Elebox;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.po.EleboxRelation;
import com.nnlightctl.po.Lighting;
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
    private LightingMapper lightingMapper;

    @Autowired
    private EleboxRelationMapper eleboxRelationMapper;

    @Override
    public int insertElebox(DeployEleboxRequest request) {
        Elebox elebox = new Elebox();
        elebox.setGmtCreated(new Date());
        elebox.setGmtUpdated(new Date());
        ReflectCopyUtil.beanSameFieldCopy(request, elebox);
        return eleboxMapper.insertSelective(elebox);
    }

    @Override
    public int updateElebox(DeployEleboxRequest request) {
        Elebox elebox = new Elebox();
        elebox.setGmtUpdated(new Date());
        ReflectCopyUtil.beanSameFieldCopy(request, elebox);
        return eleboxMapper.updateByPrimaryKeySelective(elebox);
    }

    @Override
    public Boolean deployExleboxArrange(DeployExleboxArrangeRequest request) {

        try {
            List<DeployEleboxModelLoopRequest> loopRequestList = request.getLoopRequest();
            for (DeployEleboxModelLoopRequest loopRequest : loopRequestList) {
                EleboxModelLoop eleboxModelLoop = new EleboxModelLoop();
                eleboxModelLoop.setState((byte) 1);
                eleboxModelLoop.setLoopCode(loopRequest.getLoopCode());
                eleboxModelLoop.setNnlightctlEleboxModelId(request.getExleboxModelId());
                eleboxModelLoop.setGmtCreated(new Date());
                eleboxModelLoop.setGmtUpdated(new Date());
                eleboxModelLoopMapper.insertSelective(eleboxModelLoop);
                List<Long> lightingList = loopRequest.getLightingList();
                for (Long lightId : lightingList) {
                    Lighting lighting = new Lighting();
                    lighting.setId(lightId);
                    lighting.setNnlightctlEleboxId(request.getExleboxId());
                    lighting.setNnlightctlEleboxModelLoopId(eleboxModelLoop.getId());
                    lightingMapper.updateByPrimaryKeySelective(lighting);
                }
            }
            EleboxModel eleboxModel = new EleboxModel();
            eleboxModel.setId(request.getExleboxModelId());
            eleboxModel.setNnlightctlEleboxId(request.getExleboxId());
            eleboxModel.setGmtUpdated(new Date());
            eleboxModelMapper.updateByPrimaryKeySelective(eleboxModel);
            EleboxRelation  eleboxRelation = new EleboxRelation();
            eleboxRelation.setEleboxId(request.getExleboxId());
            eleboxRelation.setEleboxModelId(request.getExleboxModelId());
            eleboxRelation.setEleboxModelType(SystemConfig.getInfo.getConstant.SwitchModle);
            eleboxRelation.setGmtCreated(new Date());
            eleboxRelation.setGmtUpdated(new Date());
            eleboxRelationMapper.insertSelective(eleboxRelation);
            return Boolean.TRUE;
        } catch (Exception e) {
            logger.error("部署失败.");
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return Boolean.FALSE;
    }


}
