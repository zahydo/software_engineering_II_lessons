package com.unicauca.openmarket.domain.service;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenMarketRMQConfig {
    @Bean
    public Queue queue(String nombreCola) {
        return new Queue(nombreCola);
    }
}
