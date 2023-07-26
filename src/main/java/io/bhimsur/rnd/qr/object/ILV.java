package io.bhimsur.rnd.qr.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class ILV implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String length;
    private String value;
    private Map<String, ILV> subTag;

    public int getIntLength() {
        return Integer.parseInt(this.length);
    }
}
