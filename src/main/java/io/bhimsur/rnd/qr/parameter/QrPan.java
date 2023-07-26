package io.bhimsur.rnd.qr.parameter;

import io.bhimsur.rnd.qr.exception.QrProviderException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Getter
@ToString
public enum QrPan {
    BI("26", "01", null, null),
    NETS("26", "01", 11, "702001"),
    ITMX("30", "01", 11, "9764000"),
    PAYNET("26", "02", null, null),
    ;

    private final String id;
    private final String subId;
    private final Integer length;
    private final String prefix;

    private static final Map<QrProvider, io.bhimsur.rnd.qr.parameter.QrPan> map = new HashMap<>();

    static {
        for (io.bhimsur.rnd.qr.parameter.QrPan pan : values()) {
            map.put(QrProvider.valueOf(pan.name()), pan);
        }
    }

    public static io.bhimsur.rnd.qr.parameter.QrPan get(QrProvider provider) {
        return Optional.ofNullable(map.get(provider)).orElseThrow(() -> new QrProviderException(String.format("provider %s not available", provider)));
    }
}
