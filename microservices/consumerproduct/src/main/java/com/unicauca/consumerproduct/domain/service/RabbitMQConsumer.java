package com.unicauca.consumerproduct.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.unicauca.consumerproduct.config.RabbitMQConfig;
import com.unicauca.consumerproduct.domain.entity.ProductEvent;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Component
public class RabbitMQConsumer {
    @Autowired
    IProductEventService productLogService;

    @Autowired
    private IProductRequestConsumerService productServiceConsumer;

    @RabbitListener(queues = RabbitMQConfig.DB_LOG_QUEUE)
    public void consumeMessageFromQueue(String message) {
        System.out.println("Message recieved from queue : " + message);
        ProductEvent product = new ProductEvent();
        String[] parts = message.split(",");
        if (parts.length == 5) {
            try {
                product.setId(Long.parseLong(parts[0]));
                product.setName(parts[1]);
                product.setPrice(Double.parseDouble(parts[2]));
                product.setAction(parts[3]);
                product.setHolderEmail(parts[4]);
                productLogService.create(product);
                productServiceConsumer.sendProductRequest(product);
            } catch (HttpClientErrorException e) {
                System.err.println(e);
                throw new AmqpRejectAndDontRequeueException(e);
            } catch (Exception e) {
                throw new AmqpRejectAndDontRequeueException(e);
            }
        }
    }
}
