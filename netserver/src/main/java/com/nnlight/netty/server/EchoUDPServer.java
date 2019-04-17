package com.nnlight.netty.server;


import com.nnlight.netty.codec.PackageInfoDecoder;
import com.nnlight.netty.codec.PackageInfoEncode;
import com.nnlight.netty.handler.EchoUDPServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

import java.net.InetSocketAddress;

public class EchoUDPServer {
    private final EventLoopGroup group;
    private final Bootstrap bootstrap;

    public EchoUDPServer(InetSocketAddress address) {
        group = new NioEventLoopGroup(10);
        bootstrap = new Bootstrap();

        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new PackageInfoDecoder());
                        pipeline.addLast(new EchoUDPServerHandler());
                        pipeline.addLast(new PackageInfoEncode());
                    }
                })
                .localAddress(address);
    }

    public Channel bind() {
        return bootstrap.bind().syncUninterruptibly().channel();
    }

    public void stop() {
        group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: LogEventMonitor <port>");
        }

        EchoUDPServer echoUDPServer = new EchoUDPServer(new InetSocketAddress(Integer.parseInt(args[0])));
        try {
            Channel channel = echoUDPServer.bind();
            channel.closeFuture().sync();
        } finally {
            echoUDPServer.stop();
        }
    }
}
