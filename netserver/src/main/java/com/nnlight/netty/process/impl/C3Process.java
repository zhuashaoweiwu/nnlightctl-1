package com.nnlight.netty.process.impl;

import com.nnlight.netty.process.Process;
import com.nnlight.netty.server.EchoServer;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.util.ByteConvert;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class C3Process implements Process {
    private static final Logger log = LoggerFactory.getLogger(C3Process.class);

    @Override
    public void process(ChannelHandlerContext netServerContext, CommandData msg) {
        log.info("发送终端升级固件指令E3");

        int k = 0;
        String realtimeUUID = msg.getRealtimeUUIDFromData();
        k += 4;

        byte[] data = msg.getData();

        short version = ByteConvert.bytesToShort(data, k);
        k += 2;

        short packageNumber = ByteConvert.bytesToShort(data, k);
        k += 2;

        byte lastPackageSize = data[k++];

        EchoServer.getGlobalApplicationContext().updateFireware(realtimeUUID, version, packageNumber, lastPackageSize);
    }
}
