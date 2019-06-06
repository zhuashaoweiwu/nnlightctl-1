package com.netty.hander;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;


/**
 * 服务器端检查客户端的是否存活
 */

@ChannelHandler.Sharable
public class HearBeatWeatherServerHander extends ChannelInboundHandlerAdapter {

    private static final ByteBuf HEARTBEAT_SEQUENCE= Unpooled
            .unreleasableBuffer(Unpooled.copiedBuffer("", CharsetUtil.UTF_8));


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent stateEvent = (IdleStateEvent) evt;
            String type = "";
            if (stateEvent.state() == IdleState.READER_IDLE) {
                type = "read idle";
            } else if (stateEvent.state() == IdleState.WRITER_IDLE) {
                type = "write idle";
            } else if (stateEvent.state() == IdleState.ALL_IDLE) {
                type = "all idle";
            }

            ctx.writeAndFlush(HEARTBEAT_SEQUENCE.duplicate()).addListener(
                    ChannelFutureListener.CLOSE_ON_FAILURE);

        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println(ctx.channel().remoteAddress() + " 客户端断开！");
    }


}
