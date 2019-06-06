package com.netty.hander;


import com.common.util.ArrayUtil;
import com.netty.dto.CommandData;
import com.netty.group.ChannelMacUtil;
import com.netty.process.WeatherProcess;
import com.netty.server.EchoWeatherServer;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
@ChannelHandler.Sharable
public class EchoWeatherHander extends ChannelInboundHandlerAdapter {

    private static final Logger logger=LoggerFactory.getLogger(EchoWeatherHander.class);


    @Resource
    private Context context;

    public EchoWeatherHander(EchoWeatherServer applicationContext, Context context, ChannelMacUtil channelMacUtil, WeatherProcess weatherProcess, ArrayUtil arrayUtil){
        this.applicationContext=applicationContext;
        this.channelMacUtil=channelMacUtil;
        this.weatherProcess=weatherProcess;
        this.arrayUtil=arrayUtil;
    }


    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {


    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.err.println("是否通过echoweatherhander");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof CommandData){
            CommandData commandData=(CommandData)msg;
            logger.info(String.valueOf(commandData));
        }


    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {




    }



    private EchoWeatherServer applicationContext;

    private ChannelMacUtil channelMacUtil;

    private WeatherProcess weatherProcess;

    private ArrayUtil arrayUtil;





}
