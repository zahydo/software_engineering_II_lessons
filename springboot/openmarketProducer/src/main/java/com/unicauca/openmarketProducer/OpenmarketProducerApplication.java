package com.unicauca.openmarketProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unicauca.openmarketProducer.domain.service.OpenMarketRMQProducer;

@SpringBootApplication
public class OpenmarketProducerApplication {
	private final OpenMarketRMQProducer OMProducer;
	private final OpenMarketRMQConfig OMConfig;
	private final static String QUEUE_NAME = "OM Products";

	@Autowired
    public OpenmarketProducerApplication(OpenMarketRMQProducer OMProducer) {
        this.OMProducer = OMProducer;
    }

	public static void main(String[] args) {

		ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(spring.rabbitmq.host);

        try (
				Connection connection = factory.newConnection();
				Channel channel = connection.createChannel()
			) 
		{
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = argv.length > 0 ? String.join(" ", argv) : "default message";
            channel.basicPublish("", QUEUE_NAME, null,
                    message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }
		//SpringApplication.run(OpenmarketApplication.class, args);
	}



}
