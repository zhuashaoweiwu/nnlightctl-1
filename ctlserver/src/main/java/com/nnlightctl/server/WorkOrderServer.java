package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepertoryOutReason;
import com.nnlightctl.po.WorkOrder;
import com.nnlightctl.po.WorkOrderHistory;
import com.nnlightctl.po.WorkflowerNode;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.ListWorkOrderRequest;
import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.vo.CountWorkOrderStateView;
import com.nnlightctl.vo.StatisticWorkOrderView;

import java.util.List;

public interface WorkOrderServer {
    List<StatisticWorkOrderView> statisticWorkOrder(WorkOrderRequest request);
    List<CountWorkOrderStateView> countWorkOrderState();
    List<StatisticWorkOrderView> statisticWorkOrderAvg(WorkOrderRequest request);
    Tuple.TwoTuple<List<WorkOrder>, Integer> listWorkOrder(ListWorkOrderRequest request);
    int claimWordOrder(WorkOrderRequest request);
    int addWordOrder(WorkOrderRequest request);
    Tuple.TwoTuple<List<WorkOrderHistory>, Integer> listWorkOrderHistory(BaseRequest request);
    List<WorkflowerNode> selectPreviewWorkFlower(Long workOrderId);
    Tuple.TwoTuple<List<WorkOrder>, Integer> listWorkFlowerWorkOrder(BaseRequest request);
}
