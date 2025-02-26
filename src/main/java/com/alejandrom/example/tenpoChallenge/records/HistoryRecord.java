package com.alejandrom.example.tenpoChallenge.records;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
// TODO: this should be a java record
public class HistoryRecord {
    @Id
    @SequenceGenerator(
            name = "history_sequence",
            sequenceName = "history_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "history_sequence"
    )
    private Long id;
    private LocalDateTime dateTime;
    private String method;
    private String path;
    private String params;
    private Integer responseCode;

    public HistoryRecord() {
    }

    public HistoryRecord(LocalDateTime dateTime, String method, String path, String params, Integer responseCode) {
        this.dateTime = dateTime;
        this.method = method;
        this.path = path;
        this.params = params;
        this.responseCode = responseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
}
