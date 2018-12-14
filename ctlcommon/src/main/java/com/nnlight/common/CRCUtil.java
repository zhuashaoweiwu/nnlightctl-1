package com.nnlight.common;

import com.nnlightctl.util.BytesHexStrTranslate;

import java.util.zip.CRC32;

public class CRCUtil {
    public static String get16CRC(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }

        return Integer.toHexString(CRC);
    }

    public static String get32CRC(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        return Long.toHexString(crc32.getValue());
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[] {(byte)0xd2, (byte)0x56};
        //crc16
        System.out.println(get16CRC(bytes));
        String hexCRC = get16CRC(bytes);
        byte[] hexCRCBytes = BytesHexStrTranslate.toBytes(hexCRC);
        ArrayUtil.reverse(hexCRCBytes);

        System.out.print("[");
        for (byte b : hexCRCBytes) {
            System.out.print(b);
            System.out.print(",");
        }
        System.out.println("]");

        //crc32
        String hexCRC32 = get32CRC(bytes);
        System.out.println(hexCRC32);
        byte[] hexCRC32Bytes = BytesHexStrTranslate.toBytes(hexCRC32);
        ArrayUtil.reverse(hexCRC32Bytes);
        System.out.print("[");
        for (byte b : hexCRC32Bytes) {
            System.out.print(b);
            System.out.print(",");
        }
        System.out.println("]");
    }
}
