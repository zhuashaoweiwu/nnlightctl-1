package com.nnlight.netty.server;

import com.nnlight.netcodec.CodeBaseFrameDecoder;
import com.nnlight.netcodec.CommandDataDecoder;
import com.nnlight.netcodec.CommandDataEncoder;
import com.nnlight.netty.handler.EchoServerHandler;
import com.nnlight.netty.handler.HeartbeatServerHandler;
import com.nnlight.netty.server.po.ChannelWrap;
import com.nnlightctl.net.CommandData;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
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
    private Map<String, ChannelWrap> commandMap;

    private static EchoServer globalApplicationContext;

    public EchoServer(int port) {
        this.port = port;
        clientChannelMap = new ConcurrentHashMap<>(10);
        this.commandMap = new ConcurrentHashMap<>(5);

        globalApplicationContext = this;
    }

    public static EchoServer getGlobalApplicationContext() {
        if (globalApplicationContext == null) {
            throw new RuntimeException("网络服务器全局上下文为空");
        }
        return globalApplicationContext;
    }

    public Map<String, ChannelWrap> getClientChannelMap() {
        return this.clientChannelMap;
    }

    public Map<String, ChannelWrap> getCommandMap() {
        return this.commandMap;
    }

    public String commandLookAll() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            result.append(entry.getValue().getName() + ":" + entry.getValue().getChannel().toString() + ":" +
                    entry.getValue().getContext().toString() + "\n");
        }
        result.append("total client count : " + clientChannelMap.size());
        return result.toString();
    }

    public void allSendCommandLightAdjust(String name, String msg) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                ChannelHandlerContext context = entry.getValue().getContext();
                msg += "\r\n";
                ByteBuf byteBuf = Unpooled.wrappedBuffer(msg.getBytes());
                context.write(byteBuf);
                context.writeAndFlush(Unpooled.EMPTY_BUFFER);
                break;
            }
        }
    }

    /**
     * 发送全部终端调光指令
     * @param percent
     */
    public void allSendCommandLightAdjust(int percent) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = new CommandData((byte)percent);
            context.writeAndFlush(commandData);
        }
    }

    /**
     * 发送全部终端重启/复位指令
     */
    public void allSendCommandReset() {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getTerminalResetCommand());
        }
    }

    /**
     * 发送全部终端设置定时发送消息时间周期
     * @param period
     */
    public void allSendCommandConfigTerminalSendMsgPeriod(int period) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getConfigTerminalSendMsgPeriod(period));
        }
    }

    /**
     * 发送全部命令客户端消息
     * @param commandData
     */
    public void allClientSendCommand(CommandData commandData) {
        for (Map.Entry<String, ChannelWrap> entry : commandMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            context.writeAndFlush(commandData);
        }
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
                    System.err.println(server.commandLookAll());
                    continue;
            }

            if (read.startsWith("send")) {
                String[] params = read.split(" ");
                String name = params[1];
                String msg = params[2];

                server.allSendCommandLightAdjust(name, msg);
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
                                    socketChannel.pipeline().addLast(CodeBaseFrameDecoder.getCodeBaseFrameDecoder(CodeBaseFrameDecoder.DELIMITER));
                                    socketChannel.pipeline().addLast(new CommandDataDecoder());
                                    socketChannel.pipeline().addLast(new CommandDataEncoder());
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
