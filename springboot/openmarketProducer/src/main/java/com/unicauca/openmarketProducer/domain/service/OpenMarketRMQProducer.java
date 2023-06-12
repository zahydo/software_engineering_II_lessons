package com.unicauca.openmarketProducer.domain.service;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unicauca.openmarketProducer.domain.entity.Product;

@Component
public class OpenMarketRMQProducer {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    
    @Autowired
    public OpenMarketRMQProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }
    
    public void sendMessage(String action, Product product) {
        String message = action+","+product.getId()+","+product.getName()+","+product.getPrice();
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Mensaje enviado: Action:" +action+"| Product info: Id:"+product.getId()+
                            ", Name:"+product.getName()+", Price:"+product.getPrice());
    }
}
