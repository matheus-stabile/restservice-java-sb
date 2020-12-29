package com.example.restservice.services.exceptions;

import com.example.restservice.entities.Client;

public class InvalidClientException extends RuntimeException {
    private static final long serialVersionUID = -165078628620003855L;

    public InvalidClientException(Client obj) {
        super(obj.validateClient(obj));
    }
}
