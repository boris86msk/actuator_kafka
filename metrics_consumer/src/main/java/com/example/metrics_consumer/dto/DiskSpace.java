package com.example.metrics_consumer.dto;

import lombok.Data;

@Data
public class DiskSpace {
    private String status;
    private Details details;
}
