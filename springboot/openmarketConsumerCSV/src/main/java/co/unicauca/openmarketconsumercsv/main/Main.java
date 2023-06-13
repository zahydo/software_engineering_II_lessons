package co.unicauca.openmarketconsumercsv.main;

import co.unicauca.openmarketconsumercsv.acces.repository.IEventLogRepository;
import co.unicauca.openmarketconsumercsv.acces.repository.EventLogRepository;
import co.unicauca.openmarketconsumercsv.domian.service.IEventLogService;
import co.unicauca.openmarketconsumercsv.domian.service.EventLogService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) {
        IEventLogRepository eventLogRepository = new EventLogRepository();
        IEventLogService eventLogService = new EventLogService(eventLogRepository);
        RabbitMQConsumer consumer;
        try {
            consumer = new RabbitMQConsumer(eventLogService, "localhost", 5672, "guest", "guest");
            consumer.startConsuming();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}