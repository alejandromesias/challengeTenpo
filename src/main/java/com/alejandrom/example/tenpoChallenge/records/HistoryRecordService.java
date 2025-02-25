package com.alejandrom.example.tenpoChallenge.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class HistoryRecordService {
    private final HistoryRecordRepository historyRecordRepository;

    @Autowired
    public HistoryRecordService(HistoryRecordRepository historyRecordRepository) {
        this.historyRecordRepository = historyRecordRepository;
    }

    public void addNewRecord(String endpoint, int num1, int num2, double response){
        HistoryRecord historyRecord = new HistoryRecord(LocalDateTime.now(),endpoint,num1,num2,response,"");
        historyRecordRepository.save(historyRecord);
    }
}
