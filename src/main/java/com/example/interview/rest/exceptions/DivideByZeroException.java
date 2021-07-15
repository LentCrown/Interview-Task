package com.example.interview.rest.exceptions;

public class DivideByZeroException extends RuntimeException{
    public DivideByZeroException() {
        super("You cannot divide by zero!");
    }
}
