
package com.unicauca.openmarket.access.dao;

import com.unicauca.openmarket.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author brayan
 */
public interface  IProductRepository extends CrudRepository<Product,Long> {
    
}
