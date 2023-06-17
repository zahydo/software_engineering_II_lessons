package com.unicauca.openmarket.domain.service;

import com.unicauca.openmarket.access.repository.IEventLogRepository;

public class CsvEventLogService implements IEventLogService {

    private IEventLogRepository repository;

    public CsvEventLogService(IEventLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void appendRow(String row) {
        repository.appendRow(row);
    }
}
