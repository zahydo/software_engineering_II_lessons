package com.unicauca.openmarket;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.unicauca.openmarketConsumer.domain.service.ProductServiceImpl;
import com.unicauca.openmarketConsumer.domain.service.RabbitMQConsumer;
import com.unicauca.utils.Constants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpenmarketConsumerApplication {
	private final static String EXCHANGES_NAME = "logs";
    //private static ProccessMessageService proccessMessage = new ProccessMessageService(new ActionProductsServiceImpl());
	public static void main(String[] args) throws Exception{
		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGES_NAME, Constants.EXCHANGE_TYPE);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGES_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(" Processing message...");
            //proccessMessage.procesarMensaje(message);
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
		SpringApplication.run(OpenmarketConsumerApplication.class, args);
	}
}
