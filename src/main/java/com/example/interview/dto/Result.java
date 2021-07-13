package com.example.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private final int number1;
    private final int number2;
    private final int result;
}
