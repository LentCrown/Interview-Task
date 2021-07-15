package com.example.interview.services.impl;

import com.example.interview.services.CalculatorService;
import com.example.interview.soap.CalculatorServiceClient;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorServiceClient calculatorServiceClient;

    public CalculatorServiceImpl(CalculatorServiceClient calculatorServiceClient) {
        this.calculatorServiceClient = calculatorServiceClient;
    }

    @Override
    public int add(int intA, int intB) {
        return calculatorServiceClient.add(intA,intB).getAddResult();
    }

    @Override
    public int divide(int intA, int intB) {
        return calculatorServiceClient.divide(intA,intB).getDivideResult();
    }

    @Override
    public int multiply(int intA, int intB) {
        return calculatorServiceClient.multiply(intA,intB).getMultiplyResult();
    }

    @Override
    public int subtract(int intA, int intB) {
        return calculatorServiceClient.subtract(intA,intB).getSubtractResult();
    }
}
