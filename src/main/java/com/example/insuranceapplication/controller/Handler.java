package com.example.insuranceapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Handler {

    @ControllerAdvice
    public class DefaultHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity handle(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }
}

