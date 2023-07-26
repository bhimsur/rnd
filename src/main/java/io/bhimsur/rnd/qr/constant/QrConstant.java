package io.bhimsur.rnd.qr.constant;

import io.bhimsur.rnd.qr.core.QrCountryISO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QrConstant {
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Regex {
        public static final String TWO_DECIMAL = "^\\d{2}$";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Message {
        public static final String WRONG_INPUT = "Wrong Input";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Id {
        public static final Map<String, Integer> MAI = new HashMap<>();
        static {
            MAI.put(QrCountryISO.INDONESIA.getAlpha2(), 26);
            MAI.put(QrCountryISO.THAILAND.getAlpha2(), 30);
            MAI.put(QrCountryISO.SINGAPORE.getAlpha2(), 26);
            MAI.put(QrCountryISO.MALAYSIA.getAlpha2(), 26);
        }

    }
}
