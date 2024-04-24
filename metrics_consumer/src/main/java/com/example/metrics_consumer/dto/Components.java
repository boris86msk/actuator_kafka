package com.example.metrics_consumer.dto;

import lombok.Data;

@Data
public class Components {
    private DiskSpace diskSpace;
    private Ping ping;
}
