/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.open_market_consumer.infra.messaging;
import co.unicauca.open_market_consumer.domain.service.ConsumerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @author RodAlejo
 */

@Component
public class QueueConsumer {

    private final RabbitAdmin rabbitAdmin;
    private final ConsumerService consumerService;

    @Autowired
    public QueueConsumer(RabbitAdmin rabbitAdmin, ConsumerService consumerService) {
        this.rabbitAdmin = rabbitAdmin;
        this.consumerService = consumerService;
    }

    @RabbitListener(queues = "open-market-products")
    public void receiveMessage(String message) {
        if (queueExists("open-market-products")) {
            consumerService.receiveMessage(message);
        }
    }

    private boolean queueExists(String queueName) {
        return rabbitAdmin.getQueueProperties(queueName) != null;
    }
}