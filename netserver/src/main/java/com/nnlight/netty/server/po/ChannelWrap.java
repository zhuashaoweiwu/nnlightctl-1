package com.nnlight.netty.server.po;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

public class ChannelWrap {
    private String imei;
    private String name;
    private Channel channel;
    private ChannelHandlerContext context;


    public ChannelHandlerContext getContext() {
        return context;
    }

    public void setContext(ChannelHandlerContext context) {
        this.context = context;
    }


    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
