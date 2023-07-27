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
        parserSubTag(map, QrId.MERCHANT_ACCOUNT_INFORMATION_PAYMENT);
        parserSubTag(map, QrId.MERCHANT_ACCOUNT_INFORMATION);

        qrRoot.setRoot(map);
    }

    private QrCountryISO parseCountryCode(Map<String, ILV> map) {
        ILV ilv = map.get(QrId.COUNTRY_CODE.getId());
        return QrCountryISO.of(ilv.getValue());
    }

    private void parseRoot(Map<String, ILV> map, String raw) {
        if (!raw.startsWith("00")) throw new QrParserException("invalid format");
        if (!"01".equals(raw.substring(4, 6))) throw new QrParserException("invalid format");
        parser(map, raw);
    }

    private void parser(Map<String, ILV> map, String raw) {
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

    private void parserSubTag(Map<String, ILV> map, QrId qrId) {
        if (!qrId.isSubTag()) throw new QrParserException("is not sub tag");
        String id = qrId.getId();
        if (id.contains("-")) {
            String[] ids = id.split("-");
            for (int i = Integer.parseInt(ids[0]); i < Integer.parseInt(ids[1]); i++) {
                parserSubTag(map, String.valueOf(i));
            }
        } else {
            parserSubTag(map, id);
        }
    }

    private void parserSubTag(Map<String, ILV> map, String id) {
        if (map.containsKey(id)) {
            Map<String, ILV> subMap = new LinkedHashMap<>();
            ILV ilv = map.get(id);
            parser(subMap, ilv.getValue());
            ilv.setSubTag(subMap);
        }
    }


}
