package com.nnlightctl.server.impl.deploy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.request.deployRequest.DeployEleboxModelRequest;
import com.nnlightctl.request.deployRequest.DeployEleboxRequest;
import com.nnlightctl.server.deploy.service.DeployEleboxModelServer;
import com.nnlightctl.server.deploy.service.DeployEleboxServer;
import com.nnlightctl.vo.DeployEleboxView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeployEleboxModelServerImpl implements DeployEleboxModelServer {

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

    @Override
    public Tuple.TwoTuple<List<DeployEleboxView>, Integer> deployEleboxList(DeployEleboxRequest request) {
        Tuple.TwoTuple<List<DeployEleboxView>, Integer> twoTuple = new Tuple.TwoTuple<>();
//        Integer total = eleboxModelMapper.deployEleboxListCount(request);
        Page<Object> objects = PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        List<DeployEleboxView> deployEleboxViews = null;
        try {
            deployEleboxViews = eleboxModelMapper.deployEleboxList(request);
        }catch (Exception e) {
            e.printStackTrace();
        }
        twoTuple.setSecond((int)objects.getTotal());
        twoTuple.setFirst(deployEleboxViews);
        return twoTuple;
    }

}
