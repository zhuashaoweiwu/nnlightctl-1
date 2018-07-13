package com.nnlightctl.server;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepertoryOutReason;
import com.nnlightctl.po.WorkOrder;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.vo.StatisticWorkOrderView;

import java.util.List;

public interface WorkOrderServer {
    List<StatisticWorkOrderView> statisticWorkOrder(WorkOrderRequest request);
    Tuple.TwoTuple<List<WorkOrder>, Integer> listWorkOrder(BaseRequest request);
    int claimWordOrder(WorkOrderRequest request);
}
