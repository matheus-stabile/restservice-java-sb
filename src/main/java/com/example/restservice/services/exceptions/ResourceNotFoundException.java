package com.example.restservice.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2540844450119438093L;

    public ResourceNotFoundException(Object id) {
        super("Cliente não encontrado. Id: " + id);
    }
}
