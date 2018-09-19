package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.DigesterUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.WorkFlowerMapper;
import com.nnlightctl.dao.WorkOrderMapper;
import com.nnlightctl.dao.WorkflowerMoveRecordMapper;
import com.nnlightctl.dao.WorkflowerNodeMapper;
import com.nnlightctl.jdbcdao.WorkOrderDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkFlowerNodeRequest;
import com.nnlightctl.request.WorkFlowerRequest;
import com.nnlightctl.request.WorkflowerMoveRecordRequest;
import com.nnlightctl.server.WorkFlowerNodeServer;
import com.nnlightctl.vo.WorkFlowerNodeMapView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class WorkFlowerNodeServerImpl implements WorkFlowerNodeServer {
    @Autowired
    private WorkflowerNodeMapper workflowerNodeMapper;
    @Autowired
    private WorkOrderDao workOrderDao;
    @Autowired
    private WorkFlowerMapper workFlowerMapper;
    @Autowired
    private WorkflowerMoveRecordMapper workflowerMoveRecordMapper;
    @Override
    public int addOrUpdateWorkFlowerNode(WorkFlowerNodeRequest request){
        WorkflowerNode workFlowerNode = new WorkflowerNode();
        ReflectCopyUtil.beanSameFieldCopy(request, workFlowerNode);
        workFlowerNode.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            workFlowerNode.setGmtCreated(new Date());

            ret = workflowerNodeMapper.insertSelective(workFlowerNode);
        } else {
            //修改
            ret = workflowerNodeMapper.updateByPrimaryKeySelective(workFlowerNode);
        }

        return ret;
    }
    @Override
    public int deleteWorkFlowerNode(List<Long> workFlowerNodeIds){
        for (Long id : workFlowerNodeIds) {
            workflowerNodeMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
    @Override
    public int  deleteWorkFlower(List<Long> workFlowerIds){
        for (Long id : workFlowerIds) {
            workFlowerMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }
    @Override
    public Tuple.TwoTuple<List<WorkflowerNode>, Integer> listWorkFlowerNode(BaseRequest request){
        Tuple.TwoTuple<List<WorkflowerNode>, Integer> tuple = new Tuple.TwoTuple<>();

        WorkflowerNodeExample workflowerNodeExample = new WorkflowerNodeExample();
        workflowerNodeExample.setOrderByClause("id DESC");

        int total =workflowerNodeMapper.countByExample(workflowerNodeExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<WorkflowerNode> workflowerNodeList = workflowerNodeMapper.selectByExample(workflowerNodeExample);
        tuple.setFirst(workflowerNodeList);

        return tuple;
    }
    @Override
    public WorkflowerNode getWorkFlowerNode(Long id){
        return workflowerNodeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addOrUpdateWorkFlower(WorkFlowerRequest request){
        WorkFlower workFlower = new WorkFlower();
        ReflectCopyUtil.beanSameFieldCopy(request, workFlower);
        workFlower.setGmtUpdated(new Date());

        int ret = 1;
        if (request.getId() == null) {
            //新增
            workFlower.setGmtCreated(new Date());

            ret = workFlowerMapper.insertSelective(workFlower);
            workOrderDao.addOrUpdateWorkFlowerMap(request.getWorkFlowerNodeIds(),workFlower.getId());

        } else {
            //修改
            ret = workFlowerMapper.updateByPrimaryKeySelective(workFlower);
            workOrderDao.addOrUpdateWorkFlowerMap(request.getWorkFlowerNodeIds(),request.getId());
        }
        return ret;
    }

    @Override
    public WorkFlower getWorkFlowerById(Long id){
        return workFlowerMapper.selectByPrimaryKey(id);
    }
    @Override
    public  List<WorkFlowerNodeMapView> listWorkflowerNodeMapByWorkflowerId(Long workflowerId){
        return workOrderDao.listWorkflowerNodeMapByWorkflowerId(workflowerId);
    }
    @Override
    public int deleteWorkflowerNodeMapByWorkflowerId(List<Long> workflowerIds){
        int ret = 0;
        for (Long id: workflowerIds) {
            ret = workOrderDao.deleteWorkflowerNodeMapByWorkflowerId(id);
        }
        return ret;
    }
    @Override
    public Tuple.TwoTuple<List<WorkFlower>, Integer> listWorkFlower(BaseRequest request){
        Tuple.TwoTuple<List<WorkFlower>, Integer> tuple = new Tuple.TwoTuple<>();

        WorkFlowerExample workFlowerExample = new WorkFlowerExample();
        workFlowerExample.setOrderByClause("id DESC");

        int total =workFlowerMapper.countByExample(workFlowerExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<WorkFlower> workFlowerList = workFlowerMapper.selectByExample(workFlowerExample);
        tuple.setFirst(workFlowerList);

        return tuple;
    }
    @Override
    public Tuple.TwoTuple<List<WorkflowerMoveRecord>, Integer> listWorkFlowerApprove(BaseRequest request){
        Tuple.TwoTuple<List<WorkflowerMoveRecord>, Integer> tuple = new Tuple.TwoTuple<>();
        WorkflowerMoveRecordExample workflowerMoveRecordExample = new WorkflowerMoveRecordExample();
        Byte moveState = 1 ;
        workflowerMoveRecordExample.createCriteria().andMoveStateEqualTo(moveState);
        int total =workflowerMoveRecordMapper.countByExample(workflowerMoveRecordExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());
        List<WorkflowerMoveRecord> workflowerMoveRecordList = workflowerMoveRecordMapper.selectByExample(workflowerMoveRecordExample);
        tuple.setFirst(workflowerMoveRecordList);
        return tuple;
    }
    @Override
    public int updateApproveWorkFlower(WorkflowerMoveRecordRequest request){
        WorkflowerMoveRecord workflowerMoveRecord = new WorkflowerMoveRecord();
        Integer  ret = request.getIsApproved();
        workflowerMoveRecord.setPassState(ret.byteValue());
        workflowerMoveRecord.setGmtUpdated(new Date());
        workflowerMoveRecord.setDeniedReson(request.getRefusedReason());
        workflowerMoveRecord.setId(request.getWorkFlowerRecordId());
        return workflowerMoveRecordMapper.updateByPrimaryKeySelective(workflowerMoveRecord);
    }
    @Override
    public int updateEnableWorkFlower(WorkFlowerRequest request){
        WorkFlower workFlower = new WorkFlower();
        workFlower.setId(request.getWorkFlowerId());
        workFlower.setGmtUpdated(new Date());
        Integer ret = request.getIsEnable();
        workFlower.setState(ret.byteValue());
        return workFlowerMapper.updateByPrimaryKeySelective(workFlower);
    }
}
