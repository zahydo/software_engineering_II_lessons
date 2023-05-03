
package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Product;
import java.util.List;

/**
 *@author Alex Torres
  */
public interface IProductRepository {
    boolean save(Product newProduct);
    
    boolean edit(Long id, Product product);
    
    boolean delete(Long id);

    Product findById(Long id);
    
    List<Product> findAll();
}
