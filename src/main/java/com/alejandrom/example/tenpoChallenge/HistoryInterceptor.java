package com.alejandrom.example.tenpoChallenge;

import com.alejandrom.example.tenpoChallenge.records.HistoryRecord;
import com.alejandrom.example.tenpoChallenge.records.HistoryRecordRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;

@Component
public class HistoryInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(HistoryInterceptor.class);

    private final ExecutorService executorService;
    private final HistoryRecordRepository historyRecordRepository;

    public HistoryInterceptor(ExecutorService executorService, HistoryRecordRepository historyRecordRepository) {
        this.executorService = executorService;
        this.historyRecordRepository = historyRecordRepository;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        HistoryRecord record = new HistoryRecord(LocalDateTime.now(), request.getMethod(), request.getRequestURL().toString(), request.getQueryString(), response.getStatus());
        executorService.submit(() -> {
            try {
                historyRecordRepository.save(record);
            } catch (Exception e) {
                logger.error("Failed saving history record: {}", e.getMessage(), e);
            }
        });
    }
}
