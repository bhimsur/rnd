package io.bhimsur.rnd.qr.parameter;

import io.bhimsur.rnd.qr.exception.QrCountryException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public enum QrCountryISO {
    INDONESIA("ID", 360),
    MALAYSIA("MY", 458),
    SINGAPORE("SG", 702),
    THAILAND("TH", 764),
    ;

    private final String alpha2;
    private final int numeric;
    private static final Map<String, QrCountryISO> alpha2Map = new HashMap<>();
    private static final Map<Integer, QrCountryISO> numericMap = new HashMap<>();

    static {
        for (QrCountryISO country : values()) {
            alpha2Map.put(country.getAlpha2(), country);
            numericMap.put(country.getNumeric(), country);
        }
    }

    public static QrCountryISO of(String alpha2) {
        return Optional.ofNullable(alpha2Map.get(alpha2)).orElseThrow(() -> new QrCountryException("invalid alpha2"));
    }

    public static QrCountryISO of(int numeric) {
        return Optional.ofNullable(numericMap.get(numeric)).orElseThrow(() -> new QrCountryException("invalid numeric"));
    }

}
