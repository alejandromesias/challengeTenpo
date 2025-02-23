package com.alejandrom.example.tenpoChallenge.numbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumbersService {

    private final ExternalFactorService externalFactorService;

    @Autowired
    public NumbersService(ExternalFactorService externalFactorService) {
        this.externalFactorService = externalFactorService;
    }

    public double getOperation(Integer num1, Integer num2){
        return (num1.doubleValue() + num2.doubleValue()) * externalFactorService.getFactor();
    }
}
