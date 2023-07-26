package io.bhimsur.rnd.qr.parameter;

import io.bhimsur.rnd.qr.exception.QrProviderException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
@ToString
@SuppressWarnings("ALL")
public enum QrMid {
    BI("26", "02", null, null),
    ITMX("30", "01", null, null),
    PAYNET("26", "02", 15, null),
    NETS("27", "02", 11, "702001"),
    ;

    private final String id;
    private final String subId;
    private final Integer length;
    private final String prefix;

    private static final Map<QrProvider, io.bhimsur.rnd.qr.parameter.QrMid> map = new HashMap<>();

    static {
        for (io.bhimsur.rnd.qr.parameter.QrMid mid : values()) {
            map.put(QrProvider.valueOf(mid.name()), mid);
        }
    }

    public static io.bhimsur.rnd.qr.parameter.QrMid get(QrProvider provider) {
        return Optional.ofNullable(map.get(provider)).orElseThrow(() -> new QrProviderException(String.format("provider %s not available", provider)));
    }
}
