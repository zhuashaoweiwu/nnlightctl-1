package com.nnlightctl.kafka.util;

import com.nnlight.common.*;
import com.nnlightctl.net.CommandData;
import com.nnlightctl.net.D0Response;
import com.nnlightctl.net.ModBusResponse;
import com.nnlightctl.po.LightSignalLog;
import com.nnlightctl.po.LightingVolEleRecord;
import com.nnlightctl.util.BytesHexStrTranslate;
import org.springframework.util.StringUtils;

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
//        byte[] uuidBytes = new byte[36];
//        System.arraycopy(data, k, uuidBytes, 0, 36);
//        String uuid = new String(uuidBytes);
        lightingVolEleRecord.setUid(new String(e0CommandData.getImei()));

//        k += 36;

        //imei
//        byte[] imeiBytes = new byte[15];
//        System.arraycopy(data, k, imeiBytes, 0, 15);
//        String imei = new String(imeiBytes);
        lightingVolEleRecord.setLightimei(new String(e0CommandData.getImei()));

//        k += 15;

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
            short unsignedActivePowerIn = ByteConvert.bytesToShort(data, k);
            lightingVolEleRecord.setInActivePower(String.valueOf(unsignedActivePowerIn));
            k += 2;

            //输入无功功率
            short unsignedReactivePowerIn = ByteConvert.bytesToShort(data, k);
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
//        int gpsByteLength = data.length - k;
//        byte[] gpsByte = new byte[gpsByteLength];
//        System.arraycopy(data, k, gpsByte, 0, gpsByteLength);
//        String gpsStr = new String(gpsByte);
//        String strLongititude = gpsStr.substring(gpsStr.indexOf("N") + 1, gpsStr.indexOf("E"));
//        lightingVolEleRecord.setLongitude(DegreeTrans.dufen2du(Arithmetic.divide(strLongititude, "100")));
//        String strLatitude = gpsStr.substring(0, gpsStr.indexOf("N"));
//        lightingVolEleRecord.setLatitude(DegreeTrans.dufen2du(Arithmetic.divide(strLatitude, "100")));

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

    public static D0Response transToD0Response(CommandData d0CommandData) {
        D0Response d0Response = new D0Response();

//        byte[] data = d0CommandData.getData();

        int k = 0;

        //uuid
        d0Response.setUuid(d0CommandData.getImei());
//        k += 36;

        //继电器状态
        System.arraycopy(d0CommandData.getData(), k, d0Response.getModelState(), 0, 2);
        d0Response.setModelState(d0Response.getModelState());
        k += 2;

        //继电器输入电源状态
        System.arraycopy(d0CommandData.getData(), k, d0Response.getModelPowerState(), 0, 2);
        d0Response.setModelPowerState(d0Response.getModelPowerState());
        k += 2;

        //BCD时间
        System.arraycopy(d0CommandData.getData(), k, d0Response.getTime(), 0, 3);

        return d0Response;
    }

    public static ModBusResponse transToModbusResponse(CommandData c12CommandData) {
        byte[] data = c12CommandData.getData();
        ModBusResponse modBusResponse = new ModBusResponse();
        modBusResponse.setOriginalPackageInfoHex(BytesHexStrTranslate.bytesToHexFun(data));

        return modBusResponse;
    }

    public static String transToModbusResponseValue(String modbusResponseHex) {
        if (StringUtils.isEmpty(modbusResponseHex)) {
            return "";
        }

        //截取数据总长度
        int valueLength = ByteConvert.bytesToUbyte(BytesHexStrTranslate.toBytes(modbusResponseHex.substring(4, 6)));

        return modbusResponseHex.substring(6, 6 + 2 * valueLength);
    }

    public static void main(String[] args) {
        String hexValue = transToModbusResponseValue("01030409520006D87C");
        System.out.println(hexValue);
        int value = ByteConvert.bytesToUshort(BytesHexStrTranslate.toBytes(hexValue.substring(0, hexValue.length() / 2)));
        System.out.println("value = " + String.valueOf(value));
    }
}
