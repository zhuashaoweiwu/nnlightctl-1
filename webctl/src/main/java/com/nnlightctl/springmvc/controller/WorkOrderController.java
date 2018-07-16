package com.nnlightctl.springmvc.controller;

import com.nnlight.common.Tuple;
import com.nnlightctl.po.*;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkFlowerNodeRequest;
import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.result.JsonResult;
import com.nnlightctl.server.WorkFlowerNodeServer;
import com.nnlightctl.server.WorkOrderServer;
import com.nnlightctl.vo.StatisticWorkOrderView;
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
import java.util.List;

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
    public String addWordOrder(WorkOrderRequest request,HttpServletRequest httpRequest,MultipartFile attachFilePath){
        logger.info("[POST]  /api/workOrder/addWordOrder");
        JsonResult jsonResult = JsonResult.getSUCCESS();
        if (attachFilePath == null) {
            jsonResult.setMsg("文件不存在！");
            jsonResult = JsonResult.getFAILURE();
            return toJson(jsonResult);
        }
        String path=null;// 文件路径
        String type=null;// 文件类型
        String fileName=attachFilePath.getOriginalFilename();// 文件原名称

        /*type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
        if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {*/
            // 项目在容器中实际发布运行的根路径
            String realPath=httpRequest.getSession().getServletContext().getRealPath("/html/image/"+request.getSerialNumber()+"/");
            // 自定义的文件名称
            String trueFileName=fileName;
            // 设置存放图片文件的路径
            path=realPath+trueFileName;
            request.setAttachFilePath(path);
            try{
                File tempFile = new File( path);
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
            }catch (IOException o){
                o.printStackTrace();
            }
       /* }else {
            logger.info("不是我们想要的文件类型,请按要求重新上传");
        }*/
        int ret =workOrderServer.addWordOrder(request);
        if (ret > 0) {
            jsonResult = JsonResult.getSUCCESS();
        } else {
            jsonResult = JsonResult.getFAILURE();
        }
        return toJson(jsonResult);
    }
    /*
     *工单概况
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

}
