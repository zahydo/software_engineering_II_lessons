package co.unicauca.openmarketconsumercsv.main;

import co.unicauca.openmarketconsumercsv.domain.service.RabbitMQConsumer;

public class OpenMarketCSV {
    
    
    public static void main(String[] args) throws Exception {
        RabbitMQConsumer consumer = new RabbitMQConsumer();
        
        consumer.startConsuming();
        
    }
}