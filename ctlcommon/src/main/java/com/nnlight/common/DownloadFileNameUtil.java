package com.nnlight.common;

import java.io.UnsupportedEncodingException;

public class DownloadFileNameUtil {
    public static String gbk2iso8859_1(String fileName) {
        try {
            return new String(fileName.getBytes("GBK"), "ISO8859_1");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
