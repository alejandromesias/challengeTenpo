package com.alejandrom.example.tenpoChallenge.numbers;

import org.springframework.stereotype.Service;

@Service
public class NumbersService {

    public double getOperation(Integer num1, Integer num2){
        double factor = 1.2;
        return (num1.doubleValue() + num2.doubleValue()) * factor;
    }
}
