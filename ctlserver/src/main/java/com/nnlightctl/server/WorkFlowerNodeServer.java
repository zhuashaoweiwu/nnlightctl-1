package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.WorkFlower;
import com.nnlightctl.po.WorkflowerNode;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkFlowerNodeRequest;

import java.util.List;

public interface WorkFlowerNodeServer {
    int addOrUpdateWorkFlowerNode(WorkFlowerNodeRequest request);
    int deleteWorkFlowerNode(List<Long> workFlowerNodeIds);
    Tuple.TwoTuple<List<WorkflowerNode>, Integer> listWorkFlowerNode(BaseRequest request);
    WorkflowerNode getWorkFlowerNode(Long id);
}
