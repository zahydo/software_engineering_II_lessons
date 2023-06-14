package co.unicauca.openmarketConsumerDesktop.presentation.rabbitmq;

import co.unicauca.openmarketconsumerDesktop.domain.Constants;
import co.unicauca.openmarketConsumerDesktop.domain.service.ProductService;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

public class RabbitMQConsumer {
    private final ProductService eventService;

    public RabbitMQConsumer() {
        this.eventService = new ProductService();
    }

    public void startConsuming(Channel channel) throws Exception {
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        
        String queueName = channel.queueDeclare().getQueue();
         channel.queueBind(queueName, Constants.EXCHANGE_NAME, "");
         
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(" Processing message...");
            this.eventService.appendRow(this.eventService.parseMessage(message));
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}