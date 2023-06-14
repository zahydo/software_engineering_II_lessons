package co.unicauca.open_market.config;

import javax.annotation.PostConstruct;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
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
        String queueCsvName = "open-market-products-csv";

        if (!queueExists(queueName)) {
            Queue queue = new Queue(queueName, true, false, false);
            queue.setShouldDeclare(true);

            queue.getArguments().put("x-argument", "value");

            rabbitAdmin.declareQueue(queue);
            
            Queue queueCsv = new Queue(queueCsvName, true, false, false);
            queueCsv.setShouldDeclare(true);

            queueCsv.getArguments().put("x-argument", "value");

            rabbitAdmin.declareQueue(queueCsv);
            
            
            // Crear un intercambio de tipo "fanout"
            FanoutExchange exchange = new FanoutExchange("open-market-products-exchange");
            rabbitAdmin.declareExchange(exchange);

            // Realizar la unión entre la cola y el intercambio
            Binding binding = BindingBuilder.bind(queue).to(exchange);
            rabbitAdmin.declareBinding(binding);
            
            Binding bindingCsv = BindingBuilder.bind(queueCsv).to(exchange);
            rabbitAdmin.declareBinding(bindingCsv);
        }
    }

    private boolean queueExists(String queueName) {
        return rabbitAdmin.getQueueProperties(queueName) != null;
    }
}