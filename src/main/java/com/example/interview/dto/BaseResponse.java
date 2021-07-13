package com.example.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class BaseResponse {
    private final Timestamp timestamp;
    private final String status;
    private final Result result;
}
