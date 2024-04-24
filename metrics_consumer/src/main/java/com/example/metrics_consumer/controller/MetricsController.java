package com.example.metrics_consumer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.metrics_consumer.model.MetricModel;
import com.example.metrics_consumer.repository.MetricsRepository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MetricsController {
    private final MetricsRepository metricsRepository;

    @GetMapping("/metrics")
    public List<MetricModel> getAllMetrics() {
        return metricsRepository.findAll();
    }

    @GetMapping("/metrics/{id}")
    public MetricModel getMetricById(@PathVariable Long id) {
        Optional<MetricModel> byId = metricsRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException();
        }
        return byId.get();
    }

    @ExceptionHandler(value = {Exception.class})
    public void catchDataIntegrityViolationException(Exception e, HttpServletRequest request,
                                                     HttpServletResponse response) throws IOException {
        Map<String, String> details = new HashMap<>();
        details.put("message", e.getMessage());
        details.put("type", String.valueOf(e.getClass()));
        details.put("timestamp", String.valueOf(LocalDateTime.now()));
        details.put("path", request.getRequestURI());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(details));
        log.error(e.getLocalizedMessage());
    }

}
