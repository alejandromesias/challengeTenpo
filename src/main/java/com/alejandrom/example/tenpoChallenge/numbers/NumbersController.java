package com.alejandrom.example.tenpoChallenge.numbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "challenge/api/numbers")
public class NumbersController {

    private final NumbersService numbersService;

    @Autowired
    public NumbersController(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @GetMapping
    public double getResult(@RequestParam Integer num1, @RequestParam Integer num2){
        return numbersService.getOperation(num1, num2);
    }
}
