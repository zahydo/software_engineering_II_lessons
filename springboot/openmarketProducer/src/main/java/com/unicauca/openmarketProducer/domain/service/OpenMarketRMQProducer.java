package com.unicauca.openmarketProducer.domain.service;
import java.nio.charset.StandardCharsets;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.unicauca.openmarketProducer.utils.Constants;

import com.unicauca.openmarketProducer.domain.entity.Product;

@Component
public class OpenMarketRMQProducer {
    private final static String QUEUE_NAME = "OM Products";
    ConnectionFactory factory;
    @Autowired
    public OpenMarketRMQProducer() {
        factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
    }

    public void sendMessage(String action, Product product)throws Exception{
        try (
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel();
			) 
		{
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = action+","+product.getId()+","+product.getName()+","+product.getPrice(); 
			System.out.println("Informacion a enviar: Action:" +action+"| Product info: Id:"+product.getId()+
                            ", Name:"+product.getName()+", Price:"+product.getPrice());

			if(message.length() < 0){
				message = "default message";
			} 

            channel.basicPublish("", QUEUE_NAME, null,
                    message.getBytes(StandardCharsets.UTF_8));

            System.out.println(" [x] Sent '" + message + "'");
			
        }
    }
}
