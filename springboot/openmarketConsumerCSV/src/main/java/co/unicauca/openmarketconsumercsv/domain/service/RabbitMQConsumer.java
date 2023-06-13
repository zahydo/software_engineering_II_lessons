package co.unicauca.openmarketconsumercsv.domain.service;



import Utils.Constants;
import java.io.IOException;
import java.nio.channels.Channel;
import java.sql.Connection;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitMQConsumer {
    
    private final static String QUEUE_NAME = "OMProducts";
    private EventLogService eventService;
    
    public RabbitMQConsumer(){
        this.eventService = new EventLogService();
    }

    public void startConsuming() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        com.rabbitmq.client.Connection connection = factory.newConnection();
        com.rabbitmq.client.Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(" Processing message...");
            this.eventService.addRow(message);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
}