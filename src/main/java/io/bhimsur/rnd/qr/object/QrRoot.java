package io.bhimsur.rnd.qr.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QrRoot implements Serializable {
    private static final long serialVersionUID = 11L;
    private String raw;
    private Map<String, ILV> root;

    public QrRoot(String raw) {
        this.raw = raw;
    }
}
