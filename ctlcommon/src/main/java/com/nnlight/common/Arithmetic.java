package com.nnlight.common;

import java.math.BigDecimal;

public class Arithmetic {
    /**
     * 除法运算
     * @param s
     * @param divideNumber
     * @return
     */
    public static String divide(short s, String divideNumber) {
        BigDecimal bdS = new BigDecimal(String.valueOf(s));
        BigDecimal result = bdS.divide(new BigDecimal(divideNumber));
        return result.toString();
    }

    public static String divide(String nString, String divideNumber) {
        BigDecimal bds = new BigDecimal(nString);
        BigDecimal result = bds.divide(new BigDecimal(divideNumber));
        return result.toString();
    }
}
