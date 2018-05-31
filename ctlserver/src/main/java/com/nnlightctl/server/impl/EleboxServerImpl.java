package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.EleboxMapper;
import com.nnlightctl.dao.EleboxModelLoopMapper;
import com.nnlightctl.dao.EleboxModelMapper;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.EleboxModelServer;
import com.nnlightctl.server.EleboxServer;
import com.nnlightctl.server.ModelLoopServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EleboxServerImpl implements EleboxServer {

    @Autowired
    private EleboxMapper eleboxMapper;

    @Autowired
    private EleboxModelServer eleboxModelServer;

    @Autowired
    private EleboxModelMapper eleboxModelMapper;

    @Autowired
    private EleboxModelLoopMapper eleboxModelLoopMapper;

    @Autowired
    private ModelLoopServer modelLoopServer;

    @Override
    public int insertElebox(EleboxAddModelRequest request) {
        int ret = -1;
        int count = request.getCount() > 0 ? request.getCount() : 1;
        for (int i = 0; i < count; ++i) {
            Elebox elebox = new Elebox();
            elebox.setGmtCreated(new Date());
            elebox.setGmtUpdated(new Date());

            ret = eleboxMapper.insertSelective(elebox);

            List<EleboxModelRequest> eleboxModelRequestList = request.getDeviceList();
            for (EleboxModelRequest eleboxModelRequest : eleboxModelRequestList) {
                eleboxModelRequest.setNnlightctlEleboxId(elebox.getId());
                ret = eleboxModelServer.addEleboxModel(eleboxModelRequest);
            }
        }
        return ret;
    }

    @Override
    public int updateElebox(EleboxRequest request) {
        Elebox elebox = new Elebox();
        ReflectCopyUtil.beanSameFieldCopy(request, elebox);
        elebox.setGmtUpdated(new Date());

        return eleboxMapper.updateByPrimaryKeySelective(elebox);
    }

    @Override
    public int updateEleboxDevice(EleboxConditionRequest request) {
        List<Long> deleteDeviceIdList = request.getDeleteModelIdList();
        List<Long> addDeviceIdList = request.getAddModelIdList();

        /*处理删除的设备*/
        EleboxModelConditionRequest deleteModelRequest = new EleboxModelConditionRequest();
        deleteModelRequest.setEleboxModelIdList(deleteDeviceIdList);
        eleboxModelServer.deleteEleboxModel(deleteModelRequest);

        /*添加新增的设备*/
        for (Long addDeviceId : addDeviceIdList) {
            EleboxModelRequest addModelRequest = new EleboxModelRequest();
            addModelRequest.setId(addDeviceId);
            addModelRequest.setNnlightctlEleboxId(request.getId());
            eleboxModelServer.updateEleboxModel(addModelRequest);
        }

        return 1;
    }

    @Override
    public int updateModelLoopSplite(EleboxConditionRequest request) {
        //添加新的回路到数据库
        List<ModelLoopRequest> addModelLoopList = request.getSplitModelLoopList();
        for (ModelLoopRequest addModelLoop : addModelLoopList) {
            modelLoopServer.addOrUpdateModelLoop(addModelLoop);
        }

        //删除原回路
        eleboxModelLoopMapper.deleteByPrimaryKey(request.getBeSplitId());

        return 1;
    }

    @Override
    public int deleteElebox(EleboxConditionRequest request) {
        List<Long> deleteEleboxIdList = request.getEleboxIdList();
        for (Long deleteEleboxId : deleteEleboxIdList) {
            //先删除控制柜对应的设备
            EleboxModelExample eleboxModelExample = new EleboxModelExample();
            eleboxModelExample.createCriteria().andNnlightctlEleboxIdEqualTo(deleteEleboxId);
            List<EleboxModel> eleboxModelList = eleboxModelMapper.selectByExample(eleboxModelExample);

            List<Long> eleboxModelIdList = new ArrayList<>(10);
            for (EleboxModel eleboxModel : eleboxModelList) {
                eleboxModelIdList.add(eleboxModel.getId());
            }

            EleboxModelConditionRequest eleboxModelConditionRequest = new EleboxModelConditionRequest();
            eleboxModelConditionRequest.setEleboxModelIdList(eleboxModelIdList);

            eleboxModelServer.deleteEleboxModel(eleboxModelConditionRequest);

            //再删除控制柜本身
            this.eleboxMapper.deleteByPrimaryKey(deleteEleboxId);
        }
        return 1;
    }

    @Override
    public Tuple.TwoTuple<List<Elebox>, Integer> listElebox(BaseRequest request) {
        Tuple.TwoTuple<List<Elebox>, Integer> tuple = new Tuple.TwoTuple<>();
        EleboxExample eleboxExample = new EleboxExample();
        if (request instanceof EleboxConditionRequest) {
            Long projectId = ((EleboxConditionRequest)request).getProjectId();
            if (projectId != null) {
                eleboxExample.createCriteria().andNnlightctlProjectIdEqualTo(projectId);
            }
        }
        int total = eleboxMapper.countByExample(eleboxExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        eleboxExample.setOrderByClause("id DESC");
        List<Elebox> eleboxList = eleboxMapper.selectByExample(eleboxExample);
        tuple.setFirst(eleboxList);
        return tuple;
    }

    @Override
    public Tuple.TwoTuple<List<EleboxModel>, Integer> listEleboxModel(EleboxConditionRequest request) {
        Tuple.TwoTuple<List<EleboxModel>, Integer> twoTuple = new Tuple.TwoTuple<>();
        EleboxModelExample eleboxModelExample = new EleboxModelExample();
        eleboxModelExample.createCriteria().andNnlightctlEleboxIdEqualTo(request.getEleboxId());
        int total = eleboxModelMapper.countByExample(eleboxModelExample);
        twoTuple.setSecond(total);
        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        eleboxModelExample.setOrderByClause("id DESC");
        List<EleboxModel> eleboxModelList = eleboxModelMapper.selectByExample(eleboxModelExample);
        twoTuple.setFirst(eleboxModelList);
        return twoTuple;
    }

    @Override
    public Tuple.TwoTuple<List<EleboxModelLoop>, Integer> listModelLoop(Long modelId) {
        Tuple.TwoTuple<List<EleboxModelLoop>, Integer> twoTuple = new Tuple.TwoTuple<>();
        EleboxModelLoopExample eleboxModelLoopExample = new EleboxModelLoopExample();
        eleboxModelLoopExample.createCriteria().andNnlightctlEleboxModelIdEqualTo(modelId);
        int total = eleboxModelLoopMapper.countByExample(eleboxModelLoopExample);
        twoTuple.setSecond(total);

        eleboxModelLoopExample.setOrderByClause("id DESC");
        List<EleboxModelLoop> eleboxModelLoops = eleboxModelLoopMapper.selectByExample(eleboxModelLoopExample);
        twoTuple.setFirst(eleboxModelLoops);
        return twoTuple;
    }
}
