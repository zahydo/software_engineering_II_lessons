package com.unicauca.openmarket.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unicauca.openmarket.config.RabbitMQConfig;
import com.unicauca.openmarket.domain.entity.ProductEvent;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class RabbitMQConsumer {
    @Autowired
    IProductEventService productLogService;

    @RabbitListener(queues = RabbitMQConfig.DB_LOG_QUEUE)
    public void consumeMessageFromQueue(String message) {
        System.out.println("Message recieved from queue : " + message);
        ProductEvent product = new ProductEvent();
        String[] parts = message.split(",");
        if (parts.length == 4) {
            try {
                product.setId(Long.parseLong(parts[0]));
                product.setName(parts[1]);
                product.setPrice(Double.parseDouble(parts[2]));
                product.setAction(parts[3]);
                productLogService.create(product);
            } catch (Exception e) {
                throw new AmqpRejectAndDontRequeueException(e);
            }
        }
    }
}
