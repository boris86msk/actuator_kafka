package com.example.metrics_producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient simpleWebClient() {
        return WebClient.create("http://localhost:8090");
    }
}
