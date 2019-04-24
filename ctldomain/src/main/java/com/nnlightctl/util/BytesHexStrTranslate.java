package com.nnlightctl.util;

public class BytesHexStrTranslate {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};



    public static String bytesToHexFun(byte... bytes) {
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for(byte b : bytes) {
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }

    public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    public static void main(String[] args) {
//        System.out.println(BytesHexStrTranslate.bytesToHexFun((byte)01));

//        byte[] bytes = BytesHexStrTranslate.toBytes("E208");
//        for (byte b : bytes) {
//            System.out.print(b);
//            System.out.print(",");
//        }
//
//        byte[] hexBytes = toBytes("c465");
//        System.out.print("[");
//        for (byte b : hexBytes) {
//            System.out.print(b);
//            System.out.print(",");
//        }
//        System.out.print("]");
//
//        String hex = bytesToHexFun(hexBytes);
//        System.out.println(hex);
//
//        byte[] bytes1 = new byte[] {0, 0, 0, 0};
//        System.out.println(bytesToHexFun(bytes1));
    }
}
