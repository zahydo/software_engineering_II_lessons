package co.unicauca.openmarketconsumercsv.domain.service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


public class EventLogService implements IEventLogService {
    
    private File archivo;
    
    public EventLogService(){
        this.archivo = new File("actionsProductsCSV.csv");
        createFile();
    }
    
    public void createFile(){
        try{   
            //Verificar si el archivo CSV ya existe
            if (this.archivo.exists()) {
                System.out.println("El archivo actionsProductsCSV ya existe.");
            } else {
                // Crear el archivo CSV si no existe
                this.archivo.createNewFile();
                System.out.println("Archivo actionsProductsCSV creado correctamente.");
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    
    @Override
    public String[] proccessMessage(String message) {
        if(message.length() <= 0){
            return null;
        }
        return message.split(",");
    }

    @Override
    public void addRow(String[] messageProccessed) {
        try{
            // Escribir datos en el archivo CSV
            String[] valor = messageProccessed;
            FileWriter escritor = new FileWriter(archivo, true); // El segundo parámetro 'true' indica que se agregará al final del archivo existente
            PrintWriter pw = new PrintWriter(escritor);
            CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("ACTION", "ID", "PRODUCT NAME", "PRICE");
            CSVPrinter csvPrinter = new CSVPrinter(pw, csvFormat);

            // Escribir los datos en el archivo CSV
            csvPrinter.printRecord(messageProccessed[0],messageProccessed[1],messageProccessed[2],messageProccessed[3]);

            csvPrinter.flush();
            csvPrinter.close();
            System.out.println("¡Datos guardados correctamente en el archivo CSV!"); 
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

}