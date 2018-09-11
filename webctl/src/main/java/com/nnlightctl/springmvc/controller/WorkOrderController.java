package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.WorkFlowerNodeServer;
import com.nnlightctl.server.WorkOrderServer;
import com.nnlightctl.vo.CountWorkOrderStateView;
import com.nnlightctl.vo.StatisticWorkOrderView;
import com.nnlightctl.vo.WorkFlowerNodeMapView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/workOrder")
public class WorkOrderController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(WorkOrderController.class);
    @Autowired
    private WorkOrderServer workOrderServer;
    @Autowired
    private WorkFlowerNodeServer workFlowerNodeServer;
    /*
    *工单概况
    * 一、按月、年统计工单概况
    * */
    @RequestMapping("statisticWorkOrder")
    public String statisticWorkOrder(WorkOrderRequest request){
        logger.info("[POST]  /api/workOrder/statisticWorkOrder");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        List<StatisticWorkOrderView> statisticWorkOrderViewList = workOrderServer.statisticWorkOrder(request);
        List<WorkOrder> workOrderList = workOrderServer.statisticWorkOrderAvg(request);
        jsonResult.setData(workOrderList);
        jsonResult.setData(statisticWorkOrderViewList);
        return toJson(jsonResult);
    }
    /*
     *我的工单
     *一、统计工单状态
     * */
    @RequestMapping("countWorkOrderState")
    public String countWorkOrderState(){
        logger.info("[POST]  /api/workOrder/countWorkOrderState");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        List<CountWorkOrderStateView> list = workOrderServer.countWorkOrderState();
        jsonResult.setData(list);
        return toJson(jsonResult);
    }
    /*
     *我的工单
     *二、分页获取我的工单信息
     * */
    @RequestMapping("listWorkOrder")
    public String workOrderServer(ListWorkOrderRequest request){
        logger.info("[POST]  /api/workOrder/listWorkOrder");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<WorkOrder>, Integer> tuple = workOrderServer.listWorkOrder(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     *我的工单
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
     *我的工单
     *四、新增工单
     * */
    @RequestMapping(value = "addWordOrder")
    public String addWordOrder(WorkOrderRequest request, HttpServletRequest httpRequest){
        logger.info("[POST]  /api/workOrder/addWordOrder");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        MultipartFile attachFilePath = request.getAttachFilePath();
        if (attachFilePath == null) {
            int ret =workOrderServer.addWordOrder(request);
            if (ret > 0) {
                jsonResult = JsonResult.getSUCCESS();
            } else {
                jsonResult = JsonResult.getFAILURE();
            }
            return toJson(jsonResult);
        }else {
            String path = null;// 文件路径
            String type = null;// 文件类型
            String fileName = attachFilePath.getOriginalFilename();// 文件原名称

            /*type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {*/
            // 项目在容器中实际发布运行的根路径
            String realPath = httpRequest.getSession().getServletContext().getRealPath("/html/image/" + request.getSerialNumber());
            // 自定义的文件名称
            String trueFileName = fileName;
            // 设置存放图片文件的路径
            path = realPath +"\\"+ trueFileName;

            request.setPath(path);
            try {
                File tempFile = new File(path);
                // 判断父级目录是否存在，不存在则创建
                if (!tempFile.getParentFile().exists()) {
                    tempFile.getParentFile().mkdir();
                }
                // 判断文件是否存在，否则创建文件（夹）
                if (!tempFile.exists()) {
                    tempFile.mkdir();
                }
                // 转存文件到指定的路径
                attachFilePath.transferTo(new File(path));
                System.out.println("文件成功上传到指定目录下");
            } catch (IOException o) {
                o.printStackTrace();
            }
            int ret = workOrderServer.addWordOrder(request);
            if (ret > 0) {
                jsonResult = JsonResult.getSUCCESS();
            } else {
                jsonResult = JsonResult.getFAILURE();
            }
            return toJson(jsonResult);
        }
    }
    /*
     *我的工单
     *五、通过搜索条件分页获取历史工单信息
     * */
    @RequestMapping("listWorkOrderHistory")
    public String listWorkOrderHistory(BaseRequest request){
        logger.info("[POST]  /api/workOrder/listWorkOrderHistory");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<WorkOrderHistory>, Integer> tuple = workOrderServer.listWorkOrderHistory(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     *我的工单
     *六、已认领工单工作流执行预览
     * */
    @RequestMapping("previewWorkFlower")
    public String previewWorkFlower(Long workOrderId){
        logger.info("[POST]  /api/workOrder/previewWorkFlower");
        JsonResult jsonResult = JsonResult.getSUCCESS();

        List<WorkflowerNode> workflowerNodeList = workOrderServer.selectPreviewWorkFlower(workOrderId);

        jsonResult.setData(workflowerNodeList);
        return toJson(jsonResult);
    }
    /*
     *我的工单
     *七、分页获取我所在工作流中的节点中的所有工单
     * */
    @RequestMapping("listWorkFlowerWorkOrder")
    public String listWorkFlowerWorkOrder(BaseRequest request){
        logger.info("[POST]  /api/workOrder/listWorkFlowerWorkOrder");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<WorkOrder>, Integer> tuple = workOrderServer.listWorkFlowerWorkOrder(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }

    /*
     *流程管理
     *一、新增/修改流程节点
     * */
    @RequestMapping("addOrUpdateWorkFlowerNode")
    public String addOrUpdateWorkFlowerNode(WorkFlowerNodeRequest request){
        logger.info("[POST]  /api/workOrder/addOrUpdateWorkFlowerNode");
        int ret = workFlowerNodeServer.addOrUpdateWorkFlowerNode(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     *流程管理
     *二、删除流程节点
     * */
    @RequestMapping("deleteWorkFlowerNode")
    public String deleteWorkFlowerNode(WorkFlowerNodeRequest request){
        logger.info("[POST]  /api/workOrder/deleteWorkFlowerNode");
        int ret = workFlowerNodeServer.deleteWorkFlowerNode(request.getWorkFlowerNodeIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     *流程管理
     *三、分页获取流程节点
     * */
    @RequestMapping("listWorkFlowerNode")
    public String listWorkFlowerNode(BaseRequest request){
        logger.info("[POST]  /api/workOrder/listWorkFlowerNode");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<WorkflowerNode>, Integer> tuple = workFlowerNodeServer.listWorkFlowerNode(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     *流程管理
     *四、通过id获取单个流程节点
     * */
    @RequestMapping("getWorkFlowerNode")
    public String getWorkFlowerNode(Long id){
        logger.info("[POST]  /api/workOrder/getWorkFlowerNode");
        WorkflowerNode workflowerNode = workFlowerNodeServer.getWorkFlowerNode(id);
        List<WorkflowerNode> workflowerNodeList = new ArrayList<>();
        workflowerNodeList.add(workflowerNode);
        JsonResult jsonResult = JsonResult.getSUCCESS();
        jsonResult.setData(workflowerNodeList);

        return toJson(jsonResult);
    }
    /*
     *流程管理
     *五、新增/修改工作流信息
     * */
    @RequestMapping("addOrUpdateWorkFlower")
    public String addOrUpdateWorkFlower(WorkFlowerRequest request){
        logger.info("[POST]  /api/workOrder/addOrUpdateWorkFlower");
        int ret = workFlowerNodeServer.addOrUpdateWorkFlower(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     *流程管理
     *六、通过工作流id获取单个工作流信息（包含该工作流包含的全部工作流节点）
     * */
    @RequestMapping("getWorkFlowerById")
    public String getWorkFlowerById(Long id){
        logger.info("[POST]  /api/workOrder/getWorkFlowerById");
        WorkFlower workFlower = workFlowerNodeServer.getWorkFlowerById(id);
        List<WorkFlower> workFlowerList =new ArrayList<>();
        workFlowerList.add(workFlower);
        List<WorkFlowerNodeMapView> workFlowerNodeMapViewList = workFlowerNodeServer.listWorkflowerNodeMapByWorkflowerId(id);
        Map<String ,Object > map = new HashMap<>();
        JsonResult jsonResult = JsonResult.getSUCCESS();
        List list = new ArrayList();
        list.addAll(workFlowerList);
        list.addAll(workFlowerNodeMapViewList);
        jsonResult.setData(list);
        return toJson(jsonResult);
    }
    /*
     *流程管理
     *七、删除工作流（同时删除该工作流与节点的映射，但不删除任何节点）
     * */
    @RequestMapping("deleteWorkFlower")
    public String deleteWorkFlower(WorkFlowerRequest request){
        logger.info("[POST]  /api/workOrder/deleteWorkFlower");
        int ret = workFlowerNodeServer.deleteWorkFlower(request.getWorkFlowerIds());
        ret= workFlowerNodeServer.deleteWorkflowerNodeMapByWorkflowerId(request.getWorkFlowerIds());
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     *流程管理
     *八、分页获取工作流信息
     * */
    @RequestMapping("listWorkFlower")
    public String listWorkFlower(BaseRequest request){
        logger.info("[POST]  /api/workOrder/listWorkFlower");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<WorkFlower>, Integer> tuple = workFlowerNodeServer.listWorkFlower(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     *审批
     *一、根据登录用户，分页获取属于该登录用户审批的工作流流转记录信息
     * */
    @RequestMapping("listWorkFlowerApprove")
    public String listWorkFlowerApprove(BaseRequest request){
        logger.info("[POST]  /api/workOrder/listWorkFlowerApprove");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        Tuple.TwoTuple<List<WorkflowerMoveRecord>, Integer> tuple = workFlowerNodeServer.listWorkFlowerApprove(request);

        jsonResult.setData(tuple.getFirst());
        jsonResult.setTotal(tuple.getSecond());

        return toJson(jsonResult);
    }
    /*
     *审批
     *二、审批操作
     * */
    @RequestMapping("approveWorkFlower")
    public String approveWorkFlower(WorkflowerMoveRecordRequest request){
        logger.info("[POST]  /api/workOrder/approveWorkFlower");
        int ret = workFlowerNodeServer.approveWorkFlower(request) ;
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     *审批
     *三、审批工作流置为启用/停用状态
     * */
    @RequestMapping("enableWorkFlower")
    public String enableWorkFlower(WorkFlowerRequest request){
        logger.info("[POST]  /api/workOrder/enableWorkFlower");
        int ret = workFlowerNodeServer.enableWorkFlower(request);
        JsonResult jsonResult = null;
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
}
