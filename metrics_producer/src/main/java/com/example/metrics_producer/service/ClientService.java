package com.example.metrics_producer.service;

import java.util.Map;

public interface ClientService {
    Map getHealthMetrics();
    Map getCpuMetrics();
}
