package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.RepertoryOutReason;
import com.nnlightctl.po.WorkOrder;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.WorkOrderServer;
import com.nnlightctl.vo.StatisticWorkOrderView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/workOrder")
public class WorkOrderController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(WorkOrderController.class);
    @Autowired
    private WorkOrderServer workOrderServer;

    /*
    *工单概况
    *一、按月、年统计工单概况
    * */
    @RequestMapping("statisticWorkOrder")
    public String statisticWorkOrder(WorkOrderRequest request){
        logger.info("[POST]  /api/workOrder/statisticWorkOrder");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        List<StatisticWorkOrderView> statisticWorkOrderViewList = workOrderServer.statisticWorkOrder(request);
        jsonResult.setData(statisticWorkOrderViewList);
        return toJson(jsonResult);
    }
    /*
     *工单概况
     *二、分页获取我的工单信息
     * */
    @RequestMapping("listWorkOrder")
    public String workOrderServer(BaseRequest request){
        logger.info("[POST]  /api/workOrder/listWorkOrder");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<WorkOrder>, Integer> tuple = workOrderServer.listWorkOrder(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     *工单概况
     *三、认领工单操作
     * */
    @RequestMapping("claimWordOrder")
    public String claimWordOrder(WorkOrderRequest request){
        logger.info("[POST]  /api/workOrder/claimWordOrder");
        int ret = workOrderServer.claimWordOrder(request);

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     *工单概况
     *四、新增工单
     * */
    @RequestMapping("addWordOrder")
    public String addWordOrder(){
        logger.info("[POST]  /api/workOrder/addWordOrder");
        int ret =1;

        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
}
