package com.example.restservice.resources.exceptions;

import com.example.restservice.services.exceptions.CpfInUseException;
import com.example.restservice.services.exceptions.EmailInUseException;
import com.example.restservice.services.exceptions.InvalidClientException;
import com.example.restservice.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {

        String error = "Cliente não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(InvalidClientException.class)
    public ResponseEntity<StandardError> invalidClient(InvalidClientException e, HttpServletRequest request) {

        String error = "Cliente inválido, revise os dados.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(EmailInUseException.class)
    public ResponseEntity<StandardError> invalidClient(EmailInUseException e, HttpServletRequest request) {

        String error = "Cliente inválido, revise os dados.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(CpfInUseException.class)
    public ResponseEntity<StandardError> invalidClient(CpfInUseException e, HttpServletRequest request) {

        String error = "Cliente inválido, revise os dados.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
