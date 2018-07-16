package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.WorkFlowerMapper;
import com.nnlightctl.dao.WorkOrderHistoryMapper;
import com.nnlightctl.dao.WorkOrderMapper;
import com.nnlightctl.jdbcdao.WorkOrderDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.BaseRequest;
import com.nnlightctl.request.WorkOrderRequest;
import com.nnlightctl.server.WorkOrderServer;
import com.nnlightctl.vo.StatisticWorkOrderView;
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
    @Override
    public List<StatisticWorkOrderView> statisticWorkOrder(WorkOrderRequest request){
        List<StatisticWorkOrderView> statisticWorkOrderViewList = new ArrayList<>();
        List<WorkOrder> workOrderList1 = new ArrayList<>();
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
            workOrderList1 = workOrderDao.listWorkOrderMouth(time);
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
            System.out.println(avg+"&&&&&&&&&&&&&&&");
            workOrderList1.get(j).setNnlightctlRegionId(avg);
        }

        return statisticWorkOrderViewList;
    }
    @Override
    public Tuple.TwoTuple<List<WorkOrder>, Integer> listWorkOrder(BaseRequest request){
        Tuple.TwoTuple<List<WorkOrder>, Integer> tuple = new Tuple.TwoTuple<>();

        WorkOrderExample workOrderExample = new WorkOrderExample();
        workOrderExample.setOrderByClause("id DESC");

        int total =workOrderMapper.countByExample(workOrderExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<WorkOrder> repertoryOutReasonList = workOrderMapper.selectByExample(workOrderExample);
        tuple.setFirst(repertoryOutReasonList);

        return tuple;
    }

    @Override
    public  int claimWordOrder(WorkOrderRequest request){
        WorkOrder workOrder = new WorkOrder();
        workOrder.setId(request.getWorkOrderId());
        workOrder.setGmtUpdated(new Date());
        workOrder.setNnlightctlMaskerId(request.getTaskerId());
        Byte state = 2;
        workOrder.setState(state);
        int ret = workOrderMapper.updateByPrimaryKey(workOrder);
        return ret;
    }

    @Override
    public int addWordOrder(WorkOrderRequest request){
        WorkOrder workOrder = new WorkOrder();
        workOrder.setGmtUpdated(new Date());
        workOrder.setAttachFilePath(request.getAttachFilePath());
        workOrder.setGmtCreated(new Date());
        workOrder.setSerialNumber(request.getSerialNumber());
        workOrder.setClassify(request.getClassify());
        workOrder.setNnlightctlWorkflowerId(request.getNnlightctlWorkflowerId());
        workOrder.setPriority(request.getPriority());
        workOrder.setNnlightctlRegionId(request.getNnlightctlRegionId());
        workOrder.setAddress(request.getAddress());
        workOrder.setNnlightctlMaskerId(request.getNnlightctlMaskerId());
        workOrder.setContent(request.getContent());;
        int ret = workOrderMapper.updateByPrimaryKey(workOrder);
        return ret;
    }
    @Override
    public Tuple.TwoTuple<List<WorkOrderHistory>, Integer> listWorkOrderHistory(BaseRequest request){
        Tuple.TwoTuple<List<WorkOrderHistory>, Integer> tuple = new Tuple.TwoTuple<>();

        WorkOrderHistoryExample workOrderHistoryExample = new WorkOrderHistoryExample();
        workOrderHistoryExample.setOrderByClause("id DESC");

        int total =workOrderHistoryMapper.countByExample(workOrderHistoryExample);
        tuple.setSecond(total);

        PageHelper.startPage(request.getPageNumber(), request.getPageSize());

        List<WorkOrderHistory> repertoryOutReasonList = workOrderHistoryMapper.selectByExample(workOrderHistoryExample);
        tuple.setFirst(repertoryOutReasonList);

        return tuple;
    }
}
