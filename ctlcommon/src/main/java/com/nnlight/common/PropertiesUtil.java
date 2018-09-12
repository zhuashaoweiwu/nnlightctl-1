package com.nnlight.common;

import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesUtil {
    private PropertiesUtil(){

    }

    public static Properties load(File file) throws IOException {

        try (InputStream in = new FileInputStream(file)) {
            Properties props = new Properties();
            props.load(in);

            return props;

        }
    }

    public static Properties load(String path) throws IOException{

        try (InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(path);
             Reader reader = new InputStreamReader(in, Charset.forName("GBK"))) {
            Properties props = new Properties();
            props.load(reader);

            return props;

        }
    }
}
