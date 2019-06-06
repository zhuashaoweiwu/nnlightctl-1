package com.common.netcode;

import com.netty.dto.CommandData;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 解码
 * @author
 */
public class CommandDataDecoder extends ByteToMessageDecoder {

    private static final Logger logger= LoggerFactory.getLogger(CommandDataDecoder.class);

    private final int NUMBER=9;


    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf==null||byteBuf.readableBytes()<1){
            return;
        }
        int bytes = byteBuf.readableBytes();
        byte[] data=new byte[bytes];
        byteBuf.readBytes(data);
        CommandData commandData=new CommandData();

        try {
                if (bytes<NUMBER){
                    System.err.print("消息"+ ByteBufUtil.hexDump(data));
                    //地址码
                    commandData.setAddr(data[0]);

                    //功能码
                    commandData.setFunction(data[1]);

                    //有效字节数
                    byte validBytes = data[2];

                    //获取数据长度
                    int iLength = validBytes & 0x000000ff;

                    //数据内容
                    byte[] dataContext=new byte[iLength];
                    try {
                        System.arraycopy(data,3,dataContext,0,iLength);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //commandData.setData(dataContext);
                    byte[] code=new byte[2];
                    System.arraycopy(data,3+iLength,code,0,2);
                    commandData.setCRCCode(code);

                }
                list.add(commandData);

        } catch (Exception e) {

        }
    }


}
