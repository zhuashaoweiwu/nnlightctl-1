package com.nnlight.common;

import java.math.BigDecimal;

public class Demo {
    private static void testBigDecimal() {
        String doubleValueStr = "39.12367";
        double doubleValue = Double.parseDouble(doubleValueStr);
        int intValue = (int)doubleValue;
        BigDecimal bigDecimal = new BigDecimal(doubleValueStr);
        System.out.println(Integer.toString(intValue));
        System.out.println(bigDecimal.subtract(new BigDecimal(Integer.toString(intValue))));

        System.out.println(DegreeTrans.dufen2du("116.327539"));
    }

    public static void main(String[] args) {
        testBigDecimal();
    }
}
