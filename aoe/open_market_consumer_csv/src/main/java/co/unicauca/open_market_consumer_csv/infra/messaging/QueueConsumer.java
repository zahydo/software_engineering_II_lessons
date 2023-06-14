/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.open_market_consumer_csv.infra.messaging;

import co.unicauca.open_market_consumer_csv.domain.service.ConsumerService;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class QueueConsumer {

    private static final String QUEUE_NAME = "open-market-products";
    private final ConsumerService consumerService;

    public QueueConsumer(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    public void startConsuming() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            // Verificar la existencia de la cola
            channel.queueDeclarePassive(QUEUE_NAME);

            System.out.println("Esperando mensajes...");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("Mensaje recibido: " + message);

                    consumerService.processMessage(message);
                }
            };

            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            // La cola no existe
            System.err.println("La cola no existe. Inicie open_market_producer.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}