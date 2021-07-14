package com.example.interview.rest.exceptions;

import com.example.interview.dto.ExceptionResponse;
import com.example.interview.rest.exceptions.DivideByZeroException;
import com.example.interview.rest.exceptions.SkippedArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

@RestControllerAdvice
public class ErrorHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(SkippedArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleSkippedArgumentException(SkippedArgumentException e) {
        ExceptionResponse response = new ExceptionResponse(new Timestamp(System.currentTimeMillis()), e.getMessage());
        logger.error(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleHTTPMessageNotReadableException(HttpMessageNotReadableException e) {
        ExceptionResponse response = new ExceptionResponse(new Timestamp(System.currentTimeMillis()),e.getMessage());
        logger.error(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DivideByZeroException.class)
    public ResponseEntity<ExceptionResponse> handleDivideByZeroException(DivideByZeroException e) {
        ExceptionResponse response = new ExceptionResponse(new Timestamp(System.currentTimeMillis()),e.getMessage());
        logger.error(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
