
package com.unicauca.openmarket.access;

import com.unicauca.openmarket.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author SANTIAGO
 */
public interface IProductRepository  extends CrudRepository<Product, Long>{
    
}
