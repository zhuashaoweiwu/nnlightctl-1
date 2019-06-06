package com.netty.hander;


import com.common.util.ArrayUtil;
import com.netty.dto.ChannelWarp;
import com.netty.dto.HeartCommand;
import com.netty.server.EchoWeatherServer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ChannelHandler.Sharable
public class BindWeatherHander extends ChannelInboundHandlerAdapter {

    private static final Logger LOGGER= LoggerFactory.getLogger(BindWeatherHander.class);

    private final  byte[] bytes=new byte[]{(byte)0xFE, (byte)0xFD, (byte)0xFC, (byte)0xFB, (byte)0xFA, (byte)0xF9};


    public BindWeatherHander(EchoWeatherServer applicationContext,ArrayUtil arrayUtil,ChannelWarp channelWarp){
        this.applicationContext=applicationContext;
        this.arrayUtil=arrayUtil;
        this.channelWarpMap=new ConcurrentHashMap<>();
        this.channelWarp=channelWarp;
        bindContext=this;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (applicationContext!=null) {
            //得到通道信息，通道的唯一标识channelid
            HeartCommand heartCommand = (HeartCommand) msg;
            synchronized (msg) {
                //获得mac地址
                byte[] mac = new byte[6];
                System.arraycopy(heartCommand.getData(), 0, mac, 0, 6);
                String macAddress = ByteBufUtil.hexDump(mac);
                //获得channelId
                String channelId = ctx.channel().id().asShortText();
                channelWarp.setMacAddress(macAddress);

                channelWarp.setContext(ctx);
                if (channelId!=null&&channelWarpMap.get(channelId)==null){
                    LOGGER.info("ChannelId:"+channelId+" 绑定 "+"MacAddress:"+macAddress);
                    channelWarpMap.put(channelId, channelWarp);
                }

            }
            ctx.fireChannelRead(msg);
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    private EchoWeatherServer applicationContext;

    private ArrayUtil arrayUtil;


    public Map<String, ChannelWarp> getChannelWarpMap() {
        return channelWarpMap;
    }

    private Map<String, ChannelWarp> channelWarpMap;

    private ChannelWarp channelWarp;

    private static BindWeatherHander bindContext;

    public static BindWeatherHander getBindContext(){
        if (bindContext==null){
            throw new RuntimeException("信息有误");
        }
        return bindContext;
    }





}
