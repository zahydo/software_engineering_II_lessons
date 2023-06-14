package co.unicauca.openmarketConsumerDesktop.domain.service;

public interface IProductService {
    String[]  parseMessage(String message);
    void appendRow(String[] processedMessage);
}
