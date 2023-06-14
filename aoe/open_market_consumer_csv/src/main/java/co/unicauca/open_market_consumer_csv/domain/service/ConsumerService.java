/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.open_market_consumer_csv.domain.service;

import co.unicauca.open_market_consumer_csv.domain.persistence.CsvWriter;

/**
 *
 * @author RodAlejo
 */


public class ConsumerService {

    private final CsvWriter csvWriter;

    public ConsumerService(CsvWriter csvWriter) {
        this.csvWriter = csvWriter;
    }

    public void processMessage(String message) {
        // Aquí puedes realizar cualquier lógica adicional antes de escribir en el archivo CSV
        csvWriter.writeMessageToCSV(message);
    }
}