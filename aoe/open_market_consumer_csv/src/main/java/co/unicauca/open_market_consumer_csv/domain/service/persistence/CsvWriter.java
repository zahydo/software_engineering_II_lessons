/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.open_market_consumer_csv.domain.service.persistence;

import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author RodAlejo
 */


public class CsvWriter {

    private static final String CSV_FILE_PATH = "peticiones.csv";

    public void writeMessageToCSV(String message) {
        
        String cleanedMessage = message.substring(1, message.length() - 1);
        String cleanJsonString = cleanedMessage.replace("\\\"", "'");
        
        try (FileWriter writer = new FileWriter(CSV_FILE_PATH, true)) {
            writer.append(cleanJsonString);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}