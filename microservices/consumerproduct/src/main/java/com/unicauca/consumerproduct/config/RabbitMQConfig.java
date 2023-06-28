package com.unicauca.consumerproduct.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String PRODUCT_EVENTS_EXCHANGE = "product-events-exchange";
    public static final String DB_LOG_QUEUE = "database-log-queue";

    @Bean
    public FanoutExchange product_events_exchange() {
        return new FanoutExchange(PRODUCT_EVENTS_EXCHANGE);
    }

    @Bean
    public Queue db_log_queue() {
        return new Queue(DB_LOG_QUEUE);
    }

    @Bean
    public Binding binding2(Queue db_log_queue, FanoutExchange product_events_exchange) {
        return BindingBuilder.bind(db_log_queue).to(product_events_exchange);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new SimpleMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
