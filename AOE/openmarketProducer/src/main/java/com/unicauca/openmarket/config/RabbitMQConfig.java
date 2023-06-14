package com.unicauca.openmarket.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.unicauca.openmarket.domain.entity.Product;
import com.unicauca.openmarket.util.Constants;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.stereotype.Component;

@Component
public class RabbitMQConfig implements IRabbitMQConfig {
    private static final String EXCHANGE_NAME = "logs";

   @Override
    public void connection(Product product, String action) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);

            String message = action + ": " + product.getId()+","+product.getName()+","+product.getPrice()+","+product.getDescription();
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (IOException exception) {
            System.err.println("Error al enviar el mensaje: " + exception.getMessage());
            throw exception;
        }
    }
}
