package com.nnlightctl.server.impl.deploy.service.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.request.deployRequest.DeployEleboxModelRequest;
import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.server.deploy.service.DeployEleboxModelServer;
import com.nnlightctl.server.deploy.service.DeployEleboxServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeployEleboxModelServerImpl  implements DeployEleboxModelServer{

    @Autowired
    private EleboxModelMapper eleboxModelMapper;

    @Override
    public int insertEleboxModel(DeployEleboxModelRequest deployEleboxModelRequest) {
        EleboxModel eleboxModel = new EleboxModel();
        ReflectCopyUtil.beanSameFieldCopy(deployEleboxModelRequest, eleboxModel);
        eleboxModel.setGmtCreated(new Date());
        eleboxModel.setGmtUpdated(new Date());
        return eleboxModelMapper.insertSelective(eleboxModel);
    }


    @Override
    public int updateEleboxModel(DeployEleboxModelRequest deployEleboxModelRequest) {
        EleboxModel eleboxModel = new EleboxModel();
        ReflectCopyUtil.beanSameFieldCopy(deployEleboxModelRequest, eleboxModel);
        eleboxModel.setGmtUpdated(new Date());
        return eleboxModelMapper.updateByPrimaryKeySelective(eleboxModel);
    }

}
