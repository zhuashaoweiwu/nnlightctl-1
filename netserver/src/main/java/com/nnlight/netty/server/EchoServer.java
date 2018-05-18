package com.nnlight.netty.server;

import com.nnlight.netty.handler.EchoServerHandler;
import com.nnlight.netty.handler.HeartbeatServerHandler;
import com.nnlight.netty.server.po.ChannelWrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class EchoServer {
    private final int port;

    private Map<String, ChannelWrap> clientChannelMap;

    public EchoServer(int port) {
        this.port = port;
        clientChannelMap = new ConcurrentHashMap<>(10);
    }

    public Map<String, ChannelWrap> getClientChannelMap() {
        return this.clientChannelMap;
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage:" + EchoServer.class.getSimpleName() + " <port>");
        }

        int port = Integer.parseInt(args[0]);

        EchoServer server = new EchoServer(port);

        server.start();


        System.err.println("请输入指令：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String read = null;
        while ((read = bufferedReader.readLine()) != null) {
            switch (read) {
                case "lookall":
                    for (Map.Entry<String, ChannelWrap> entry : server.clientChannelMap.entrySet()) {
                        System.err.println(entry.getValue().getName() + ":" + entry.getValue().getChannel().toString() + ":" +
                            entry.getValue().getContext().toString());
                    }
                    System.err.println("total client count : " + server.clientChannelMap.size());
                    continue;
            }

            if (read.startsWith("send")) {
                String[] params = read.split(" ");
                String name = params[1];
                String msg = params[2];

                for (Map.Entry<String, ChannelWrap> entry : server.clientChannelMap.entrySet()) {
                    if (entry.getValue().getName().equals(name)) {
                        ChannelHandlerContext context = entry.getValue().getContext();
                        msg += "\n\r";
                        ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.getBytes());
                        context.write(byteBuf);
                        context.writeAndFlush(Unpooled.EMPTY_BUFFER);
                    }
                }
            }
        }
    }

    public void start() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final EchoServerHandler serverHandler = new EchoServerHandler(EchoServer.this);
                final HeartbeatServerHandler heartbeatServerHandler = new HeartbeatServerHandler();
                EventLoopGroup group = new NioEventLoopGroup(50);
                EventLoopGroup workGroup = new NioEventLoopGroup(1000);
                try {
                    ServerBootstrap b = new ServerBootstrap();
                    b.group(group, workGroup)
                            .channel(NioServerSocketChannel.class)
                            .localAddress(new InetSocketAddress(port))
                            .option(ChannelOption.SO_BACKLOG, 1024 * 1024)
                            .childOption(ChannelOption.SO_KEEPALIVE, true)
                            .childHandler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel socketChannel) throws Exception {
                                    socketChannel.pipeline().addLast(serverHandler);
                                    socketChannel.pipeline().addLast(new IdleStateHandler(4,
                                            5, 7, TimeUnit.SECONDS));
                                    socketChannel.pipeline().addLast(heartbeatServerHandler);
                                }
                            });

                    ChannelFuture f = b.bind().sync();
                    f.channel().closeFuture().sync();
                    System.out.println("Start Netty Server End!!!");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        group.shutdownGracefully().sync();
                        workGroup.shutdownGracefully().sync();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
