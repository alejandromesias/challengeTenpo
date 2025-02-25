package com.alejandrom.example.tenpoChallenge.records;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class HistoryRecord {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private LocalDateTime dateTime;
    private String endpoint;
    private int num1;
    private int num2;
    private double response;
    private String error;

    public HistoryRecord() {
    }

    public HistoryRecord(LocalDateTime dateTime, String endpoint, int num1, int num2, double response, String error) {
        this.dateTime = dateTime;
        this.endpoint = endpoint;
        this.num1 = num1;
        this.num2 = num2;
        this.response = response;
        this.error = error;
    }
}
