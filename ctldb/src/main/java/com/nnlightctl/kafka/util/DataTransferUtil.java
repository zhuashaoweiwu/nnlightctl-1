package com.nnlightctl.kafka.util;

import com.nnlight.common.Arithmetic;
import com.nnlight.common.ByteConvert;
import com.nnlight.common.DateTimeUtil;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.LightingVolEleRecord;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

public class DataTransferUtil {
    public static LightingVolEleRecord transToLightingVolEleRecord(CommandData e0CommandData) {
        LightingVolEleRecord lightingVolEleRecord = new LightingVolEleRecord();


        byte[] data = e0CommandData.getData();

        //uuid
        byte[] uuidBytes = new byte[64];
        System.arraycopy(data, 0, uuidBytes, 0, 64);
        String uuid = new String(uuidBytes, Charset.forName("UTF-8"));
        lightingVolEleRecord.setUid(uuid);

        //温度
        short temperature = (short) ByteConvert.bytesToUshort(data, 64);
        lightingVolEleRecord.setTemperature(new BigDecimal(String.valueOf(Arithmetic.divide(temperature, "10"))));

        //湿度
        short dampness = (short) ByteConvert.bytesToUshort(data, 66);
        lightingVolEleRecord.setDampness(new BigDecimal(String.valueOf(Arithmetic.divide(dampness, "10"))));

        //光照
        short beam = (short) ByteConvert.bytesToUshort(data, 68);
        lightingVolEleRecord.setBeam(new BigDecimal(String.valueOf(beam)));

        //电流
        short unsignedEletric = (short)ByteConvert.bytesToUshort(data, 70);
        lightingVolEleRecord.setElectricty(new BigDecimal(String.valueOf(unsignedEletric)));

        //电压
        short unsignedVoltage = (short)ByteConvert.bytesToUshort(data, 72);
        lightingVolEleRecord.setVoltage(new BigDecimal(String.valueOf(unsignedVoltage)));

        //信号强度
        short unSignalIntensity = (short)ByteConvert.bytesToUbyte(data, 74);
        lightingVolEleRecord.setPersist1(new BigDecimal(String.valueOf(unSignalIntensity)));

        //时间
        short unHour = (short)ByteConvert.bytesToUbyte(data, 75);
        short unMinute = (short)ByteConvert.bytesToUbyte(data, 76);
        short unSecond = (short)ByteConvert.bytesToUbyte(data, 77);
        LocalDateTime dateTime = LocalDateTime.now().withHour(unHour).withMinute(unMinute).withSecond(unSecond);
        lightingVolEleRecord.setRecordDatetime(DateTimeUtil.fromLocalDateTime(dateTime));

        //GPS
        int gpsByteLength = data.length - 1 - 77;
        byte[] gpsByte = new byte[gpsByteLength];
        System.arraycopy(data, 78, gpsByte, 0, gpsByteLength);
        String gpsStr = new String(gpsByte, Charset.forName("UTF-8"));
        String strLongititude = gpsStr.substring(0, gpsStr.indexOf("N"));
        lightingVolEleRecord.setPersist2(new BigDecimal(Arithmetic.divide(strLongititude, "100")));
        String strLatitude = gpsStr.substring(gpsStr.indexOf("N") + 1, gpsStr.indexOf("E"));
        lightingVolEleRecord.setPersist3(new BigDecimal(Arithmetic.divide(strLatitude, "100")));

        return lightingVolEleRecord;
    }
}