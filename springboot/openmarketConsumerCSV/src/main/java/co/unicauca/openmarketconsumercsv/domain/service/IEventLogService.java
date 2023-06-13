package co.unicauca.openmarketconsumercsv.domain.service;

public interface IEventLogService {
    String[]  proccessMessage(String message);
    int addRow(String messageProccessed);
}
