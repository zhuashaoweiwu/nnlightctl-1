package com.common.observer.impl;

import com.common.observer.BindObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 观察者实体类
 */
public class ChannelServer implements BindObserver {

    private static final Logger LOGGER= LoggerFactory.getLogger(ChannelIdServer.class);

    @Value("${map.count}")
    private int mapCount;

    private String channelId;

    private Map<String,String> channelMacMap;

    public ChannelServer (String channelId){
        this.channelId=channelId;
        this.channelMacMap=new ConcurrentHashMap<>(mapCount);
    }


    @Override
    public void bindMacUpdate(String mac) {
        if (channelMacMap.get(mac)!=null&&channelMacMap.get(mac)!=channelId){
            channelMacMap.put(mac,channelId);
        }
    }
}
