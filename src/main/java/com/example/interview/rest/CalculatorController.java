package com.example.interview.rest;

import com.example.interview.services.CalculatorService;
import com.example.interview.soap.CalculatorServiceClient;
import com.example.interview.dto.BaseRequest;
import com.example.interview.dto.BaseResponse;
import com.example.interview.dto.Result;
import com.example.interview.rest.exceptions.DivideByZeroException;
import com.example.interview.rest.exceptions.SkippedArgumentException;
import com.example.interview.soap.calculator.AddResponse;
import com.example.interview.soap.calculator.DivideResponse;
import com.example.interview.soap.calculator.MultiplyResponse;
import com.example.interview.soap.calculator.SubtractResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;

@RestController
@RequestMapping("/calculator")
@Api(value = "calculator")
public class CalculatorController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Test connection", response = Result.class)
    public BaseResponse showStatus() {
        logger.info("Testing connection..");
        return new BaseResponse(Instant.now().toString(),SUCCESS_STATUS,
                new Result(0,0,0));
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ApiOperation(value = "Add two numbers", response = Result.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed operation"),
            @ApiResponse(code = 400, message = "Bad request, check parameters"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public BaseResponse add(@RequestBody BaseRequest request) {
        logger.info("Invoking add operation..");
        if (request.getNumber1()==null || request.getNumber2()==null)
            throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        int result = calculatorService.add(number1, number2);
        logger.info("Web-service invoking is OK");
        logger.debug(number1 + " + " + number2 + " = " + result);
        return new BaseResponse(Instant.now().toString(),SUCCESS_STATUS,
                new Result(number1,number2,result));
    }

    @PostMapping(value = "/div", produces = "application/json")
    @ApiOperation(value = "Divide two numbers", response = Result.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed operation"),
            @ApiResponse(code = 400, message = "Bad request, check parameters"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public BaseResponse divide(@RequestBody BaseRequest request) {
        logger.info("Invoking divide operation..");
        if (request.getNumber1()==null || request.getNumber2()==null)
            throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        if (number2 == 0) throw new DivideByZeroException();
        int result = calculatorService.divide(number1, number2);
        logger.info("Web-service invoking is OK");
        logger.debug(number1 + " / " + number2 + " = " + result);
        return new BaseResponse(Instant.now().toString(),SUCCESS_STATUS,
                new Result(number1,number2,result));
    }

    @PostMapping(value = "/mul", produces = "application/json")
    @ApiOperation(value = "Multiply two numbers", response = Result.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed operation"),
            @ApiResponse(code = 400, message = "Bad request, check parameters"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public BaseResponse multiply(@RequestBody BaseRequest request) {
        logger.info("Invoking multiply operation..");
        if (request.getNumber1()==null || request.getNumber2()==null)
            throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        int result = calculatorService.multiply(number1, number2);
        logger.info("Web-service invoking is OK");
        logger.debug(number1 + " * " + number2 + " = " + result);
        return new BaseResponse(Instant.now().toString(),SUCCESS_STATUS,
                new Result(number1,number2,result));
    }

    @PostMapping(value = "/sub", produces = "application/json")
    @ApiOperation(value = "Subtract two numbers", response = Result.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully completed operation"),
            @ApiResponse(code = 400, message = "Bad request, check parameters"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public BaseResponse subtract(@RequestBody BaseRequest request) {
        logger.info("Invoking subtract operation..");
        if (request.getNumber1()==null || request.getNumber2()==null)
            throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        int result = calculatorService.subtract(number1, number2);
        logger.info("Web-service invoking is OK");
        logger.debug(number1 + " - " + number2 + " = " + result);
        return new BaseResponse(Instant.now().toString(),SUCCESS_STATUS,
                new Result(number1,number2,result));
    }
}
