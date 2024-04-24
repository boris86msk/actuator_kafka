package com.example.metrics_consumer.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "metric")
public class MetricModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic_name;

    private LocalDateTime measuring;

    @Column(name = "cpu_usage")
    private float percentage;

    private String status;

    @Column(name = "disc_total")
    private Long discTotal;

    @Column(name = "disc_free")
    private Long discFree;

    @Column(name = "ping_status")
    private String pingStatus;
}
