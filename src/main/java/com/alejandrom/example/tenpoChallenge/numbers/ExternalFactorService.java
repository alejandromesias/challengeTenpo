package com.alejandrom.example.tenpoChallenge.numbers;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExternalFactorService {

    private final RestClient restClient;

    public ExternalFactorService() {
        this.restClient = RestClient.builder()
                // TODO: this should be injected as an env var
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

    // TODO: check if the library has retries already
    private double getRetriedFactor() {
        int attempts = 0;
        while(attempts < 3) {
            try {
                return fetchedFactor();
            } catch (Exception e) {
                // TODO: use logs
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
        return (value != null) ? value.factor() : 1;
    }

    // TODO: should this be a distributed cache?
    // TODO: invalidate cache every 30 mins
    private double cachedValue;

    private void saveInCache(double value) {
        cachedValue = value;
    }
}
