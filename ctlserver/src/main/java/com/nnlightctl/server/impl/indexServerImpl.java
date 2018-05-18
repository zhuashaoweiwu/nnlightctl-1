package com.nnlightctl.server.impl;

import com.nnlightctl.dao.AlarmMapper;
import com.nnlightctl.po.Alarm;
import com.nnlightctl.server.IndexServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class indexServerImpl implements IndexServer {

    @Autowired
    private AlarmMapper alarmMapper;

    @Override
    public String indexServer() {
//        Alarm alarm = new Alarm();
//        alarm.setGmtCreated(new Date());
//        alarm.setGmtUpdated(new Date());
//        alarm.setAlarmSource("Test");
//        alarmMapper.insertSelective(alarm);
        Alarm alarm = alarmMapper.selectByPrimaryKey(1L);
        System.out.println("select value is : " + alarm.getAlarmSource());
        return "select alarm success";
    }
}
