package com.alejandrom.example.tenpoChallenge;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private HistoryInterceptor historyInterceptor;

    public WebConfig(HistoryInterceptor historyInterceptor) {
        this.historyInterceptor = historyInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(historyInterceptor);
    }
}
