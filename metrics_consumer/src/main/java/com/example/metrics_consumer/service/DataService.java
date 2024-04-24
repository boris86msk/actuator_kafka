package com.example.metrics_consumer.service;

import ru.openshcool.metrics_consumer.dto.MetricDto;

public interface DataService {
    void saveMetric(MetricDto metric, String topicName);
}
