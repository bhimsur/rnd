package io.bhimsur.rnd.qr.parameter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum QrId {
    COUNTRY_CODE("58"),
    ;

    private final String id;
}
