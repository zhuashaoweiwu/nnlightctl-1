package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.request.EleboxModelConditionRequest;
import com.nnlightctl.request.EleboxModelRequest;
import com.nnlightctl.request.ModelLoopRequest;
import com.nnlightctl.server.EleboxModelServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleboxModelServerImpl implements EleboxModelServer {

    @Autowired
    private EleboxModelMapper eleboxModelMapper;

    @Autowired
    private EleboxModelLoopMapper eleboxModelLoopMapper;

    @Override
    public int addEleboxModel(EleboxModelRequest request) {
        int ret = -1;
        int duplicate = request.getCount() > 0 ? request.getCount() : 1;
        for (int i = 0; i < duplicate; ++i) {
            EleboxModel eleboxModel = new EleboxModel();
            ReflectCopyUtil.beanSameFieldCopy(request, eleboxModel);
            ret = eleboxModelMapper.insertSelective(eleboxModel);
            if (ret > 0) {
                List<ModelLoopRequest> modleLoopList = request.getModelLoopList();
                for (ModelLoopRequest modelLoopRequest : modleLoopList) {
                    modelLoopRequest.setNnlightctlEleboxModelId(eleboxModel.getId());
                    EleboxModelLoop eleboxModelLoop = new EleboxModelLoop();
                    ReflectCopyUtil.beanSameFieldCopy(modelLoopRequest, eleboxModelLoop);
                    eleboxModelLoopMapper.insertSelective(eleboxModelLoop);
                }
            }
        }

        return ret;
    }

    @Override
    public int updateEleboxModel(EleboxModelRequest request) {
        return 0;
    }

    @Override
    public int deleteEleboxModel(EleboxModelConditionRequest request) {
        return 0;
    }
}
