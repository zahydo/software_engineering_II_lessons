
package co.edu.unicauca.openmarket.access;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;

public interface ICategoryRepository {
    boolean save(Category newCategory);
    
    boolean edit(Long id, Category category);
    
    boolean delete(Long id);

    Category findById(Long id);
    
    List<Category> findAll();
    
    Category findByName(String name);
}
