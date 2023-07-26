package io.bhimsur.rnd.qr;

import io.bhimsur.rnd.qr.parameter.QrMid;
import io.bhimsur.rnd.qr.parameter.QrPan;
import io.bhimsur.rnd.qr.parameter.QrProvider;

public class QrApplication {
    public static void main(String[] args) {
        String cc = "ID";
        QrProvider provider = QrProvider.get(cc);
        System.out.println(provider);
        System.out.println(QrMid.get(provider));
        System.out.println(QrPan.get(provider));
    }
}
