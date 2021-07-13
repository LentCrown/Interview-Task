package com.example.interview.rest.exception;

public class SkippedArgumentException extends RuntimeException{
    public SkippedArgumentException(String message) {
        super(message);
    }
}
