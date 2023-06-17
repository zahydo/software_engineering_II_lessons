package com.unicauca.openmarket.access.repository;

import java.io.FileOutputStream;
import java.io.IOException;

public class CsvEventLogRepository implements IEventLogRepository {
    @Override
    public void appendRow(String row) {
        String fileName = "events.csv";
        row = row + "\n";

        try (FileOutputStream fos = new FileOutputStream(fileName, true)) {
            byte[] contentBytes = row.getBytes();
            fos.write(contentBytes);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
