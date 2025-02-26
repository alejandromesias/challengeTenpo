package com.alejandrom.example.tenpoChallenge.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryRecordService {
    private final HistoryRecordRepository historyRecordRepository;

    @Autowired
    public HistoryRecordService(HistoryRecordRepository historyRecordRepository) {
        this.historyRecordRepository = historyRecordRepository;
    }

    public void addNewRecord(String endpoint, double num1, double num2, double response){
//        HistoryRecord historyRecord = new HistoryRecord(LocalDateTime.now(),endpoint,num1,num2,response,"");
//        historyRecordRepository.save(historyRecord);
    }

    public List<HistoryRecord> getRecords(Integer page, Integer pageSize){
        Page<HistoryRecord> all = historyRecordRepository.findAll(PageRequest.of(page, pageSize));
        return all.stream().toList();
    }
}
