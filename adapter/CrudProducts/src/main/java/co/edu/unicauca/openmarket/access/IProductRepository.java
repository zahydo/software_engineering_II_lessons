
package co.edu.unicauca.openmarket.access;

import co.unicauca.openmarket.client.domain.Category;
import co.unicauca.openmarket.client.domain.Product;
import java.util.List;


/**
 *
 * @author Libardo, Julio
 */
public interface IProductRepository {
    boolean save(Product newProduct);
    
    boolean edit(Long id,Product product);
    
    boolean delete(Long id);

    Product findById(Long id);
    
   List<Product> findByName(String pname);
    List<Product> findByCategory(Long categoryid);
    List<Product> findAll();
    

}
