package com.example.interview.config;

import com.example.interview.soap.CalculatorServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CalculatorClientConfig {
    private final static String DEFAULT_CONTEXT_PATH = "com.example.interview.soap.calculator";
    private final static String DEFAULT_URI = "http://www.dneonline.com/calculator.asmx";

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(DEFAULT_CONTEXT_PATH);
        return marshaller;
    }

    @Bean
    public CalculatorServiceClient soapConnector(Jaxb2Marshaller marshaller) {
        CalculatorServiceClient client = new CalculatorServiceClient();
        client.setDefaultUri(DEFAULT_URI);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
