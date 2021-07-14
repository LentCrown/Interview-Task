package com.example.interview.soap;

import com.example.interview.soap.calculator.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorServiceClient extends WebServiceGatewaySupport {
    private static final String SOAP_ACTION_ADD = "http://tempuri.org/Add";
    private static final String SOAP_ACTION_DIVIDE = "http://tempuri.org/Divide";
    private static final String SOAP_ACTION_MULTIPLY = "http://tempuri.org/Multiply";
    private static final String SOAP_ACTION_SUBTRACT = "http://tempuri.org/Subtract";

    public AddResponse add(int intA, int intB){
        Add request = new Add();
        request.setIntA(intA);
        request.setIntB(intB);
        return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(request,new SoapActionCallback(SOAP_ACTION_ADD));
    }

    public DivideResponse divide(int intA, int intB){
        Divide request = new Divide();
        request.setIntA(intA);
        request.setIntB(intB);
        return (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(request,new SoapActionCallback(SOAP_ACTION_DIVIDE));
    }

    public MultiplyResponse multiply(int intA, int intB){
        Multiply request = new Multiply();
        request.setIntA(intA);
        request.setIntB(intB);
        return (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(request,new SoapActionCallback(SOAP_ACTION_MULTIPLY));
    }

    public SubtractResponse subtract(int intA, int intB){
        Subtract request = new Subtract();
        request.setIntA(intA);
        request.setIntB(intB);
        return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(request,new SoapActionCallback(SOAP_ACTION_SUBTRACT));
    }
}
