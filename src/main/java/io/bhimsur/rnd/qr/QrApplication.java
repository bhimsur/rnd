package io.bhimsur.rnd.qr;

import io.bhimsur.rnd.qr.core.QrMid;
import io.bhimsur.rnd.qr.core.QrPan;
import io.bhimsur.rnd.qr.core.QrProvider;

public class QrApplication {
    public static void main(String[] args) {
        String cc = "ID";
        QrProvider provider = QrProvider.get(cc);
        System.out.println(provider);
        System.out.println(QrMid.get(provider));
        System.out.println(QrPan.get(provider));
    }
}
