package com.nnlightctl.command.client.analyze.impl;

import com.nnlight.common.Arithmetic;
import com.nnlight.common.ByteConvert;
import com.nnlightctl.command.client.Context;
import com.nnlightctl.command.client.analyze.CommandAnalyzer;
import com.nnlightctl.net.CommandData;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class E0CommandAnalyze implements CommandAnalyzer {
    @Override
    public String analyze(CommandData command) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("收到E0指令，[");

        byte[] data = command.getData();

        //uuid
        stringBuilder.append("UUID：");
        byte[] uuidBytes = new byte[64];
        System.arraycopy(data, 0, uuidBytes, 0, 64);
        stringBuilder.append(new String(uuidBytes, Charset.forName("UTF-8")));
        stringBuilder.append(",");

        //温度
        stringBuilder.append("温度：");
        short temperature = (short) ByteConvert.bytesToUshort(data, 64);
        stringBuilder.append(Arithmetic.divide(temperature, "10"));
        stringBuilder.append(",");

        //湿度
        stringBuilder.append("湿度：");
        short dampness = (short) ByteConvert.bytesToUshort(data, 66);
        stringBuilder.append(Arithmetic.divide(dampness, "10"));
        stringBuilder.append(",");

        //光照
        stringBuilder.append("光照：");
        short beam = (short) ByteConvert.bytesToUshort(data, 68);
        stringBuilder.append(String.valueOf(beam));
        stringBuilder.append(",");

        //电流
        stringBuilder.append("电流：");
        short unsignedEletric = (short)ByteConvert.bytesToUshort(data, 70);
        stringBuilder.append(String.valueOf(unsignedEletric));
        stringBuilder.append(",");

        //电压
        stringBuilder.append("电压：");
        short unsignedVoltage = (short)ByteConvert.bytesToUshort(data, 72);
        stringBuilder.append(String.valueOf(unsignedVoltage));
        stringBuilder.append(",");

        //信号强度
        stringBuilder.append("信号强度：");
        short unSignalIntensity = (short)ByteConvert.bytesToUbyte(data, 74);
        stringBuilder.append("-" + String.valueOf(unSignalIntensity));
        stringBuilder.append(",");

        //时间
        stringBuilder.append("时间：");
        short unHour = (short)ByteConvert.bytesToUbyte(data, 75);
        short unMinute = (short)ByteConvert.bytesToUbyte(data, 76);
        short unSecond = (short)ByteConvert.bytesToUbyte(data, 77);
        stringBuilder.append(String.valueOf(unHour) + "-" + String.valueOf(unMinute) + "-" + String.valueOf(unSecond));
        stringBuilder.append(",");

        //GPS
        stringBuilder.append("GPS：");
        int gpsByteLength = data.length - 1 - 77;
        byte[] gpsByte = new byte[gpsByteLength];
        System.arraycopy(data, 78, gpsByte, 0, gpsByteLength);
        String gpsStr = new String(gpsByte, Charset.forName("UTF-8"));
        stringBuilder.append(gpsStr);

        stringBuilder.append("]");

        //向终端回复ack指令
        Context.getGlobalContext().commandReplyTerminal((byte)0xe0, true);

        return stringBuilder.toString();

    }
}
