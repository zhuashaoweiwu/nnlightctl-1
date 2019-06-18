package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.LightingModelMapper;
import com.nnlightctl.po.LightingModel;
import com.nnlightctl.po.LightingModelExample;
import com.nnlightctl.request.LightModelConditionRequest;
import com.nnlightctl.request.LightModelRequest;
import com.nnlightctl.server.LightModelServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class LightModelServerImpl implements LightModelServer {
    @Autowired
    private LightingModelMapper lightingModelMapper;

    @Override
    public int addOrUpdateLightModel(LightModelRequest request) {
        LightingModel lightingModel = new LightingModel();
        ReflectCopyUtil.beanSameFieldCopy(request, lightingModel);
        lightingModel.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() != null) {
            //修改
            ret = this.lightingModelMapper.updateByPrimaryKeySelective(lightingModel);
        } else {
            //添加
            lightingModel.setGmtCreated(new Date());
            ret = this.lightingModelMapper.insertSelective(lightingModel);
        }

        return ret;
    }

    @Override
    public int deleteLightModel(LightModelConditionRequest request) {
        List<Long> deleteLightModelIdList = request.getDeleteLightModelList();
        for (Long id : deleteLightModelIdList) {
            this.lightingModelMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<LightingModel>, Integer> listLightModel(LightModelConditionRequest request) {
        LightingModelExample lightingModelExample = new LightingModelExample();

        if (!StringUtils.isEmpty(request.getEquipmentNumber())) {
            lightingModelExample.createCriteria().andEquipmentNumberLike("%" + request.getEquipmentNumber() + "%");
        }

        if (!StringUtils.isEmpty(request.getModelName())){

            lightingModelExample.createCriteria().andModelNameLike("%"+request.getModelName()+"%");
        }

        int total = this.lightingModelMapper.countByExample(lightingModelExample);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        lightingModelExample.setOrderByClause("id DESC");
        List<LightingModel> lightingModels = this.lightingModelMapper.selectByExample(lightingModelExample);

        Tuple.TwoTuple<List<LightingModel>, Integer> tuple = new Tuple.TwoTuple<>();
        tuple.setFirst(lightingModels);
        tuple.setSecond(total);
        return tuple;
    }

    @Override
    public LightingModel getLightModelById(Long id) {
        return lightingModelMapper.selectByPrimaryKey(id);
    }
}
