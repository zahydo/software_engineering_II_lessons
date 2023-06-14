package co.unicauca.open_market_consumer.domain.service;

import co.unicauca.open_market_consumer.access.dao.ILogEntryRepository;
import co.unicauca.open_market_consumer.domain.entity.LogEntry;
import co.unicauca.open_market_consumer.domain.entity.MessageData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final ILogEntryRepository logEntryRepository;

    @Autowired
    public ConsumerService(ILogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    public void receiveMessage(String message) {
        System.out.println("Mensaje recibido: " + message);

        try {
            LogEntry logEntry = parseMessageToLogEntry(message);
            logEntryRepository.save(logEntry);
            System.out.println("Registro guardado en la base de datos: " + logEntry);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al procesar el mensaje: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado al procesar el mensaje: " + e.getMessage());

        }
    }

    private LogEntry parseMessageToLogEntry(String message) {
        Gson gson = new Gson();
        String cleanedMessage = message.substring(1, message.length() - 1);
        String cleanJsonString = cleanedMessage.replace("\\\"", "'");
        LogEntry logEntry = gson.fromJson(cleanJsonString, LogEntry.class);

        return logEntry;
    }

}
