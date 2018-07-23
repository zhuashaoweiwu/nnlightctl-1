package com.nnlightctl.jdbcdao;

import com.nnlightctl.po.WorkOrder;
import com.nnlightctl.po.WorkflowerNode;
import com.nnlightctl.request.WorkFlowerRequest;
import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.vo.StatisticWorkOrderView;
import com.nnlightctl.vo.WorkFlowerNodeMapView;

import java.util.List;

public interface WorkOrderDao {
    //通过项目分类查询月的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderMouthTotalByProject(String date);
    //通过项目分类查询月的完成的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderMouthFinishByProject(String date);
    //通过项目分类查询年的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderYearTotalByProject(String date);
    //通过项目分类查询年的完成的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderYearFinishByProject(String date);

    //通过区域分类查询月的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderMouthTotalByRegion(String date);
    //通过区域分类查询月的完成的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderMouthFinishByRegion(String date);
    //通过区域分类查询年的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderYearTotalByRegion(String date);
    //通过区域分类查询年的完成的工单总数
    List<StatisticWorkOrderView> statisticWorkOrderYearFinishByRegion(String date);
    List<WorkOrder> listWorkOrderMouth(String date);
    List<WorkOrder> listWorkOrderYear(String date);
    int addOrUpdateWorkFlowerMap(List<Long> workFlowerNodeIds , Long WorkFlowerId);
    List<WorkFlowerNodeMapView> listWorkflowerNodeMapByWorkflowerId(Long workflowerId);
    int deleteWorkflowerNodeMapByWorkflowerId(Long workflowerId);
}
