package com.example.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ExceptionResponse {
    private final Timestamp timestamp;
    private final String message;
}
