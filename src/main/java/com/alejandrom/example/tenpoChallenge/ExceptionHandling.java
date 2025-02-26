package com.alejandrom.example.tenpoChallenge;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandling {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorResponse> catchApiExceptions(Throwable e) {
        return ResponseEntity.status(500).body(new ErrorResponse(500, "Unknown server error"));
    }

    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<ErrorResponse> missingParams(MissingRequestValueException exception) {
        return ResponseEntity.status(400).body(new ErrorResponse(400, "Request is missing stuff"));
    }
}