package com.alejandrom.example.tenpoChallenge.numbers;

import com.alejandrom.example.tenpoChallenge.records.HistoryRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "challenge/api/numbers")
public class NumbersController {

    private final NumbersService numbersService;
    private final HistoryRecordService historyRecordService;

    @Autowired
    public NumbersController(NumbersService numbersService, HistoryRecordService historyRecordService) {
        this.numbersService = numbersService;
        this.historyRecordService = historyRecordService;
    }

    @GetMapping
    public double getResult(@RequestParam double num1, @RequestParam double num2){
        double response = numbersService.getOperation(num1, num2);
        historyRecordService.addNewRecord("challenge/api/numbers", num1, num2, response);
        return response;
    }
}
