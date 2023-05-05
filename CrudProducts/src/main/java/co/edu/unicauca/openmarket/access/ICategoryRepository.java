package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;
/**
 *
 * @author BRey
 */
public interface ICategoryRepository {
    boolean save(Category newCategory);
    
    boolean edit(Long categoryId, Category category);
    
    boolean delete(Long categoryId);

    Category findById(Long categoryId);
    
    Category findByName(String name);
    
    List<Category> findAll();
}
