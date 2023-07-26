package io.bhimsur.rnd.qr.object.element;

import io.bhimsur.rnd.qr.constant.QrConstant;
import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MerchantAccountInformation implements Serializable {
    private static final long serialVersionUID = 1L;
    @NonNull
    @Size(max = 32)
    private String domain;
    @Size(max = 19)
    @Pattern(regexp = QrConstant.Regex.DECIMAL, message = QrConstant.Message.WRONG_INPUT)
    private String pan;
    @Size(max = 15)
    private String merchantId;
    private String criteria;
}
