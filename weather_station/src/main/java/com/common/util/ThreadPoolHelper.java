package com.common.util;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Component
public class ThreadPoolHelper {

    private static final Logger LOGGER= LoggerFactory.getLogger(ThreadPoolHelper.class);

    public static ThreadPoolExecutor commandExecutor(){
        return new ScheduledThreadPoolExecutor(2,
                new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
    }

    public static void shutdownThread() {
        LOGGER.debug("shutdown comitTaskPool...");
        commandExecutor().shutdown();
        try {
            if (!commandExecutor().isTerminated()) {
                LOGGER.debug("直接关闭失败[" + commandExecutor().toString() + "]");
                commandExecutor().awaitTermination(3, TimeUnit.SECONDS);
                if (commandExecutor().isTerminated()) {
                    LOGGER.debug("成功关闭[" + commandExecutor().toString() + "]");
                } else {
                    LOGGER.debug("[" + commandExecutor().toString() + "]关闭失败，执行shutdownNow...");
                    if (commandExecutor().shutdownNow().size() > 0) {
                        LOGGER.debug("[" + commandExecutor().toString() + "]没有关闭成功");
                    } else {
                        LOGGER.debug("shutdownNow执行完毕，成功关闭[" + commandExecutor().toString() + "]");
                    }
                }
            } else {
                LOGGER.debug("成功关闭[" + commandExecutor().toString() + "]");
            }
        } catch (InterruptedException e) {
            LOGGER.warn("接收到中断请" + commandExecutor().toString() + "停止操作");
        }
    }
}




