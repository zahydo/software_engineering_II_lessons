package com.unicauca.openmarket.main;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.unicauca.openmarket.access.repository.CsvEventLogRepository;
import com.unicauca.openmarket.access.repository.IEventLogRepository;
import com.unicauca.openmarket.domain.service.CsvEventLogService;
import com.unicauca.openmarket.domain.service.IEventLogService;
import com.unicauca.openmarket.domain.service.RabbitMQConsumer;

public class Main {
    public static void main(String[] args) {
        IEventLogRepository eventLogRepository = new CsvEventLogRepository();
        IEventLogService eventLogService = new CsvEventLogService(eventLogRepository);
        eventLogService.appendRow("ID,Nombre,Precio,Accion");
        RabbitMQConsumer consumer;
        try {
            consumer = new RabbitMQConsumer(eventLogService, "localhost", 5672, "guest", "guest");
            consumer.startConsuming();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
