package com.nnlightctl.kafka.util;

import com.nnlight.common.Arithmetic;
import com.nnlight.common.ByteConvert;
import com.nnlight.common.DateTimeUtil;
import com.nnlight.common.LightTermianlSignalLevelUtil;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.po.LightSignalLog;
import com.nnlightctl.po.LightingVolEleRecord;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Date;

public class DataTransferUtil {
    public static LightingVolEleRecord transToLightingVolEleRecord(CommandData e0CommandData) {
        LightingVolEleRecord lightingVolEleRecord = new LightingVolEleRecord();

        byte[] data = e0CommandData.getData();

        int k = 0;

        //uuid
        byte[] uuidBytes = new byte[36];
        System.arraycopy(data, k, uuidBytes, 0, 36);
        String uuid = new String(uuidBytes, Charset.forName("UTF-8"));
        lightingVolEleRecord.setUid(uuid);

        k += 36;

        //判断版本
        byte version = e0CommandData.getAddr()[4];
        if (version == 1) {
            //输入电流
            int unsignedEletricIn = ByteConvert.bytesToUshort(data, k);
            lightingVolEleRecord.setInElectricity(String.valueOf(unsignedEletricIn));
            k += 2;

            //输入电压
            int unsignedVoltageIn = ByteConvert.bytesToUshort(data, k);
            lightingVolEleRecord.setInVoltage(String.valueOf(unsignedVoltageIn));
            k += 2;

            //电网频率
            int unsignedEleFrequency = ByteConvert.bytesToUshort(data, k);
            lightingVolEleRecord.setElecFrequency(String.valueOf(unsignedEleFrequency));
            k += 2;

            //输入有功功率
            int unsignedActivePowerIn = ByteConvert.bytesToUshort(data, k);
            lightingVolEleRecord.setInActivePower(String.valueOf(unsignedActivePowerIn));
            k += 2;

            //输入无功功率
            int unsignedReactivePowerIn = ByteConvert.bytesToUshort(data, k);
            lightingVolEleRecord.setInReactivePower(String.valueOf(unsignedReactivePowerIn));
            k += 2;

            //输入视在功率
            int unsignedSeenPowerIn = ByteConvert.bytesToUshort(data, k);
            lightingVolEleRecord.setInSeenPower(String.valueOf(unsignedSeenPowerIn));
            k += 2;

            //输入有功电能
            byte[] activeEnergyInBytes = new byte[4];
            System.arraycopy(data, k, activeEnergyInBytes, 1, 3);
            activeEnergyInBytes[0] = 0x00;
            int unsignedActiveEnergyIn = ByteConvert.bytesToInt(activeEnergyInBytes);
            lightingVolEleRecord.setInActiveEnergy(String.valueOf(unsignedActiveEnergyIn));
            k += 3;

            //输入无功电能
            byte[] reactiveEnergyInBytes = new byte[4];
            System.arraycopy(data, k, reactiveEnergyInBytes, 1, 3);
            reactiveEnergyInBytes[0] = 0x00;
            int unsignedReactiveEnergyIn = ByteConvert.bytesToInt(reactiveEnergyInBytes);
            lightingVolEleRecord.setInReactiveEnergy(String.valueOf(unsignedReactiveEnergyIn));
            k += 3;

            //输入视在电能
            byte[] seenEnergyInBytes = new byte[4];
            System.arraycopy(data, k, seenEnergyInBytes, 1, 3);
            seenEnergyInBytes[0] = 0x00;
            int unsignedSeenEnergyIn = ByteConvert.bytesToInt(seenEnergyInBytes);
            lightingVolEleRecord.setInSeenEnergy(String.valueOf(unsignedSeenEnergyIn));
            k += 3;
        }

        //输出电流
        int unsignedEletric = ByteConvert.bytesToUshort(data, k) % 1050;
        lightingVolEleRecord.setElectricty(new BigDecimal(String.valueOf(unsignedEletric / 1000)));

        k += 2;

        //输出电压
        int unsignedVoltage = ByteConvert.bytesToUshort(data, k) % 1000;
        lightingVolEleRecord.setVoltage(new BigDecimal(String.valueOf(unsignedVoltage)));

        k += 2;

        //计算能耗
        lightingVolEleRecord.setEnergy(lightingVolEleRecord.getElectricty().multiply(lightingVolEleRecord.getVoltage()));

        //信号强度
        short unSignalIntensity = (short)ByteConvert.bytesToUbyte(data, k);
        lightingVolEleRecord.setSignalIntensity(new BigDecimal(String.valueOf("-" + unSignalIntensity)));

        k += 1;

        //时间
        short unHour = (short)(ByteConvert.bytesToUbyte(data, k++) % 24);
        short unMinute = (short)(ByteConvert.bytesToUbyte(data, k++) % 60);
        short unSecond = (short)(ByteConvert.bytesToUbyte(data, k++) % 60);
        LocalDateTime dateTime = LocalDateTime.now().withHour(unHour).withMinute(unMinute).withSecond(unSecond);
        lightingVolEleRecord.setRecordDatetime(DateTimeUtil.fromLocalDateTime(dateTime));

        //GPS
        int gpsByteLength = data.length - k;
        byte[] gpsByte = new byte[gpsByteLength];
        System.arraycopy(data, k, gpsByte, 0, gpsByteLength);
        String gpsStr = new String(gpsByte, Charset.forName("UTF-8"));
        String strLongititude = gpsStr.substring(0, gpsStr.indexOf("N"));
        lightingVolEleRecord.setLongitude(new BigDecimal(Arithmetic.divide(strLongititude, "100")).toString());
        String strLatitude = gpsStr.substring(gpsStr.indexOf("N") + 1, gpsStr.indexOf("E"));
        lightingVolEleRecord.setLatitude(new BigDecimal(Arithmetic.divide(strLatitude, "100")).toString());

        return lightingVolEleRecord;
    }

    public static LightSignalLog transToLightSignalLog(LightingVolEleRecord lightingVolEleRecord) {
        LightSignalLog lightSignalLog = new LightSignalLog();

        lightSignalLog.setUid(lightingVolEleRecord.getUid());
        lightSignalLog.setGmtCreated(lightingVolEleRecord.getGmtCreated());
        lightSignalLog.setGmtUpdated(lightingVolEleRecord.getGmtUpdated());
        lightSignalLog.setLongitude(lightingVolEleRecord.getLongitude());
        lightSignalLog.setLatitude(lightingVolEleRecord.getLatitude());
        lightSignalLog.setSignalIntensity(lightingVolEleRecord.getSignalIntensity());
        lightSignalLog.setSignalLogDate(new Date());
        lightSignalLog.setUnit("db");
        lightSignalLog.setSignalLevel((byte) LightTermianlSignalLevelUtil.getSignalLevel(lightingVolEleRecord.getSignalIntensity()));

        return lightSignalLog;
    }
}
