package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.DigesterUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.WorkflowerNodeMapper;
import com.nnlightctl.po.WorkflowerNode;
import com.nnlightctl.po.WorkflowerNodeExample;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkFlowerNodeRequest;
import com.nnlightctl.server.WorkFlowerNodeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class WorkFlowerNodeServerImpl implements WorkFlowerNodeServer {
    @Autowired
    private WorkflowerNodeMapper workflowerNodeMapper;
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
}
