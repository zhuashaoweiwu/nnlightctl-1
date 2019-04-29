package com.nnlightctl.util;

import javax.sound.sampled.AudioFormat;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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




    public static void toHex(int num) {

        //& 两两为1即为1
        //>>>无符号右移
        /**
         * eg.60
         *       0000-0000 0000-0000 0000-0000 0011-1100   60的二进制表示
         * &     0000-0000 0000-0000 0000-0000 0000-1111   15的二进制表示
         * &后的值   0000-0000 0000-0000 0000-0000 0000-1100          值为12即16进制的C
         */
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            int temp = num & 15;
            if (temp > 9) {
                sb.append((char) (temp - 10 + 'A'));//强转成16进制

            } else {
                sb.append(temp);
            }
            num = num >>> 4;
        }
        System.out.println(sb.reverse());//0000003C


    }
    public static List<Boolean> getHunyiByNum(int num){
        String s = Integer.toBinaryString(num);
        List<Boolean> bool=new ArrayList<Boolean>();
        String format = String.format("%017d", Long.parseLong(s));
        for (int i = 0; i <format.length() ; i++) {
            char c1 = format.charAt(i);
            if (c1=='0'){
                bool.add(false);
            }
            if (c1=='1'){
                bool.add(true);
            }
        }
        //System.out.println(s1);
        return bool;
    }



    public static void main(String[] args) throws UnsupportedEncodingException {

        List<Boolean> hunyiByNum = getHunyiByNum(2048);
        hunyiByNum.forEach(e->{
            System.out.print(e?1:0);
        });

//        bytes2BinaryStr(new byte[]{8,00});
//        System.out.println(new String(a));
//        System.out.println(new String(a).getBytes());
//        System.out.println(new String(a,"GBK"));
//        System.out.println(new String(a,"UTF-8"));
//        System.out.println(new String(a,"ISO8859-1"));


//        byte[] bytes = BytesHexStrTranslate.toBytes("FF");
//        for (int i = 0; i < bytes.length; i++)
//        {
//            System.out.println(bytes[i] & 0xFF);
//        }

//        toHex(80);


//        String s = BytesHexStrTranslate.bytesToHexFun((byte) (((byte)800) ));
//        System.out.println(s);


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
