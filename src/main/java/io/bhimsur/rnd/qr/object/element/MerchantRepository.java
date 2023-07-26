package io.bhimsur.rnd.qr.object.element;

import io.bhimsur.rnd.qr.parameter.QrMerchantCriteria;
import lombok.*;

import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MerchantRepository implements Serializable {
    private static final long serialVersionUID = 1L;
    private String domain;
    private String merchantId;
    private QrMerchantCriteria criteria;

    public MerchantRepository(String domain, String merchantId, QrMerchantCriteria criteria) {
        this.domain = domain;
        this.merchantId = merchantId;
        this.criteria = Optional.ofNullable(criteria).orElse(QrMerchantCriteria.URE);
    }
}
