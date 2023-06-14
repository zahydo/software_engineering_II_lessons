/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.unicauca.open_market_consumer_csv;

import co.unicauca.open_market_consumer_csv.domain.service.ConsumerService;
import co.unicauca.open_market_consumer_csv.domain.service.persistence.CsvWriter;
import co.unicauca.open_market_consumer_csv.infra.messaging.QueueConsumer;

/**
 *
 * @author RodAlejo
 */
public class Open_market_consumer_csv {

    public static void main(String[] args) {
        CsvWriter csvWriter = new CsvWriter();
        ConsumerService consumerService = new ConsumerService(csvWriter);
        QueueConsumer queueConsumer = new QueueConsumer(consumerService);
        queueConsumer.startConsuming();
    }
}
