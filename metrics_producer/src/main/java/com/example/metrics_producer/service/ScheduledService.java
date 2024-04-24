package com.example.metrics_producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScheduledService {
    private final ClientService clientService;
    private final KafkaTemplate<Object, Object> template;

    @Scheduled(fixedRate = 60000)
    public void getMetric() {
        Map actuatorMetrics = clientService.getCpuMetrics();
        Map healthMetrics = clientService.getHealthMetrics();
        actuatorMetrics.putAll(healthMetrics);
        template.send("health-topic", actuatorMetrics);
    }

}
