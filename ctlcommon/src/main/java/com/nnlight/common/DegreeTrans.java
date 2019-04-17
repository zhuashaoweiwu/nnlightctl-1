package com.nnlight.common;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DegreeTrans {
    public static String dufen2du(String dufenValueStr) {
        if (StringUtils.isEmpty(dufenValueStr)) {
            throw new RuntimeException("转换参数不可为空");
        }

        double doubleValue = Double.parseDouble(dufenValueStr);
        int intValue = (int)doubleValue;
        BigDecimal intBigDecimal = new BigDecimal(intValue);
        BigDecimal bigDecimal = new BigDecimal(dufenValueStr);
        BigDecimal floatBigDecimal = bigDecimal.subtract(intBigDecimal);
        BigDecimal float2DuBigDecimal = floatBigDecimal.multiply(new BigDecimal("100"))
                .divide(new BigDecimal("60"), 8, RoundingMode.HALF_DOWN);
        return intBigDecimal.add(float2DuBigDecimal).toString();
    }
}
