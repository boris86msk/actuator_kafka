package com.example.metrics_consumer.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.openshcool.metrics_consumer.dto.MetricDto;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerService implements ListenerService {
    private final DataService dataService;

    @Override
    @KafkaListener(id = "metricsGroup", topics = "health-topic")
    public void listen(String metric) {
        log.info("Consumer принял метрики: {}", metric);
        MetricDto metricDto = new Gson().fromJson(metric, MetricDto.class);
        dataService.saveMetric(metricDto, "health-topic");
    }

}
