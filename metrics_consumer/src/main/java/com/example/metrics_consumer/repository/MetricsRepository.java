package com.example.metrics_consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.openshcool.metrics_consumer.model.MetricModel;

@Repository
public interface MetricsRepository extends JpaRepository<MetricModel, Long> {
}
