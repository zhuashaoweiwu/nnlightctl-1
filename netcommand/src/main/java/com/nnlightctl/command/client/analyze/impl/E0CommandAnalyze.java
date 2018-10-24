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

        int k = 0;

        //uuid
        stringBuilder.append("UUID：");
        byte[] uuidBytes = new byte[36];
        System.arraycopy(data, k, uuidBytes, 0, 36);
        stringBuilder.append(new String(uuidBytes, Charset.forName("UTF-8")));
        stringBuilder.append(",");

        k += 36;

        //温度
//        stringBuilder.append("温度：");
//        short temperature = (short) ByteConvert.bytesToUshort(data, 36);
//        stringBuilder.append(Arithmetic.divide(temperature, "10"));
//        stringBuilder.append(",");

        //湿度
//        stringBuilder.append("湿度：");
//        short dampness = (short) ByteConvert.bytesToUshort(data, 38);
//        stringBuilder.append(Arithmetic.divide(dampness, "10"));
//        stringBuilder.append(",");

        //光照
//        stringBuilder.append("光照：");
//        short beam = (short) ByteConvert.bytesToUshort(data, 40);
//        stringBuilder.append(String.valueOf(beam));
//        stringBuilder.append(",");

        //电流
        stringBuilder.append("电流：");
        short unsignedEletric = (short)ByteConvert.bytesToUshort(data, k);
        stringBuilder.append(String.valueOf(unsignedEletric));
        stringBuilder.append(",");

        k += 2;

        //电压
        stringBuilder.append("电压：");
        short unsignedVoltage = (short)ByteConvert.bytesToUshort(data, k);
        stringBuilder.append(String.valueOf(unsignedVoltage));
        stringBuilder.append(",");

        k += 2;

        //信号强度
        stringBuilder.append("信号强度：");
        short unSignalIntensity = (short)ByteConvert.bytesToUbyte(data, k);
        stringBuilder.append("-" + String.valueOf(unSignalIntensity));
        stringBuilder.append(",");

        k += 1;

        //时间
        stringBuilder.append("时间：");
        short unHour = (short)ByteConvert.bytesToUbyte(data, k++);
        short unMinute = (short)ByteConvert.bytesToUbyte(data, k++);
        short unSecond = (short)ByteConvert.bytesToUbyte(data, k++);
        stringBuilder.append(String.valueOf(unHour) + "-" + String.valueOf(unMinute) + "-" + String.valueOf(unSecond));
        stringBuilder.append(",");

        //GPS
        stringBuilder.append("GPS：");
        int gpsByteLength = data.length - k;
        byte[] gpsByte = new byte[gpsByteLength];
        System.arraycopy(data, k, gpsByte, 0, gpsByteLength);
        String gpsStr = new String(gpsByte, Charset.forName("UTF-8"));
        stringBuilder.append(gpsStr);

        stringBuilder.append("]");

        //向终端回复ack指令
        Context.getGlobalContext().commandReplyTerminal((byte)0xe0, true);

        return stringBuilder.toString();

    }
}
