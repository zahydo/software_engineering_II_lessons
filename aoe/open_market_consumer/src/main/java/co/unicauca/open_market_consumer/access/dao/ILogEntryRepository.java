
package co.unicauca.open_market_consumer.access.dao;
import co.unicauca.open_market_consumer.domain.entity.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author RodAlejo
 */
@Repository
public interface ILogEntryRepository extends JpaRepository<LogEntry, Long> {
    
}
