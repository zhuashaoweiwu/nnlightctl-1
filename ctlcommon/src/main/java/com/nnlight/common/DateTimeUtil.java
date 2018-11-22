package com.nnlight.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtil {

    public static Date nowWithoutSecond() {
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0).withSecond(0);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date fromLocalDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);

        return date;
    }

    public static String nowStr() {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        Date date = Date.from(instant);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public static byte[] nowBytes() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String[] timeSeprater = dateFormat.format(new Date()).split("-");
        byte[] timeData = new byte[6];
        timeData[0] = (byte)(Integer.parseInt(timeSeprater[0]) - 2000);
        timeData[1] = Byte.parseByte(timeSeprater[1]);
        timeData[2] = Byte.parseByte(timeSeprater[2]);
        timeData[3] = Byte.parseByte(timeSeprater[3]);
        timeData[4] = Byte.parseByte(timeSeprater[4]);
        timeData[5] = Byte.parseByte(timeSeprater[5]);

        return timeData;
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0).withSecond(0);
        System.out.println(localDateTime);

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);

        System.out.println(nowStr());
    }
}
