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

    public double getOperation(double num1, double num2){
        return (num1 + num2) * externalFactorService.getFactor();
    }
}
