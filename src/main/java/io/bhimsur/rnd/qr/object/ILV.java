package io.bhimsur.rnd.qr.object;

import io.bhimsur.rnd.qr.constant.QrConstant;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
@Valid
public class ILV implements Serializable {
    private static final long serialVersionUID = 1L;

    @NonNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = QrConstant.Regex.TWO_DECIMAL, message = QrConstant.Message.WRONG_INPUT)
    private String id;

    @NonNull
    @Size(min = 2, max = 2)
    @Pattern(regexp = QrConstant.Regex.TWO_DECIMAL, message = QrConstant.Message.WRONG_INPUT)
    private String length;

    @NonNull
    @NotEmpty
    private String value;
    private Map<String, ILV> subTag;

    public int getIntLength() {
        return Integer.parseInt(this.length);
    }
}
