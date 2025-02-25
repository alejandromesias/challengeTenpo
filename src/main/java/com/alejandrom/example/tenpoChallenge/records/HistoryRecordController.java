package com.alejandrom.example.tenpoChallenge.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "challenge/api/records")
public class HistoryRecordController {

    private final HistoryRecordService historyRecordService;

    @Autowired
    public HistoryRecordController(HistoryRecordService historyRecordService) {
        this.historyRecordService = historyRecordService;
    }

    @GetMapping
    public List<HistoryRecord> getRecords(){
        return historyRecordService.getRecords();
    }
}
