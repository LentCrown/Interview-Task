package com.example.interview.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class BaseRequest {
    @NotNull
    private Integer number1;
    @NotNull
    private Integer number2;
}
