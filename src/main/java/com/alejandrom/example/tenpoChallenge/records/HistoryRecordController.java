package com.alejandrom.example.tenpoChallenge.records;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "challenge/api/records")
// TODO: OpenAPI spec documentation
public class HistoryRecordController {

    private final HistoryRecordService historyRecordService;

    @Autowired
    public HistoryRecordController(HistoryRecordService historyRecordService) {
        this.historyRecordService = historyRecordService;
    }

    @GetMapping
    // TODO: this should be paginated
    public List<HistoryRecord> getRecords(@RequestParam Integer page, @RequestParam Integer pageSize){
        return historyRecordService.getRecords(page, pageSize);
    }
}
