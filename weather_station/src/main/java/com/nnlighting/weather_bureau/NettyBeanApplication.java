package com.nnlighting.weather_bureau;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class NettyBeanApplication implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static DefaultListableBeanFactory defaultListableBeanFactory;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        NettyBeanApplication.applicationContext=applicationContext;
        defaultListableBeanFactory = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();

    }

    public static <T> T getBean(Class<T> clazz) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        String className = clazz.getName();
        defaultListableBeanFactory.registerBeanDefinition(className, beanDefinitionBuilder.getBeanDefinition());
        return (T) applicationContext.getBean(className);
    }

}
