package com.nnlight.common;

import java.math.BigDecimal;

public class LightTermianlSignalLevelUtil {

    private static final BigDecimal LEVEL1 = new BigDecimal("-73");

    private static final BigDecimal LEVEL2 = new BigDecimal("-93");

    public static int getSignalLevel(BigDecimal signal) {
        if (signal.compareTo(LEVEL1) < 0) {
            return 3;
        } else if (signal.compareTo(LEVEL2) < 0) {
            return 2;
        } else {
            return 1;
        }
    }
}
