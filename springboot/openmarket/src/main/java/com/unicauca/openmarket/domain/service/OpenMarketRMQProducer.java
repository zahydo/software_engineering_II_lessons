package com.unicauca.openmarket.domain.service;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpenMarketRMQProducer {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    
    @Autowired
    public OpenMarketRMQProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }
    
    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Mensaje enviado: " + message);
    }
}
