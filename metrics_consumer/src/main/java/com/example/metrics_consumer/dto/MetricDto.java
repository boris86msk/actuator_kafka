package com.example.metrics_consumer.dto;

import lombok.Data;

@Data
public class MetricDto {
    private Measurements[] measurements;
    private String status;
    private Components components;
}
