package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelExample;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.po.EleboxModelLoopExample;
import com.nnlightctl.request.EleboxModelConditionRequest;
import com.nnlightctl.request.EleboxModelRequest;
import com.nnlightctl.request.ModelLoopRequest;
import com.nnlightctl.server.EleboxModelServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EleboxModelServerImpl implements EleboxModelServer {

    @Autowired
    private EleboxModelMapper eleboxModelMapper;

    @Autowired
    private EleboxModelLoopMapper eleboxModelLoopMapper;

    @Autowired
    private EleboxMapper eleboxMapper;

    @Override
    public int addEleboxModel(EleboxModelRequest request) {
        int ret = -1;
        EleboxModel eleboxModel = new EleboxModel();
        ReflectCopyUtil.beanSameFieldCopy(request, eleboxModel);
        eleboxModel.setGmtCreated(new Date());
        eleboxModel.setGmtUpdated(new Date());

        ret = eleboxModelMapper.insertSelective(eleboxModel);
        if (ret > 0) {
            List<ModelLoopRequest> modleLoopList = request.getModelLoopList();
            if (modleLoopList != null && modleLoopList.size() > 0) {
                for (ModelLoopRequest modelLoopRequest : modleLoopList) {
                    modelLoopRequest.setNnlightctlEleboxModelId(eleboxModel.getId());
                    EleboxModelLoop eleboxModelLoop = new EleboxModelLoop();
                    ReflectCopyUtil.beanSameFieldCopy(modelLoopRequest, eleboxModelLoop);
                    eleboxModelLoop.setGmtCreated(new Date());
                    eleboxModelLoop.setGmtUpdated(new Date());
                    //默认新增回路处于断电状态
                    eleboxModelLoop.setState((byte)1);
                    eleboxModelLoopMapper.insertSelective(eleboxModelLoop);
                }
            }
        }

        return ret;
    }

    @Override
    public int updateEleboxModel(EleboxModelRequest request) {
        EleboxModel eleboxModel = new EleboxModel();
        ReflectCopyUtil.beanSameFieldCopy(request, eleboxModel);
        eleboxModel.setGmtUpdated(new Date());

        int ret = eleboxModelMapper.updateByPrimaryKeySelective(eleboxModel);

        return ret;
    }

    @Override
    public int deleteEleboxModel(EleboxModelConditionRequest request) {
        List<Long> eleboxModelIdList = request.getEleboxModelIdList();
        int ret = -1;
        for (Long id : eleboxModelIdList) {
            //先删除对应的回路
            EleboxModelLoopExample loopExample = new EleboxModelLoopExample();
            loopExample.createCriteria().andNnlightctlEleboxModelIdEqualTo(id);
            eleboxModelLoopMapper.deleteByExample(loopExample);

            ret = eleboxModelMapper.deleteByPrimaryKey(id);
        }
        return ret;
    }

    @Override
    public String getEleboxRealtimeUUIDByModelUUID(String modelUUID) {
        EleboxModelExample eleboxModelExample = new EleboxModelExample();
        eleboxModelExample.createCriteria().andUidEqualTo(modelUUID);
        EleboxModel eleboxModel = eleboxModelMapper.selectByExample(eleboxModelExample).get(0);

        return eleboxMapper.selectByPrimaryKey(eleboxModel.getNnlightctlEleboxId()).getRealtimeUid();
    }

    @Override
    public String getEleboxRealtimeUUIDByModelId(Long modelId) {
        return eleboxMapper.selectByPrimaryKey(eleboxModelMapper.selectByPrimaryKey(modelId).getNnlightctlEleboxId()).getRealtimeUid();
    }


    @Override
    public String getEleboxRealtimeUUIDByLoopId(Long loopId) {
        return getEleboxRealtimeUUIDByModelId(eleboxModelLoopMapper.selectByPrimaryKey(loopId).getNnlightctlEleboxModelId());
    }

    @Override
    public EleboxModel getEleboxModelById(Long id) {
        return eleboxModelMapper.selectByPrimaryKey(id);
    }
}
