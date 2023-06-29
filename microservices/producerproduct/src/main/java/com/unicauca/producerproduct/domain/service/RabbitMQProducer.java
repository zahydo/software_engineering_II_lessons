package com.unicauca.producerproduct.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.producerproduct.config.RabbitMQConfig;
import com.unicauca.producerproduct.domain.entity.Product;

import org.springframework.amqp.core.AmqpTemplate;

@Service
public class RabbitMQProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Product product, String action) {
        String message = product.getId() + "," + product.getName() + "," + product.getPrice() + "," + action + ","
                + product.getHolderEmail();
        rabbitTemplate.convertAndSend(RabbitMQConfig.PRODUCT_EVENTS_EXCHANGE, "", message);
    }
}
