package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Product;
import java.util.List;

/**
 *
 * @author Libardo, Julio
 */
public interface IProductRepository extends IRepository<Product> {
    boolean save(Product product);
    boolean edit(Long id, Product product);
    boolean delete(Long id);
    Product findById(Long id);
    List<Product> findByName(String name);
    List<Product> findAll();
}
