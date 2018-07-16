package com.nnlightctl.server.impl;

import com.nnlight.common.Constants;
import com.nnlight.common.QuartzUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.RepairRecordAutoCommitMapper;
import com.nnlightctl.dao.RepairRecordMapper;
import com.nnlightctl.jdbcdao.PropertyManagerDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.*;
import com.nnlightctl.server.PropertyManagerServer;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PropertyManagerServerImpl implements PropertyManagerServer {
    @Autowired
    private PropertyManagerDao propertyManagerDao;
    @Autowired
    private RepairRecordMapper repairRecordMapper;
    @Autowired
    private RepairRecordAutoCommitMapper repairRecordAutoCommitMapper;

    @Override
    public List<ListDeviceRepairStatisticView> listDeviceRepaireStatistic(ListDeviceRepairStatisticRequest listDeviceRepairStatisticRequest){
        return propertyManagerDao.listDeviceRepaireStatistic(listDeviceRepairStatisticRequest);
    }

    @Override
    public List<ListDeviceDamageCountByMonthView> listDeviceDamageCountByMonth(ListDeviceDamageCountByMonthRequest listDeviceDamageCountByMonthRequest){
        return propertyManagerDao.listDeviceDamageCountByMonth(listDeviceDamageCountByMonthRequest);
    }

    @Override
    public Tuple.TwoTuple<List<RepairRecord>, Integer> listRepairRecord(ListRepairRecordRequest request){
        return propertyManagerDao.listRepairRecord(request);
    }

    @Override
    public int addOrUpdateRepairRecord(RepairRecordRequest request){
        RepairRecord epairRecord = new RepairRecord();
        ReflectCopyUtil.beanSameFieldCopy(request, epairRecord);
        epairRecord.setGmtUpdated(new Date());

        int ret = -1;
        if (request.getId() == null) {
            //新增
            epairRecord.setGmtCreated(new Date());
            ret = repairRecordMapper.insertSelective(epairRecord);
        } else {
            //修改
            ret = repairRecordMapper.updateByPrimaryKeySelective(epairRecord);
        }

        return ret;
    }

    @Override
    public  int deleteRepairRecord(List<Long> repairRecordIds){
        for (Long id : repairRecordIds) {
            repairRecordMapper.deleteByPrimaryKey(id);
        }
        return 1;
    }

    @Override
    public int commitRepairRecord(List<Long> repairRecordIds){
        return propertyManagerDao.commitRepairRecord(repairRecordIds);
    }

    @Override
    public HSSFWorkbook exportDeviceOperation(ExportDeviceOperationRequest request) {

        ListDeviceRepairStatisticRequest listDeviceRepairStatisticRequest = new ListDeviceRepairStatisticRequest();
        listDeviceRepairStatisticRequest.setEndDate(request.getEndDate());
        listDeviceRepairStatisticRequest.setStartDate(request.getStartDate());
        List<ListDeviceRepairStatisticView> listDeviceRepairStatisticViewList = propertyManagerDao.listDeviceRepaireStatistic(listDeviceRepairStatisticRequest);

        ListDeviceDamageCountByMonthRequest listDeviceDamageCountByMonthRequest = new ListDeviceDamageCountByMonthRequest();
        listDeviceDamageCountByMonthRequest.setEndDate(request.getEndDate());
        listDeviceDamageCountByMonthRequest.setStartDate(request.getStartDate());
        List<ListDeviceDamageCountByMonthView> listDeviceDamageCountByMonthViews = propertyManagerDao.listDeviceDamageCountByMonth(listDeviceDamageCountByMonthRequest);
//创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("设备运维概况");

        //创建表头
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        row1.createCell(0).setCellValue("设备名称");
        row1.createCell(1).setCellValue("维修统计");
        row1.createCell(2).setCellValue("月份");
        row1.createCell(3).setCellValue("维修次数");
        int rowIndex = 1;
        for (ListDeviceRepairStatisticView listDeviceRepairStatisticView : listDeviceRepairStatisticViewList) {
            HSSFRow row = sheet.createRow(rowIndex++);
            //创建单元格并设置单元格内容
            row.createCell(0).setCellValue(listDeviceRepairStatisticView.getMyCatalogName());
            row.createCell(1).setCellValue(listDeviceRepairStatisticView.getListDeviceRepairStatisticCount());
        }
        for (ListDeviceDamageCountByMonthView listDeviceDamageCountByMonth : listDeviceDamageCountByMonthViews) {
            HSSFRow row = sheet.createRow(rowIndex++);
            //创建单元格并设置单元格内容
            row.createCell(2).setCellValue(listDeviceDamageCountByMonth.getMonth());
            row.createCell(3).setCellValue(listDeviceDamageCountByMonth.getMonthCount());
        }
        return wb;
    }

    @Override
    public int setDateAutoCommitRepairRecord(RepaireRecordConditionRequest request) {
        //生成自动提交维修记录
        List<Long> autoCommitRCIds = request.getRepairRecordIds();
        for (Long repairedRecordId : autoCommitRCIds) {
            RepairRecordAutoCommit repairRecordAutoCommit = new RepairRecordAutoCommit();
            repairRecordAutoCommit.setGmtCreated(new Date());
            repairRecordAutoCommit.setGmtUpdated(new Date());
            repairRecordAutoCommit.setRepairRecordId(repairedRecordId);
            repairRecordAutoCommit.setAutoCommitTime(request.getCommitDate());
            repairRecordAutoCommit.setCommitState((byte)0);

            this.repairRecordAutoCommitMapper.insertSelective(repairRecordAutoCommit);
        }

        //启动定时器
        Map<String, Object> params = new ConcurrentHashMap<>(2);
        params.put(Constants.JOB_PARAM_KEY_REPAIRRECORDAUTOCOMMITMAPPER, repairRecordAutoCommitMapper);
        params.put(Constants.JOB_PARAM_KEY_REPAIRRECORDMAPPER, this.repairRecordMapper);
        QuartzUtil.addJob(QuartzRepairRecordAutoCommitServerImpl.class, request.getCommitDate(), params);

        return 1;
    }
}
