package io.bhimsur.rnd.qr.parameter;

import io.bhimsur.rnd.qr.exception.QrProviderException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public enum QrType {
    STATIC("11"),
    DYNAMIC("12"),
    ;

    private final String type;
    private static final Map<String, QrType> map = new HashMap<>();

    static {
        for (QrType qrType : values()) {
            map.put(qrType.getType(), qrType);
        }
    }

    public static QrType get(String type) {
        return Optional.ofNullable(map.get(type)).orElseThrow(() -> new QrProviderException("invalid type"));
    }
}
