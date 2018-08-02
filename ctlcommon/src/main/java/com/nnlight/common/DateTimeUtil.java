package com.nnlight.common;

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

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now().withNano(0).withSecond(0);
        System.out.println(localDateTime);

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }
}
