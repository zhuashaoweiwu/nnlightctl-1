package com.netty.dto;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
public class ChannelWarp {
    /**
     * 设备的唯一编号
     */
    private String macAddress;
    /**
     * 通道的唯一编号
     */
    private String ChannelId;
    /**
     *  通信通道
     */
    private Channel channel;

    private ChannelHandlerContext context;



}
