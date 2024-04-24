package com.example.metrics_consumer.dto;

import lombok.Data;

@Data
public class Measurements {
    private String statistic;
    private float value;
}
