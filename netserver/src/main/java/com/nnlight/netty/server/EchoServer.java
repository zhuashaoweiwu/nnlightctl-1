package com.nnlight.netty.server;

import com.nnlight.netcodec.CodeBaseFrameDecoder;
import com.nnlight.netcodec.CommandDataDecoder;
import com.nnlight.netcodec.CommandDataEncoder;
import com.nnlight.netcodec.ModbusBytesToMessageCodec;
import com.nnlight.netty.handler.EchoServerHandler;
import com.nnlight.netty.handler.HeartbeatServerHandler;
import com.nnlight.netty.server.po.ChannelWrap;
import com.nnlightctl.kafka.produce.Produce;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.util.BytesHexStrTranslate;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class EchoServer {
    private final int port;

    private Map<String, ChannelWrap> clientChannelMap;
    private Map<String, ChannelWrap> commandMap;

    private static EchoServer globalApplicationContext;

//    private final Produce produce = new Produce();

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

    public    Map<String, ChannelWrap> getClientChannelMap() {
        return clientChannelMap;
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
            CommandData commandData = new CommandData((byte)percent, BytesHexStrTranslate.toBytes(entry.getValue().getImei()));
            context.writeAndFlush(commandData);
        }
    }

    /**
     * 发送单灯调光指令
     * @param channelId
     * @param percent
     */
    public void sendCommandLightAdjust(String channelId, int percent) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            String shortChanelId = entry.getValue().getChannel().id().asShortText();
            if (channelId.equalsIgnoreCase(shortChanelId)) {
                CommandData c =new CommandData((byte)percent, entry.getValue().getImei().getBytes());
//                serializeToString(c);
                entry.getValue().getContext().writeAndFlush(c);
                break;
            }
        }
    }


    public static String serializeToString( CommandData c) {
        String s = new String();
        s += c.getStart0() + "";
        for (int i = 0;i < c.getAddr().length; i ++) {
            s+= c.getAddr()[i];
        }
        s +=c.getStart1();
        for (int i = 0;i < c.getImei().length; i ++) {
            s+= c.getImei()[i];
        }
        s+= c.getControl();
        s +=c.getDataLength();
        for (int i = 0;i < c.getData().length; i ++) {
            s+= c.getData()[i];
        }
        s += c.getCheck();
        s += c.getEnd0();
        for (int i = 0;i < c.getEnd1().length; i ++) {
            s+= c.getEnd1()[i];
        }
//        s += c.getLogicalArea();
//        s += c.getPhysicsArea();
        System.out.println(s);
        return s;
    }

    /**
     * 发送单个终端更改电源方式命令
     * @param realtimeUUID
     * @param powerType
     */
    public void sendTerminalPowerType(String realtimeUUID, byte powerType) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(realtimeUUID)) {
                entry.getValue().getContext().writeAndFlush(CommandData.getChangePowerTypeCommandData(powerType,entry.getValue().getImei().getBytes()));
                break;
            }
        }
    }

    /**
     * 发送全部终端重启/复位指令
     */
    public void allSendCommandReset() {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getTerminalResetCommand(entry.getValue().getImei().getBytes(),(byte) 0xe4));
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
     * 发送全部终端控制配电柜通电/断电
     * @param eleboxOn
     */
    public void allSendCommandTerminalEleboxOn(Boolean eleboxOn) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getCommandTerminalEleboxOn(eleboxOn));
        }
    }

    /**
     * 发送全部终端重置任务开关策略
     * @param c7Command
     */
    public void allConfigTerminalSwitchPolicy(CommandData c7Command) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getConfigTerminalSwitchPolicy(c7Command,entry.getValue().getImei().getBytes()));
        }
    }

    /**
     * 发送特定终端重置任务开关策略
     * @param c7Command
     */
    public void configTerminalSwitchPolicy(CommandData c7Command) {
        String realtimeUUID = c7Command.getRealtimeUUIDFromData();
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(realtimeUUID)) {
                ChannelHandlerContext context = entry.getValue().getContext();
                context.writeAndFlush(CommandData.getConfigTerminalSwitchPolicy(c7Command,entry.getValue().getImei().getBytes()));
                break;
            }
        }
    }

    /**
     * 发送全部终端读取终端信息
     */
    public void allSendCommandReadTerminalInfo() {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getCommandReadTerminalInfo());
        }
    }

    /**
     * 发送特定终端的终端工作模式
     * @param realtimeUUID
     * @param model
     */
    public void sendCommandTerminalAutoModel(String realtimeUUID, byte model) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(realtimeUUID)) {
                ChannelHandlerContext context = entry.getValue().getContext();
                context.writeAndFlush(CommandData.getCommandConfigTerminalModel(model,entry.getValue().getImei().getBytes()));
                break;
            }
        }
    }

    /**
     * 发送全部终端设置终端的工作模式
     * @param model
     */
    public void allSendCommandTerminalAutoModel(byte model) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getCommandConfigTerminalModel(model,entry.getValue().getImei().getBytes()));
        }
    }

    /**
     * 发送全部终端ack回应信息
     * @param control
     * @param success
     */
    public void allSendTerminalACK(byte control, Boolean success) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();

            context.writeAndFlush(CommandData.getACKCommandData(control, success));
        }
    }

    /**
     * 发送特定终端ack回应信息
     * @param control
     * @param success
     * @param realtimeUUID
     */
    public void sendTerminalACK(byte control, Boolean success, String realtimeUUID) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            String name = entry.getKey();
            if (name.equalsIgnoreCase(realtimeUUID)) {
                ChannelHandlerContext context = entry.getValue().getContext();
                context.writeAndFlush(CommandData.getACKCommandData(control, success));
            }
        }
    }

    /**
     * 发送全部命令客户端消息
     * @param commandData
     */
    public void allClientSendCommand(CommandData commandData) {
        for (Map.Entry<String, ChannelWrap> entry : commandMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            context.channel().writeAndFlush(commandData);
        }
    }

    /**
     * 将E0消息发送到Kafka
     * @param e0CommandData
     */
    public void sendE02Kafka(CommandData e0CommandData) {
//        produce.send(e0CommandData);
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
                EventLoopGroup group = new NioEventLoopGroup();
                EventLoopGroup workGroup = new NioEventLoopGroup();
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
                                    socketChannel.pipeline().addLast(new ModbusBytesToMessageCodec());
                                    socketChannel.pipeline().addLast(CodeBaseFrameDecoder.getCodeBaseFrameDecoder(CodeBaseFrameDecoder.DELIMITER));
                                    socketChannel.pipeline().addLast(new CommandDataDecoder());
                                    socketChannel.pipeline().addLast(new CommandDataEncoder());
                                    socketChannel.pipeline().addLast(serverHandler);
                                    socketChannel.pipeline().addLast(new IdleStateHandler(25,
                                            15, 25, TimeUnit.MINUTES));
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
    /**
     * 服务器获取固定信息0xA0
     */
    public void batchCommandReadserviceFixedInfo(String realtime_id) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = CommandData.getA0CommandData(realtime_id);
            context.writeAndFlush(commandData);
        }
    }

    public void commandGetModelState(String gatewayRealtimeUUID, byte[] modelUUIDBytes) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(gatewayRealtimeUUID)) {
                ChannelHandlerContext context = entry.getValue().getContext();
                CommandData commandData = CommandData.commandGetModelStateByGateway(modelUUIDBytes);
                context.writeAndFlush(commandData);
                break;
            }
        }
    }


    private  void  test(CommandData commandData) {
        System.out.print( BytesHexStrTranslate.bytesToHexFun(commandData.getStart0()) );
        for (int i = 0 ; i < commandData.getAddr().length; i ++ ) {
            System.out.print(commandData.getAddr()[i]);
        }
        System.out.print(BytesHexStrTranslate.bytesToHexFun(commandData.getStart1()));

        System.out.print(BytesHexStrTranslate.bytesToHexFun(commandData.getLogicalArea()));
        System.out.print(BytesHexStrTranslate.bytesToHexFun(commandData.getPhysicsArea()));

        for (int i = 0 ; i < commandData.getImei().length; i ++ ) {
            System.out.print(commandData.getImei()[i]);
        }

        System.out.print(BytesHexStrTranslate.bytesToHexFun(commandData.getControl()));
        System.out.print(commandData.getDataLength());

        for (int i = 0 ; i < commandData.getData().length; i ++ ) {
            System.out.print(commandData.getData()[i]);
        }

        System.out.print(BytesHexStrTranslate.bytesToHexFun(commandData.getCheck()));
        System.out.print(BytesHexStrTranslate.bytesToHexFun(commandData.getEnd0()));

        for (int i = 0 ; i < commandData.getEnd1().length; i ++) {
            System.out.print(BytesHexStrTranslate.bytesToHexFun(commandData.getEnd1()[i]));
        }
    }

    /**
     * 控制继电器开闭状态0xA1
     */
    public void batchConfigOpenClose(String realtime_id) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = CommandData.getA1CommandData(realtime_id);
            context.writeAndFlush(commandData);
        }
    }

    /**
     * 设置模块继电器状态
     * @param gatewayRealtimeUUID
     * @param modelUUID
     * @param modelLoop
     * @param modelLoopState
     */
    public void configModelState(String gatewayRealtimeUUID, byte[] modelUUID, short modelLoop, short modelLoopState) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(gatewayRealtimeUUID)) {
                entry.getValue().getContext().writeAndFlush(CommandData.commandConfigModelStateByGateway(modelUUID, modelLoop, modelLoopState));
                break;
            }
        }
    }

    /**
     * 重启/复位0xA2
     */
    public void batchConfigRestart(String realtime_id) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = CommandData.getA2CommandData(realtime_id);
            context.writeAndFlush(commandData);
        }
    }
    /*
    * 设置定时发送参数 0xA3
    * */
    public void batchCommandReadTimeParamter(String realtime_id){
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = CommandData.getA3CommandData(realtime_id,entry.getValue().getImei().getBytes());
            context.writeAndFlush(commandData);
        }
    }
    /*
     *  读取/发送信息 0xA4
     * */
    public void batchCommandReadSending(String realtime_id){
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = CommandData.getA4CommandData(realtime_id);
            context.writeAndFlush(commandData);
        }
    }
    /*
    * 广播对时D5
    * */
    public void batchConfigSetTime(byte[] time){
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            context.writeAndFlush(CommandData.getConfigSetTimeCommand(time,entry.getValue().getImei().getBytes()));
        }
    }
    /*
    *设置亮/灭灯定时策略 0xA6
    */
    public void batchConfigOpenCloseStrategy(String realtime_id){
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = CommandData.getA6CommandData(realtime_id);
            context.writeAndFlush(commandData);
        }
    }
    /*
     * 设置终端设备的工作模式（手动or自动）A7
     */
    public void batchConfigWorkModel(String realtime_id){
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            ChannelHandlerContext context = entry.getValue().getContext();
            CommandData commandData = CommandData.getA7CommandData(realtime_id);
            context.writeAndFlush(commandData);
        }
    }

    /**
     * 升级固件指令E3
     * @param realtime_id
     * @param version
     * @param packageNumber
     * @param lastPackageSize
     */
    public void updateFireware(String realtime_id, short version, short packageNumber, byte lastPackageSize) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(realtime_id)) {
                entry.getValue().getContext().writeAndFlush(CommandData.getUpdateFirewareCommand(version, packageNumber, lastPackageSize));
                break;
            }
        }
    }

    /**
     * 重启/复位 D2 指令
     * @param realtime_id
     */
    public void restart(String realtime_id) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(realtime_id)) {
                entry.getValue().getContext().writeAndFlush(CommandData.getTerminalResetCommand(entry.getValue().getImei().getBytes(),(byte)0xd2));
                break;
            }
        }
    }


    /**
     * 发送指令到modbus电表的透传
     * @param gateWayRealtimeUUID
     * @param directiveBytes
     */
    public void invokeModbusByGateway(String gateWayRealtimeUUID, byte[] directiveBytes) {
        for (Map.Entry<String, ChannelWrap> entry : clientChannelMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(gateWayRealtimeUUID)) {
                entry.getValue().getContext().writeAndFlush(CommandData.getInvokeModbusEMDirectiveCommandData(directiveBytes));
                break;
            }
        }
    }

}
