package com.example.metrics_consumer.dto;

import lombok.Data;

@Data
public class Details {
    private long total;
    private long free;
    private long threshold;
    private String path;
    private boolean exists;
}
