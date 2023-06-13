package co.unicauca.openmarketconsumercsv.domain.service;

public interface IEventLogService {
    String[]  proccessMessage(String message);
    void addRow(String[] messageProccessed);
}
