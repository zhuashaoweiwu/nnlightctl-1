package com.nnlight.netcodec;

import com.nnlightctl.net.CommandData;
import com.nnlightctl.util.ByteConvert;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CommandDataEncoder extends MessageToByteEncoder<CommandData> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, CommandData commandData, ByteBuf byteBuf) {
        try {
            byte[] data = new byte[(35 + ByteConvert.byteToUbyte(commandData.getDataLength())) + (commandData.getAddr()[commandData.getAddr().length - 1] == 02 ? 2 : 0)];
            int k = 0;
            //帧起始符
            data[k++] = commandData.getStart0();
            //地址域
            System.arraycopy(commandData.getAddr(), 0, data, k, commandData.getAddr().length);
            k += commandData.getAddr().length;
            //帧起始符
            data[k++] = commandData.getStart1();
            //IMEI

            if(commandData.getAddr()[commandData.getAddr().length - 1] == 02) {
                data[k++] = commandData.getLogicalArea();
                data[k++] = commandData.getPhysicsArea();
            }
            System.arraycopy(commandData.getImei(), 0, data, k, 17);
            k += 17;
            //控制码
            data[k++] = commandData.getControl();
            //数据域长度
            data[k++] = commandData.getDataLength();
            //数据域
            System.arraycopy(commandData.getData(), 0, data, k, commandData.getData().length);
            k += commandData.getData().length;
            //校验码
            data[k++] = commandData.getCheck();
            //帧结束符
            data[k++] = commandData.getEnd0();
            //帧识别码
            System.arraycopy(commandData.getEnd1(), 0, data, k, commandData.getEnd1().length);

            byteBuf.writeBytes(data);
        } catch (Exception e) {
            System.err.println("------------------------CommandData 编码错误---------------------");
            e.printStackTrace();
        }
    }
}
