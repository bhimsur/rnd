package io.bhimsur.rnd.qr.object.element;

import io.bhimsur.rnd.qr.parameter.QrTip;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TipInformation implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean needConfirmation;
    private QrTip type;
    private Double amount;
}
