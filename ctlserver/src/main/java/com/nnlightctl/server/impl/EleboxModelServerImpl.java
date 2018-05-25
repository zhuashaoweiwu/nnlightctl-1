package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.po.EleboxModelLoopExample;
import com.nnlightctl.request.EleboxModelConditionRequest;
import com.nnlightctl.request.EleboxModelRequest;
import com.nnlightctl.request.ModelLoopRequest;
import com.nnlightctl.server.EleboxModelServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
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
            eleboxModel.setGmtCreated(new Date());
            eleboxModel.setGmtUpdated(new Date());
            if (request.getPowerRating() != null) {
                eleboxModel.setPowerRating(new BigDecimal(Double.toString(request.getPowerRating())));
            }

            if (request.getElectricRating() != null) {
                eleboxModel.setElectricRating(new BigDecimal(Double.toString(request.getElectricRating())));
            }

            if (request.getVoltageRating() != null) {
                eleboxModel.setVoltageRating(new BigDecimal(Double.toString(request.getVoltageRating())));
            }

            if (request.getLoopElectricity() != null) {
                eleboxModel.setLoopElectricity(new BigDecimal(Double.toString(request.getLoopElectricity())));
            }
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
        EleboxModel eleboxModel = new EleboxModel();
        ReflectCopyUtil.beanSameFieldCopy(request, eleboxModel);
        eleboxModel.setGmtUpdated(new Date());
        if (request.getPowerRating() != null) {
            eleboxModel.setPowerRating(new BigDecimal(Double.toString(request.getPowerRating())));
        }

        if (request.getElectricRating() != null) {
            eleboxModel.setElectricRating(new BigDecimal(Double.toString(request.getElectricRating())));
        }

        if (request.getVoltageRating() != null) {
            eleboxModel.setVoltageRating(new BigDecimal(Double.toString(request.getVoltageRating())));
        }

        if (request.getLoopElectricity() != null) {
            eleboxModel.setLoopElectricity(new BigDecimal(Double.toString(request.getLoopElectricity())));
        }

        int ret = eleboxModelMapper.updateByPrimaryKeySelective(eleboxModel);

        return ret;
    }

    @Override
    public int deleteEleboxModel(EleboxModelConditionRequest request) {
        List<Long> eleboxModelIdList = request.getEleboxModelIdList();
        int ret = -1;
        for (Long id : eleboxModelIdList) {
            //称删除对应的回路
            EleboxModelLoopExample loopExample = new EleboxModelLoopExample();
            loopExample.createCriteria().andNnlightctlEleboxModelIdEqualTo(id);
            eleboxModelLoopMapper.deleteByExample(loopExample);

            ret = eleboxModelMapper.deleteByPrimaryKey(id);
        }
        return ret;
    }
}
