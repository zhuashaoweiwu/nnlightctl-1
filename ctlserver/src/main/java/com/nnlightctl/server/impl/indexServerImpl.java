package com.nnlightctl.server.impl;

import com.nnlightctl.dao.AlarmMapper;
import com.nnlightctl.po.Alarm;
import com.nnlightctl.server.IndexServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class indexServerImpl implements IndexServer {

    private static final Logger logger = LoggerFactory.getLogger(indexServerImpl.class);

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

    @Cacheable("loginUserCache")
    @Override
    public String testEhcache(int id) {
        logger.info("Ehcache 执行了方法，没有从缓存中读取！");
        switch (id) {
            case 1:
                return "Hello";
            case 2:
                return "World!";
                default:
                    return "";
        }
    }
}
