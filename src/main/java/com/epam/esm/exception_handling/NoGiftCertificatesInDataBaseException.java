package com.epam.esm.exception_handling;

public class NoGiftCertificatesInDataBaseException extends RuntimeException {
    public NoGiftCertificatesInDataBaseException(String message) {
        super(message);
    }
}
