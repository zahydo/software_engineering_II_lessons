package com.unicauca.consumercategory.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.unicauca.consumercategory.config.RabbitMQConfig;
import com.unicauca.consumercategory.domain.entity.CategoryEvent;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class RabbitMQConsumer {
    @Autowired
    ICategoryEventService categoryLogService;

    @Autowired
    private ICategoryRequestConsumerService categoryServiceConsumer;

    @RabbitListener(queues = RabbitMQConfig.DB_LOG_QUEUE)
    public void consumeMessageFromQueue(String message) {
        System.out.println("Message recieved from queue : " + message);
        CategoryEvent category = new CategoryEvent();
        String[] parts = message.split(",");
        if (parts.length == 5) {
            try {
                category.setId(Long.parseLong(parts[0]));
                category.setName(parts[1]);
                category.setDescription(parts[2]);
                category.setAction(parts[3]);
                category.setHolderEmail(parts[4]);
                categoryLogService.create(category);
                categoryServiceConsumer.sendCategoryRequest(category);
            } catch (HttpClientErrorException e) {
                System.err.println(e);
                throw new AmqpRejectAndDontRequeueException(e);
            } catch (Exception e) {
                throw new AmqpRejectAndDontRequeueException(e);
            }
        }
    }
}
