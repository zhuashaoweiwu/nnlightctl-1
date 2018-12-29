package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.*;
import com.nnlightctl.jdbcdao.WorkOrderDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.WorkFlowerNodeServer;
import com.nnlightctl.server.WorkOrderServer;
import com.nnlightctl.vo.CountWorkOrderStateView;
import com.nnlightctl.vo.StatisticWorkOrderView;
import com.nnlightctl.vo.WorkFlowerNodeMapView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class WorkOrderServerImpl implements WorkOrderServer {

    @Autowired
    private WorkOrderMapper workOrderMapper;
    @Autowired
    private WorkOrderDao workOrderDao;
    @Autowired
    private WorkOrderHistoryMapper workOrderHistoryMapper;
    @Autowired
    private WorkFlowerMapper workFlowerMapper;
    @Autowired
    private WorkflowerMoveRecordMapper workflowerMoveRecordMapper;
    @Autowired
    private WorkflowerNodeMapper workflowerNodeMapper;
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrder(WorkOrderRequest request){
        List<StatisticWorkOrderView> statisticWorkOrderViewList = new ArrayList<>();
        if (request.getTimeType()==0){
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
            String  time=  df.format(request.getDate());
            List<StatisticWorkOrderView> statisticWorkOrderViewList1 = workOrderDao.statisticWorkOrderMouthFinishByProject(time);
            List<StatisticWorkOrderView> statisticWorkOrderViewList2 = workOrderDao.statisticWorkOrderMouthTotalByProject(time);
            List<StatisticWorkOrderView> statisticWorkOrderViewList3 = workOrderDao.statisticWorkOrderMouthFinishByRegion(time);
            List<StatisticWorkOrderView> statisticWorkOrderViewList4 = workOrderDao.statisticWorkOrderMouthTotalByRegion(time);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList1);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList2);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList3);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList4);
            //workOrderList1 = workOrderDao.listWorkOrderMouth(time);
        }else if (request.getTimeType()==1){
            SimpleDateFormat df=new SimpleDateFormat("yyyy");
            String  time=  df.format(request.getDate());

            List<StatisticWorkOrderView> statisticWorkOrderViewList1 = workOrderDao.statisticWorkOrderYearFinishByProject(time);
            List<StatisticWorkOrderView> statisticWorkOrderViewList2 = workOrderDao.statisticWorkOrderYearTotalByProject(time);
            List<StatisticWorkOrderView> statisticWorkOrderViewList3 = workOrderDao.statisticWorkOrderYearFinishByRegion(time);
            List<StatisticWorkOrderView> statisticWorkOrderViewList4 = workOrderDao.statisticWorkOrderYearTotalByRegion(time);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList1);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList2);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList3);
            statisticWorkOrderViewList.addAll(statisticWorkOrderViewList4);
        }
        return statisticWorkOrderViewList;
    }
    @Override
    public List<CountWorkOrderStateView> countWorkOrderState(){
        WorkOrderExample workOrderExample = new WorkOrderExample();
        List<CountWorkOrderStateView> list = new ArrayList<>();
        workOrderExample.setOrderByClause("id DESC");

        int total =workOrderMapper.countByExample(workOrderExample);
        Byte state = 1;
        workOrderExample.createCriteria().andStateEqualTo(state);
        int finishTotal = workOrderMapper.countByExample(workOrderExample);
        Byte state1 =2;
        workOrderExample.createCriteria().andStateEqualTo(state1);
        int noFinishTotal = workOrderMapper.countByExample(workOrderExample);
        CountWorkOrderStateView countWorkOrderStateView  = new CountWorkOrderStateView();
        countWorkOrderStateView.setFinishTotal(finishTotal);
        countWorkOrderStateView.setTotal(total);
        countWorkOrderStateView.setNoFinishTotal(noFinishTotal);
        list.add(countWorkOrderStateView);
        return list;
    }

    @Override
    public List<StatisticWorkOrderView> statisticWorkOrderAvg(WorkOrderRequest request){
        List<WorkOrder> workOrderList1 = new ArrayList<>();
        List<StatisticWorkOrderView> statisticWorkOrderViewList = new ArrayList<>();
        if (request.getTimeType()==0){
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
            String  time=  df.format(request.getDate());
            workOrderList1 = workOrderDao.listWorkOrderMouth(time);
        }else if (request.getTimeType()==1){
            SimpleDateFormat df=new SimpleDateFormat("yyyy");
            String  time=  df.format(request.getDate());
            workOrderList1 = workOrderDao.listWorkOrderYear(time);
        }
        if (!workOrderList1.isEmpty()) {
            for (int i = 0 ; i < workOrderList1.size() ; i++){
                Long done =  workOrderList1.get(i).getWorkDone().getTime();
                Long  created= workOrderList1.get(i).getWorkCreated().getTime();
                System.out.println(workOrderList1.get(i).getWorkDone()+"%%%%%%%"+workOrderList1.get(i).getWorkCreated());
                System.out.println(done +"*****"+created);
                Long time = done -created;
                workOrderList1.get(i).setNnlightctlRegionId(time);
            }
        }
        List<WorkOrder> workOrderList = new ArrayList<>();
        for (int j = 0 ; j<workOrderList1.size() ;j++){
            StatisticWorkOrderView statisticWorkOrderView = new StatisticWorkOrderView();
            int count = 1;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HHmmss");

            Long project = workOrderList1.get(j).getNnlightctlProjectId();
            Long totalTime = workOrderList1.get(j).getNnlightctlRegionId();
            for (int k = 0 ; k <workOrderList1.size() ; k++){
                if (workOrderList1.get(k).getNnlightctlProjectId()== project){
                    if (j!=k){
                        count++;
                        totalTime = totalTime+workOrderList1.get(k).getNnlightctlRegionId();
                    }
                     workOrderList1.remove(k);
                }
            }
            Long avg = totalTime/count/60/1000/60;
            System.out.println(avg+"&&&&&&&&&&&&&&&"+workOrderList1.get(j).getAddress());
            statisticWorkOrderView.setAvgTime(avg);
            statisticWorkOrderView.setProjectName(workOrderList1.get(j).getAddress());
            statisticWorkOrderViewList.add(statisticWorkOrderView);
        }

        for  ( int  i  =   0 ; i  <  statisticWorkOrderViewList.size()  -   1 ; i ++ )  {
            for  ( int  j  =  statisticWorkOrderViewList.size()  -   1 ; j  >  i; j -- )  {
                if  (statisticWorkOrderViewList.get(j).equals(statisticWorkOrderViewList.get(i)))  {
                    statisticWorkOrderViewList.remove(j);
                }
            }
        }
        return statisticWorkOrderViewList;

    }
    @Override
    public Tuple.TwoTuple<List<WorkOrder>, Integer> listWorkOrder(ListWorkOrderRequest request){
        Tuple.TwoTuple<List<WorkOrder>, Integer> tuple = new Tuple.TwoTuple<>();

        WorkOrderExample workOrderExample = new WorkOrderExample();
        workOrderExample.createCriteria().andStateEqualTo(request.getState());
        workOrderExample.setOrderByClause("id DESC");

        int total =workOrderMapper.countByExample(workOrderExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<WorkOrder> repertoryOutReasonList = workOrderMapper.selectByExample(workOrderExample);
        tuple.setFirst(repertoryOutReasonList);

        return tuple;
    }

    @Override
    public  int updateClaimWordOrder(WorkOrderRequest request){
       WorkOrder workOrder2 = workOrderMapper.selectByPrimaryKey(request.getWorkOrderId());

        WorkflowerMoveRecord workflowerMoveRecord = new WorkflowerMoveRecord();
        workflowerMoveRecord.setGmtCreated(new Date());
        workflowerMoveRecord.setGmtUpdated(new Date());
        workflowerMoveRecord.setNnlightctlWorkOrderId(request.getWorkOrderId());
        workflowerMoveRecord.setNnlightctlWorkflowerId(workOrder2.getNnlightctlWorkflowerId());
        Byte passState = 0;
        workflowerMoveRecord.setPassState(passState);

        workflowerMoveRecordMapper.insertSelective(workflowerMoveRecord);

        WorkOrder workOrder = new WorkOrder();
        workOrder.setId(request.getWorkOrderId());
        workOrder.setGmtUpdated(new Date());
        workOrder.setNnlightctlMaskerId(request.getTaskerId());
        Byte state = 2;
        workOrder.setState(state);
        int ret = workOrderMapper.updateByPrimaryKeySelective(workOrder);
        return ret;
    }

    @Override
    public int addWordOrder(WorkOrderRequest request){

        WorkFlower workFlower = new WorkFlower();

        workFlower.setGmtUpdated(new Date());
        workFlower.setGmtCreated(new Date());
        Byte state = 0;
        workFlower.setState(state);
        workFlower.setMem(request.getContent());
        workFlower.setWorkflowerName(request.getAddress());
        int ret2 = workFlowerMapper.insertSelective(workFlower);

        WorkOrder workOrder = new WorkOrder();
        workOrder.setGmtUpdated(new Date());
        workOrder.setAttachFilePath(request.getPath());
        workOrder.setGmtCreated(new Date());
        workOrder.setSerialNumber(request.getSerialNumber());
        workOrder.setClassify(request.getClassify());
        workOrder.setNnlightctlWorkflowerId(request.getNnlightctlWorkflowerId());
        workOrder.setPriority(request.getPriority());
        workOrder.setNnlightctlRegionId(request.getNnlightctlRegionId());
        workOrder.setAddress(request.getAddress());
        workOrder.setNnlightctlMaskerId(request.getNnlightctlMaskerId());
        workOrder.setContent(request.getContent());;
        workOrder.setNnlightctlWorkflowerId(workFlower.getId());
        Byte s = 1;
        workOrder.setState(s );
        workOrder.setWorkCreated(new Date());
        int ret = workOrderMapper.insertSelective(workOrder);
        return ret;
    }
    @Override
    public Tuple.TwoTuple<List<WorkOrderHistory>, Integer> listWorkOrderHistory(WorkOrderHistoryRequest request){
        Tuple.TwoTuple<List<WorkOrderHistory>, Integer> tuple = new Tuple.TwoTuple<>();

        WorkOrderHistoryExample workOrderHistoryExample = new WorkOrderHistoryExample();
        WorkOrderHistoryExample.Criteria criteria = workOrderHistoryExample.createCriteria();

        if (request.getEndTime() != null){
            criteria.andRecordDateLessThanOrEqualTo(request.getEndTime());
        }
        if (request.getStartTime() != null){
            criteria.andRecordDateGreaterThanOrEqualTo(request.getStartTime());
        }
        if (request.getNnlightctlMaskerId() != null){

        }
        workOrderHistoryExample.setOrderByClause("id DESC");

        int total =workOrderHistoryMapper.countByExample(workOrderHistoryExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<WorkOrderHistory> repertoryOutReasonList = workOrderHistoryMapper.selectByExample(workOrderHistoryExample);
        tuple.setFirst(repertoryOutReasonList);

        return tuple;
    }
    @Override
    public  List<WorkflowerNode> selectPreviewWorkFlower(Long workOrderId){
        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(workOrderId);
        Long workFlowerId = workOrder.getNnlightctlWorkflowerId();
        List<WorkFlowerNodeMapView> workFlowerNodeMapViewList = workOrderDao.listWorkflowerNodeMapByWorkflowerId(workFlowerId);
        List<WorkflowerNode> workflowerNodeList = new ArrayList<>();
        for(int i = 0 ; i<workFlowerNodeMapViewList.size() ; i++ ){
            WorkflowerNode workflowerNode = workflowerNodeMapper.selectByPrimaryKey(workFlowerNodeMapViewList.get(i).getNnlightctlWorkflowerNodeId());
            workflowerNodeList.add(workflowerNode);
        }
        return workflowerNodeList;
    }

    @Override
    public Tuple.TwoTuple<List<WorkOrder>, Integer> listWorkFlowerWorkOrder(WorkFlowerWorkOrderRequest request){
        Tuple.TwoTuple<List<WorkOrder>, Integer> tuple = new Tuple.TwoTuple<>();

        WorkOrderExample workOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = workOrderExample.createCriteria();
        if (request.getEndTime() !=null){
            criteria.andGmtUpdatedLessThanOrEqualTo(request.getEndTime());
        }
        if (request.getStartTime() != null){
            criteria.andGmtUpdatedGreaterThanOrEqualTo(request.getStartTime());
        }
        if (request.getSerialNumber() != null){
            criteria.andSerialNumberEqualTo(request.getSerialNumber());
        }
        if (request.getState() != null){
            criteria.andStateEqualTo(request.getState().byteValue());
        }
        criteria.andNnlightctlWorkflowerIdIsNotNull();

        workOrderExample.setOrderByClause("id DESC");

        int total =workOrderMapper.countByExample(workOrderExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<WorkOrder> repertoryOutReasonList = workOrderMapper.selectByExample(workOrderExample);
        tuple.setFirst(repertoryOutReasonList);

        return tuple;
    }
}
