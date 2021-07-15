package com.example.interview.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseResponse {
    @ApiModelProperty(notes = "Time of generated response")
    private final String date;
    @ApiModelProperty(notes = "Status of invoked operation")
    private final String status;
    @ApiModelProperty(notes = "Results of operation")
    private final Result result;
}
