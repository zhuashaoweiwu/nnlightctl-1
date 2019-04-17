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

        String hexStr = Integer.toHexString(CRC);
        int zeroCount = 4 - hexStr.length();
        for (int k = 0; k < zeroCount; ++k) {
            hexStr = "0" + hexStr;
        }

        return hexStr;
    }

    public static String get32CRC(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        String crc32HexStr = Long.toHexString(crc32.getValue());
        int zeroCount = 8 - crc32HexStr.length();
        for (int k = 0; k < zeroCount; ++k) {
            crc32HexStr = "0" + crc32HexStr;
        }
        return crc32HexStr;
    }

    public static void main(String[] args) {
        byte[] bytes = new byte[] {(byte)0x01, (byte)0x03, (byte)0x00, (byte)0x60, (byte)0x00, (byte)0x02};
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
