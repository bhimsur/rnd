package io.bhimsur.rnd.qr.exception;

public class QrParserException extends RuntimeException {
    public QrParserException(String message) {
        super(message);
    }

    public QrParserException(String message, String id) {
        super(String.format(message, id));
    }
}
