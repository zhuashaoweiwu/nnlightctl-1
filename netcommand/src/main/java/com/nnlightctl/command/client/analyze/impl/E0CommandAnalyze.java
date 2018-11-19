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

        //版本判断
        byte version = command.getAddr()[4];
        if (version == 1) {
            //输入电流
            stringBuilder.append("输入电流：");
            int unsignedEletricIn = ByteConvert.bytesToUshort(data, k);
            stringBuilder.append(String.valueOf(unsignedEletricIn));
            stringBuilder.append(",");

            k += 2;

            //输入电压
            stringBuilder.append("输入电压：");
            int unsignedVoltageIn = ByteConvert.bytesToUshort(data, k);
            stringBuilder.append(String.valueOf(unsignedVoltageIn));
            stringBuilder.append(",");

            k += 2;

            //电网频率
            stringBuilder.append("电网频率：");
            int unsignedEleFrequency = ByteConvert.bytesToUshort(data, k);
            stringBuilder.append(String.valueOf(unsignedEleFrequency));
            stringBuilder.append(",");

            k += 2;

            //输入有功功率
            stringBuilder.append("输入有功功率：");
            short unsignedActivePowerIn = ByteConvert.bytesToShort(data, k);
            stringBuilder.append(String.valueOf(unsignedActivePowerIn));
            stringBuilder.append(",");

            k += 2;

            //输入无功功率
            stringBuilder.append("输入无功功率：");
            short unsignedReactivePowerIn = ByteConvert.bytesToShort(data, k);
            stringBuilder.append(String.valueOf(unsignedReactivePowerIn));
            stringBuilder.append(",");

            k += 2;

            //输入视在功率
            stringBuilder.append("输入视在功率：");
            int unsignedSeenPowerIn = ByteConvert.bytesToUshort(data, k);
            stringBuilder.append(String.valueOf(unsignedSeenPowerIn));
            stringBuilder.append(",");

            k += 2;

            //输入有功电能
            stringBuilder.append("输入有功电能：");
            byte[] activeEnergyInBytes = new byte[4];
            System.arraycopy(data, k, activeEnergyInBytes, 1, 3);
            activeEnergyInBytes[0] = 0x00;
            int unsignedActiveEnergyIn = ByteConvert.bytesToInt(activeEnergyInBytes);
            stringBuilder.append(String.valueOf(unsignedActiveEnergyIn));
            stringBuilder.append(",");

            k += 3;

            //输入无功电能
            stringBuilder.append("输入无功电能：");
            byte[] reactiveEnergyInBytes = new byte[4];
            System.arraycopy(data, k, reactiveEnergyInBytes, 1, 3);
            reactiveEnergyInBytes[0] = 0x00;
            int unsignedReactiveEnergyIn = ByteConvert.bytesToInt(reactiveEnergyInBytes);
            stringBuilder.append(String.valueOf(unsignedReactiveEnergyIn));
            stringBuilder.append(",");

            k += 3;

            //输入视在电能
            stringBuilder.append("输入视在电能：");
            byte[] seenEnergyInBytes = new byte[4];
            System.arraycopy(data, k, seenEnergyInBytes, 1, 3);
            seenEnergyInBytes[0] = 0x00;
            int unsignedSeenEnergyIn = ByteConvert.bytesToInt(seenEnergyInBytes);
            stringBuilder.append(String.valueOf(unsignedSeenEnergyIn));
            stringBuilder.append(",");

            k += 3;
        }

        //输出电流
        stringBuilder.append("输出电流：");
        short unsignedEletric = (short)ByteConvert.bytesToUshort(data, k);
        stringBuilder.append(String.valueOf(unsignedEletric));
        stringBuilder.append(",");

        k += 2;

        //输出电压
        stringBuilder.append("输出电压：");
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
//        Context.getGlobalContext().commandReplyTerminal((byte)0xe0, true);

        return stringBuilder.toString();

    }
}
