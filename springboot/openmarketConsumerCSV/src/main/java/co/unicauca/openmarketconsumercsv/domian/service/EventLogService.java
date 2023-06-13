package co.unicauca.openmarketconsumercsv.domian.service;

import co.unicauca.openmarketconsumercsv.acces.repository.IEventLogRepository;

public class EventLogService implements IEventLogService {

    private IEventLogRepository repository;

    public EventLogService(IEventLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void appendRow(String row) {
        repository.appendRow(row);
    }
}