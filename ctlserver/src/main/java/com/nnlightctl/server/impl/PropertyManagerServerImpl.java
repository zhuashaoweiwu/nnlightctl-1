package com.nnlightctl.server.impl;

import com.github.pagehelper.PageHelper;
import com.nnlight.common.DigesterUtil;
import com.nnlight.common.ReflectCopyUtil;
import com.nnlight.common.Tuple;
import com.nnlightctl.dao.RepairRecordMapper;
import com.nnlightctl.jdbcdao.PropertyManagerDao;
import com.nnlightctl.po.*;
import com.nnlightctl.request.ListDeviceDamageCountByMonthRequest;
import com.nnlightctl.request.ListDeviceRepairStatisticRequest;
import com.nnlightctl.request.ListRepairRecordRequest;
import com.nnlightctl.request.RepairRecordRequest;
import com.nnlightctl.server.ProjectServer;
import com.nnlightctl.server.PropertyManagerServer;
import com.nnlightctl.vo.ListDeviceDamageCountByMonthView;
import com.nnlightctl.vo.ListDeviceRepairStatisticView;
import com.sun.deploy.net.proxy.ProxyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class PropertyManagerServerImpl implements PropertyManagerServer {
    @Autowired
    private PropertyManagerDao propertyManagerDao;
    @Autowired
    private RepairRecordMapper repairRecordMapper;

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
}
