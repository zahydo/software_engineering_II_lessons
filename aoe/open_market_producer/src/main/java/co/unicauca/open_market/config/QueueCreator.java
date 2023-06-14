package co.unicauca.open_market.config;

import javax.annotation.PostConstruct;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class QueueCreator {

    private final RabbitAdmin rabbitAdmin;

    @Autowired
    public QueueCreator(RabbitAdmin rabbitAdmin) {
        this.rabbitAdmin = rabbitAdmin;
    }

    @PostConstruct
    public void createQueueOpenMarketProducts() {
        String queueName = "open-market-products";

        if (!queueExists(queueName)) {
            Queue queue = new Queue(queueName, true, false, false);
            queue.setShouldDeclare(true);

            queue.getArguments().put("x-argument", "value");

            rabbitAdmin.declareQueue(queue);
        }
    }

    private boolean queueExists(String queueName) {
        return rabbitAdmin.getQueueProperties(queueName) != null;
    }
}