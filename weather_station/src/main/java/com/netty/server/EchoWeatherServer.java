package com.netty.server;
import com.common.netcode.CommandDataDecoder;
import com.common.netcode.CommandDataEncoder;
import com.common.netcode.HeartCommandDecoder;
import com.common.util.ArrayUtil;
import com.common.util.ThreadPoolHelper;
import com.netty.dto.ChannelWarp;
import com.netty.dto.HeartCommand;
import com.netty.group.ChannelMacUtil;
import com.netty.hander.BindWeatherHander;
import com.netty.hander.Context;
import com.netty.hander.EchoWeatherHander;
import com.netty.hander.HearBeatWeatherServerHander;
import com.netty.process.WeatherProcess;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.util.concurrent.*;
@Data
@Component
public class EchoWeatherServer{

    private EchoWeatherServer applicationContext;

    @Value("${tcp.port}")
    private int port;

    @PostConstruct
    public void start(){
        ThreadPoolHelper.commandExecutor().execute(
        new Runnable() {
            @Override
            public void run() {
                EventLoopGroup masterGroup=new NioEventLoopGroup();
                EventLoopGroup slaveGroup=new NioEventLoopGroup();
                HearBeatWeatherServerHander hearBeatHander=new HearBeatWeatherServerHander();

                BindWeatherHander bindWeatherHander=new BindWeatherHander(applicationContext,arrayUtil,channelWarp);

                EchoWeatherHander serverHander=new EchoWeatherHander(applicationContext,context,channelMacUtil,weatherProcess,arrayUtil);
                try {
                    ServerBootstrap bootstrap=new ServerBootstrap();
                    bootstrap.group(masterGroup,slaveGroup)
                            .channel(NioServerSocketChannel.class)
                            .localAddress(new InetSocketAddress(port))
                            .option(ChannelOption.SO_BACKLOG,1024)
                            .childOption(ChannelOption.SO_KEEPALIVE,true)
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    socketChannel.pipeline().addLast(new HeartCommandDecoder(heartCommand));
                                    socketChannel.pipeline().addLast(new CommandDataDecoder());
                                    socketChannel.pipeline().addLast(new CommandDataEncoder());
                                    socketChannel.pipeline().addLast(bindWeatherHander);
                                    socketChannel.pipeline().addLast(serverHander);
                                    socketChannel.pipeline().addLast(new IdleStateHandler(10,10,
                                            12, TimeUnit.SECONDS));

                                }
                            });
                    ChannelFuture channelFuture = bootstrap.bind().sync();
                    System.out.println(EchoWeatherServer.class);
                    channelFuture.channel().closeFuture().sync();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.err.print("服务器出现异常");
                } finally {
                    try {
                        masterGroup.shutdownGracefully().sync();
                        slaveGroup.shutdownGracefully().sync();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    private ChannelMacUtil channelMacUtil;

    private WeatherProcess weatherProcess;

    private ArrayUtil arrayUtil;

    private Context context;

    private ChannelWarp channelWarp;

    private HeartCommand heartCommand;

    public EchoWeatherServer(Context context, ChannelMacUtil channelMacUtil, WeatherProcess weatherProcess, ArrayUtil arrayUtil,ChannelWarp channelWarp,HeartCommand heartCommand){
        applicationContext=this;
        this.context=context;
        this.channelMacUtil=channelMacUtil;
        this.weatherProcess=weatherProcess;
        this.arrayUtil=arrayUtil;
        this.channelWarp=channelWarp;
        this.heartCommand=heartCommand;
    }

}
