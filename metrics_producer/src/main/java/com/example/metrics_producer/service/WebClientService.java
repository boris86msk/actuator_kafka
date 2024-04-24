package com.example.metrics_producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WebClientService implements ClientService {

    private final WebClient webClient;

    @Override
    public Map getHealthMetrics() {
        return webClient
                .get()
                .uri("http://localhost:8078/actuator/health")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    @Override
    public Map getCpuMetrics() {
        return webClient
                .get()
                .uri("http://localhost:8078/actuator/metrics/system.cpu.usage")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }


}
