package com.nnlightctl.server;

import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.vo.StatisticWorkOrderView;

import java.util.List;

public interface WorkOrderServer {
    List<StatisticWorkOrderView> statisticWorkOrder(WorkOrderRequest request);
}
