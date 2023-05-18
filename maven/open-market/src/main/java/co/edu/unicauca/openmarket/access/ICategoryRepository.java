package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Category;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public interface ICategoryRepository extends IRepository<Category> {
    boolean save(Category category);
    boolean edit(Long id, Category category);
    boolean delete(Long id);
    Category findById(Long id);
    List<Category> findByName(String name);
    List<Category> findAll();
}
