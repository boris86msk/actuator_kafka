package com.example.metrics_consumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.metrics_consumer.dto.Measurements;
import com.example.metrics_consumer.dto.MetricDto;
import com.example.metrics_consumer.model.MetricModel;
import com.example.metrics_consumer.repository.MetricsRepository;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class JpaDataService implements DataService {
    private final MetricsRepository metricsRepository;

    @Override
    public void saveMetric(MetricDto metricDto, String topicName) {
        MetricModel metricModel = new MetricModel();
        metricModel.setTopic_name(topicName);
        metricModel.setMeasuring(LocalDateTime.now());
        Measurements[] measurements = metricDto.getMeasurements();
        Measurements measurement = measurements[0];
        float value = measurement.getValue();
        metricModel.setPercentage(value);
        metricModel.setStatus(metricDto.getStatus());
        metricModel.setDiscTotal(metricDto.getComponents().getDiskSpace().getDetails().getTotal());
        metricModel.setDiscFree(metricDto.getComponents().getDiskSpace().getDetails().getFree());
        metricModel.setPingStatus(metricDto.getComponents().getPing().getStatus());

        if(metricsRepository.save(metricModel).getId() < 1) {
            log.info("Неудалось сохранить значения {}", metricModel.getMeasuring());
        };
    }
}
