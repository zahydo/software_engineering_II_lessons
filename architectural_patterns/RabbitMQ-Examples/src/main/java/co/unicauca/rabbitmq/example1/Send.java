package co.unicauca.rabbitmq.example1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import co.unicauca.rabbitmq.utils.Constants;

import java.nio.charset.StandardCharsets;

public class Send {

    private final static String QUEUE_NAME = "hello";


        //genero una fabrica 
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        try (
                Connection connection = factory.newConnection();
                //genero nuevo canal
                Channel channel = connection.createChannel()) {
            //declaro la cola debe ser igual a la otra 
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
           //se envia unmesaje en bits y termina
            String message = argv.length > 0 ? String.join(" ", argv) : "default message";
            channel.basicPublish("", QUEUE_NAME, null,
                    message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}