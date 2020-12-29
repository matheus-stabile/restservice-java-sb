package com.example.restservice.services.exceptions;

public class EmailInUseException extends RuntimeException {
    private static final long serialVersionUID = 2873945255055160331L;

    public EmailInUseException(String msg) {
        super(msg);
    }
}
