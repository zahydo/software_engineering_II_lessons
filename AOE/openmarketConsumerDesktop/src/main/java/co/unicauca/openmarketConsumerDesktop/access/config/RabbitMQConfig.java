package co.unicauca.openmarketConsumerDesktop.access.config;


import co.unicauca.openmarketconsumerDesktop.domain.Constants;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        return factory;
    }

    @Bean
    public Connection connection(ConnectionFactory connectionFactory) throws Exception {
        return connectionFactory.newConnection();
    }

    @Bean
    public Channel channel(Connection connection) throws Exception {
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Constants.EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, Constants.EXCHANGE_NAME, "");
        return channel;
    }
}