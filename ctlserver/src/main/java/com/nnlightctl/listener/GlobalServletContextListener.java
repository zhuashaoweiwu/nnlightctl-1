package com.nnlightctl.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class GlobalServletContextListener implements ServletContextListener {

    private static ServletContext globalServletContext;

    public static ServletContext getGlobalServletContext() {
        if (globalServletContext == null) {
            throw new RuntimeException("全局ServletContext没有初始化！");
        }

        return globalServletContext;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        globalServletContext = servletContextEvent.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
