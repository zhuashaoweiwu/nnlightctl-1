package com.nnlight.common;


import java.util.*;
import java.util.stream.Collectors;

public class SystemConfig {


    public interface ControlIlength {
        Map<String, Object> m = new HashMap<String, Object>();
    }

    public enum Ilength {

        /*** 地址域*/
        addr(0, new ControlTransformation.Builder().startIndex(1).ilength(6).build()),

        /**
         * 逻辑区
         */
        logicalArea(1, new ControlTransformation.Builder().startIndex(8).build()),

        /**
         * 物理区
         */
        physicsArea(2, new ControlTransformation.Builder().startIndex(9).build()),

        /*** IMEI*/
        imei(3, new ControlTransformation.Builder().startIndex(8).ilength(17).build()),

        /*** 控制码*/
        control(4, new ControlTransformation.Builder(25).build()),

        /*** 数据长度*/
        dataLength(5, new ControlTransformation.Builder(26).build()),

        /*** 数据域*/
        data(6, new ControlTransformation.Builder(27).build()),

        /*** 校验码*/
        check(7, new ControlTransformation.Builder(27).build());

        Ilength(int code) {
            this.code = code;
        }

        Ilength(int code, ControlTransformation val) {
            this.code = code;
            this.val = val;
        }

        private int code;
        private ControlTransformation val;

        public int getCode() {
            return this.code;
        }

        public ControlTransformation getValue() {
            return this.val;
        }


        public static List<Map<String, Object>> list() {
            return Arrays.stream(Ilength.values()).map(e -> {
                Map<String, Object> map = new HashMap(1);
                map.put("key", e.getCode());
                map.put("value", e.getValue());
                return map;
            }).collect(Collectors.toList());
        }

        public static Ilength valueOf(int code) {
            for (Ilength value : Ilength.values()) {
                if (value.code == code) {
                    return value;
                }
            }
            throw new IllegalArgumentException("没有这个Code");
        }
    }

    public static class getInfo {

        protected interface getCacheKey {

            public static final Integer DATALENGTHINDEX = 5;

            public static final String PREFIX = "set";

        }

        protected static Object optionIlength(Ilength ilength, ControlTransformation controlTransformation, byte... data) {
            switch (ilength) {
                case data:
                    byte[] dataArea = new byte[controlTransformation.runLength];
                    if (controlTransformation.runLength >= data.length || controlTransformation.getStartIndex(ilength.getValue().startIndex) >= data.length) {
                        System.out.println("error");
                    }
                    System.arraycopy(data, controlTransformation.getStartIndex(ilength.getValue().startIndex), dataArea, 0, controlTransformation.runLength);
                    return dataArea;
                case check:
                    return data[controlTransformation.getStartIndex(ilength.getValue().startIndex) + controlTransformation.runLength];
                case dataLength:
                    int drm = data[controlTransformation.getStartIndex(ilength.getValue().startIndex)];
                    controlTransformation.runLength = drm & 0x000000ff;
                    return (byte) drm;
                case addr:
                    byte[] addr = new byte[ilength.getValue().ilength];
                    System.arraycopy(data, ilength.getValue().startIndex, addr, 0, ilength.getValue().ilength);
                    if (addr[addr.length - 1] == 02)
                        controlTransformation.point = 2;
                    else if (addr[addr.length - 1] == 04)
                        controlTransformation.flag = Boolean.TRUE;
                    return addr;
                case logicalArea:
                case physicsArea:
                    if (PubMethod.isEmpty(controlTransformation.point) || controlTransformation.point == (0))
                        return null;
                    else
                        return data[ilength.getValue().startIndex];
                case imei:
                    if (!PubMethod.isEmpty(controlTransformation.flag) && controlTransformation.flag) return null;
                    byte[] imei = new byte[ilength.getValue().ilength];
                    System.arraycopy(data, controlTransformation.getStartIndex(ilength.getValue().startIndex), imei, 0, ilength.getValue().ilength);
                    return imei;
                case control:
//                    System.out.println("control = " + data[controlTransformation.getStartIndex(ilength.getValue().startIndex)]);
//                    System.out.println("control *= " + byteToHex(data[controlTransformation.getStartIndex(ilength.getValue().startIndex)]));
                    return data[controlTransformation.getStartIndex(ilength.getValue().startIndex)];
                default:
                    return null;
            }
        }


        public static String byteToHex(byte b) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() < 2) {
                hex = "0" + hex;
            }
            return hex;
        }


    }


}