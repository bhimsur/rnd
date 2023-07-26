package io.bhimsur.rnd.qr.object;

import io.bhimsur.rnd.qr.object.element.MerchantAccountInformation;
import io.bhimsur.rnd.qr.object.element.MerchantRepository;
import io.bhimsur.rnd.qr.object.element.TipInformation;
import io.bhimsur.rnd.qr.parameter.QrCountryISO;
import io.bhimsur.rnd.qr.parameter.QrType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QrData {
    private QrType id01;
    private MerchantAccountInformation id26To45;
    private MerchantRepository id51;
    private String transactionCurrency;
    private Double transactionAmount;
    private TipInformation id55;
    private String country;
    private String merchantName;
    private String merchantCity;
    private String postalCode;

}
