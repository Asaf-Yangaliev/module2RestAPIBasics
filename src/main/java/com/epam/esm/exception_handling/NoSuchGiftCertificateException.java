package com.epam.esm.exception_handling;

public class NoSuchGiftCertificateException extends RuntimeException {
    public NoSuchGiftCertificateException(String message) {
        super(message);
    }
}
