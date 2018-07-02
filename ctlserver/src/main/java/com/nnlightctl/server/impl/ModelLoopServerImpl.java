package com.nnlightctl.server.impl;

import com.nnlight.common.ReflectCopyUtil;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.jdbcdao.EleboxModelDao;
import com.nnlightctl.po.EleboxModel;
import com.nnlightctl.po.EleboxModelLoop;
import com.nnlightctl.request.ModelLoopConditionRequest;
import com.nnlightctl.request.ModelLoopRequest;
import com.nnlightctl.server.ModelLoopServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ModelLoopServerImpl implements ModelLoopServer {
    @Autowired
    private EleboxModelLoopMapper modelLoopMapper;
    @Autowired
    private EleboxModelDao eleboxModelDao;
    @Override
    public int addOrUpdateModelLoop(ModelLoopRequest request) {
        EleboxModelLoop modelLoop = new EleboxModelLoop();
        ReflectCopyUtil.beanSameFieldCopy(request, modelLoop);
        modelLoop.setGmtUpdated(new Date());
        if (request.getVoltage() != null) {
            modelLoop.setVoltage(new BigDecimal(Double.toString(request.getVoltage())));
        }
        if (request.getElectricity() != null) {
            modelLoop.setElectricity(new BigDecimal(Double.toString(request.getElectricity())));
        }

        int ret = -1;
        if (request.getId() == null) {  //新增
            modelLoop.setGmtCreated(new Date());

            ret = modelLoopMapper.insertSelective(modelLoop);
        } else {    //修改
            ret = modelLoopMapper.updateByPrimaryKeySelective(modelLoop);
        }

        return ret;
    }

    @Override
    public int deleteModelLoop(ModelLoopConditionRequest request) {
        int ret = -1;
        List<Long> ids = request.getModelLoopIds();
        for (Long id : ids) {
            ret = modelLoopMapper.deleteByPrimaryKey(id);
        }
        return ret;
    }

    @Override
    public List<EleboxModelLoop> listEleboxLoop(Long EleboxId){
        List<EleboxModel> eleboxModelList = eleboxModelDao.listEleboxModel(EleboxId);
        List<EleboxModelLoop> eleboxModelLoopList = new ArrayList<EleboxModelLoop>();


        if(eleboxModelList.isEmpty()){

        }else {
            for(int i  = 0 ;i < eleboxModelList.size() ; i++){
                List<EleboxModelLoop> eleboxModelLoopList2 =  eleboxModelDao.listEleboxModelLoop(eleboxModelList.get(i).getId());
                eleboxModelLoopList.addAll(eleboxModelLoopList2);
            }
        }

        return eleboxModelLoopList;
    }
}
