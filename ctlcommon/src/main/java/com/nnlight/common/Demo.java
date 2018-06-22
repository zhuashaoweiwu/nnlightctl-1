package com.nnlight.common;

import java.math.BigDecimal;

public class Demo {
    private static void testBigDecimal() {
        BigDecimal bigDecimal = new BigDecimal("39.12367E");
        System.out.println(bigDecimal);
    }

    public static void main(String[] args) {
        testBigDecimal();
    }
}
