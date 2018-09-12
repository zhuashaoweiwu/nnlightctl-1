package com.nnlightctl.filter;

import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.po.UserOperationLog;
import com.nnlightctl.server.UserOpLogServer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Properties;

public class OpLogFilter {

    private static final Logger logger = LoggerFactory.getLogger(OpLogFilter.class);

    private Properties properties;

    @Autowired
    private UserOpLogServer userOpLogServer;

    public OpLogFilter() {
        try {
            properties = PropertiesUtil.load("config/urlMapOpDesc.properties");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void before(JoinPoint jp) {
        logger.info("生成用户操作记录");
        //获取注解
        RequestMapping annoRequestMapping = ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(RequestMapping.class);
        String[] annoValues = annoRequestMapping.value();

        //获取注解描述
        String opDesc = properties.getProperty(annoValues[0], annoValues[0]);

        //存入数据库
        UserOperationLog userOpLog = new UserOperationLog();
        userOpLog.setGmtCreated(new Date());
        userOpLog.setGmtUpdated(new Date());
        userOpLog.setOperationTime(new Date());
        userOpLog.setOperationType((byte)1);
        userOpLog.setOperationDesc(opDesc);

        userOpLogServer.addUserOpLog(userOpLog);
    }
}
