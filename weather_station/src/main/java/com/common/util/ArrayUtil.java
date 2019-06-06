package com.common.util;

import org.springframework.stereotype.Component;

@Component
public class ArrayUtil {

    public static <T> T[] reverse(T[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        for (int i = 0; i < array.length / 2; ++i) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }

        return array;
    }

    public static byte[] reverse(byte[] bytes) {
        if (bytes == null || bytes.length <= 1) {
            return bytes;
        }

        for (int i = 0; i < bytes.length / 2; ++i) {
            byte temp = bytes[i];
            bytes[i] = bytes[bytes.length - i - 1];
            bytes[bytes.length - i - 1] = temp;
        }

        return bytes;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[] {1, 2};
        reverse(a);
        System.out.print("[");
        for (Integer i : a) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println("]");

        byte[] bytes = new byte[] {0x01, 0x02, 0x03, 0x04};
        reverse(bytes);
        System.out.print("[");
        for (byte b : bytes) {
            System.out.print(b);
            System.out.print(",");
        }
        System.out.println("]");
    }

    public String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
