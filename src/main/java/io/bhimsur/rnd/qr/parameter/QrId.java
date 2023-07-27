package io.bhimsur.rnd.qr.parameter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum QrId {
    COUNTRY_CODE("58", false),
    MERCHANT_ACCOUNT_INFORMATION_PAYMENT("26-45", true),
    MERCHANT_ACCOUNT_INFORMATION("51", true),
    ;

    private final String id;
    private final boolean isSubTag;
}
