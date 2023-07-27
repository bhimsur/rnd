package io.bhimsur.rnd.qr.parameter;

import io.bhimsur.rnd.qr.exception.QrProviderException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("ALL")
@Getter
@RequiredArgsConstructor
@ToString
public enum QrProvider {
    /**
     * Bank Indonesia
     */
    BI("ID"),
    /**
     * Network for Electronic Transfers
     */
    NETS("SG"),
    /**
     * Interbank Transaction Management and Exchange
     */
    ITMX("TH"),
    /**
     * Payments Network Malaysia
     */
    PAYNET("MY");

    private final String countryCode;

    private static final Map<String, QrProvider> map = new HashMap<>();

    static {
        for (QrProvider provider : values()) {
            map.put(provider.getCountryCode(), provider);
        }
    }

    public static QrProvider get(String countryCode) {
        return Optional.ofNullable(map.get(countryCode)).orElseThrow(() -> new QrProviderException(String.format("country code %s not available", countryCode)));
    }

}
