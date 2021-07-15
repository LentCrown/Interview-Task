package com.example.interview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    @ApiModelProperty(notes = "Number 1")
    private final int number1;
    @ApiModelProperty(notes = "Nummber 2")
    private final int number2;
    @ApiModelProperty(notes = "Result of invoked operation")
    private final int result;
}
