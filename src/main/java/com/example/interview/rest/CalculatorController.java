package com.example.interview.rest;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CalculatorServiceClient calculatorServiceClient;

    public CalculatorController(CalculatorServiceClient calculatorServiceClient) {
        this.calculatorServiceClient = calculatorServiceClient;
    }

    @GetMapping
    public BaseResponse showStatus() {
        logger.info("Testing connection..");
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(0,0,0));
    }

    @GetMapping("/add")
    public BaseResponse add(@RequestBody BaseRequest request) {
        if (request.getNumber1()==null || request.getNumber2()==null) throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        logger.info("Attempt to do operation: " + number1 + "+" + number2);
        AddResponse response = calculatorServiceClient.add(number1, number2);
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2, response.getAddResult()));
    }

    @GetMapping("/div")
    public BaseResponse divide(@RequestBody BaseRequest request) {
        if (request.getNumber1()==null || request.getNumber2()==null) throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        logger.info("Attempt to do operation: " + number1 + "/" + number2);
        if (number2 == 0) throw new DivideByZeroException();
        DivideResponse response = calculatorServiceClient.divide(number1, number2);
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2, response.getDivideResult()));
    }

    @GetMapping("/mul")
    public BaseResponse multiply(@RequestBody BaseRequest request) {
        if (request.getNumber1()==null || request.getNumber2()==null) throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        logger.info("Attempt to do operation: " + number1 + "*" + number2);
        MultiplyResponse response = calculatorServiceClient.multiply(number1, number2);
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2,response.getMultiplyResult()));
    }

    @GetMapping("/sub")
    public BaseResponse subtract(@RequestBody BaseRequest request) {
        if (request.getNumber1()==null || request.getNumber2()==null) throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        logger.info("Attempt to do operation: " + number1 + "-" + number2);
        SubtractResponse response = calculatorServiceClient.subtract(number1, number2);
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2,response.getSubtractResult()));
    }
}
