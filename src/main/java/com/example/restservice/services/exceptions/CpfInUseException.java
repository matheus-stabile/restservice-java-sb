package com.example.restservice.services.exceptions;

public class CpfInUseException extends RuntimeException {

    private static final long serialVersionUID = -5909057948828980030L;

    public CpfInUseException(String msg) {
        super(msg);
    }
}
