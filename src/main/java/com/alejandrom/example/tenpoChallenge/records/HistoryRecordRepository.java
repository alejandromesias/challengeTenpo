package com.alejandrom.example.tenpoChallenge.records;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRecordRepository
        extends JpaRepository<HistoryRecord, Long> {
}
