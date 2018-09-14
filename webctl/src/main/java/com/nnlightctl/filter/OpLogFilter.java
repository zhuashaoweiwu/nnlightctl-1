package com.nnlightctl.filter;

import com.nnlight.common.PropertiesUtil;
import com.nnlightctl.po.User;
import com.nnlightctl.po.UserOperationLog;
import com.nnlightctl.server.UserOpLogServer;
import com.nnlightctl.server.UserServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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

    @Autowired
    private UserServer userServer;

    public OpLogFilter() {
        try {
            properties = PropertiesUtil.load("config/urlMapOpDesc.properties");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public void before(JoinPoint jp) {
        //获取注解
        RequestMapping annoRequestMapping = ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(RequestMapping.class);
        String[] annoValues = annoRequestMapping.value();

        //判断登录用户权限
        Subject subject = SecurityUtils.getSubject();
        String loginName = (String) subject.getPrincipal();

        logger.info("生成用户操作记录");

        User user = userServer.getUserByLoginName(loginName);

        //获取注解描述
        String opDesc = properties.getProperty(annoValues[0], annoValues[0]);

        //存入数据库
        UserOperationLog userOpLog = new UserOperationLog();
        userOpLog.setGmtCreated(new Date());
        userOpLog.setGmtUpdated(new Date());
        userOpLog.setNnlightctlUserId(user.getId());
        userOpLog.setOperationTime(new Date());
        userOpLog.setOperationType((byte)1);
        userOpLog.setOperationDesc(opDesc);

        userOpLogServer.addUserOpLog(userOpLog);
    }
}
