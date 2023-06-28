package com.unicauca.producercategory.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.producercategory.config.RabbitMQConfig;
import com.unicauca.producercategory.domain.entity.Category;

import org.springframework.amqp.core.AmqpTemplate;

@Service
public class RabbitMQProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(Category category, String action) {
        String message = category.getId() + "," + category.getName() + "," + category.getDescription() + "," + action
                + ","
                + category.getHolderEmail();
        rabbitTemplate.convertAndSend(RabbitMQConfig.CATEGORY_EVENTS_EXCHANGE, "", message);
    }
}
