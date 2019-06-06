package com.common.netcode;

import com.netty.dto.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandDataEncoder extends MessageToByteEncoder<CommandData> {
    private static final Logger logger= LoggerFactory.getLogger(CommandDataEncoder.class);
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CommandData commandData, ByteBuf byteBuf) throws Exception {
        try {
            byte[] data=new byte[8];
            int index=0;
            //地址码
            data[index++]=commandData.getAddr();
            //功能码
            data[index++]=commandData.getFunction();
            //寄存器的起始地址
            System.arraycopy(commandData.getStartAddr(),0,data,index,commandData.getStartAddr().length);
            index+=commandData.getStartAddr().length;

            //寄存器的长度
            System.arraycopy(commandData.getLength(),0,data,index,commandData.getLength().length);

            //生成效验位
            index+=commandData.getLength().length;
            System.arraycopy(commandData.getCRCCode(),0,data,index,commandData.getCRCCode().length);

            System.err.println(ByteBufUtil.hexDump(data));

            byteBuf.writeBytes(data);


        } catch (Exception e) {
            /********************************************编码错误******************/


        }


    }
}
