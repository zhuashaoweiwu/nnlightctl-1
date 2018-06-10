package com.nnlightctl.command.client;

import com.nnlight.netcodec.CodeBaseFrameDecoder;
import com.nnlight.netcodec.CommandDataDecoder;
import com.nnlight.netcodec.CommandDataEncoder;
import com.nnlightctl.command.client.handler.EchoClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoClient {
    private final String host;
    private final int port;
    private Context context;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public EchoClient(String host, int port, Context context) {
        this.host = host;
        this.port = port;
        this.context = context;
    }

    public void start() throws Exception {
        EventLoopGroup group = new NioEventLoopGroup(1);
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(CodeBaseFrameDecoder.getCodeBaseFrameDecoder(CodeBaseFrameDecoder.DELIMITER));
                            socketChannel.pipeline().addLast(new CommandDataDecoder());
                            socketChannel.pipeline().addLast(new CommandDataEncoder());
                            socketChannel.pipeline().addLast(new EchoClientHandler(context));
                        }
                    });
            ChannelFuture future = b.connect().sync();
            future.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage:" + EchoClient.class.getSimpleName() + " <host><port>");
        }

        final String host = args[0];
        final int port = Integer.parseInt(args[1]);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; ++i) {
            executorService.execute(() -> {
                try {
                    new EchoClient(host, port).start();
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
            });
        }
    }
}
