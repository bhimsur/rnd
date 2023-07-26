package io.bhimsur.rnd.qr.core;

import io.bhimsur.rnd.qr.object.ILV;
import io.bhimsur.rnd.qr.object.QrData;
import io.bhimsur.rnd.qr.object.QrRoot;
import io.bhimsur.rnd.qr.parameter.QrType;

import java.util.Map;

public class QrMapper {
    private final QrParser qrParser;
    private final String raw;

    public QrMapper(QrParser qrParser, String raw) {
        this.qrParser = qrParser;
        this.raw = raw;
    }

    public QrData command() {
        QrRoot qrRoot = this.qrParser.command(this.raw);
        Map<String, ILV> root = qrRoot.getRoot();
        QrData qrData = new QrData();
        System.out.println(root);
        qrData.setId01(QrType.get(root.get("01").getValue()));
        return qrData;
    }

}
