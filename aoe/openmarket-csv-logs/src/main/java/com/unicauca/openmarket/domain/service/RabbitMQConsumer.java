package com.unicauca.openmarket.domain.service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Connection;

public class RabbitMQConsumer {
    private final String CSV_LOG_QUEUE = "csv-log-queue";
    private final String PRODUCT_EVENTS_EXCHANGE = "product-events-exchange";
    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;

    private IEventLogService eventLogService;

    public RabbitMQConsumer(IEventLogService eventLogService, String host, int port, String username, String password)
            throws IOException, TimeoutException {
        this.eventLogService = eventLogService;
        this.factory = new ConnectionFactory();
        this.factory.setHost(host);
        this.factory.setPort(port);
        this.factory.setUsername(username);
        this.factory.setPassword(password);

        this.connection = this.factory.newConnection();
        this.channel = this.connection.createChannel();
        this.channel.exchangeDeclare(PRODUCT_EVENTS_EXCHANGE, "fanout", true, false, null);
        this.channel.queueDeclare(CSV_LOG_QUEUE, true, false, false, null);
        this.channel.queueBind(CSV_LOG_QUEUE, PRODUCT_EVENTS_EXCHANGE, "");
    }

    public void startConsuming() throws IOException {
        // Crear el callback que se ejecutará cuando se reciba un mensaje
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String row = new String(message.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + row + "'");
            this.eventLogService.appendRow(row);

        };
        // Iniciar el consumo de mensajes
        this.channel.basicConsume(CSV_LOG_QUEUE, true, deliverCallback, consumerTag -> {
        });
    }

    public void stopConsuming() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}
