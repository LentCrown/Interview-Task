package com.example.interview.rest.exceptions;

public class SkippedArgumentException extends RuntimeException{
    public SkippedArgumentException(String message) {
        super(message);
    }
}
