package com.example.interview.rest.exception;

public class DivideByZeroException extends RuntimeException{
    public DivideByZeroException() {
        super("You cannot divide by zero!");
    }
}
