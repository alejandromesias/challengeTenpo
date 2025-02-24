package com.alejandrom.example.tenpoChallenge.numbers;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalFactorService {

    private final RestClient restClient;

    public ExternalFactorService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    public double getFactor(){
        try {
            double retriedFactor = getRetriedFactor();
            saveInCache(retriedFactor);
            return retriedFactor;
        } catch (RuntimeException e){
            System.out.println("Returning cached Value");
            return cachedValue;
        }
    }

    private double getRetriedFactor() {
        int attempts = 0;
        while(attempts < 3) {
            try {
                return fetchedFactor();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                attempts++;
            }
        }
        throw new RuntimeException("Failed retries");
    }

    private double fetchedFactor() {
        Factor value = restClient.get()
                .uri("/factor")
                .retrieve()
                .body(Factor.class);
        return (value != null) ? value.factor : 1;
    }

    private double cachedValue;

    private void saveInCache(double value) {
        cachedValue = value;
    }
}
