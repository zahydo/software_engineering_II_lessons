package co.unicauca.openmarketconsumercsv.domain.service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class EventLogService implements IEventLogService {
    
    private File archivo;
    
    public EventLogService(){
        this.archivo = new File("actionsProductsCSV");
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
        return message.split(message);
    }

    @Override
    public int addRow(String messageProccessed) {
        int countAddedRows = 0;
        try{
            // Escribir datos en el archivo CSV
            FileWriter escritor = new FileWriter(archivo, true); // El segundo parámetro 'true' indica que se agregará al final del archivo existente
            PrintWriter pw = new PrintWriter(escritor);

            // Escribir los datos en el archivo CSV
            pw.println(messageProccessed);

            pw.close();
            System.out.println("¡Datos guardados correctamente en el archivo CSV!"); 
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        return countAddedRows;
    }

}