package com.example.metrics_consumer.service;

import com.example.metrics_consumer.dto.MetricDto;

public interface DataService {
    void saveMetric(MetricDto metric, String topicName);
}
