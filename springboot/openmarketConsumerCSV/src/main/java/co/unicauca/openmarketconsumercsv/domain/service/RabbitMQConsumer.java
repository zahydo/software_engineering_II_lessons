package co.unicauca.openmarketconsumercsv.domain.service;



import Utils.Constants;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class RabbitMQConsumer {
    
    private final static String EXCHANGE_NAME = "OMProducts";
    private EventLogService eventService;
    
    public RabbitMQConsumer(){
        this.eventService = new EventLogService();
    }

    public void startConsuming() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(Constants.HOST_NAME);
        
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, Constants.EXCHANGE_TYPE);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            System.out.println(" Processing message...");
            this.eventService.addRow(this.eventService.proccessMessage(message));
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}