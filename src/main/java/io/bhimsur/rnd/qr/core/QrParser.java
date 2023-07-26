package io.bhimsur.rnd.qr.core;

import io.bhimsur.rnd.qr.exception.QrParserException;
import io.bhimsur.rnd.qr.object.ILV;
import io.bhimsur.rnd.qr.object.QrRoot;
import io.bhimsur.rnd.qr.parameter.QrCountryISO;
import io.bhimsur.rnd.qr.parameter.QrId;

import java.util.LinkedHashMap;
import java.util.Map;

public class QrParser {

    public QrRoot command(String raw) {
        QrRoot qrRoot = new QrRoot(raw);
        parse(qrRoot);
        return qrRoot;
    }

    private void parse(QrRoot qrRoot) {
        Map<String, ILV> map = new LinkedHashMap<>();
        parseRoot(map, qrRoot.getRaw());
        QrCountryISO country = parseCountryCode(map);

        qrRoot.setRoot(map);
    }

    private QrCountryISO parseCountryCode(Map<String, ILV> map) {
        ILV ilv = map.get(QrId.COUNTRY_CODE.getId());
        return QrCountryISO.of(ilv.getValue());
    }

    private void parseRoot(Map<String, ILV> map, String raw) {
        parser(map, raw);
    }

    private void parser(Map<String, ILV> map, String raw) {
        if (!raw.startsWith("00")) throw new QrParserException("invalid format");
        if (!"01".equals(raw.substring(4, 6))) throw new QrParserException("invalid format");
        int length;
        for (int i = 0; i < raw.length(); i = i + 4 + length) {
            String id = raw.substring(i, i + 2);
            length = Integer.parseInt(raw.substring(i + 2, i + 4));
            String value = raw.substring(i + 4, i + 4 + length);
            ILV ilv = new ILV(id, String.valueOf(length), value);
            map.merge(ilv.getId(), ilv, (k1, k2) -> {
                throw new QrParserException("Duplicate id %s.", id);
            });
        }
    }


}
