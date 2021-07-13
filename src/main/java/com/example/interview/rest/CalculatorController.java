package com.example.interview.rest;

import com.example.interview.dto.BaseRequest;
import com.example.interview.dto.BaseResponse;
import com.example.interview.dto.Result;
import com.example.interview.rest.exception.DivideByZeroException;
import com.example.interview.rest.exception.SkippedArgumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2,number1*number2));
    }

    @GetMapping("/div")
    public BaseResponse divide(@RequestBody BaseRequest request) {
        if (request.getNumber1()==null || request.getNumber2()==null) throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        logger.info("Attempt to do operation: " + number1 + "/" + number2);
        if (number2 == 0) throw new DivideByZeroException();
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2,number1*number2));
    }

    @GetMapping("/mul")
    public BaseResponse multiply(@RequestBody BaseRequest request) {
        if (request.getNumber1()==null || request.getNumber2()==null) throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        logger.info("Attempt to do operation: " + number1 + "*" + number2);
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2,number1*number2));
    }

    @GetMapping("/sub")
    public BaseResponse subtract(@RequestBody BaseRequest request) {
        if (request.getNumber1()==null || request.getNumber2()==null) throw new SkippedArgumentException("You forgot to specify argument(s)");
        int number1 = request.getNumber1();
        int number2 = request.getNumber2();
        logger.info("Attempt to do operation: " + number1 + "-" + number2);
        return new BaseResponse(new Timestamp(System.currentTimeMillis()),SUCCESS_STATUS, new Result(number1,number2,number1*number2));
    }
}
