package co.unicauca.openmarketconsumercsv.acces.repository;


public interface IEventLogRepository {

    /**
     * Appends a row to the log repository.
     * 
     * @param row
     */
    void appendRow(String row);

}