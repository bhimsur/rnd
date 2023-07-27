package io.bhimsur.rnd.qr;

import io.bhimsur.rnd.qr.core.QrMapper;
import io.bhimsur.rnd.qr.core.QrParser;
import io.bhimsur.rnd.qr.parameter.QrMid;
import io.bhimsur.rnd.qr.parameter.QrPan;
import io.bhimsur.rnd.qr.parameter.QrProvider;

public class QrApplication {
    public static void main(String[] args) {
        String id = "00020101021126650013ID.CO.BCA.WWW011893600014000124857402150008850012485740303UKE51440014ID.CO.QRIS.WWW0215ID20210753479750303UKE5204839853033605802ID5922YAYASAN PEMBINAAN ANAK6015JAKARTA SELATAN61051212062070703A016304E58B";
        String th = "00020101021230640016A0000006770101120115010553509091205020720661140310W22932935553037645406200.005802TH62070703PRF63040C86";
        String sg = "00020101021226370009SG.PAYNOW010120210201207337D03010520400005303702540510.005802SG5916Nerdherd Pte Ltd6009Singapore6304F832";


        QrParser qrParser = new QrParser();
        QrMapper qrMapperId = new QrMapper(qrParser, id);
        qrMapperId.command();
    }
}
