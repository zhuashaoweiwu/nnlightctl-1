package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.WorkFlower;
import com.nnlightctl.po.WorkflowerMoveRecord;
import com.nnlightctl.po.WorkflowerMoveRecordExample;
import com.nnlightctl.po.WorkflowerNode;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkFlowerNodeRequest;
import com.nnlightctl.request.WorkFlowerRequest;
import com.nnlightctl.request.WorkflowerMoveRecordRequest;
import com.nnlightctl.vo.WorkFlowerNodeMapView;

import java.util.List;

public interface WorkFlowerNodeServer {
    int addOrUpdateWorkFlowerNode(WorkFlowerNodeRequest request);
    int deleteWorkFlowerNode(List<Long> workFlowerNodeIds);
    int deleteWorkFlower(List<Long> workFlowerIds);
    Tuple.TwoTuple<List<WorkflowerNode>, Integer> listWorkFlowerNode(BaseRequest request);
    WorkflowerNode getWorkFlowerNode(Long id);
    int addOrUpdateWorkFlower(WorkFlowerRequest request);
    WorkFlower getWorkFlowerById(Long id);
    /*List<WorkflowerNode> getWorkFlowerNodeByWorkFlowerId(Long workFlwerId);*/
    List<WorkFlowerNodeMapView> listWorkflowerNodeMapByWorkflowerId(Long workflowerId);
    int deleteWorkflowerNodeMapByWorkflowerId(List<Long> workflowerIds);
    Tuple.TwoTuple<List<WorkFlower>, Integer> listWorkFlower(BaseRequest request);
    Tuple.TwoTuple<List<WorkflowerMoveRecord>, Integer> listWorkFlowerApprove(BaseRequest request);
    int updateApproveWorkFlower(WorkflowerMoveRecordRequest request);
    int updateEnableWorkFlower(WorkFlowerRequest request);
}
