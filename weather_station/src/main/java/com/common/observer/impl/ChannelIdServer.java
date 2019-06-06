package com.common.observer.impl;

import com.common.observer.BindObserver;
import com.common.observer.HeartBeatObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者
 */
public class ChannelIdServer implements HeartBeatObserver {

    private static final Logger LOGGER=LoggerFactory.getLogger(ChannelIdServer.class);

    private List<BindObserver> observerList;

    private String mac;

    public ChannelIdServer(){
        observerList=new ArrayList<>();

    }

    @Override
    public void registerObserver(BindObserver observer) {
        observerList.add(observer);
        LOGGER.info("添加一个chanbelId");
    }

    @Override
    public void removeObserver(BindObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (BindObserver bindObserver : observerList) {
            bindObserver.bindMacUpdate(mac);
        }
    }

    /**
     * 取出一个mac地址，完成绑定
     */
    public void bindComplete(String mac){
        this.mac=mac;
        notifyObserver();


    }


}
