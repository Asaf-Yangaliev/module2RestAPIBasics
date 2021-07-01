package com.epam.esm.exception_handling;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GiftCertificateGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<NoGiftCertificateInDatabase> handleException(NoGiftCertificatesInDataBaseException e) {
        NoGiftCertificateInDatabase noCertificate =
                new NoGiftCertificateInDatabase(504, e.getMessage(), 50401);
        return new ResponseEntity<>(noCertificate, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<NoGiftCertificateInDatabase> handleException(NoSuchGiftCertificateException e) {
        NoGiftCertificateInDatabase noCertificate =
                new NoGiftCertificateInDatabase(404, e.getMessage() , 40401);
        return new ResponseEntity<>(noCertificate, HttpStatus.BAD_REQUEST);
    }
}
