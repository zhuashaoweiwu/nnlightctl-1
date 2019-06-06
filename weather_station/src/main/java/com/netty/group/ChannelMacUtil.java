package com.netty.group;

import com.netty.dto.ChannelWarp;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * channel与设备唯一编号绑定
 */
@Component
public class ChannelMacUtil {

    private static Map<String, ChannelWarp> channelAndMac=new ConcurrentHashMap<>();

    /**
     * 设备与channel绑定
     * @param mac
     * @param channelWarp
     * @returnc
     */
    public ChannelWarp put(String mac,ChannelWarp channelWarp){
        return channelAndMac.put(mac,channelWarp);
    }

    /**
     * 判断当前设备数
     * @return
     */
    public int size(){
        return channelAndMac.size();
    }

    /**
     * 根据mac查询通道
     * @param mac
     * @return
     */
    public ChannelWarp get(String mac){
        return channelAndMac.get(mac);
    }

    /**
     * 根据mac移除设备
     * @param mac
     * @return
     */
    public ChannelWarp removeByMac(String mac){
        return channelAndMac.remove(mac);
    }






}
